import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public final class C_ap {
   static {
      Charset.forName("UTF-8");
   }

   public static final String a(String var0) {
      try {
         return new String(a(var0.getBytes("UTF-8")), "UTF-8");
      } catch (UnsupportedEncodingException var1) {
         throw new RuntimeException(var1);
      }
   }

   public static final byte[] a(byte[] var0) {
      byte[] var3 = new byte[(var0.length + 2) / 3 << 2];
      int var1 = 0;

      int var2;
      for (var2 = 0; var1 < var0.length - 2; var1 += 3) {
         var3[var2++] = (byte)(var0[var1] >>> 2 & 63);
         var3[var2++] = (byte)(var0[var1 + 1] >>> 4 & 15 | var0[var1] << 4 & 63);
         var3[var2++] = (byte)(var0[var1 + 2] >>> 6 & 3 | var0[var1 + 1] << 2 & 63);
         var3[var2++] = (byte)(var0[var1 + 2] & 63);
      }

      if (var1 < var0.length) {
         var3[var2++] = (byte)(var0[var1] >>> 2 & 63);
         if (var1 < var0.length - 1) {
            var3[var2++] = (byte)(var0[var1 + 1] >>> 4 & 15 | var0[var1] << 4 & 63);
            var3[var2++] = (byte)(var0[var1 + 1] << 2 & 63);
         } else {
            var3[var2++] = (byte)(var0[var1] << 4 & 63);
         }
      }

      for (var1 = 0; var1 < var2; var1++) {
         if (var3[var1] < 26) {
            var3[var1] = (byte)(var3[var1] + 65);
         } else if (var3[var1] < 52) {
            var3[var1] = (byte)(var3[var1] + 97 - 26);
         } else if (var3[var1] < 62) {
            var3[var1] = (byte)(var3[var1] + 48 - 52);
         } else if (var3[var1] < 63) {
            var3[var1] = 43;
         } else {
            var3[var1] = 47;
         }
      }

      while (var1 < var3.length) {
         var3[var1] = 61;
         var1++;
      }

      return var3;
   }
}
