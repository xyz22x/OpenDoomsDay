import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

final class C_jq extends BasicComboBoxRenderer {
   @Override
   public final Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      super.getListCellRendererComponent(var1, var2, var3, var4, var5);
      if (var2 instanceof VersionItem) {
         VersionItem var6 = (VersionItem)var2;
         this.setIcon(var6.a_Icon_2());
      } else {
         this.setIcon(null);
      }

      return this;
   }
}
