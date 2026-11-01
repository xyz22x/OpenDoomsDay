import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class JvmtiInjector {
   public static Object a = new Object();

   public static boolean a(int var0, String var1, byte[] var2, String var3, String var4, InjectionCallback var5) {
      try {
         int var6 = ProcessAttacher.a(var0);
         if (PlatformUtil.h()) {
            if (PlatformUtil.e()) {
               if (var6 == 4) {
                  var5.b(null, new RuntimeException("Injection from x32 to ARM64 process is not supported"));
                  return false;
               }

               if (PlatformUtil.a == 2 && var6 == 1) {
                  var5.b(null, new RuntimeException("Injection from x32 to x64 process on ARM64 machine is not supported"));
                  return false;
               }
            }

            if (var6 == 0 && !DoomsdayGUI.b_bool_1) {
               return ExternalProcessInjector.a(var0, var1, var2, var3, var4, var5);
            }
         }

         var5.b("Starting inject jvmti agent to ".concat(String.valueOf(var0)), null);
         byte[] var7 = null;
         byte[] var8 = null;
         if (var6 == 1) {
            var8 = ShellcodeLoader.c();
         } else if (var6 == 3) {
            var8 = ShellcodeLoader.b();
         } else if (var6 == 4) {
            var8 = ShellcodeLoader.a();
         } else if (var6 == 0) {
            var8 = ShellcodeLoader.d();
         } else {
            var5.b(null, new RuntimeException("Unsupported target process architecture: " + NativeBinaryManager.a_String(var6)));
         }

         byte[] var24;
         ShellcodeLoader.a_arr_byte_2(var24 = ShellcodeLoader.a_arr_byte(var8), 3);
         if (PlatformUtil.i()) {
            long var9 = ProcessMemoryHooks.a(var0);
            ShellcodeLoader.a(var24, var24.length - 4096 + 48, var9);
         }

         if (PlatformUtil.h()) {
            if (var6 == 1) {
               var7 = NativeBinaryManager.h();
            } else if (var6 == 3) {
               var7 = NativeBinaryManager.g();
            } else if (var6 == 4) {
               var7 = NativeBinaryManager.i();
            } else if (var6 == 0) {
               var7 = NativeBinaryManager.j();
            }
         } else if (!PlatformUtil.j() && !PlatformUtil.k()) {
            if (PlatformUtil.i()) {
               if (var6 == 1) {
                  var7 = NativeBinaryManager.c();
               } else if (var6 == 4) {
                  var7 = NativeBinaryManager.b();
               } else if (var6 == 0) {
                  var7 = NativeBinaryManager.j();
               }
            }
         } else if (var6 == 1) {
            var7 = NativeBinaryManager.d_arr_byte();
         } else if (var6 == 3) {
            var7 = NativeBinaryManager.e_arr_byte();
         } else if (var6 == 4) {
            var7 = NativeBinaryManager.f();
         } else if (var6 == 0) {
            var7 = NativeBinaryManager.j();
         }

         if (var7 == null) {
            var5.b(null, new RuntimeException("Failed to get jvmti library"));
         }

         boolean var26 = false;
         if (var4 != null) {
            try {
               byte[] var10 = FileUtils.a_arr_byte_2(new File(var4));
               if (!Arrays.equals(var7, var10)) {
                  var4 = null;
                  var26 = true;
               }
            } catch (Throwable var12) {
               var4 = null;
               var26 = true;
            }
         }

         if (var4 == null) {
            File var27;
            if ((var27 = a_File(var5)) == null) {
               return false;
            }

            if (!a(var27, var7, var5)) {
               return false;
            }

            var4 = var27.getAbsolutePath();
            if (var26) {
               var3 = var3 + " --nativefile2=" + FileUtils.a(var4);
            } else {
               var3 = var3 + " --nativefile=" + FileUtils.a(var4);
            }
         }

         byte[] var28;
         if ((var28 = a(var5)) == null) {
            return false;
         }

         byte[] var21 = a(var3, var2, 2, var28);
         String var22;
         if ((var22 = a(var24, var21, var5)) == null) {
            return false;
         }

         var5.b("Injecting...", null);
         InjectionResult var23 = new InjectionResult();
         int var25;
         if ((var25 = ProcessAttacher.a(var0, "load", var4, "true", var22, var23)) == -1000012 || var25 == -1000013 || var25 == -1000019) {
            var5.c();
            return ExternalProcessInjector.a(var0, var1, var2, var3, var4, var5);
         }

         boolean var15 = false;
         if (var25 != 0 && var25 != 100 && !PlatformUtil.h() && DoomsdayGUI.b_bool_1 && var1 != null) {
            var15 = true;
            var23 = new InjectionResult();
            System.out.println("Try as user, cause ".concat(String.valueOf(var25)));
            var25 = ExternalProcessInjector.a(var1, var0, "load", var4, "true", var22, var23);
         }

         int var14 = 0;

         try {
            int var20;
            if ((var20 = (var3 = var23.a.toString()).indexOf("code:")) >= 0) {
               var14 = Integer.parseInt(var3.substring(var20 + 5).trim());
            } else {
               var14 = Integer.parseInt(var3.trim());
            }
         } catch (Exception var11) {
         }

         if (var25 != 0 && var25 != 100) {
            var3 = "Failed to inject JVMTI agent to ".concat(String.valueOf(var0));
            if (var15) {
               var3 = var3 + " by another user";
            }

            var3 = var3 + ". ";
            var3 = var3 + ErrorCodeUtil.c(var25);
            if (DoomsdayGUI.b_bool_1 && PlatformUtil.h() && (var25 == -1000002 || var25 == -1000003 || var25 == -1000005)) {
               var3 = var3 + ". Try to disable antivirus";
            }

            if (var25 == -1000008 || var25 == -1000013 || var25 == -1000014) {
               if (PlatformUtil.i()) {
                  var3 = var3 + ". Try to use restart injection (Advanced inject tab -> Mode: restart)";
               } else {
                  var3 = var3 + ". Try to use shellcode injection (Advanced inject tab -> Mode: shellcode)";
               }
            }

            var5.b(null, new RuntimeException(var3));
         } else {
            if (var14 == 0) {
               var5.b("Injected! Loading...", null);
               var5.a_Thread_4.join();
               return true;
            }

            var5.b(null, new RuntimeException(ErrorCodeUtil.b(var14)));
         }
      } catch (Throwable var13) {
         var5.b("Runtime error", new RuntimeException(var13.getMessage()));
         var13.printStackTrace();
      }

      return false;
   }

   public static boolean a(int var0, String var1, InjectionCallback var2) {
      return a(var0, var1, var2, false);
   }

   public static boolean b(int var0, String var1, InjectionCallback var2) {
      return a(var0, var1, var2, true);
   }

   private static boolean a(int var0, String var1, InjectionCallback var2, boolean var3) {
      try {
         char[] var4 = ProcessAttacher.b(var0);
         int var5;
         String var19;
         if ((var5 = (var19 = new String(var4).trim()).indexOf("java ")) >= 0) {
            var5 += 5;
         } else {
            var5 = var19.indexOf("-Xms");
         }

         if (var5 < 0) {
            var5 = var19.indexOf("-");
         }

         if (var5 < 0) {
            var2.b("", new RuntimeException("Failed to create command"));
            return false;
         } else {
            var2.b("Restarting...", null);
            String var22 = new String(ProcessAttacher.a_arr_char(var0));
            System.out.println("Working directory: ".concat(String.valueOf(var22)));
            File var23 = new File(var22);
            File var6;
            if (PlatformUtil.i()) {
               if (var3) {
                  var6 = GamePathUtils.a_File();
               } else {
                  var6 = new File("/tmp/" + Math.abs(new Random().nextInt()) + ".jar");
               }
            } else if (var3) {
               var6 = GamePathUtils.a_File();
            } else {
               var6 = new File(System.getProperty("java.io.tmpdir"), Math.abs(new Random().nextInt()) + ".jar");
            }

            var1 = var1 + " --restartagent=" + FileUtils.a(var6.getAbsolutePath());
            if (!var3 || !var6.exists()) {
               if (!var6.getParentFile().exists()) {
                  var6.getParentFile().mkdirs();
               }

               System.out.println(var19);
               a(var6);
               System.out.println("Copy created ".concat(String.valueOf(var6)));
               System.out.println("Length " + var6.length());
            }

            ArrayList var16;
            if (var3) {
               var16 = NativeBinaryManager.a(var19, var1, var6);
            } else {
               var16 = NativeBinaryManager.b(var19, var1, var6);
            }

            if (var16 == null) {
               var2.b("", new RuntimeException("Failed to create command (2)"));
               if (!var3) {
                  var6.delete();
               }

               return false;
            } else {
               String[] var17 = (String[])var16.toArray(new String[var16.size()]);
               System.out.println(Arrays.toString((Object[])var17));
               boolean var20 = false;

               for (int var7 = 0; var7 < var17.length; var7++) {
                  if (var17[var7].contains("Salwyrr")) {
                     var20 = true;
                     break;
                  }
               }

               Process var24 = Runtime.getRuntime().exec(var17, null, var23);
               new C_it(var24).start();
               Integer[] var18 = new Integer[1];
               new C_iu(var24).start();
               var2.b("Restarting. Closing minecraft...", null);
               if (!var20) {
                  Thread.sleep(3000L);
                  a(var0);
               }

               new C_iv(var24, var18).start();
               var2.b("Restarted. Wait for minecraft loading...", null);

               try {
                  var2.a();
                  long var8 = System.currentTimeMillis();
                  synchronized (a) {
                     a.wait(120000L);
                  }

                  if (var20) {
                     a(var0);
                  }

                  if (!var3) {
                     var6.delete();
                  }

                  long var25;
                  if ((var25 = System.currentTimeMillis()) - var8 > 119000L) {
                     var2.b("", new RuntimeException("Failed restart: timeout"));
                     return false;
                  }

                  System.out.println("Restart take " + (var25 - var8));
                  var2.b();
               } catch (Exception var13) {
                  var13.printStackTrace();
               }

               if (var18[0] != null) {
                  var2.b("", new RuntimeException("Minecraft unexpected closed, exit code: " + var18[0]));
                  return false;
               } else {
                  var2.a(55555L);
                  return true;
               }
            }
         }
      } catch (Exception var14) {
         var14.printStackTrace();
         var2.b("", new RuntimeException("Failed restart: " + var14.getMessage() + " : " + var14.getClass().getName()));
         return false;
      }
   }

   private static void a(int var0) {
      try {
         ProcessBuilder var2;
         if (PlatformUtil.h()) {
            var2 = new ProcessBuilder("taskkill", "/PID", Integer.toString(var0), "/F");
         } else {
            var2 = new ProcessBuilder("kill", Integer.toString(var0));
         }

         var2.start();
      } catch (Throwable var1) {
      }
   }

   public static boolean a(int var0, byte[] var1, String var2, InjectionCallback var3) {
      try {
         int var4 = ProcessAttacher.a(var0);
         if (PlatformUtil.h()) {
            if (PlatformUtil.e()) {
               if (var4 == 4) {
                  var3.b(null, new RuntimeException("Injection from x32 to ARM64 process is not supported"));
                  return false;
               }

               if (PlatformUtil.a == 2 && var4 == 1) {
                  var3.b(null, new RuntimeException("Injection from x32 to x64 process on ARM64 machine is not supported"));
                  return false;
               }
            }

            if (var4 == 0 && !DoomsdayGUI.b_bool_1) {
               return ExternalProcessInjector.a(var0, var1, var2, var3);
            }
         } else if (!PlatformUtil.j() && !PlatformUtil.k()) {
            if (PlatformUtil.i() && PlatformUtil.a == 2) {
               if (PlatformUtil.f()) {
                  if (var4 == 1) {
                     var3.b(null, new RuntimeException("Injection from x64 to x64 process on ARM64 machine is not supported"));
                     return false;
                  }

                  if (var4 == 4) {
                     var3.b(null, new RuntimeException("Injection from x64 to ARM64 process is not supported"));
                     return false;
                  }
               } else if (PlatformUtil.d() && var4 == 1) {
                  var3.b(null, new RuntimeException("Injection from ARM64 to x64 process is not supported"));
                  return false;
               }
            }
         } else if (PlatformUtil.e() && (var4 == 4 || var4 == 1)) {
            var3.b(null, new RuntimeException("Injection from 32-bit to 64-bit process is not supported"));
            return false;
         }

         var3.b("Starting inject shellcode to ".concat(String.valueOf(var0)), null);
         byte[] var5 = null;
         if (var4 == 1) {
            var5 = ShellcodeLoader.c();
         } else if (var4 == 3) {
            var5 = ShellcodeLoader.b();
         } else if (var4 == 4) {
            var5 = ShellcodeLoader.a();
         } else if (var4 == 0) {
            var5 = ShellcodeLoader.d();
         } else {
            var3.b(null, new RuntimeException("Unsupported target process architecture: " + NativeBinaryManager.a_String(var4)));
         }

         byte[] var15;
         ShellcodeLoader.a_arr_byte_2(var15 = ShellcodeLoader.a_arr_byte(var5), 3);
         if (PlatformUtil.i()) {
            long var6 = ProcessMemoryHooks.a(var0);
            ShellcodeLoader.a(var15, var15.length - 4096 + 48, var6);
         }

         byte[] var17 = null;
         if ((PlatformUtil.j() || PlatformUtil.i()) && (var17 = a(var3)) == null) {
            return false;
         }

         byte[] var7 = a(var2, var1, 9, var17);
         C_fk var16;
         if ((var16 = ProcessAttacher.a(var0, var15, var7)).b == 0L) {
            if ((int)var16.c != 0) {
               var3.b(null, new RuntimeException(ErrorCodeUtil.b((int)var16.c)));
            } else {
               var3.b("Injected! Loading...", null);
               if (PlatformUtil.h()) {
                  long var20 = ProcessAttacher.a(C_fa.a | C_fa.b, var0);
                  long var10 = 60078L;

                  for (int var13 = 0; var13 < 240; var13++) {
                     if (var4 == 3) {
                        var1 = new byte[4];
                     } else {
                        var1 = new byte[8];
                     }

                     if (!ProcessAttacher.a(var20, var16.a_long_1, var1, var1.length, null)) {
                        ProcessAttacher.b(var20);
                        var3.b(null, new RuntimeException("Failed to read shellcode result"));
                        return false;
                     }

                     if (var4 == 3) {
                        var10 = 0L | (long)(var1[3] & 255) << 24 | (long)(var1[2] & 255) << 16 | (long)(var1[1] & 255) << 8 | var1[0] & 255;
                     } else {
                        var10 = 0L
                           | (long)(var1[7] & 255) << 56
                           | (long)(var1[6] & 255) << 48
                           | (long)(var1[5] & 255) << 40
                           | (long)(var1[4] & 255) << 32
                           | (long)(var1[3] & 255) << 24
                           | (long)(var1[2] & 255) << 16
                           | (long)(var1[1] & 255) << 8
                           | var1[0] & 255;
                     }

                     if (var10 != 60078L) {
                        break;
                     }

                     Thread.sleep(50L);
                  }

                  ProcessAttacher.b(var20);
                  if (var10 == 60078L) {
                     var3.b(null, new RuntimeException("Failed to read shellcode result: timeout"));
                  } else {
                     var3.a(var10);
                  }
               } else {
                  var3.a_Thread_4.join();
               }
            }
         } else {
            System.out.println("ERROR " + var16.b);
            String var8 = "Failed inject shellcode to ".concat(String.valueOf(var0));
            var8 = var8 + ". ";
            var8 = var8 + var16.a_String;
            Object var9 = null;
            if (DoomsdayGUI.b_bool_1) {
               if (var16.b == -8L || var16.b == -13L) {
                  if (PlatformUtil.h()) {
                     var8 = var8 + ". Try to disable antivirus";
                  } else if (PlatformUtil.j()) {
                     var8 = var8 + ". Try to disable SELinux";
                  } else if (PlatformUtil.i()) {
                     var9 = new C_iy("SIP: ".concat(String.valueOf(var8)));
                  }
               }
            } else if (var16.b == -8L || var16.b == -13L) {
               if (PlatformUtil.i() || PlatformUtil.j()) {
                  var3.c();
               }

               return ExternalProcessInjector.a(var0, var1, var2, var3);
            }

            if (var9 == null) {
               var9 = new RuntimeException(var8);
            }

            var3.b(null, (Throwable)var9);
         }
      } catch (Throwable var12) {
         var3.b("Runtime error", new RuntimeException(var12.getMessage()));
         var12.printStackTrace();
      }

      return false;
   }

   private static byte[] a(String var0, byte[] var1, int var2, byte[] var3) {
      try {
         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         if (var3 != null) {
            var4.write(new byte[4]);
            var4.write(var3);
            var4.write(new byte[28 - var3.length]);
         } else {
            var4.write(new byte[32]);
         }

         var4.write(var2);
         var4.write(0);
         var4.write(0);
         byte var10 = 0;
         if (var0 != null && var0.contains("--silentnatives=true")) {
            var10 = 1;
         }

         var4.write(var10);
         var4.write(1);
         var10 = 0;
         if (var0 != null && var0.contains("--loadexperimental=true")) {
            var10 = 1;
         }

         var4.write(var10);
         var4.write(new byte[6]);
         byte[] var12 = null;
         int var13 = 0;
         byte var5 = (byte)new Random().nextInt(128);
         if (var0 != null) {
            var13 = (var12 = var0.getBytes(Charset.forName("UTF-8"))).length;

            for (int var7 = 0; var7 < var13; var7++) {
               var12[var7] ^= var5;
            }
         }

         DataOutputStream var8;
         (var8 = new DataOutputStream(var4)).writeInt(var13);
         var8.write(var5);
         if (var12 != null) {
            var8.write(var12);
         }

         var8.writeInt(var1.length);
         var8.write(var1);
         byte[] var9;
         (var9 = var4.toByteArray())[0] = (byte)(var9.length >>> 24);
         var9[1] = (byte)(var9.length >>> 16);
         var9[2] = (byte)(var9.length >>> 8);
         var9[3] = (byte)var9.length;
         return var9;
      } catch (Exception var6) {
         throw new RuntimeException(var6);
      }
   }

   private static byte[] a(InjectionCallback var0) {
      try {
         String var1 = "\\\\.\\pipe\\return";
         ServerSocket var2;
         byte[] var3;
         long var4;
         if (!PlatformUtil.h()) {
            var4 = 0L;

            try {
               (var2 = new ServerSocket(0)).setSoTimeout(40000);
            } catch (Exception var9) {
               var9.printStackTrace();

               try {
                  Thread.sleep(200L);
                  (var2 = new ServerSocket(0)).setSoTimeout(40000);
               } catch (Exception var8) {
                  var8.printStackTrace();
                  var0.b("Failed to create socket for return value", var8);
                  return null;
               }
            }

            var0.a_ServerSocket_1 = var2;
            var3 = new byte[]{(byte)(var2.getLocalPort() >> 8), (byte)var2.getLocalPort()};
         } else {
            var2 = null;
            var3 = var1.getBytes();
            if ((var4 = ProcessAttacher.a(var1, 1L)) <= 0L && (var4 = ProcessAttacher.a(var1 + new Random().nextInt(), 1L)) <= 0L) {
               var0.b(null, new RuntimeException("Failed to create pipe for return value"));
               return null;
            }
         }

         PipeServerWorker var11 = new PipeServerWorker(var4, var0, var2);
         var0.a_Thread_4 = var11;
         var11.setDaemon(false);
         var11.start();
         return var3;
      } catch (Exception var10) {
         throw new RuntimeException(var10);
      }
   }

   private static String a(byte[] var0, byte[] var1, InjectionCallback var2) {
      byte[] var3;
      (var3 = new byte[4])[3] = (byte)(var0.length >>> 24);
      var3[2] = (byte)(var0.length >>> 16);
      var3[1] = (byte)(var0.length >>> 8);
      var3[0] = (byte)var0.length;
      byte[] var4;
      (var4 = new byte[4])[3] = (byte)(var1.length >>> 24);
      var4[2] = (byte)(var1.length >>> 16);
      var4[1] = (byte)(var1.length >>> 8);
      var4[0] = (byte)var1.length;
      long var6 = 0L;
      ServerSocket var8 = null;
      String var5;
      if (PlatformUtil.h()) {
         String var9 = "\\\\.\\pipe\\javatool";
         if ((var6 = ProcessAttacher.a("\\\\.\\pipe\\javatool", 2L)) <= 0L) {
            var6 = ProcessAttacher.a(var9 = var9 + new Random().nextInt(), 2L);
         }

         if (var6 <= 0L) {
            var2.b(null, new RuntimeException("Failed to create pipe for send shellcode to target process"));
            return null;
         }

         var5 = var9;
      } else {
         try {
            var8 = new ServerSocket(0);
         } catch (Exception var13) {
            var13.printStackTrace();

            try {
               Thread.sleep(200L);
               var8 = new ServerSocket(0);
            } catch (Exception var12) {
               var12.printStackTrace();
               var2.b("Failed to create socket for send shellcode to target process", var12);
               return null;
            }
         }

         var2.b_ServerSocket = var8;
         var5 = Integer.toString(var8.getLocalPort());
      }

      C_ix var14 = new C_ix(var6, var2, var3, var4, var0, var1, var8);
      var2.b_Thread_2 = var14;
      var14.setDaemon(false);
      var14.start();
      return var5;
   }

   private static boolean a(File var0, byte[] var1, InjectionCallback var2) {
      try {
         FileOutputStream var3;
         (var3 = new FileOutputStream(var0)).write(var1);
         var3.close();
         DoomsdayGUI.a(var0);
         return true;
      } catch (Exception var4) {
         var4.printStackTrace();
         var2.b(null, var4);
         return false;
      }
   }

   private static File a_File(InjectionCallback param0) {
      try {
         File dir;
         if (PlatformUtil.i() && DoomsdayGUI.b_bool_1) {
            dir = new File("/tmp");
         } else {
            dir = new File(System.getProperty("java.io.tmpdir"));
         }

         Random rand = new Random();
         for (int i = 0; i < 64; i++) {
            String name = System.mapLibraryName(Integer.toHexString(rand.nextInt()) + "-" + Integer.toHexString(rand.nextInt()));
            File file = new File(dir, name);
            if (!file.exists()) {
               return file;
            }
         }

         param0.b(null, new RuntimeException("Error create inject file"));
         return null;
      } catch (Throwable t) {
         param0.b(null, new RuntimeException("Error create inject file: " + t.getMessage()));
         t.printStackTrace();
         return null;
      }
   }

   public static void a(File var0) {
      try {
         C_ih var1 = new C_ih(new ByteArrayInputStream(FileUtils.a_arr_byte_2(GamePathUtils.a_File())));
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();
         C_ii var3;
         (var3 = new C_ii(var2)).b();
         byte[] var5 = new byte[16384];
         int var7 = 0;

         C_if var4;
         while ((var4 = var1.a_if_2()) != null) {
            if (!var4.a_String_4().endsWith("pack.mcmeta")) {
               C_if var6;
               (var6 = new C_if(var4.a_String_4())).a(1454328000000L);
               var3.a(var6);

               while ((var7 = var1.read(var5)) != -1) {
                  var3.write(var5, 0, var7);
               }

               var3.c();
            }
         }

         var1.close();
         var3.close();
         FileOutputStream var8 = new FileOutputStream(var0);
         var2.writeTo(var8);
         var8.close();
      } catch (Exception var_e) {
         throw new RuntimeException(var_e);
      }
   }
}
