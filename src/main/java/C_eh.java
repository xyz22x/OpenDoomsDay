final class C_eh extends C_ga {
   private MainContentPanel a_eg;
   private final DoomsdayGUI a_a_1;

   C_eh(MainContentPanel var1, DoomsdayGUI var2) {
      this.a_eg = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void a() {
      this.a_a_1.a_au_9.c(this.a_eg.a_JTextField.getText());
      if (!DoomsdayGUI.b_bool_1) {
         this.a_a_1.setTitle(this.a_eg.a_JTextField.getText());
      }
   }
}
