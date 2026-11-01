import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_ei implements ActionListener {
   private MainContentPanel a_eg;
   private final DoomsdayGUI a_a_1;

   C_ei(MainContentPanel var1, DoomsdayGUI var2) {
      this.a_eg = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_a_1.a_au_9.c(this.a_eg.a_JCheckBox_1.isSelected());
   }
}
