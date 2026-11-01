import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_cg implements ActionListener {
   private AdvancedSettingsPanel a;

   C_cg(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      if (this.a.c_JComboBox_2.getSelectedIndex() == 0) {
         this.a.a("--clickguikey=", "");
      } else {
         this.a.a("--clickguikey=", this.a.c_JComboBox_2.getSelectedItem().toString());
      }
   }
}
