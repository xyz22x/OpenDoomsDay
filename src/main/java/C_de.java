import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_de implements ActionListener {
   private ProcessSelectPanel a_cw;
   private final DoomsdayGUI a_a_1;

   C_de(ProcessSelectPanel var1, DoomsdayGUI var2) {
      this.a_cw = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_a_1.a_au_9.f(this.a_cw.a_JCheckBox_6.isSelected());
      this.a_cw.a_void_2();
   }
}
