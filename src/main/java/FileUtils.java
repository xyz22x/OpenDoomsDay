import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.zip.ZipEntry;
import javax.swing.AbstractButton;

public final class FileUtils {
   static Charset a_Charset = Charset.forName("UTF-8");
   private static long[] a_arr_long_1;

   static {
      long[] var0 = new long[256];
      long var1 = 6074001001750140548L;

      for (int var3 = 0; var3 < 256; var3++) {
         for (int var4 = 0; var4 < 31; var4++) {
            long var5;
            long var6;
            var1 = (var6 = (var5 = var1 >>> 7 ^ var1) << 11 ^ var5) >>> 10 ^ var6;
         }

         var0[var3] = var1;
      }

      a_arr_long_1 = var0;
   }

   public static void a(AbstractButton var0) {
      ActionListener[] var1;
      for (int var2 = (var1 = var0.getActionListeners()).length - 1; var2 >= 0; var2--) {
         var0.removeActionListener(var1[var2]);
      }
   }

   public static String a_String(byte[] var0) {
      return a(var0, var0.length);
   }

   private static String a(byte[] var0, int var1) {
      MessageDigest var2 = null;

      try {
         var2 = MessageDigest.getInstance("SHA-1");
      } catch (NoSuchAlgorithmException var3) {
         var3.printStackTrace();
      }

      var2.update(var0, 0, var1);
      var0 = var2.digest();
      StringBuilder var6 = new StringBuilder();

      for (int var5 = 0; var5 < var0.length; var5++) {
         var6.append(Integer.toString((var0[var5] & 255) + 256, 16).substring(1));
      }

      return var6.toString();
   }

   private static File a(File var0) {
      String var1 = var0.getParent();
      StringBuilder var2 = new StringBuilder();
      Random var3 = new Random();

      for (int var4 = 0; var4 < var0.getName().length(); var4++) {
         char var5 = (char)var3.nextInt(26);
         if (var3.nextBoolean()) {
            var5 = (char)(var5 + 'a');
         } else {
            var5 = (char)(var5 + 'A');
         }

         var2.append(var5);
      }

      return new File(var1, var2.toString());
   }

   public static void a_void(File var0) {
      try {
         Random var1 = new Random();
         FileOutputStream var2 = new FileOutputStream(var0);
         byte[] var3 = new byte[(int)var0.length()];
         var1.nextBytes(var3);
         var2.write(var3);
         var2.close();
         File var4 = a(var0);
         a(var0, var4);
      } catch (Exception var_e) {
         throw new RuntimeException(var_e);
      }
   }

   private static boolean a(File var0, File var1) {
      boolean var7 = false;
      try {
         Path var8 = var0.toPath();
      
         Path var3 = var1.toPath();
         Files.move(var8, var3, StandardCopyOption.ATOMIC_MOVE);
         Files.delete(var3);
         Random var9 = new Random();
         var1.setLastModified(System.currentTimeMillis() - 86400000L - var9.nextInt(86400000));
         Files.createDirectory(var3);
         var1.setLastModified(System.currentTimeMillis() - 86400000L - var9.nextInt(86400000));
         Files.delete(var3);
         var7 = true;
      } catch (NoClassDefFoundError var4) {
         var7 = var0.delete();
      } catch (NoSuchMethodError var5) {
         var7 = var0.delete();
      } catch (Throwable var6) {
         var7 = var0.delete();
         var6.printStackTrace();
      }

      return var7;
   }

   public static void a(ZipEntry var0) {
      try {
         ZipEntry var1 = var0;

         try {
            FileTime var2 = FileTime.fromMillis(1454328000000L);
            var1.setCreationTime(var2);
            var1.setLastAccessTime(var2);
            var1.setLastModifiedTime(var2);
         } catch (NoClassDefFoundError var3) {
         } catch (NoSuchMethodError var4) {
         } catch (Throwable var5) {
            var5.printStackTrace();
         }

         var0.setTime(1454328000000L);
      } catch (NoClassDefFoundError var6) {
      } catch (NoSuchMethodError var7) {
      } catch (Throwable var8) {
         var8.printStackTrace();
      }

      var0.setTime(1454328000000L);
   }

   public static void a(String var0, OutputStream var1) {
      try {
         try {
            Files.copy(Paths.get(var0), var1);
         } catch (NoClassDefFoundError var2) {
         } catch (Throwable var3) {
            if (!var3.getClass().getName().equals("java.nio.file.AccessDeniedException")) {
               var3.printStackTrace();
            }
         }
      } catch (NoClassDefFoundError var4) {
      } catch (Throwable var5) {
         if (!var5.getClass().getName().equals("java.nio.file.AccessDeniedException")) {
            var5.printStackTrace();
         }
      }
   }

   public static boolean a_bool(String var0) {
      try {
         Paths.get(var0);
      } catch (NoClassDefFoundError var1) {
      } catch (Throwable var2) {
         if (var2.getClass().getName().equals("java.nio.file.InvalidPathException")) {
            return false;
         }
      }

      return true;
   }

   public static void a_void(File var0, File var1) {
      a(var1, a_arr_byte_2(var0));
   }

   public static Object[] a(Object[] var0) {
      Object[] var1 = new Object[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = var0[var2];
      }

      return var1;
   }

   public static void a(File var0, byte[] var1) {
      try {
         FileOutputStream var2;
         (var2 = new FileOutputStream(var0)).write(var1);
         var2.close();
      } catch (Exception var_e) {
         throw new RuntimeException(var_e);
      }
   }

   public static byte[] a_arr_byte_2(File var0) {
      try {
         RandomAccessFile var1 = new RandomAccessFile(var0, "r");
         byte[] var2 = new byte[(int)var0.length()];
         var1.readFully(var2);
         var1.close();
         return var2;
      } catch (Exception var_e) {
         throw new RuntimeException(var_e);
      }
   }

   public static byte[] a(long var0) {
      try {
         ByteArrayOutputStream var2 = new ByteArrayOutputStream(8);
         new DataOutputStream(var2).writeLong(var0);
         return var2.toByteArray();
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   public static void a(Throwable var0) {
      if (var0 instanceof RuntimeException) throw (RuntimeException)var0;
      if (var0 instanceof Error) throw (Error)var0;
      throw new RuntimeException(var0);
   }

   public static String a(String var0) {
      return var0.replace("\\", "\\x5C").replace(" ", "\\x20");
   }

   public static String b(String var0) {
      StringBuilder var1 = new StringBuilder();

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3;
         if ((var3 = var0.charAt(var2)) == '\\') {
            if (var2 + 3 >= var0.length()) {
               break;
            }

            if (var0.charAt(var2 + 1) == 'x' && a(var0.charAt(var2 + 2)) && a(var0.charAt(var2 + 3))) {
               char var10001 = var0.charAt(var2 + 2);
               char var4 = var0.charAt(var2 + 3);
               var3 = var10001;
               char var5 = 0;
               char var6 = 0;
               if (var3 >= '0' && var3 <= '9') {
                  var5 = (char)(var3 - '0');
               }

               if (var3 >= 'A' && var3 <= 'F') {
                  var5 = (char)(var3 - 'A' + 10);
               }

               if (var3 >= 'a' && var3 <= 'f') {
                  var5 = (char)(var3 - 'a' + 10);
               }

               if (var4 >= '0' && var4 <= '9') {
                  var6 = (char)(var4 - '0');
               }

               if (var4 >= 'A' && var4 <= 'F') {
                  var6 = (char)(var4 - 'A' + 10);
               }

               if (var4 >= 'a' && var4 <= 'f') {
                  var6 = (char)(var4 - 'a' + 10);
               }

               var1.append((char)(var5 << 4 | var6));
            }

            var2 += 3;
         } else {
            var1.append(var3);
         }
      }

      return var1.toString();
   }

   private static boolean a(char var0) {
      if (var0 >= '0' && var0 <= '9') {
         return true;
      } else {
         return var0 >= 'A' && var0 <= 'F' ? true : var0 >= 'a' && var0 <= 'f';
      }
   }

   public static long a(byte[] var0) {
      long var1 = -4953706369002393500L;
      long[] var3 = a_arr_long_1;
      int var4 = var0.length;

      for (int var5 = 0; var5 < var4; var5++) {
         var1 = var1 * 7664345821815920749L ^ var3[var0[var5] & 255];
      }

      return var1;
   }
}
