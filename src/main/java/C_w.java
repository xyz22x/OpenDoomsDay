import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

final class C_w implements MouseListener {
   private VersionTabPanel a_u;
   private final C_i a_i_1;

   C_w(VersionTabPanel var1, C_i var2) {
      this.a_u = var1;
      this.a_i_1 = var2;
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
      if (this.a_u.a_dy_6.isEnabled()) {
         this.a_i_1.actionPerformed(null);
      }
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
   }

   @Override
   public final void mouseClicked(MouseEvent var1) {
   }
}
