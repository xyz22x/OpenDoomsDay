import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.CellRendererPane;

final class C_eb extends CellRendererPane {
   private C_ea a;

   C_eb(C_ea var1) {
      this.a = var1;
   }

   @Override
   public final void paintComponent(Graphics var1, Component var2, Container var3, int var4, int var5, int var6, int var7, boolean var8) {
      if (!C_ea.a(this.a).isEnabled()) {
         var2.setBackground(Color.darkGray);
      }

      super.paintComponent(var1, var2, var3, var4, var5, var6, var7, var8);
   }
}
