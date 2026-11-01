import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

final class C_jn implements WindowListener {
   private final ClientConfig a;

   C_jn(ClientConfig var1) {
      this.a = var1;
   }

   @Override
   public final void windowOpened(WindowEvent var1) {
   }

   @Override
   public final void windowIconified(WindowEvent var1) {
   }

   @Override
   public final void windowDeiconified(WindowEvent var1) {
   }

   @Override
   public final void windowDeactivated(WindowEvent var1) {
   }

   @Override
   public final void windowClosing(WindowEvent var1) {
      if (this.a.a_Boolean()) {
         C_jo var2;
         (var2 = new C_jo(this.a)).setDaemon(false);
         var2.start();
      } else {
         System.exit(0);
      }
   }

   @Override
   public final void windowClosed(WindowEvent var1) {
   }

   @Override
   public final void windowActivated(WindowEvent var1) {
   }
}
