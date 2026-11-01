import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.Executors;

public final class ClientConfig {
   private String a_String;
   private String b_String;
   private boolean a_bool_1;
   private int a_int_2;
   private String c_String;
   private String d_String;
   private String e_String;
   private String f_String;
   private boolean b_bool_1;
   private boolean c_bool_1;
   private String g_String;
   private String h_String;
   private boolean d_bool_1;
   private boolean e_bool_1;
   private boolean f_bool_1;
   private boolean g_bool_1;
   private String i_String;
   private boolean h_bool_1;
   private int b_int_2;
   private boolean i_bool_1;
   private Properties a_Properties_3;
   private Properties b_Properties_3;
   private Properties c_Properties_2;
   private boolean j;
   private static String[] a_arr_String_4 = new String[]{
      "Thread", "DoPrivileged", "GetSystemPackage", "IsInterrupted", "IsThreadAlive", "MonitorWait", "MonitorNotify", "Sleep", "StartThread"
   };
   public volatile C_dw a_dw_5;
   private static boolean k;

   static {
      String[] var10000 = new String[]{"None", "MonitorNotify", "LWJGL"};
   }

   private static String a(Properties var0, String var1, String var2) {
      var2 = var0.getProperty(var1, var2);
      var0.put(var1, var2);
      return var2;
   }

   public ClientConfig(byte[] var1) {
      new Object();
      Collections.synchronizedList(new ArrayList());
      this.a_Properties_3 = new Properties();
      this.b_Properties_3 = new Properties();
      this.c_Properties_2 = new Properties();
      Executors.newFixedThreadPool(8);
      new HashMap();
      new Object();
      Properties var2 = new Properties();

      try {
         if (var1 != null) {
            var2.load(new ByteArrayInputStream(var1));
         } else {
            var2.load(new ByteArrayInputStream(AgentJarPacker.a("f")));
         }
      } catch (Exception var6) {
      }

      this.c_Properties_2 = (Properties)var2.clone();
      this.a_String = a(var2, "window_title", "");
      this.b_String = a(var2, "opened_tab", PlatformUtil.k() ? "install" : "inject");
      this.a_bool_1 = a(var2, "window_maximized", "false").equals("true");
      this.c_String = a(var2, "inject_mode", "shellcode");
      this.d_String = a(var2, "show_process_mode", "java");
      String var3 = a(var2, "monitor_index", "-1");

      try {
         this.a_int_2 = Integer.parseInt(var3);
      } catch (Exception var5) {
      }

      this.e_String = a(var2, "inject_attach_mode", "Thread");
      a(var2, "inject_second_hook_mode", "None");
      a(var2, "inject_run_in_a_new_thread", "true").equalsIgnoreCase("true");
      this.f_String = a(var2, "inject_arguments", "");
      this.b_bool_1 = a(var2, "check_update_automatically", "true").equals("true");
      a(var2, "silent_mode", "false").equals("true");
      this.j = a(var2, "extended_mode", "false").equals("true");
      a(var2, "loader_library_directory", "$loader$");
      a(var2, "loader_library_name", "loader_natives");
      this.c_bool_1 = a(var2, "run_as_admin", "false").equalsIgnoreCase("true");
      a(var2, "install_library_directory", "$config$");
      a(var2, "install_library_name", "doomsday_natives");
      this.h_String = a(var2, "install_version_name", "$latest$");
      this.g_String = a(var2, "inject_version_name", "$latest$");
      a(var2, "hide_all_rdll_strings", "false").equalsIgnoreCase("true");
      a(var2, "hide_rdll_strings", "true").equalsIgnoreCase("true");
      a(var2, "show_process_bitness", "false").equalsIgnoreCase("true");
      this.d_bool_1 = a(var2, "install_as_mod", "false").equalsIgnoreCase("true");
      this.e_bool_1 = a(var2, "install_advanced_settings", "false").equalsIgnoreCase("true");
      this.f_bool_1 = a(var2, "install_create_instance", "true").equalsIgnoreCase("true");
      this.g_bool_1 = a(var2, "save_updates_in_loader", "false").equalsIgnoreCase("true");
      a(var2, "inject_macos_arm_shellcode", "");
      this.i_String = a(var2, "install_launcher_location", "$default$");
      var3 = a(var2, "auto_save_config", "false");
      this.h_bool_1 = var3.equalsIgnoreCase("true");
      var3 = a(var2, "inject_timeout", "20");

      try {
         this.b_int_2 = Integer.parseInt(var3);
      } catch (Exception var4) {
      }

      a(var2, "dev_extended_mode", "false").equalsIgnoreCase("true");
      this.i_bool_1 = a(var2, "show_success_inject_message", "true").equalsIgnoreCase("true");
      this.a_Properties_3 = var2;
      if (var1 == null) {
         this.b_Properties_3.putAll(this.a_Properties_3);
      }
   }

   public static String a(int var0) {
      return a_arr_String_4[var0];
   }

   public static int a_int_2(String var0) {
      for (int var1 = 0; var1 < a_arr_String_4.length; var1++) {
         if (a_arr_String_4[var1].equals(var0)) {
            return var1;
         }
      }

      return 0;
   }

   public final String a_String_3() {
      return this.c_String;
   }

   public final void a(String var1) {
      this.c_String = var1;
      this.a_str("inject_mode", var1);
   }

   public final String b_String() {
      return this.d_String;
   }

   public final void b(String var1) {
      this.d_String = var1;
      this.a_str("show_process_mode", var1);
   }

   public final String c_String() {
      return this.a_String;
   }

   public final void c(String var1) {
      this.a_String = var1;
      this.a_str("window_title", var1);
   }

   public final String d_String() {
      return this.b_String;
   }

   public final void d(String var1) {
      this.b_String = var1;
      this.a_str("opened_tab", var1);
   }

   public final boolean a_bool_4() {
      return this.a_bool_1;
   }

   public final void a(boolean var1) {
      this.a_bool_1 = var1;
      this.a_str("window_maximized", Boolean.toString(var1));
   }

   public final int a_int_2() {
      return this.a_int_2;
   }

   public final void a(int var1, int var2) {
      this.a_int_2 = var1;
      if (var1 == var2) {
         this.a_str("monitor_index", "-1");
      } else {
         this.a_str("monitor_index", Integer.toString(var1));
      }
   }

   public final void e(String var1) {
      this.e_String = var1;
      this.a_str("inject_attach_mode", var1);
   }

   public final String e_String() {
      return this.e_String;
   }

   public final void f(String var1) {
      this.f_String = var1;
      this.a_str("inject_arguments", var1);
   }

   public final String f_String() {
      return this.f_String;
   }

   public final boolean b_bool_2() {
      return this.b_bool_1;
   }

   public final void b(boolean var1) {
      this.b_bool_1 = var1;
      this.a_str("check_update_automatically", Boolean.toString(var1));
   }

   public final void c(boolean var1) {
      this.c_bool_1 = var1;
      this.a_str("run_as_admin", Boolean.toString(var1));
   }

   public final boolean c() {
      return this.c_bool_1;
   }

   public final Boolean a_Boolean() {
      return this.h_bool_1;
   }

   public final void a(Boolean var1) {
      this.h_bool_1 = var1;
      if (var1 == null) {
         this.a_str("auto_save_config", null);
      } else {
         this.a_str("auto_save_config", var1.toString());
      }
   }

   public final boolean d() {
      return this.g_bool_1;
   }

   public final void d(boolean var1) {
      this.g_bool_1 = var1;
      this.a_str("save_updates_in_loader", Boolean.toString(var1));
   }

   public final String g_String() {
      return this.g_String;
   }

   public final void g(String var1) {
      this.g_String = var1;
      this.a_str("inject_version_name", var1);
   }

   public final String h() {
      return this.h_String;
   }

   public final void h(String var1) {
      this.h_String = var1;
      this.a_str("install_version_name", var1);
   }

   public final void e(boolean var1) {
      this.a_str("show_process_bitness", Boolean.toString(var1));
   }

   public final void i(String var1) {
      this.i_String = var1;
      this.a_str("install_launcher_location", var1);
   }

   public final String i() {
      return this.i_String;
   }

   public final void f(boolean var1) {
      this.d_bool_1 = var1;
      this.a_str("install_as_mod", Boolean.toString(var1));
   }

   public final boolean e() {
      return this.d_bool_1;
   }

   public final void g(boolean var1) {
      this.e_bool_1 = var1;
      this.a_str("install_advanced_settings", Boolean.toString(var1));
   }

   public final boolean f() {
      return this.e_bool_1;
   }

   public final void h(boolean var1) {
      this.f_bool_1 = var1;
      this.a_str("install_create_instance", Boolean.toString(this.e_bool_1));
   }

   public final int b() {
      return this.b_int_2;
   }

   public final boolean g() {
      return this.f_bool_1;
   }

   public final boolean h_bool() {
      return this.i_bool_1;
   }

   public final void a_bytes(String var1, byte[] var2) {
      try {
         if (this.a_dw_5 == null) {
            this.a_dw_5 = new C_dw();
            this.a_dw_5.start();
         }

         a_void_5();
         this.a_dw_5.a(var1, var2);
      } catch (Exception var3) {
         throw new RuntimeException(var3);
      }
   }

   public final void j(String var1) {
      try {
         if (this.a_dw_5 == null) {
            this.a_dw_5 = new C_dw();
            this.a_dw_5.start();
         }

         a_void_5();
         this.a_dw_5.a(var1);
      } catch (Exception var2) {
         throw new RuntimeException(var2);
      }
   }

   private boolean k() {
      return !this.b_Properties_3.equals(this.a_Properties_3);
   }

   public final void a_str(String var1, String var2) {
      synchronized (this.a_Properties_3) {
         if (var2 == null) {
            this.a_Properties_3.remove(var1);
         } else if (!this.a_Properties_3.get(var1).equals(var2)) {
            this.a_Properties_3.put(var1, var2);
         }
      }
   }

   public final String a_String(String var1) {
      String var2 = this.f_String;
      var2 = var2 + "--configstorage=" + FileUtils.a(var1);
      return var2 + " --doomsdayversion=" + FileUtils.a(this.h_String);
   }

   public final String j() {
      String var1 = this.f_String;
      if (!this.f_String.isEmpty()) {
         var1 = var1 + " ";
      }

      if (GamePathUtils.e() != null) {
         var1 = var1 + " --loaderpath=" + FileUtils.a(GamePathUtils.e());
      }

      var1 = var1 + " --loaderpid=" + DoomsdayGUI.b_int;
      if (DoomsdayGUI.a_ee_4 != null) {
         var1 = var1 + " --loaderkill=" + DoomsdayGUI.a_ee_4.a;
      }

      if (PlatformUtil.h()) {
         if (WindowsProcessInfo.a_int == 0) {
            WindowsProcessInfo.a();
         }

         var1 = var1 + " --explorerpid=" + WindowsProcessInfo.a_int;
      }

      return var1 + " --loaderstarttime=" + ManagementFactory.getRuntimeMXBean().getStartTime();
   }

   public final byte[] a() {
      try {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         Properties var2 = new Properties();
         Iterator var4 = this.c_Properties_2.entrySet().iterator();

         while (var4.hasNext()) {
            Entry var3;
            if ((var3 = (Entry)var4.next()).getValue() != null) {
               var2.put(var3.getKey(), var3.getValue());
            }
         }

         var4 = this.a_Properties_3.entrySet().iterator();

         while (var4.hasNext()) {
            Entry var6;
            if ((var6 = (Entry)var4.next()).getValue() != null && !var6.getValue().equals(this.b_Properties_3.get(var6.getKey()))) {
               var2.put(var6.getKey(), var6.getValue());
            }
         }

         var2.store(var1, null);
         return var1.toByteArray();
      } catch (Exception var5) {
         var5.printStackTrace();
         return null;
      }
   }

   public final boolean i_bool() {
      return this.j;
   }

   private static void a_void_5() {
      if (!k) {
         C_cv.a_arr_byte_2();
         if (PlatformUtil.h()) {
            ArrayList var12;
            ProcessAttacher.a_int(var12 = new ArrayList());
            String var10000 = GamePathUtils.a_File().getAbsolutePath();
            String var16 = var10000.substring(var10000.indexOf(":") + 1);
            Iterator var20 = var12.iterator();

            while (var20.hasNext()) {
               Object[] var18;
               char[] var22 = (char[])(var18 = (Object[])var20.next())[0];
               char[] var13 = (char[])var18[1];
               String var23 = new String(var22);
               String var14 = new String(var13);
               int var24 = ((int[])var18[2])[0];
               if (var23.equalsIgnoreCase("file") && var14.endsWith(var16)) {
                  if (ProcessAttacher.b((long)var24)) {
                     System.out.println("File " + var14 + " closed");
                     k = true;
                  } else {
                     System.out.println("File " + var14 + " not closed");
                  }
               }
            }

            return;
         }

         if (PlatformUtil.j() || PlatformUtil.k()) {
            File[] var11 = new File("/proc/self/fd").listFiles();

            for (int var15 = 0; var15 < var11.length; var15++) {
               try {
                  int var17 = Integer.parseInt(var11[var15].getName());
                  String var19;
                  if ((var19 = var11[var15].getCanonicalPath()).equals(GamePathUtils.e())) {
                     int var21;
                     if ((var21 = ProcessAttacher.b_int(var17)) == 0) {
                        k = true;
                        System.out.println("File " + var19 + " closed");
                     } else {
                        System.out.println("File " + var19 + " not closed: " + var21);
                     }
                  }
               } catch (Exception var7) {
               }
            }

            return;
         }

         if (PlatformUtil.i()) {
            try {
               Process var1 = new ProcessBuilder("lsof", "-Ffn", "-p", Integer.toString(DoomsdayGUI.b_int)).start();
               BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));
               String var4 = GamePathUtils.e();
               String var0 = null;

               String var3;
               while ((var3 = var2.readLine()) != null) {
                  if (var3.indexOf(var4) > 0) {
                     String var5 = var0;
                     if (var0 != null) {
                        try {
                           int var6;
                           int var10;
                           if ((var6 = ProcessAttacher.b_int(var10 = Integer.parseInt(var5.substring(1)))) == 0) {
                              k = true;
                              System.out.println("File " + var10 + " " + var4 + " closed");
                              return;
                           }

                           System.out.println("File " + var10 + " " + var4 + " not closed: " + var6);
                           return;
                        } catch (Exception var8) {
                        }
                     }
                  }

                  var0 = var3;
               }

               return;
            } catch (Exception var9) {
               var9.printStackTrace();
            }
         }
      }
   }

   public final boolean j_bool() {
      try {
         a_void_5();
         System.out.println("Save config anyChanged " + this.k());
         if (this.k()) {
            this.a_bytes("f", this.a());
            this.b_Properties_3 = (Properties)this.a_Properties_3.clone();
         }

         return true;
      } catch (Throwable var1) {
         var1.printStackTrace();
         return false;
      }
   }
}
