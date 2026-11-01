import java.io.File;

final class C_iz extends Thread {
   private final String a;

   C_iz(String var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         Thread.sleep(500L);
      } catch (InterruptedException var1) {
         var1.printStackTrace();
      }

      new File(this.a).delete();
   }
}
