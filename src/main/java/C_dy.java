import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;

public final class C_dy extends JButton {
   private Color k = Color.magenta;
   public Color a_Color = new Color(0, 153, 153);
   public Color b_Color = Color.GREEN;
   public Color c_Color = Color.magenta;
   public Color d_Color = new Color(0, 153, 153);
   public Color e_Color = Color.GREEN;
   public Color f = new Color(255, 0, 255);
   public Color g = Color.green;
   private Color l = Color.white;
   public Color h = Color.magenta;
   private boolean a_bool_1 = true;
   public int a_int_2 = 10;
   private boolean b_bool_1 = false;
   private boolean c_bool_1 = false;
   private boolean d_bool_1 = false;
   private boolean e_bool_1 = true;
   private Color m = Color.white;
   public Color i = Color.gray;
   private Color n = Color.magenta;
   public Color j = Color.LIGHT_GRAY;

   public C_dy() {
      this.setPreferredSize(new Dimension(115, 35));
      this.setForeground(Color.white);
      C_dz var1 = new C_dz(this);
      this.addMouseListener(var1);
   }

   @Override
   protected final void paintComponent(Graphics var1) {
      super.paintComponent(var1);
      super.setContentAreaFilled(false);
      Graphics2D var2 = (Graphics2D)var1.create();
      Graphics2D var3;
      (var3 = (Graphics2D)var1).setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      var3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      var3.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
      var2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      var2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      var2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
      if (this.d_bool_1) {
         var2.setPaint(this.j);
      } else if (this.a_bool_1) {
         if (this.isEnabled()) {
            GradientPaint var13 = new GradientPaint(this.getWidth() / 2, 0.0F, this.a_Color, this.getWidth() / 2, this.getHeight(), this.b_Color);
            var2.setPaint(var13);
            this.setForeground(this.m);
            if (this.c_bool_1) {
               GradientPaint var14 = new GradientPaint(this.getWidth() / 2, 0.0F, this.f, this.getWidth() / 2, this.getHeight(), this.g);
               var2.setPaint(var14);
               this.setForeground(this.h);
            } else if (this.b_bool_1) {
               GradientPaint var15 = new GradientPaint(this.getWidth() / 2, 0.0F, this.a_Color, this.getWidth() / 2, this.getHeight(), this.b_Color);
               var2.setPaint(var15);
               this.setForeground(this.m);
            }
         } else {
            GradientPaint var16 = new GradientPaint(this.getWidth() / 2, 0.0F, this.d_Color, this.getWidth() / 2, this.getHeight(), this.e_Color);
            var2.setPaint(var16);
            this.setForeground(this.i);
         }
      } else if (this.isEnabled()) {
         if (this.c_bool_1) {
            var2.setPaint(this.l);
            var2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.a_int_2, this.a_int_2);
            this.setForeground(this.h);
         } else if (this.b_bool_1) {
            var2.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, this.a_int_2, this.a_int_2);
            var2.setPaint(this.k);
            this.setForeground(this.m);
         } else {
            var2.setPaint(this.k);
         }
      } else {
         var2.setPaint(this.c_Color);
         this.setForeground(this.i);
      }

      if (this.isSelected()) {
         var2.setPaint(this.n);
         this.setForeground(this.m);
      }

      if (this.e_bool_1) {
         var2.fillRoundRect(0, 0, this.getWidth(), this.getHeight(), this.a_int_2, this.a_int_2);
      }

      var2.drawRoundRect(0, 0, this.getWidth() - 1, this.getHeight() - 1, this.a_int_2, this.a_int_2);
      var2.setPaint(Color.BLACK);
      Rectangle var10001 = new Rectangle(this.getWidth(), this.getHeight());
      Font var6 = this.getFont();
      String var5 = this.getText();
      Rectangle var4 = var10001;
      FontRenderContext var7 = new FontRenderContext(null, true, true);
      Rectangle2D var21;
      int var8 = (int)Math.round((var21 = var6.getStringBounds(var5, var7)).getWidth());
      int var9 = (int)Math.round(var21.getHeight());
      int var10 = (int)Math.round(var21.getX());
      int var22 = (int)Math.round(var21.getY());
      var8 = var4.width / 2 - var8 / 2 - var10;
      int var23 = var4.height / 2 - var9 / 2 - var22;
      var1.setFont(var6);
      var1.drawString(var5, var4.x + var8, var4.y + var23);
      Rectangle var19 = new Rectangle(0, 0, this.getWidth(), this.getHeight());
      Graphics var18 = var1;
      C_dy var17 = this;

      try {
         FontRenderContext var20 = new FontRenderContext(null, true, true);
         Rectangle2D var12;
         Math.round((var12 = var17.getFont().getStringBounds(var17.getText(), var20)).getWidth());
         Math.round(var12.getHeight());
         Math.round(var12.getX());
         Math.round(var12.getY());
         var17.getIcon().paintIcon(var17, var18, var17.getIconTextGap(), var17.getHeight() / 3);
      } catch (Exception var11) {
      }

      var2.dispose();
   }

   static void a(C_dy var0, boolean var1) {
      var0.c_bool_1 = var1;
   }

   static void a(C_dy var0) {
      var0.b_bool_1 = true;
   }

   static void b(C_dy var0, boolean var1) {
      var0.d_bool_1 = var1;
   }
}
