import javax.swing.SwingUtilities;

final class C_ha implements VersionUpdateListener {
   final VersionSelectPanel a;

   C_ha(VersionSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1, int var2) {
      SwingUtilities.invokeLater(new C_hb(this, var1));
   }
}
