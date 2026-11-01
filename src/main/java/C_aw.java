import java.util.Arrays;
import java.util.Random;

public final class C_aw {
   private C_fp a_fp;
   private byte[] a_arr_byte_1;
   private byte[] b;
   private int a_int_2;
   private boolean a_bool_3;
   private byte[] c;
   private byte[] d;

   public C_aw(C_fp var1, byte[] var2) {
      this.a_fp = var1;
      this.c = (byte[])var2.clone();
      this.a_arr_byte_1 = new byte[0];
      this.b();
      this.a_void();
   }

   public C_aw(byte[] var1, int var2) {
      this.a_int_2 = var2;
      int var5 = this.a_int_2;
      if (var1[var5] != 0) {
         this.a_bool_3 = true;
         byte[] var6 = new byte[var1.length];
         int var4 = this.a(var1, var5, var6, 0);
         this.a_arr_byte_1 = Arrays.copyOf(var6, var4 - 1);
         this.b();
         a(var6);
      }

      int var3 = var1[this.a_int_2++] << 8 | var1[this.a_int_2++];
      boolean var10000;
      switch (var3) {
         case 1:
            this.a_fp = C_fp.c;
            var10000 = true;
            break;
         case 2:
            this.a_fp = C_fp.b;
            var10000 = true;
            break;
         case 5:
            this.a_fp = C_fp.e;
            var10000 = true;
            break;
         case 15:
            this.a_fp = C_fp.a_fp;
            var10000 = true;
            break;
         case 28:
            this.a_fp = C_fp.d;
            var10000 = true;
            break;
         default:
            this.a_int_2 = -1;
            var10000 = false;
      }

      if (var10000) {
         if ((var1[this.a_int_2++] << 8 | var1[this.a_int_2++]) != 1) {
            this.a_int_2 = -1;
            return;
         }

         this.a_int_2++;
         this.a_int_2++;
         this.a_int_2++;
         this.a_int_2++;
         this.a_int_2++;
         byte[] var10001;
         if (var1[this.a_int_2] == 0) {
            var10001 = new byte[0];
         } else {
            this.a_bool_3 = true;
            if (this.a_fp == C_fp.c) {
               var10001 = this.a(var1, this.a_int_2);
            } else if (this.a_fp == C_fp.d) {
               var10001 = this.b(var1, this.a_int_2);
            } else if (this.a_fp == C_fp.b) {
               this.a_int_2++;
               byte[] var10 = new byte[var1.length];
               int var13 = this.a(var1, this.a_int_2, var10, 0);
               byte[] var7 = Arrays.copyOf(var10, var13 - 1);
               a(var10);
               var10001 = var7;
            } else if (this.a_fp == C_fp.a_fp) {
               this.a_int_2++;
               this.a_int_2++;
               this.a_int_2++;
               byte[] var11 = new byte[var1.length];
               int var14 = this.a(var1, this.a_int_2, var11, 0);
               byte[] var8 = Arrays.copyOf(var11, var14 - 1);
               a(var11);
               var10001 = var8;
            } else {
               this.a_int_2++;
               byte[] var12 = new byte[var1.length];
               int var15 = this.a(var1, this.a_int_2, var12, 0);
               byte[] var9 = Arrays.copyOf(var12, var15 - 1);
               a(var12);
               var10001 = var9;
            }
         }

         this.c = var10001;
         this.a_void();
      }
   }

   private void a_void() {
      this.d = new byte[this.c.length];
      new Random().nextBytes(this.d);

      for (int var1 = 0; var1 < this.c.length; var1++) {
         this.c[var1] = (byte)(this.c[var1] ^ this.d[var1]);
      }
   }

   public final int a_int_2() {
      return this.a_int_2;
   }

   public final byte[] a() {
      byte[] var1 = new byte[this.c.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (byte)(this.c[var2] ^ this.d[var2]);
      }

      return var1;
   }

   private void b() {
      this.b = new byte[this.a_arr_byte_1.length];
      new Random().nextBytes(this.b);

      for (int var1 = 0; var1 < this.a_arr_byte_1.length; var1++) {
         this.a_arr_byte_1[var1] = (byte)(this.a_arr_byte_1[var1] ^ this.b[var1]);
      }
   }

   private static void a(byte[] var0) {
      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = 0;
      }
   }

   private int a(byte[] var1, int var2, byte[] var3, int var4) {
      while (var1[var2] != 0) {
         if ((var1[var2] & 192) == 192) {
            this.a_int_2 += 2;
            this.a_bool_3 = false;
            byte var10002 = var1[var2];
            byte var7 = var1[var2 + 1];
            var2 = (var10002 & 63) << 8 | var7;
            var1 = var1;
            // this = this;
         } else {
            int var5 = var1[var2] & 255;

            for (int var6 = 1; var6 <= var5; var6++) {
               var3[var4++] = var1[var6 + var2];
            }

            if (this.a_bool_3) {
               this.a_int_2 += var5 + 1;
            }

            var3[var4++] = 46;
            var2 = var2 + var5 + 1;
            var1 = var1;
            // this = this;
         }
      }

      return var4;
   }

   private byte[] a(byte[] var1, int var2) {
      if (var1[var2] == 0) {
         return new byte[0];
      } else {
         int var3 = var1[var2] & 255;
         var2++;
         byte[] var4 = new byte[var3];

         for (int var5 = 0; var5 < var3; var5++) {
            var4[var5] = (byte)var1[var5 + var2];
         }

         if (this.a_bool_3) {
            this.a_int_2 += var3 + 1;
         }

         return var4;
      }
   }

   private byte[] b(byte[] var1, int var2) {
      if (var1[var2] == 0) {
         return new byte[0];
      } else {
         int var3;
         byte[] var4 = new byte[var3 = var1[var2] & 255];
         var2++;

         for (int var5 = 0; var5 < var3; var5++) {
            var4[var5] = (byte)var1[var5 + var2];
         }

         if (this.a_bool_3) {
            this.a_int_2 += var3 + 1;
         }

         return var4;
      }
   }
}
