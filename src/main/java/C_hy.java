public final class C_hy {
   private static final int[] a_arr_int = new int[]{
      3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, 131, 163, 195, 227, 258
   };
   private static final int[] b_arr_int = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0};
   private static final int[] c_arr_int = new int[]{
      1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, 129, 193, 257, 385, 513, 769, 1025, 1537, 2049, 3073, 4097, 6145, 8193, 12289, 16385, 24577
   };
   private static final int[] d_arr_int = new int[]{0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13};
   private int a_int_1;
   private int b_int_1;
   private int c_int_1;
   private int d_int_1;
   private int e;
   private int f;
   private boolean a_bool_2;
   private long a_long_3;
   private long b_long_2;
   private boolean b_bool_3;
   private C_ie a_ie_4;
   private C_ic a_ic_5;
   private C_hz a_hz_6;
   private C_ia a_ia_7;
   private C_ia b_ia_4;
   private C_hm a_hm_8;

   public C_hy() {
      this(false);
   }

   public C_hy(boolean var1) {
      this.b_bool_3 = var1;
      this.a_hm_8 = new C_hm();
      this.a_ie_4 = new C_ie();
      this.a_ic_5 = new C_ic();
      this.a_int_1 = var1 ? 2 : 0;
   }

   @Override
   protected final void finalize() {
   }

   public final boolean a() {
      return this.a_int_1 == 12 && this.a_ic_5.b() == 0;
   }

   public final int a_int() {
      return this.a_ie_4.b_int();
   }

   public final int b_int() {
      return (int)(this.b_long_2 - this.a_ie_4.b_int());
   }

   public final int c() {
      return (int)this.a_long_3;
   }

   public final int a(byte[] var1, int var2, int var3) throws C_ho {
      if (var3 == 0) {
         return 0;
      } else if (var2 >= 0 && var2 <= var2 + var3 && var2 + var3 <= var1.length) {
         int var4 = 0;

         boolean var10000;
         do {
            if (this.a_int_1 != 11) {
               int var5 = this.a_ic_5.a(var1, var2, var3);
               this.a_hm_8.a(var1, var2, var5);
               var2 += var5;
               var4 += var5;
               this.a_long_3 += var5;
               if ((var3 -= var5) == 0) {
                  return var4;
               }
            }

            switch (this.a_int_1) {
               case 0:
                  int var9;
                  if ((var9 = this.a_ie_4.a_int(16)) < 0) {
                     var10000 = false;
                  } else {
                     this.a_ie_4.a(16);
                     if ((var9 = (var9 << 8 | var9 >> 8) & 65535) % 31 != 0) {
                        throw new C_ho("Header checksum illegal");
                     }

                     if ((var9 & 3840) != 2048) {
                        throw new C_ho("Compression Method unknown");
                     }

                     if ((var9 & 32) == 0) {
                        this.a_int_1 = 2;
                     } else {
                        this.a_int_1 = 1;
                        this.c_int_1 = 32;
                     }

                     var10000 = true;
                  }
                  break;
               case 1:
                  var10000 = this.d();
                  break;
               case 2:
                  if (this.a_bool_2) {
                     if (this.b_bool_3) {
                        this.a_int_1 = 12;
                        var10000 = false;
                     } else {
                        this.a_ie_4.a();
                        this.c_int_1 = 32;
                        this.a_int_1 = 11;
                        var10000 = true;
                     }
                  } else {
                     int var8;
                     if ((var8 = this.a_ie_4.a_int(3)) < 0) {
                        var10000 = false;
                     } else {
                        this.a_ie_4.a(3);
                        if ((var8 & 1) != 0) {
                           this.a_bool_2 = true;
                        }

                        switch (var8 >> 1) {
                           case 0:
                              this.a_ie_4.a();
                              this.a_int_1 = 3;
                              break;
                           case 1:
                              this.a_ia_7 = C_ia.a_ia_1;
                              this.b_ia_4 = C_ia.b;
                              this.a_int_1 = 7;
                              break;
                           case 2:
                              this.a_hz_6 = new C_hz();
                              this.a_int_1 = 6;
                              break;
                           default:
                              throw new C_ho("Unknown block type ".concat(String.valueOf(var8)));
                        }

                        var10000 = true;
                     }
                  }
                  break;
               case 3:
                  if ((this.f = this.a_ie_4.a_int(16)) < 0) {
                     var10000 = false;
                     break;
                  } else {
                     this.a_ie_4.a(16);
                     this.a_int_1 = 4;
                  }
               case 4:
                  int var6;
                  if ((var6 = this.a_ie_4.a_int(16)) < 0) {
                     var10000 = false;
                     break;
                  } else {
                     this.a_ie_4.a(16);
                     if (var6 != (this.f ^ 65535)) {
                        throw new C_ho("broken uncompressed block");
                     }

                     this.a_int_1 = 5;
                  }
               case 5:
                  int var7 = this.a_ic_5.a(this.a_ie_4, this.f);
                  this.f -= var7;
                  if (this.f == 0) {
                     this.a_int_1 = 2;
                     var10000 = true;
                  } else {
                     var10000 = !this.a_ie_4.a_bool_2();
                  }
                  break;
               case 6:
                  if (!this.a_hz_6.a(this.a_ie_4)) {
                     var10000 = false;
                     break;
                  } else {
                     this.a_ia_7 = this.a_hz_6.a();
                     this.b_ia_4 = this.a_hz_6.b();
                     this.a_int_1 = 7;
                  }
               case 7:
               case 8:
               case 9:
               case 10:
                  var10000 = this.e();
                  break;
               case 11:
                  var10000 = this.f();
                  break;
               case 12:
                  var10000 = false;
                  break;
               default:
                  throw new IllegalStateException();
            }
         } while (var10000 || this.a_ic_5.b() > 0 && this.a_int_1 != 11);

         return var4;
      } else {
         throw new ArrayIndexOutOfBoundsException();
      }
   }

   public final boolean b() {
      return this.a_int_1 == 1 && this.c_int_1 == 0;
   }

   public final boolean c_bool() {
      return this.a_ie_4.a_bool_2();
   }

   public final void a_void_2() {
      this.a_int_1 = this.b_bool_3 ? 2 : 0;
      this.b_long_2 = this.a_long_3 = 0L;
      this.a_ie_4.b();
      this.a_ic_5.a_void();
      this.a_hz_6 = null;
      this.a_ia_7 = null;
      this.b_ia_4 = null;
      this.a_bool_2 = false;
      this.a_hm_8.a();
   }

   public final void a(byte[] var1, int var2) {
      this.a_ie_4.a(var1, 0, var2);
      this.b_long_2 += var2;
   }

   private boolean d() {
      while (this.c_int_1 > 0) {
         int var1;
         if ((var1 = this.a_ie_4.a_int(8)) < 0) {
            return false;
         }

         this.a_ie_4.a(8);
         this.b_int_1 = this.b_int_1 << 8 | var1;
         this.c_int_1 -= 8;
      }

      return false;
   }

   private boolean e() throws C_ho {
      for (int var1 = this.a_ic_5.a(); var1 >= 258; this.a_int_1 = 7) {
         label80: {
            label86: {
               switch (this.a_int_1) {
                  case 7:
                     int var2;
                     while (((var2 = this.a_ia_7.a(this.a_ie_4)) & -256) == 0) {
                        this.a_ic_5.a(var2);
                        if (--var1 < 258) {
                           return true;
                        }
                     }

                     if (var2 < 257) {
                        if (var2 < 0) {
                           return false;
                        }

                        this.b_ia_4 = null;
                        this.a_ia_7 = null;
                        this.a_int_1 = 2;
                        return true;
                     }

                     try {
                        this.d_int_1 = a_arr_int[var2 - 257];
                        this.c_int_1 = b_arr_int[var2 - 257];
                     } catch (ArrayIndexOutOfBoundsException var4) {
                        throw new C_ho("Illegal rep length code");
                     }
                  case 8:
                     break;
                  case 9:
                     break label86;
                  case 10:
                     break label80;
                  default:
                     throw new IllegalStateException();
               }

               if (this.c_int_1 > 0) {
                  this.a_int_1 = 8;
                  int var5;
                  if ((var5 = this.a_ie_4.a_int(this.c_int_1)) < 0) {
                     return false;
                  }

                  this.a_ie_4.a(this.c_int_1);
                  this.d_int_1 += var5;
               }

               this.a_int_1 = 9;
            }

            int var6;
            if ((var6 = this.b_ia_4.a(this.a_ie_4)) < 0) {
               return false;
            }

            try {
               this.e = c_arr_int[var6];
               this.c_int_1 = d_arr_int[var6];
            } catch (ArrayIndexOutOfBoundsException var3) {
               throw new C_ho("Illegal rep dist code");
            }
         }

         if (this.c_int_1 > 0) {
            this.a_int_1 = 10;
            int var7;
            if ((var7 = this.a_ie_4.a_int(this.c_int_1)) < 0) {
               return false;
            }

            this.a_ie_4.a(this.c_int_1);
            this.e += var7;
         }

         this.a_ic_5.a(this.d_int_1, this.e);
         var1 -= this.d_int_1;
      }

      return true;
   }

   private boolean f() throws C_ho {
      while (this.c_int_1 > 0) {
         int var1;
         if ((var1 = this.a_ie_4.a_int(8)) < 0) {
            return false;
         }

         this.a_ie_4.a(8);
         this.b_int_1 = this.b_int_1 << 8 | var1;
         this.c_int_1 -= 8;
      }

      if ((int)this.a_hm_8.a_long() != this.b_int_1) {
         throw new C_ho("Adler chksum doesn't match: " + Integer.toHexString((int)this.a_hm_8.a_long()) + " vs. " + Integer.toHexString(this.b_int_1));
      } else {
         this.a_int_1 = 12;
         return false;
      }
   }
}
