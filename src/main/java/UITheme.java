import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public final class UITheme extends JScrollPane {
   protected Component a_Component;
   protected int a_int_1 = 100;
   protected int b = 50;
   protected int c = 8;
   protected int d = 10;

   public UITheme() {
   }

   public UITheme(Component var1) {
      this(var1, (byte)0);
   }

   public final void a(Component var1) {
      this.b(var1);
   }

   private void b(Component var1) {
      this.a_Component = var1;
      this.setBorder(null);
      this.setViewport(this.createViewport());
      this.setVerticalScrollBar(this.createVerticalScrollBar());
      this.setHorizontalScrollBar(this.createHorizontalScrollBar());
      JScrollBar var2;
      (var2 = this.getVerticalScrollBar()).setOpaque(false);
      var2.setUI(new C_ff(this));
      (var2 = this.getHorizontalScrollBar()).setOpaque(false);
      var2.setUI(new C_ff(this));
      this.setLayout(new C_fe(this));
      this.setComponentZOrder(this.getVerticalScrollBar(), 0);
      this.setComponentZOrder(this.getHorizontalScrollBar(), 1);
      this.setComponentZOrder(this.getViewport(), 2);
      this.viewport.setView(var1);
   }

   public UITheme(Component var1, byte var2) {
      this.b(var1);
   }

   static boolean a(UITheme var0) {
      Rectangle var1 = var0.viewport.getViewRect();
      return var0.viewport.getViewSize().getHeight() > var1.getHeight();
   }

   static boolean b(UITheme var0) {
      Rectangle var1 = var0.viewport.getViewRect();
      return var0.viewport.getViewSize().getWidth() > var1.getWidth();
   }
}
