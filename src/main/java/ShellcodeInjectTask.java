import java.io.File;
import javax.swing.SwingUtilities;

final class ShellcodeInjectTask extends InjectionTask {
   private C_i a_i;
   private final DoomsdayGUI a_a_1;
   private final InjectionCallback a_cb_2;
   private final int a_int_3;
   private final String b;

   ShellcodeInjectTask(C_i var1, DoomsdayGUI var2, InjectionCallback var3, int var4, String var5) {
      this.a_i = var1;
      this.a_a_1 = var2;
      this.a_cb_2 = var3;
      this.a_int_3 = var4;
      this.b = var5;
   }

   @Override
   public final void run() {
      try {
         this.a_i.a_u.a_bool = true;
         this.a = this.a_i.a_u.a();

         // Check if a custom JAR was selected
         ClientVersion selectedVer = null;
         Object selectedObj = this.a_a_1.a_ex_10.a_u_2.c.getSelectedItem();
         if (selectedObj instanceof ClientVersion) {
            selectedVer = (ClientVersion) selectedObj;
         } else if (selectedObj instanceof LocalClientVersion) {
            selectedVer = ((LocalClientVersion) selectedObj).a_gg;
         }

         boolean isCustom = (selectedVer != null && (selectedVer.isCustom() || selectedVer.a_File_5 != null));
         File customJar = isCustom ? selectedVer.a_File_5 : null;

         if (isCustom && customJar != null && customJar.exists()) {
            if (this.a.equals("restart") || this.a.equals("restart 2")) {
               String var2 = this.a_a_1.a_au_9.j();
               var2 = var2 + " --customjar=" + FileUtils.a(customJar.getAbsolutePath());
               if (this.a.equals("restart 2")) {
                  JvmtiInjector.b(this.a_int_3, var2, this.a_cb_2);
               } else {
                  JvmtiInjector.a(this.a_int_3, var2, this.a_cb_2);
               }
            } else {
               CustomJarInjector.inject(this.a_int_3, customJar, this.a_cb_2);
            }
            return;
         }

         AgentJarPacker.a();
         byte[] var1;
         if ((var1 = AgentJarPacker.a(this.a_a_1, this.a_cb_2)) == null) {
            return;
         }

         // Also check if payload byte array has ZIP magic header PK\x03\x04
         if (var1.length > 4 && var1[0] == 0x50 && var1[1] == 0x4B && var1[2] == 0x03 && var1[3] == 0x04) {
            File tmpJar = File.createTempFile("custom-inject-", ".jar");
            tmpJar.deleteOnExit();
            java.nio.file.Files.write(tmpJar.toPath(), var1);
            if (this.a.equals("restart") || this.a.equals("restart 2")) {
               String var2 = this.a_a_1.a_au_9.j();
               var2 = var2 + " --customjar=" + FileUtils.a(tmpJar.getAbsolutePath());
               if (this.a.equals("restart 2")) {
                  JvmtiInjector.b(this.a_int_3, var2, this.a_cb_2);
               } else {
                  JvmtiInjector.a(this.a_int_3, var2, this.a_cb_2);
               }
            } else {
               CustomJarInjector.inject(this.a_int_3, tmpJar, this.a_cb_2);
            }
            return;
         }

         String var2 = this.a_a_1.a_au_9.j();
         if (this.a.equals("jvmti_agent")) {
            JvmtiInjector.a(this.a_int_3, this.b, var1, var2, null, this.a_cb_2);
         } else if (this.a.equals("shellcode")) {
            JvmtiInjector.a(this.a_int_3, var1, var2, this.a_cb_2);
         } else if (this.a.equals("restart")) {
            var2 = var2 + " --doomsdayversion=" + FileUtils.a(this.a_a_1.a_au_9.g_String());
            JvmtiInjector.a(this.a_int_3, var2, this.a_cb_2);
         } else {
            if (!this.a.equals("restart 2")) {
               throw new RuntimeException("Unknown injection " + this.a);
            }

            var2 = var2 + " --doomsdayversion=" + FileUtils.a(this.a_a_1.a_au_9.g_String());
            JvmtiInjector.b(this.a_int_3, var2, this.a_cb_2);
         }
      } catch (Exception var5) {
         var5.printStackTrace();
         if (this.a_cb_2 != null) {
            this.a_cb_2.b(null, var5);
         }
         return;
      } finally {
         this.a_i.a_u.a_bool = false;
         SwingUtilities.invokeLater(new C_q(this));
      }
   }

   static C_i a(ShellcodeInjectTask var0) {
      return var0.a_i;
   }
}
