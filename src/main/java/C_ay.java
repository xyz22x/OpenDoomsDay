import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public final class C_ay {
   DatagramSocket a;

   public final int a(byte[] var1) {
      try {
         DatagramPacket var3 = new DatagramPacket(var1, 1024);
         this.a.receive(var3);
         return var3.getLength();
      } catch (IOException var2) {
         throw new RuntimeException(var2);
      }
   }

   public final void a() {
      if (this.a != null) {
         this.a.close();
      }
   }
}
