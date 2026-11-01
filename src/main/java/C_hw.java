import java.io.IOException;
import java.io.InputStream;

public class C_hw extends InputStream {
   protected InputStream a;

   protected C_hw(InputStream var1) {
      this.a = var1;
   }

   @Override
   public int read() throws IOException {
      return this.a.read();
   }

   @Override
   public int read(byte[] var1) throws IOException {
      return this.read(var1, 0, var1.length);
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      return this.a.read(var1, var2, var3);
   }

   @Override
   public long skip(long var1) throws IOException {
      return this.a.skip(var1);
   }

   @Override
   public int available() throws IOException {
      return this.a.available();
   }

   @Override
   public void close() throws IOException {
      this.a.close();
   }

   @Override
   public synchronized void mark(int var1) {
      this.a.mark(var1);
   }

   @Override
   public synchronized void reset() throws IOException {
      this.a.reset();
   }

   @Override
   public boolean markSupported() {
      return this.a.markSupported();
   }
}
