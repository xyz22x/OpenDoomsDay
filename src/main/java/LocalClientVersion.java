import javax.swing.Icon;

public final class LocalClientVersion implements VersionItem {
   public final ClientVersion a_gg;
   private String a_String_1;

   public LocalClientVersion(ClientVersion var1, String var2) {
      this.a_gg = var1;
      this.a_String_1 = var2;
   }

   @Override
   public final String toString() {
      return this.a_String_1;
   }

   @Override
   public final Icon a_Icon_2() {
      return this.a_gg.a_Icon_2();
   }
}
