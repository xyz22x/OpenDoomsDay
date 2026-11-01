import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_ej implements ActionListener {
   private MainContentPanel a_eg;
   private final DoomsdayGUI a_a_1;

   C_ej(MainContentPanel var1, DoomsdayGUI var2) {
      this.a_eg = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_a_1.a_au_9.e(this.a_eg.b_JCheckBox.isSelected());
   }
}
