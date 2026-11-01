import javax.swing.SwingUtilities;

final class C_eq extends Thread {
   private C_ep a;

   C_eq(C_ep var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         Thread.sleep(2000L);
         SwingUtilities.invokeLater(new C_er(this));
      } catch (Throwable var1) {
      }
   }

   static C_ep a(C_eq var0) {
      return var0.a;
   }
}
