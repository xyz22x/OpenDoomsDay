final class C_cx extends C_ga {
   private ProcessSelectPanel a_cw;
   private final DoomsdayGUI a_a_1;

   C_cx(ProcessSelectPanel var1, DoomsdayGUI var2) {
      this.a_cw = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void a() {
      if (this.a_cw.a_aq_1.a_JTextField.getText().equals(GamePathUtils.b())) {
         this.a_a_1.a_au_9.i("$default$");
      } else {
         this.a_a_1.a_au_9.i(this.a_cw.a_aq_1.a_JTextField.getText());
      }

      this.a_cw.a_void_2();
   }
}
