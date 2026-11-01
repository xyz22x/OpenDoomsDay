final class C_ad implements DownloadProgressListener {
   private VersionTabPanel a;

   C_ad(VersionTabPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1) {
   }

   @Override
   public final void a(ClientVersion var1, Exception var2) {
      this.a.c.repaint();
   }
}
