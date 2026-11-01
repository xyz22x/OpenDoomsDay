import java.awt.KeyboardFocusManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

final class C_jc implements MouseListener {
   @Override
   public final void mouseReleased(MouseEvent var1) {
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
      if (KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() != var1.getComponent()) {
         if (!DoomsdayGUI.a_a_3.isFocused()) {
            DoomsdayGUI.a_a_3.dispatchEvent(new WindowEvent(DoomsdayGUI.a_a_3, 207));
         }

         var1.getComponent().requestFocus();
      }
   }
}
