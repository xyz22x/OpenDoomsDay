import javax.swing.JDialog;
import javax.swing.SwingUtilities;

final class C_jg extends Thread {
   private final JDialog a;

   C_jg(JDialog var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         Thread.sleep(0L);
         SwingUtilities.invokeLater(new C_jh(this.a));
      } catch (Throwable var1) {
      }
   }
}
