import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_co implements ActionListener {
   private AdvancedSettingsPanel a;

   C_co(AdvancedSettingsPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.a("--silentnatives=", this.a.d_JCheckBox_1.isSelected() ? "true" : "");
   }
}
