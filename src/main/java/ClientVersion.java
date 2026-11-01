import java.io.File;
import javax.swing.Icon;

public final class ClientVersion implements VersionItem {
   public final String a_String;
   public final String b_String;
   public final int a_int_1;
   public volatile double a_dbl_2 = -1.0;
   public volatile boolean a_bool_3;
   public byte[] a_arr_byte_4;
   private String c_String;
   protected File a_File_5;
   private int b_int_1;
   private String d;
   protected DownloadUrlConfig a_bn_6;
   private int c_int_1;
   private String e;
   private boolean isCustom = false;

   public ClientVersion(String var1, int var2, String var3) {
      this.b_String = var1;
      this.a_int_1 = var2;
      this.a_String = var3;
   }

   public ClientVersion(File var1) {
      this.b_String = var1.getName();
      this.a_int_1 = 0;
      this.a_String = var1.getAbsolutePath();
      this.a_File_5 = var1;
      this.b_int_1 = (int)var1.length();
      this.isCustom = true;
   }

   public final boolean isCustom() {
      return this.isCustom;
   }

   public final int a() {
      if (this.a_arr_byte_4 != null) {
         return this.a_arr_byte_4.length;
      } else if (this.a_File_5 != null) {
         return this.b_int_1;
      } else {
         return this.a_bn_6 != null ? this.c_int_1 : 0;
      }
   }

   public final boolean a(byte[] var1, String var2) {
      boolean var3 = false;
      if (!a(this.a_arr_byte_4, var1)) {
         this.a_arr_byte_4 = var1;
         var3 = true;
      }

      if (!a(this.c_String, var2)) {
         this.c_String = var2;
         var3 = true;
      }

      return var3;
   }

   public final boolean a_file(File var1, int var2, String var3) {
      boolean var4 = false;
      if (!a(this.a_File_5, var1)) {
         this.a_File_5 = var1;
         var4 = true;
      }

      if (this.b_int_1 != var2) {
         this.b_int_1 = var2;
         var4 = true;
      }

      if (!a(this.d, var3)) {
         this.d = var3;
         var4 = true;
      }

      return var4;
   }

   private static boolean a(Object var0, Object var1) {
      if (var0 == var1) {
         return true;
      } else if (var0 == null) {
         return false;
      } else {
         return var1 == null ? false : var0.equals(var1);
      }
   }

   public final boolean a_bool() {
      if (this.isCustom) {
         return true;
      }
      return this.c_String != null && this.e != null ? this.c_String.equals(this.e) : true;
   }

   public final boolean b() {
      if (this.isCustom) {
         return true;
      }
      return this.d != null && this.e != null ? this.d.equals(this.e) : true;
   }

   public final boolean a_bn(DownloadUrlConfig var1, int var2, String var3) {
      boolean var4 = false;
      if (!a(this.a_bn_6, var1)) {
         this.a_bn_6 = var1;
         var4 = true;
      }

      if (this.c_int_1 != var2) {
         this.c_int_1 = var2;
         var4 = true;
      }

      if (!a(this.e, var3)) {
         this.e = var3;
         var4 = true;
      }

      return var4;
   }

   public final boolean c() {
      return this.a_File_5 == null && this.a_arr_byte_4 == null && this.a_bn_6 == null;
   }

   @Override
   public final String toString() {
      return this.b_String;
   }

   public final boolean d() {
      return this.a_File_5 != null || this.a_arr_byte_4 != null;
   }

   @Override
   public final Icon a_Icon_2() {
      return !this.d() ? C_bo.e() : null;
   }
}
