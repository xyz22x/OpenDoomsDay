import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

final class C_ce implements ActionListener {
   private final JComboBox a_JComboBox;
   private final DoomsdayGUI a_a_1;

   C_ce(JComboBox var1, DoomsdayGUI var2) {
      this.a_JComboBox = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      int var2;
      if ((var2 = this.a_JComboBox.getSelectedIndex()) < 0) {
         var2 = 0;
      }

      this.a_a_1.a_au_9.e(ClientConfig.a(var2));
   }
}
