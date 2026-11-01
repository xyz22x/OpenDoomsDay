import java.io.DataOutputStream;

public final class BinaryBufferWriter {
   public final long a_long;
   public final long b;
   public final String a_String_1;

   private static int a(int var0, int var1, int var2) {
      if (var1 < 0 || var1 > 65535) {
         throw new RuntimeException();
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
               throw new RuntimeException();
            }

            var2 = 6291456;
         }

         return var3 | var2 | var1 << 5 | var0;
      } else {
         throw new RuntimeException();
      }
   }

   public static void a(int var0, long var1, DataOutputStream var3) {
      try {
         if (var1 == 0L) {
            var3.writeInt(Integer.reverseBytes(a(var0, 0, 0)));
         } else {
            long var4 = var1 & 65535L;
            long var6 = var1 & 4294901760L;
            long var8 = var1 & 281470681743360L;
            long var10 = var1 & -281474976710656L;
            if (var4 != 0L || var6 == 0L || var8 == 0L || var10 == 0L) {
               var3.writeInt(Integer.reverseBytes(a(var0, (int)var4, 0)));
            }

            if (var6 != 0L) {
               var3.writeInt(Integer.reverseBytes(a(var0, (int)(var6 >>> 16), 16)));
            }

            if (var8 != 0L) {
               var3.writeInt(Integer.reverseBytes(a(var0, (int)(var8 >>> 32), 32)));
            }

            if (var10 != 0L) {
               var3.writeInt(Integer.reverseBytes(a(var0, (int)(var10 >>> 48), 48)));
            }
         }
      } catch (Exception var12) {
         throw new RuntimeException(var12);
      }
   }

   public BinaryBufferWriter(long var1, long var3, String var5) {
      this.a_long = var1;
      this.b = var3;
      this.a_String_1 = var5;
   }
}
