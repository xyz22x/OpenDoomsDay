final class C_hd implements Runnable {
   private C_hc a_hc;
   private final ClientVersion a_gg_1;
   private final C_hg a_hg_2;

   C_hd(C_hc var1, ClientVersion var2, C_hg var3) {
      this.a_hc = var1;
      this.a_gg_1 = var2;
      this.a_hg_2 = var3;
   }

   @Override
   public final void run() {
      VersionSelectPanel.a(this.a_hc.a).remove(this.a_gg_1.b_String);
      this.a_hc.a.a_JPanel_1.remove(this.a_hg_2.b_JPanel_1);
      this.a_hc.a.a_JPanel_1.remove(this.a_hg_2.a_JPanel_1);
      this.a_hc.a.a_JPanel_1.revalidate();
      this.a_hc.a.a_JPanel_1.repaint();
   }
}
