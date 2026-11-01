final class C_bc extends Thread {
   private CustomDialogBase a;

   C_bc(CustomDialogBase var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         for (int var1 = 7; var1 >= 0; var1--) {
            Thread.sleep(1000L);
         }

         this.a.a().dispose();
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
