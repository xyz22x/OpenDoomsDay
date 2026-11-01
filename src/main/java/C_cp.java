import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_cp implements ActionListener {
   private AdvancedSettingsPanel a;

   C_cp(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      if (this.a.b_JComboBox_2.getSelectedIndex() == 0) {
         this.a.a("--defineclassfunction=", "");
      } else {
         this.a.a("--defineclassfunction=", this.a.b_JComboBox_2.getSelectedItem().toString());
      }
   }
}
