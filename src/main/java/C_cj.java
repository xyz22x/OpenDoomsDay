final class C_cj extends C_ga {
   private AdvancedSettingsPanel a;

   C_cj(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a() {
      this.a.a("--classprefix=", FileUtils.a(this.a.a_JTextField_2.getText()));
   }
}
