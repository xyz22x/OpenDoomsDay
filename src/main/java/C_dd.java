final class C_dd implements Runnable {
   private ProcessSelectPanel a;

   C_dd(ProcessSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      if (this.a.a_aq_1.a_JTextField.getText().length() == 0) {
         this.a.a_aq_1.a(GamePathUtils.b());
      }
   }
}
