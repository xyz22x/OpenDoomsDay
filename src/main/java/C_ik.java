import java.net.Socket;

final class C_ik extends Thread {
   private final Socket[] a;

   C_ik(Socket[] var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         Thread.sleep(20000L);

         try {
            this.a[0].close();
         } catch (Throwable var1) {
         }

         System.exit(0);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
