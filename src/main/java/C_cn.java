import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_cn implements ActionListener {
   private AdvancedSettingsPanel a;

   C_cn(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.a("--findfrombootstrap=", this.a.c_JCheckBox.isSelected() ? "true" : "");
   }
}
