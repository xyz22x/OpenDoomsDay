import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

public final class C_t implements ActionListener {
   private SettingsTabPanel a;

   public C_t(SettingsTabPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.c.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 100, 255)));
      this.a.a_dy.setBorder(BorderFactory.createEmptyBorder());
      this.a.d.setBorder(BorderFactory.createEmptyBorder());
      this.a.b.setBorder(BorderFactory.createEmptyBorder());
      this.a.remove(this.a.a_cw_3);
      this.a.remove(this.a.a_gp_4);
      this.a.remove(this.a.a_cr_1);
      this.a.add(this.a.a_u_2, "Center");
      this.a.repaint();
      this.a.a_a_5.a_au_9.d("advinject");
   }
}
