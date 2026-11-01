import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

public final class C_fq implements Border {
   private int a_int;
   private Color a_Color_1;

   public C_fq(int var1, Color var2) {
      this.a_int = var1;
      this.a_Color_1 = var2;
   }

   @Override
   public final Insets getBorderInsets(Component var1) {
      return new Insets(this.a_int, this.a_int, this.a_int, this.a_int);
   }

   @Override
   public final boolean isBorderOpaque() {
      return true;
   }

   @Override
   public final void paintBorder(Component var1, Graphics var2, int var3, int var4, int var5, int var6) {
      var2.setColor(this.a_Color_1);
      int var8 = this.a_int;
      int var7 = this.a_int / 2;
      var2.fillArc(var3, var4, var8, var8, 90, 90);
      var2.fillRect(var3 + var7, var4, var5 - var8, var7);
      var2.fillArc(var3 + var5 - var8, var4, var8, var8, 0, 90);
      var2.fillRect(var3 + var5 - var7, var4 + var7, var7, var6 - var8);
      if (var8 == 2) {
         var2.fillArc(var3 + var5 - var8, var4 + var6 - var8, var8 + 1, var8 + 1, 270, 90);
         var2.fillRect(var3 + var7, var4 + var6 - var7, var5 - var8, var7);
         var2.fillArc(var3, var4 + var6 - var8, var8 + 1, var8 + 1, 180, 90);
         var2.fillRect(var3, var4 + var7, var7, var6 - var8);
      } else {
         var2.fillArc(var3 + var5 - var8, var4 + var6 - var8, var8, var8, 270, 90);
         var2.fillRect(var3 + var7, var4 + var6 - var7, var5 - var8, var7);
         var2.fillArc(var3, var4 + var6 - var8, var8, var8, 180, 90);
         var2.fillRect(var3, var4 + var7, var7, var6 - var8);
      }
   }
}
