import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_ft implements ActionListener {
   private final DoomsdayGUI a;

   C_ft(DoomsdayGUI var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.setContentPane(this.a.a_ex_10);
      this.a.invalidate();
      this.a.validate();
   }
}
