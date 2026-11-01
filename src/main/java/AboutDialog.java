import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

final class AboutDialog extends CustomDialogBase {
   private final JDialog a_JDialog;
   private final JLabel a_JLabel_1;
   private final JTextArea a_JTextArea_2;
   private final C_dy a_dy_3;

   AboutDialog(JDialog var1, JLabel var2, JTextArea var3, C_dy var4) {
      this.a_JDialog = var1;
      this.a_JLabel_1 = var2;
      this.a_JTextArea_2 = var3;
      this.a_dy_3 = var4;
   }

   @Override
   public final void a(int var1) {
      if (var1 == 0) {
         this.a_JLabel_1.setIcon(C_bo.a());
      } else if (var1 == 1) {
         this.a_JLabel_1.setIcon(C_bo.c());
      } else if (var1 == 2) {
         this.a_JLabel_1.setIcon(C_bo.b());
      } else if (var1 == 3) {
         this.a_JLabel_1.setIcon(C_bo.d());
      } else if (var1 == 4) {
         this.a_JLabel_1.setIcon(C_bo.f());
      } else {
         if (var1 == 5) {
            this.a_JLabel_1.setIcon(null);
         }
      }
   }

   @Override
   public final JTextArea a_JTextArea_2() {
      return this.a_JTextArea_2;
   }

   @Override
   public final C_dy a_dy() {
      return this.a_dy_3;
   }

   @Override
   public final JDialog a() {
      return this.a_JDialog;
   }
}
