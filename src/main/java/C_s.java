final class C_s implements Runnable {
   private C_r a;

   C_s(C_r var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      C_r.a(this.a).a_u.a_dy_6.setEnabled(C_r.a(this.a).a_u.a_JTextField_8.getText().length() > 0);
      C_r.a(this.a).a_u.b_dy.setEnabled(C_r.a(this.a).a_u.a_JTextField_8.getText().length() > 0);
      C_r.a(this.a).a_u.a_a_9.a_ex_10.a_cr_1.a_dy_1.setEnabled(DoomsdayGUI.a_bool_5());
   }
}
