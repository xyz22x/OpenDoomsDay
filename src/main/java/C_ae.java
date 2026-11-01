import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_ae implements ActionListener {
   private VersionTabPanel a_u;
   private final DoomsdayGUI a_a_1;

   C_ae(VersionTabPanel var1, DoomsdayGUI var2) {
      this.a_u = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      if (this.a_u.c.getItemCount() > 0) {
         if (this.a_u.c.getSelectedIndex() != 0 && this.a_u.c.getSelectedItem() != null) {
            this.a_a_1.a_au_9.g(this.a_u.c.getSelectedItem().toString());
         } else {
            this.a_a_1.a_au_9.g("$latest$");
         }
      } else {
         this.a_a_1.a_au_9.g("$latest$");
      }
   }
}
