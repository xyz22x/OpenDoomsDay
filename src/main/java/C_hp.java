public final class C_hp {
   private int a_int;
   private boolean a_bool_1;
   private int b;
   private long a_long_2;
   private C_hv a_hv_3 = new C_hv();
   private C_hr a_hr_4 = new C_hr(this.a_hv_3);

   public C_hp() {
      this(false);
   }

   public C_hp(boolean var1) {
      this.a_bool_1 = var1;
      this.a(6);
      this.a();
   }

   public final void a() {
      this.b = this.a_bool_1 ? 16 : 0;
      this.a_long_2 = 0L;
      this.a_hv_3.a_void();
      this.a_hr_4.a_void();
   }

   public final int a_int() {
      return (int)this.a_long_2;
   }

   @Override
   protected final void finalize() {
   }

   final void b() {
      this.b |= 4;
   }

   public final void c() {
      this.b |= 12;
   }

   public final boolean a_bool_2() {
      return this.b == 30 && this.a_hv_3.a();
   }

   public final boolean b_bool() {
      return this.a_hr_4.a_bool_2();
   }

   public final void a_void(byte[] var1, int var2, int var3) {
      if ((this.b & 8) != 0) {
         throw new IllegalStateException("finish()/end() already called");
      } else {
         this.a_hr_4.a(var1, var2, var3);
      }
   }

   public final void a(int var1) {
      if (var1 == -1) {
         var1 = 6;
      } else if (var1 < 0 || var1 > 9) {
         throw new IllegalArgumentException();
      }

      if (this.a_int != var1) {
         this.a_int = var1;
         this.a_hr_4.a_void(var1);
      }
   }

   public final int a(byte[] var1, int var2, int var3) {
      int var4 = var3;
      if (this.b == 127) {
         throw new IllegalStateException("Deflater closed");
      } else {
         if (this.b < 16) {
            int var5;
            if ((var5 = this.a_int - 1 >> 1) < 0 || var5 > 3) {
               var5 = 3;
            }

            var5 = 30720 | var5 << 6;
            if ((this.b & 1) != 0) {
               var5 |= 32;
            }

            var5 += 31 - var5 % 31;
            this.a_hv_3.b(var5);
            if ((this.b & 1) != 0) {
               var5 = this.a_hr_4.a();
               this.a_hr_4.b();
               this.a_hv_3.b(var5 >> 16);
               this.a_hv_3.b(var5 & 65535);
            }

            this.b = 16 | this.b & 12;
         }

         while (true) {
            int var9 = this.a_hv_3.a_int(var1, var2, var3);
            var2 += var9;
            this.a_long_2 += var9;
            if ((var3 -= var9) == 0 || this.b == 30) {
               return var4 - var3;
            }

            if (!this.a_hr_4.a((this.b & 4) != 0, (this.b & 8) != 0)) {
               if (this.b == 16) {
                  return var4 - var3;
               }

               if (this.b != 20) {
                  if (this.b == 28) {
                     this.a_hv_3.b();
                     if (!this.a_bool_1) {
                        var9 = this.a_hr_4.a();
                        this.a_hv_3.b(var9 >> 16);
                        this.a_hv_3.b(var9 & 65535);
                     }

                     this.b = 30;
                  }
               } else {
                  if (this.a_int != 0) {
                     for (int var10 = 8 + (-this.a_hv_3.a_int_1 & 7); var10 > 0; var10 -= 10) {
                        this.a_hv_3.a(2, 10);
                     }
                  }

                  this.b = 16;
               }
            }
         }
      }
   }
}
