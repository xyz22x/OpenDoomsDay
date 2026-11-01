import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_dc implements ActionListener {
   private ProcessSelectPanel a_cw;
   private final DoomsdayGUI a_a_1;

   C_dc(ProcessSelectPanel var1, DoomsdayGUI var2) {
      this.a_cw = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      if (this.a_cw.d_JComboBox.getItemCount() > 0) {
         if (this.a_cw.d_JComboBox.getSelectedIndex() != 0 && this.a_cw.d_JComboBox.getSelectedItem() != null) {
            this.a_a_1.a_au_9.h(this.a_cw.d_JComboBox.getSelectedItem().toString());
         } else {
            this.a_a_1.a_au_9.h("$latest$");
         }
      } else {
         this.a_a_1.a_au_9.h("$latest$");
      }
   }
}
