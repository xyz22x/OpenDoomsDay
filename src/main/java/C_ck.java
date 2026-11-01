final class C_ck extends C_ga {
   private AdvancedSettingsPanel a;

   C_ck(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a() {
      this.a.a("--classpostfix=", FileUtils.a(this.a.b_JTextField.getText()));
   }
}
