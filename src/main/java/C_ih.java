import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public final class C_ih extends C_ib {
   private C_hn a_hn = new C_hn();
   private C_if a_if_1 = null;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private boolean a_bool_2;

   public C_ih(InputStream var1) {
      super(var1, new C_hy(true));
   }

   private void a_void() throws IOException {
      this.f = this.a_int_2 = this.a.read(this.a_arr_byte_1, 0, this.a_arr_byte_1.length);
   }

   private int a(byte[] var1, int var2, int var3) throws IOException {
      if (this.f <= 0) {
         this.a_void();
         if (this.f <= 0) {
            return -1;
         }
      }

      if (var3 > this.f) {
         var3 = this.f;
      }

      System.arraycopy(this.a_arr_byte_1, this.a_int_2 - this.f, var1, var2, var3);
      this.f -= var3;
      return var3;
   }

   private void a(byte[] var1) throws IOException {
      int var2 = 0;
      int var3 = var1.length;

      while (var3 > 0) {
         int var4;
         if ((var4 = this.a(var1, var2, var3)) == -1) {
            throw new EOFException();
         }

         var2 += var4;
         var3 -= var4;
      }
   }

   private int a() throws IOException {
      if (this.f <= 0) {
         this.a_void();
         if (this.f <= 0) {
            throw new C_ig("EOF in header");
         }
      }

      return this.a_arr_byte_1[this.a_int_2 - this.f--] & 0xFF;
   }

   private int b_int() throws IOException {
      return this.a() | this.a() << 8;
   }

   private int c() throws IOException {
      return this.b_int() | this.b_int() << 16;
   }

   public final C_if a_if_2() throws IOException {
      if (this.a_hn == null) {
         throw new IOException("Stream closed.");
      } else {
         if (this.a_if_1 != null) {
            this.b();
         }

         int var1;
         if ((var1 = this.c()) == 33639248L) {
            this.close();
            return null;
         } else if (var1 != 67324752L) {
            throw new C_ig("Wrong Local header signature: " + Integer.toHexString(var1));
         } else {
            this.b_int();
            this.e = this.b_int();
            this.d = this.b_int();
            var1 = this.c();
            int var2 = this.c();
            this.b = this.c();
            this.c = this.c();
            int var3 = this.b_int();
            int var4 = this.b_int();
            if (this.d == 0 && this.b != this.c) {
               throw new C_ig("Stored, but compressed != uncompressed");
            } else {
               byte[] var8 = new byte[var3];
               String var9 = null;
               this.a(var8);

               try {
                  var9 = new String(var8, "UTF-8");
               } catch (UnsupportedEncodingException var5) {
                  throw new Error();
               }

               this.a_if_1 = new C_if(var9);
               this.a_bool_2 = false;
               this.a_if_1.b(this.d);
               if ((this.e & 8) == 0) {
                  this.a_if_1.d(var2 & 4294967295L);
                  this.a_if_1.b(this.c & 4294967295L);
                  this.a_if_1.c(this.b & 4294967295L);
               }

               this.a_if_1.a(var1);
               if (var4 > 0) {
                  byte[] var7 = new byte[var4];
                  this.a(var7);
                  this.a_if_1.a(var7);
               }

               if (this.d == 8 && this.f > 0) {
                  System.arraycopy(this.a_arr_byte_1, this.a_int_2 - this.f, this.a_arr_byte_1, 0, this.f);
                  this.a_int_2 = this.f;
                  this.f = 0;
                  this.a_hy.a(this.a_arr_byte_1, this.a_int_2);
               }

               return this.a_if_1;
            }
         }
      }
   }

   private void b() throws IOException {
      if (this.a_hn == null) {
         throw new IOException("Stream closed.");
      } else if (this.a_if_1 != null) {
         if (this.d == 8) {
            if ((this.e & 8) != 0) {
               byte[] var3 = new byte[2048];

               while (this.read(var3) > 0) {
               }

               return;
            }

            this.b = this.b - this.a_hy.b_int();
            this.f = this.a_hy.a_int();
         }

         if (this.f > this.b && this.b >= 0) {
            this.f = this.f - this.b;
         } else {
            this.b = this.b - this.f;
            this.f = 0;

            while (this.b != 0) {
               long var1;
               if ((var1 = this.a.skip(this.b & 4294967295L)) <= 0L) {
                  throw new C_ig("zip archive ends early.");
               }

               this.b = (int)(this.b - var1);
            }
         }

         this.c = 0;
         this.a_hn.a();
         if (this.d == 8) {
            this.a_hy.a_void_2();
         }

         this.a_if_1 = null;
         this.a_bool_2 = true;
      }
   }

   @Override
   public final int available() throws IOException {
      return this.a_bool_2 ? 0 : 1;
   }

   @Override
   public final int read() throws IOException {
      byte[] var1 = new byte[1];
      return this.read(var1, 0, 1) <= 0 ? -1 : var1[0] & 0xFF;
   }

   @Override
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      if (var3 == 0) {
         return 0;
      } else if (this.a_hn == null) {
         throw new IOException("Stream closed.");
      } else if (this.a_if_1 == null) {
         return -1;
      } else {
         boolean var4 = false;
         switch (this.d) {
            case 0:
               if (var3 > this.b && this.b >= 0) {
                  var3 = this.b;
               }

               if ((var3 = this.a(var1, var2, var3)) > 0) {
                  this.b -= var3;
                  this.c -= var3;
               }

               if (this.b == 0) {
                  var4 = true;
               } else if (var3 < 0) {
                  throw new C_ig("EOF in stored block");
               }
               break;
            case 8:
               if ((var3 = super.read(var1, var2, var3)) < 0) {
                  if (!this.a_hy.a()) {
                     throw new C_ig("Inflater not finished!?");
                  }

                  this.f = this.a_hy.a_int();
                  if ((this.e & 8) != 0) {
                     if (this.c() != 134695760L) {
                        throw new C_ig("Data descriptor signature not found");
                     }

                     this.a_if_1.d(this.c() & 4294967295L);
                     this.b = this.c();
                     this.c = this.c();
                     this.a_if_1.b(this.c & 4294967295L);
                     this.a_if_1.c(this.b & 4294967295L);
                  }

                  if (this.a_hy.b_int() != this.b || this.a_hy.c() != this.c) {
                     throw new C_ig("size mismatch: " + this.b + ";" + this.c + " <-> " + this.a_hy.b_int() + ";" + this.a_hy.c());
                  }

                  this.a_hy.a_void_2();
                  var4 = true;
               }
         }

         if (var3 > 0) {
            this.a_hn.a(var1, var2, var3);
         }

         if (var4) {
            if ((this.a_hn.a_long() & 4294967295L) != this.a_if_1.d()) {
               throw new C_ig("CRC mismatch");
            }

            this.a_hn.a();
            this.a_if_1 = null;
            this.a_bool_2 = true;
         }

         return var3;
      }
   }

   @Override
   public final void close() throws IOException {
      super.close();
      this.a_hn = null;
      this.a_if_1 = null;
      this.a_bool_2 = true;
   }
}
