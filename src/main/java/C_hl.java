public final class C_hl {
   public int a_int = 0;
   public Object a_Object_1 = null;

   public C_hl(int var1, Object var2) {
      this.a_int = var1;
      this.a_Object_1 = var2;
   }

   @Override
   public final String toString() {
      StringBuffer var1 = new StringBuffer();
      if (this.a_int == 0) {
         var1.append("VALUE(").append(this.a_Object_1).append(")");
      } else if (this.a_int == 1) {
         var1.append("LEFT BRACE({)");
      } else if (this.a_int == 2) {
         var1.append("RIGHT BRACE(})");
      } else if (this.a_int == 3) {
         var1.append("LEFT SQUARE([)");
      } else if (this.a_int == 4) {
         var1.append("RIGHT SQUARE(])");
      } else if (this.a_int == 5) {
         var1.append("COMMA(,)");
      } else if (this.a_int == 6) {
         var1.append("COLON(:)");
      } else if (this.a_int == -1) {
         var1.append("END OF FILE");
      }

      return var1.toString();
   }
}
