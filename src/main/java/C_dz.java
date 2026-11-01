import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

final class C_dz extends MouseAdapter {
   private C_dy a;

   C_dz(C_dy var1) {
      this.a = var1;
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
      if (this.a.contains(var1.getX(), var1.getY())) {
         C_dy.a(this.a, true);
         this.a.repaint();
      }
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
      C_dy.a(this.a);
      C_dy.a(this.a, false);
      this.a.repaint();
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
      C_dy.b(this.a, false);
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
      C_dy.b(this.a, true);
   }
}
