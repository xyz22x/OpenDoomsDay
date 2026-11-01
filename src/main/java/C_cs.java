import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import javax.swing.JLabel;

final class C_cs implements MouseListener {
   private final StringBuilder a_StringBuilder;
   private final Font a_Font_1;
   private final Font b;
   private final JLabel a_JLabel_2;

   C_cs(StringBuilder var1, Font var2, Font var3, JLabel var4) {
      this.a_StringBuilder = var1;
      this.a_Font_1 = var2;
      this.b = var3;
      this.a_JLabel_2 = var4;
   }

   @Override
   public final void mouseClicked(MouseEvent var1) {
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
      try {
         Desktop.getDesktop().browse(new URI("http://" + this.a_StringBuilder.toString()));
      } catch (Throwable var2) {
         var2.printStackTrace();
      }
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
      if (this.a_Font_1 == this.b) {
         this.a_JLabel_2.setForeground(new Color(124, 180, 255));
      } else {
         this.a_JLabel_2.setFont(this.a_Font_1);
      }
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
      if (this.a_Font_1 == this.b) {
         this.a_JLabel_2.setForeground(new Color(144, 220, 255));
      } else {
         this.a_JLabel_2.setFont(this.b);
      }
   }
}
