public final class TargetProcess {
   public final int a_int;
   private String a_String_1;
   private String b;

   public TargetProcess(int var1, String var2, String var3) {
      this.a_int = var1;
      this.a_String_1 = var2;
      this.b = var3;
   }

   @Override
   public final String toString() {
      String var1 = "";
      if (this.a_String_1 != null) {
         var1 = var1 + this.a_String_1;
      }

      if (this.a_String_1 != null && this.b != null) {
         var1 = var1 + " - ";
      }

      if (this.b != null) {
         var1 = var1 + this.b;
      }

      return var1;
   }
}
