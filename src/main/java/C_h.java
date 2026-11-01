import java.io.DataOutputStream;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

final class C_h extends Thread {
   private final ServerSocket a_ServerSocket;
   private final int a_int_1;
   private final ClientConfig a_au_2;
   private final File a_File_3;

   C_h(ServerSocket var1, int var2, ClientConfig var3, File var4) {
      this.a_ServerSocket = var1;
      this.a_int_1 = var2;
      this.a_au_2 = var3;
      this.a_File_3 = var4;
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

         if (this.a_File_3 != null) {
            var2.writeUTF(this.a_File_3.getAbsolutePath());
         } else {
            var2.writeUTF("");
         }

         var2.close();
         var1.close();
         this.a_ServerSocket.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }
}
