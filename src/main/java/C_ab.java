import javax.swing.SwingUtilities;

final class C_ab implements VersionUpdateListener {
   final VersionTabPanel a;

   C_ab(VersionTabPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1, int var2) {
      SwingUtilities.invokeLater(new C_ac(this, var2));
   }
}
