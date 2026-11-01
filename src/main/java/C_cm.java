import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_cm implements ActionListener {
   private AdvancedSettingsPanel a;

   C_cm(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.a("--jvmtigetfield=", this.a.b_JCheckBox_1.isSelected() ? "true" : "");
   }
}
