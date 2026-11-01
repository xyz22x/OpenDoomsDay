final class C_q implements Runnable {
   private ShellcodeInjectTask a;

   C_q(ShellcodeInjectTask var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      ShellcodeInjectTask.a(this.a).a_u.a_dy_6.setEnabled(ShellcodeInjectTask.a(this.a).a_u.a_JTextField_8.getText().length() > 0);
      ShellcodeInjectTask.a(this.a).a_u.b_dy.setEnabled(ShellcodeInjectTask.a(this.a).a_u.a_JTextField_8.getText().length() > 0);
      ShellcodeInjectTask.a(this.a).a_u.a_a_9.a_ex_10.a_cr_1.a_dy_1.setEnabled(DoomsdayGUI.a_bool_5());
   }
}
