import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class C_if {
   private static Calendar a_Calendar;
   private String a_String_1;
   private int c;
   private long a_long_2 = -1L;
   private int d;
   private int e;
   private short a_short_3 = 0;
   private short b_short = -1;
   private byte[] a_arr_byte_4 = null;
   private String b_String_1 = null;
   int a_int_5;
   int b_int_2;

   public C_if(String var1) {
      int var2;
      if ((var2 = var1.length()) > 65535) {
         throw new IllegalArgumentException("name length is ".concat(String.valueOf(var2)));
      } else {
         this.a_String_1 = var1;
      }
   }

   final void a(int var1) {
      this.e = var1;
      this.a_short_3 = (short)(this.a_short_3 | 8);
   }

   final int a_int_2() {
      return (this.a_short_3 & 8) == 0 ? 0 : this.e;
   }

   public final String a_String_4() {
      return this.a_String_1;
   }

   public final void a_void_3() {
      Calendar var1;
      synchronized (var1 = b_Calendar_3()) {
         Date var3 = new Date(1454328000000L);
         var1.setTime(var3);
         this.e = (var1.get(1) - 1980 & 127) << 25 | var1.get(2) + 1 << 21 | var1.get(5) << 16 | var1.get(11) << 11 | var1.get(12) << 5 | var1.get(13) >> 1;
      }

      this.a_short_3 = (short)(this.a_short_3 | 8);
   }

   public final void a(long var1) {
      Calendar var3;
      synchronized (var3 = a()) {
         Date var6 = new Date(var1);
         var3.setTime(var6);
         this.e = (var3.get(1) - 1980 & 127) << 25 | var3.get(2) + 1 << 21 | var3.get(5) << 16 | var3.get(11) << 11 | var3.get(12) << 5 | var3.get(13) >> 1;
      }

      this.a_short_3 = (short)(this.a_short_3 | 8);
   }

   public final long a_long() {
      C_if var1 = this;
      if ((this.a_short_3 & 16) == 0) {
         if (this.a_arr_byte_4 == null) {
            this.a_short_3 = (short)(this.a_short_3 | 16);
         } else {
            try {
               int var2 = 0;

               while (var2 < var1.a_arr_byte_4.length) {
                  int var3 = var1.a_arr_byte_4[var2++] & 255 | (var1.a_arr_byte_4[var2++] & 255) << 8;
                  int var4 = var1.a_arr_byte_4[var2++] & 255 | (var1.a_arr_byte_4[var2++] & 255) << 8;
                  if (var3 == 21589 && (var1.a_arr_byte_4[var2] & 1) != 0) {
                     long var8 = var1.a_arr_byte_4[var2 + 1] & 255
                        | (var1.a_arr_byte_4[var2 + 2] & 255) << 8
                        | (var1.a_arr_byte_4[var2 + 3] & 255) << 16
                        | (var1.a_arr_byte_4[var2 + 4] & 255) << 24;
                     var1.a(var8 * 1000L);
                  }

                  var2 += var4;
               }
            } catch (ArrayIndexOutOfBoundsException var12) {
            }

            var1.a_short_3 = (short)(var1.a_short_3 | 16);
         }
      }

      if ((this.a_short_3 & 8) == 0) {
         return -1L;
      } else {
         int var13 = 2 * (this.e & 31);
         int var18 = this.e >> 5 & 63;
         int var19 = this.e >> 11 & 31;
         int var20 = this.e >> 16 & 31;
         int var5 = (this.e >> 21 & 15) - 1;
         int var6 = (this.e >> 25 & 127) + 1980;

         try {
            synchronized (a_Calendar = a()) {
               a_Calendar.set(1, var6);
               a_Calendar.set(2, var5);
               a_Calendar.set(5, var20);
               a_Calendar.set(11, var19);
               a_Calendar.set(12, var18);
               a_Calendar.set(13, var13);
               return a_Calendar.getTime().getTime();
            }
         } catch (RuntimeException var11) {
            this.a_short_3 = (short)(this.a_short_3 & -9);
            return -1L;
         }
      }
   }

   private static synchronized Calendar a() {
      if (a_Calendar == null) {
         a_Calendar = Calendar.getInstance();
      }

      return a_Calendar;
   }

   private static synchronized Calendar b_Calendar_3() {
      if (a_Calendar == null) {
         a_Calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
      }

      return a_Calendar;
   }

   public final void b(long var1) {
      if ((var1 & -4294967296L) != 0L) {
         throw new IllegalArgumentException();
      } else {
         this.c = (int)var1;
         this.a_short_3 = (short)(this.a_short_3 | 1);
      }
   }

   public final long b() {
      return (this.a_short_3 & 1) != 0 ? this.c & 4294967295L : -1L;
   }

   public final void c(long var1) {
      this.a_long_2 = var1;
   }

   public final long c() {
      return this.a_long_2;
   }

   public final void d(long var1) {
      if ((var1 & -4294967296L) != 0L) {
         throw new IllegalArgumentException();
      } else {
         this.d = (int)var1;
         this.a_short_3 = (short)(this.a_short_3 | 4);
      }
   }

   public final long d() {
      return (this.a_short_3 & 4) != 0 ? this.d & 4294967295L : -1L;
   }

   public final void b(int var1) {
      if (var1 != 0 && var1 != 8) {
         throw new IllegalArgumentException();
      } else {
         this.b_short = (short)var1;
      }
   }

   public final int b_int_2() {
      return this.b_short;
   }

   public final void a(byte[] var1) {
      if (var1.length > 65535) {
         throw new IllegalArgumentException();
      } else {
         this.a_arr_byte_4 = var1;
      }
   }

   public final byte[] a_arr_byte_5() {
      return this.a_arr_byte_4;
   }

   public final String b_String() {
      return this.b_String_1;
   }

   @Override
   public final String toString() {
      return this.a_String_1;
   }

   @Override
   public final int hashCode() {
      return this.a_String_1.hashCode();
   }
}
