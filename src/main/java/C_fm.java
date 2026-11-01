public final class C_fm extends RuntimeException {
   private int a_int;
   private Object a_Object_1;
   private int b;

   public C_fm(int var1, int var2, Object var3) {
      this.b = var1;
      this.a_int = var2;
      this.a_Object_1 = var3;
   }

   @Override
   public final String getMessage() {
      StringBuffer var1 = new StringBuffer();
      if (this.a_int == 0) {
         var1.append("Unexpected character (").append(this.a_Object_1).append(") at position ").append(this.b).append(".");
      } else if (this.a_int == 1) {
         var1.append("Unexpected token ").append(this.a_Object_1).append(" at position ").append(this.b).append(".");
      } else if (this.a_int == 2) {
         var1.append("Unexpected exception at position ").append(this.b).append(": ").append(this.a_Object_1);
      } else {
         var1.append("Unkown error at position ").append(this.b).append(".");
      }

      return var1.toString();
   }
}
