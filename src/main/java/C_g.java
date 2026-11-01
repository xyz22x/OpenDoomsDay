import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

final class C_g extends Thread {
   private final ServerSocket a_ServerSocket;
   private final ClientConfig a_au_1;

   C_g(ServerSocket var1, ClientConfig var2) {
      this.a_ServerSocket = var1;
      this.a_au_1 = var2;
   }

   @Override
   public final void run() {
      try {
         Socket var1 = this.a_ServerSocket.accept();
         DataOutputStream var2 = new DataOutputStream(var1.getOutputStream());
         byte[] var3 = this.a_au_1.a();
         var2.writeInt(var3.length);
         var2.write(var3);
         var2.writeUTF("");
         var2.flush();
         var1.close();
         this.a_ServerSocket.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }
}
