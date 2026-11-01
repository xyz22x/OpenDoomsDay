import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Path2D.Double;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalComboBoxIcon;
import javax.swing.plaf.metal.MetalLookAndFeel;

public final class C_as extends MetalComboBoxIcon {
   private Double a_Path2D$Double;
   private Polygon a_Polygon_1;

   public C_as(boolean var1) {
      if (var1) {
         this.a_Path2D$Double = new Double();
         this.a_Path2D$Double.moveTo(5.0, -1.0);
         this.a_Path2D$Double.lineTo(11.0, 5.0);
         this.a_Path2D$Double.lineTo(0.0, 5.0);
         this.a_Path2D$Double.closePath();
         this.a_Polygon_1 = new Polygon(new int[]{5, 11, 0}, new int[]{0, 5, 5}, 3);
      } else {
         this.a_Path2D$Double = new Double();
         this.a_Path2D$Double.moveTo(1.0, 0.0);
         this.a_Path2D$Double.lineTo(11.0, 0.0);
         this.a_Path2D$Double.lineTo(5.0, 4.0);
         this.a_Path2D$Double.closePath();
         this.a_Polygon_1 = new Polygon(new int[]{1, 11, 5}, new int[]{0, 0, 5}, 3);
      }
   }

   @Override
   public final void paintIcon(Component var1, Graphics var2, int var3, int var4) {
      JComponent var6 = (JComponent)var1;
      Graphics2D var5 = (Graphics2D)var2;
      var2.translate(var3, var4);
      var2.setColor((Color)(var6.isEnabled() ? Color.white : MetalLookAndFeel.getControlShadow()));
      var5.fill(this.a_Polygon_1);
      var5.fill(this.a_Path2D$Double);
      var2.translate(-var3, -var4);
   }
}
