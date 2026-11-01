final class C_hz {
   private static final int[] a_arr_int = new int[]{3, 3, 11};
   private static final int[] b_arr_int = new int[]{2, 3, 7};
   private byte[] a_arr_byte_1;
   private byte[] b_arr_byte_1;
   private C_ia a_ia_2;
   private int a_int_3;
   private int b_int_2;
   private int c_int;
   private int d;
   private int e;
   private int f;
   private byte a_byte_4;
   private int g;
   private static final int[] c_arr_int_1 = new int[]{16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

   public C_hz() {
   }

   public final boolean a(C_ie var1) throws C_ho {
      while (true) {
         label90: {
            label91: {
               switch (this.a_int_3) {
                  case 0:
                     this.b_int_2 = var1.a_int(5);
                     if (this.b_int_2 < 0) {
                        return false;
                     }

                     this.b_int_2 += 257;
                     var1.a(5);
                     this.a_int_3 = 1;
                  case 1:
                     this.c_int = var1.a_int(5);
                     if (this.c_int < 0) {
                        return false;
                     }

                     this.c_int++;
                     var1.a(5);
                     this.e = this.b_int_2 + this.c_int;
                     this.b_arr_byte_1 = new byte[this.e];
                     this.a_int_3 = 2;
                  case 2:
                     this.d = var1.a_int(4);
                     if (this.d < 0) {
                        return false;
                     }

                     this.d += 4;
                     var1.a(4);
                     this.a_arr_byte_1 = new byte[19];
                     this.g = 0;
                     this.a_int_3 = 3;
                  case 3:
                     break;
                  case 4:
                     break label91;
                  case 5:
                     break label90;
                  default:
                     continue;
               }

               while (this.g < this.d) {
                  int var2;
                  if ((var2 = var1.a_int(3)) < 0) {
                     return false;
                  }

                  var1.a(3);
                  this.a_arr_byte_1[c_arr_int_1[this.g]] = (byte)var2;
                  this.g++;
               }

               this.a_ia_2 = new C_ia(this.a_arr_byte_1);
               this.a_arr_byte_1 = null;
               this.g = 0;
               this.a_int_3 = 4;
            }

            int var4;
            while (((var4 = this.a_ia_2.a(var1)) & -16) == 0) {
               this.b_arr_byte_1[this.g++] = this.a_byte_4 = (byte)var4;
               if (this.g == this.e) {
                  return true;
               }
            }

            if (var4 < 0) {
               return false;
            }

            if (var4 >= 17) {
               this.a_byte_4 = 0;
            } else if (this.g == 0) {
               throw new C_ho();
            }

            this.f = var4 - 16;
            this.a_int_3 = 5;
         }

         int var5 = b_arr_int[this.f];
         int var3;
         if ((var3 = var1.a_int(var5)) < 0) {
            return false;
         }

         var1.a(var5);
         var3 += a_arr_int[this.f];
         if (this.g + var3 > this.e) {
            throw new C_ho();
         }

         while (var3-- > 0) {
            this.b_arr_byte_1[this.g++] = this.a_byte_4;
         }

         if (this.g == this.e) {
            return true;
         }

         this.a_int_3 = 4;
      }
   }

   public final C_ia a() throws C_ho {
      byte[] var1 = new byte[this.b_int_2];
      System.arraycopy(this.b_arr_byte_1, 0, var1, 0, this.b_int_2);
      return new C_ia(var1);
   }

   public final C_ia b() throws C_ho {
      byte[] var1 = new byte[this.c_int];
      System.arraycopy(this.b_arr_byte_1, this.b_int_2, var1, 0, this.c_int);
      return new C_ia(var1);
   }
}
