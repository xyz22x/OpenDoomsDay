import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

final class C_dh implements MouseListener {
   private final JButton a;

   C_dh(JButton var1) {
      this.a = var1;
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
      this.a.setIcon(C_bo.l());
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
      this.a.setIcon(C_bo.m());
   }

   @Override
   public final void mouseClicked(MouseEvent var1) {
   }
}
