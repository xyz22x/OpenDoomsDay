final class C_hr implements C_hq {
   private int b_int;
   private short[] a_arr_short;
   private short[] b_arr_short_1;
   private int c;
   private int d;
   private boolean a_bool_1;
   private int e;
   private int f;
   private int g;
   private byte[] a_arr_byte_2;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private byte[] b_arr_byte_2;
   private long a_long_3;
   private int m;
   private int n;
   private C_hv a_hv_4;
   private C_hs a_hs_5;
   private C_hm a_hm_6;

   C_hr(C_hv var1) {
      this.a_hv_4 = var1;
      this.a_hs_5 = new C_hs(var1);
      this.a_hm_6 = new C_hm();
      this.a_arr_byte_2 = new byte[65536];
      this.a_arr_short = new short[32768];
      this.b_arr_short_1 = new short[32768];
      this.e = this.f = 1;
   }

   public final void a_void() {
      this.a_hs_5.a_void();
      this.a_hm_6.a();
      this.e = this.f = 1;
      this.g = 0;
      this.a_long_3 = 0L;
      this.a_bool_1 = false;
      this.d = 2;

      for (int var1 = 0; var1 < 32768; var1++) {
         this.a_arr_short[var1] = 0;
      }

      for (int var2 = 0; var2 < 32768; var2++) {
         this.b_arr_short_1[var2] = 0;
      }
   }

   public final void b() {
      this.a_hm_6.a();
   }

   public final int a() {
      return (int)this.a_hm_6.a_long();
   }

   public final void a_void(int var1) {
      this.k = C_hq.a_arr_int_1[var1];
      this.i = C_hq.b[var1];
      this.j = C_hq.c[var1];
      this.h = C_hq.d[var1];
      if (C_hq.e[var1] != this.l) {
         switch (this.l) {
            case 0:
               if (this.f > this.e) {
                  this.a_hs_5.a(this.a_arr_byte_2, this.e, this.f - this.e, false);
                  this.e = this.f;
               }

               this.c();
               break;
            case 1:
               if (this.f > this.e) {
                  this.a_hs_5.b(this.a_arr_byte_2, this.e, this.f - this.e, false);
                  this.e = this.f;
               }
               break;
            case 2:
               if (this.a_bool_1) {
                  this.a_hs_5.a(this.a_arr_byte_2[this.f - 1] & 255);
               }

               if (this.f > this.e) {
                  this.a_hs_5.b(this.a_arr_byte_2, this.e, this.f - this.e, false);
                  this.e = this.f;
               }

               this.a_bool_1 = false;
               this.d = 2;
         }

         this.l = C_hq.e[var1];
      }
   }

   private void c() {
      this.b_int = this.a_arr_byte_2[this.f] << 5 ^ this.a_arr_byte_2[this.f + 1];
   }

   private int b_int() {
      int var2 = (this.b_int << 5 ^ this.a_arr_byte_2[this.f + 2]) & 32767;
      short var1;
      this.b_arr_short_1[this.f & 32767] = var1 = this.a_arr_short[var2];
      this.a_arr_short[var2] = (short)this.f;
      this.b_int = var2;
      return var1 & 65535;
   }

   private void d() {
      System.arraycopy(this.a_arr_byte_2, 32768, this.a_arr_byte_2, 0, 32768);
      this.c -= 32768;
      this.f -= 32768;
      this.e -= 32768;

      for (int var1 = 0; var1 < 32768; var1++) {
         int var2 = this.a_arr_short[var1] & '\uffff';
         this.a_arr_short[var1] = var2 >= 32768 ? (short)(var2 - 32768) : 0;
      }

      for (int var3 = 0; var3 < 32768; var3++) {
         int var4 = this.b_arr_short_1[var3] & '\uffff';
         this.b_arr_short_1[var3] = var4 >= 32768 ? (short)(var4 - 32768) : 0;
      }
   }

   private boolean a(int var1) {
      int var2 = this.h;
      int var3 = this.j;
      short[] var4 = this.b_arr_short_1;
      int var5 = this.f;
      int var7 = this.f + this.d;
      int var8 = Math.max(this.d, 2);
      int var9 = Math.max(this.f - 32506, 0);
      int var10 = var5 + 258 - 1;
      byte var11 = this.a_arr_byte_2[var7 - 1];
      byte var12 = this.a_arr_byte_2[var7];
      if (var8 >= this.k) {
         var2 >>= 2;
      }

      if (var3 > this.g) {
         var3 = this.g;
      }

      do {
         if (this.a_arr_byte_2[var1 + var8] == var12
            && this.a_arr_byte_2[var1 + var8 - 1] == var11
            && this.a_arr_byte_2[var1] == this.a_arr_byte_2[var5]
            && this.a_arr_byte_2[var1 + 1] == this.a_arr_byte_2[var5 + 1]) {
            int var6 = var1 + 2;
            var5 += 2;

            while (
               this.a_arr_byte_2[++var5] == this.a_arr_byte_2[++var6]
                  && this.a_arr_byte_2[++var5] == this.a_arr_byte_2[++var6]
                  && this.a_arr_byte_2[++var5] == this.a_arr_byte_2[++var6]
                  && this.a_arr_byte_2[++var5] == this.a_arr_byte_2[++var6]
                  && this.a_arr_byte_2[++var5] == this.a_arr_byte_2[++var6]
                  && this.a_arr_byte_2[++var5] == this.a_arr_byte_2[++var6]
                  && this.a_arr_byte_2[++var5] == this.a_arr_byte_2[++var6]
                  && this.a_arr_byte_2[++var5] == this.a_arr_byte_2[++var6]
                  && var5 < var10
            ) {
            }

            if (var5 > var7) {
               this.c = var1;
               var7 = var5;
               if ((var8 = var5 - this.f) >= var3) {
                  break;
               }

               var11 = this.a_arr_byte_2[var5 - 1];
               var12 = this.a_arr_byte_2[var5];
            }

            var5 = this.f;
         }
      } while ((var1 = var4[var1 & 32767] & '\uffff') > var9 && --var2 != 0);

      this.d = Math.min(var8, this.g);
      return this.d >= 3;
   }

   public final boolean a(boolean var1, boolean var2) {
      boolean var11;
      do {
         C_hr var3 = this;
         if (this.f >= 65274) {
            this.d();
         }

         while (var3.g < 262 && var3.m < var3.n) {
            int var4;
            if ((var4 = 65536 - var3.g - var3.f) > var3.n - var3.m) {
               var4 = var3.n - var3.m;
            }

            System.arraycopy(var3.b_arr_byte_2, var3.m, var3.a_arr_byte_2, var3.f + var3.g, var4);
            var3.a_hm_6.a(var3.b_arr_byte_2, var3.m, var4);
            var3.m += var4;
            var3.a_long_3 += var4;
            var3.g += var4;
         }

         if (var3.g >= 3) {
            var3.c();
         }

         var11 = var1 && this.m == this.n;
         switch (this.l) {
            case 0:
               boolean var24;
               if (!var11 && this.g == 0) {
                  var24 = false;
               } else {
                  this.f = this.f + this.g;
                  this.g = 0;
                  int var17;
                  if ((var17 = this.f - this.e) < C_hq.a_int && (this.e >= 32768 || var17 < 32506) && !var11) {
                     var24 = true;
                  } else {
                     boolean var21 = var2;
                     if (var17 > C_hq.a_int) {
                        var17 = C_hq.a_int;
                        var21 = false;
                     }

                     this.a_hs_5.a(this.a_arr_byte_2, this.e, var17, var21);
                     this.e += var17;
                     var24 = !var21;
                  }
               }

               var11 = var24;
               break;
            case 1:
               boolean var15 = var11;
               C_hr var12 = this;
               boolean var23;
               if (this.g < 262 && !var11) {
                  var23 = false;
               } else {
                  while (true) {
                     if (var12.g < 262 && !var15) {
                        var23 = true;
                        break;
                     }

                     if (var12.g == 0) {
                        var12.a_hs_5.b(var12.a_arr_byte_2, var12.e, var12.f - var12.e, var2);
                        var12.e = var12.f;
                        var23 = false;
                        break;
                     }

                     if (var12.f > 65274) {
                        var12.d();
                     }

                     int var16;
                     if (var12.g >= 3 && (var16 = var12.b_int()) != 0 && var12.f - var16 <= 32506 && var12.a(var16)) {
                        boolean var19 = var12.a_hs_5.a(var12.f - var12.c, var12.d);
                        var12.g = var12.g - var12.d;
                        if (var12.d <= var12.i && var12.g >= 3) {
                           while (--var12.d > 0) {
                              var12.f++;
                              var12.b_int();
                           }

                           var12.f++;
                        } else {
                           var12.f = var12.f + var12.d;
                           if (var12.g >= 2) {
                              var12.c();
                           }
                        }

                        var12.d = 2;
                        if (!var19) {
                           continue;
                        }
                     } else {
                        var12.a_hs_5.a(var12.a_arr_byte_2[var12.f] & 255);
                        var12.f++;
                        var12.g--;
                     }

                     if (var12.a_hs_5.a()) {
                        boolean var20 = var2 && var12.g == 0;
                        var12.a_hs_5.b(var12.a_arr_byte_2, var12.e, var12.f - var12.e, var20);
                        var12.e = var12.f;
                        var23 = !var20;
                        break;
                     }
                  }
               }

               var11 = var23;
               break;
            case 2:
               boolean var13 = var11;
               C_hr var10 = this;
               boolean var10000;
               if (this.g < 262 && !var11) {
                  var10000 = false;
               } else {
                  while (true) {
                     if (var10.g < 262 && !var13) {
                        var10000 = true;
                        break;
                     }

                     if (var10.g == 0) {
                        if (var10.a_bool_1) {
                           var10.a_hs_5.a(var10.a_arr_byte_2[var10.f - 1] & 255);
                        }

                        var10.a_bool_1 = false;
                        var10.a_hs_5.b(var10.a_arr_byte_2, var10.e, var10.f - var10.e, var2);
                        var10.e = var10.f;
                        var10000 = false;
                        break;
                     }

                     if (var10.f >= 65274) {
                        var10.d();
                     }

                     int var6 = var10.c;
                     int var7 = var10.d;
                     int var8;
                     if (var10.g >= 3
                        && (var8 = var10.b_int()) != 0
                        && var10.f - var8 <= 32506
                        && var10.a(var8)
                        && var10.d <= 5
                        && var10.d == 3
                        && var10.f - var10.c > 4096) {
                        var10.d = 2;
                     }

                     if (var7 >= 3 && var10.d <= var7) {
                        var10.a_hs_5.a(var10.f - 1 - var6, var7);
                        var7 -= 2;

                        do {
                           var10.f++;
                           var10.g--;
                           if (var10.g >= 3) {
                              var10.b_int();
                           }
                        } while (--var7 > 0);

                        var10.f++;
                        var10.g--;
                        var10.a_bool_1 = false;
                        var10.d = 2;
                     } else {
                        if (var10.a_bool_1) {
                           var10.a_hs_5.a(var10.a_arr_byte_2[var10.f - 1] & 255);
                        }

                        var10.a_bool_1 = true;
                        var10.f++;
                        var10.g--;
                     }

                     if (var10.a_hs_5.a()) {
                        var8 = var10.f - var10.e;
                        if (var10.a_bool_1) {
                           var8--;
                        }

                        var13 = var2 && var10.g == 0 && !var10.a_bool_1;
                        var10.a_hs_5.b(var10.a_arr_byte_2, var10.e, var8, var13);
                        var10.e += var8;
                        var10000 = !var13;
                        break;
                     }
                  }
               }

               var11 = var10000;
               break;
            default:
               throw new Error();
         }
      } while (this.a_hv_4.a() && var11);

      return var11;
   }

   public final void a(byte[] var1, int var2, int var3) {
      if (this.m < this.n) {
         throw new IllegalStateException("Old input was not completely processed");
      } else {
         var3 = var2 + var3;
         if (var2 >= 0 && var2 <= var3 && var3 <= var1.length) {
            this.b_arr_byte_2 = var1;
            this.m = var2;
            this.n = var3;
         } else {
            throw new ArrayIndexOutOfBoundsException();
         }
      }
   }

   public final boolean a_bool_2() {
      return this.n == this.m;
   }
}
