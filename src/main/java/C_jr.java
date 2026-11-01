import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;

final class C_jr implements MouseListener {
   private final JComboBox a_JComboBox;
   private final C_ea a_ea_1;

   C_jr(JComboBox var1, C_ea var2) {
      this.a_JComboBox = var1;
      this.a_ea_1 = var2;
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
      this.a_JComboBox.setBackground(DoomsdayGUI.e_Color_2);
      this.a_ea_1.a().a().repaint();
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
      this.a_JComboBox.setBackground(DoomsdayGUI.f_Color_2);
      this.a_ea_1.a().a().repaint();
   }

   @Override
   public final void mouseClicked(MouseEvent var1) {
   }
}
