import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_ey implements ActionListener {
   private final DoomsdayGUI a;

   C_ey(DoomsdayGUI var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.setContentPane(this.a.a_fr_11);
      this.a.invalidate();
      this.a.validate();
   }
}
