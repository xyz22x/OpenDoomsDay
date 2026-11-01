public enum C_fp {
   a_fp,
   b,
   c,
   d,
   e;

   private static final C_fp[] a_arr_fp_1 = new C_fp[]{a_fp, b, c, d, e};

   public static C_fp[] a() {
      C_fp[] var0;
      C_fp[] var1;
      int var2;
      System.arraycopy(var0 = a_arr_fp_1, 0, var1 = new C_fp[var2 = var0.length], 0, var2);
      return var1;
   }
}
