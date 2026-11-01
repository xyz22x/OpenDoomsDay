import java.util.ArrayList;
import javax.swing.SwingUtilities;

final class C_by extends Thread {
   private C_bp a;

   C_by(C_bp var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      SwingUtilities.invokeLater(new C_bz(this));
      DoomsdayGUI.a_a_3.a_gd_13.a(50);
      DoomsdayGUI.a_a_3.a_gd_13.a();
      ArrayList var1 = new ArrayList(3);

      for (Object var2_raw : DoomsdayGUI.a_a_3.a_gd_13.a_List_1) { TargetProcess var2 = (TargetProcess)var2_raw;
         var1.add(var2);
      }

      try {
         Thread.sleep(Integer.parseInt(DoomsdayGUI.a_a_3.a_fr_11.a_eg_2.b_JTextField_1.getText()));
      } catch (Throwable var4) {
         var4.printStackTrace();
      }

      C_bp.a(this.a, var1);
      DoomsdayGUI.a_a_3.a_gd_13.a(2000);
      SwingUtilities.invokeLater(new C_ca(this));
   }

   static C_bp a(C_by var0) {
      return var0.a;
   }
}
