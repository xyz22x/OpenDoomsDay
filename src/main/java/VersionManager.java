import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipInputStream;

public final class VersionManager {
   private static byte[] a_arr_byte = new byte[]{-91, 22, -60, 0};
   private static byte[] b_arr_byte = new byte[]{42, 3, -80, -64, 0, 2, 0, -48, 0, 0, 0, 0, 20, 44, -32, 1};
   private static String a_String_1 = "doomsdayclient.com";
   private static String b_String_1 = "doomsdayclient.xyz";
   private static String c_String = null;
   private static int a_int_2 = 3;
   private static int b_int_2 = 0;
   private static Comparator a_Comparator_3 = new VersionComparator();
   private static HashMap a_HashMap_4 = new HashMap();
   public static ArrayList a_ArrayList_5 = new ArrayList();
   public static ArrayList b_ArrayList_3 = new ArrayList();
   public static ArrayList c_ArrayList_1 = new ArrayList();
   public static ArrayList d = new ArrayList();
   public static ArrayList e = new ArrayList();
   private static boolean a_bool_6;

   static {
      try {
         c();
      } catch (Throwable var0) {
         var0.printStackTrace();
      }
   }

   private static void a(ClientVersion var0, int var1) {
      Iterator var2 = a_ArrayList_5.iterator();

      while (var2.hasNext()) {
         ((VersionUpdateListener)var2.next()).a(var0, var1);
      }
   }

   private static void b(ClientVersion var0, int var1) {
      Iterator var2 = b_ArrayList_3.iterator();

      while (var2.hasNext()) {
         ((VersionUpdateListener)var2.next()).a(var0, var1);
      }
   }

   private static void c_void(ClientVersion var0) {
      Iterator var1 = d.iterator();

      while (var1.hasNext()) {
         ((DownloadProgressListener)var1.next()).a(var0);
      }
   }

   private static void a(ClientVersion var0, Exception var1) {
      Iterator var2 = d.iterator();

      while (var2.hasNext()) {
         ((DownloadProgressListener)var2.next()).a(var0, var1);
      }
   }

   public static byte[] a(ClientVersion var0) {
      if (var0.a_bool_3) {
         return null;
      } else {
         int var1;
         if ((var1 = e.indexOf(var0)) == -1) {
            throw new RuntimeException("Version not found");
         } else if (var0.a_bn_6 == null) {
            throw new RuntimeException("URL not defined");
         } else {
            try {
               var0.a_bool_3 = true;
               c_void(var0);
               byte[] var2 = null;
               if (var0.a_bn_6.a != null) {
                  HttpURLConnection var4;
                  if ((var4 = (HttpURLConnection)new URL(var0.a_bn_6.a.toString()).openConnection()).getResponseCode() != 200) {
                     throw new RuntimeException("Http error: " + var4.getResponseCode());
                  }

                  BufferedInputStream var5 = new BufferedInputStream(var4.getInputStream());
                  byte[] var12 = new byte[1024];
                  ByteArrayOutputStream var11 = new ByteArrayOutputStream();
                  int var6 = 0;

                  int var7;
                  while ((var7 = var5.read(var12)) > 0) {
                     var11.write(var12, 0, var7);
                     var6 += var7;
                     if (var4.getContentLength() != 1) {
                        var0.a_dbl_2 = (double)var6 / var4.getContentLength();
                     } else {
                        var0.a_dbl_2 = 0.1;
                     }
                  }

                  try {
                     var4.disconnect();
                  } catch (Exception var8) {
                  }

                  var2 = var11.toByteArray();
               } else {
                  Throwable var13 = null;

                  for (int var16 = 0; var16 < a_int_2; var16++) {
                     try {
                        EncryptedHttpClient var15;
                        if ((var15 = EncryptedHttpClient.a(a(var16, var0.a_bn_6.b.toString()), a_arr_byte, b_arr_byte, var0.a_bn_6.c, new DownloadCallback(var0))).c_int_1
                           != var15.c_arr_byte.length) {
                           throw new RuntimeException("Http error: received size doesn't match: " + var15.c_int_1 + " != " + var15.c_arr_byte.length);
                        }

                        if (var15.b_int_2 != 200) {
                           throw new RuntimeException("Http error: " + var15.b_int_2);
                        }

                        var2 = var15.c_arr_byte;
                        b_int_2 = var16;
                        break;
                     } catch (Throwable var9) {
                        var13 = var9;
                     }
                  }

                  if (var13 != null) {
                     FileUtils.a(var13);
                  }
               }

               var0.a_dbl_2 = -1.0;
               String var14 = FileUtils.a_String(var2);
               var0.a(var2, var14);
               if (!var0.a_bool()) {
                  var0.a(null, null);
               }

               var0.a_bool_3 = false;
               a(var0, (Exception)null);
               b(var0, var1);
               return var2;
            } catch (Throwable var10) {
               var0.a_bool_3 = false;
               var0.a_dbl_2 = -1.0;
               Exception var3 = new Exception(var10);
               a(var0, var3);
               throw new RuntimeException(var3);
            }
         }
      }
   }

   public static byte[] b(ClientVersion var0) {
      if (var0.a_bool_3) {
         return null;
      } else {
         int var1;
         if ((var1 = e.indexOf(var0)) == -1) {
            throw new RuntimeException("Version not found");
         } else if (var0.a_bn_6 == null) {
            throw new RuntimeException("URL not defined");
         } else {
            try {
               var0.a_bool_3 = true;
               c_void(var0);
               byte[] var2 = null;
               if (var0.a_bn_6.a != null) {
                  HttpURLConnection var4;
                  if ((var4 = (HttpURLConnection)new URL(var0.a_bn_6.a.toString()).openConnection()).getResponseCode() != 200) {
                     throw new RuntimeException("Http error: " + var4.getResponseCode());
                  }

                  BufferedInputStream var5 = new BufferedInputStream(var4.getInputStream());
                  byte[] var12 = new byte[1024];
                  ByteArrayOutputStream var11 = new ByteArrayOutputStream();
                  int var6 = 0;

                  int var7;
                  while ((var7 = var5.read(var12)) > 0) {
                     var11.write(var12, 0, var7);
                     var6 += var7;
                     if (var4.getContentLength() != 1) {
                        var0.a_dbl_2 = (double)var6 / var4.getContentLength();
                     } else {
                        var0.a_dbl_2 = 0.1;
                     }
                  }

                  try {
                     var4.disconnect();
                  } catch (Exception var8) {
                  }

                  var2 = var11.toByteArray();
               } else {
                  Throwable var13 = null;

                  for (int var16 = 0; var16 < a_int_2; var16++) {
                     try {
                        EncryptedHttpClient var15;
                        if ((var15 = EncryptedHttpClient.a(a(var16, var0.a_bn_6.b.toString()), a_arr_byte, b_arr_byte, var0.a_bn_6.c, new DownloadCallbackB(var0))).c_int_1
                           != var15.c_arr_byte.length) {
                           throw new RuntimeException("Http error: received size doesn't match: " + var15.c_int_1 + " != " + var15.c_arr_byte.length);
                        }

                        if (var15.b_int_2 != 200) {
                           throw new RuntimeException("Http error: " + var15.b_int_2);
                        }

                        var2 = var15.c_arr_byte;
                        b_int_2 = var16;
                        break;
                     } catch (Throwable var9) {
                        var13 = var9;
                     }
                  }

                  if (var13 != null) {
                     FileUtils.a(var13);
                  }
               }

               var0.a_dbl_2 = -1.0;
               String var14 = FileUtils.a_String(var2);
               var0.a(var2, var14);
               if (!var0.a_bool()) {
                  var0.a(null, null);
               } else {
                  DoomsdayGUI.a_a_3.a_au_9.a_bytes(var0.a_String, var0.a_arr_byte_4);
               }

               var0.a_bool_3 = false;
               a(var0, (Exception)null);
               b(var0, var1);
               return var2;
            } catch (Throwable var10) {
               var0.a_bool_3 = false;
               var0.a_dbl_2 = -1.0;
               Exception var3 = new Exception(var10);
               a(var0, var3);
               throw new RuntimeException(var3);
            }
         }
      }
   }

   public static void a() {
      for (int var0 = 0; var0 < e.size(); var0++) {
         ClientVersion var1;
         if ((var1 = (ClientVersion)e.get(var0)).a_arr_byte_4 != null && var1.a_arr_byte_4.length > 0) {
            DoomsdayGUI.a_a_3.a_au_9.a_bytes(var1.a_String, var1.a_arr_byte_4);
         }
      }
   }

   public static byte[] a(ClientVersion var0, File var1) {
      if (var0.a_bool_3) {
         return null;
      } else {
         int var2;
         if ((var2 = e.indexOf(var0)) == -1) {
            throw new RuntimeException("Version not found");
         } else if (var0.a_bn_6 == null) {
            throw new RuntimeException("URL not defined");
         } else if (!var1.exists() && !var1.mkdirs()) {
            throw new RuntimeException("Error create directory ".concat(String.valueOf(var1)));
         } else if (var1.isFile()) {
            throw new RuntimeException(var1 + " should be a folder");
         } else {
            try {
               var0.a_bool_3 = true;
               c_void(var0);
               byte[] var3 = null;
               if (var0.a_bn_6.a != null) {
                  HttpURLConnection var5;
                  if ((var5 = (HttpURLConnection)new URL(var0.a_bn_6.a.toString()).openConnection()).getResponseCode() != 200) {
                     throw new RuntimeException("Http error: " + var5.getResponseCode());
                  }

                  BufferedInputStream var6 = new BufferedInputStream(var5.getInputStream());
                  byte[] var13 = new byte[1024];
                  ByteArrayOutputStream var12 = new ByteArrayOutputStream();
                  int var7 = 0;

                  int var8;
                  while ((var8 = var6.read(var13)) > 0) {
                     var12.write(var13, 0, var8);
                     var7 += var8;
                     if (var5.getContentLength() != 1) {
                        var0.a_dbl_2 = (double)var7 / var5.getContentLength();
                     } else {
                        var0.a_dbl_2 = 0.1;
                     }
                  }

                  try {
                     var5.disconnect();
                  } catch (Exception var9) {
                  }

                  var3 = var12.toByteArray();
               } else {
                  Throwable var14 = null;

                  for (int var18 = 0; var18 < a_int_2; var18++) {
                     try {
                        EncryptedHttpClient var16;
                        if ((var16 = EncryptedHttpClient.a(a(var18, var0.a_bn_6.b.toString()), a_arr_byte, b_arr_byte, var0.a_bn_6.c, new DownloadCallbackC(var0))).c_int_1
                           != var16.c_arr_byte.length) {
                           throw new RuntimeException("Http error: received size doesn't match: " + var16.c_int_1 + " != " + var16.c_arr_byte.length);
                        }

                        if (var16.b_int_2 != 200) {
                           throw new RuntimeException("Http error: " + var16.b_int_2);
                        }

                        var3 = var16.c_arr_byte;
                        b_int_2 = var18;
                        break;
                     } catch (Throwable var10) {
                        var14 = var10;
                     }
                  }

                  if (var14 != null) {
                     FileUtils.a(var14);
                  }
               }

               var0.a_dbl_2 = -1.0;
               File var15 = new File(var1, var0.a_String);
               FileOutputStream var17;
               (var17 = new FileOutputStream(var15)).write(var3);
               var17.close();
               var0.a_file(var15, (int)var15.length(), a(var15));
               if (!var0.b()) {
                  var0.a_File_5.delete();
                  var0.a_file(null, 0, null);
               }

               var0.a_bool_3 = false;
               a(var0, (Exception)null);
               b(var0, var2);
               return var3;
            } catch (Throwable var11) {
               var0.a_bool_3 = false;
               var0.a_dbl_2 = -1.0;
               Exception var4 = new Exception(var11);
               a(var0, var4);
               throw new RuntimeException(var4);
            }
         }
      }
   }

   public static void a_void(ClientVersion var0) {
      var0.a(null, null);
      int var1 = e.indexOf(var0);

      try {
         DoomsdayGUI.a_a_3.a_au_9.j(var0.a_String);
      } catch (Throwable var2) {
         var2.printStackTrace();
      }

      if (var0.c()) {
         if (var1 >= 0) {
            e.remove(var1);
            a(var0, var1);
            return;
         }
      } else {
         b(var0, var1);
      }
   }

   public static void b_void(ClientVersion var0) {
      var0.a_File_5.delete();
      var0.a_file(null, 0, null);
      int var1 = e.indexOf(var0);
      if (var0.c()) {
         if (var1 >= 0) {
            e.remove(var1);
            a(var0, var1);
            return;
         }
      } else {
         b(var0, var1);
      }
   }

   public static byte[] c(ClientVersion var0) {
      if (var0.a_arr_byte_4 != null) {
         return var0.a_arr_byte_4;
      } else if (var0.a_File_5 != null) {
         byte[] var1 = FileUtils.a_arr_byte_2(var0.a_File_5);
         var0.a_file(var0.a_File_5, var1.length, FileUtils.a_String(var1));
         if (!var0.b()) {
            var0.a_File_5.delete();
            var0.a_file(null, 0, null);
            int var2 = e.indexOf(var0);
            b(var0, var2);
            throw new RuntimeException("Corrupted update file, please redownload " + var0.b_String);
         } else {
            return var1;
         }
      } else {
         return null;
      }
   }

   private static void d(ClientVersion var0) {
      int var3;
      if (e.size() > 0) {
         if ((var3 = Collections.binarySearch(e, var0, a_Comparator_3)) >= 0) {
            return;
         }

         var3 = ~var3;
      } else {
         var3 = 0;
      }

      e.add(var3, var0);
      Iterator var2 = c_ArrayList_1.iterator();

      while (var2.hasNext()) {
         ((VersionUpdateListener)var2.next()).a(var0, var3);
      }
   }

   private static void d() {
      for (int var0 = e.size() - 1; var0 >= 0; var0--) {
         if (((ClientVersion)e.get(var0)).c()) {
            a((ClientVersion)e.remove(var0), var0);
         }
      }
   }

   private static void a(EncryptedHttpClient var0) {
      try {
         BufferedReader var10 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(var0.c_arr_byte)));

      String var1;
      while ((var1 = var10.readLine()) != null) {
         String[] var11;
         if ((var11 = var1.split(";")).length >= 4) {
            try {
               String var2;
               int var3 = JarEntryDecoder.a(var2 = var11[0]);
               String var4 = var11[1];
               int var5 = Integer.parseInt(var11[3]);
               String var6 = var11[4];
               DownloadUrlConfig var7 = new DownloadUrlConfig(null, a_String_1, "/download/".concat(String.valueOf(var2)));
               if (var11.length >= 6 && var11[5].length() > 0) {
                  var7 = new DownloadUrlConfig(var11[5], null, null);
               }

               int var12;
               ClientVersion var13;
               if ((var12 = a(var4)) >= 0) {
                  var13 = (ClientVersion)e.get(var12);
               } else {
                  var13 = new ClientVersion(var4, var3, var2);
               }

               boolean var14 = var13.a_bn(var7, var5, var6);
               if (!var13.a_bool()) {
                  try {
                     DoomsdayGUI.a_a_3.a_au_9.j(var13.a_String);
                  } catch (Throwable var8) {
                     var8.printStackTrace();
                  }

                  var13.a(null, null);
                  if (var12 >= 0) {
                     b(var13, var12);
                     var14 = false;
                  }
               }

               if (!var13.b()) {
                  if (var13.a_File_5 != null) {
                     var13.a_File_5.delete();
                  }

                  var13.a_file(null, 0, null);
                  if (var12 >= 0) {
                     b(var13, var12);
                     var14 = false;
                  }
               }

               if (var12 == -1) {
                  d(var13);
               } else if (var14) {
                  b(var13, var12);
               }
            } catch (Exception var9) {
               var9.printStackTrace();
            }
         }
      }
      } catch (Exception var_e) {
         var_e.printStackTrace();
      }
   }

   private static String a(int var0, String var1) {
      if (var0 != 0 && var0 == b_int_2) {
         var0 = 0;
      } else if (var0 == 0 && b_int_2 != 0) {
         var0 = b_int_2;
      }

      if (var0 == 0) {
         return var1 != null && var0 == b_int_2 ? var1 : a_String_1;
      } else if (var0 == 1) {
         return b_String_1;
      } else if (var0 == 2 && c_String != null) {
         return c_String;
      } else {
         return var1 == null ? a_String_1 : var1;
      }
   }

   public static void b() {
      for (int var0 = 0; var0 < e.size(); var0++) {
         ((ClientVersion)e.get(var0)).a_bn(null, 0, null);
      }

      for (int var3 = 0; var3 < a_int_2; var3++) {
         try {
            String var1 = "/download/version_manifest.csv";
            EncryptedHttpClient var4;
            if ((var4 = EncryptedHttpClient.a(a(var3, null), a_arr_byte, b_arr_byte, var1)).c_int_1 != var4.c_arr_byte.length) {
               throw new RuntimeException("Http error: received size doesn't match: " + var4.c_int_1 + " != " + var4.c_arr_byte.length);
            }

            if (var4.b_int_2 != 200) {
               throw new RuntimeException("Http error: " + var4.b_int_2);
            }

            a(var4);
            d();
            b_int_2 = var3;
            return;
         } catch (Throwable var2) {
            var2.printStackTrace();
         }
      }
   }

   private static String a(File var0) {
      BinaryBufferWriter var1 = (BinaryBufferWriter)a_HashMap_4.get(var0);
      long var3;
      if ((var3 = var0.length()) >= 2147483647L) {
         return null;
      } else {
         if (var1 != null && (var1.a_long != var0.lastModified() || var1.b != var3)) {
            a_HashMap_4.remove(var0);
            var1 = null;
         }

         if (var1 == null) {
            try {
               RandomAccessFile var5 = new RandomAccessFile(var0, "r");
               byte[] var2 = new byte[(int)var3];
               var5.readFully(var2);
               var5.close();
               var1 = new BinaryBufferWriter(var0.lastModified(), var3, FileUtils.a_String(var2));
               a_HashMap_4.put(var0, var1);
               return var1.a_String_1;
            } catch (Exception var_e) {
               return null;
            }
         } else {
            return var1.a_String_1;
         }
      }
   }

   public static void c() {
      try {
         if (!a_bool_6) {
            a_bool_6 = true;
            if (GamePathUtils.a_File() == null) {
               return;
            }

            ZipInputStream var0;
            JarEntryDecoder[] var1 = JarEntryDecoder.a(var0 = new ZipInputStream(new BufferedInputStream(new FileInputStream(GamePathUtils.a_File()))));
            var0.close();
            if (var1 != null) {
               for (int var8 = 0; var8 < var1.length; var8++) {
                  if (!var1[var8].a()) {
                     String var2 = FileUtils.a_String(var1[var8].a_arr_byte_4);
                     ClientVersion var3;
                     (var3 = new ClientVersion(var1[var8].b_String, var1[var8].a_int_2, var1[var8].a_String_1)).a(var1[var8].a_arr_byte_4, var2);
                     d(var3);
                  }
               }
            }
         }
      } catch (IOException var7) {
      }

      for (int var9 = 0; var9 < e.size(); var9++) {
         ((ClientVersion)e.get(var9)).a_file(null, 0, null);
      }

      String var10 = GamePathUtils.c();
      JarEntryDecoder[] var12 = JarEntryDecoder.a(new File(var10));
      new ArrayList();
      if (var12 != null) {
         for (int var13 = 0; var13 < var12.length; var13++) {
            if (!var12[var13].a()) {
               ClientVersion var11;
               int var14;
               if ((var14 = a(var12[var13].b_String)) >= 0) {
                  var11 = (ClientVersion)e.get(var14);
               } else {
                  var11 = new ClientVersion(var12[var13].b_String, var12[var13].a_int_2, var12[var13].a_String_1);
               }

               boolean var4 = false;

               try {
                  var4 = var11.a_file(var12[var13].a_File_3, (int)var12[var13].a_File_3.length(), a(var12[var13].a_File_3));
               } catch (Exception var6) {
                  var6.printStackTrace();
               }

               if (!var11.a_bool()) {
                  try {
                     DoomsdayGUI.a_a_3.a_au_9.j(var11.a_String);
                  } catch (Throwable var5) {
                     var5.printStackTrace();
                  }

                  var11.a(null, null);
                  if (var14 >= 0) {
                     b(var11, var14);
                     var4 = false;
                  }
               }

               if (!var11.b()) {
                  if (var11.a_File_5 != null) {
                     var11.a_File_5.delete();
                  }

                  var11.a_file(null, 0, null);
                  if (var14 >= 0) {
                     b(var11, var14);
                     var4 = false;
                  }
               }

               if (var14 == -1) {
                  d(var11);
               } else if (var4) {
                  b(var11, var14);
               }
            }
         }
      }

      d();
   }

   private static int a(String var0) {
      for (int var1 = 0; var1 < e.size(); var1++) {
         if (((ClientVersion)e.get(var1)).b_String.equals(var0)) {
            return var1;
         }
      }

      return -1;
   }

   public static ClientVersion a_gg() {
      if (e.size() == 0) {
         return null;
      } else {
         ClientVersion var0 = (ClientVersion)e.get(0);

         for (int var1 = 0; var1 < e.size(); var1++) {
            ClientVersion var2;
            if ((var2 = (ClientVersion)e.get(var1)).a_int_1 > var0.a_int_1) {
               var0 = var2;
            }
         }

         return var0;
      }
   }
}
