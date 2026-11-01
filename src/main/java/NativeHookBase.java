import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Arrays;

public abstract class NativeHookBase {
   private long a_long;
   private RandomAccessFile a_RandomAccessFile_1;

   public NativeHookBase() {
      this.a();
   }

   private void a() {
      try {
         BufferedReader var1 = new BufferedReader(new FileReader("/proc/self/maps"));
         long var3 = 0L;
         String var5 = null;

         String var2;
         while ((var2 = var1.readLine()) != null) {
            int var6;
            if ((var6 = var2.indexOf("libjava.so")) != -1) {
               int var7 = var2.indexOf(45);
               var3 = Long.parseLong(var2.substring(0, var7), 16);
               int var9;
               if ((var9 = var2.indexOf(47)) < 0) {
                  var9 = var2.lastIndexOf(32, var6) + 1;
               }

               var5 = var2.substring(var9);
               break;
            }
         }

         var1.close();
         long var10;
         if ((var10 = a(var5, "Java_java_io_RandomAccessFile_length")) == 0L) {
            var10 = a(var5, "Java_java_io_RandomAccessFile_length0");
         }

         if (var10 == 0L) {
            throw new RuntimeException("RandomAccessFile_length not found");
         } else {
            this.a_long = var3 + var10;
            this.a_RandomAccessFile_1 = new RandomAccessFile("/proc/self/mem", "rw");
         }
      } catch (Exception var8) {
         FileUtils.a(var8);
      }
   }

   private static long a(String var0, String var1) throws java.io.IOException {
      RandomAccessFile var28 = new RandomAccessFile(var0, "r");
      byte[] var2 = new byte[16];
      var28.read(var2);
      short var3;
      short var4;
      long var5;
      short var7;
      if (var2[4] == 1) {
         Short.reverseBytes(var28.readShort());
         Short.reverseBytes(var28.readShort());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         var5 = Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Short.reverseBytes(var28.readShort());
         Short.reverseBytes(var28.readShort());
         Short.reverseBytes(var28.readShort());
         var4 = Short.reverseBytes(var28.readShort());
         var3 = Short.reverseBytes(var28.readShort());
         var7 = Short.reverseBytes(var28.readShort());
      } else {
         if (var2[4] != 2) {
            var28.close();
            throw new RuntimeException("Unsupported");
         }

         Short.reverseBytes(var28.readShort());
         Short.reverseBytes(var28.readShort());
         Integer.reverseBytes(var28.readInt());
         Long.reverseBytes(var28.readLong());
         Long.reverseBytes(var28.readLong());
         var5 = Long.reverseBytes(var28.readLong());
         Integer.reverseBytes(var28.readInt());
         Short.reverseBytes(var28.readShort());
         Short.reverseBytes(var28.readShort());
         Short.reverseBytes(var28.readShort());
         var4 = Short.reverseBytes(var28.readShort());
         var3 = Short.reverseBytes(var28.readShort());
         var7 = Short.reverseBytes(var28.readShort());
      }

      var28.seek(var5 + var7 * var4);
      long var8;
      if (var2[4] == 1) {
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         int var11 = Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         var8 = var11;
      } else {
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Long.reverseBytes(var28.readLong());
         Long.reverseBytes(var28.readLong());
         long var13 = Long.reverseBytes(var28.readLong());
         Long.reverseBytes(var28.readLong());
         Integer.reverseBytes(var28.readInt());
         Integer.reverseBytes(var28.readInt());
         Long.reverseBytes(var28.readLong());
         Long.reverseBytes(var28.readLong());
         var8 = var13;
      }

      var28.seek(var5);
      byte[] var29 = new byte[7];
      byte[] var30 = ".dynstr".getBytes(Charset.forName("UTF-8"));
      byte[] var6 = ".dynsym".getBytes(Charset.forName("UTF-8"));
      long var10 = 0L;
      long var12 = 0L;
      long var14 = 0L;
      long var16 = 0L;

      for (int var18 = 0; var18 < var3; var18++) {
         int var19;
         long var20;
         long var22;
         long var24;
         if (var2[4] == 1) {
            var7 = (short)Integer.reverseBytes(var28.readInt());
            var19 = Integer.reverseBytes(var28.readInt());
            Integer.reverseBytes(var28.readInt());
            Integer.reverseBytes(var28.readInt());
            var20 = Integer.reverseBytes(var28.readInt());
            var22 = Integer.reverseBytes(var28.readInt());
            Integer.reverseBytes(var28.readInt());
            Integer.reverseBytes(var28.readInt());
            Integer.reverseBytes(var28.readInt());
            var24 = Integer.reverseBytes(var28.readInt());
         } else {
            var7 = (short)Integer.reverseBytes(var28.readInt());
            var19 = Integer.reverseBytes(var28.readInt());
            Long.reverseBytes(var28.readLong());
            Long.reverseBytes(var28.readLong());
            var20 = Long.reverseBytes(var28.readLong());
            var22 = Long.reverseBytes(var28.readLong());
            Integer.reverseBytes(var28.readInt());
            Integer.reverseBytes(var28.readInt());
            Long.reverseBytes(var28.readLong());
            var24 = Long.reverseBytes(var28.readLong());
         }

         if (var19 == 3) {
            long var26 = var28.getFilePointer();
            var28.seek(var8 + var7);
            var28.readFully(var29);
            var28.seek(var26);
            if (Arrays.equals(var29, var30)) {
               var10 = var20;
               var12 = var22;
            }
         } else if (var19 == 11) {
            long var35 = var28.getFilePointer();
            var28.seek(var8 + var7);
            var28.readFully(var29);
            var28.seek(var35);
            if (Arrays.equals(var29, var6)) {
               var14 = var20;
               var16 = var22 / var24;
            }
         }

         if (var14 != 0L && var10 != 0L) {
            break;
         }
      }

      long var33;
      if ((var33 = a(var28, var10, var12, var1)) != 0L) {
         var28.seek(var14);

         for (int var32 = 0; var32 < var16; var32++) {
            int var21;
            long var34;
            if (var2[4] == 1) {
               var21 = Integer.reverseBytes(var28.readInt());
               var34 = Integer.reverseBytes(var28.readInt());
               Integer.reverseBytes(var28.readInt());
               var28.read();
               var28.read();
               Short.reverseBytes(var28.readShort());
            } else {
               var21 = Integer.reverseBytes(var28.readInt());
               var28.readByte();
               var28.readByte();
               Short.reverseBytes(var28.readShort());
               var34 = Long.reverseBytes(var28.readLong());
               Long.reverseBytes(var28.readLong());
            }

            if (var33 == var21) {
               return var34;
            }
         }
      }

      return 0L;
   }

   private static long a(RandomAccessFile var0, long var1, long var3, String var5) throws java.io.IOException {
      int var8 = 0;
      int var9 = 0;
      var0.seek(var1);

      for (long var6 = 0L; var6 < var3; var6++) {
         int var10;
         if ((var10 = var0.read()) == -1) {
            return 0L;
         }

         if (var10 != 0) {
            var9++;
         }

         if (var10 == 0 && var8 == var5.length() || var8 < var5.length() && var10 == var5.charAt(var8)) {
            if (var10 == 0) {
               if (var9 == var5.length()) {
                  return var6 - var8;
               }

               var8 = 0;
            } else {
               var8++;
            }
         } else {
            var8 = 0;
         }

         if (var10 == 0) {
            var9 = 0;
         }
      }

      return 0L;
   }

   private long a_long(byte[] var1) {
      try {
         byte[] var2 = new byte[var1.length];
         this.a_RandomAccessFile_1.seek(this.a_long);
         this.a_RandomAccessFile_1.readFully(var2);
         this.a_RandomAccessFile_1.seek(this.a_long);
         this.a_RandomAccessFile_1.write(var1);
         long var3 = this.a_RandomAccessFile_1.length();
         this.a_RandomAccessFile_1.seek(this.a_long);
         this.a_RandomAccessFile_1.write(var2);
         return var3;
      } catch (Exception var5) {
         throw new RuntimeException(var5);
      }
   }

   public final long a_long(long var1, long var3, long var5) {
      byte[] var7 = this.a(var1, var3, var5);
      return this.a_long(var7);
   }

   public final long a_long(long var1, long var3, long var5, long var7) {
      byte[] var9 = this.a(var1, var3, var5, var7);
      return this.a_long(var9);
   }

   public final long b(long var1, long var3, long var5, long var7) {
      byte[] var9 = this.b_arr_byte(var1, var3, var5, var7);
      return this.a_long(var9);
   }

   public final long b_long(long var1, long var3, long var5) {
      byte[] var7 = this.b(var1, var3, var5);
      return this.a_long(var7);
   }

   public abstract byte[] a(long var1, long var3, long var5);

   public abstract byte[] a(long var1, long var3, long var5, long var7);

   public abstract byte[] b_arr_byte(long var1, long var3, long var5, long var7);

   public abstract byte[] b(long var1, long var3, long var5);
}
