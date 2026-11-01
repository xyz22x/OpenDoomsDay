final class DownloadCallbackC implements HttpDownloadCallback {
   private final ClientVersion a;

   DownloadCallbackC(ClientVersion var1) {
      this.a = var1;
   }

   @Override
   public final void a(double var1) {
      this.a.a_dbl_2 = var1;
   }
}
