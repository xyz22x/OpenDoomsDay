final class C_bv implements Runnable {
   private final VersionTabPanel a;

   C_bv(VersionTabPanel var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      this.a.a_dy_6.setEnabled(this.a.a_JTextField_8.getText().length() > 0);
      this.a.b_dy.setEnabled(this.a.a_JTextField_8.getText().length() > 0);
      this.a.a_a_9.a_ex_10.a_cr_1.a_dy_1.setEnabled(DoomsdayGUI.a_bool_5());
   }
}
