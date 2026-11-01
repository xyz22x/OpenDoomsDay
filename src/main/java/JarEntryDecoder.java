import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class JarEntryDecoder {
   private static Charset a_Charset = Charset.forName("UTF-8");
   public final String a_String_1;
   public final String b_String;
   public final int a_int_2;
   private int b_int_1;
   public final File a_File_3;
   public final byte[] a_arr_byte_4;
   private String c;

   private JarEntryDecoder(String var1, String var2, int var3, int var4, File var5) {
      this.a_String_1 = var1;
      this.b_String = var2;
      this.a_int_2 = var3;
      this.b_int_1 = var4;
      this.a_File_3 = var5;
      this.c = var2;
      this.a_arr_byte_4 = null;
   }

   private JarEntryDecoder(String var1, String var2, int var3, int var4, byte[] var5) {
      this.a_String_1 = var1;
      this.b_String = var2;
      this.a_int_2 = var3;
      this.b_int_1 = var4;
      this.a_File_3 = null;
      this.c = var2;
      this.a_arr_byte_4 = var5;
   }

   @Override
   public final String toString() {
      return this.c;
   }

   public final boolean a() {
      return this.b_int_1 != 0;
   }

   public static JarEntryDecoder[] a(ZipInputStream var0) {
      ArrayList var1 = new ArrayList(5);

      try {
         DataInputStream var2 = new DataInputStream(var0);
         ByteArrayOutputStream var4 = new ByteArrayOutputStream(1000000);
         byte[] var5 = new byte[65536];
         int var13;

         ZipEntry var3;
         while ((var3 = var0.getNextEntry()) != null) {
            if (var3.getName().length() < 20) {
               int[] var6 = new int[1];
               byte[] var7 = new byte[1];
               byte[] var8 = new byte[1];
               if (a(var3.getName(), var6, var7, var8)) {
                  byte[] var9 = new byte[64];

                  try {
                     var2.readFully(var9);
                     String var12;
                     if ((var12 = a((byte[])var9.clone(), var6[0], var7[0], var8[0])) != null) {
                        var4.reset();
                        var4.write(var9);

                        while ((var13 = var0.read(var5)) >= 0) {
                           var4.write(var5, 0, var13);
                        }

                        var1.add(new JarEntryDecoder(var3.getName(), var12, var6[0], var7[0], var4.toByteArray()));
                     }
                  } catch (IOException var10) {
                     var10.printStackTrace();
                  }
               }
            }
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      return (JarEntryDecoder[])var1.toArray(new JarEntryDecoder[0]);
   }

   public static int a(String var0) {
      int[] var1 = new int[1];
      return a(var0, var1, null, null) ? var1[0] : 0;
   }

   private static String a(byte[] var0, int var1, byte var2, byte var3) {
      if (0 + ((var0[0] & 255) << 24) + ((var0[1] & 255) << 16) + ((var0[2] & 255) << 8) + (var0[3] & 255) != var1) {
         return null;
      } else if (var3 != var0[4]) {
         return null;
      } else if (var2 != var0[5]) {
         return null;
      } else {
         var1 = 0;

         for (int var9 = 6; var9 < 64; var9++) {
            var0[var9] = (byte)(var0[var9] ^ 71);
            if (var0[var9] == 0 && var1 == 0) {
               var1 = var9;
            }
         }

         if (var1 == 0) {
            var1 = 64;
         }

         int var4 = var1 - 6;
         byte[] var10 = var0;
         byte var5 = 0;
         byte var6 = 0;
         var4 += 6;

         for (int var7 = 6; var7 < var4; var7++) {
            var5 += var10[var7];
            var6 += var5;
         }

         return (byte)(var5 ^ var6) != var3 ? null : new String(var0, 6, var1 - 6, a_Charset);
      }
   }

   public static JarEntryDecoder[] a(File var0) {
      if (!var0.exists()) {
         return null;
      } else if (!var0.isDirectory()) {
         return null;
      } else {
         File[] var10;
         if ((var10 = var0.listFiles()) == null) {
            return null;
         } else {
            ArrayList var1 = new ArrayList(var10.length);
            int[] var2 = new int[1];
            byte[] var3 = new byte[1];
            byte[] var4 = new byte[1];

            for (int var5 = 0; var5 < var10.length; var5++) {
               String var6;
               if (a(var6 = var10[var5].getName(), var2, var3, var4) && var10[var5].length() > 64L) {
                  try {
                     RandomAccessFile var7 = new RandomAccessFile(var10[var5], "r");
                     byte[] var8 = new byte[64];
                     var7.readFully(var8);
                     var7.close();
                     String var11;
                     if ((var11 = a(var8, var2[0], var3[0], var4[0])) != null) {
                        var1.add(new JarEntryDecoder(var6, var11, var2[0], var3[0], var10[var5]));
                     }
                  } catch (Exception var9) {
                     var9.printStackTrace();
                  }
               }
            }

            return (JarEntryDecoder[])var1.toArray(new JarEntryDecoder[0]);
         }
      }
   }

   private static boolean a(String var0, int[] var1, byte[] var2, byte[] var3) {
      try {
         if (var0 == null) {
            throw new NumberFormatException("null");
         }

         int var4;
         if ((var4 = var0.length()) > 0) {
            if (var0.charAt(0) == '-') {
               throw new NumberFormatException(String.format("Illegal leading minus sign on unsigned string %s.", var0));
            }

            long var10000;
            if (var4 <= 12) {
               var10000 = Long.parseLong(var0, 32);
            } else {
               long var6 = Long.parseLong(var0.substring(0, var4 - 1), 32);
               if ((var4 = Character.digit(var0.charAt(var4 - 1), 32)) < 0) {
                  throw new NumberFormatException("Bad digit at end of ".concat(String.valueOf(var0)));
               }

               long var8;
               var10000 = (var8 = (var6 << 5) + var4) + Long.MIN_VALUE;
               long var12 = var6 + Long.MIN_VALUE;
               long var10 = var10000;
               if ((var10000 < var12 ? -1 : (var10 == var12 ? 0 : 1)) < 0) {
                  throw new NumberFormatException(String.format("String value %s exceeds range of unsigned long.", var0));
               }

               var10000 = var8;
            }

            long var18 = var10000 ^ 4773789072989332985L;
            byte[] var16;
            (var16 = new byte[8])[0] = (byte)(var18 >>> 56 & 255L);
            var16[1] = (byte)(var18 >>> 48 & 255L);
            var16[2] = (byte)(var18 >>> 40 & 255L);
            var16[3] = (byte)(var18 >>> 32 & 255L);
            var16[4] = (byte)(var18 >>> 24 & 255L);
            var16[5] = (byte)(var18 >>> 16 & 255L);
            var16[6] = (byte)(var18 >>> 8 & 255L);
            var16[7] = (byte)(var18 & 255L);
            int var19 = (short)((short)(0 + ((var16[6] & 255) << 8)) + (var16[7] & 255));
            CRC32 var5;
            (var5 = new CRC32()).update(var16, 0, 6);
            if ((short)var5.getValue() != var19) {
               return false;
            }

            var19 = 0 + ((var16[1] & 255) << 24) + ((var16[2] & 255) << 16) + ((var16[3] & 255) << 8) + (var16[4] & 255);
            if (var3 != null) {
               var3[0] = var16[0];
            }

            var1[0] = var19;
            if (var2 != null) {
               var2[0] = var16[5];
            }

            return true;
         }

         throw new IllegalArgumentException();
      } catch (NumberFormatException var14) {
      } catch (Exception var15) {
         var15.printStackTrace();
      }

      return false;
   }
}
