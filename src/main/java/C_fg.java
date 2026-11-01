import javax.swing.BorderFactory;
import javax.swing.JButton;

final class C_fg extends JButton {
   private C_fg() {
      this.setOpaque(false);
      this.setFocusable(false);
      this.setFocusPainted(false);
      this.setBorderPainted(false);
      this.setBorder(BorderFactory.createEmptyBorder());
   }

   C_fg(byte var1) {
      this();
   }
}
