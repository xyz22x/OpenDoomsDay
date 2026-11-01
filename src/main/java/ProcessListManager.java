import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;

public final class ProcessListManager extends Thread {
   public HashMap a_HashMap = new HashMap();
   public List a_List_1 = Collections.synchronizedList(new ArrayList());
   public List b = new ArrayList();
   protected final VersionTabPanel a_u_2;
   public volatile List c;
   private int a_int_3 = 2000;
   private static Object a_Object_4 = new Object();
   private static String[] a_arr_String_5 = new String[]{
      "1.8.9",
      "1.9.4",
      "1.12.2",
      "1.14.4",
      "1.15.2",
      "1.16.5",
      "1.17.1",
      "1.18.2",
      "1.19.1",
      "1.19.2",
      "1.19.3",
      "1.19.4",
      "1.20.1",
      "1.20.4",
      "1.20.5",
      "1.20.6",
      "1.21.1",
      "1.21.3",
      "1.21.4"
   };

   public ProcessListManager() {
      this.a_u_2 = null;
      this.setName("UpdateProcessThread");
   }

   public ProcessListManager(VersionTabPanel var1) {
      this.a_u_2 = var1;
      this.setName("UpdateProcessThread");
   }

   private void a(List var1) {
      try {
         this.a_List_1.clear();
         Iterator var2 = var1.iterator();

         while (var2.hasNext()) {
            ProcessInfo var11;
            (var11 = (ProcessInfo)var2.next()).a_bool_3 = false;
            if (var11.c.length() > 0 && (!var11.a_String_1.startsWith("/bin/sh") || !var11.c.startsWith("-c"))) {
               String var3 = null;
               String var4 = null;
               int var5;
               if ((var5 = var11.c.indexOf("--username ")) >= 0) {
                  var5 += 11;
                  int var6;
                  if ((var6 = var11.c.indexOf(32, var5)) >= 0) {
                     var3 = var11.c.substring(var5, var6);
                  } else {
                     var3 = var11.c.substring(var5, var11.c.length());
                  }
               }

               int var19;
               if ((var19 = var11.c.indexOf("--version ")) >= 0) {
                  var19 += 10;
                  int var13;
                  if ((var13 = var11.c.indexOf(" --", var19)) >= 0) {
                     var4 = var11.c.substring(var19, var13);
                  } else {
                     var4 = var11.c.substring(var19, var11.c.length());
                  }
               }

               if (var3 == null && var4 != null && var4.endsWith(" 2\u0000")) {
                  var4 = null;
                  var19 = -1;
               }

               if (var19 < 0 && (var19 = var11.c.indexOf("--fml.mcVersion ")) >= 0) {
                  var19 += 16;
                  int var14;
                  if ((var14 = var11.c.indexOf(" --", var19)) >= 0) {
                     var4 = var11.c.substring(var19, var14);
                  } else {
                     var4 = var11.c.substring(var19, var11.c.length());
                  }
               }

               if (var3 != null || var4 != null) {
                  this.a_List_1.add(new TargetProcess(var11.b_int, var4, var3));
                  var11.a_bool_3 = true;
               } else if (var11.c.indexOf("org.multimc.EntryPoint") >= 0) {
                  this.a_List_1.add(new TargetProcess(var11.b_int, "MultiMC", "Minecraft"));
                  var11.a_bool_3 = true;
               } else if (var11.c.indexOf("org.prismlauncher.EntryPoint") >= 0) {
                  this.a_List_1.add(new TargetProcess(var11.b_int, "PrismMC", "Minecraft"));
                  var11.a_bool_3 = true;
               } else if (var11.c.indexOf("lwjgl") >= 0 && var11.c.indexOf("minecraft") >= 0) {
                  boolean var15 = false;

                  for (int var12 = 0; var12 < a_arr_String_5.length; var12++) {
                     String var18;
                     String var22 = var18 = a_arr_String_5[var12];
                     int var7 = 0;

                     for (int var8 = 0; var8 < var22.length(); var8++) {
                        if (var22.charAt(var8) == '.') {
                           var7++;
                        }
                     }

                     if (var7 == 1) {
                        var18 = var18 + ".jar";
                     }

                     if (var11.c.contains(var18)) {
                        this.a_List_1.add(new TargetProcess(var11.b_int, a_arr_String_5[var12], "Minecraft"));
                        var11.a_bool_3 = true;
                        var15 = true;
                        break;
                     }
                  }

                  if (!var15) {
                     this.a_List_1.add(new TargetProcess(var11.b_int, "?", "Minecraft"));
                     var11.a_bool_3 = true;
                  }
               } else if (var11.c.indexOf("forge") >= 0 && var11.c.indexOf("fml") >= 0) {
                  this.a_List_1.add(new TargetProcess(var11.b_int, "Forge", "Minecraft"));
                  var11.a_bool_3 = true;
               }

               if (this.a_List_1.size() > 0) {
                  synchronized (a_Object_4) {
                     a_Object_4.notifyAll();
                  }
               }
            }
         }

         if (this.a_u_2 != null) {
            SwingUtilities.invokeLater(new C_ge(this));
            return;
         }
      } catch (Throwable var10) {
         var10.printStackTrace();
      }
   }

   @Override
   public final void run() {
      try {
         while (true) {
            List var1 = WindowsProcessInfo.b();
            List var2 = UnixProcessInfo.a();
            this.c = var1;
            this.b.clear();

            for (Object var3_raw : var1) { ProcessInfo var3 = (ProcessInfo)var3_raw;
               if (PlatformUtil.h()) {
                  if (!var3.a_String_1.equalsIgnoreCase("java.exe") && !var3.a_String_1.equalsIgnoreCase("javaw.exe")) {
                     Iterator var16 = var2.iterator();

                     while (var16.hasNext()) {
                        ProcessInfo var12;
                        if ((var12 = (ProcessInfo)var16.next()).b_int == var3.b_int) {
                           this.b.add(var3);
                           if (var3.c == null || var3.c.length() == 0) {
                              var3.c = var12.c;
                              System.out.println("Weird java process " + var3.b_int + " " + var3.a_String_1 + " " + var3.c);
                           }

                           if (var3.c != null && var12.c != null && var12.c.length() > var3.c.length() + 2) {
                              System.out.println("Weird 2 java process " + var3.b_int + " " + var3.a_String_1 + " " + var3.c);
                           }
                           break;
                        }
                     }
                  } else {
                     this.b.add(var3);
                     Iterator var15 = var2.iterator();

                     while (var15.hasNext()) {
                        ProcessInfo var5;
                        if ((var5 = (ProcessInfo)var15.next()).b_int == var3.b_int) {
                           if (var3.c == null || var3.c.length() == 0) {
                              var3.c = var5.c;
                           }
                           break;
                        }
                     }
                  }
               } else if (var3.a_String_1.indexOf("java") >= 0) {
                  this.b.add(var3);
               } else {
                  Iterator var6 = var2.iterator();

                  while (var6.hasNext()) {
                     if (((ProcessInfo)var6.next()).b_int == var3.b_int) {
                        this.b.add(var3);
                        break;
                     }
                  }
               }
            }

            this.a(var1);

            for (Object var9_raw : var1) { ProcessInfo var9 = (ProcessInfo)var9_raw;
               C_cc var13;
               if ((var13 = (C_cc)this.a_HashMap.get(var9.b_int)) != null) {
                  if (var9 instanceof UnixProcessInfo) {
                     if (var13.b_String != null && !var13.b_String.equals(var9.a_String_1)) {
                        this.a_HashMap.remove(var9.b_int);
                        var13 = null;
                     }
                  } else if (var13.a_String != null && !var13.a_String.equals(var9.a_String_1)) {
                     this.a_HashMap.remove(var9.b_int);
                     var13 = null;
                  }
               }

               if (var13 == null) {
                  if (var9 instanceof UnixProcessInfo) {
                     var13 = new C_cc(null, var9.a_String_1);
                  } else {
                     var13 = new C_cc(var9.a_String_1, null);
                  }

                  this.a_HashMap.put(var9.b_int, var13);
               }
            }

            if (this.a_u_2 != null) {
               SwingUtilities.invokeLater(new C_gf(this, var1));
            }

            synchronized (VersionTabPanel.a_Object_1) {
               VersionTabPanel.a_Object_1.wait(this.a_int_3);
            }
         }
      } catch (InterruptedException var8) {
         var8.printStackTrace();
      }
   }

   public final void a(int var1) {
      this.a_int_3 = var1;
      synchronized (VersionTabPanel.a_Object_1) {
         VersionTabPanel.a_Object_1.notify();
      }
   }

   public final ProcessInfo a_fo(int var1) {
      Iterator var3 = this.c.iterator();

      while (var3.hasNext()) {
         ProcessInfo var2;
         if ((var2 = (ProcessInfo)var3.next()).b_int == var1) {
            return var2;
         }
      }

      return null;
   }

   public final void a() {
      synchronized (a_Object_4) {
         try {
            if (this.a_List_1.size() == 0) {
               a_Object_4.wait();
            }
         } catch (Exception var2) {
         }
      }
   }

   public final void b() {
      synchronized (a_Object_4) {
         try {
            if (this.a_List_1.size() == 0) {
               a_Object_4.wait(5000L);
            }
         } catch (Exception var2) {
         }
      }
   }

   public final boolean a(ProcessInfo var1) {
      for (int var2 = this.a_u_2.a_DefaultTableModel_5.getRowCount() - 1; var2 >= 0; var2--) {
         ProcessInfo var3 = (ProcessInfo)this.a_u_2.a_DefaultTableModel_5.getValueAt(var2, 0);
         if (var1.equals(var3)) {
            return true;
         }
      }

      return false;
   }
}
