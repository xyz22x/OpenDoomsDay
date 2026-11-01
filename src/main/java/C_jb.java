import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;

final class C_jb extends DefaultListCellRenderer {
   private final C_ea a_ea;
   private final JComboBox a_JComboBox_1;

   C_jb(C_ea var1, JComboBox var2) {
      this.a_ea = var1;
      this.a_JComboBox_1 = var2;
   }

   @Override
   public final Component getListCellRendererComponent(JList var1, Object var2, int var3, boolean var4, boolean var5) {
      super.getListCellRendererComponent(var1, var2, var3, var4, var5);
      this.setBorder(new EmptyBorder(0, 5, 0, 5));
      if (var3 == this.a_ea.a) {
         this.setBackground(new Color(110, 110, 111));
         this.setForeground(Color.white);
      } else {
         this.setBackground(this.a_JComboBox_1.getBackground());
         this.setForeground(Color.white);
      }

      if (var2 instanceof VersionItem) {
         VersionItem var6 = (VersionItem)var2;
         this.setIcon(var6.a_Icon_2());
      }

      return this;
   }
}
