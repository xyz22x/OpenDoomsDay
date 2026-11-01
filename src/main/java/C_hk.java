import java.io.IOException;
import java.io.Reader;

final class C_hk {
   private static final int[] a_arr_int = new int[]{0, 0, 1, 1};
   private static final char[] a_arr_char_1;
   private static final char[] b_arr_char;
   private static final int[] b_arr_int_1;
   private static final char[] c_arr_char;
   private static final int[] c_arr_int_1;
   private static final int[] d_arr_int;
   private static final String[] a_arr_String_2;
   private static final char[] d_arr_char_1;
   private static final int[] e_arr_int;
   private Reader a_Reader_3;
   private int a_int_4;
   private int b_int_2 = 0;
   private char[] e_arr_char_1 = new char[16384];
   private int c_int_2;
   private int d_int_2;
   private int e_int_2;
   private int f;
   private int g;
   private boolean a_bool_5;
   private StringBuffer a_StringBuffer_6 = new StringBuffer();

   static {
      char[] var0 = new char[]{
         '\t',
         '\u0000',
         '\u0001',
         '\u0007',
         '\u0001',
         '\u0007',
         '\u0002',
         '\u0000',
         '\u0001',
         '\u0007',
         '\u0012',
         '\u0000',
         '\u0001',
         '\u0007',
         '\u0001',
         '\u0000',
         '\u0001',
         '\t',
         '\b',
         '\u0000',
         '\u0001',
         '\u0006',
         '\u0001',
         '\u0019',
         '\u0001',
         '\u0002',
         '\u0001',
         '\u0004',
         '\u0001',
         '\n',
         '\n',
         '\u0003',
         '\u0001',
         '\u001a',
         '\u0006',
         '\u0000',
         '\u0004',
         '\u0001',
         '\u0001',
         '\u0005',
         '\u0001',
         '\u0001',
         '\u0014',
         '\u0000',
         '\u0001',
         '\u0017',
         '\u0001',
         '\b',
         '\u0001',
         '\u0018',
         '\u0003',
         '\u0000',
         '\u0001',
         '\u0012',
         '\u0001',
         '\u000b',
         '\u0002',
         '\u0001',
         '\u0001',
         '\u0011',
         '\u0001',
         '\f',
         '\u0005',
         '\u0000',
         '\u0001',
         '\u0013',
         '\u0001',
         '\u0000',
         '\u0001',
         '\r',
         '\u0003',
         '\u0000',
         '\u0001',
         '\u000e',
         '\u0001',
         '\u0014',
         '\u0001',
         '\u000f',
         '\u0001',
         '\u0010',
         '\u0005',
         '\u0000',
         '\u0001',
         '\u0015',
         '\u0001',
         '\u0000',
         '\u0001',
         '\u0016',
         'ﾂ',
         '\u0000'
      };
      char[] var1 = new char[65536];
      int var2 = 0;
      int var3 = 0;

      while (var2 < 90) {
         int var4 = var0[var2++];
         char var5 = var0[var2++];

         do {
            var1[var3++] = var5;
         } while (--var4 <= 0);
      }

      a_arr_char_1 = var1;
      b_arr_char = new char[]{
         '\u0002',
         '\u0000',
         '\u0002',
         '\u0001',
         '\u0001',
         '\u0002',
         '\u0001',
         '\u0003',
         '\u0001',
         '\u0004',
         '\u0003',
         '\u0001',
         '\u0001',
         '\u0005',
         '\u0001',
         '\u0006',
         '\u0001',
         '\u0007',
         '\u0001',
         '\b',
         '\u0001',
         '\t',
         '\u0001',
         '\n',
         '\u0001',
         '\u000b',
         '\u0001',
         '\f',
         '\u0001',
         '\r',
         '\u0005',
         '\u0000',
         '\u0001',
         '\f',
         '\u0001',
         '\u000e',
         '\u0001',
         '\u000f',
         '\u0001',
         '\u0010',
         '\u0001',
         '\u0011',
         '\u0001',
         '\u0012',
         '\u0001',
         '\u0013',
         '\u0001',
         '\u0014',
         '\u0001',
         '\u0000',
         '\u0001',
         '\u0015',
         '\u0001',
         '\u0000',
         '\u0001',
         '\u0015',
         '\u0004',
         '\u0000',
         '\u0001',
         '\u0016',
         '\u0001',
         '\u0017',
         '\u0002',
         '\u0000',
         '\u0001',
         '\u0018'
      };
      int[] var8 = new int[45];
      int[] var18 = var8;
      var1 = b_arr_char;
      int var21 = 0;
      int var27 = 0;
      var2 = var1.length;

      while (var21 < var2) {
         int var6 = var1[var21++];
         char var7 = var1[var21++];

         do {
            var18[var27++] = var7;
         } while (--var6 <= 0);
      }

      b_arr_int_1 = var8;
      c_arr_char = new char[]{
         '\u0000',
         '\u0000',
         '\u0000',
         '\u001b',
         '\u0000',
         '6',
         '\u0000',
         'Q',
         '\u0000',
         'l',
         '\u0000',
         '\u0087',
         '\u0000',
         '6',
         '\u0000',
         '¢',
         '\u0000',
         '½',
         '\u0000',
         'Ø',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         'ó',
         '\u0000',
         'Ď',
         '\u0000',
         '6',
         '\u0000',
         'ĩ',
         '\u0000',
         'ń',
         '\u0000',
         'ş',
         '\u0000',
         'ź',
         '\u0000',
         'ƕ',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         'ư',
         '\u0000',
         'ǋ',
         '\u0000',
         'Ǧ',
         '\u0000',
         'Ǧ',
         '\u0000',
         'ȁ',
         '\u0000',
         'Ȝ',
         '\u0000',
         'ȷ',
         '\u0000',
         'ɒ',
         '\u0000',
         '6',
         '\u0000',
         '6',
         '\u0000',
         'ɭ',
         '\u0000',
         'ʈ',
         '\u0000',
         '6'
      };
      int[] var9 = new int[45];
      int[] var19 = var9;
      var1 = c_arr_char;
      var21 = 0;
      var27 = 0;
      var2 = var1.length;

      while (var21 < var2) {
         int var30 = var1[var21++] << 16;
         var19[var27++] = var30 | var1[var21++];
      }

      c_arr_int_1 = var9;
      d_arr_int = new int[]{
         2,
         2,
         3,
         4,
         2,
         2,
         2,
         5,
         2,
         6,
         2,
         2,
         7,
         8,
         2,
         9,
         2,
         2,
         2,
         2,
         2,
         10,
         11,
         12,
         13,
         14,
         15,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         17,
         18,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         4,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         4,
         19,
         20,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         20,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         5,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         21,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         22,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         23,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         -1,
         -1,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         16,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         24,
         25,
         26,
         27,
         28,
         29,
         30,
         31,
         32,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         33,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         34,
         35,
         -1,
         -1,
         34,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         36,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         37,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         38,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         39,
         -1,
         39,
         -1,
         39,
         -1,
         -1,
         -1,
         -1,
         -1,
         39,
         39,
         -1,
         -1,
         -1,
         -1,
         39,
         39,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         33,
         -1,
         20,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         20,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         35,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         38,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         40,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         41,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         42,
         -1,
         42,
         -1,
         42,
         -1,
         -1,
         -1,
         -1,
         -1,
         42,
         42,
         -1,
         -1,
         -1,
         -1,
         42,
         42,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         43,
         -1,
         43,
         -1,
         43,
         -1,
         -1,
         -1,
         -1,
         -1,
         43,
         43,
         -1,
         -1,
         -1,
         -1,
         43,
         43,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         44,
         -1,
         44,
         -1,
         44,
         -1,
         -1,
         -1,
         -1,
         -1,
         44,
         44,
         -1,
         -1,
         -1,
         -1,
         44,
         44,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1,
         -1
      };
      a_arr_String_2 = new String[]{"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
      d_arr_char_1 = new char[]{
         '\u0002',
         '\u0000',
         '\u0001',
         '\t',
         '\u0003',
         '\u0001',
         '\u0001',
         '\t',
         '\u0003',
         '\u0001',
         '\u0006',
         '\t',
         '\u0002',
         '\u0001',
         '\u0001',
         '\t',
         '\u0005',
         '\u0000',
         '\b',
         '\t',
         '\u0001',
         '\u0000',
         '\u0001',
         '\u0001',
         '\u0001',
         '\u0000',
         '\u0001',
         '\u0001',
         '\u0004',
         '\u0000',
         '\u0002',
         '\t',
         '\u0002',
         '\u0000',
         '\u0001',
         '\t'
      };
      int[] var10 = new int[45];
      int[] var20 = var10;
      var1 = d_arr_char_1;
      var21 = 0;
      var27 = 0;
      var2 = var1.length;

      while (var21 < var2) {
         int var31 = var1[var21++];
         char var32 = var1[var21++];

         do {
            var20[var27++] = var32;
         } while (--var31 <= 0);
      }

      e_arr_int = var10;
   }

   final int a() {
      return this.g;
   }

   C_hk(Reader var1) {
      this.a_Reader_3 = var1;
   }

   public final void a(Reader var1) {
      this.a_Reader_3 = var1;
      this.a_bool_5 = false;
      this.f = this.e_int_2 = 0;
      this.d_int_2 = this.c_int_2 = 0;
      this.g = 0;
      this.b_int_2 = 0;
   }

   private String a_String() {
      return new String(this.e_arr_char_1, this.e_int_2, this.c_int_2 - this.e_int_2);
   }

   public final C_hl a_hl_2() {
      int var5 = this.f;
      char[] var6 = this.e_arr_char_1;
      char[] var7 = a_arr_char_1;
      int[] var8 = d_arr_int;
      int[] var9 = c_arr_int_1;
      int[] var10 = e_arr_int;

      while (true) {
         int var4 = this.c_int_2;
         this.g = this.g + (var4 - this.e_int_2);
         int var2 = -1;
         int var3 = this.d_int_2 = this.e_int_2 = var4;
         this.a_int_4 = a_arr_int[this.b_int_2];

         int var1;
         while (true) {
            if (var3 >= var5) {
               if (this.a_bool_5) {
                  var1 = -1;
                  break;
               }

               this.d_int_2 = var3;
               this.c_int_2 = var4;
               if (this.e_int_2 > 0) {
                  System.arraycopy(this.e_arr_char_1, this.e_int_2, this.e_arr_char_1, 0, this.f - this.e_int_2);
                  this.f = this.f - this.e_int_2;
                  this.d_int_2 = this.d_int_2 - this.e_int_2;
                  this.c_int_2 = this.c_int_2 - this.e_int_2;
                  this.e_int_2 = 0;
               }

               if (this.d_int_2 >= this.e_arr_char_1.length) {
                  char[] var14 = new char[this.d_int_2 << 1];
                  System.arraycopy(this.e_arr_char_1, 0, var14, 0, this.e_arr_char_1.length);
                  this.e_arr_char_1 = var14;
               }

               boolean var10000;
               try {
                  if ((var3 = this.a_Reader_3.read(this.e_arr_char_1, this.f, this.e_arr_char_1.length - this.f)) > 0) {
                     this.f += var3;
                     var10000 = false;
                  } else if (var3 == 0 && (var3 = this.a_Reader_3.read()) != -1) {
                     this.e_arr_char_1[this.f++] = (char)var3;
                     var10000 = false;
                  } else {
                     var10000 = true;
                  }
               } catch (IOException var_ioe) {
                  throw new RuntimeException(var_ioe);
               }

               boolean var11 = var10000;
               var3 = this.d_int_2;
               var4 = this.c_int_2;
               var6 = this.e_arr_char_1;
               var5 = this.f;
               if (var11) {
                  var1 = -1;
                  break;
               }
            }

            var1 = var6[var3++];
            int var18;
            if ((var18 = var8[var9[this.a_int_4] + var7[var1]]) == -1) {
               break;
            }

            this.a_int_4 = var18;
            if (((var18 = var10[this.a_int_4]) & 1) == 1) {
               var2 = this.a_int_4;
               var4 = var3;
               if ((var18 & 8) == 8) {
                  break;
               }
            }
         }

         this.c_int_2 = var4;
         switch (var2 < 0 ? var2 : b_arr_int_1[var2]) {
            case 1:
               throw new C_fm(this.g, 0, new Character(this.e_arr_char_1[this.e_int_2]));
            case 2:
            String var17 = null;
               Long var23 = Long.valueOf(this.a_String());
               return new C_hl(0, var23);
            case 3:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
               break;
            case 4:
               this.a_StringBuffer_6 = null;
               this.a_StringBuffer_6 = new StringBuffer();
               this.b_int_2 = 2;
               break;
            case 5:
               return new C_hl(1, null);
            case 6:
               return new C_hl(2, null);
            case 7:
               return new C_hl(3, null);
            case 8:
               return new C_hl(4, null);
            case 9:
               return new C_hl(5, null);
            case 10:
               return new C_hl(6, null);
            case 11:
               this.a_StringBuffer_6.append(this.a_String());
               break;
            case 12:
               this.a_StringBuffer_6.append('\\');
               break;
            case 13:
               this.b_int_2 = 0;
               return new C_hl(0, this.a_StringBuffer_6.toString());
            case 14:
               this.a_StringBuffer_6.append('"');
               break;
            case 15:
               this.a_StringBuffer_6.append('/');
               break;
            case 16:
               this.a_StringBuffer_6.append('\b');
               break;
            case 17:
               this.a_StringBuffer_6.append('\f');
               break;
            case 18:
               this.a_StringBuffer_6.append('\n');
               break;
            case 19:
               this.a_StringBuffer_6.append('\r');
               break;
            case 20:
               this.a_StringBuffer_6.append('\t');
               break;
            case 21:
               Double var22 = Double.valueOf(this.a_String());
               return new C_hl(0, var22);
            case 22:
               return new C_hl(0, null);
            case 23:
               Boolean var21 = Boolean.valueOf(this.a_String());
               return new C_hl(0, var21);
            case 24:
               try {
                  int var20 = Integer.parseInt(this.a_String().substring(2), 16);
                  this.a_StringBuffer_6.append((char)var20);
                  break;
               } catch (Exception var13) {
                  throw new C_fm(this.g, 2, var13);
               }
            default:
               var17 = null;
               if (var1 == -1 && this.e_int_2 == this.d_int_2) {
                  this.a_bool_5 = true;
                  return null;
               }

               try {
                  var17 = a_arr_String_2[1];
               } catch (ArrayIndexOutOfBoundsException var12) {
                  var17 = a_arr_String_2[0];
               }

               throw new Error(var17);
         }
      }
   }
}
