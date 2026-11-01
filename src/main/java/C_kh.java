import java.util.NoSuchElementException;
import java.util.Set;

public final class C_kh {
   private static final ProcessEntry[] a_arr_kc = new ProcessEntry[0];
   private String a_String_1;
   private String b_String;
   public final int a_int_2;
   private ProcessEntry[] b_arr_kc_1;

   C_kh(String var1, String var2, int var3, Set var4) {
      this.a_String_1 = var1;
      this.b_String = var2;
      this.a_int_2 = var3;
      this.b_arr_kc_1 = var4 == null ? a_arr_kc : (ProcessEntry[])var4.toArray(new ProcessEntry[0]);
   }

   public final ProcessEntry a(String var1) {
      ProcessEntry[] var5 = this.b_arr_kc_1;
      int var4 = this.b_arr_kc_1.length;

      for (int var3 = 0; var3 < var4; var3++) {
         ProcessEntry var2;
         if ((var2 = var5[var3]).a_String.equals(var1)) {
            return var2;
         }
      }

      throw new NoSuchElementException("No such field: ".concat(String.valueOf(var1)));
   }

   public final long a_long(String var1) {
      ProcessEntry var2;
      if (!(var2 = this.a(var1)).a_bool_2) {
         return var2.a_long_1;
      } else {
         throw new IllegalArgumentException("Instance field expected");
      }
   }

   @Override
   public final String toString() {
      StringBuilder var1 = new StringBuilder(this.a_String_1);
      if (this.b_String != null) {
         var1.append(" extends ").append(this.b_String);
      }

      var1.append(" @ ").append(this.a_int_2).append('\n');

      for (ProcessEntry var2 : this.b_arr_kc_1) {
         var1.append("  ").append(var2).append('\n');
      }

      return var1.toString();
   }
}
