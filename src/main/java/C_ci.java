import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_ci implements ActionListener {
   private AdvancedSettingsPanel a;

   C_ci(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      if (this.a.a_JComboBox_1.getSelectedIndex() == 0) {
         this.a.a("--naming=", "");
      } else {
         this.a.a("--naming=", String.valueOf(this.a.a_JComboBox_1.getSelectedIndex()));
      }
   }
}
