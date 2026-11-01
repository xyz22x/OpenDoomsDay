import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

final class C_fu implements ActionListener {
   private ProcessTabPanel a;

   C_fu(ProcessTabPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.a_dy.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 100, 255)));
      this.a.b.setBorder(BorderFactory.createEmptyBorder());
      this.a.remove(this.a.a_eg_2);
      this.a.add(this.a.a_cd_1, "Center");
      this.a.repaint();
   }
}
