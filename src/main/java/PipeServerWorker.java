import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

final class PipeServerWorker extends Thread {
   private final long a_long;
   private final InjectionCallback a_cb_1;
   private final ServerSocket a_ServerSocket_2;

   PipeServerWorker(long var1, InjectionCallback var3, ServerSocket var4) {
      this.a_long = var1;
      this.a_cb_1 = var3;
      this.a_ServerSocket_2 = var4;
   }

   @Override
   public final void run() {
      try {
         byte[] var1 = new byte[8];
         if (PlatformUtil.h()) {
            if (!ProcessAttacher.a(this.a_long)) {
               ProcessAttacher.b(this.a_long);
               this.a_cb_1.b(null, new RuntimeException("Failed to connect return pipe " + this.a_long));
               return;
            }

            if (!ProcessAttacher.a(this.a_long, var1)) {
               ProcessAttacher.b(this.a_long);
               this.a_cb_1.b(null, new RuntimeException("Failed to read from return pipe"));
               return;
            }

            ProcessAttacher.b(this.a_long);
         } else {
            Socket var2 = this.a_ServerSocket_2.accept();
            this.a_cb_1.a_Socket_2 = var2;
            new DataInputStream(var2.getInputStream()).readFully(var1);
            var2.close();
            this.a_ServerSocket_2.close();
         }

         long var5 = 0L
            | (long)var1[7] << 56
            | (long)var1[6] << 48
            | (long)var1[5] << 40
            | (long)var1[4] << 32
            | (long)var1[3] << 24
            | (long)var1[2] << 16
            | (long)var1[1] << 8
            | var1[0];
         this.a_cb_1.b(var5);
      } catch (Exception var4) {
         if (!this.a_cb_1.a_bool_3 && var4.getMessage() != null && !var4.getMessage().contains("Socket closed")) {
            var4.printStackTrace();
         }

         if (!this.isInterrupted()) {
            this.a_cb_1.b("Error getting injection result", var4);
         }
      }
   }
}
