final class C_gu implements Runnable {
   private C_gt a;

   C_gu(C_gt var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      C_gt.a(this.a).a_JPanel_1.removeAll();

      for (int var1 = 0; var1 < VersionManager.e.size(); var1++) {
         C_gt.a(this.a).a((ClientVersion)VersionManager.e.get(var1), var1);
      }

      C_gt.a(this.a).a_fd_3.repaint();
   }
}
