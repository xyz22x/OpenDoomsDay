final class C_cf extends C_ga {
   private AdvancedSettingsPanel a;

   C_cf(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a() {
      this.a.a("--classloader=", FileUtils.a(this.a.c_JTextField_1.getText()));
   }
}
