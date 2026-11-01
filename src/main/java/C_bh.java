import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.UIManager;

public final class C_bh implements ComponentListener {
   private DoomsdayGUI a;

   public C_bh(DoomsdayGUI var1) {
      this.a = var1;
   }

   @Override
   public final void componentShown(ComponentEvent var1) {
      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         if (this.a.a_au_9.b_bool_2()) {
            new C_bi().start();
         }

         new C_fn().start();
         this.a.a_gd_13.start();
         if (!PlatformUtil.a()) {
            if (PlatformUtil.g()) {
               this.a
                  .a(
                     "Wow, you are using RISCV64 system. Very cool. RISCV is future. Unfortunately this arch is not supported for now. Let me know if you need run DoomsDay on this arch. 04.12.2022",
                     "Warning"
                  );
               return;
            }

            this.a.a("Your system  is not supported (" + AgentJarPacker.a_String() + ", " + AgentJarPacker.b() + ", " + AgentJarPacker.c() + ")", "Warning");
            return;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   @Override
   public final void componentResized(ComponentEvent var1) {
      try {
         int var3;
         if (var1.getComponent().isVisible() && (var3 = this.a.a_int_2()) != this.a.d_int_3 && var3 != DoomsdayGUI.c_int_3) {
            this.a.a_au_9.a(var3, DoomsdayGUI.c_int_3);
            return;
         }
      } catch (Exception var2) {
      }
   }

   @Override
   public final void componentMoved(ComponentEvent var1) {
      try {
         int var3;
         if (var1.getComponent().isVisible() && (var3 = this.a.a_int_2()) != this.a.d_int_3) {
            this.a.a_au_9.a(var3, DoomsdayGUI.c_int_3);
            return;
         }
      } catch (Exception var2) {
      }
   }

   @Override
   public final void componentHidden(ComponentEvent var1) {
   }
}
