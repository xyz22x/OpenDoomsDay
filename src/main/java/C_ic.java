final class C_ic {
   private byte[] a_arr_byte = new byte[32768];
   private int a_int_1 = 0;
   private int b = 0;

   public final void a(int var1) {
      if (this.b++ == 32768) {
         throw new IllegalStateException("Window full");
      } else {
         this.a_arr_byte[this.a_int_1++] = (byte)var1;
         this.a_int_1 &= 32767;
      }
   }

   private void b(int var1, int var2) {
      while (var2-- > 0) {
         this.a_arr_byte[this.a_int_1++] = this.a_arr_byte[var1++];
         this.a_int_1 &= 32767;
         var1 &= 32767;
      }
   }

   public final void a(int var1, int var2) {
      if ((this.b += var1) > 32768) {
         throw new IllegalStateException("Window full");
      } else {
         int var3 = this.a_int_1 - var2 & 32767;
         int var4 = 32768 - var1;
         if (var3 > var4 || this.a_int_1 >= var4) {
            this.b(var3, var1);
         } else if (var1 <= var2) {
            System.arraycopy(this.a_arr_byte, var3, this.a_arr_byte, this.a_int_1, var1);
            this.a_int_1 += var1;
         } else {
            while (var1-- > 0) {
               this.a_arr_byte[this.a_int_1++] = this.a_arr_byte[var3++];
            }
         }
      }
   }

   public final int a(C_ie var1, int var2) {
      var2 = Math.min(Math.min(var2, 32768 - this.b), var1.b_int());
      int var4 = 32768 - this.a_int_1;
      int var3;
      if (var2 > var4) {
         if ((var3 = var1.a_int(this.a_arr_byte, this.a_int_1, var4)) == var4) {
            var3 += var1.a_int(this.a_arr_byte, 0, var2 - var4);
         }
      } else {
         var3 = var1.a_int(this.a_arr_byte, this.a_int_1, var2);
      }

      this.a_int_1 = this.a_int_1 + var3 & 32767;
      this.b += var3;
      return var3;
   }

   public final int a() {
      return 32768 - this.b;
   }

   public final int b() {
      return this.b;
   }

   public final int a(byte[] var1, int var2, int var3) {
      int var4 = this.a_int_1;
      if (var3 > this.b) {
         var3 = this.b;
      } else {
         var4 = this.a_int_1 - this.b + var3 & 32767;
      }

      int var5 = var3;
      int var6;
      if ((var6 = var3 - var4) > 0) {
         System.arraycopy(this.a_arr_byte, 32768 - var6, var1, var2, var6);
         var2 += var6;
         var3 = var4;
      }

      System.arraycopy(this.a_arr_byte, var4 - var3, var1, var2, var3);
      this.b -= var5;
      if (this.b < 0) {
         throw new IllegalStateException();
      } else {
         return var5;
      }
   }

   public final void a_void() {
      this.b = this.a_int_1 = 0;
   }
}
