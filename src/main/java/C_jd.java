import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

final class C_jd implements ActionListener {
   private final JDialog a_JDialog;
   private final ActionListener a_ActionListener_1;

   C_jd(JDialog var1, ActionListener var2) {
      this.a_JDialog = var1;
      this.a_ActionListener_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_JDialog.dispose();
      if (this.a_ActionListener_1 != null) {
         this.a_ActionListener_1.actionPerformed(var1);
      }
   }
}
