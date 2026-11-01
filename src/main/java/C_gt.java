import javax.swing.SwingUtilities;

final class C_gt extends Thread {
   private VersionSelectPanel a;

   C_gt(VersionSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      SwingUtilities.invokeLater(new C_gu(this));
   }

   static VersionSelectPanel a(C_gt var0) {
      return var0.a;
   }
}
