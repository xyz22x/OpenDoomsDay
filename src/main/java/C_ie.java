final class C_ie {
   private byte[] a_arr_byte;
   private int a_int_1 = 0;
   private int b = 0;
   private int c = 0;
   private int d = 0;

   public final int a_int(int var1) {
      if (this.d < var1) {
         if (this.a_int_1 == this.b) {
            return -1;
         }

         this.c = this.c | (this.a_arr_byte[this.a_int_1++] & 255 | (this.a_arr_byte[this.a_int_1++] & 255) << 8) << this.d;
         this.d += 16;
      }

      return this.c & (1 << var1) - 1;
   }

   public final void a(int var1) {
      this.c >>>= var1;
      this.d -= var1;
   }

   public final int a_int() {
      return this.d;
   }

   public final int b_int() {
      return this.b - this.a_int_1 + (this.d >> 3);
   }

   public final void a() {
      this.c = this.c >> (this.d & 7);
      this.d &= -8;
   }

   public final boolean a_bool_2() {
      return this.a_int_1 == this.b;
   }

   public final int a_int(byte[] var1, int var2, int var3) {
      if (var3 < 0) {
         throw new IllegalArgumentException("length negative");
      } else if ((this.d & 7) != 0) {
         throw new IllegalStateException("Bit buffer is not aligned!");
      } else {
         int var4;
         for (var4 = 0; this.d > 0 && var3 > 0; var4++) {
            var1[var2++] = (byte)this.c;
            this.c >>>= 8;
            this.d -= 8;
            var3--;
         }

         if (var3 == 0) {
            return var4;
         } else {
            int var5 = this.b - this.a_int_1;
            if (var3 > var5) {
               var3 = var5;
            }

            System.arraycopy(this.a_arr_byte, this.a_int_1, var1, var2, var3);
            this.a_int_1 += var3;
            if ((this.a_int_1 - this.b & 1) != 0) {
               this.c = this.a_arr_byte[this.a_int_1++] & 255;
               this.d = 8;
            }

            return var4 + var3;
         }
      }
   }

   public C_ie() {
   }

   public final void b() {
      this.a_int_1 = this.b = this.c = this.d = 0;
   }

   public final void a(byte[] var1, int var2, int var3) {
      if (this.a_int_1 < this.b) {
         throw new IllegalStateException("Old input was not completely processed");
      } else if (var3 >= 0 && var3 <= var1.length) {
         if ((var3 & 1) != 0) {
            var2++;
            this.c = this.c | (var1[0] & 255) << this.d;
            this.d += 8;
         }

         this.a_arr_byte = var1;
         this.a_int_1 = var2;
         this.b = var3;
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }
}
