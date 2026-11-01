final class C_aa implements Runnable {
   private C_z a_z;
   private final ClientVersion a_gg_1;
   private final int a_int_2;

   C_aa(C_z var1, ClientVersion var2, int var3) {
      this.a_z = var1;
      this.a_gg_1 = var2;
      this.a_int_2 = var3;
   }

   @Override
   public final void run() {
      int var1 = this.a_z.a.c.getSelectedIndex();
      if (this.a_z.a.c.getItemCount() == 0) {
         LocalClientVersion var2 = new LocalClientVersion(this.a_gg_1, "Latest (" + this.a_gg_1 + ")");
         this.a_z.a.c.insertItemAt(var2, 0);
      }

      if (this.a_int_2 == 0) {
         this.a_z.a.c.removeItemAt(0);
         LocalClientVersion var3 = new LocalClientVersion(this.a_gg_1, "Latest (" + this.a_gg_1 + ")");
         this.a_z.a.c.insertItemAt(var3, 0);
      }

      this.a_z.a.c.insertItemAt(this.a_gg_1, this.a_int_2 + 1);
      if (var1 <= 0) {
         this.a_z.a.c.setSelectedIndex(0);
      }
   }
}
