final class C_hs {
   private static final int[] a_arr_int = new int[]{16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
   C_hv a_hv_1;
   private C_ht a_ht_2;
   private C_ht b_ht;
   private C_ht c_ht;
   private short[] a_arr_short_3;
   private byte[] a_arr_byte_4;
   private int a_int_5;
   private int b_int_1;
   private static short[] b_arr_short_2 = new short[286];
   private static byte[] b_arr_byte_3 = new byte[286];
   private static short[] c_arr_short_1;
   private static byte[] c_arr_byte_2;

   static {
      int var0;
      for (var0 = 0; var0 < 144; b_arr_byte_3[var0++] = 8) {
         b_arr_short_2[var0] = a_short_2(var0 + 48 << 8);
      }

      while (var0 < 256) {
         b_arr_short_2[var0] = a_short_2(var0 + 256 << 7);
         b_arr_byte_3[var0++] = 9;
      }

      while (var0 < 280) {
         b_arr_short_2[var0] = a_short_2(var0 + -256 << 9);
         b_arr_byte_3[var0++] = 7;
      }

      while (var0 < 286) {
         b_arr_short_2[var0] = a_short_2(var0 + -88 << 8);
         b_arr_byte_3[var0++] = 8;
      }

      c_arr_short_1 = new short[30];
      c_arr_byte_2 = new byte[30];

      for (int var1 = 0; var1 < 30; var1++) {
         c_arr_short_1[var1] = a_short_2(var1 << 11);
         c_arr_byte_2[var1] = 5;
      }
   }

   static short a_short_2(int var0) {
      return (short)(
         "\u0000\b\u0004\f\u0002\n\u0006\u000e\u0001\t\u0005\r\u0003\u000b\u0007\u000f".charAt(var0 & 15) << '\f'
            | "\u0000\b\u0004\f\u0002\n\u0006\u000e\u0001\t\u0005\r\u0003\u000b\u0007\u000f".charAt(var0 >> 4 & 15) << '\b'
            | "\u0000\b\u0004\f\u0002\n\u0006\u000e\u0001\t\u0005\r\u0003\u000b\u0007\u000f".charAt(var0 >> 8 & 15) << 4
            | "\u0000\b\u0004\f\u0002\n\u0006\u000e\u0001\t\u0005\r\u0003\u000b\u0007\u000f".charAt(var0 >> 12)
      );
   }

   public C_hs(C_hv var1) {
      this.a_hv_1 = var1;
      this.a_ht_2 = new C_ht(this, 286, 257, 15);
      this.b_ht = new C_ht(this, 30, 1, 15);
      this.c_ht = new C_ht(this, 19, 4, 7);
      this.a_arr_short_3 = new short[16384];
      this.a_arr_byte_4 = new byte[16384];
   }

   public final void a_void() {
      this.a_int_5 = 0;
      this.b_int_1 = 0;
      this.a_ht_2.a_void();
      this.b_ht.a_void();
      this.c_ht.a_void();
   }

   private static int a_int(int var0) {
      if (var0 == 255) {
         return 285;
      } else {
         short var1;
         for (var1 = 257; var0 >= 8; var0 >>= 1) {
            var1 += 4;
         }

         return var1 + var0;
      }
   }

   private static int b(int var0) {
      byte var1 = 0;

      while (var0 >= 4) {
         var1 += 2;
         var0 >>= 1;
      }

      return var1 + var0;
   }

   private void b() {
      for (int var1 = 0; var1 < this.a_int_5; var1++) {
         int var2 = this.a_arr_byte_4[var1] & 255;
         int var3;
         int var10000 = var3 = this.a_arr_short_3[var1];
         var3--;
         if (var10000 != 0) {
            int var4 = a_int(var2);
            this.a_ht_2.a(var4);
            if ((var4 = (var4 - 261) / 4) > 0 && var4 <= 5) {
               this.a_hv_1.a(var2 & (1 << var4) - 1, var4);
            }

            var2 = b(var3);
            this.b_ht.a(var2);
            if ((var4 = var2 / 2 - 1) > 0) {
               this.a_hv_1.a(var3 & (1 << var4) - 1, var4);
            }
         } else {
            this.a_ht_2.a(var2);
         }
      }

      this.a_ht_2.a(256);
   }

   public final void a(byte[] var1, int var2, int var3, boolean var4) {
      this.a_hv_1.a(0 + (var4 ? 1 : 0), 3);
      this.a_hv_1.b();
      this.a_hv_1.a(var3);
      this.a_hv_1.a(~var3);
      this.a_hv_1.a(var1, var2, var3);
      this.a_void();
   }

   public final void b(byte[] var1, int var2, int var3, boolean var4) {
      this.a_ht_2.a_arr_short[256]++;
      this.a_ht_2.c();
      this.b_ht.c();
      this.a_ht_2.a(this.c_ht);
      this.b_ht.a(this.c_ht);
      this.c_ht.c();
      int var5 = 4;

      for (int var6 = 18; var6 > var5; var6--) {
         if (this.c_ht.a_arr_byte_1[a_arr_int[var6]] > 0) {
            var5 = var6 + 1;
         }
      }

      int var12 = 14 + var5 * 3 + this.c_ht.a() + this.a_ht_2.a() + this.b_ht.a() + this.b_int_1;
      int var7 = this.b_int_1;

      for (int var8 = 0; var8 < 286; var8++) {
         var7 += this.a_ht_2.a_arr_short[var8] * b_arr_byte_3[var8];
      }

      for (int var13 = 0; var13 < 30; var13++) {
         var7 += this.b_ht.a_arr_short[var13] * c_arr_byte_2[var13];
      }

      if (var12 >= var7) {
         var12 = var7;
      }

      if (var2 >= 0 && var3 + 4 < var12 >> 3) {
         this.a(var1, var2, var3, var4);
      } else if (var12 == var7) {
         this.a_hv_1.a(2 + (var4 ? 1 : 0), 3);
         this.a_ht_2.a(b_arr_short_2, b_arr_byte_3);
         this.b_ht.a(c_arr_short_1, c_arr_byte_2);
         this.b();
         this.a_void();
      } else {
         this.a_hv_1.a(4 + (var4 ? 1 : 0), 3);
         var2 = var5;
         C_hs var9 = this;
         this.c_ht.b();
         this.a_ht_2.b();
         this.b_ht.b();
         this.a_hv_1.a(this.a_ht_2.a_int_3 - 257, 5);
         this.a_hv_1.a(this.b_ht.a_int_3 - 1, 5);
         this.a_hv_1.a(var5 - 4, 4);

         for (int var11 = 0; var11 < var2; var11++) {
            var9.a_hv_1.a(var9.c_ht.a_arr_byte_1[a_arr_int[var11]], 3);
         }

         var9.a_ht_2.b(var9.c_ht);
         var9.b_ht.b(var9.c_ht);
         this.b();
         this.a_void();
      }
   }

   public final boolean a() {
      return this.a_int_5 == 16384;
   }

   public final boolean a(int var1) {
      this.a_arr_short_3[this.a_int_5] = 0;
      this.a_arr_byte_4[this.a_int_5++] = (byte)var1;
      this.a_ht_2.a_arr_short[var1]++;
      return this.a_int_5 == 16384;
   }

   public final boolean a(int var1, int var2) {
      this.a_arr_short_3[this.a_int_5] = (short)var1;
      this.a_arr_byte_4[this.a_int_5++] = (byte)(var2 - 3);
      var2 = a_int(var2 - 3);
      this.a_ht_2.a_arr_short[var2]++;
      if (var2 >= 265 && var2 < 285) {
         this.b_int_1 += (var2 - 261) / 4;
      }

      var1 = b(var1 - 1);
      this.b_ht.a_arr_short[var1]++;
      if (var1 >= 4) {
         this.b_int_1 += var1 / 2 - 1;
      }

      return this.a_int_5 == 16384;
   }
}
