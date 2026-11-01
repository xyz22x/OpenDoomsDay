import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public final class WindowsProcessInfo extends ProcessInfo {
   public static int a_int;
   private static HashMap a_HashMap_1 = new HashMap();

   private WindowsProcessInfo(String var1, int var2, int var3, String var4, long var5, String var7) {
      super(var2, var3, var1, var4, var5, var7);
   }

   @Override
   public final String toString() {
      String var1 = this.b_int + "@" + this.a_String_1 + " " + this.b_String_1;
      return var1 + " " + this.a_long_2 + " KB";
   }

   public static List a() {
      return c();
   }

   private static List c() {
      ArrayList var0 = new ArrayList();
      ArrayList var1 = new ArrayList();
      AgentJarPacker.a();
      ProcessAttacher.a((List)var1);

      for (int var2 = 0; var2 < var1.size(); var2++) {
         Object[] var3 = (Object[])var1.get(var2);
         int var4 = 0;
         String var5 = "";
         int var6 = 0;
         String var7 = "";
         String var8 = "";
         String var9 = "";
         long var10 = 0L;
         int[] var12;
         if (var3[0] != null && var3[0] instanceof int[] && (var12 = (int[])var3[0]).length > 0) {
            var4 = var12[0];
         }

         if (var3[1] != null && var3[1] instanceof char[] && (var5 = new String((char[])var3[1])).equals("explorer.exe")) {
            a_int = var4;
         }

         if (var3[2] != null && var3[2] instanceof int[] && (var12 = (int[])var3[2]).length > 0) {
            var6 = var12[0];
         }

         if (var3[3] != null && var3[3] instanceof char[]) {
            var7 = new String((char[])var3[3]);
         }

         if (var3[4] != null && var3[4] instanceof char[]) {
            var8 = new String((char[])var3[4]);
         }

         long[] var17;
         if (var3[5] != null && var3[5] instanceof long[] && (var17 = (long[])var3[5]).length > 0) {
            var10 = var17[0];
         }

         char[] var18;
         if ((var18 = ProcessAttacher.b(var4)) != null) {
            var9 = new String(var18);
         }

         String var13;
         if (!var8.isEmpty() && !var7.isEmpty()) {
            var13 = var8 + "\\" + var7;
         } else {
            var13 = "";
         }

         byte var15 = 0;
         if (var6 == 34404) {
            var15 = 1;
         } else if (var6 == 448) {
            var15 = 6;
         } else if (var6 == 43620) {
            var15 = 4;
         } else if (var6 == 332) {
            var15 = 3;
         }

         WindowsProcessInfo var14 = new WindowsProcessInfo(var5, var4, var15, var13, var10, var9);
         var0.add(var14);
      }

      return var0;
   }

   private static List d() {
      ArrayList var0 = new ArrayList();

      try {
         String var1 = "f,rss,user,pid,command";
         Process var18 = new ProcessBuilder("ps", "-e", "-o", var1).start();
         Scanner var19;
         if ((var19 = new Scanner(var18.getInputStream())).hasNextLine()) {
            var19.nextLine();
         }

         while (var19.hasNextLine()) {
            String var2;
            int var3 = (var2 = var19.nextLine().trim()).indexOf(32);
            int var4 = a(var2, var3);
            int var5 = var2.indexOf(32, var4);
            int var6 = a(var2, var5);
            int var7 = var2.indexOf(32, var6);
            int var8 = a(var2, var7);
            int var9 = var2.indexOf(32, var8);
            int var10 = a(var2, var9);
            var2.substring(0, var3);
            String var21 = var2.substring(var4, var5);
            String var23 = var2.substring(var6, var7);
            String var24 = var2.substring(var8, var9);
            var2 = var2.substring(var10);
            long var11 = 0L;

            try {
               var11 = Long.parseLong(var21) << 10;
            } catch (Exception var15) {
            }

            var3 = 0;

            try {
               var3 = Integer.parseInt(var24);
            } catch (Exception var14) {
            }

            String var29 = "";
            String var25 = "";

            try {
               if ((!var2.startsWith("[") || !var2.endsWith("]")) && (!var2.startsWith("(") || !var2.endsWith(")"))) {
                  File var26;
                  (var26 = new File("/proc/" + var3 + "/exe")).lastModified();
                  File var30 = null;

                  try {
                     var30 = var26.getCanonicalFile();
                  } catch (Exception var13) {
                  }

                  var5 = 0;
                  if (var30 != null) {
                     if ((var8 = var2.indexOf(var30.getAbsolutePath())) < 0) {
                        if ((var8 = var2.indexOf(var30.getName())) >= 0) {
                           var5 = var8 + var30.getName().length();
                        }
                     } else {
                        var5 = var8 + var30.getAbsolutePath().length();
                     }
                  }

                  if (var5 == 0) {
                     if ((var8 = a(var2)) < 0) {
                        var25 = var2;
                     } else {
                        var25 = var2.substring(0, var8);
                        var29 = var2.substring(var8 + 1);
                     }
                  } else {
                     if (var5 + 1 < var2.length()) {
                        var29 = var2.substring(var5 + 1);
                     }

                     var25 = var2.substring(0, var5);
                  }
               } else {
                  var25 = var2;
               }
            } catch (Throwable var16) {
               System.out.println("Error parse proc: ".concat(String.valueOf(var2)));
               var16.printStackTrace();
               var25 = var2;
               var29 = var2;
            }

            WindowsProcessInfo var28 = new WindowsProcessInfo(var25, var3, ProcessAttacher.a(var3), var23, var11, var29);
            var0.add(var28);
         }

         var19.close();
      } catch (Exception var17) {
         var17.printStackTrace();
      }

      return var0;
   }

   private static void a_void_2() {
      a_HashMap_1.clear();

      try {
         String var0 = "pid,comm";
         Process var6 = new ProcessBuilder("ps", "-e", "-o", var0).start();
         Scanner var7;
         if ((var7 = new Scanner(var6.getInputStream())).hasNextLine()) {
            var7.nextLine();
         }

         while (var7.hasNextLine()) {
            String var1;
            int var2 = a(var1 = var7.nextLine().trim());
            int var3 = a(var1, var2);
            String var9 = var1.substring(0, var2);
            var1 = var1.substring(var3);
            Integer var10 = 0;

            try {
               var10 = Integer.parseInt(var9);
            } catch (Exception var4) {
            }

            a_HashMap_1.put(var10, var1);
         }
      } catch (Exception var5) {
      }
   }

   private static List e() {
      ArrayList var0 = new ArrayList();
      a_void_2();

      try {
         String var1 = "f,rss,user,pid,command";
         Process var16 = new ProcessBuilder("ps", "-e", "-o", var1).start();
         Scanner var17;
         if ((var17 = new Scanner(var16.getInputStream())).hasNextLine()) {
            var17.nextLine();
         }

         while (var17.hasNextLine()) {
            String var2;
            int var3 = (var2 = var17.nextLine().trim()).indexOf(32);
            int var4 = a(var2, var3);
            int var5 = var2.indexOf(32, var4);
            int var6 = a(var2, var5);
            int var7 = var2.indexOf(32, var6);
            int var8 = a(var2, var7);
            int var9 = var2.indexOf(32, var8);
            int var10 = a(var2, var9);
            var2.substring(0, var3);
            String var20 = var2.substring(var4, var5);
            String var22 = var2.substring(var6, var7);
            String var23 = var2.substring(var8, var9);
            var2 = var2.substring(var10);
            long var11 = 0L;

            try {
               var11 = Long.parseLong(var20) << 10;
            } catch (Exception var14) {
            }

            Integer var21 = 0;

            try {
               var21 = Integer.parseInt(var23);
            } catch (Exception var13) {
            }

            String var24 = (String)a_HashMap_1.get(var21);
            String var25 = "";
            if (var24 == null) {
               if ((var7 = a(var2)) < 0) {
                  var24 = var2;
               } else {
                  var24 = var2.substring(0, var7);
                  var25 = var2.substring(var7 + 1);
               }
            } else {
               if ((var7 = var2.indexOf(var24)) < 0) {
                  var7 = a(var2);
               } else {
                  var7 += var24.length();
               }

               if (var7 >= 0 && var7 + 1 < var2.length()) {
                  var25 = var2.substring(var7 + 1);
               }
            }

            var7 = 0;
            if (AgentJarPacker.a_int_1 == 0) {
               new C_dq().start();
            } else if (AgentJarPacker.a_int_1 == 2) {
               var7 = ProcessAttacher.a(var21.intValue());
            }

            WindowsProcessInfo var19 = new WindowsProcessInfo(var24, var21, var7, var22, var11, var25);
            var0.add(var19);
         }

         var17.close();
      } catch (Exception var15) {
         var15.printStackTrace();
      }

      return var0;
   }

   private static int a(String var0) {
      for (int var1 = 0; var1 < var0.length(); var1++) {
         if (Character.isWhitespace(var0.charAt(var1))) {
            return var1;
         }
      }

      return -1;
   }

   private static int a(String var0, int var1) {
      while (var1 < var0.length()) {
         if (!Character.isWhitespace(var0.charAt(var1))) {
            return var1;
         }

         var1++;
      }

      return -1;
   }

   public static List b() {
      if (PlatformUtil.h()) {
         return c();
      } else {
         return PlatformUtil.i() ? e() : d();
      }
   }
}
