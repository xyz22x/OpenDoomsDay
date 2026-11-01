final class C_gr extends Thread {
   private final C_dy a;

   C_gr(C_dy var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      this.a.setEnabled(false);
      long var1 = System.currentTimeMillis();
      VersionManager.c();
      VersionManager.b();
      long var3;
      if ((var3 = System.currentTimeMillis()) - var1 < 1000L) {
         try {
            Thread.sleep(1000L - (var3 - var1));
         } catch (InterruptedException var5) {
            var5.printStackTrace();
         }
      }

      this.a.setEnabled(true);
   }
}
