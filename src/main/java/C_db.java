final class C_db implements Runnable {
   private C_da a_da;
   private final int a_int_1;

   C_db(C_da var1, int var2) {
      this.a_da = var1;
      this.a_int_1 = var2;
   }

   @Override
   public final void run() {
      int var1 = this.a_da.a.d_JComboBox.getSelectedIndex();
      this.a_da.a.d_JComboBox.removeItemAt(this.a_int_1 + 1);
      if (this.a_da.a.d_JComboBox.getItemCount() == 1) {
         this.a_da.a.d_JComboBox.removeItemAt(0);
      } else if (this.a_int_1 == 0) {
         this.a_da.a.d_JComboBox.removeItemAt(0);
         ClientVersion var2 = (ClientVersion)this.a_da.a.d_JComboBox.getItemAt(0);
         LocalClientVersion var3 = new LocalClientVersion(var2, "Latest (" + var2 + ")");
         this.a_da.a.d_JComboBox.insertItemAt(var3, 0);
      }

      if (var1 == 0 && this.a_da.a.d_JComboBox.getItemCount() > 0) {
         this.a_da.a.d_JComboBox.setSelectedIndex(0);
      }
   }
}
