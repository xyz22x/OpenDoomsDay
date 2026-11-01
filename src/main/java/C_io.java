import java.net.ServerSocket;
import java.net.Socket;

final class C_io extends Thread {
   private final Process a_Process;
   private final ServerSocket a_ServerSocket_1;
   private final Socket[] a_arr_Socket_2;
   private final InjectionCallback a_cb_3;

   C_io(Process var1, ServerSocket var2, Socket[] var3, InjectionCallback var4) {
      this.a_Process = var1;
      this.a_ServerSocket_1 = var2;
      this.a_arr_Socket_2 = var3;
      this.a_cb_3 = var4;
   }

   @Override
   public final void run() {
      try {
         for (; !this.isInterrupted(); Thread.sleep(50L)) {
            try {
               int var1 = this.a_Process.exitValue();
               System.out.println("Exit code received! ".concat(String.valueOf(var1)));
               if (var1 == 126) {
                  this.a_ServerSocket_1.close();

                  try {
                     this.a_arr_Socket_2[0].close();
                  } catch (Throwable var2) {
                  }

                  ExternalProcessInjector.a_void();
                  this.a_cb_3.b(null, new RuntimeException("Failed injection: canceled by user"));
               }

               return;
            } catch (IllegalThreadStateException var3) {
            } catch (Throwable var4) {
               var4.printStackTrace();
            }
         }
      } catch (InterruptedException var5) {
      } catch (Throwable var6) {
         var6.printStackTrace();
      }
   }
}
