final class C_f extends Thread {
   private C_c a;

   C_f(C_c var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      C_c.a(this.a.a_au_1);
   }
}
