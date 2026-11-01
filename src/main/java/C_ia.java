final class C_ia {
   private short[] a_arr_short;
   static C_ia a_ia_1;
   static C_ia b;

   static {
      try {
         byte[] var0 = new byte[288];
         int var1 = 0;

         while (var1 < 144) {
            var0[var1++] = 8;
         }

         while (var1 < 256) {
            var0[var1++] = 9;
         }

         while (var1 < 280) {
            var0[var1++] = 7;
         }

         while (var1 < 288) {
            var0[var1++] = 8;
         }

         a_ia_1 = new C_ia(var0);
         var0 = new byte[32];
         var1 = 0;

         while (var1 < 32) {
            var0[var1++] = 5;
         }

         b = new C_ia(var0);
      } catch (C_ho var2) {
         throw new Error("InflaterHuffmanTree: static tree length illegal");
      }
   }

   C_ia(byte[] var1) throws C_ho {
      this.a(var1);
   }

   private void a(byte[] var1) throws C_ho {
      int[] var2 = new int[16];
      int[] var3 = new int[16];

      for (int var4 = 0; var4 < var1.length; var4++) {
         byte var5;
         if ((var5 = var1[var4]) > 0) {
            var2[var5]++;
         }
      }

      int var11 = 0;
      int var13 = 512;

      for (int var6 = 1; var6 <= 15; var6++) {
         var3[var6] = var11;
         var11 += var2[var6] << 16 - var6;
         if (var6 >= 10) {
            int var7 = var3[var6] & 130944;
            int var8 = var11 & 130944;
            var13 += var8 - var7 >> 16 - var6;
         }
      }

      if (var11 != 65536) {
         throw new C_ho("Code lengths don't add up properly.");
      } else {
         this.a_arr_short = new short[var13];
         int var15 = 512;

         for (int var16 = 15; var16 >= 10; var16--) {
            int var18 = var11 & 130944;

            for (int var9 = (var11 -= var2[var16] << 16 - var16) & 130944; var9 < var18; var9 += 128) {
               this.a_arr_short[C_hs.a_short_2(var9)] = (short)(-var15 << 4 | var16);
               var15 += 1 << var16 - 9;
            }
         }

         for (int var17 = 0; var17 < var1.length; var17++) {
            byte var19;
            if ((var19 = var1[var17]) != 0) {
               var13 = C_hs.a_short_2(var11 = var3[var19]);
               if (var19 <= 9) {
                  do {
                     this.a_arr_short[var13] = (short)(var17 << 4 | var19);
                  } while ((var13 += 1 << var19) < 512);
               } else {
                  int var20 = this.a_arr_short[var13 & 511];
                  int var10 = 1 << (var20 & 15);
                  var20 = -(var20 >> 4);

                  do {
                     this.a_arr_short[var20 | var13 >> 9] = (short)(var17 << 4 | var19);
                  } while ((var13 += 1 << var19) < var10);
               }

               var3[var19] = var11 + (1 << 16 - var19);
            }
         }
      }
   }

   final int a(C_ie var1) {
      int var2;
      if ((var2 = var1.a_int(9)) >= 0) {
         short var7;
         if ((var7 = this.a_arr_short[var2]) >= 0) {
            var1.a(var7 & 15);
            return var7 >> 4;
         } else {
            int var13 = -(var7 >> 4);
            var7 &= 15;
            if ((var7 = (short)var1.a_int(var7)) >= 0) {
               short var12 = this.a_arr_short[var13 | var7 >> 9];
               var1.a(var12 & 15);
               return var12 >> 4;
            } else {
               int var4 = var1.a_int();
               var7 = (short)var1.a_int(var4);
               short var11;
               if (((var11 = this.a_arr_short[var13 | var7 >> 9]) & 15) <= var4) {
                  var1.a(var11 & 15);
                  return var11 >> 4;
               } else {
                  return -1;
               }
            }
         }
      } else {
         int var3 = var1.a_int();
         var2 = var1.a_int(var3);
         short var6;
         if ((var6 = this.a_arr_short[var2]) >= 0 && (var6 & 15) <= var3) {
            var1.a(var6 & 15);
            return var6 >> 4;
         } else {
            return -1;
         }
      }
   }
}
