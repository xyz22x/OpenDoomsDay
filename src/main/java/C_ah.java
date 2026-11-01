import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.ToolTipManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

final class C_ah extends JTable {
   private DefaultTableCellRenderer a_DefaultTableCellRenderer;
   private VersionTabPanel a_u_1;

   C_ah(VersionTabPanel var1, TableModel var2, DoomsdayGUI var3) {
      super(var2);
      this.a_u_1 = var1;
      this.a_DefaultTableCellRenderer = new C_ai(this, var3);
   }

   @Override
   public final String getToolTipText(MouseEvent var1) {
      Object var2 = null;
      Point var4 = var1.getPoint();
      int var5 = this.rowAtPoint(var4);
      ToolTipManager.sharedInstance().setInitialDelay(0);

      try {
         this.getValueAt(var5, 0);
      } catch (RuntimeException var3) {
      }

      return (String)var2;
   }

   @Override
   public final boolean isCellEditable(int var1, int var2) {
      return false;
   }

   @Override
   public final TableCellRenderer getCellRenderer(int var1, int var2) {
      return this.a_DefaultTableCellRenderer;
   }

   static VersionTabPanel a(C_ah var0) {
      return var0.a_u_1;
   }
}
