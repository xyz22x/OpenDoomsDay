import java.io.IOException;
import java.io.OutputStream;

public class C_hx extends OutputStream {
   protected OutputStream a;

   public C_hx(OutputStream var1) {
      this.a = var1;
   }

   @Override
   public void write(int var1) throws IOException {
      this.a.write(var1);
   }

   @Override
   public void write(byte[] var1) throws IOException {
      this.write(var1, 0, var1.length);
   }

   @Override
   public void write(byte[] var1, int var2, int var3) throws IOException {
      if ((var2 | var3 | var1.length - (var3 + var2) | var2 + var3) < 0) {
         throw new IndexOutOfBoundsException();
      } else {
         for (int var4 = 0; var4 < var3; var4++) {
            this.write(var1[var2 + var4]);
         }
      }
   }

   @Override
   public void flush() throws IOException {
      this.a.flush();
   }

   @Override
   public void close() throws IOException {
      try {
         this.flush();
      } catch (IOException var1) {
      }

      this.a.close();
   }
}
