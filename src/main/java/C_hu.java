import java.io.IOException;
import java.io.OutputStream;

public class C_hu extends C_hx {
   private byte[] a_arr_byte = new byte[4096];
   protected C_hp a_hp_1;

   private void b() throws IOException {
      int var1;
      while (!this.a_hp_1.b_bool() && (var1 = this.a_hp_1.a(this.a_arr_byte, 0, this.a_arr_byte.length)) > 0) {
         this.a.write(this.a_arr_byte, 0, var1);
      }

      if (!this.a_hp_1.b_bool()) {
         throw new Error("Can't deflate all input?");
      }
   }

   public C_hu(OutputStream var1, C_hp var2) {
      this(var1, var2, (byte)0);
   }

   private C_hu(OutputStream var1, C_hp var2, byte var3) {
      super(var1);
      this.a_hp_1 = var2;
   }

   @Override
   public void flush() throws IOException {
      this.a_hp_1.b();
      this.b();
      this.a.flush();
   }

   public void a() throws IOException {
      this.a_hp_1.c();

      int var1;
      while (!this.a_hp_1.a_bool_2() && (var1 = this.a_hp_1.a(this.a_arr_byte, 0, this.a_arr_byte.length)) > 0) {
         this.a.write(this.a_arr_byte, 0, var1);
      }

      if (!this.a_hp_1.a_bool_2()) {
         throw new Error("Can't deflate all input?");
      } else {
         this.a.flush();
      }
   }

   @Override
   public void close() throws IOException {
      this.a();
      this.a.close();
   }

   @Override
   public void write(int var1) throws IOException {
      byte[] var2;
      (var2 = new byte[1])[0] = (byte)var1;
      this.write(var2, 0, 1);
   }

   @Override
   public void write(byte[] var1, int var2, int var3) throws IOException {
      this.a_hp_1.a_void(var1, var2, var3);
      this.b();
   }
}
