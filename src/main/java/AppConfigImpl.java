import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public final class AppConfigImpl extends AppConfigBase {
   private SocketChannel a;

   public final void a(byte[] var1, int var2) {
      try {
         SocketChannel var3;
         (var3 = SocketChannel.open()).connect(new InetSocketAddress(InetAddress.getByAddress(var1), var2));
         this.a = var3;
         C_bd.a(var3.getLocalAddress());
      } catch (Exception var4) {
         throw new RuntimeException(var4);
      }
   }

   public final int a_int(byte[] var1, int var2) {
      try {
         ByteBuffer var3;
         (var3 = ByteBuffer.allocateDirect(var2)).put(var1, 0, var2);
         ((Buffer)var3).position(0);
         int var5 = this.a.write(var3);
         C_bd.a(this.a.getLocalAddress());
         ((Buffer)var3).position(0);
         var3.put(new byte[var2]);
         return var5;
      } catch (Exception var4) {
         throw new RuntimeException(var4);
      }
   }

   public final int a(NativeBinaryManager var1) {
      try {
         var1.a_void_3();
         ByteBuffer var2 = ByteBuffer.allocateDirect(16384);
         int var3 = this.a.read(var2);
         C_bd.a(this.a.getLocalAddress());
         ((Buffer)var2).position(0);
         var2.get(var1.a(), var1.c_int(), 16384);
         var1.c(var1.c_int() + var3);
         ((Buffer)var2).position(0);
         var2.put(new byte[16384]);
         return var3;
      } catch (Exception var4) {
         var4.printStackTrace();
         throw new RuntimeException(var4);
      }
   }

   public final void a() {
      try {
         this.a.close();
      } catch (Exception var2) {
         throw new RuntimeException(var2);
      }
   }
}
