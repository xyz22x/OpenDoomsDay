import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;

public final class NativeHookWindows extends NativeHookBase {
   private static int a = 1;
   private static int b = 2;
   private static int c = 3;
   private static int d = 4;
   private static int e = 5;
   private static int f = 8;

   private static int a(int var0, int var1, int var2) {
      if (var1 < 0 || var1 > 65535) {
         System.out.println(var1);
         throw new RuntimeException("Invalid value");
      } else if (var0 >= 0 && var0 <= 31) {
         int var3 = var2 == 0 ? -763363328 : -226492416;
         if (var2 == 0) {
            var2 = 0;
         } else if (var2 == 16) {
            var2 = 2097152;
         } else if (var2 == 32) {
            var2 = 4194304;
         } else {
            if (var2 != 48) {
               throw new RuntimeException("Invalid shift");
            }

            var2 = 6291456;
         }

         return var3 | var2 | var1 << 5 | var0;
      } else {
         throw new RuntimeException("Invalid register");
      }
   }

   private static void a(int var0, long var1, ArrayList var3) {
      if (var1 == 0L) {
         var3.add(a(var0, 0, 0));
      } else {
         long var4 = var1 & 65535L;
         long var6 = var1 & 4294901760L;
         long var8 = var1 & 281470681743360L;
         long var10 = var1 & -281474976710656L;
         if (var4 != 0L || var6 == 0L || var8 == 0L || var10 == 0L) {
            var3.add(a(var0, (int)var4, 0));
         }

         if (var6 != 0L) {
            var3.add(a(var0, (int)(var6 >>> 16), 16));
         }

         if (var8 != 0L) {
            var3.add(a(var0, (int)(var8 >>> 32), 32));
         }

         if (var10 != 0L) {
            var3.add(a(var0, (int)(var10 >>> 48), 48));
         }
      }
   }

   @Override
   public final byte[] a(long var1, long var3, long var5) {
      ArrayList var13 = new ArrayList();
      a(6, var1, var13);
      a(0, var3, var13);
      a(1, var5, var13);
      a(2, 0L, var13);
      a(3, 0L, var13);
      var13.add(-700514112);
      var13.add(-698416192);
      return a(var13);
   }

   @Override
   public final byte[] a(long var1, long var3, long var5, long var7) {
      ArrayList var17 = new ArrayList();
      a(0, 0L, var17);
      a(a, var3, var17);
      a(b, var5, var17);
      a(c, var7, var17);
      a(d, -1L, var17);
      a(e, 0L, var17);
      a(f, var1, var17);
      var17.add(-738197503);
      var17.add(-698416192);
      return a(var17);
   }

   @Override
   public final byte[] b_arr_byte(long var1, long var3, long var5, long var7) {
      ArrayList var17 = new ArrayList();
      a(0, var3, var17);
      a(a, var5, var17);
      a(b, var7, var17);
      a(f, var1, var17);
      var17.add(-738197503);
      var17.add(-698416192);
      return a(var17);
   }

   @Override
   public final byte[] b(long var1, long var3, long var5) {
      ArrayList var13 = new ArrayList();
      a(0, var3, var13);
      a(a, var5, var13);
      a(f, var1, var13);
      var13.add(-738197503);
      var13.add(-698416192);
      return a(var13);
   }

   private static byte[] a(ArrayList var0) {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      DataOutputStream var2 = new DataOutputStream(var1);

      try {
         for (Object var5_raw : var0) { Integer var5 = (Integer)var5_raw;
            var2.writeInt(Integer.reverseBytes(var5));
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var1.toByteArray();
   }

   private static String a(byte[] var0) {
      StringBuilder var1;
      (var1 = new StringBuilder()).append('"');

      for (int var2 = 0; var2 < var0.length; var2++) {
         String var3;
         if ((var3 = Integer.toHexString(var0[var2] & 255)).length() == 1) {
            var3 = "0".concat(String.valueOf(var3));
         }

         var1.append("\\x");
         var1.append(var3);
         if ((var2 + 1) % 4 == 0) {
            var1.append("\"\n\"");
         }
      }

      return var1.substring(0, var1.length() - 1);
   }

   public static void main(String[] var0) {
      ArrayList var1 = new ArrayList();
      a(16, 365072222328L, var1);
      var1.add(-702610944);
      byte[] var2 = a(var1);
      System.out.println(a(var2));
      System.out.println();
      System.out.println(var2.length);
   }
}
