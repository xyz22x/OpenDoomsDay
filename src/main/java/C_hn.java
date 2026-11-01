public final class C_hn {
   private int a_int = 0;
   private static int[] a_arr_int_1;

   static {
      int[] var0 = new int[256];

      for (int var1 = 0; var1 < 256; var1++) {
         int var2 = var1;
         int var3 = 8;

         while (--var3 >= 0) {
            if ((var2 & 1) != 0) {
               var2 = -306674912 ^ var2 >>> 1;
            } else {
               var2 >>>= 1;
            }
         }

         var0[var1] = var2;
      }

      a_arr_int_1 = var0;
   }

   public final long a_long() {
      return this.a_int & 4294967295L;
   }

   public final void a() {
      this.a_int = 0;
   }

   public final void a(byte[] var1, int var2, int var3) {
      int var4 = ~this.a_int;

      while (--var3 >= 0) {
         var4 = a_arr_int_1[(var4 ^ var1[var2++]) & 0xFF] ^ var4 >>> 8;
      }

      this.a_int = ~var4;
   }
}
