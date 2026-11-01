import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class C_i implements ActionListener {
   protected VersionTabPanel a_u;
   protected volatile InjectionTask a_cu_1;
   protected volatile C_ir a_ir_2;

   public C_i(VersionTabPanel var1) {
      this.a_u = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_u.a_dy_6.setEnabled(false);
      this.a_u.b_dy.setEnabled(false);
      this.a_u.a_a_9.a_ex_10.a_cr_1.a_dy_1.setEnabled(false);

      try {
         int var4 = Integer.parseInt(this.a_u.a_JTextField_8.getText());
         ProcessInfo var2;
         String var5;
         if ((var2 = this.a_u.a_a_9.a_gd_13.a_fo(var4)) == null
            || (var5 = var2.c).contains("--version")
            || (!var5.contains("MinecraftLauncher.exe") || !PlatformUtil.h())
               && (!var5.contains("MutliMC.exe") || !PlatformUtil.h())
               && (!var5.contains("MutliMC") || PlatformUtil.h())
               && (!var5.contains("MinecraftLauncher") || PlatformUtil.h())
               && !var5.contains("SKLauncher")
               && (!var5.contains("GDLauncher.exe") || !PlatformUtil.h())
               && (!var5.contains("GDLauncher") || PlatformUtil.h())
               && !var5.startsWith("org.tlauncher.tlauncher.rmo.TLauncher")
               && !var5.startsWith("org.jackhuang.hmcl.Main")
               && !var5.startsWith("net.minecraft.bootstrap.Bootstrap")
               && !var5.startsWith("ru.turikhay.bootstrap.Bootstrap")
               && (!var5.endsWith("Launcher.jar") || !PlatformUtil.h())
               && (!var5.endsWith("Launcher.exe") || !PlatformUtil.h())) {
            C_cc var6;
            if ((var6 = (C_cc)this.a_u.a_a_9.a_gd_13.a_HashMap.get(var4)) != null && var6.a_int_1 > 0) {
               String var7;
               if (var6.a_int_1 == 1) {
                  var7 = "You have already injected the process once. Do you want to inject again?";
               } else if (var6.a_int_1 == 2) {
                  var7 = "You have already injected the process twice. Do you want to inject again?";
               } else {
                  if (var6.a_int_1 == 25) {
                     this.a_u.a_a_9.a("Please, stop! I don't know what can happen...", "Please...");
                     return;
                  }

                  if (var6.a_int_1 == 28) {
                     this.a_u.a_a_9.a("Are you shure?", "Too much");
                     return;
                  }

                  if (var6.a_int_1 == 32) {
                     this.a_u.a_a_9.a("Dude?", "Too much");
                     return;
                  }

                  if (var6.a_int_1 == 35) {
                     this.a_u.a_a_9.a("Ok. Do whatever you want", "Toooo much");
                     return;
                  }

                  var7 = "You have already injected the process " + var6.a_int_1 + " times. Do you want to inject again?";
               }

               this.a_u.a_a_9.a(var7, "Warn", new C_l(this, var4), new C_m(this));
            } else {
               this.a(var4);
            }
         } else {
            this.a_u
               .a_a_9
               .a(
                  "It looks like you want to inject into the minecraft launcher. This is not possible, you must be injected into the running minecraft! Regardless, do you want to continue?",
                  "Warn",
                  new C_j(this, var4),
                  new C_k(this)
               );
         }
      } catch (Exception var3) {
         var3.printStackTrace();
         this.a_u.a_dy_6.setEnabled(true);
         this.a_u.b_dy.setEnabled(true);
         this.a_u.a_a_9.a_ex_10.a_cr_1.a_dy_1.setEnabled(DoomsdayGUI.a_bool_5());
      }
   }

   private void a(int var1) {
      DoomsdayGUI var2 = this.a_u.a_a_9;
      C_cc var3 = (C_cc)this.a_u.a_a_9.a_gd_13.a_HashMap.get(var1);
      ProcessInfo var4;
      String var7;
      if ((var4 = var2.a_gd_13.a_fo(var1)) != null) {
         var7 = var4.b_String_1;
      } else {
         var7 = null;
      }

      CustomDialogBase var5;
      (var5 = this.a_u.a_a_9.a("", "", 5, true)).a().setDefaultCloseOperation(0);
      var5.a().setAlwaysOnTop(true);
      var5.a_dy().setVisible(false);
      WorkerStatusCallback var6 = new WorkerStatusCallback(this, var5, var3);
      var5.a_JTextArea_2().setText("Starting...");
      this.a_cu_1 = new ShellcodeInjectTask(this, var2, var6, var1, var7);
      this.a_ir_2 = new C_r(this, var6);
      this.a_cu_1.start();
      this.a_ir_2.start();
   }

   static void a(C_i var0, int var1) {
      var0.a(var1);
   }
}
