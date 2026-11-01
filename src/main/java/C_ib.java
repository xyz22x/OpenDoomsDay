import java.io.IOException;
import java.io.InputStream;

public class C_ib extends C_hw {
   protected C_hy a_hy;
   protected byte[] a_arr_byte_1;
   protected int a_int_2;
   private byte[] b = new byte[1];

   public C_ib(InputStream var1, C_hy var2) {
      this(var1, var2, (byte)0);
   }

   private C_ib(InputStream var1, C_hy var2, byte var3) {
      super(var1);
      if (var1 == null) {
         throw new NullPointerException("in may not be null");
      } else if (var2 == null) {
         throw new NullPointerException("inf may not be null");
      } else {
         this.a_hy = var2;
         this.a_arr_byte_1 = new byte[4096];
      }
   }

   @Override
   public int available() throws IOException {
      if (this.a_hy == null) {
         throw new IOException("stream closed");
      } else {
         return this.a_hy.a() ? 0 : 1;
      }
   }

   @Override
   public synchronized void close() throws IOException {
      if (this.a != null) {
         this.a.close();
      }

      this.a = null;
   }

   @Override
   public int read() throws IOException {
      return this.read(this.b, 0, 1) > 0 ? this.b[0] & 0xFF : -1;
   }

   @Override
   public int read(byte[] var1, int var2, int var3) throws IOException {
      if (this.a_hy == null) {
         throw new IOException("stream closed");
      } else if (var3 == 0) {
         return 0;
      } else {
         while (true) {
            int var4;
            try {
               var4 = this.a_hy.a(var1, var2, var3);
            } catch (C_ho var5) {
               throw new C_ig(var5.getMessage());
            }

            if (var4 > 0) {
               return var4;
            }

            if (this.a_hy.b() | this.a_hy.a()) {
               return -1;
            }

            if (!this.a_hy.c_bool()) {
               throw new Error("Don't know what to do");
            }

            if (this.a == null) {
               throw new C_ig("InflaterInputStream is closed");
            }

            this.a_int_2 = this.a.read(this.a_arr_byte_1, 0, this.a_arr_byte_1.length);
            if (this.a_int_2 < 0) {
               throw new C_ig("Deflated stream ends early.");
            }

            this.a_hy.a(this.a_arr_byte_1, this.a_int_2);
         }
      }
   }

   @Override
   public long skip(long var1) throws IOException {
      if (this.a_hy == null) {
         throw new IOException("stream closed");
      } else if (var1 < 0L) {
         throw new IllegalArgumentException();
      } else if (var1 == 0L) {
         return 0L;
      } else {
         int var3;
         byte[] var4 = new byte[var3 = (int)Math.min(var1, 2048L)];

         long var5;
         for (var5 = 0L; var1 > 0L && (var3 = this.read(var4, 0, var3)) > 0; var3 = (int)Math.min(var1, 2048L)) {
            var1 -= var3;
            var5 += var3;
         }

         return var5;
      }
   }

   @Override
   public boolean markSupported() {
      return false;
   }

   @Override
   public void mark(int var1) {
   }

   @Override
   public void reset() throws IOException {
      throw new IOException("reset not supported");
   }
}
