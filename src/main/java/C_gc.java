import java.awt.Dimension;
import javax.swing.JPanel;

final class C_gc implements Runnable {
   private final C_hg a;

   C_gc(C_hg var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      JPanel var1 = this.a.c;
      if (this.a.a_gg.a_dbl_2 == -1.0) {
         var1.setPreferredSize(new Dimension(0, 1));
      } else {
         var1.setPreferredSize(new Dimension((int)(var1.getParent().getWidth() * this.a.a_gg.a_dbl_2), 1));
      }

      var1.getParent().repaint();
      var1.revalidate();
   }
}
