import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.PrintStream;

public final class NativeHookLinux extends NativeHookBase {
   private static byte[] c(long var0, long var2, long var4, long var6) {
      try {
         ByteArrayOutputStream var8 = new ByteArrayOutputStream();
         DataOutputStream var9;
         (var9 = new DataOutputStream(var8)).writeInt(-217112837);
         var9.write(85);
         var9.write(184);
         var9.writeInt(Integer.reverseBytes((int)var0));
         var9.write(185);
         var9.writeInt(Integer.reverseBytes((int)var2));
         var9.write(186);
         var9.writeInt(Integer.reverseBytes((int)var4));
         var9.writeShort(35301);
         var9.write(87);
         var9.write(191);
         var9.writeInt(Integer.reverseBytes(-1));
         var9.write(86);
         var9.write(190);
         var9.writeInt(Integer.reverseBytes((int)var6));
         var9.write(83);
         var9.write(187);
         var9.writeInt(Integer.reverseBytes(0));
         var9.write(104);
         var9.writeInt(Integer.reverseBytes(0));
         var9.write(85);
         var9.writeInt(-1955847164);
         var9.writeInt(1711215888);
         var9.write(0);
         var9.write(0);
         var9.write(0);
         var9.write(93);
         var9.write(131);
         var9.write(196);
         var9.write(4);
         var9.write(91);
         var9.write(94);
         var9.write(95);
         var9.write(93);
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
         (var9 = new DataOutputStream(var8)).writeInt(-217112837);
         var9.write(85);
         var9.write(184);
         var9.writeInt(Integer.reverseBytes((int)var0));
         var9.write(185);
         var9.writeInt(Integer.reverseBytes((int)var4));
         var9.write(186);
         var9.writeInt(Integer.reverseBytes((int)var6));
         var9.writeShort(35301);
         var9.write(83);
         var9.write(187);
         var9.writeInt(Integer.reverseBytes((int)var2));
         var9.writeInt(1711215888);
         var9.write(0);
         var9.write(0);
         var9.write(0);
         var9.write(91);
         var9.write(93);
         var9.write(195);
         return var8.toByteArray();
      } catch (Exception var10) {
         throw new RuntimeException(var10);
      }
   }

   private static byte[] c(long var0, long var2, long var4) {
      try {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var6)).writeInt(-217112837);
         var7.write(184);
         var7.writeInt(Integer.reverseBytes((int)var0));
         var7.write(186);
         var7.writeInt(Integer.reverseBytes((int)var2));
         var7.write(185);
         var7.writeInt(Integer.reverseBytes((int)var4));
         var7.writeShort(34778);
         var7.writeInt(1711215888);
         var7.write(0);
         var7.write(0);
         var7.write(0);
         var7.writeShort(34778);
         var7.write(195);
         return var6.toByteArray();
      } catch (Exception var8) {
         throw new RuntimeException(var8);
      }
   }

   @Override
   public final byte[] a(long var1, long var3, long var5) {
      return d(var1, var3, var5);
   }

   private static byte[] d(long var0, long var2, long var4) {
      try {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var6)).writeInt(-217112837);
         var7.write(184);
         var7.writeInt(Integer.reverseBytes((int)var0));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes(0));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes(0));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes((int)var4));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes((int)var2));
         var7.writeShort(65488);
         var7.write(131);
         var7.write(196);
         var7.write(16);
         var7.write(195);
         return var6.toByteArray();
      } catch (Exception var8) {
         throw new RuntimeException(var8);
      }
   }

   @Override
   public final byte[] a(long var1, long var3, long var5, long var7) {
      return c(var1, var3, var5, var7);
   }

   public static void main(String[] var0) {
      byte[] var5 = d(1448436203L, 1448436203L, 0L);
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

   @Override
   public final byte[] b_arr_byte(long var1, long var3, long var5, long var7) {
      return d(var1, var3, var5, var7);
   }

   @Override
   public final byte[] b(long var1, long var3, long var5) {
      return c(var1, var3, var5);
   }
}
