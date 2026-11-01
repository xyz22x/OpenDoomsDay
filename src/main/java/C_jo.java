import java.io.IOException;

final class C_jo extends Thread {
   private final ClientConfig a;

   C_jo(ClientConfig var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      if (!this.a.j_bool()) {
         System.out.println("Not saved :(");
      }

      try {
         System.out.println("Jar writer save..");
         this.a.a_dw_5.a();
      } catch (Exception var1) {
         var1.printStackTrace();
      }

      System.exit(0);
   }
}
