public final class LzmaDecompressor {
   private byte[] a_arr_byte;
   private int a_int_1;
   private int b_int = 0;
   private int c_int;
   private byte[] b_arr_byte_1;
   private int d_int;
   private int e_int;
   private int f_int;
   private byte[] c_arr_byte_1;
   private int g_int;
   private int h_int;
   private int i_int;
   private int j_int;
   private short[][] a_arr_short_2;
   private short[] a_arr_short_3 = new short[192];
   private short[] b_arr_short_2 = new short[12];
   private short[] c_arr_short_2 = new short[12];
   private short[] d_arr_short_1 = new short[12];
   private short[] e_arr_short_1 = new short[12];
   private short[] f_arr_short_1 = new short[192];
   private short[][] b_arr_short_3 = new short[4][];
   private short[] g_arr_short_1 = new short[114];
   private short[] h_arr_short_1 = new short[16];
   private short[] i_arr_short_1 = new short[2];
   private short[][] c_arr_short_3 = new short[16][];
   private short[][] d_arr_short_2 = new short[16][];
   private short[] j_arr_short_1 = new short[256];
   private int k_int = 0;
   private short[] k_arr_short_1 = new short[2];
   private short[][] e_arr_short_2 = new short[16][];
   private short[][] f_arr_short_2 = new short[16][];
   private short[] l_arr_short = new short[256];
   private int l_int_1 = 0;
   private int m = -1;
   private int n = -1;
   private int o;

   private void a_void() {
      this.b();
      this.b_arr_byte_1 = null;
   }

   private void b() {
      int var1;
      if ((var1 = this.a_int_1 - this.c_int) != 0) {
         for (int var2 = 0; var2 < var1; var2++) {
            this.b_arr_byte_1[var2 + this.d_int] = this.a_arr_byte[this.c_int + var2];
         }

         this.d_int += var1;
         if (this.a_int_1 >= this.b_int) {
            this.a_int_1 = 0;
         }

         this.c_int = this.a_int_1;
      }
   }

   private byte a_byte(int var1) {
      if ((var1 = this.a_int_1 - var1 - 1) < 0) {
         var1 += this.b_int;
      }

      return this.a_arr_byte[var1];
   }

   private int a() {
      return this.c_arr_byte_1[this.g_int++] & 0xFF;
   }

   private int a(Object var1, int var2) {
      short[] var5;
      short var3 = (var5 = (short[])var1)[var2];
      int var4 = (this.e_int >>> 11) * var3;
      if ((this.f_int ^ Integer.MIN_VALUE) < (var4 ^ Integer.MIN_VALUE)) {
         this.e_int = var4;
         var5[var2] = (short)(var3 + (2048 - var3 >>> 5));
         if ((this.e_int & 0xFF000000) == 0) {
            this.f_int = this.f_int << 8 | this.a();
            this.e_int <<= 8;
         }

         return 0;
      } else {
         this.e_int -= var4;
         this.f_int -= var4;
         var5[var2] = (short)(var3 - (var3 >>> 5));
         if ((this.e_int & 0xFF000000) == 0) {
            this.f_int = this.f_int << 8 | this.a();
            this.e_int <<= 8;
         }

         return 1;
      }
   }

   private static void a_void(short[] var0) {
      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = 1024;
      }
   }

   public LzmaDecompressor() {
      for (int var1 = 0; var1 < 4; var1++) {
         this.b_arr_short_3[var1] = new short[64];
      }
   }

   private int a(short[] var1) {
      int var2 = 31 - a(var1.length);
      int var3 = 1;

      for (int var4 = var2; var4 != 0; var4--) {
         var3 = (var3 << 1) + this.a(var1, var3);
      }

      return var3 - (1 << var2);
   }

   private static int a(int var0) {
      if (var0 == 0) {
         return 32;
      } else {
         byte var1 = 1;
         if (var0 >>> 16 == 0) {
            var1 += 16;
            var0 <<= 16;
         }

         if (var0 >>> 24 == 0) {
            var1 += 8;
            var0 <<= 8;
         }

         if (var0 >>> 28 == 0) {
            var1 += 4;
            var0 <<= 4;
         }

         if (var0 >>> 30 == 0) {
            var1 += 2;
            var0 <<= 2;
         }

         return var1 - (var0 >>> 31);
      }
   }

   private boolean a(byte[] var1, byte[] var2) {
      long var3 = var2.length;
      this.c_arr_byte_1 = var1;
      this.g_int = 13;
      this.a_void();
      this.b_arr_byte_1 = var2;
      LzmaDecompressor var12 = this;
      this.c_int = 0;
      this.a_int_1 = 0;
      a_void(this.a_arr_short_3);
      a_void(this.f_arr_short_1);
      a_void(this.b_arr_short_2);
      a_void(this.c_arr_short_2);
      a_void(this.d_arr_short_1);
      a_void(this.e_arr_short_1);
      a_void(this.g_arr_short_1);
      LzmaDecompressor var9 = this;
      int var18 = 1 << this.h_int + this.i_int;

      for (int var14 = 0; var14 < var18; var14++) {
         a_void(var9.a_arr_short_2[var14]);
      }

      for (int var26 = 0; var26 < 4; var26++) {
         a_void(var12.b_arr_short_3[var26]);
      }

      a_void(var12.i_arr_short_1);

      for (int var13 = 0; var13 < var12.k_int; var13++) {
         a_void(var12.c_arr_short_3[var13]);
         a_void(var12.d_arr_short_2[var13]);
      }

      a_void(var12.j_arr_short_1);
      a_void(var12.k_arr_short_1);

      for (int var45 = 0; var45 < var12.l_int_1; var45++) {
         a_void(var12.e_arr_short_2[var45]);
         a_void(var12.f_arr_short_2[var45]);
      }

      a_void(var12.l_arr_short);
      a_void(var12.h_arr_short_1);
      var9 = var12;
      var12.f_int = 0;
      var12.e_int = -1;

      for (int var19 = 0; var19 < 5; var19++) {
         var9.f_int = var9.f_int << 8 | var9.a();
      }

      int var17 = 0;
      int var20 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      long var10 = 0L;
      int var8 = 0;

      while (var3 < 0L || var10 < var3) {
         int var28 = (int)var10 & this.o;
         if (this.a(this.a_arr_short_3, (var17 << 4) + var28) == 0) {
            short[] var25 = this.a_arr_short_2[(((int)var10 & this.j_int) << this.h_int) + ((var8 & 0xFF) >>> 8 - this.h_int)];
            if (var17 >= 7) {
               byte var43 = this.a_byte(var20);
               int var34 = 1;

               do {
                  int var50 = var43 >> 7 & 1;
                  var43 = (byte)(var43 << 1);
                  int var53 = this.a(var25, (var50 + 1 << 8) + var34);
                  var34 = var34 << 1 | var53;
                  if (var50 != var53) {
                     while (var34 < 256) {
                        var34 = var34 << 1 | this.a(var25, var34);
                     }
                     break;
                  }
               } while (var34 < 256);

               var8 = (byte)var34;
            } else {
               int var44 = 1;

               while ((var44 = var44 << 1 | this.a(var25, var44)) < 256) {
               }

               var8 = (byte)var44;
            }

            this.a_arr_byte[this.a_int_1++] = (byte)var8;
            if (this.a_int_1 >= this.b_int) {
               this.b();
            }

            var17 = var17 < 4 ? 0 : (var17 < 10 ? var17 - 3 : var17 - 6);
            var10++;
         } else {
            if (this.a(this.b_arr_short_2, var17) == 1) {
               var8 = 0;
               if (this.a(this.c_arr_short_2, var17) == 0) {
                  if (this.a(this.f_arr_short_1, (var17 << 4) + var28) == 0) {
                     var17 = var17 < 7 ? 9 : 11;
                     var8 = 1;
                  }
               } else {
                  int var35;
                  if (this.a(this.d_arr_short_1, var17) == 0) {
                     var35 = var5;
                  } else {
                     if (this.a(this.e_arr_short_1, var17) == 0) {
                        var35 = var6;
                     } else {
                        var35 = var7;
                        var7 = var6;
                     }

                     var6 = var5;
                  }

                  var5 = var20;
                  var20 = var35;
               }

               if (var8 == 0) {
                  int var36;
                  if (this.a(this.k_arr_short_1, 0) == 0) {
                     var36 = this.a(this.e_arr_short_2[var28]);
                  } else if (this.a(this.k_arr_short_1, 1) == 0) {
                     var36 = 8 + this.a(this.f_arr_short_2[var28]);
                  } else {
                     var36 = 8 + 8 + this.a(this.l_arr_short);
                  }

                  var8 = var36 + 2;
                  var17 = var17 < 7 ? 8 : 11;
               }
            } else {
               var7 = var6;
               var6 = var5;
               var5 = var20;
               int var37;
               if (this.a(this.i_arr_short_1, 0) == 0) {
                  var37 = this.a(this.c_arr_short_3[var28]);
               } else if (this.a(this.i_arr_short_1, 1) == 0) {
                  var37 = 8 + this.a(this.d_arr_short_2[var28]);
               } else {
                  var37 = 8 + 8 + this.a(this.j_arr_short_1);
               }

               var8 = var37 + 2;
               var17 = var17 < 7 ? 7 : 10;
               int var38 = var8 - 2;
               int var29;
               if ((var29 = this.a(this.b_arr_short_3[var38 < 4 ? var38 : 3])) >= 4) {
                  int var46 = (var29 >> 1) - 1;
                  int var21 = (2 | var29 & 1) << var46;
                  if (var29 < 14) {
                     int var51 = 1;
                     int var39 = 0;

                     for (int var15 = 0; var15 < var46; var15++) {
                        int var16 = this.a(this.g_arr_short_1, var21 - var29 - 1 + var51);
                        var51 = (var51 << 1) + var16;
                        var39 |= var16 << var15;
                     }

                     var20 = var21 + var39;
                  } else {
                     int var30 = var46 - 4;
                     var12 = this;

                     for (var46 = 0; var30 != 0; var30--) {
                        var12.e_int >>>= 1;
                        int var22 = var12.f_int - var12.e_int >>> 31;
                        var12.f_int = var12.f_int - (var12.e_int & var22 - 1);
                        var46 = var46 << 1 | 1 - var22;
                        if ((var12.e_int & 0xFF000000) == 0) {
                           var12.f_int = var12.f_int << 8 | var12.a();
                           var12.e_int <<= 8;
                        }
                     }

                     int var56 = var21 + (var46 << 4);
                     short[] var31 = this.h_arr_short_1;
                     var12 = this;
                     short[] var48 = var31;
                     int var32 = 31 - a(var48.length);
                     int var23 = 1;
                     int var52 = 0;

                     for (int var54 = 0; var54 < var32; var54++) {
                        int var55 = var12.a(var48, var23);
                        var23 = (var23 << 1) + var55;
                        var52 |= var55 << var54;
                     }

                     if ((var20 = var56 + var52) < 0) {
                        if (var20 != -1) {
                           return false;
                        }
                        break;
                     }
                  }
               } else {
                  var20 = var29;
               }
            }

            if (var20 >= var10 || var20 >= this.n) {
               return false;
            }

            int var49 = var8;
            var12 = this;
            int var33;
            if ((var33 = this.a_int_1 - var20 - 1) < 0) {
               var33 += this.b_int;
            }

            for (; var49 != 0; var49--) {
               if (var33 >= var12.b_int) {
                  var33 = 0;
               }

               var12.a_arr_byte[var12.a_int_1++] = var12.a_arr_byte[var33++];
               if (var12.a_int_1 >= var12.b_int) {
                  var12.b();
               }
            }

            var10 += var8;
            var8 = this.a_byte(0);
         }
      }

      this.b();
      this.a_void();
      this.c_arr_byte_1 = null;
      return true;
   }

   private static void b(short[] var0) {
      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = 0;
      }
   }

   private static void c(short[][] var0) {
      for (int var1 = 0; var1 < var0.length; var1++) {
         if (var0[var1] != null) {
            b(var0[var1]);
         }
      }
   }

   private void c() {
      byte[] var1 = this.a_arr_byte;

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = 0;
      }

      this.a_int_1 = 0;
      this.b_int = 0;
      this.c_int = 0;
      this.b_arr_byte_1 = null;
      this.e_int = 0;
      this.f_int = 0;
      this.c_arr_byte_1 = null;
      this.h_int = 0;
      this.i_int = 0;
      this.j_int = 0;
      c(this.a_arr_short_2);
      b(this.a_arr_short_3);
      b(this.b_arr_short_2);
      b(this.b_arr_short_2);
      b(this.c_arr_short_2);
      b(this.d_arr_short_1);
      b(this.e_arr_short_1);
      b(this.f_arr_short_1);
      c(this.b_arr_short_3);
      b(this.g_arr_short_1);
      b(this.h_arr_short_1);
      b(this.i_arr_short_1);
      c(this.c_arr_short_3);
      c(this.d_arr_short_2);
      b(this.j_arr_short_1);
      this.k_int = 0;
      b(this.k_arr_short_1);
      c(this.e_arr_short_2);
      c(this.f_arr_short_2);
      b(this.l_arr_short);
      this.l_int_1 = 0;
      this.m = 0;
      this.n = 0;
      this.o = 0;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static byte[] a(byte[] var0) {
      LzmaDecompressor var1 = null;
      boolean var10 = false /* VF: Semaphore variable */;

      label204: {
         byte[] var14;
         try {
            var10 = true;
            var14 = new byte[5];

            for (int var3 = 0; var3 < 5; var3++) {
               var14[var3] = var0[var3];
            }

            LzmaDecompressor var10000 = var1 = new LzmaDecompressor();
            byte[] var15 = var14;
            LzmaDecompressor var12 = var10000;
            int var4;
            int var5 = (var4 = var14[0] & 255) % 9;
            int var18;
            int var6 = (var18 = var4 / 9) % 5;
            var4 = var18 / 5;
            int var7 = 0;

            for (int var8 = 0; var8 < 4; var8++) {
               var7 += (var15[var8 + 1] & 255) << (var8 << 3);
            }

            LzmaDecompressor var16 = var12;
            boolean var35;
            if (var5 <= 8 && var6 <= 4 && var4 <= 4) {
               LzmaDecompressor var21 = var12;
               if (var12.a_arr_short_2 == null || var12.h_int != var5 || var12.i_int != var6) {
                  var12.i_int = var6;
                  var12.j_int = (1 << var6) - 1;
                  var12.h_int = var5;
                  var5 = 1 << var12.h_int + var12.i_int;
                  var12.a_arr_short_2 = new short[var5][];

                  for (int var31 = 0; var31 < var5; var31++) {
                     var21.a_arr_short_2[var31] = new short[768];
                  }
               }

               var4 = 1 << var4;

               for (var5 = var12.k_int; var5 < var4; var5++) {
                  var16.c_arr_short_3[var5] = new short[8];
                  var16.d_arr_short_2[var5] = new short[8];
               }

               var16.k_int = var5;

               for (var5 = var16.l_int_1; var5 < var4; var5++) {
                  var16.e_arr_short_2[var5] = new short[8];
                  var16.f_arr_short_2[var5] = new short[8];
               }

               var16.l_int_1 = var5;
               var16.o = var4 - 1;
               var35 = true;
            } else {
               var35 = false;
            }

            boolean var36;
            if (!var35) {
               var36 = false;
            } else if (var7 < 0) {
               var36 = false;
            } else {
               if (var12.m != var7) {
                  var12.m = var7;
                  var12.n = Math.max(var12.m, 1);
                  var6 = Math.max(var12.n, 4096);
                  if (var12.a_arr_byte == null || var12.b_int != var6) {
                     var12.a_arr_byte = new byte[var6];
                  }

                  var12.b_int = var6;
                  var12.a_int_1 = 0;
                  var12.c_int = 0;
               }

               var36 = true;
            }

            if (!var36) {
               throw new IllegalArgumentException();
            }

            long var17 = 0L;

            for (int var13 = 0; var13 < 8; var13++) {
               var5 = var0[var13 + 5] & 255;
               var17 |= (long)var5 << (var13 << 3);
            }

            var14 = new byte[(int)var17];
            if (!var1.a(var0, var14)) {
               var10 = false;
               break label204;
            }

            var10 = false;
         } finally {
            if (var10) {
               if (var1 != null) {
                  var1.c();
               }
            }
         }

         var1.c();
         return var14;
      }

      var1.c();
      return null;
   }
}
