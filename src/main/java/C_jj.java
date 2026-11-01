import javax.swing.JDialog;

final class C_jj implements Runnable {
   private DoomsdayGUI a_a;
   private final JDialog a_JDialog_1;

   C_jj(DoomsdayGUI var1, JDialog var2) {
      this.a_a = var1;
      this.a_JDialog_1 = var2;
   }

   @Override
   public final void run() {
      DoomsdayGUI.a(this.a_a.a_int_2(), this.a_JDialog_1);
   }
}
