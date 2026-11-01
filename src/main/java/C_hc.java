import javax.swing.SwingUtilities;

final class C_hc implements VersionUpdateListener {
   final VersionSelectPanel a;

   C_hc(VersionSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1, int var2) {
      C_hg var3 = (C_hg)VersionSelectPanel.a(this.a).get(var1.b_String);
      SwingUtilities.invokeLater(new C_hd(this, var1, var3));
   }
}
