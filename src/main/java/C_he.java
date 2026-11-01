import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

final class C_he implements MouseListener {
   private VersionSelectPanel a_gp;
   private final JLabel a_JLabel_1;
   private final ClientVersion a_gg_2;
   private final C_hg a_hg_3;
   private final Font a_Font_4;
   private final Font b;

   C_he(VersionSelectPanel var1, JLabel var2, ClientVersion var3, C_hg var4, Font var5, Font var6) {
      this.a_gp = var1;
      this.a_JLabel_1 = var2;
      this.a_gg_2 = var3;
      this.a_hg_3 = var4;
      this.a_Font_4 = var5;
      this.b = var6;
   }

   @Override
   public final void mouseReleased(MouseEvent var1) {
      if (this.a_JLabel_1.getText().equals("Delete")) {
         if (this.a_gg_2.a_File_5 != null) {
            VersionManager.b_void(this.a_gg_2);
         }

         if (this.a_gg_2.a_arr_byte_4 != null) {
            VersionManager.a_void(this.a_gg_2);
         }
      } else if (this.a_JLabel_1.getText().equals("Download")) {
         new C_hf(this, this.a_gg_2).start();
      }

      this.a_gp.a_fd_3.repaint();
   }

   @Override
   public final void mousePressed(MouseEvent var1) {
   }

   @Override
   public final void mouseExited(MouseEvent var1) {
      this.a_hg_3.a_bool_3 = false;
      if (this.a_Font_4 == this.b) {
         if (this.a_JLabel_1.getText().equals("Delete")) {
            this.a_JLabel_1.setForeground(new Color(255, 120, 104));
         } else if (this.a_JLabel_1.getText().equals("Download") || this.a_JLabel_1.getText().equals("Downloading...")) {
            this.a_JLabel_1.setForeground(new Color(124, 180, 255));
         }
      } else {
         this.a_JLabel_1.setFont(this.a_Font_4);
      }

      this.a_gp.a_fd_3.repaint();
   }

   @Override
   public final void mouseEntered(MouseEvent var1) {
      this.a_hg_3.a_bool_3 = true;
      if (this.a_Font_4 == this.b) {
         if (this.a_JLabel_1.getText().equals("Delete")) {
            this.a_JLabel_1.setForeground(new Color(255, 180, 134));
         } else if (this.a_JLabel_1.getText().equals("Download") || this.a_JLabel_1.getText().equals("Downloading...")) {
            this.a_JLabel_1.setForeground(new Color(144, 220, 255));
         }
      } else {
         this.a_JLabel_1.setFont(this.b);
      }

      this.a_gp.a_fd_3.repaint();
   }

   @Override
   public final void mouseClicked(MouseEvent var1) {
   }

   static VersionSelectPanel a(C_he var0) {
      return var0.a_gp;
   }
}
