import javax.swing.SwingUtilities;

final class C_cy implements VersionUpdateListener {
   final ProcessSelectPanel a;

   C_cy(ProcessSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1, int var2) {
      SwingUtilities.invokeLater(new C_cz(this, var1, var2));
   }
}
