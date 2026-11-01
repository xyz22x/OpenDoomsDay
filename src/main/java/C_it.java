import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

final class C_it extends C_ef {
   private final Process a;

   C_it(Process var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         InputStream var1 = this.a.getInputStream();
         BufferedReader var5 = new BufferedReader(new InputStreamReader(var1));

         String var2;
         while ((var2 = var5.readLine()) != null) {
            System.out.println(var2);
            if (var2.contains("LWJGL") || var2.contains("LUNARCLIENT_STATUS_INIT")) {
               synchronized (JvmtiInjector.a) {
                  JvmtiInjector.a.notifyAll();
               }
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }
}
