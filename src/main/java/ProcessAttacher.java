import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class ProcessAttacher {
   private static HashMap a_HashMap = new HashMap();
   private static int a_int_1 = 62;
   private static int b_int = 3;
   private static int c = 183;
   private static int d = 40;
   private static int e = 8;
   private static int f = 21;
   private static int g = 20;
   private static int h = 243;
   private static int i = 4;
   private static int j = 2;
   private static Object[] a_arr_Object_2 = new Object[7];
   private static Object[] b_arr_Object_1 = new Object[5];

   public static int a(int var0, String var1, String var2, String var3, String var4, OutputStream var5) {
      long[] var6 = new long[1];
      a_arr_Object_2[0] = var6;
      a_arr_Object_2[1] = new long[]{var0};
      a_arr_Object_2[2] = var1;
      a_arr_Object_2[3] = var2;
      a_arr_Object_2[4] = var3;
      a_arr_Object_2[5] = var4;
      a_arr_Object_2[6] = var5;
      Object[] var7 = a_arr_Object_2;
      AgentJarPacker.a();
      DoomsdayGUI.a(var7);
      return (int)var6[0];
   }

   public static void a(List var0) {
      try {
         Object[] var2 = new Object[]{new long[]{1L}, var0, Object.class, List.class, List.class.getMethod("add", Object.class)};
         AgentJarPacker.a();
         DoomsdayGUI.a(var2);
      } catch (Exception var1) {
         throw new RuntimeException(var1);
      }
   }

   private static int c(int var0) {
      File var9 = new File("/proc/".concat(String.valueOf(var0)));
      C_fl var1 = (C_fl)a_HashMap.get(var9.getAbsolutePath());
      long var3 = var9.lastModified();
      if (var1 != null) {
         if (var1.a_long == var3) {
            return var1.a_int_1;
         }

         a_HashMap.remove(var9.getAbsolutePath());
      }

      byte var10 = 0;
      if (var3 != 0L) {
         try {
            RandomAccessFile var2 = new RandomAccessFile(new File(var9, "exe"), "r");
            byte[] var5 = new byte[16];
            var2.read(var5);
            Short.reverseBytes(var2.readShort());
            short var6 = Short.reverseBytes(var2.readShort());
            var2.close();
            if (var6 == a_int_1) {
               if (var5[i] == j) {
                  var10 = 1;
               } else {
                  var10 = 2;
               }
            } else if (var6 == b_int) {
               var10 = 3;
            } else if (var6 == c) {
               var10 = 4;
            } else if (var6 == d) {
               var10 = 6;
            } else if (var6 == e) {
               if (var5[i] == j) {
                  var10 = 7;
               } else {
                  var10 = 8;
               }
            } else if (var6 == f) {
               var10 = 10;
            } else if (var6 == g) {
               var10 = 11;
            } else if (var6 == h) {
               if (var5[i] == j) {
                  var10 = 12;
               } else {
                  var10 = 13;
               }
            }
         } catch (FileNotFoundException var7) {
         } catch (Exception var8) {
            var8.printStackTrace();
         }
      }

      a_HashMap.put(var9.getAbsolutePath(), new C_fl(var3, var10));
      return var10;
   }

   public static int a(int var0) {
      if (!PlatformUtil.j() && !PlatformUtil.k()) {
         Object[] var1 = new Object[2];
         long[] var2 = new long[]{2L};
         var1[0] = var2;
         var1[1] = new long[]{var0};
         AgentJarPacker.a();
         DoomsdayGUI.a(var1);
         return (int)var2[0];
      } else {
         return c(var0);
      }
   }

   public static boolean a(long var0, long var2, byte[] var4, int var5, int[] var6) {
      Object[] var7 = new Object[7];
      long[] var8 = new long[]{4L};
      var7[0] = var8;
      var7[1] = new long[]{var0};
      var7[2] = new long[]{var2};
      var7[3] = var4;
      var7[4] = new long[]{0L};
      var7[5] = new long[]{var5};
      var7[6] = var6;
      AgentJarPacker.a();
      DoomsdayGUI.a(var7);
      return var8[0] == 1L;
   }

   public static C_fk a(int var0, byte[] var1, byte[] var2) {
      long[] var3 = new long[]{3L};
      b_arr_Object_1[0] = var3;
      b_arr_Object_1[1] = new long[]{var0};
      b_arr_Object_1[2] = var1;
      b_arr_Object_1[3] = var2;
      Object[] var4 = b_arr_Object_1;
      AgentJarPacker.a();
      Object var5 = DoomsdayGUI.a(var4);
      C_fk var7 = new C_fk();
      if (var5 != null) {
         var7.a_long_1 = ((long[])var5)[0];
         var7.c = ((long[])var5)[1];
      }

      if (b_arr_Object_1[4] != null) {
         byte[] var6 = (byte[])b_arr_Object_1[4];
         var7.a_String = new String(var6, Charset.forName("UTF-8"));
      }

      var7.b = var3[0];
      return var7;
   }

   public static char[] a_arr_char(int var0) {
      if (PlatformUtil.j()) {
         try {
            Process var6 = new ProcessBuilder("pwdx", Integer.toString(var0)).start();
            String var4;
            int var5 = (var4 = new BufferedReader(new InputStreamReader(var6.getInputStream())).readLine()).indexOf(": ");
            return var4.substring(var5 + 2).toCharArray();
         } catch (Throwable var3) {
            var3.printStackTrace();
            return null;
         }
      } else {
         Object[] var1 = new Object[2];
         long[] var2 = new long[]{5L};
         var1[0] = var2;
         var1[1] = new long[]{var0};
         AgentJarPacker.a();
         return (char[])DoomsdayGUI.a(var1);
      }
   }

   public static long a(String var0, long var1) {
      Object[] var3 = new Object[10];
      long[] var4 = new long[]{6L};
      var3[0] = var4;
      var3[1] = Arrays.copyOf(var0.getBytes(), var0.getBytes().length + 1);
      var3[2] = new long[]{var1};
      var3[3] = new long[]{0L};
      var3[4] = new long[]{1L};
      var3[5] = new long[1];
      var3[6] = new long[1];
      var3[7] = new long[1];
      var3[8] = new long[1];
      AgentJarPacker.a();
      DoomsdayGUI.a(var3);
      return var4[0];
   }

   public static boolean a(long var0) {
      Object[] var2 = new Object[10];
      long[] var3 = new long[]{7L};
      var2[0] = var3;
      var2[1] = new long[]{var0};
      var2[2] = new long[1];
      AgentJarPacker.a();
      DoomsdayGUI.a(var2);
      return var3[0] == 1L;
   }

   public static boolean a(long var0, byte[] var2, int var3) {
      Object[] var4 = new Object[10];
      long[] var5 = new long[]{8L};
      var4[0] = var5;
      var4[1] = new long[]{var0};
      var4[2] = var2;
      var4[3] = new long[]{0L};
      var4[4] = new long[]{var3};
      var4[5] = null;
      var4[6] = new long[1];
      AgentJarPacker.a();
      DoomsdayGUI.a(var4);
      return var5[0] == 1L;
   }

   public static boolean a(long var0, byte[] var2) {
      Object[] var3 = new Object[10];
      long[] var4 = new long[]{9L};
      var3[0] = var4;
      var3[1] = new long[]{var0};
      var3[2] = var2;
      var3[3] = new long[]{0L};
      var3[4] = new long[]{8L};
      var3[5] = null;
      var3[6] = new long[1];
      AgentJarPacker.a();
      DoomsdayGUI.a(var3);
      return var4[0] == 1L;
   }

   public static boolean b(long var0) {
      Object[] var2 = new Object[10];
      long[] var3 = new long[]{10L};
      var2[0] = var3;
      var2[1] = new long[]{var0};
      AgentJarPacker.a();
      DoomsdayGUI.a(var2);
      return var3[0] == 1L;
   }

   public static long a(int var0, int var1) {
      Object[] var2 = new Object[4];
      long[] var3 = new long[]{12L};
      var2[0] = var3;
      var2[1] = new long[]{var0};
      var2[2] = new long[]{0L};
      var2[3] = new long[]{var1};
      AgentJarPacker.a();
      DoomsdayGUI.a(var2);
      return var3[0];
   }

   public static int a_int(List var0) {
      Object[] var1 = new Object[2];
      long[] var2 = new long[]{16L};
      var1[0] = var2;
      var1[1] = var0;
      AgentJarPacker.a();
      DoomsdayGUI.a(var1);
      return (int)var2[0];
   }

   public static char[] b(int var0) {
      if (PlatformUtil.l()) {
         try {
            BufferedReader var5 = new BufferedReader(new FileReader("/proc/" + var0 + "/cmdline"));
            StringBuilder var6 = new StringBuilder();

            while ((var0 = var5.read()) >= 0) {
               var6.append((char)var0);
            }

            var5.close();
            return var6.toString().trim().toCharArray();
         } catch (Exception var3) {
            return null;
         }
      } else {
         Object[] var1 = new Object[2];
         long[] var2 = new long[]{17L};
         var1[0] = var2;
         var1[1] = new long[]{var0};
         AgentJarPacker.a();
         return (char[])DoomsdayGUI.a(var1);
      }
   }

   public static int b_int(int var0) {
      Object[] var1 = new Object[2];
      long[] var2 = new long[]{18L};
      var1[0] = var2;
      var1[1] = new long[]{var0};
      AgentJarPacker.a();
      DoomsdayGUI.a(var1);
      return (int)var2[0];
   }

   public static int a(char[] var0, char[] var1) {
      var0 = Arrays.copyOf(var0, var0.length + 1);
      var1 = Arrays.copyOf(var1, var1.length + 1);
      Object[] var2 = new Object[4];
      long[] var3 = new long[]{19L};
      var2[0] = var3;
      var2[1] = new char[]{'r', 'u', 'n', 'a', 's', '\u0000'};
      var2[2] = var0;
      var2[3] = var1;
      AgentJarPacker.a();
      DoomsdayGUI.a(var2);

      for (int var6 = 0; var6 < var0.length; var6++) {
         var0[var6] = 0;
      }

      for (int var7 = 0; var7 < var1.length; var7++) {
         var1[var7] = 0;
      }

      return (int)var3[0];
   }

   public static long a(Object var0) {
      Object[] var1 = new Object[2];
      long[] var2 = new long[]{20L};
      var1[0] = var2;
      var1[1] = var0;
      AgentJarPacker.a();
      DoomsdayGUI.a(var1);
      return var2[0];
   }

   public static int a_int(long var0) {
      Object[] var2 = new Object[2];
      long[] var3 = new long[]{21L};
      var2[0] = var3;
      var2[1] = new long[]{var0};
      AgentJarPacker.a();
      DoomsdayGUI.a(var2);
      return (int)var3[0];
   }

   public static long a(byte[] var0) {
      Object[] var1 = new Object[2];
      long[] var2 = new long[]{22L};
      var1[0] = var2;
      var1[1] = var0;
      AgentJarPacker.a();
      DoomsdayGUI.a(var1);
      return var2[0];
   }

   public static long a_long_2(long var0) {
      Object[] var2 = new Object[2];
      long[] var3 = new long[]{23L};
      var2[0] = var3;
      var2[1] = new long[]{var0};
      AgentJarPacker.a();
      DoomsdayGUI.a(var2);
      return var3[0];
   }

   public static void a(String var0, ArrayList var1) {
      Object[] var2 = new Object[3];
      long[] var3 = new long[]{24L};
      Object[] var4 = new Object[128];
      var2[0] = var3;
      if (var0 != null) {
         byte[] var5 = var0.getBytes();
         var2[1] = Arrays.copyOf(var5, var5.length + 1);
      }

      var2[2] = var4;
      AgentJarPacker.a();
      DoomsdayGUI.a(var2);

      for (int var6 = 0; var6 < 128; var6++) {
         if (var4[var6] != null) {
            var1.add((byte[])var4[var6]);
         }
      }
   }
}
