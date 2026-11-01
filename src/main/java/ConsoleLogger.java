final class ConsoleLogger extends InjectionCallback {
   @Override
   public final void b() {
   }

   @Override
   public final void a() {
   }

   @Override
   public final void a(long var1) {
      if (var1 == 55555L) {
         System.out.println("Minecraft restarted successfully!");
      } else if (var1 != 0L) {
         System.out.println(ErrorCodeUtil.a((int)var1));
      } else {
         System.out.println("DoomsDay loaded successfully!");
      }
   }

   @Override
   public final void a(String var1, Throwable var2) {
      if (var1 != null && var2 != null) {
         System.out.println(var1 + " " + var2.getMessage());
      } else if (var1 != null) {
         System.out.println(var1);
      } else {
         if (var2 != null) {
            System.out.println("Error: " + var2.getMessage());
         }
      }
   }
}
