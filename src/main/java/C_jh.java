import javax.swing.JDialog;

final class C_jh implements Runnable {
   private final JDialog a;

   C_jh(JDialog var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      this.a.setVisible(false);
   }
}
