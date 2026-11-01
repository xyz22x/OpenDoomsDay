import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

final class C_ez implements MouseListener {
   private boolean a_bool;
   private boolean b;
   private SettingsTabPanel a_ex_1;

   C_ez(SettingsTabPanel var1) {
      this.a_ex_1 = var1;
   }

   private void a() {
      if (this.a_bool) {
         this.a_ex_1.a_JButton_6.setIcon(C_bo.c);
      } else if (this.b) {
         this.a_ex_1.a_JButton_6.setIcon(C_bo.b);
      } else {
         this.a_ex_1.a_JButton_6.setIcon(C_bo.a);
      }
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
      this.a_bool = false;
      this.b = false;
      this.a();
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
      this.a_bool = true;
      this.a();
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
      this.b = false;
      this.a();
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
      this.b = true;
      this.a();
   }

   @Override
   public final void mouseClicked(MouseEvent var1) {
   }
}
