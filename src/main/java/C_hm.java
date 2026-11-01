public final class C_hm {
   private int a = 1;

   public final void a() {
      this.a = 1;
   }

   public final void a(byte[] var1, int var2, int var3) {
      int var4 = this.a & 65535;

      int var5;
      for (var5 = this.a >>> 16; var3 > 0; var5 %= 65521) {
         int var6 = 3800;
         if (3800 > var3) {
            var6 = var3;
         }

         for (var3 -= var6; --var6 >= 0; var5 += var4) {
            var4 += var1[var2++] & 255;
         }

         var4 %= 65521;
      }

      this.a = var5 << 16 | var4;
   }

   public final long a_long() {
      return this.a & 4294967295L;
   }
}
