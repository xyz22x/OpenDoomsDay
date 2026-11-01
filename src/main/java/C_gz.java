final class C_gz implements Runnable {
   private C_gy a_gy;
   private final ClientVersion a_gg_1;
   private final int a_int_2;

   C_gz(C_gy var1, ClientVersion var2, int var3) {
      this.a_gy = var1;
      this.a_gg_1 = var2;
      this.a_int_2 = var3;
   }

   @Override
   public final void run() {
      this.a_gy.a.a(this.a_gg_1, this.a_int_2);
      this.a_gy.a.a_JPanel_1.revalidate();
      this.a_gy.a.a_JPanel_1.repaint();
      this.a_gy.a.a_fd_3.repaint();
   }
}
