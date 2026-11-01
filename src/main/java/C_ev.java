import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

final class C_ev extends Thread {
   private final ServerSocket a_ServerSocket;
   private final int a_int_1;
   private final ClientConfig a_au_2;

   C_ev(ServerSocket var1, int var2, ClientConfig var3) {
      this.a_ServerSocket = var1;
      this.a_int_1 = var2;
      this.a_au_2 = var3;
   }

   @Override
   public final void run() {
      try {
         Socket var1 = this.a_ServerSocket.accept();
         DataOutputStream var2;
         (var2 = new DataOutputStream(var1.getOutputStream())).writeInt(this.a_int_1);
         if (this.a_au_2 != null) {
            byte[] var3 = this.a_au_2.a();
            var2.writeInt(var3.length);
            var2.write(var3);
         } else {
            var2.writeInt(0);
         }

         var2.writeUTF("");
         var2.close();
         var1.close();
         this.a_ServerSocket.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }
}
