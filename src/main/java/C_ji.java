import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

final class C_ji implements ActionListener {
   private final JDialog a;

   C_ji(JDialog var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.dispose();
   }
}
