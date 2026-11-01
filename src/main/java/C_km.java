import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;

public final class C_km {
   public final File a_File;
   private int a_int_1;
   private String b_String;
   public final String a_String_2;
   private static int b_int_1;

   private C_km(File var1, int var2, String var3, String var4) {
      this.a_File = var1;
      this.a_int_1 = var2;
      this.b_String = var3;
      this.a_String_2 = var4;
   }

   private static boolean a(String var0, String var1) {
      String[] var4 = var0.split("\\.");
      String[] var6 = var1.split("\\.");
      if (var4.length >= 3 && var6.length >= 3) {
         int var2 = Integer.parseInt(var4[0]);
         int var3 = Integer.parseInt(var6[0]);
         int var5 = Integer.parseInt(var4[1]);
         int var7 = Integer.parseInt(var6[1]);
         return var2 != var3 ? false : var5 <= var7;
      } else {
         return false;
      }
   }

   private static int a(byte[] var0, byte[] var1) {
      if (var1.length == 0) {
         return -1;
      } else {
         int var2 = var0.length - var1.length;

         label27:
         for (int var3 = 0; var3 <= var2; var3++) {
            for (int var4 = 0; var4 < var1.length; var4++) {
               if (var1[var4] != var0[var3 + var4]) {
                  continue label27;
               }
            }

            return var3;
         }

         return -1;
      }
   }

   private static int a(byte[] var0) {
      try {
         int var1 = ((var0[63] & 255) << 24) + ((var0[62] & 255) << 16) + ((var0[61] & 255) << 8) + (var0[60] & 255);
         return ((var0[var1 + 5] & 0xFF) << 8) + (var0[var1 + 4] & 0xFF);
      } catch (Exception var2) {
         return 0;
      }
   }

   private static String a_String(byte[] var0) {
      String[] var1 = new String[]{"3.4.0", "5.4.0", "5.0.1", "6.1.1", "6.1.2", "6.1.4"};
      byte[][] var2 = new byte[6][];

      for (int var3 = 0; var3 < 6; var3++) {
         var2[var3] = var1[var3].getBytes();
      }

      for (int var6 = 0; var6 < 6; var6++) {
         if (a(var0, var2[var6]) >= 0) {
            return var1[var6];
         }
      }

      int var7;
      if ((var7 = a(var0, "6.1.".getBytes())) >= 0) {
         int var5 = 0;

         while (var0[var7 + var5] != 0) {
            var5++;
         }

         return new String(var0, var7, var5);
      } else if ((var7 = a(var0, "6.1".getBytes())) < 0) {
         return null;
      } else {
         int var4 = 0;

         while (var0[var7 + var4] != 0) {
            var4++;
         }

         return new String(var0, var7, var4);
      }
   }

   private static int[] a(CharSequence var0, int var1) {
      int var3 = 0;

      for (int var4 = 0; var4 < var1; var4++) {
         if (var0.charAt(var4) == '.') {
            var3++;
         }
      }

      int[] var7 = new int[var3 + 1];
      var3 = 0;
      int var5 = 0;

      for (int var2 = 0; var2 < var1; var2++) {
         if (var0.charAt(var2) == '.') {
            var7[var5] = Integer.parseInt(var0.subSequence(var3, var2).toString());
            var3 = var2 + 1;
            var5++;
         }
      }

      var7[var5] = Integer.parseInt(var0.subSequence(var3, var1).toString());
      return var7;
   }

   private static void a(File var0, ArrayList var1) {
      if (var0.exists()) {
         File[] var9;
         if ((var9 = var0.listFiles()) != null) {
            for (int var2 = 0; var2 < var9.length; var2++) {
               if (var9[var2].getName().endsWith(".dll")) {
                  try {
                     RandomAccessFile var3;
                     byte[] var4 = new byte[(int)(var3 = new RandomAccessFile(var9[var2], "r")).length()];
                     var3.readFully(var4);
                     var3.close();
                     int var10 = a(var4);
                     String var5 = a_String(var4);
                     if (var10 != 0 && var5 != null) {
                        if (b_int_1 == 0) {
                           String var7;
                           if ((var7 = System.getProperty("os.arch").toLowerCase()).equals("arm")
                              || var7.equals("arm32")
                              || var7.equals("aarch32")
                              || var7.contains("armv7")) {
                              b_int_1 = 3;
                           } else if (var7.equals("arm64") || var7.equals("aarch64")) {
                              b_int_1 = 2;
                           } else if (var7.equals("x86_64") || var7.equals("amd64") || var7.equals("ia64")) {
                              b_int_1 = 0;
                           } else if (var7.equals("x86")
                              || var7.equals("x86_32")
                              || var7.equals("i386")
                              || var7.equals("i486")
                              || var7.equals("i586")
                              || var7.equals("i686")) {
                              b_int_1 = 1;
                           } else if (var7.equals("riscv64")) {
                              b_int_1 = 4;
                           } else {
                              b_int_1 = -1;
                           }
                        }

                        String var6;
                        if ((
                              var10 == 332 && b_int_1 == 1
                                 ? true
                                 : (var10 == 34404 && b_int_1 == 0 ? true : (var10 == 43620 && b_int_1 == 2 ? true : var10 == 448 && b_int_1 == 3))
                           )
                           && (
                                 var6 = var5.equals("3.4.0")
                                    ? "3.4.0"
                                    : (
                                       !var5.startsWith("5.") || !a(var5, "5.0.1") && !a(var5, "5.4.0")
                                          ? (var5.startsWith("6.") && a(var5, "6.1.4") ? "5.12.1" : null)
                                          : "4.4.0"
                                    )
                              )
                              != null
                           && var4.length != 274432) {
                           var1.add(new C_km(var9[var2], var10, var5, var6));
                        }
                     }
                  } catch (Throwable var8) {
                     var8.printStackTrace();
                  }
               }
            }
         }
      }
   }

   public static C_km a() {
      String var0 = System.getProperty("java.io.tmpdir");
      File var1 = new File(var0, "jna");
      File var3 = new File(var0, "jna-" + System.getProperty("user.name").hashCode());
      ArrayList var2 = new ArrayList();
      a(var1, var2);
      a(var3, var2);
      Collections.sort(var2, new C_kn());
      return var2.size() > 0 ? (C_km)var2.get(0) : null;
   }

   @Override
   public final String toString() {
      return "JnaDll [file=" + this.a_File + ", arch=" + this.a_int_1 + ", nativeVersion=" + this.b_String + ", jnaVersion=" + this.a_String_2 + "]";
   }

   static int a(CharSequence var0, CharSequence var1) {
      int var10001 = var0.length();
      int var3 = var1.length();
      int[] var6 = a(var0, var10001);
      int[] var7 = a(var1, var3);
      int var2 = Math.min(var6.length, var7.length);

      for (int var8 = 0; var8 < var2; var8++) {
         int var4 = var6[var8];
         int var5 = var7[var8];
         if (var4 != var5) {
            if (var4 > var5) {
               return 1;
            }

            return -1;
         }
      }

      if (var6.length == var7.length) {
         return 0;
      } else if (var6.length > var7.length) {
         return var6[var6.length - 1] == 0 ? 0 : 1;
      } else {
         return var7[var7.length - 1] == 0 ? 0 : -1;
      }
   }
}
