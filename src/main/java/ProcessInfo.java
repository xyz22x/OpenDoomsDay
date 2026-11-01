public abstract class ProcessInfo {
   public final int b_int;
   private int a_int;
   public final String a_String_1;
   public final long a_long_2;
   public final String b_String_1;
   public String c;
   public boolean a_bool_3;

   public ProcessInfo(int var1, int var2, String var3, String var4, long var5, String var7) {
      this.b_int = var1;
      this.a_int = var2;
      this.a_String_1 = var3;
      this.b_String_1 = var4;
      this.a_long_2 = var5;
      this.c = var7;
   }

   @Override
   public int hashCode() {
      return this.b_int;
   }

   public final String a_String() {
      String var1;
      return (var1 = NativeBinaryManager.a_String(this.a_int)).equals("?") ? "" : var1;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 == null) {
         return false;
      } else if (this.getClass() != var1.getClass()) {
         return false;
      } else {
         var1 = var1;
         return this.b_int == ((ProcessInfo)var1).b_int;
      }
   }
}
