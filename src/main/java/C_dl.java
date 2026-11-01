import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_dl implements ActionListener {
   private ProcessSelectPanel a;

   C_dl(ProcessSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      if (this.a.b_JComboBox.getSelectedIndex() == 0) {
         this.a.b_aq_2.a(GamePathUtils.d());
         this.a.b_aq_2.setEnabled(false);
      } else {
         this.a.b_aq_2.setEnabled(true);
      }
   }
}
