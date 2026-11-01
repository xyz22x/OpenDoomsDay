import java.util.Iterator;
import javax.swing.SwingUtilities;

final class JvmtiInjectTask extends InjectionTask {
   private final VersionTabPanel a_u;
   private final Iterator a_Iterator_1;
   private final InjectionCallback a_cb_2;
   private final boolean a_bool_3;
   private final int a_int_4;
   private final String b;

   JvmtiInjectTask(VersionTabPanel var1, Iterator var2, InjectionCallback var3, boolean var4, int var5, String var6) {
      this.a_u = var1;
      this.a_Iterator_1 = var2;
      this.a_cb_2 = var3;
      this.a_bool_3 = var4;
      this.a_int_4 = var5;
      this.b = var6;
   }

   @Override
   public final void run() {
      DoomsdayGUI var1 = this.a_u.a_a_9;

      try {
         AgentJarPacker.a();
         this.a_u.a_bool = true;
         this.a = this.a_u.a();
         System.out.println();
         System.out.println();
         System.out.println();
         byte[] var2;
         if ((var2 = AgentJarPacker.a(var1, this.a_cb_2)) != null) {
            String var8 = var1.a_au_9.j();
            if (this.a_bool_3) {
               var8 = var8 + " --waitinjectmode";
            }

            if (this.a.equals("jvmti_agent")) {
               if (PlatformUtil.i()) {
                  char[] var3 = ProcessAttacher.b(this.a_int_4);
                  if (new String(var3).trim().contains("-XX:+DisableAttach")) {
                     JvmtiInjector.a(this.a_int_4, var8, this.a_cb_2);
                  } else {
                     JvmtiInjector.a(this.a_int_4, this.b, var2, var8, null, this.a_cb_2);
                  }

                  return;
               } else {
                  JvmtiInjector.a(this.a_int_4, this.b, var2, var8, null, this.a_cb_2);
                  return;
               }
            } else if (this.a.equals("shellcode")) {
               JvmtiInjector.a(this.a_int_4, var2, var8, this.a_cb_2);
               return;
            } else {
               if (this.a.equals("restart")) {
                  JvmtiInjector.a(this.a_int_4, var8, this.a_cb_2);
               } else {
                  if (!this.a.equals("restart 2")) {
                     throw new RuntimeException("Unknown injection " + this.a);
                  }

                  JvmtiInjector.b(this.a_int_4, var8, this.a_cb_2);
               }

               return;
            }
         }
      } catch (Exception var6) {
         this.a_cb_2.b(null, var6);
         var6.printStackTrace();
         return;
      } finally {
         if (!this.a_Iterator_1.hasNext()) {
            this.a_u.a_bool = false;
            SwingUtilities.invokeLater(new C_bv(this.a_u));
         }
      }
   }
}
