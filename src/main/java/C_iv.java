import java.util.concurrent.TimeUnit;

final class C_iv extends C_ef {
   private final Process a_Process;
   private final Integer[] a_arr_Integer_1;

   C_iv(Process var1, Integer[] var2) {
      this.a_Process = var1;
      this.a_arr_Integer_1 = var2;
   }

   @Override
   public final void run() {
      try {
         if (this.a_Process.waitFor(120000L, TimeUnit.MILLISECONDS)) {
            this.a_arr_Integer_1[0] = this.a_Process.exitValue();
            synchronized (JvmtiInjector.a) {
               JvmtiInjector.a.notifyAll();
               return;
            }
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }
}
