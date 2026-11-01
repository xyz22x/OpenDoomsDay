import javax.swing.SwingUtilities;

final class C_d extends Thread {
   private C_c a;

   C_d(C_c var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         Thread.sleep(3500L);
      } catch (Exception var1) {
      }

      SwingUtilities.invokeLater(new C_e(this));
   }

   static C_c a(C_d var0) {
      return var0.a;
   }
}
