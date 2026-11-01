import java.awt.Color;
import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

final class C_ai extends DefaultTableCellRenderer {
   private C_ah a_ah;
   private final DoomsdayGUI a_a_1;

   C_ai(C_ah var1, DoomsdayGUI var2) {
      super();
      this.a_ah = var1;
      this.a_a_1 = var2;
   }

   @Override
   public final Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      Component var10 = super.getTableCellRendererComponent(var1, var2, var3, false, var5, var6);
      ProcessInfo rowVal = (ProcessInfo)C_ah.a(this.a_ah).a_DefaultTableModel_5.getValueAt(var5, 0);
      if (var6 == 1 && rowVal.a_bool_3) {
         var10 = C_ah.a(this.a_ah).a_JLabel_10;
      }

      C_cc var12;
      if ((var12 = (C_cc)this.a_a_1.a_gd_13.a_HashMap.get(rowVal.b_int)) != null) {
         if (var12.a_int_1 > 8) {
            if (var3) {
               var10.setBackground(new Color(240, 158, 40));
            } else {
               var10.setBackground(new Color(180, 120, 0));
            }
         } else if (var12.a_int_1 > 0) {
            if (var3) {
               var10.setBackground(new Color(30, 200, 30));
            } else {
               var10.setBackground(new Color(0, 165, 0));
            }
         } else if (var12.b_int_1 > 0) {
            if (var3) {
               var10.setBackground(new Color(225, 40, 40));
            } else {
               var10.setBackground(new Color(160, 0, 0));
            }
         } else if (var3) {
            var10.setBackground(new Color(0, 100, 255));
         } else {
            var10.setBackground(DoomsdayGUI.d_Color_4);
         }
      } else if (var3) {
         var10.setBackground(new Color(0, 100, 255));
      } else {
         var10.setBackground(DoomsdayGUI.d_Color_4);
      }

      if (var6 == 6) {
         try {
            DefaultTableCellRenderer var13 = (DefaultTableCellRenderer)var10;
            NumberFormat var14 = NumberFormat.getInstance();
            long var7;
            if ((var7 = Long.parseLong(var13.getText())) != 0L) {
               var13.setText(var14.format(var7 / 1024L) + " KB");
            } else {
               var13.setText("");
            }
         } catch (Throwable var9) {
            var9.printStackTrace();
         }
      }

      return var10;
   }
}
