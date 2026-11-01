import javax.swing.SwingUtilities;

final class C_z implements VersionUpdateListener {
   final VersionTabPanel a;

   C_z(VersionTabPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1, int var2) {
      SwingUtilities.invokeLater(new C_aa(this, var1, var2));
   }
}
