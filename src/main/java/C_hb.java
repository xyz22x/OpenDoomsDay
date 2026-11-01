import java.awt.Color;

final class C_hb implements Runnable {
   private C_ha a_ha;
   private final ClientVersion a_gg_1;

   C_hb(C_ha var1, ClientVersion var2) {
      this.a_ha = var1;
      this.a_gg_1 = var2;
   }

   @Override
   public final void run() {
      C_hg var1 = (C_hg)VersionSelectPanel.a(this.a_ha.a).get(this.a_gg_1.b_String);
      String var2 = Integer.toString(this.a_gg_1.a() / 1024);
      var1.a_JLabel_2.setText(var2 + " KB");
      if (this.a_gg_1.a_dbl_2 >= 0.0) {
         var1.b_JLabel.setText("Downloading...");
         if (var1.a_bool_3 && VersionSelectPanel.a_bool_4) {
            var1.b_JLabel.setForeground(new Color(144, 220, 255));
         } else {
            var1.b_JLabel.setForeground(new Color(124, 180, 255));
         }
      } else if (this.a_gg_1.a_arr_byte_4 != null) {
         var1.b_JLabel.setText("Delete");
         if (var1.a_bool_3 && VersionSelectPanel.a_bool_4) {
            var1.b_JLabel.setForeground(new Color(255, 180, 134));
         } else {
            var1.b_JLabel.setForeground(new Color(255, 120, 104));
         }
      } else if (this.a_gg_1.a_File_5 != null) {
         var1.b_JLabel.setText("Delete");
         if (var1.a_bool_3 && VersionSelectPanel.a_bool_4) {
            var1.b_JLabel.setForeground(new Color(255, 180, 134));
         } else {
            var1.b_JLabel.setForeground(new Color(255, 120, 104));
         }
      } else if (this.a_gg_1.a_bn_6 != null) {
         var1.b_JLabel.setText("Download");
         if (var1.a_bool_3 && VersionSelectPanel.a_bool_4) {
            var1.b_JLabel.setForeground(new Color(144, 220, 255));
         } else {
            var1.b_JLabel.setForeground(new Color(124, 180, 255));
         }
      } else {
         this.a_ha.a.a_JPanel_1.remove(var1.b_JPanel_1);
         this.a_ha.a.a_JPanel_1.remove(var1.a_JPanel_1);
         this.a_ha.a.a_JPanel_1.revalidate();
         this.a_ha.a.a_JPanel_1.repaint();
      }

      this.a_ha.a.a_fd_3.repaint();
   }
}
