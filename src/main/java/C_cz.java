final class C_cz implements Runnable {
   private C_cy a_cy;
   private final ClientVersion a_gg_1;
   private final int a_int_2;

   C_cz(C_cy var1, ClientVersion var2, int var3) {
      this.a_cy = var1;
      this.a_gg_1 = var2;
      this.a_int_2 = var3;
   }

   @Override
   public final void run() {
      int var1 = this.a_cy.a.d_JComboBox.getSelectedIndex();
      if (this.a_cy.a.d_JComboBox.getItemCount() == 0) {
         LocalClientVersion var2 = new LocalClientVersion(this.a_gg_1, "Latest (" + this.a_gg_1 + ")");
         this.a_cy.a.d_JComboBox.insertItemAt(var2, 0);
      }

      if (this.a_int_2 == 0) {
         this.a_cy.a.d_JComboBox.removeItemAt(0);
         LocalClientVersion var3 = new LocalClientVersion(this.a_gg_1, "Latest (" + this.a_gg_1 + ")");
         this.a_cy.a.d_JComboBox.insertItemAt(var3, 0);
      }

      this.a_cy.a.d_JComboBox.insertItemAt(this.a_gg_1, this.a_int_2 + 1);
      if (var1 <= 0) {
         this.a_cy.a.d_JComboBox.setSelectedIndex(0);
      }
   }
}
