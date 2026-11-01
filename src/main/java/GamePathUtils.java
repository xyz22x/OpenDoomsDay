import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

public class GamePathUtils {
   private static String a_String;
   private static Boolean a_Boolean_1;
   private static String b;
   private static String c;
   private static String d;
   private static File a_File_2;

   public static boolean a() {
      if (a_Boolean_1 != null) {
         return a_Boolean_1;
      } else {
         try {
            Process var0 = new ProcessBuilder("csrutil", "status").start();
            if (new BufferedReader(new InputStreamReader(var0.getInputStream())).readLine().indexOf("enabled") == -1) {
               a_Boolean_1 = Boolean.TRUE;
            } else {
               a_Boolean_1 = Boolean.FALSE;
            }

            return a_Boolean_1;
         } catch (Throwable var1) {
            var1.printStackTrace();
            a_Boolean_1 = Boolean.FALSE;
            return false;
         }
      }
   }

   public static String a_String_2() {
      File var0 = new File(System.getProperty("java.home"), "bin");
      return new File(var0, "java").getAbsolutePath();
   }

   public static boolean b_bool() {
      try {
         URI var0;
         try {
            var0 = GamePathUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI();
         } catch (Throwable var1) {
            var0 = GamePathUtils.class.getClassLoader().getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
         }

         try {
            if ((PlatformUtil.j() || PlatformUtil.k()) && e().contains("smb-share:server=")) {
               return true;
            }

            if (var0.getAuthority() != null) {
               InetAddress.getByName(var0.getAuthority());
               if (var0.toString().startsWith("file://")) {
                  return true;
               }
            }
         } catch (Exception var2) {
         }
      } catch (Exception var3) {
      }

      return false;
   }

   public static String b() {
      if (a_String != null) {
         return a_String;
      } else {
         File var1;
         if (PlatformUtil.h()) {
            String var0;
            if ((var0 = System.getenv("APPDATA")) != null) {
               var1 = new File(var0, ".minecraft");
            } else {
               var1 = new File(System.getProperty("user.home"), ".minecraft");
            }
         } else if (PlatformUtil.i()) {
            var1 = new File(System.getProperty("user.home") + "/Library/Application Support", "minecraft");
         } else {
            var1 = new File(System.getProperty("user.home"), ".minecraft");
         }

         return a_String = var1.getAbsolutePath();
      }
   }

   public static String c() {
      if (b == null) {
         b = d();
      }

      return b;
   }

   public static String d() {
      if (c == null) {
         System.getProperty("os.name").toLowerCase();
         File var1;
         if (PlatformUtil.h()) {
            String var0;
            if ((var0 = System.getenv("APPDATA")) != null) {
               var1 = new File(var0, ".minecraft");
            } else {
               var1 = new File(System.getProperty("user.home"), ".minecraft");
            }
         } else if (PlatformUtil.i()) {
            var1 = new File(System.getProperty("user.home") + "/Library/Application Support", "minecraft");
         } else {
            var1 = new File(System.getProperty("user.home"), ".minecraft");
         }

         c = new File(var1.getAbsolutePath(), "doomsday").getAbsolutePath();
      }

      return c;
   }

   public static String e() {
      if (d == null) {
         try {
            URI var0;
            try {
               var0 = GamePathUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI();
            } catch (Throwable var2) {
               var0 = GamePathUtils.class.getClassLoader().getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
            }

            if (var0.getAuthority() == null) {
               try {
                  return d = new File(var0).getAbsolutePath();
               } catch (Exception var3) {
               }
            }

            try {
               InetAddress.getByName(var0.getAuthority());
               if (var0.toString().startsWith("file://")) {
                  d = var0.toString().substring(7);
                  return d = "\\\\" + d.replace('/', File.separatorChar);
               }
            } catch (Exception var1) {
               var1.printStackTrace();
            }

            if ((d = var0.toString()).startsWith("file://")) {
               d = d.substring(7);
               if (PlatformUtil.h() && d.charAt(0) == '/') {
                  d = d.substring(1);
               }

               d = d.replace('/', File.separatorChar);
            }
         } catch (Throwable var4) {
            var4.printStackTrace();
         }
      }

      return d;
   }

   public static File a_File() {
      if (a_File_2 == null) {
         try {
            try {
               a_File_2 = new File(GamePathUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            } catch (Throwable var5) {
               a_File_2 = new File(GamePathUtils.class.getClassLoader().getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
            }
         } catch (URISyntaxException var7) {
            var7.printStackTrace();
         } catch (IllegalArgumentException var8) {
            if (var8.getMessage().toLowerCase().contains("authority component")) {
               try {
                  URI var1;
                  try {
                     var1 = GamePathUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI();
                  } catch (Throwable var4) {
                     var1 = GamePathUtils.class.getClassLoader().getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
                  }

                  try {
                     InetAddress.getByName(var1.getAuthority());
                     if (var1.toString().startsWith("file://")) {
                        String var2 = var1.toString().substring(7);
                        var2 = "\\\\".concat(String.valueOf(var2));
                        return a_File_2 = new File(var2.replace('/', File.separatorChar));
                     }
                  } catch (Exception var3) {
                     var3.printStackTrace();
                  }

                  return a_File_2 = new File(var1.toString());
               } catch (URISyntaxException var6) {
                  var6.printStackTrace();
               }
            }

            var8.printStackTrace();
         } catch (Throwable var9) {
            var9.printStackTrace();
         }
      }

      return a_File_2;
   }
}
