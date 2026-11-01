import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_ek implements ActionListener {
   private MainContentPanel a_eg;
   private final DoomsdayGUI a_a_1;

   C_ek(MainContentPanel var1, DoomsdayGUI var2) {
      this.a_eg = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_a_1.a_au_9.a(Boolean.valueOf(this.a_eg.c.isSelected()));
      this.a_a_1.a_au_9.j_bool();
   }
}
