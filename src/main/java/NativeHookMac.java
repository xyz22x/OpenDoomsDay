import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;

public final class NativeHookMac extends NativeHookBase {
   private static int a = 1;
   private static int b = 2;
   private static int c = 6;
   private static int d = 7;
   private static int e = 8;
   private static int f = 9;
   private static int g = 10;

   private static void a(DataOutputStream var0, int var1, long var2) throws java.io.IOException {
      if (var1 >= e) {
         if (var2 <= 4294967295L && var2 >= 0L) {
            var0.write(73);
            var0.write(199);
            if (var1 == g) {
               var0.write(194);
            } else if (var1 == e) {
               var0.write(192);
            } else {
               if (var1 != f) {
                  throw new RuntimeException("Unknown register");
               }

               var0.write(193);
            }
         } else {
            var0.write(73);
            if (var1 == g) {
               var0.write(186);
            } else if (var1 == e) {
               var0.write(184);
            } else {
               if (var1 != f) {
                  throw new RuntimeException("Unknown register");
               }

               var0.write(185);
            }
         }
      } else if (var2 <= 4294967295L && var2 >= 0L) {
         var0.write(72);
         var0.write(199);
         if (var1 == 0) {
            var0.write(192);
         } else if (var1 == a) {
            var0.write(193);
         } else if (var1 == d) {
            var0.write(199);
         } else if (var1 == c) {
            var0.write(198);
         } else {
            if (var1 != b) {
               throw new RuntimeException("Unknown register");
            }

            var0.write(194);
         }
      } else {
         var0.write(72);
         if (var1 == 0) {
            var0.write(184);
         } else if (var1 == a) {
            var0.write(185);
         } else if (var1 == d) {
            var0.write(191);
         } else if (var1 == c) {
            var0.write(190);
         } else {
            if (var1 != b) {
               throw new RuntimeException("Unknown register");
            }

            var0.write(186);
         }
      }

      if (var2 <= 4294967295L && var2 >= 0L) {
         var0.writeInt(Integer.reverseBytes((int)var2));
      } else {
         var0.writeLong(Long.reverseBytes(var2));
      }
   }

   private static byte[] c(long var0, long var2, long var4) {
      try {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var6)).writeInt(-217112838);
         a(var7, 0, var0);
         a(var7, d, var2);
         a(var7, c, var4);
         var7.writeShort(3845);
         var7.write(195);
         return var6.toByteArray();
      } catch (Exception var8) {
         throw new RuntimeException(var8);
      }
   }

   private static byte[] c(long var0, long var2, long var4, long var6) {
      try {
         ByteArrayOutputStream var8 = new ByteArrayOutputStream();
         DataOutputStream var9;
         (var9 = new DataOutputStream(var8)).writeInt(-217112838);
         a(var9, 0, var0);
         a(var9, d, var2);
         a(var9, c, var4);
         a(var9, b, var6);
         var9.writeShort(3845);
         var9.write(195);
         return var8.toByteArray();
      } catch (Exception var10) {
         throw new RuntimeException(var10);
      }
   }

   private static byte[] d(long var0, long var2, long var4, long var6) {
      try {
         ByteArrayOutputStream var8 = new ByteArrayOutputStream();
         DataOutputStream var9;
         (var9 = new DataOutputStream(var8)).writeInt(-217112838);
         a(var9, g, var6);
         a(var9, e, -1L);
         a(var9, f, 0L);
         a(var9, 0, var0);
         a(var9, d, 0L);
         a(var9, c, var2);
         a(var9, b, var4);
         var9.writeShort(3845);
         var9.write(195);
         return var8.toByteArray();
      } catch (Exception var10) {
         throw new RuntimeException(var10);
      }
   }

   @Override
   public final byte[] b_arr_byte(long var1, long var3, long var5, long var7) {
      return c(var1, var3, var5, var7);
   }

   @Override
   public final byte[] b(long var1, long var3, long var5) {
      return c(var1, var3, var5);
   }

   @Override
   public final byte[] a(long var1, long var3, long var5) {
      return d(var1, var3, var5);
   }

   private static byte[] d(long var0, long var2, long var4) {
      try {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var6)).writeInt(-217112838);
         a(var7, 0, var0);
         a(var7, d, var2);
         a(var7, c, var4);
         a(var7, b, 0L);
         a(var7, a, 0L);
         var7.writeShort(65504);
         var7.write(195);
         return var6.toByteArray();
      } catch (Exception var8) {
         throw new RuntimeException(var8);
      }
   }

   @Override
   public final byte[] a(long var1, long var3, long var5, long var7) {
      return d(var1, var3, var5, var7);
   }

   public static void main(String[] var0) {
      byte[] var5 = c(11L, 140737353826304L, 24576L);
      PrintStream var10000 = System.out;
      byte[] var1 = var5;
      StringBuilder var2;
      (var2 = new StringBuilder()).append('"');

      for (int var3 = 0; var3 < var1.length; var3++) {
         String var4;
         if ((var4 = Integer.toHexString(var1[var3] & 255)).length() == 1) {
            var4 = "0".concat(String.valueOf(var4));
         }

         var2.append("\\x");
         var2.append(var4);
      }

      var2.append('"');
      var10000.println(var2.toString());
      System.out.println();
      System.out.println(var5.length);
   }
}
