import java.util.Iterator;
import javax.swing.SwingUtilities;

final class C_bw extends C_ir {
   private C_bp a_bp;
   private final VersionTabPanel a_u_1;
   private final Iterator a_Iterator_2;
   private final InjectionCallback a_cb_3;

   C_bw(C_bp var1, VersionTabPanel var2, Iterator var3, InjectionCallback var4) {
      this.a_bp = var1;
      this.a_u_1 = var2;
      this.a_Iterator_2 = var3;
      this.a_cb_3 = var4;
   }

   @Override
   public final void run() {
      try {
         int var1 = this.a_u_1.a_a_9.a_au_9.b() << 1;

         try {
            long var2;
            if ((var2 = C_dx.a()) > 0L && var2 <= -2147483648L || PlatformUtil.b() || Runtime.getRuntime().availableProcessors() <= 2) {
               var1 = (int)(var1 * 1.5F);
            }
         } catch (Throwable var9) {
         }

         for (int var12 = 0; var12 < var1; var12++) {
            Thread.sleep(500L);
            if (this.isInterrupted()) {
               return;
            }

            if (this.a) {
               var12--;
            }
         }

         if (!this.a_Iterator_2.hasNext()) {
            SwingUtilities.invokeLater(new C_bx(this.a_u_1));
         }

         if (AgentJarPacker.a_int_1 != 2) {
            this.a_cb_3.b(null, new RuntimeException("Failed to inject: timeout, natives unitialized?"));
         } else {
            this.a_cb_3.b(null, new RuntimeException("Failed to inject: timeout"));
         }

         try {
            this.a_bp.a_cu_1.interrupt();
         } catch (Throwable var8) {
            var8.printStackTrace();
         }
      } catch (Exception var10) {
      } finally {
         this.a_u_1.a_bool = false;
      }
   }
}
