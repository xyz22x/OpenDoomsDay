import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniversalBootstrapAgent {

    private static void log(String msg) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        String line = "[" + time + "] " + msg;
        System.out.println(line);

        // Also write to log files for javaw.exe where stdout is hidden
        try {
            File[] targets = new File[] {
                new File(System.getProperty("user.home"), "doomsday_inject.log"),
                new File(System.getenv("APPDATA") != null ? System.getenv("APPDATA") + "/.minecraft/doomsday_inject.log" : "doomsday_inject.log")
            };
            for (File f : targets) {
                try (FileOutputStream fos = new FileOutputStream(f, true)) {
                    fos.write((line + "\r\n").getBytes(StandardCharsets.UTF_8));
                }
            }
        } catch (Throwable ignored) {
        }
    }

    private static void log(String msg, Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        log(msg + "\n" + sw.toString());
    }

    public static void agentmain(String args, Instrumentation inst) {
        inject(args, inst);
    }

    public static void premain(String args, Instrumentation inst) {
        inject(args, inst);
    }

    public static void inject(String args, Instrumentation inst) {
        log("UniversalBootstrapAgent started with args: " + args);
        if (args == null || args.trim().isEmpty()) {
            log("Warning: No arguments provided to bootstrap agent.");
            return;
        }

        String jarPath = args.trim();
        if (jarPath.contains("--customjar=")) {
            int idx = jarPath.indexOf("--customjar=") + 12;
            int end = jarPath.indexOf(" ", idx);
            if (end == -1) end = jarPath.length();
            jarPath = jarPath.substring(idx, end).trim();
            if (jarPath.startsWith("\"") && jarPath.endsWith("\"") && jarPath.length() >= 2) {
                jarPath = jarPath.substring(1, jarPath.length() - 1);
            }
        } else if (jarPath.contains("=")) {
            String[] parts = jarPath.split("=", 2);
            if (new File(parts[0]).exists()) {
                jarPath = parts[0];
            } else if (parts.length > 1 && new File(parts[1]).exists()) {
                jarPath = parts[1];
            }
        }

        jarPath = jarPath.replace("\\x5C", "\\").replace("\\x20", " ");
        File jarFile = new File(jarPath);
        if (!jarFile.exists()) {
            log("ERROR: Target JAR not found at: " + jarPath);
            return;
        }

        log("Target JAR found: " + jarFile.getAbsolutePath() + " (" + jarFile.length() + " bytes)");

        try {
            // 1. Add JAR to SystemClassLoader search path
            if (inst != null) {
                try {
                    inst.appendToSystemClassLoaderSearch(new JarFile(jarFile));
                    log("Appended custom JAR to SystemClassLoaderSearch.");
                } catch (Throwable t) {
                    log("appendToSystemClassLoaderSearch error: " + t.getMessage(), t);
                }
            }

            // 2. Identify target ClassLoader (KnotClassLoader for Fabric, LaunchClassLoader for Forge/LaunchWrapper, or Context)
            ClassLoader targetCl = Thread.currentThread().getContextClassLoader();
            if (targetCl == null) {
                targetCl = ClassLoader.getSystemClassLoader();
            }
            log("Current Context ClassLoader: " + targetCl.getClass().getName());

            URL jarUrl = jarFile.toURI().toURL();
            injectIntoClassLoader(targetCl, jarUrl);
            if (targetCl != ClassLoader.getSystemClassLoader()) {
                injectIntoClassLoader(ClassLoader.getSystemClassLoader(), jarUrl);
            }

            JarFile jf = new JarFile(jarFile);

            // 3. Extract and load any nested JARs (e.g. META-INF/jars/... used in Fabric mods like Glazed/Neptune)
            Enumeration<JarEntry> entries = jf.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().startsWith("META-INF/jars/") && entry.getName().endsWith(".jar")) {
                    try {
                        File tmpNested = File.createTempFile("nested-lib-", ".jar");
                        tmpNested.deleteOnExit();
                        try (InputStream is = jf.getInputStream(entry); FileOutputStream fos = new FileOutputStream(tmpNested)) {
                            byte[] buf = new byte[8192];
                            int r;
                            while ((r = is.read(buf)) != -1) {
                                fos.write(buf, 0, r);
                            }
                        }
                        if (inst != null) {
                            try {
                                inst.appendToSystemClassLoaderSearch(new JarFile(tmpNested));
                            } catch (Throwable ignored) {}
                        }
                        injectIntoClassLoader(targetCl, tmpNested.toURI().toURL());
                        log("Loaded nested jar: " + entry.getName());
                    } catch (Throwable t) {
                        log("Warning extracting nested jar " + entry.getName() + ": " + t.getMessage());
                    }
                }
            }

            // 4. Check for fabric.mod.json (Fabric mods, Meteor addons, Neptune, etc.)
            JarEntry fabricEntry = jf.getJarEntry("fabric.mod.json");
            if (fabricEntry != null) {
                log("Detected fabric.mod.json! Parsing Fabric / Meteor entrypoints...");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try (InputStream is = jf.getInputStream(fabricEntry)) {
                    byte[] buf = new byte[4096];
                    int r;
                    while ((r = is.read(buf)) != -1) {
                        baos.write(buf, 0, r);
                    }
                }
                String jsonStr = new String(baos.toByteArray(), StandardCharsets.UTF_8);
                boolean executedAny = loadFabricMod(jsonStr, targetCl, jarFile);
                if (executedAny) {
                    log("SUCCESS: Fabric / Meteor mod initialized successfully!");
                    return;
                }
            }

            // 5. Check Manifest for standard Agent-Class, Premain-Class, Main-Class
            Manifest mf = jf.getManifest();
            String agentClass = null;
            String premainClass = null;
            String mainClass = null;
            if (mf != null && mf.getMainAttributes() != null) {
                agentClass = mf.getMainAttributes().getValue("Agent-Class");
                premainClass = mf.getMainAttributes().getValue("Premain-Class");
                mainClass = mf.getMainAttributes().getValue("Main-Class");
            }

            if (agentClass != null && !agentClass.trim().isEmpty()) {
                log("Invoking Agent-Class: " + agentClass);
                Class<?> clazz = Class.forName(agentClass.trim(), true, targetCl);
                try {
                    Method m = clazz.getMethod("agentmain", String.class, Instrumentation.class);
                    m.invoke(null, jarPath, inst);
                    log("Executed " + agentClass + ".agentmain(String, Instrumentation)");
                    return;
                } catch (NoSuchMethodException e) {
                    Method m = clazz.getMethod("agentmain", String.class);
                    m.invoke(null, jarPath);
                    log("Executed " + agentClass + ".agentmain(String)");
                    return;
                }
            }

            if (premainClass != null && !premainClass.trim().isEmpty()) {
                log("Invoking Premain-Class: " + premainClass);
                Class<?> clazz = Class.forName(premainClass.trim(), true, targetCl);
                try {
                    Method m = clazz.getMethod("premain", String.class, Instrumentation.class);
                    m.invoke(null, jarPath, inst);
                    log("Executed " + premainClass + ".premain(String, Instrumentation)");
                    return;
                } catch (NoSuchMethodException e) {
                    Method m = clazz.getMethod("premain", String.class);
                    m.invoke(null, jarPath);
                    log("Executed " + premainClass + ".premain(String)");
                    return;
                }
            }

            if (mainClass != null && !mainClass.trim().isEmpty()) {
                log("Starting Main-Class: " + mainClass);
                Class<?> clazz = Class.forName(mainClass.trim(), true, targetCl);
                Method m = clazz.getMethod("main", String[].class);
                Thread thread = new Thread(() -> {
                    try {
                        m.invoke(null, (Object) new String[0]);
                    } catch (Throwable t) {
                        log("Main-Class execution error: " + t.getMessage(), t);
                    }
                }, "CustomJar-Main");
                thread.setContextClassLoader(targetCl);
                thread.start();
                log("Started " + mainClass + ".main() in thread.");
                return;
            }

            // 6. Generic scan: search classes for MeteorAddon or ModInitializer
            log("No manifest entry found. Scanning JAR classes for known entrypoints...");
            scanAndExecute(jf, targetCl);

        } catch (Throwable t) {
            log("FATAL ERROR during custom JAR injection: " + t.getMessage(), t);
        }
    }

    private static boolean loadFabricMod(String jsonStr, ClassLoader targetCl, File jarFile) {
        boolean executed = false;
        List<String> entryClasses = new ArrayList<>();

        // Regex to extract class names under "entrypoints": { ... }
        Pattern epPattern = Pattern.compile("\"(?:meteor|main|client|init)\"\\s*:\\s*\\[([^\\]]+)\\]");
        Matcher m = epPattern.matcher(jsonStr);
        while (m.find()) {
            String block = m.group(1);
            Matcher classMatcher = Pattern.compile("\"([a-zA-Z0-9_.]+\\.[a-zA-Z0-9_]+)\"").matcher(block);
            while (classMatcher.find()) {
                String cls = classMatcher.group(1);
                if (!entryClasses.contains(cls)) {
                    entryClasses.add(cls);
                }
            }
        }

        log("Found Fabric/Meteor entrypoint classes: " + entryClasses);

        for (String clsName : entryClasses) {
            try {
                log("Loading entrypoint: " + clsName);
                Class<?> clazz = Class.forName(clsName, true, targetCl);
                Object instance = clazz.getDeclaredConstructor().newInstance();

                // 1. If MeteorAddon: call onRegisterCategories() first, then onInitialize()
                try {
                    Method onRegCat = clazz.getMethod("onRegisterCategories");
                    onRegCat.invoke(instance);
                    log("Invoked " + clsName + ".onRegisterCategories()");
                } catch (NoSuchMethodException ignored) {}

                // 2. Call onInitialize() or onInitializeClient()
                try {
                    Method onInit = clazz.getMethod("onInitialize");
                    onInit.invoke(instance);
                    log("Invoked " + clsName + ".onInitialize()");
                    executed = true;
                } catch (NoSuchMethodException e) {
                    try {
                        Method onInitClient = clazz.getMethod("onInitializeClient");
                        onInitClient.invoke(instance);
                        log("Invoked " + clsName + ".onInitializeClient()");
                        executed = true;
                    } catch (NoSuchMethodException ignored) {}
                }

                // 3. For Meteor Client: Also register the addon in Addons list if Meteor is present
                try {
                    Class<?> addonsClass = Class.forName("meteordevelopment.meteorclient.addons.Addons", true, targetCl);
                    Method addMethod = null;
                    for (Method meth : addonsClass.getMethods()) {
                        if (meth.getName().equals("add") && meth.getParameterTypes().length == 1) {
                            addMethod = meth;
                            break;
                        }
                    }
                    if (addMethod != null) {
                        addMethod.invoke(null, instance);
                        log("Registered addon directly into Meteor Client Addons list!");
                    }
                } catch (Throwable ignored) {}

            } catch (Throwable t) {
                log("Error loading entrypoint " + clsName + ": " + t.getMessage(), t);
            }
        }

        return executed;
    }

    private static void scanAndExecute(JarFile jf, ClassLoader targetCl) {
        Enumeration<JarEntry> entries = jf.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            String name = entry.getName();
            if (name.endsWith(".class") && !name.contains("$") && !name.startsWith("META-INF/")) {
                String className = name.substring(0, name.length() - 6).replace('/', '.');
                try {
                    Class<?> clazz = Class.forName(className, false, targetCl);
                    // Check if class implements onInitialize or extends MeteorAddon
                    for (Method m : clazz.getMethods()) {
                        if (m.getName().equals("onInitialize") && m.getParameterTypes().length == 0) {
                            log("Auto-detected onInitialize() in " + className + "! Invoking...");
                            Object inst = clazz.getDeclaredConstructor().newInstance();
                            try {
                                Method reg = clazz.getMethod("onRegisterCategories");
                                reg.invoke(inst);
                            } catch (Throwable ignored) {}
                            m.invoke(inst);
                            log("Successfully initialized " + className);
                            return;
                        }
                    }
                } catch (Throwable ignored) {}
            }
        }
        log("Classes loaded onto classpath.");
    }

    private static void injectIntoClassLoader(ClassLoader cl, URL url) {
        if (cl == null) return;
        try {
            Class<?> cur = cl.getClass();
            while (cur != null && cur != Object.class) {
                try {
                    Method addUrl = cur.getDeclaredMethod("addURL", URL.class);
                    addUrl.setAccessible(true);
                    addUrl.invoke(cl, url);
                    log("Added URL to ClassLoader: " + cl.getClass().getName());
                    return;
                } catch (NoSuchMethodException e) {
                    cur = cur.getSuperclass();
                }
            }
        } catch (Throwable ignored) {}
    }
}
