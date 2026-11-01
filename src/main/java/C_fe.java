import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
import javax.swing.Scrollable;
import javax.swing.border.Border;

final class C_fe extends ScrollPaneLayout {
   private UITheme a;

   C_fe(UITheme var1) {
      this.a = var1;
   }

   @Override
   public final void layoutContainer(Container var1) {
      JScrollPane var2 = (JScrollPane)var1;
      this.vsbPolicy = var2.getVerticalScrollBarPolicy();
      this.hsbPolicy = var2.getHorizontalScrollBarPolicy();
      Rectangle var3;
      Rectangle var10000 = var3 = ((JScrollPane)var1).getBounds();
      var10000.x = var10000.y = 0;
      Insets var4 = var1.getInsets();
      var3.x = var4.left;
      var3.y = var4.top;
      var3.width = var3.width - (var4.left + var4.right);
      var3.height = var3.height - (var4.top + var4.bottom);
      boolean var12 = var2.getComponentOrientation().isLeftToRight();
      Rectangle var5 = new Rectangle(0, var3.y, 0, 0);
      if (this.colHead != null && this.colHead.isVisible()) {
         int var6 = Math.min(var3.height, this.colHead.getPreferredSize().height);
         var5.height = var6;
         var3.y += var6;
         var3.height -= var6;
      }

      Rectangle var15 = new Rectangle(0, 0, 0, 0);
      if (this.rowHead != null && this.rowHead.isVisible()) {
         int var7 = Math.min(var3.width, this.rowHead.getPreferredSize().width);
         var15.width = var7;
         var3.width -= var7;
         if (var12) {
            var15.x = var3.x;
            var3.x += var7;
         } else {
            var15.x = var3.x + var3.width;
         }
      }

      Insets var8;
      Border var16;
      if ((var16 = var2.getViewportBorder()) != null) {
         var8 = var16.getBorderInsets(var1);
         var3.x = var3.x + var8.left;
         var3.y = var3.y + var8.top;
         var3.width = var3.width - (var8.left + var8.right);
         var3.height = var3.height - (var8.top + var8.bottom);
      } else {
         var8 = new Insets(0, 0, 0, 0);
      }

      if (this.viewport != null) {
         this.viewport.setBounds(var3);
      }

      Component var9;
      if ((var9 = this.viewport != null ? this.viewport.getView() : null) != null) {
         var9.getPreferredSize();
      } else {
         new Dimension(0, 0);
      }

      if (this.viewport != null) {
         this.viewport.toViewCoordinates(var3.getSize());
      } else {
         new Dimension(0, 0);
      }

      if (var3.width >= 0 && var3.height >= 0 && var9 instanceof Scrollable) {
         Scrollable var10;
         (var10 = (Scrollable)var9).getScrollableTracksViewportWidth();
         var10.getScrollableTracksViewportHeight();
      }

      boolean var11 = UITheme.a(this.a);
      boolean var13 = UITheme.b(this.a);
      Rectangle var17;
      (var17 = new Rectangle()).width = this.a.d;
      var17.height = var3.height - (var13 ? var17.width : 0);
      var17.x = var3.x + var3.width - var17.width;
      var17.y = var3.y;
      if (this.vsb != null) {
         this.vsb.setBounds(var17);
      }

      Rectangle var14;
      (var14 = new Rectangle()).height = this.a.d;
      var14.width = var3.width - (var11 ? var14.height : 0);
      var14.x = var3.x;
      var14.y = var3.y + var3.height - var14.height;
      if (this.hsb != null) {
         this.hsb.setBounds(var14);
      }

      var17.height = var3.height + var8.top + var8.bottom;
      var14.width = var3.width + var8.left + var8.right;
      var15.height = var3.height + var8.top + var8.bottom;
      var15.y = var3.y - var8.top;
      var5.width = var3.width + var8.left + var8.right;
      var5.x = var3.x - var8.left;
      if (this.rowHead != null) {
         this.rowHead.setBounds(var15);
      }

      if (this.colHead != null) {
         this.colHead.setBounds(var5);
      }
   }
}
