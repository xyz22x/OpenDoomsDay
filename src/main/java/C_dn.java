final class C_dn {
   public C_dt a_dt;
   public String a_String_1;

   public C_dn(C_dt var1) {
      this.a_dt = var1;
      this.a_String_1 = (String)var1.get("id");
   }

   @Override
   public final String toString() {
      return this.a_String_1;
   }
}
