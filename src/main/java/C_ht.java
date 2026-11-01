final class C_ht {
   short[] a_arr_short;
   private short[] b_arr_short;
   byte[] a_arr_byte_1;
   private int[] a_arr_int_2;
   private int b_int_1;
   int a_int_3;
   private int c;
   private C_hs a_hs_4;

   C_ht(C_hs var1, int var2, int var3, int var4) {
      this.a_hs_4 = var1;
      this.b_int_1 = var3;
      this.c = var4;
      this.a_arr_short = new short[var2];
      this.a_arr_int_2 = new int[var4];
   }

   final void a_void() {
      for (int var1 = 0; var1 < this.a_arr_short.length; var1++) {
         this.a_arr_short[var1] = 0;
      }

      this.b_arr_short = null;
      this.a_arr_byte_1 = null;
   }

   final void a(int var1) {
      this.a_hs_4.a_hv_1.a(this.b_arr_short[var1] & '\uffff', this.a_arr_byte_1[var1]);
   }

   final void a(short[] var1, byte[] var2) {
      this.b_arr_short = var1;
      this.a_arr_byte_1 = var2;
   }

   public final void b() {
      int[] var1 = new int[this.c];
      int var2 = 0;
      this.b_arr_short = new short[this.a_arr_short.length];

      for (int var3 = 0; var3 < this.c; var3++) {
         var1[var3] = var2;
         var2 += this.a_arr_int_2[var3] << 15 - var3;
      }

      for (int var5 = 0; var5 < this.a_int_3; var5++) {
         byte var4;
         if ((var4 = this.a_arr_byte_1[var5]) > 0) {
            this.b_arr_short[var5] = C_hs.a_short_2(var1[var4 - 1]);
            var1[var4 - 1] = var1[var4 - 1] + (1 << 16 - var4);
         }
      }
   }

   private void a(int[] var1) {
      this.a_arr_byte_1 = new byte[this.a_arr_short.length];
      int var2;
      int var3 = ((var2 = var1.length / 2) + 1) / 2;
      int var4 = 0;

      for (int var5 = 0; var5 < this.c; var5++) {
         this.a_arr_int_2[var5] = 0;
      }

      int[] var11;
      (var11 = new int[var2])[var2 - 1] = 0;

      while (--var2 >= 0) {
         if (var1[2 * var2 + 1] != -1) {
            int var6;
            if ((var6 = var11[var2] + 1) > this.c) {
               var6 = this.c;
               var4++;
            }

            var11[var1[2 * var2]] = var11[var1[2 * var2 + 1]] = var6;
         } else {
            int var12 = var11[var2];
            this.a_arr_int_2[var12 - 1]++;
            this.a_arr_byte_1[var1[2 * var2]] = (byte)var11[var2];
         }
      }

      if (var4 != 0) {
         var2 = this.c - 1;

         do {
            while (this.a_arr_int_2[--var2] == 0) {
            }

            do {
               this.a_arr_int_2[var2]--;
               var2++;
               this.a_arr_int_2[var2]++;
            } while ((var4 -= 1 << this.c - 1 - var2) > 0 && var2 < this.c - 1);
         } while (var4 > 0);

         this.a_arr_int_2[this.c - 1] = this.a_arr_int_2[this.c - 1] + var4;
         this.a_arr_int_2[this.c - 2] = this.a_arr_int_2[this.c - 2] - var4;
         int var13 = 2 * var3;

         for (int var8 = this.c; var8 != 0; var8--) {
            var3 = this.a_arr_int_2[var8 - 1];

            while (var3 > 0) {
               var4 = 2 * var1[var13++];
               if (var1[var4 + 1] == -1) {
                  this.a_arr_byte_1[var1[var4]] = (byte)var8;
                  var3--;
               }
            }
         }
      }
   }

   final void c() {
      int var1;
      int[] var2 = new int[var1 = this.a_arr_short.length];
      int var3 = 0;
      int var4 = 0;

      for (int var5 = 0; var5 < var1; var5++) {
         short var6;
         if ((var6 = this.a_arr_short[var5]) != 0) {
            var4 = var3++;

            int var7;
            while (var4 > 0 && this.a_arr_short[var2[var7 = (var4 - 1) / 2]] > var6) {
               var2[var4] = var2[var7];
               var4 = var7;
            }

            var2[var4] = var5;
            var4 = var5;
         }
      }

      while (var3 < 2) {
         int var15 = var4 < 2 ? ++var4 : 0;
         var2[var3++] = var15;
      }

      this.a_int_3 = Math.max(var4 + 1, this.b_int_1);
      int[] var19 = new int[4 * var3 - 2];
      int[] var14 = new int[2 * var3 - 1];
      int var20 = var3;

      for (int var11 = 0; var11 < var3; var2[var11] = var11++) {
         int var16 = var2[var11];
         var19[2 * var11] = var16;
         var19[2 * var11 + 1] = -1;
         var14[var11] = this.a_arr_short[var16] << 8;
      }

      label84:
      while (true) {
         var1 = var2[0];
         int var17 = var2[--var3];
         int var8 = 0;

         for (int var9 = 1; var9 < var3; var9 = (var9 << 1) + 1) {
            if (var9 + 1 < var3 && var14[var2[var9]] > var14[var2[var9 + 1]]) {
               var9++;
            }

            var2[var8] = var2[var9];
            var8 = var9;
         }

         int var10 = var14[var17];

         while (true) {
            int var23 = var8;
            if (var8 <= 0 || var14[var2[var8 = (var8 - 1) / 2]] <= var10) {
               var2[var23] = var17;
               var8 = var2[0];
               var17 = var20++;
               var19[2 * var17] = var1;
               var19[2 * var17 + 1] = var8;
               var23 = Math.min(var14[var1] & 0xFF, var14[var8] & 0xFF);
               var14[var17] = var10 = var14[var1] + var14[var8] - var23 + 1;
               var8 = 0;

               for (int var25 = 1; var25 < var3; var25 = (var25 << 1) + 1) {
                  if (var25 + 1 < var3 && var14[var2[var25]] > var14[var2[var25 + 1]]) {
                     var25++;
                  }

                  var2[var8] = var2[var25];
                  var8 = var25;
               }

               while (true) {
                  var23 = var8;
                  if (var8 <= 0 || var14[var2[var8 = (var8 - 1) / 2]] <= var10) {
                     var2[var23] = var17;
                     if (var3 <= 1) {
                        break label84;
                     }
                     continue label84;
                  }

                  var2[var23] = var2[var8];
               }
            }

            var2[var23] = var2[var8];
         }
      }

      if (var2[0] != var19.length / 2 - 1) {
         throw new RuntimeException("Weird!");
      } else {
         this.a(var19);
      }
   }

   final int a() {
      int var1 = 0;

      for (int var2 = 0; var2 < this.a_arr_short.length; var2++) {
         var1 += this.a_arr_short[var2] * this.a_arr_byte_1[var2];
      }

      return var1;
   }

   final void a(C_ht var1) {
      byte var4 = -1;
      int var5 = 0;

      while (var5 < this.a_int_3) {
         int var3 = 1;
         short var2;
         byte var6;
         if ((var6 = this.a_arr_byte_1[var5]) == 0) {
            var2 = 138;
         } else {
            var2 = 6;
            if (var4 != var6) {
               var1.a_arr_short[var6]++;
               var3 = 0;
            }
         }

         var4 = var6;
         var5++;

         while (var5 < this.a_int_3 && var4 == this.a_arr_byte_1[var5]) {
            var5++;
            if (++var3 >= var2) {
               break;
            }
         }

         if (var3 < 3) {
            var1.a_arr_short[var4] = (short)(var1.a_arr_short[var4] + var3);
         } else if (var4 != 0) {
            var1.a_arr_short[16]++;
         } else if (var3 <= 10) {
            var1.a_arr_short[17]++;
         } else {
            var1.a_arr_short[18]++;
         }
      }
   }

   final void b(C_ht var1) {
      byte var4 = -1;
      int var5 = 0;

      while (var5 < this.a_int_3) {
         int var3 = 1;
         short var2;
         byte var6;
         if ((var6 = this.a_arr_byte_1[var5]) == 0) {
            var2 = 138;
         } else {
            var2 = 6;
            if (var4 != var6) {
               var1.a(var6);
               var3 = 0;
            }
         }

         var4 = var6;
         var5++;

         while (var5 < this.a_int_3 && var4 == this.a_arr_byte_1[var5]) {
            var5++;
            if (++var3 >= var2) {
               break;
            }
         }

         if (var3 < 3) {
            while (var3-- > 0) {
               var1.a(var4);
            }
         } else if (var4 != 0) {
            var1.a(16);
            this.a_hs_4.a_hv_1.a(var3 - 3, 2);
         } else if (var3 <= 10) {
            var1.a(17);
            this.a_hs_4.a_hv_1.a(var3 - 3, 3);
         } else {
            var1.a(18);
            this.a_hs_4.a_hv_1.a(var3 - 11, 7);
         }
      }
   }
}
