import java.util.Random;

public final class C_ax {
   private CharSequence a_CharSequence;
   private C_fp a_fp_1;
   public byte[] a_arr_byte_2;
   private static volatile int[] a_arr_int_3;

   public C_ax(CharSequence var1, C_fp var2) {
      this.a_CharSequence = var1;
      this.a_fp_1 = var2;
      this.a_arr_byte_2 = new byte[2];
      new Random().nextBytes(this.a_arr_byte_2);
   }

   public final byte[] a() {
      int var1 = 0;
      CharSequence var4 = this.a_CharSequence;
      int var5 = 1;

      for (int var2 = 0; var2 < var4.length(); var2++) {
         if (var4.charAt(var2) == '.') {
            var5++;
         }
      }

      int[] var9 = new int[var5];
      int var3 = 0;
      var5 = 0;

      for (int var6 = 0; var6 < var4.length(); var6++) {
         if (var4.charAt(var6) == '.') {
            var9[var5++] = var6 - var3;
            var3 = var6 + 1;
         }
      }

      var9[var5] = var4.length() - var3;

      for (int var10 = 0; var10 < var9.length; var10++) {
         var1 += var9[var10] + 1;
      }

      int var11 = 0;
      byte[] var8 = new byte[var1 + 12 + 5];
      var8[0] = this.a_arr_byte_2[0];
      var8[1] = this.a_arr_byte_2[1];
      var8[2] = 1;
      var8[3] = 0;
      var8[4] = 0;
      var8[5] = 1;
      var8[6] = 0;
      var8[7] = 0;
      var8[8] = 0;
      var8[9] = 0;
      var8[10] = 0;
      var8[11] = 0;
      var11 += 12;
      int var17 = 0;
      var5 = 0;

      for (int var20 = 0; var20 < this.a_CharSequence.length(); var20++) {
         if (this.a_CharSequence.charAt(var20) == '.') {
            var8[var11++] = (byte)var9[var5];

            for (int var7 = 0; var7 < var9[var5]; var7++) {
               var8[var11++] = (byte)this.a_CharSequence.charAt(var17 + var7);
            }

            var5++;
            var17 = var20 + 1;
         }
      }

      var8[var11++] = (byte)var9[var5];

      for (int var21 = 0; var21 < var9[var5]; var21++) {
         var8[var11++] = (byte)this.a_CharSequence.charAt(var17 + var21);
      }

      var8[var11++] = 0;
      var8[var11++] = 0;
      switch (a_arr_int()[this.a_fp_1.ordinal()]) {
         case 1:
            var8[var11++] = 15;
            break;
         case 2:
            var8[var11++] = 2;
            break;
         case 3:
            var8[var11++] = 1;
            break;
         case 4:
            var8[var11++] = 28;
      }

      var8[var11++] = 0;
      var8[var11] = 1;
      return var8;
   }

   private static int[] a_arr_int() {
      if (a_arr_int_3 != null) {
         return a_arr_int_3;
      } else {
         int[] var0 = new int[C_fp.a().length];

         try {
            var0[C_fp.c.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[C_fp.d.ordinal()] = 4;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[C_fp.e.ordinal()] = 5;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[C_fp.a_fp.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[C_fp.b.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
         }

         a_arr_int_3 = var0;
         return var0;
      }
   }
}
