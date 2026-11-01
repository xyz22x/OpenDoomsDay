import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

final class C_ff extends BasicScrollBarUI {
   private UITheme a;

   public C_ff(UITheme var1) {
      this.a = var1;
   }

   @Override
   protected final JButton createDecreaseButton(int var1) {
      return new C_fg((byte)0);
   }

   @Override
   protected final JButton createIncreaseButton(int var1) {
      return new C_fg((byte)0);
   }

   @Override
   protected final void paintTrack(Graphics var1, JComponent var2, Rectangle var3) {
   }

   @Override
   protected final void paintThumb(Graphics var1, JComponent var2, Rectangle var3) {
      int var9 = this.isThumbRollover() ? this.a.a_int_1 : this.a.b;
      int var4 = this.scrollbar.getOrientation();
      int var5 = var3.x;
      int var6 = var3.y;
      int var7 = Math.max(var4 == 1 ? this.a.c : var3.width, this.a.c);
      int var10 = Math.max(var4 == 1 ? var3.height : this.a.c, this.a.c);
      if (var4 != 1 || this.a.a_Component.getHeight() > this.a.getHeight()) {
         if (var4 != 0 || this.a.a_Component.getWidth() > this.a.getWidth()) {
            Graphics2D var8;
            (var8 = (Graphics2D)var1.create()).setColor(new Color(this.thumbColor.getRed(), this.thumbColor.getGreen(), this.thumbColor.getBlue(), var9));
            var8.fillRect(var5, var6, var7, var10);
            var8.dispose();
         }
      }
   }

   @Override
   protected final void setThumbBounds(int var1, int var2, int var3, int var4) {
      super.setThumbBounds(var1, var2, var3, var4);
      this.a.repaint();
   }
}
