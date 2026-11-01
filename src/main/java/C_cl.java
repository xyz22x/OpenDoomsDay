import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_cl implements ActionListener {
   private AdvancedSettingsPanel a;

   C_cl(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.a("--jvmtigetmethod=", this.a.a_JCheckBox_3.isSelected() ? "true" : "");
   }
}
