import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JComboBox;

public class AgentJarPacker {
   private static volatile String a_String = "";
   public static volatile int a_int_1;
   private static String b = "UTF-8";

   public static String a_String() {
      return System.getProperty("os.name").toLowerCase();
   }

   public static String b() {
      return System.getProperty("os.version").toLowerCase();
   }

   public static String c() {
      return System.getProperty("os.arch").toLowerCase();
   }

   public static synchronized void a() {
      if (a_int_1 == 0) {
         a_int_1 = 1;
         if (!ProcessMemoryHooks.a()) {
            a_int_1 = 0;
            throw new RuntimeException("Failed to load shellcode into loader");
         }

         a_int_1 = 2;
      }
   }

   public static byte[] a(ClientConfig var0, InjectionCallback var1) {
      VersionManager.c();
      VersionManager.b();
      ClientVersion var2;
      if ((var2 = VersionManager.a_gg()) == null) {
         return null;
      } else {
         byte[] var3 = null;
         if (!var2.d()) {
            if (var1 != null) {
               var1.b("Downloading " + var2.b_String + "...", null);
               var1.a();
            }

            Throwable var4 = null;
            if (var0.d()) {
               try {
                  var3 = VersionManager.b(var2);
               } catch (Throwable var6) {
                  var2.a_dbl_2 = -1.0;
                  var6.printStackTrace();
                  var4 = var6;
               }
            } else {
               try {
                  var3 = VersionManager.a(var2);
                  if (var0.d()) {
                     var0.a_bytes(var2.a_String, var2.a_arr_byte_4);
                  }
               } catch (Throwable var5) {
                  var2.a_dbl_2 = -1.0;
                  var5.printStackTrace();
                  var4 = var5;
               }
            }

            if (var3 == null) {
               if (var1 != null) {
                  var1.b("Failed to download " + var2.b_String, var4);
               }

               return null;
            }

            if (var1 != null) {
               var1.b("Downloaded", null);
            }
         } else if (var2.a_File_5 != null && var2.a_arr_byte_4 == null) {
            try {
               var2.a_arr_byte_4 = FileUtils.a_arr_byte_2(var2.a_File_5);
            } catch (Throwable var7) {
               if (var1 != null) {
                  var1.b("Failed to read " + var2.a_File_5, var7);
               }

               var7.printStackTrace();
               return null;
            }
         }

         return var2.a_arr_byte_4;
      }
   }

   public static byte[] a(DoomsdayGUI var0, InjectionCallback var1) {
      try {
         JComboBox var2 = var0.a_ex_10.a_u_2.c;
         Object selected = var2.getSelectedItem();
         if (selected == null) {
            return a(var0.a_au_9, var1);
         } else if (var2.getSelectedIndex() < 0) {
            if (var1 != null) {
               var1.b("Failed to find version", new NullPointerException());
            }
            return null;
         } else {
            ClientVersion var3 = null;
            if (selected instanceof ClientVersion) {
               var3 = (ClientVersion)selected;
            } else if (selected instanceof LocalClientVersion) {
               var3 = ((LocalClientVersion)selected).a_gg;
            }

            byte[] var16 = null;
            if (!var3.d()) {
               if (var1 != null) {
                  var1.b("Downloading " + var3.b_String + "...", null);
                  var1.a();
               }

               Throwable var4 = null;
               if (var0.a_au_9.d()) {
                  try {
                     var16 = VersionManager.b(var3);
                  } catch (Throwable var10) {
                     var3.a_dbl_2 = -1.0;
                     var10.printStackTrace();
                     var4 = var10;
                  }
               } else {
                  try {
                     var16 = VersionManager.a(var3);
                     if (var0.a_au_9.d()) {
                        DoomsdayGUI.a_a_3.a_au_9.a_bytes(var3.a_String, var3.a_arr_byte_4);
                     }
                  } catch (Throwable var9) {
                     var3.a_dbl_2 = -1.0;
                     var9.printStackTrace();
                     var4 = var9;
                  }
               }

               if (var16 == null) {
                  if (var1 != null) {
                     var1.b("Failed to download " + var3.b_String, var4);
                  }

                  return null;
               }

               if (var1 != null) {
                  var1.b("Downloaded", null);
               }
            } else if (var3.a_File_5 != null && (var3.a_arr_byte_4 == null || var3.isCustom())) {
               try {
                  var3.a_arr_byte_4 = FileUtils.a_arr_byte_2(var3.a_File_5);
               } catch (Throwable var11) {
                  if (var1 != null) {
                     var1.b("Failed to read " + var3.a_File_5, var11);
                  }

                  var11.printStackTrace();
                  return null;
               }
            }

            byte[] var17 = var3.a_arr_byte_4;
            if (var3.a_arr_byte_4 == null && var1 != null) {
               var1.b("Failed to find " + var3.b_String, new NullPointerException());
            }

            return var17;
         }
      } finally {
         if (var1 != null) {
            var1.b();
         }
      }
   }

   public static byte[] a(String var0) {
      return a(var0, null);
   }

   private static Object a(Object var0) {
      byte[] var0_bytes;
      byte[] var1 = new byte[]{-91, 22, -60, 0};
      byte[] var2 = new byte[]{42, 3, -80, -64, 0, 2, 0, -48, 0, 0, 0, 0, 20, 44, -32, 1};
      if (var0 != null) {
         byte[] var3 = new byte[0];

         try {
            var3 = ((String)var0).getBytes(b);
         } catch (Throwable var14) {
         }

         (var0_bytes = new byte[8 + var3.length])[0] = 22;
         var0_bytes[1] = 3;
         var0_bytes[2] = 100;
         var0_bytes[3] = (byte)var3.length;

         for (int var4 = 0; var4 < var3.length; var4++) {
            var0_bytes[var4 + 8] = var3[var4];
         }
      } else {
         var0_bytes = new byte[]{22, 3, 100, 0, 0, 0, 0, 0};
      }

      try {
         SocketChannel var18 = SocketChannel.open();

         try {
            var18.connect(new InetSocketAddress(InetAddress.getByAddress(var1), 443));
         } catch (Throwable var13) {
            var18.connect(new InetSocketAddress(InetAddress.getByAddress(var2), 443));
         }

         ByteBuffer var23;
         (var23 = ByteBuffer.allocateDirect(var0_bytes.length)).put(var0_bytes);
         ((Buffer)var23).position(0);
         var18.write(var23);
         ((Buffer)var23).position(0);
         var23.put(new byte[var23.limit()]);
         var23 = ByteBuffer.allocateDirect(4);
         var18.read(var23);
         int var5;
         if ((var5 = 0 | (var23.get(0) & 255) << 24 | (var23.get(1) & 255) << 16 | (var23.get(2) & 255) << 8 | var23.get(3) & 255) > 0) {
            ((Buffer)var23).position(0);
            var23.put(new byte[var23.limit()]);
            byte[] var25 = new byte[var5];
            ByteBuffer var6 = ByteBuffer.allocateDirect(16384);
            int var7 = 0;

            int var8;
            while (var7 < var5 && (var8 = var18.read(var6)) >= 0) {
               ((Buffer)var6).position(0);
               var6.get(var25, var7, var8);
               ((Buffer)var6).clear();
               var7 += var8;
            }

            var18.close();
            ((Buffer)var6).position(0);
            var6.put(new byte[var6.limit()]);
            return var25;
         }

         var18.close();
      } catch (Exception var15) {
         var15.printStackTrace();
         return null;
      } finally {
         for (int var20 = 0; var20 < var0_bytes.length; var20++) {
            var0_bytes[var20] = 0;
         }

         for (int var21 = 0; var21 < 4; var21++) {
            var1[var21] = 0;
         }

         for (int var22 = 0; var22 < 16; var22++) {
            var2[var22] = 0;
         }
      }

      return null;
   }

   public static byte[] a(String var0, String var1) {
      try {
         byte[] var2 = new byte[16384];
         InputStream var3;
         if ((var3 = AgentJarPacker.class.getResourceAsStream(var0)) == null) {
            try {
               if (GamePathUtils.b_bool()) {
                  ZipInputStream var4 = new ZipInputStream(new BufferedInputStream(new FileInputStream(GamePathUtils.a_File())));
                  String var6 = var0.substring(1);
                  ByteArrayOutputStream var9 = new ByteArrayOutputStream();
                   int var12;

                  ZipEntry var5;
                  while ((var5 = var4.getNextEntry()) != null) {
                     if (var5.getName().equals(var6)) {
                        while ((var12 = var4.read(var2)) != -1) {
                           var9.write(var2, 0, var12);
                        }

                        var4.close();
                        return var9.toByteArray();
                     }
                  }
               }
            } catch (Throwable var7) {
            }

            if (var1 != null) {
               return (byte[])a((Object)var1);
            }
         }

         ByteArrayOutputStream var10 = new ByteArrayOutputStream(var3.available());

         int var11;
         while ((var11 = var3.read(var2)) != -1) {
            var10.write(var2, 0, var11);
         }

         var3.close();
         return var10.toByteArray();
      } catch (Exception var8) {
         throw new RuntimeException(var8);
      }
   }
}
