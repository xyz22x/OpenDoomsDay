import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_em implements ActionListener {
   private MainContentPanel a;

   C_em(MainContentPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      DoomsdayGUI.a_a_3.a_ex_10.a_cr_1.a_dy_1.setEnabled(true);
      this.a.b_JTextField_1.setEditable(this.a.e.isSelected());
   }
}
