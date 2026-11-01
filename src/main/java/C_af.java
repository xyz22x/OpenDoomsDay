import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_af implements ActionListener {
   private VersionTabPanel a_u;
   private final DoomsdayGUI a_a_1;

   C_af(VersionTabPanel var1, DoomsdayGUI var2) {
      this.a_u = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_a_1.a_au_9.a(VersionTabPanel.a(this.a_u.b_JComboBox_1.getSelectedIndex()));
   }
}
