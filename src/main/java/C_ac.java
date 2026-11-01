final class C_ac implements Runnable {
   private C_ab a_ab;
   private final int a_int_1;

   C_ac(C_ab var1, int var2) {
      this.a_ab = var1;
      this.a_int_1 = var2;
   }

   @Override
   public final void run() {
      int var1 = this.a_ab.a.c.getSelectedIndex();
      this.a_ab.a.c.removeItemAt(this.a_int_1 + 1);
      if (this.a_ab.a.c.getItemCount() == 1) {
         this.a_ab.a.c.removeItemAt(0);
      } else if (this.a_int_1 == 0) {
         this.a_ab.a.c.removeItemAt(0);
         ClientVersion var2 = (ClientVersion)this.a_ab.a.c.getItemAt(0);
         LocalClientVersion var3 = new LocalClientVersion(var2, "Latest (" + var2 + ")");
         this.a_ab.a.c.insertItemAt(var3, 0);
      }

      if (var1 == 0 && this.a_ab.a.c.getItemCount() > 0) {
         this.a_ab.a.c.setSelectedIndex(0);
      }
   }
}
