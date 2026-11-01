import java.util.List;

final class C_gf implements Runnable {
   private ProcessListManager a_gd;
   private final List a_List_1;

   C_gf(ProcessListManager var1, List var2) {
      this.a_gd = var1;
      this.a_List_1 = var2;
   }

   @Override
   public final void run() {
      List var1;
      if (DoomsdayGUI.a_a_3.a_ex_10.a_u_2.a_JComboBox_2.getSelectedIndex() == 0) {
         var1 = this.a_gd.b;
      } else {
         var1 = this.a_List_1;
      }

      for (Object var2_raw : var1) { ProcessInfo var2 = (ProcessInfo)var2_raw;
         if (!this.a_gd.a(var2) && var2.b_int != DoomsdayGUI.b_int) {
            try {
               this.a_gd
                  .a_u_2
                  .a_DefaultTableModel_5
                  .addRow(new Object[]{var2, null, var2.b_int, var2.a_String(), var2.a_String_1, var2.b_String_1, var2.a_long_2});
            } catch (Exception var4) {
               var4.printStackTrace();
            }
         }
      }

      for (int var5 = this.a_gd.a_u_2.a_DefaultTableModel_5.getRowCount() - 1; var5 >= 0; var5--) {
         ProcessInfo var6 = (ProcessInfo)this.a_gd.a_u_2.a_DefaultTableModel_5.getValueAt(var5, 0);
         int var7;
         if ((var7 = var1.indexOf(var6)) < 0) {
            this.a_gd.a_u_2.a_DefaultTableModel_5.removeRow(var5);
         } else {
            var6 = (ProcessInfo)var1.get(var7);
            this.a_gd.a_u_2.a_DefaultTableModel_5.setValueAt(var6.b_int, var5, 2);
            this.a_gd.a_u_2.a_DefaultTableModel_5.setValueAt(var6.a_String(), var5, 3);
            this.a_gd.a_u_2.a_DefaultTableModel_5.setValueAt(var6.a_String_1, var5, 4);
            this.a_gd.a_u_2.a_DefaultTableModel_5.setValueAt(var6.b_String_1, var5, 5);
            this.a_gd.a_u_2.a_DefaultTableModel_5.setValueAt(var6.a_long_2, var5, 6);
         }
      }

      this.a_gd.a_u_2.a_JTable_3.repaint();
      this.a_gd.a_u_2.a_JScrollPane_7.repaint();
   }
}
