final class C_hf extends Thread {
   private C_he a_he;
   private final ClientVersion a_gg_1;

   C_hf(C_he var1, ClientVersion var2) {
      this.a_he = var1;
      this.a_gg_1 = var2;
   }

   @Override
   public final void run() {
      if (C_he.a(this.a_he).a_a.a_au_9.d()) {
         try {
            VersionManager.b(this.a_gg_1);
         } catch (Exception var2) {
            this.a_gg_1.a_dbl_2 = -1.0;
            var2.printStackTrace();
         }
      } else {
         try {
            VersionManager.a(this.a_gg_1);
            if (C_he.a(this.a_he).a_a.a_au_9.d()) {
               DoomsdayGUI.a_a_3.a_au_9.a_bytes(this.a_gg_1.a_String, this.a_gg_1.a_arr_byte_4);
               return;
            }
         } catch (Exception var3) {
            this.a_gg_1.a_dbl_2 = -1.0;
            var3.printStackTrace();
         }
      }
   }
}
