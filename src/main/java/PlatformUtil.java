import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class PlatformUtil {
   private static int b;
   public static final int a;
   private static int c;

   static {
      String var0 = System.getProperty("os.name").toLowerCase();
      String var1;
      if ((var1 = System.getProperty("os.version").toLowerCase()) != null && var1.contains("android")) {
         c = 3;
      } else if (var0.contains("win")) {
         c = 0;
      } else if (var0.contains("linux")) {
         c = 1;
      } else if (!var0.contains("mac") && !var0.contains("osx") && !var0.contains("os x")) {
         c = -1;
      } else {
         c = 2;
      }

      if ((var0 = System.getProperty("os.arch").toLowerCase()).equals("arm") || var0.equals("arm32") || var0.equals("aarch32") || var0.contains("armv7")) {
         b = 3;
      } else if (var0.equals("arm64") || var0.equals("aarch64")) {
         b = 2;
      } else if (var0.equals("x86_64") || var0.equals("amd64") || var0.equals("ia64")) {
         b = 0;
      } else if (var0.equals("x86") || var0.equals("x86_32") || var0.equals("i386") || var0.equals("i486") || var0.equals("i586") || var0.equals("i686")) {
         b = 1;
      } else if (var0.equals("riscv64")) {
         b = 4;
      } else {
         b = -1;
      }

      if (h()) {
         Map var9 = System.getenv();
         var1 = null;
         String var12 = null;
         Iterator var14 = var9.entrySet().iterator();

         while (var14.hasNext()) {
            Entry var13;
            String var15 = (String)(var13 = (Entry)var14.next()).getKey();
            var0 = (String)var13.getValue();
            if (var15.length() >= 22 && var15.charAt(0) == 'P' && var15.charAt(1) == 'R') {
               if (var15.hashCode() == -124999680) {
                  var12 = var0;
               } else if (var15.hashCode() == -107455683) {
                  var1 = var0;
               }
            }
         }

         if (var1 != null) {
            if (var1.equals("ARM64")) {
               a = 2;
            } else if (!var1.equals("AMD64") && !var1.equals("EM64T")) {
               a = -1;
            } else {
               a = 0;
            }
         } else if (var12.equals("AMD64") || var12.equals("EM64T")) {
            a = 0;
         } else if (var12.equals("ARM64")) {
            a = 2;
         } else if (var12.equals("x86")) {
            a = 1;
         } else {
            a = -1;
         }
      } else {
         var0 = "";

         try {
            Process var2;
            (var2 = new ProcessBuilder("uname", "-m").start()).waitFor();
            InputStream var3 = var2.getInputStream();
            ByteArrayOutputStream var4 = new ByteArrayOutputStream();

            int var5;
            while ((var5 = var3.read()) >= 0) {
               var4.write(var5);
               if (var4.size() > 32) {
                  break;
               }
            }

            var0 = var4.toString("UTF-8").toLowerCase().trim();
         } catch (Exception var6) {
            var6.printStackTrace();
         }

         if (var0.equals("arm") || var0.equals("arm32") || var0.equals("aarch32") || var0.contains("armv7")) {
            a = 3;
         } else if (var0.equals("arm64") || var0.equals("aarch64")) {
            a = 2;
         } else if (var0.equals("x86_64") || var0.equals("amd64") || var0.equals("ia64")) {
            a = 0;
         } else if (var0.equals("x86") || var0.equals("x86_32") || var0.equals("i386") || var0.equals("i486") || var0.equals("i586") || var0.equals("i686")) {
            a = 1;
         } else if (var0.equals("riscv64")) {
            a = 4;
         } else {
            a = -1;
         }
      }
   }

   public static boolean a() {
      if (c == -1) {
         return false;
      } else {
         return b == -1 || b == 4 || b == 3 ? false : c != 2 || b != 1;
      }
   }

   public static boolean b() {
      return b == 1 || b == 3;
   }

   public static boolean c() {
      return b == 2 || b == 3;
   }

   public static boolean d() {
      return b == 2;
   }

   public static boolean e() {
      return b == 1;
   }

   public static boolean f() {
      return b == 0;
   }

   public static boolean g() {
      return b == 4;
   }

   public static boolean h() {
      return c == 0;
   }

   public static boolean i() {
      return c == 2;
   }

   public static boolean j() {
      return c == 1;
   }

   public static boolean k() {
      return c == 3;
   }

   public static boolean l() {
      return j() || k();
   }
}
