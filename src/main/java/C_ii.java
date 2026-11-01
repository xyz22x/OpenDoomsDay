import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;

public final class C_ii extends C_hu {
   private Vector a_Vector = new Vector();
   private C_hn a_hn_1 = new C_hn();
   private C_if a_if_2 = null;
   private int a_int_3;
   private int b;
   private int c = 0;
   private byte[] a_arr_byte_4 = new byte[0];
   private int d = 8;

   public C_ii(OutputStream var1) {
      super(var1, new C_hp(true));
   }

   public final void b() {
      this.a_hp_1.a(9);
   }

   private void a(int var1) throws IOException {
      this.a.write(var1 & 0xFF);
      this.a.write(var1 >> 8 & 0xFF);
   }

   private void b(int var1) throws IOException {
      this.a(var1);
      this.a(var1 >> 16);
   }

   public final void a(C_if var1) throws IOException {
      byte[] var6;
      if (this.a_Vector == null) {
         throw new C_ig("ZipOutputStream was finished");
      } else {
         int var2 = var1.b_int_2();
         byte var3 = 0;
         if (var2 == -1) {
            var2 = this.d;
         }

         if (var2 == 0) {
            if (var1.c() >= 0L) {
               if (var1.b() < 0L) {
                  var1.b(var1.c());
               } else if (var1.b() != var1.c()) {
                  throw new C_ig("Method STORED, but compressed size != size");
               }
            } else {
               var1.c(var1.b());
            }

            if (var1.b() < 0L) {
               throw new C_ig("Method STORED, but size not set");
            }

            if (var1.d() < 0L) {
               throw new C_ig("Method STORED, but crc not set");
            }
         } else if (var2 == 8 && (var1.c() < 0L || var1.b() < 0L || var1.d() < 0L)) {
            var3 = 8;
         }

         if (this.a_if_2 != null) {
            this.c();
         }

         if (var1.a_long() < 0L) {
            var1.a(System.currentTimeMillis());
         }

         var1.a_int_5 = var3;
         var1.b_int_2 = this.c;
         var1.b(var2);
         this.a_int_3 = var2;
         this.b(67324752);
         this.a(var2 == 0 ? 10 : 20);
         this.a(var3);
         this.a(var2);
         this.b(var1.a_int_2());
         if ((var3 & 8) == 0) {
            this.b((int)var1.d());
            this.b((int)var1.c());
            this.b((int)var1.b());
         } else {
            this.b(0);
            this.b(0);
            this.b(0);
         }

         try {
            var6 = var1.a_String_4().getBytes("UTF-8");
         } catch (UnsupportedEncodingException var5) {
            throw new Error();
         }

         if (var6.length > 65535) {
            throw new C_ig("Name too long.");
         } else {
            byte[] var4;
            if ((var4 = var1.a_arr_byte_5()) == null) {
               var4 = new byte[0];
            }

            this.a(var6.length);
            this.a(var4.length);
            this.a.write(var6);
            this.a.write(var4);
            this.c += 30 + var6.length + var4.length;
            this.a_if_2 = var1;
            this.a_hn_1.a();
            if (var2 == 8) {
               this.a_hp_1.a();
            }

            this.b = 0;
         }
      }
   }

   public final void c() throws IOException {
      if (this.a_if_2 == null) {
         throw new C_ig("No open entry");
      } else {
         if (this.a_int_3 == 8) {
            super.a();
         }

         int var1 = this.a_int_3 == 8 ? this.a_hp_1.a_int() : this.b;
         if (this.a_if_2.b() < 0L) {
            this.a_if_2.b((long)this.b);
         } else if (this.a_if_2.b() != this.b) {
            throw new C_ig("size was " + this.b + ", but I expected " + this.a_if_2.b());
         }

         if (this.a_if_2.c() < 0L) {
            this.a_if_2.c(var1);
         } else if (this.a_if_2.c() != var1) {
            throw new C_ig("compressed size was " + var1 + ", but I expected " + this.a_if_2.b());
         }

         if (this.a_if_2.d() < 0L) {
            this.a_if_2.d(this.a_hn_1.a_long());
         } else if (this.a_if_2.d() != this.a_hn_1.a_long()) {
            throw new C_ig("crc was " + Long.toString(this.a_hn_1.a_long(), 16) + ", but I expected " + Long.toString(this.a_if_2.d(), 16));
         }

         this.c += var1;
         if (this.a_int_3 == 8 && (this.a_if_2.a_int_5 & 8) != 0) {
            this.b(134695760);
            this.b((int)this.a_if_2.d());
            this.b((int)this.a_if_2.c());
            this.b((int)this.a_if_2.b());
            this.c += 16;
         }

         this.a_Vector.addElement(this.a_if_2);
         this.a_if_2 = null;
      }
   }

   @Override
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if (this.a_if_2 == null) {
         throw new C_ig("No open entry.");
      } else {
         switch (this.a_int_3) {
            case 0:
               this.a.write(var1, var2, var3);
               break;
            case 8:
               super.write(var1, var2, var3);
         }

         this.a_hn_1.a(var1, var2, var3);
         this.b += var3;
      }
   }

   @Override
   public final void a() throws IOException {
      if (this.a_Vector != null) {
         if (this.a_if_2 != null) {
            this.c();
         }

         int var1 = 0;
         int var2 = 0;
         Enumeration var3 = this.a_Vector.elements();
         byte[] var10;
         byte[] var11;

         while (var3.hasMoreElements()) {
            C_if var4;
            int var5 = (var4 = (C_if)var3.nextElement()).b_int_2();
            this.b(33639248);
            this.a(var5 == 0 ? 10 : 20);
            this.a(var5 == 0 ? 10 : 20);
            this.a(var4.a_int_5);
            this.a(var5);
            this.b(var4.a_int_2());
            this.b((int)var4.d());
            this.b((int)var4.c());
            this.b((int)var4.b());

            try {
               var10 = var4.a_String_4().getBytes("UTF-8");
            } catch (UnsupportedEncodingException var8) {
               throw new Error();
            }

            if (var10.length > 65535) {
               throw new C_ig("Name too long.");
            }

            byte[] var6;
            if ((var6 = var4.a_arr_byte_5()) == null) {
               var6 = new byte[0];
            }

            String var7 = var4.b_String();

            try {
               var11 = var7 != null ? var7.getBytes("UTF-8") : new byte[0];
            } catch (UnsupportedEncodingException var9) {
               throw new Error();
            }

            if (var11.length > 65535) {
               throw new C_ig("Comment too long.");
            }

            this.a(var10.length);
            this.a(var6.length);
            this.a(var11.length);
            this.a(0);
            this.a(0);
            this.b(0);
            this.b(var4.b_int_2);
            this.a.write(var10);
            this.a.write(var6);
            this.a.write(var11);
            var1++;
            var2 += 46 + var10.length + var6.length + var11.length;
         }

         this.b(101010256);
         this.a(0);
         this.a(0);
         this.a(var1);
         this.a(var1);
         this.b(var2);
         this.b(this.c);
         this.a(this.a_arr_byte_4.length);
         this.a.write(this.a_arr_byte_4);
         this.a.flush();
         this.a_Vector = null;
      }
   }
}
