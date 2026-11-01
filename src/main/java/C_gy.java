import javax.swing.SwingUtilities;

final class C_gy implements VersionUpdateListener {
   final VersionSelectPanel a;

   C_gy(VersionSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void a(ClientVersion var1, int var2) {
      if (VersionSelectPanel.a(this.a).get(var1.b_String) == null) {
         SwingUtilities.invokeLater(new C_gz(this, var1, var2));
      }
   }
}
