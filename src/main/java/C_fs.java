import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

final class C_fs implements MouseListener {
   private boolean a_bool;
   private boolean b_bool;
   private final JButton a_JButton_1;
   private final ImageIcon a_ImageIcon_2;
   private final ImageIcon b_ImageIcon_1;
   private final ImageIcon c;

   C_fs(JButton var1, ImageIcon var2, ImageIcon var3, ImageIcon var4) {
      this.a_JButton_1 = var1;
      this.a_ImageIcon_2 = var2;
      this.b_ImageIcon_1 = var3;
      this.c = var4;
   }

   private void a() {
      if (this.a_bool) {
         this.a_JButton_1.setIcon(this.a_ImageIcon_2);
      } else if (this.b_bool) {
         this.a_JButton_1.setIcon(this.b_ImageIcon_1);
      } else {
         this.a_JButton_1.setIcon(this.c);
      }
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
      this.a_bool = false;
      this.b_bool = false;
      this.a();
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
      this.a_bool = true;
      this.a();
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
      this.b_bool = false;
      this.a();
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
      this.b_bool = true;
      this.a();
   }

   @Override
   public final void mouseClicked(MouseEvent var1) {
   }
}
