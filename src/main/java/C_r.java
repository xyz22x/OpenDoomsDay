import javax.swing.SwingUtilities;

final class C_r extends C_ir {
   private C_i a_i;
   private final InjectionCallback a_cb_1;

   C_r(C_i var1, InjectionCallback var2) {
      this.a_i = var1;
      this.a_cb_1 = var2;
   }

   @Override
   public final void run() {
      try {
         int var1 = this.a_i.a_u.a_a_9.a_au_9.b() << 1;

         try {
            long var2;
            if ((var2 = C_dx.a()) > 0L && var2 <= -2147483648L || PlatformUtil.b() || Runtime.getRuntime().availableProcessors() <= 2) {
               var1 = (int)(var1 * 1.5F);
            }
         } catch (Throwable var10) {
         }

         for (int var14 = 0; var14 < var1; var14++) {
            Thread.sleep(500L);
            if (this.isInterrupted()) {
               return;
            }

            if (this.a) {
               var14--;
            }
         }

         SwingUtilities.invokeLater(new C_s(this));
         if (AgentJarPacker.a_int_1 != 2) {
            this.a_cb_1.b(null, new RuntimeException("Failed to inject: timeout, natives unitialized?"));
         } else {
            this.a_cb_1.b(null, new RuntimeException("Failed to inject: timeout"));
         }

         try {
            this.a_i.a_cu_1.interrupt();
         } catch (Throwable var9) {
            var9.printStackTrace();
         }
      } catch (InterruptedException var11) {
      } catch (Exception var12) {
         var12.printStackTrace();
      } finally {
         this.a_i.a_u.a_bool = false;
      }
   }

   static C_i a(C_r var0) {
      return var0.a_i;
   }
}
