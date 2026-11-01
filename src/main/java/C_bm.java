public final class C_bm extends Thread {
   C_bl a_bl;
   private int a_int_1 = 5000;
   private int b = 60000;

   @Override
   public final void run() {
      long var1 = System.currentTimeMillis();

      try {
         while (!this.isInterrupted()) {
            long var3;
            if ((var3 = System.currentTimeMillis()) > var1 + this.b) {
               if (this.a_bl.isAlive()) {
                  this.a_bl.interrupt();
               }

               return;
            }

            if (var3 > this.a_bl.a_long_1 + this.a_int_1) {
               if (this.a_bl.isAlive()) {
                  this.a_bl.interrupt();
               }

               return;
            }

            Thread.sleep(100L);
         }
      } catch (Throwable var5) {
      }
   }
}
