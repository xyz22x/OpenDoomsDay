import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

final class C_di implements MouseListener {
   private boolean a_bool;
   private ProcessSelectPanel a_cw_1;
   private final DoomsdayGUI a_a_2;
   private final JLabel a_JLabel_3;

   C_di(ProcessSelectPanel var1, DoomsdayGUI var2, JLabel var3) {
      this.a_cw_1 = var1;
      this.a_a_2 = var2;
      this.a_JLabel_3 = var3;
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
      if (!this.a_cw_1.a_JPanel_5.isVisible()) {
         this.a_cw_1.a_JPanel_5.setVisible(true);
         this.a_a_2.a_au_9.g(true);
      } else {
         this.a_cw_1.a_JPanel_5.setVisible(false);
         this.a_a_2.a_au_9.g(false);
      }

      this.a();
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
   }

   private void a() {
      if (this.a_cw_1.a_JPanel_5.isVisible()) {
         if (this.a_bool) {
            this.a_cw_1.a_JLabel_4.setIcon(C_bo.f);
         } else {
            this.a_cw_1.a_JLabel_4.setIcon(C_bo.e);
         }
      } else if (this.a_bool) {
         this.a_cw_1.a_JLabel_4.setIcon(C_bo.g);
      } else {
         this.a_cw_1.a_JLabel_4.setIcon(C_bo.d);
      }
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
      this.a_bool = false;
      this.a();
      this.a_JLabel_3.setForeground(this.a_a_2.g_Color_2);
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
      this.a_bool = true;
      this.a();
      this.a_JLabel_3.setForeground(this.a_a_2.h_Color_2);
   }

   @Override
   public final void mouseClicked(MouseEvent var1) {
   }
}
