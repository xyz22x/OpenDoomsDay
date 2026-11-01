import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

public final class ExternalProcessInjector {
   private static volatile boolean a_bool;
   private byte[] a_arr_byte_1;
   private int a_int_2;
   private int b_int;
   private int c;
   private int d;
   private byte[] b_arr_byte_1;
   private int e;
   public ArrayList a_ArrayList_3;
   private ArrayList b_ArrayList_2;

   public static int a(String var0, int var1, String var2, String var3, String var4, String var5, OutputStream var6) {
      try {
         String var7 = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
         ServerSocket var8;
         (var8 = new ServerSocket(0)).setSoTimeout(10000);
      int var9 = var8.getLocalPort();

      Process var10;
      try {
         var10 = new ProcessBuilder(
               "sudo",
               "-u",
               var0,
               var7,
               "-Djava.awt.headless=true",
               "-XX:-UsePerfData",
               "-splash:",
               "-jar",
               GamePathUtils.e(),
               "--jattach=".concat(String.valueOf(var9))
            )
            .start();
      } catch (Throwable var12) {
         var10 = new ProcessBuilder("sudo", "-u", var0, var7, "-jar", GamePathUtils.e(), "--jattach=".concat(String.valueOf(var9))).start();
      }

      Socket var13 = var8.accept();
      DataOutputStream var17 = new DataOutputStream(var13.getOutputStream());
      DataInputStream var14 = new DataInputStream(var13.getInputStream());
      var17.writeInt(var1);
      var17.writeUTF(var2);
      if (var3 != null) {
         var17.writeUTF(var3);
      } else {
         var17.writeUTF("");
      }

      var17.writeUTF(var4);
      if (var5 != null) {
         var17.writeUTF(var5);
      } else {
         var17.writeUTF("");
      }

      var17.flush();
      var1 = var14.readInt();
      var0 = var14.readUTF();

      try {
         var6.write(var0.getBytes(Charset.forName("UTF-8")));
      } catch (Exception var11) {
         var11.printStackTrace();
      }

      var10.waitFor();
      var8.close();
      return var1;
      } catch (Exception var_e) {
         throw new RuntimeException(var_e);
      }
   }

   public static void a(String var0) {
      Socket[] var1 = new Socket[1];
      var0 = var0.substring(13);
      C_ik var2;
      (var2 = new C_ik(var1)).setDaemon(true);
      var2.start();
      Socket var20 = null;

      try {
         int var15 = Integer.parseInt(var0);
         var20 = new Socket("localhost", var15);
         var1[0] = var20;
         DataOutputStream var16 = new DataOutputStream(var20.getOutputStream());
         int var3;
         DataInputStream var17;
         if ((var3 = (var17 = new DataInputStream(var20.getInputStream())).readInt()) != -1) {
            new C_il(var3).start();
         }

         var3 = var17.readInt();
         byte[] var4 = new byte[var17.readInt()];
         var17.readFully(var4);
         String var18;
         if ((var18 = var17.readUTF()).length() == 0) {
            var18 = null;
         }

         GuiStatusCallback var5 = new GuiStatusCallback(var16);
         boolean var19 = JvmtiInjector.a(var3, var4, var18, var5);
         var16.write(0);
         var16.writeBoolean(var19);
         var20.close();
      } catch (Throwable var12) {
         var12.printStackTrace();
      } finally {
         try {
            var20.close();
         } catch (Throwable var11) {
         }
      }

      System.exit(0);
   }

   public static void b(String var0) {
      Socket[] var1 = new Socket[1];
      var0 = var0.substring(8);
      C_im var2;
      (var2 = new C_im(var1)).setDaemon(true);
      var2.start();
      Socket var22 = null;

      try {
         int var17 = Integer.parseInt(var0);
         var22 = new Socket("localhost", var17);
         var1[0] = var22;
         DataOutputStream var18 = new DataOutputStream(var22.getOutputStream());
         int var3;
         DataInputStream var19;
         if ((var3 = (var19 = new DataInputStream(var22.getInputStream())).readInt()) != -1) {
            new C_in(var3).start();
         }

         var3 = var19.readInt();
         String var4;
         if ((var4 = var19.readUTF()).length() == 0) {
            var4 = null;
         }

         byte[] var5 = new byte[var19.readInt()];
         var19.readFully(var5);
         String var6;
         if ((var6 = var19.readUTF()).length() == 0) {
            var6 = null;
         }

         String var20;
         if ((var20 = var19.readUTF()).length() == 0) {
            var20 = null;
         }

         GuiStatusCallback var7 = new GuiStatusCallback(var18);
         boolean var21 = JvmtiInjector.a(var3, var4, var5, var6, var20, var7);
         var18.write(0);
         var18.writeBoolean(var21);
         var22.close();
      } catch (Throwable var14) {
         var14.printStackTrace();
      } finally {
         try {
            var22.close();
         } catch (Throwable var13) {
         }
      }

      System.exit(0);
   }

   private static boolean b(int var0, String var1, byte[] var2, String var3, String var4, InjectionCallback var5) {
      a_bool = false;
      ServerSocket var6 = null;
      Socket var33 = null;
      try {
         (var6 = new ServerSocket(0)).setSoTimeout(7500);
      String var7 = GamePathUtils.e();
      var5.a();
      String var8 = System.getProperty("java.home") + File.separatorChar + "bin" + File.separatorChar + "java";
      ProcessBuilder var28 = new ProcessBuilder(
         "pkexec",
         "env",
         "DISPLAY=" + System.getenv("DISPLAY"),
         "XAUTHORITY=" + System.getenv("XAUTHORITY"),
         var8,
         "-splash:",
         "-jar",
         var7,
         "--jvmti=" + var6.getLocalPort()
      );
      StringBuilder var32 = new StringBuilder();
      String[] var29 = var28.command().toArray(new String[0]);

      for (int var9 = 0; var9 < var29.length; var9++) {
         var32.append(var29[var9]);
         var32.append(" ");
      }

      Socket[] var34 = new Socket[1];
      Process var30 = Runtime.getRuntime().exec(var29);
      C_io var31;
      (var31 = new C_io(var30, var6, var34, var5)).setDaemon(true);
      var31.start();
      var5.b();
         var33 = var6.accept();
         var34[0] = var33;
         DataOutputStream var35 = new DataOutputStream(var33.getOutputStream());
         DataInputStream var10 = new DataInputStream(var33.getInputStream());
         var35.writeInt(-1);
         var35.writeInt(var0);
         if (var1 != null) {
            var35.writeUTF(var1);
         } else {
            var35.writeUTF("");
         }

         var35.writeInt(var2.length);
         var35.write(var2);
         if (var3 != null) {
            var35.writeUTF(var3);
         } else {
            var35.writeUTF("");
         }

         if (var4 != null) {
            var35.writeUTF(var4);
         } else {
            var35.writeUTF("");
         }

         var35.flush();

         while ((var0 = var10.read()) != 0) {
            if (var0 == 2) {
               String var11;
               if ((var11 = var10.readUTF()).length() == 0) {
                  var11 = null;
               }

               RuntimeException var12 = null;
               String var26;
               if ((var26 = var10.readUTF()).length() != 0) {
                  var12 = new RuntimeException(var26);
               }

               var5.b(var11, var12);
            } else if (var0 == 3) {
               long var36 = var10.readLong();
               var5.b(var36);
            }
         }

         boolean var27 = var10.readBoolean();
         var31.interrupt();
         var33.close();
         var6.close();
         return var27;
      } catch (Throwable var23) {
         if (!a_bool) {
            throw new RuntimeException(var23);
         }
      } finally {
         try {
            var33.close();
         } catch (Throwable var22) {
         }

         try {
            var6.close();
         } catch (Throwable var21) {
         }
      }

      return false;
   }

   private static int a(Process var0) {
      try {
         InputStream var5 = var0.getInputStream();
      StringBuilder var1 = new StringBuilder();
      int var3 = 0;

      int var2;
      while ((var2 = var5.read()) >= 0) {
         var3++;
         var1.append((char)var2);
         if (var2 == 65535 || var3 > 100) {
            break;
         }
      }

      String var6 = var1.toString();
      int var7 = -1;

      try {
         var7 = Integer.parseInt(var6.substring(0, var6.indexOf(44)));
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      return var7;
      } catch (Exception var_e) {
         return -1;
      }
   }

   private static boolean c(int var0, String var1, byte[] var2, String var3, String var4, InjectionCallback var5) {
      ServerSocket var7 = null;
      String var8 = GamePathUtils.e();
      File var9 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "run_sudo.txt");
      File var10 = null;

      try {
         (var7 = new ServerSocket(0)).setSoTimeout(7500);
         String var6 = var9.getAbsolutePath();
         BufferedWriter var11;
         (var11 = new BufferedWriter(new FileWriter(var9))).append("tell application \"Terminal\"");
         var11.newLine();
         String var12 = GamePathUtils.a_String_2();
         String var13;
         if (var8.indexOf(32) < 0 && var12.indexOf(32) < 0) {
            var13 = "--jvmti=" + var7.getLocalPort();
            var11.append(
               "\tset newTab to do script \"sudo bash -c \\\""
                  + var12
                  + "-splash: -jar "
                  + var8
                  + " --jvmti="
                  + var7.getLocalPort()
                  + " > /dev/null 2>&1 &\\\"\""
            );
         } else {
            var10 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "run_sudo_bash.sh");
            StringBuilder var14;
            (var14 = new StringBuilder()).append('"');
            var14.append(var12);
            var14.append('"');
            var14.append("-splash: -jar \"");
            var14.append(var8);
            var14.append('"');
            var14.append(" --jvmti=");
            var14.append(var7.getLocalPort());
            var14.append(" > /dev/null 2>&1 &");
            FileOutputStream var15;
            (var15 = new FileOutputStream(var10)).write(var14.toString().getBytes(Charset.forName("UTF-8")));
            var15.close();
            var11.append("\tset newTab to do script \"sudo bash " + var10.getAbsolutePath() + "\"");
            var13 = var10.getAbsolutePath();
         }

         var11.newLine();
         var11.append("\tactivate");
         var11.newLine();
         var11.append("\tset theWindow to first window of (every window whose tabs contains newTab)");
         var11.newLine();
         var11.append("    \tset windowId to theWindow's id");
         var11.newLine();
         var11.append("    \trepeat with i from 1 to the count of theWindow's tabs");
         var11.newLine();
         var11.append("        if item i of theWindow's tabs is newTab then set tabNumber to i");
         var11.newLine();
         var11.append("    \tend repeat");
         var11.newLine();
         var11.append("    \tget {windowId, tabNumber}");
         var11.newLine();
         var11.append("end tell");
         var11.close();
         var9.setExecutable(true);
         var5.a();

         int var61 = 0;
         try {
            Process var68;
            var61 = a(var68 = new ProcessBuilder("osascript", var6).start());
            if (var68.waitFor() != 0) {
               throw new RuntimeException();
            }
         } catch (Exception var54) {
            var5.b(
               null,
               new RuntimeException(
                  "Failed to get sudo privileges: error open terminal. You need to run DoomsDay loader yourself: sudo\"" + var12 + "\" -jar \"" + var8 + "\""
               )
            );
            return false;
         }

         DoomsdayGUI.a_a_3.a_gd_13.a(1000);
         Thread.sleep(100L);
         int var67 = 0;
         int var69 = 0;

         while (true) {
            boolean var64 = false;
            Iterator var66 = DoomsdayGUI.a_a_3.a_gd_13.c.iterator();

            while (var66.hasNext()) {
               ProcessInfo var62;
               if ((var62 = (ProcessInfo)var66.next()).c.contains(var13) && var62.a_String_1.contains("sudo")) {
                  var67 = var62.b_int;
                  var64 = true;
                  break;
               }
            }

            if (var69 > 60 && var67 == 0) {
               var5.b(null, new RuntimeException("Failed to get sudo privileges: terminal open timeout"));
               return false;
            }

            if (var67 != 0 && !var64) {
               DoomsdayGUI.a_a_3.a_gd_13.a(2000);
               var5.b();
               var9.delete();
               var7.setSoTimeout(3000);
               Socket var70 = null;

               try {
                  System.currentTimeMillis();
                  var70 = var7.accept();
                  System.currentTimeMillis();
                  DataOutputStream var63 = new DataOutputStream(var70.getOutputStream());
                  DataInputStream var65 = new DataInputStream(var70.getInputStream());
                  var63.writeInt(var61);
                  var63.writeInt(var0);
                  if (var1 != null) {
                     var63.writeUTF(var1);
                  } else {
                     var63.writeUTF("");
                  }

                  var63.writeInt(var2.length);
                  var63.write(var2);
                  if (var3 != null) {
                     var63.writeUTF(var3);
                  } else {
                     var63.writeUTF("");
                  }

                  if (var4 != null) {
                     var63.writeUTF(var4);
                  } else {
                     var63.writeUTF("");
                  }

                  var63.flush();

                  while ((var0 = var65.read()) != 0) {
                     if (var0 == 2) {
                        String var16;
                        if ((var16 = var65.readUTF()).length() == 0) {
                           var16 = null;
                        }

                        RuntimeException var17 = null;
                        String var59;
                        if ((var59 = var65.readUTF()).length() != 0) {
                           var17 = new RuntimeException(var59);
                        }

                        var5.b(var16, var17);
                     } else if (var0 == 3) {
                        long var71 = var65.readLong();
                        var5.b(var71);
                     }
                  }

                  boolean var60 = var65.readBoolean();
                  var70.close();
                  return var60;
               } catch (Exception var55) {
                  var5.b(null, new RuntimeException("Failed injection: canceled by user"));
                  if (var55.getMessage() != null && !var55.getMessage().contains("timed")) {
                     var55.printStackTrace();
                  }
                  break;
               } finally {
                  try {
                     var70.close();
                  } catch (Throwable var53) {
                  }
               }
            }

            Thread.sleep(50L);
            var69++;
         }
      } catch (Throwable var_err) {
         return false;
      } finally {
         try {
            if (var10 != null) var10.delete();
         } catch (Throwable var52) {
         }

         try {
            var9.delete();
         } catch (Throwable var51) {
         }

         try {
            if (var7 != null) var7.close();
         } catch (Throwable var50) {
         }
      }

      return false;
   }

   public static boolean a(int var0, byte[] var1, String var2, InjectionCallback var3) {
      if (PlatformUtil.h()) {
         return d(var0, var1, var2, var3);
      } else if (PlatformUtil.j() || PlatformUtil.k()) {
         return c(var0, var1, var2, var3);
      } else {
         return PlatformUtil.i() ? b(var0, var1, var2, var3) : false;
      }
   }

   private static boolean b(int var0, byte[] var1, String var2, InjectionCallback var3) {
      ServerSocket var5 = null;
      String var6 = GamePathUtils.e();
      File var7 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "run_sudo.txt");
      File var8 = null;

      try {
         (var5 = new ServerSocket(0)).setSoTimeout(7500);
         String var4 = var7.getAbsolutePath();
         BufferedWriter var9;
         (var9 = new BufferedWriter(new FileWriter(var7))).append("tell application \"Terminal\"");
         var9.newLine();
         String var10 = GamePathUtils.a_String_2();
         String var11;
         if (var6.indexOf(32) < 0 && var10.indexOf(32) < 0) {
            var11 = "--ishellcode=" + var5.getLocalPort();
            var9.append(
               "\tset newTab to do script \"sudo bash -c \\\""
                  + var10
                  + " -splash: -jar "
                  + var6
                  + " --ishellcode="
                  + var5.getLocalPort()
                  + " > /dev/null 2>&1 &\\\"\""
            );
         } else {
            var8 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "run_sudo_bash.sh");
            StringBuilder var12;
            (var12 = new StringBuilder()).append('"');
            var12.append(var10);
            var12.append('"');
            var12.append(" -splash: -jar \"");
            var12.append(var6);
            var12.append('"');
            var12.append(" --ishellcode=");
            var12.append(var5.getLocalPort());
            var12.append(" > /dev/null 2>&1 &");
            FileOutputStream var13;
            (var13 = new FileOutputStream(var8)).write(var12.toString().getBytes(Charset.forName("UTF-8")));
            var13.close();
            var9.append("\tset newTab to do script \"sudo bash " + var8.getAbsolutePath() + "\"");
            var11 = var8.getAbsolutePath();
         }

         var9.newLine();
         var9.append("\tactivate");
         var9.newLine();
         var9.append("\tset theWindow to first window of (every window whose tabs contains newTab)");
         var9.newLine();
         var9.append("    \tset windowId to theWindow's id");
         var9.newLine();
         var9.append("    \trepeat with i from 1 to the count of theWindow's tabs");
         var9.newLine();
         var9.append("        if item i of theWindow's tabs is newTab then set tabNumber to i");
         var9.newLine();
         var9.append("    \tend repeat");
         var9.newLine();
         var9.append("    \tget {windowId, tabNumber}");
         var9.newLine();
         var9.append("end tell");
         var9.close();
         var7.setExecutable(true);
         var3.a();

         int var59 = 0;
         try {
            Process var67;
            var59 = a(var67 = new ProcessBuilder("osascript", var4).start());
            if (var67.waitFor() != 0) {
               throw new RuntimeException();
            }
         } catch (Exception var52) {
            var3.b(
               null,
               new RuntimeException(
                  "Failed to get sudo privileges: error open terminal. You need to run DoomsDay loader yourself: sudo\"" + var10 + "\" -jar \"" + var6 + "\""
               )
            );
            return false;
         }

         DoomsdayGUI.a_a_3.a_gd_13.a(1000);
         Thread.sleep(100L);
         int var66 = 0;
         int var68 = 0;

         while (true) {
            boolean var62 = false;
            Iterator var64 = DoomsdayGUI.a_a_3.a_gd_13.c.iterator();

            while (var64.hasNext()) {
               ProcessInfo var60;
               if ((var60 = (ProcessInfo)var64.next()).c.contains(var11) && var60.a_String_1.contains("sudo")) {
                  var66 = var60.b_int;
                  var62 = true;
                  break;
               }
            }

            if (var68 > 60 && var66 == 0) {
               var3.b(null, new RuntimeException("Failed to get sudo privileges: terminal open timeout"));
               return false;
            }

            if (var66 != 0 && !var62) {
               DoomsdayGUI.a_a_3.a_gd_13.a(2000);
               var3.b();
               var7.delete();
               var5.setSoTimeout(8000);
               Socket var69 = null;

               try {
                  var69 = var5.accept();
                  DataOutputStream var63 = new DataOutputStream(var69.getOutputStream());
                  DataInputStream var61 = new DataInputStream(var69.getInputStream());
                  var63.writeInt(var59);
                  var63.writeInt(var0);
                  var63.writeInt(var1.length);
                  var63.write(var1);
                  if (var2 != null) {
                     var63.writeUTF(var2);
                  } else {
                     var63.writeUTF("");
                  }

                  var63.flush();

                  while ((var0 = var61.read()) != 0) {
                     if (var0 == 2) {
                        String var14;
                        if ((var14 = var61.readUTF()).length() == 0) {
                           var14 = null;
                        }

                        Object var15 = null;
                        String var57;
                        if ((var57 = var61.readUTF()).length() != 0) {
                           if (var57.startsWith("SIP:")) {
                              var15 = new C_iy(var57);
                           } else {
                              var15 = new RuntimeException(var57);
                           }
                        }

                        var3.b(var14, (Throwable)var15);
                     } else if (var0 == 3) {
                        long var70 = var61.readLong();
                        var3.b(var70);
                     }
                  }

                  boolean var65 = var61.readBoolean();
                  var69.close();
                  return var65;
               } catch (Exception var53) {
                  var3.b(null, new RuntimeException("Failed injection: canceled by user"));
                  if (var53.getMessage() != null && !var53.getMessage().contains("timed")) {
                     var53.printStackTrace();
                  }
                  break;
               } finally {
                  try {
                     var69.close();
                  } catch (Throwable var51) {
                  }
               }
            }

            Thread.sleep(50L);
            var68++;
         }
      } catch (Throwable var_err) {
         return false;
      } finally {
         try {
            if (var8 != null) var8.delete();
         } catch (Throwable var50) {
         }

         try {
            var7.delete();
         } catch (Throwable var49) {
         }

         try {
            if (var5 != null) var5.close();
         } catch (Throwable var48) {
         }
      }

      return false;
   }

   private static boolean c(int var0, byte[] var1, String var2, InjectionCallback var3) {
      a_bool = false;
      ServerSocket var4 = null;
      Socket var31 = null;
      try {
         (var4 = new ServerSocket(0)).setSoTimeout(7500);
      String var5 = GamePathUtils.e();
      var3.a();
      String var6 = System.getProperty("java.home") + File.separatorChar + "bin" + File.separatorChar + "java";
      ProcessBuilder var26 = new ProcessBuilder(
         "pkexec",
         "env",
         "DISPLAY=" + System.getenv("DISPLAY"),
         "XAUTHORITY=" + System.getenv("XAUTHORITY"),
         var6,
         "-splash:",
         "-jar",
         var5,
         "--ishellcode=" + var4.getLocalPort()
      );
      StringBuilder var30 = new StringBuilder();
      String[] var27 = var26.command().toArray(new String[0]);

      for (int var7 = 0; var7 < var27.length; var7++) {
         var30.append(var27[var7]);
         var30.append(" ");
      }

      Socket[] var32 = new Socket[1];
      Process var28 = Runtime.getRuntime().exec(var27);
      C_ip var29;
      (var29 = new C_ip(var28, var4, var32, var3)).setDaemon(true);
      var29.start();
      var3.b();
         var31 = var4.accept();
         var32[0] = var31;
         DataOutputStream var33 = new DataOutputStream(var31.getOutputStream());
         DataInputStream var8 = new DataInputStream(var31.getInputStream());
         var33.writeInt(-1);
         var33.writeInt(var0);
         var33.writeInt(var1.length);
         var33.write(var1);
         if (var2 != null) {
            var33.writeUTF(var2);
         } else {
            var33.writeUTF("");
         }

         var33.flush();

         while ((var0 = var8.read()) != 0) {
            if (var0 == 2) {
               String var9;
               if ((var9 = var8.readUTF()).length() == 0) {
                  var9 = null;
               }

               RuntimeException var10 = null;
               String var24;
               if ((var24 = var8.readUTF()).length() != 0) {
                  var10 = new RuntimeException(var24);
               }

               var3.b(var9, var10);
            } else if (var0 == 3) {
               long var34 = var8.readLong();
               var3.b(var34);
            }
         }

         boolean var25 = var8.readBoolean();
         var29.interrupt();
         var31.close();
         var4.close();
         return var25;
      } catch (Throwable var21) {
         if (!a_bool) {
            throw new RuntimeException(var21);
         }
      } finally {
         try {
            var31.close();
         } catch (Throwable var20) {
         }

         try {
            var4.close();
         } catch (Throwable var19) {
         }
      }

      return false;
   }

   private static boolean d(int var0, byte[] var1, String var2, InjectionCallback var3) {
      ServerSocket var4 = null;
      Socket var5 = null;

      try {
         (var4 = new ServerSocket(0)).setSoTimeout(7500);
         String var6 = GamePathUtils.e();
         var3.a();
         int var23 = ProcessAttacher.a(
            (System.getProperty("java.home") + File.separator + "bin" + File.separator + "javaw.exe").toCharArray(),
            ("-splash: -jar \"" + var6 + "\" --ishellcode=" + var4.getLocalPort()).toCharArray()
         );
         var3.b();
         if (var23 != 1223) {
            var5 = var4.accept();
            DataOutputStream var24 = new DataOutputStream(var5.getOutputStream());
            DataInputStream var7 = new DataInputStream(var5.getInputStream());
            var24.writeInt(-1);
            var24.writeInt(var0);
            var24.writeInt(var1.length);
            var24.write(var1);
            if (var2 != null) {
               var24.writeUTF(var2);
            } else {
               var24.writeUTF("");
            }

            var24.flush();

            while ((var0 = var7.read()) != 0) {
               if (var0 == 2) {
                  String var8;
                  if ((var8 = var7.readUTF()).length() == 0) {
                     var8 = null;
                  }

                  RuntimeException var9 = null;
                  String var21;
                  if ((var21 = var7.readUTF()).length() != 0) {
                     var9 = new RuntimeException(var21);
                  }

                  var3.b(var8, var9);
               } else if (var0 == 3) {
                  long var25 = var7.readLong();
                  var3.b(var25);
               }
            }

            boolean var22 = var7.readBoolean();
            var5.close();
            var4.close();
            return var22;
         }

         var4.close();
         var3.b(null, new RuntimeException("Failed injection: canceled by user"));
      } catch (Throwable var_err) {
         return false;
      } finally {
         try {
            if (var4 != null) var4.close();
         } catch (Throwable var18) {
         }

         try {
            var5.close();
         } catch (Throwable var17) {
         }
      }

      return false;
   }

   public static boolean a(int var0, String var1, byte[] var2, String var3, String var4, InjectionCallback var5) {
      if (PlatformUtil.h()) {
         return d(var0, var1, var2, var3, var4, var5);
      } else if (PlatformUtil.j() || PlatformUtil.k()) {
         return b(var0, var1, var2, var3, var4, var5);
      } else {
         return PlatformUtil.i() ? c(var0, var1, var2, var3, var4, var5) : false;
      }
   }

   private static boolean d(int var0, String var1, byte[] var2, String var3, String var4, InjectionCallback var5) {
      ServerSocket var6 = null;
      Socket var7 = null;

      try {
         (var6 = new ServerSocket(0)).setSoTimeout(7500);
         String var8 = GamePathUtils.e();
         var5.a();
         int var25 = ProcessAttacher.a(
            (System.getProperty("java.home") + File.separator + "bin" + File.separator + "javaw.exe").toCharArray(),
            ("-splash: -jar \"" + var8 + "\" --jvmti=" + var6.getLocalPort()).toCharArray()
         );
         var5.b();
         if (var25 != 1223) {
            var7 = var6.accept();
            DataOutputStream var26 = new DataOutputStream(var7.getOutputStream());
            DataInputStream var9 = new DataInputStream(var7.getInputStream());
            var26.writeInt(-1);
            var26.writeInt(var0);
            if (var1 != null) {
               var26.writeUTF(var1);
            } else {
               var26.writeUTF("");
            }

            var26.writeInt(var2.length);
            var26.write(var2);
            if (var3 != null) {
               var26.writeUTF(var3);
            } else {
               var26.writeUTF("");
            }

            if (var4 != null) {
               var26.writeUTF(var4);
            } else {
               var26.writeUTF("");
            }

            var26.flush();

            while ((var0 = var9.read()) != 0) {
               if (var0 == 2) {
                  String var10;
                  if ((var10 = var9.readUTF()).length() == 0) {
                     var10 = null;
                  }

                  RuntimeException var11 = null;
                  String var23;
                  if ((var23 = var9.readUTF()).length() != 0) {
                     var11 = new RuntimeException(var23);
                  }

                  var5.b(var10, var11);
               } else if (var0 == 3) {
                  long var27 = var9.readLong();
                  var5.b(var27);
               }
            }

            boolean var24 = var9.readBoolean();
            var7.close();
            var6.close();
            return var24;
         }

         var6.close();
         var5.b(null, new RuntimeException("Failed injection: canceled by user"));
      } catch (Throwable var_err) {
         return false;
      } finally {
         try {
            if (var6 != null) var6.close();
         } catch (Throwable var20) {
         }

         try {
            var7.close();
         } catch (Throwable var19) {
         }
      }

      return false;
   }

   static void a_void() {
      a_bool = true;
   }

   public ExternalProcessInjector() {
      this.a_ArrayList_3 = new ArrayList();
      this.b_ArrayList_2 = new ArrayList();
   }

   public ExternalProcessInjector(byte[] var1, int var2, byte[] var3) {
      this.e = var2;
      this.b_arr_byte_1 = var3;
      this.a_arr_byte_1 = new byte[2];
      this.a(var1);
   }

   private void a(byte[] var1) {
      this.a_arr_byte_1[0] = var1[0];
      this.a_arr_byte_1[1] = var1[1];
      byte var4 = var1[3];
      this.a_int_2 = var4 & 15;
      this.b_int = var1[6] << 8 | var1[7];
      this.c = var1[8] << 8 | var1[9];
      this.d = var1[10] << 8 | var1[11];
      ExternalProcessInjector var2 = this;

      for (int var3 = 0; var3 < 2; var3++) {
         if (var2.a_arr_byte_1[var3] != var2.b_arr_byte_1[var3]) {
            throw new RuntimeException("The response ID and the request ID do not match");
         }
      }

      switch (this.a_int_2) {
         case 1:
            throw new RuntimeException("The name server was unable to interpret the query");
         case 2:
            throw new RuntimeException("Server failure: the name server was unable to process the query due to a problem with the name server");
         case 3:
            throw new RuntimeException("NOTFOUND");
         case 4:
            throw new RuntimeException("Not implemented: The name server does not support the requested kind of query");
         case 5:
            throw new RuntimeException("Refused: the name server refuses to perform the requested operation for policy reasons");
         default:
            int var5 = this.e;
            this.a_ArrayList_3 = new ArrayList();

            for (int var6 = 0; var6 < this.b_int; var6++) {
               this.a_ArrayList_3.add(new C_aw(var1, var5));
               if ((var5 = ((C_aw)this.a_ArrayList_3.get(var6)).a_int_2()) == -1) {
                  this.a_ArrayList_3.remove(var6);
                  break;
               }
            }

            for (int var7 = this.b_int; var7 < this.c + this.b_int; var7++) {
               this.a_ArrayList_3.add(new C_aw(var1, var5));
               if ((var5 = ((C_aw)this.a_ArrayList_3.get(var7)).a_int_2()) == -1) {
                  this.a_ArrayList_3.remove(var7);
                  break;
               }
            }

            this.b_ArrayList_2 = new ArrayList();

            for (int var8 = 0; var8 < this.d; var8++) {
               this.b_ArrayList_2.add(new C_aw(var1, var5));
               if ((var5 = ((C_aw)this.b_ArrayList_2.get(var8)).a_int_2()) == -1) {
                  this.a_ArrayList_3.remove(var8);
                  return;
               }
            }
      }
   }

   public final boolean a() {
      return this.a_ArrayList_3.size() == 0;
   }
}
