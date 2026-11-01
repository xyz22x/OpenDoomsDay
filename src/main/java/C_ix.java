import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

final class C_ix extends Thread {
   private final long a_long;
   private final InjectionCallback a_cb_1;
   private final byte[] a_arr_byte_2;
   private final byte[] b;
   private final byte[] c;
   private final byte[] d;
   private final ServerSocket a_ServerSocket_3;

   C_ix(long var1, InjectionCallback var3, byte[] var4, byte[] var5, byte[] var6, byte[] var7, ServerSocket var8) {
      this.a_long = var1;
      this.a_cb_1 = var3;
      this.a_arr_byte_2 = var4;
      this.b = var5;
      this.c = var6;
      this.d = var7;
      this.a_ServerSocket_3 = var8;
   }

   @Override
   public final void run() {
      if (PlatformUtil.h()) {
         if (!ProcessAttacher.a(this.a_long)) {
            ProcessAttacher.b(this.a_long);
            this.a_cb_1.b(null, new RuntimeException("Failed to connect shellcode send pipe"));
         } else if (!ProcessAttacher.a(this.a_long, this.a_arr_byte_2, 4)) {
            ProcessAttacher.b(this.a_long);
            this.a_cb_1.b(null, new RuntimeException("Failed to write shellcode length"));
         } else if (!ProcessAttacher.a(this.a_long, this.b, 4)) {
            ProcessAttacher.b(this.a_long);
            this.a_cb_1.b(null, new RuntimeException("Failed to write data length"));
         } else if (!ProcessAttacher.a(this.a_long, this.c, this.c.length)) {
            ProcessAttacher.b(this.a_long);
            this.a_cb_1.b(null, new RuntimeException("Failed to write shellcode"));
         } else if (!ProcessAttacher.a(this.a_long, this.d, this.d.length)) {
            ProcessAttacher.b(this.a_long);
            this.a_cb_1.b(null, new RuntimeException("Failed to write data"));
         } else {
            ProcessAttacher.b(this.a_long);
         }
      } else {
         try {
            Socket var1 = this.a_ServerSocket_3.accept();
            this.a_cb_1.b_Socket_1 = var1;
            OutputStream var2;
            (var2 = var1.getOutputStream()).write(this.a_arr_byte_2);
            var2.write(this.b);
            var2.write(this.c);
            var2.write(this.d);
            var1.close();
            this.a_ServerSocket_3.close();
         } catch (Exception var3) {
            if (!this.a_cb_1.a_bool_3 && var3.getMessage() != null && !var3.getMessage().contains("Socket closed")) {
               var3.printStackTrace();
            }

            if (!this.isInterrupted()) {
               this.a_cb_1.b("Failed to write shellcode", var3);
            }
         }
      }
   }
}
