import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

final class C_ja extends MouseAdapter {
   private final C_ea a;

   C_ja(C_ea var1) {
      this.a = var1;
   }

   @Override
   public final void mouseMoved(MouseEvent var1) {
      Point var2 = new Point(var1.getX(), var1.getY());
      int var3;
      if ((var3 = this.a.a_JList_3().locationToIndex(var2)) != this.a.a) {
         this.a.a = var3;
         this.a.a_JList_3().repaint();
      }
   }
}
