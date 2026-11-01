import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NativeBinaryManager {
   private byte[] a_arr_byte = new byte[32];
   private int a_int_1;
   private int b_int;
   private static byte[] b_arr_byte_1;
   private static byte[] c;
   private static byte[] d;
   private static byte[] e;
   private static byte[] f;
   private static byte[] g;
   private static byte[] h;
   private static byte[] i;

   public static String a_String(int var0) {
      switch (var0) {
         case 1:
            return "x64";
         case 2:
            return "x86_64 x32-ABI";
         case 3:
            return "x32";
         case 4:
            return "ARM64";
         case 5:
            return "ARM thumb";
         case 6:
            return "ARM";
         case 7:
            return "MIPS 64";
         case 8:
            return "MIPS N32 ABI";
         case 9:
            return "MIPS O32 ABI";
         case 10:
            return "PowerPC 64-bit";
         case 11:
            return "PowerPC";
         case 12:
            return "RISC-V 64";
         case 13:
            return "RISC-V 32";
         default:
            return "?";
      }
   }

   public static byte[] a_arr_byte(String var0) {
      byte[] var5;
      byte[] var3 = new byte[(var5 = var0.getBytes(Charset.forName("UTF-8"))).length];
      int var2 = var5.length;

      while (var2 - 1 > 0 && var5[var2 - 1] == 61) {
         var2--;
      }

      if (var2 - 1 == 0) {
         return null;
      } else {
         byte[] var4 = new byte[var2 * 3 / 4];

         for (int var1 = 0; var1 < var2; var1++) {
            if (var5[var1] == 43) {
               var3[var1] = 62;
            } else if (var5[var1] == 47) {
               var3[var1] = 63;
            } else if (var5[var1] < 58) {
               var3[var1] = (byte)(var5[var1] + 52 - 48);
            } else if (var5[var1] < 91) {
               var3[var1] = (byte)(var5[var1] - 65);
            } else if (var5[var1] < 123) {
               var3[var1] = (byte)(var5[var1] + 26 - 97);
            }
         }

         int var10 = 0;
         int var6;
         for (var6 = 0; var10 < var2 && var6 < var4.length / 3 * 3; var10 += 4) {
            var4[var6++] = (byte)(var3[var10] << 2 & 252 | var3[var10 + 1] >>> 4 & 3);
            var4[var6++] = (byte)(var3[var10 + 1] << 4 & 240 | var3[var10 + 2] >>> 2 & 15);
            var4[var6++] = (byte)(var3[var10 + 2] << 6 & 192 | var3[var10 + 3] & 63);
         }

         if (var10 < var2) {
            if (var10 < var2 - 2) {
               var4[var6++] = (byte)(var3[var10] << 2 & 252 | var3[var10 + 1] >>> 4 & 3);
               var4[var6] = (byte)(var3[var10 + 1] << 4 & 240 | var3[var10 + 2] >>> 2 & 15);
            } else if (var10 < var2 - 1) {
               var4[var6] = (byte)(var3[var10] << 2 & 252 | var3[var10 + 1] >>> 4 & 3);
            }
         }

         return var4;
      }
   }

   public NativeBinaryManager(byte var1) {
      this();
   }

   public final int a_int() {
      return this.a_int_1;
   }

   public final byte[] a() {
      return this.a_arr_byte;
   }

   private NativeBinaryManager() {
   }

   public final void a_void_3() {
      int var2 = this.a_int_1 + 16384;
      if (var2 - this.a_arr_byte.length > 0) {
         int var3;
         if ((var3 = this.a_arr_byte.length << 1) - var2 < 0) {
            var3 = var2;
         }

         if (var3 - 2147483639 > 0) {
            if (var2 < 0) {
               throw new OutOfMemoryError();
            }

            var3 = var2 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
         }

         byte[] var4 = this.a_arr_byte;
         this.a_arr_byte = Arrays.copyOf(this.a_arr_byte, var3);

         for (int var1 = 0; var1 < var4.length; var1++) {
            var4[var1] = 0;
         }
      }
   }

   private int e() {
      return this.b_int < this.a_arr_byte.length ? this.a_arr_byte[this.b_int++] : -1;
   }

   public final int b_int_2() {
      return this.b_int;
   }

   public final int c_int() {
      return this.a_int_1;
   }

   public final byte[] a(int var1, int var2) {
      return Arrays.copyOfRange(this.a_arr_byte, var1, var1 + var2);
   }

   public final int a(byte var1, int var2) {
      while (var2 < this.a_int_1) {
         if (this.a_arr_byte[var2] == var1) {
            return var2;
         }

         var2++;
      }

      return -1;
   }

   public final byte a_byte_2(int var1) {
      return this.a_arr_byte[var1];
   }

   public final int a_int(int var1, int var2) {
      return Integer.parseInt(this.a_String_2(var1, var2 - var1));
   }

   public final String a_String_2(int var1, int var2) {
      return new String(this.a_arr_byte, var1, var2, FileUtils.a_Charset);
   }

   public final int a(byte[] var1, int var2, int var3) {
      if (var1.length == 0) {
         return -1;
      } else {
         var3 -= var1.length;

         label43:
         while (var2 <= var3) {
            for (int var4 = 0; var4 < var1.length; var4++) {
               byte var10000 = var1[var4];
               byte var6 = this.a_arr_byte[var2 + var4];
               byte var5 = var10000;
               if (var10000 >= 32 && var6 >= 32 ? Character.toUpperCase((int)var5) != Character.toUpperCase((int)var6) : var5 != var6) {
                  var2++;
                  continue label43;
               }
            }

            return var2;
         }

         return -1;
      }
   }

   public final int a(byte[] var1, int var2) {
      return this.a(var1, var2, this.a_int_1);
   }

   public final String a_String_2() {
      StringBuilder var1 = new StringBuilder();
      int var2 = this.b_int;

      int var3;
      while ((var3 = this.e()) != -1) {
         if (var3 == 13) {
            if (this.e() != 10) {
               this.b_int--;
            }

            this.a_void_3(var2, this.b_int);
            return var1.toString();
         }

         if (var3 == 10) {
            this.a_void_3(var2, this.b_int);
            return var1.toString();
         }

         var1.append((char)var3);
      }

      this.a_void_3(var2, this.b_int);
      return var1.toString();
   }

   public final void a_void_3(int var1, int var2) {
      System.arraycopy(this.a_arr_byte, var2, this.a_arr_byte, var1, this.a_arr_byte.length - var2);
      if (this.a_int_1 > var1 && this.a_int_1 < var2) {
         this.a_int_1 = var1;
      }

      if (this.b_int > var1 && this.b_int < var2) {
         this.b_int = var1;
      }

      if (this.a_int_1 >= var2) {
         this.a_int_1 -= var2 - var1;
      }

      if (this.b_int >= var2) {
         this.b_int -= var2 - var1;
      }
   }

   public final void b_void() {
      this.a_int_1 = 0;
      this.b_int = 0;

      for (int var1 = 0; var1 < this.a_arr_byte.length; var1++) {
         this.a_arr_byte[var1] = 0;
      }
   }

   public final void a(int var1) {
      this.b_int += var1;
   }

   public final void b(int var1) {
      this.b_int = var1;
   }

   public final void c(int var1) {
      this.a_int_1 = var1;
   }

   public final int d() {
      return this.a_int_1 - this.b_int;
   }

   @Override
   public final String toString() {
      return new String(this.a_arr_byte, 0, this.a_int_1);
   }

   public static void a(Object var0, Writer var1) throws java.io.IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0 instanceof String) {
         var1.write(34);
         var1.write(a((String)var0));
         var1.write(34);
      } else if (var0 instanceof Double) {
         if (!((Double)var0).isInfinite() && !((Double)var0).isNaN()) {
            var1.write(var0.toString());
         } else {
            var1.write("null");
         }
      } else if (var0 instanceof Float) {
         if (!((Float)var0).isInfinite() && !((Float)var0).isNaN()) {
            var1.write(var0.toString());
         } else {
            var1.write("null");
         }
      } else if (var0 instanceof Number) {
         var1.write(var0.toString());
      } else if (var0 instanceof Boolean) {
         var1.write(var0.toString());
      } else if (var0 instanceof C_dv) {
         ((C_dv)var0).a(var1);
      } else if (var0 instanceof C_ds) {
         var1.write(((C_ds)var0).a());
      } else if (var0 instanceof Map) {
         C_dt.a((Map)var0, var1);
      } else if (var0 instanceof Collection) {
         C_dr.a((Collection)var0, var1);
      } else if (var0 instanceof byte[]) {
         C_dr.a((byte[])var0, var1);
      } else if (var0 instanceof short[]) {
         C_dr.a((short[])var0, var1);
      } else if (var0 instanceof int[]) {
         C_dr.a((int[])var0, var1);
      } else if (var0 instanceof long[]) {
         C_dr.a((long[])var0, var1);
      } else if (var0 instanceof float[]) {
         C_dr.a((float[])var0, var1);
      } else if (var0 instanceof double[]) {
         C_dr.a((double[])var0, var1);
      } else if (var0 instanceof boolean[]) {
         C_dr.a((boolean[])var0, var1);
      } else if (var0 instanceof char[]) {
         C_dr.a((char[])var0, var1);
      } else if (var0 instanceof Object[]) {
         C_dr.a((Object[])var0, var1);
      } else {
         var1.write(var0.toString());
      }
   }

   public static String a(String var0) {
      if (var0 == null) {
         return null;
      } else {
         StringBuffer var1 = new StringBuffer();
         a(var0, var1);
         return var1.toString();
      }
   }

   private static void a(String var0, StringBuffer var1) {
      int var2 = var0.length();

      for (int var3 = 0; var3 < var2; var3++) {
         char var4;
         if ((var4 = var0.charAt(var3)) == '"') {
            var1.append("\\\"");
         } else if (var4 == '\\') {
            var1.append("\\\\");
         } else if (var4 == '\b') {
            var1.append("\\b");
         } else if (var4 == '\f') {
            var1.append("\\f");
         } else if (var4 == '\n') {
            var1.append("\\n");
         } else if (var4 == '\r') {
            var1.append("\\r");
         } else if (var4 == '\t') {
            var1.append("\\t");
         } else if (var4 == '/') {
            var1.append("/");
         } else if (var4 >= 0 && var4 <= 31 || var4 >= 127 && var4 <= 159 || var4 >= 8192 && var4 <= 8447) {
            String var6 = Integer.toHexString(var4);
            var1.append("\\u");

            for (int var5 = 0; var5 < 4 - var6.length(); var5++) {
               var1.append('0');
            }

            var1.append(var6.toUpperCase());
         } else {
            var1.append(var4);
         }
      }
   }

   public static ArrayList a(String var0, String var1, File var2) {
      if (DoomsdayGUI.g_bool_1) {
         System.out.println();
         System.out.println(C_ap.a(var0));
         System.out.println();
      }

      ArrayList var3 = new ArrayList();
      var1 = C_ap.a(var1);
      String var4 = null;
      String var5 = null;
      if (PlatformUtil.h()) {
         Matcher var10 = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(var0);
         boolean var12 = false;

         while (var10.find()) {
            String var8;
            if (var10.group(1) != null) {
               var8 = var10.group(1);
            } else {
               var8 = var10.group(2);
            }

            if (!"-cp".equals(var4) && !"-classpath".equals(var4)) {
               if (var5 == null && var4 != null && !var4.startsWith("--") && !var8.startsWith("-")) {
                  var5 = var8;
                  var3.add(DoomsdayGUI.b_String_2);
                  var3.add("--mainClass");
                  var3.add(var8);
                  var3.add("--doomsdayargs=".concat(String.valueOf(var1)));
                  if (DoomsdayGUI.f_String != null) {
                     var3.add("--stored=" + DoomsdayGUI.f_String.trim());
                  } else {
                     var3.add("--stored=STORED");
                  }

                  var12 = true;
                  var4 = var8;
                  continue;
               }
            } else {
               var8 = var8 + ';' + var2.getAbsolutePath();
            }

            if (!DoomsdayGUI.e_bool_1 || !var8.contains("DisableAttach")) {
               var3.add(var8);
               var4 = var8;
            }
         }

         return !var12 ? null : var3;
      } else {
         StringTokenizer var6 = new StringTokenizer(var0, "\u0000");
         boolean var9 = false;

         while (var6.hasMoreTokens()) {
            String var7 = var6.nextToken();
            if (!"-cp".equals(var4) && !"-classpath".equals(var4)) {
               if (var5 == null && var4 != null && !var4.startsWith("--") && !var7.startsWith("-")) {
                  var5 = var7;
                  var3.add(DoomsdayGUI.b_String_2);
                  var3.add("--mainClass");
                  var3.add(var7);
                  var3.add("--doomsdayargs=".concat(String.valueOf(var1)));
                  var3.add("--stored=" + DoomsdayGUI.f_String.trim());
                  var9 = true;
                  continue;
               }
            } else {
               var7 = var7 + ':' + var2.getAbsolutePath();
            }

            if (!DoomsdayGUI.e_bool_1 || !var7.contains("DisableAttach")) {
               var3.add(var7);
               var4 = var7;
            }
         }

         return !var9 ? null : var3;
      }
   }

   public static ArrayList b(String var0, String var1, File var2) {
      if (DoomsdayGUI.g_bool_1) {
         System.out.println();
         System.out.println(C_ap.a(var0));
         System.out.println();
      }

      ArrayList var3 = new ArrayList();
      if (PlatformUtil.h()) {
         var3 = new ArrayList();
         Matcher var7 = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(var0);
         boolean var10 = false;

         while (var7.find()) {
            String var11;
            if (var7.group(1) != null) {
               var11 = var7.group(1);
            } else {
               var11 = var7.group(2);
            }

            var3.add(var11);
            if (var11.endsWith("java") || var11.endsWith(".exe")) {
               var3.add("-javaagent:" + var2.getAbsolutePath() + "=" + C_ap.a(var1));
               var10 = true;
            }

            if (!var10 && (var11.trim().startsWith("-Xmx") || var11.trim().endsWith("-Xms"))) {
               var3.add("-javaagent:" + var2.getAbsolutePath() + "=" + C_ap.a(var1));
               var10 = true;
            }
         }

         return !var10 ? null : var3;
      } else {
         var1 = C_ap.a(var1);
         StringTokenizer var6 = new StringTokenizer(var0, "\u0000");
         boolean var4 = false;

         while (var6.hasMoreTokens()) {
            String var5 = var6.nextToken();
            if (!DoomsdayGUI.e_bool_1 || !var5.contains("DisableAttach")) {
               var3.add(var5);
               if (var5.endsWith("java") || var5.endsWith(".exe")) {
                  var3.add("-javaagent:" + var2.getAbsolutePath() + "=" + var1);
                  var4 = true;
               }

               if (!var4 && (var5.trim().startsWith("-Xmx") || var5.trim().endsWith("-Xms"))) {
                  var3.add("-javaagent:" + var2.getAbsolutePath() + "=" + var1);
                  var4 = true;
               }
            }
         }

         return !var4 ? null : var3;
      }
   }

   public static byte[] b() {
      if (c == null) {
         c = b("dylib_aarch64");
      }

      return c;
   }

   public static byte[] c() {
      if (b_arr_byte_1 == null) {
         b_arr_byte_1 = b("dylib_x86_64");
      }

      return b_arr_byte_1;
   }

   public static byte[] d_arr_byte() {
      if (d == null) {
         d = b("so_x86_64");
      }

      return d;
   }

   public static byte[] e_arr_byte() {
      if (e == null) {
         e = b("so_i386");
      }

      return e;
   }

   public static byte[] f() {
      if (e == null) {
         e = b("so_aarch64");
      }

      return e;
   }

   public static byte[] g() {
      if (f == null) {
         f = b("dll_i386");
      }

      return f;
   }

   public static byte[] h() {
      if (g == null) {
         g = b("dll_x86_64");
      }

      return g;
   }

   public static byte[] i() {
      if (h == null) {
         h = b("dll_aarch64");
      }

      return h;
   }

   public static byte[] j() {
      byte[] var0 = null;
      if (PlatformUtil.h()) {
         if (PlatformUtil.d()) {
            var0 = i();
         } else if (PlatformUtil.e()) {
            var0 = g();
         } else if (PlatformUtil.f()) {
            var0 = h();
         }
      } else if (!PlatformUtil.j() && !PlatformUtil.k()) {
         if (PlatformUtil.i()) {
            if (PlatformUtil.d()) {
               var0 = b();
            } else if (PlatformUtil.f()) {
               var0 = c();
            }
         }
      } else if (PlatformUtil.d()) {
         var0 = f();
      } else if (PlatformUtil.e()) {
         var0 = e_arr_byte();
      } else if (PlatformUtil.f()) {
         var0 = d_arr_byte();
      }

      return var0;
   }

      private static byte[] b(String param0) {
      try {
         if (i == null) {
            i = LzmaDecompressor.a(DoomsdayGUI.b_arr_byte_3);
         }
         DataInputStream dis = new DataInputStream(new ByteArrayInputStream(i));
         for (int idx = 0; idx < 8; idx++) {
            String name = dis.readUTF();
            byte[] data = new byte[dis.readInt()];
            dis.readFully(data);
            if (name.equals(param0)) {
               return data;
            }
         }
         return null;
      } catch (Throwable t) {
         throw new RuntimeException(t);
      }
   }
}
