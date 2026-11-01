import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class CustomJarInjector {

    private static void log(String msg) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        String line = "[" + time + "] " + msg;
        System.out.println(line);
        try {
            File logFile = new File(System.getProperty("user.home"), "doomsday_inject.log");
            try (FileOutputStream fos = new FileOutputStream(logFile, true)) {
                fos.write((line + "\r\n").getBytes(StandardCharsets.UTF_8));
            }
        } catch (Throwable ignored) {}
    }

    public static File getDoomsdayJar() {
        try {
            return new File(CustomJarInjector.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        } catch (Exception e) {
            return GamePathUtils.a_File();
        }
    }

    public static boolean inject(int pid, File customJar, InjectionCallback callback) {
        if (callback != null) {
            callback.b("Attaching to target process " + pid + "...", null);
        }

        File doomsdayJar = getDoomsdayJar();
        String customJarPath = customJar.getAbsolutePath();
        String doomsdayJarPath = doomsdayJar.getAbsolutePath();

        log("Injecting custom JAR: " + customJarPath + " into PID: " + pid);
        log("Using bootstrap agent: " + doomsdayJarPath);

        Throwable attachError = null;

        // 1. Try Java Attach API (VirtualMachine.attach)
        try {
            Class<?> vmClass = null;
            try {
                vmClass = Class.forName("com.sun.tools.attach.VirtualMachine");
            } catch (ClassNotFoundException e) {
                File toolsJar = new File(System.getProperty("java.home") + "/../lib/tools.jar");
                if (toolsJar.exists()) {
                    URLClassLoader loader = new URLClassLoader(new URL[]{toolsJar.toURI().toURL()}, CustomJarInjector.class.getClassLoader());
                    vmClass = Class.forName("com.sun.tools.attach.VirtualMachine", true, loader);
                }
            }

            if (vmClass != null) {
                Method attachMethod = vmClass.getMethod("attach", String.class);
                Method loadAgentMethod = vmClass.getMethod("loadAgent", String.class, String.class);
                Method detachMethod = vmClass.getMethod("detach");

                Object vm = attachMethod.invoke(null, String.valueOf(pid));
                if (callback != null) {
                    callback.b("Loading agent into target JVM...", null);
                }
                loadAgentMethod.invoke(vm, doomsdayJarPath, customJarPath);
                detachMethod.invoke(vm);

                log("Successfully attached and loaded custom JAR via Attach API!");
                if (callback != null) {
                    callback.b("Custom JAR injected successfully!", null);
                    callback.a(0L); // 0L represents success code
                }
                return true;
            }
        } catch (InvocationTargetException e) {
            attachError = e.getCause() != null ? e.getCause() : e;
            log("Attach API InvocationTargetException: " + attachError.getMessage());
        } catch (Throwable t) {
            attachError = t;
            log("Attach API attempt failed: " + t.getMessage());
        }

        // 2. Try HotSpot native AttachListener via ProcessAttacher
        try {
            if (callback != null) {
                callback.b("Trying native attach listener...", null);
            }
            InjectionResult res = new InjectionResult();
            String options = doomsdayJarPath + "=" + customJarPath;
            int code = ProcessAttacher.a(pid, "load", "instrument", "false", options, res);
            if (code == 0 || code == 100) {
                log("Native attach succeeded with code: " + code);
                if (callback != null) {
                    callback.b("Custom JAR injected successfully!", null);
                    callback.a(0L);
                }
                return true;
            }
        } catch (Throwable t) {
            log("Native attach attempt failed: " + t.getMessage());
        }

        // Failure handling
        String errorMsg = "Attach failed";
        if (attachError != null && attachError.getMessage() != null) {
            String m = attachError.getMessage();
            if (m.toLowerCase().contains("access is denied")) {
                errorMsg = "Attach access denied. Selected process is likely Minecraft Launcher (Minecraft.exe) or protected! Please select javaw.exe (or use Mode: restart).";
            } else if (m.toLowerCase().contains("no providers")) {
                errorMsg = "Attach provider unavailable in this JRE. Please switch to Mode: restart.";
            } else {
                errorMsg = "Attach failed (" + m + "). Please select javaw.exe or switch to Mode: restart.";
            }
        } else {
            errorMsg = "Attach failed. Ensure you selected javaw.exe, or switch to Mode: restart.";
        }

        log("Final error: " + errorMsg);
        if (callback != null) {
            callback.b(errorMsg, new RuntimeException(errorMsg));
            callback.a(-1L);
        }
        return false;
    }
}
