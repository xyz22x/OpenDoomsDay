class C_id {
   private byte[] a_arr_byte = new byte[65536];
   private int b;
   private int c;
   private int d;
   int a_int_1;

   public C_id() {
   }

   public final void a_void() {
      this.b = this.c = this.a_int_1 = 0;
   }

   public final void a(int var1) {
      this.a_arr_byte[this.c++] = (byte)var1;
      this.a_arr_byte[this.c++] = (byte)(var1 >> 8);
   }

   public final void a(byte[] var1, int var2, int var3) {
      System.arraycopy(var1, var2, this.a_arr_byte, this.c, var3);
      this.c += var3;
   }

   public final void b() {
      if (this.a_int_1 > 0) {
         this.a_arr_byte[this.c++] = (byte)this.d;
         if (this.a_int_1 > 8) {
            this.a_arr_byte[this.c++] = (byte)(this.d >>> 8);
         }
      }

      this.d = 0;
      this.a_int_1 = 0;
   }

   public final void a(int var1, int var2) {
      this.d = this.d | var1 << this.a_int_1;
      this.a_int_1 += var2;
      if (this.a_int_1 >= 16) {
         this.a_arr_byte[this.c++] = (byte)this.d;
         this.a_arr_byte[this.c++] = (byte)(this.d >>> 8);
         this.d >>>= 16;
         this.a_int_1 -= 16;
      }
   }

   public final void b(int var1) {
      this.a_arr_byte[this.c++] = (byte)(var1 >> 8);
      this.a_arr_byte[this.c++] = (byte)var1;
   }

   public final boolean a() {
      return this.c == 0;
   }

   public final int a_int(byte[] var1, int var2, int var3) {
      if (this.a_int_1 >= 8) {
         this.a_arr_byte[this.c++] = (byte)this.d;
         this.d >>>= 8;
         this.a_int_1 -= 8;
      }

      if (var3 > this.c - this.b) {
         var3 = this.c - this.b;
         System.arraycopy(this.a_arr_byte, this.b, var1, var2, var3);
         this.b = 0;
         this.c = 0;
      } else {
         System.arraycopy(this.a_arr_byte, this.b, var1, var2, var3);
         this.b += var3;
      }

      return var3;
   }
}
