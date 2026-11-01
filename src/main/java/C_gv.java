import javax.swing.SwingUtilities;

final class C_gv implements DownloadProgressListener {
   final VersionSelectPanel a;

   C_gv(VersionSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1) {
      C_hg var2;
      if ((var2 = (C_hg)VersionSelectPanel.a(this.a).get(var1.b_String)) != null) {
         var1.a_dbl_2 = 0.0;
         C_gb var5 = this.a.a_gb_2;
         this.a.a_gb_2.a_List.add(var2);
         synchronized (var5.a_Object_1) {
            var5.a_Object_1.notify();
         }

         SwingUtilities.invokeLater(new C_gw(this, var2));
      }
   }

   @Override
   public final void a(ClientVersion var1, Exception var2) {
      C_hg var3;
      if ((var3 = (C_hg)VersionSelectPanel.a(this.a).get(var1.b_String)) != null) {
         SwingUtilities.invokeLater(new C_gx(this, var2, var3));
      }
   }
}
