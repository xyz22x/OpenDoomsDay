import java.awt.Color;

final class C_gw implements Runnable {
   private C_gv a_gv;
   private final C_hg a_hg_1;

   C_gw(C_gv var1, C_hg var2) {
      this.a_gv = var1;
      this.a_hg_1 = var2;
   }

   @Override
   public final void run() {
      this.a_hg_1.b_JLabel.setText("Downloading...");
      if (this.a_hg_1.a_bool_3 && VersionSelectPanel.a_bool_4) {
         this.a_hg_1.b_JLabel.setForeground(new Color(144, 220, 255));
      } else {
         this.a_hg_1.b_JLabel.setForeground(new Color(124, 180, 255));
      }

      this.a_gv.a.a_fd_3.repaint();
   }
}
