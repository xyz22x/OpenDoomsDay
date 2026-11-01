import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public final class CryptoUtil extends Thread {
   public int a;

   @Override
   public final void run() {
      ServerSocket var1 = null;

      try {
         (var1 = new ServerSocket(0)).setSoTimeout(86400000);
         this.a = var1.getLocalPort();

         while (true) {
            Socket var2;
            (var2 = var1.accept()).setSoTimeout(750);
            if (new DataInputStream(var2.getInputStream()).readInt() == DoomsdayGUI.b_int) {
               var1.close();
               var2.close();
               System.exit(0);
               return;
            }

            var2.close();
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      } finally {
         try {
            var1.close();
         } catch (Throwable var8) {
         }
      }
   }
}
