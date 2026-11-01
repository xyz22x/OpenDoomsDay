final class C_jf extends Thread {
   private final String[] a;

   C_jf(String[] var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      AgentJarPacker.a();
      ProcessAttacher.a(Integer.parseInt(this.a[0]), this.a[1], null, null, null, System.out);
      System.exit(0);
   }
}
