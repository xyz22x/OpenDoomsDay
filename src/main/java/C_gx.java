import java.awt.Color;

final class C_gx implements Runnable {
   private C_gv a_gv;
   private final Exception a_Exception_1;
   private final C_hg a_hg_2;

   C_gx(C_gv var1, Exception var2, C_hg var3) {
      this.a_gv = var1;
      this.a_Exception_1 = var2;
      this.a_hg_2 = var3;
   }

   @Override
   public final void run() {
      if (this.a_Exception_1 != null) {
         this.a_hg_2.b_JLabel.setText("Download");
         if (this.a_hg_2.a_bool_3 && VersionSelectPanel.a_bool_4) {
            this.a_hg_2.b_JLabel.setForeground(new Color(144, 220, 255));
         } else {
            this.a_hg_2.b_JLabel.setForeground(new Color(124, 180, 255));
         }
      } else {
         this.a_hg_2.b_JLabel.setText("Delete");
         if (this.a_hg_2.a_bool_3 && VersionSelectPanel.a_bool_4) {
            this.a_hg_2.b_JLabel.setForeground(new Color(255, 180, 134));
         } else {
            this.a_hg_2.b_JLabel.setForeground(new Color(255, 120, 104));
         }
      }

      this.a_gv.a.a_fd_3.repaint();
   }
}
