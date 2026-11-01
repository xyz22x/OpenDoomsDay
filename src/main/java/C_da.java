import javax.swing.SwingUtilities;

final class C_da implements VersionUpdateListener {
   final ProcessSelectPanel a;

   C_da(ProcessSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1, int var2) {
      SwingUtilities.invokeLater(new C_db(this, var2));
   }
}
