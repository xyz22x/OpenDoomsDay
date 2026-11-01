import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

final class C_ge implements Runnable {
   private ProcessListManager a;

   C_ge(ProcessListManager var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      JPanel var1 = DoomsdayGUI.a_a_3.a_ex_10.a_cr_1.a_JPanel_3;
      if (this.a.a_List_1.size() == 0) {
         DoomsdayGUI.a_a_3.a_ex_10.a_cr_1.a_JLabel_2.setText("Minecraft processes not found");
         if (!this.a.a_u_2.a_bool) {
            DoomsdayGUI.a_a_3.a_ex_10.a_cr_1.a_dy_1.setEnabled(DoomsdayGUI.a_bool_5());
         }
      } else {
         DoomsdayGUI.a_a_3.a_ex_10.a_cr_1.a_JLabel_2.setText("Found minecraft processes");
         if (!this.a.a_u_2.a_bool) {
            DoomsdayGUI.a_a_3.a_ex_10.a_cr_1.a_dy_1.setEnabled(true);
         }
      }

      for (int var2 = 0; var2 < var1.getComponentCount(); var2++) {
         var1.getComponent(var2).setVisible(false);
      }

      synchronized (this.a.a_List_1) {
         for (int var3 = 0; var3 < this.a.a_List_1.size(); var3++) {
            TargetProcess var4 = (TargetProcess)this.a.a_List_1.get(var3);
            JLabel var9;
            if (var3 == var1.getComponentCount()) {
               String var6 = "";
               DoomsdayGUI var5 = DoomsdayGUI.a_a_3;
               JLabel var10;
               (var10 = new JLabel(var6)).setFont(new Font(var5.a_Font_12.getName(), 0, (int)var5.a_Font_12.getSize()));
               var10.setForeground(Color.white);
               var9 = var10;
               var1.add(var10);
            } else {
               var9 = (JLabel)var1.getComponent(var3);
            }

            var9.setText(var4.toString());
            var9.setVisible(true);
         }
      }

      var1.revalidate();
      var1.repaint();
   }
}
