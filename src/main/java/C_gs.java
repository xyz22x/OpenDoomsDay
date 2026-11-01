import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

final class C_gs implements ActionListener {
   private final DoomsdayGUI a_a;
   private final JCheckBox a_JCheckBox_1;

   C_gs(DoomsdayGUI var1, JCheckBox var2) {
      this.a_a = var1;
      this.a_JCheckBox_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_a.a_au_9.b(this.a_JCheckBox_1.isSelected());
   }
}
