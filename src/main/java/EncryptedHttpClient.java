public final class EncryptedHttpClient {
   CharSequence a_CharSequence;
   byte[] a_arr_byte_1;
   byte[] b_arr_byte;
   CharSequence b_CharSequence_1;
   int a_int_2;
   AppConfigImpl a_fh_3;
   HttpDownloadCallback a_bk_4;
   public byte[] c_arr_byte;
   public int b_int_2;
   Throwable a_Throwable_5;
   public int c_int_1;

   public static EncryptedHttpClient a(CharSequence var0, byte[] var1, byte[] var2, CharSequence var3, HttpDownloadCallback var4) {
      return a(var0, var1, var2, var3, new AppConfigImpl(), var4);
   }

   public static EncryptedHttpClient a(CharSequence var0, byte[] var1, byte[] var2, CharSequence var3) {
      return a(var0, var1, var2, var3, new AppConfigImpl(), null);
   }

   private static EncryptedHttpClient a(CharSequence var0, byte[] var1, byte[] var2, CharSequence var3, AppConfigImpl var4, HttpDownloadCallback var5) {
      EncryptedHttpClient var6 = null;
      EncryptedHttpClient var13 = null;

      try {
         (var6 = new EncryptedHttpClient()).a_CharSequence = var0;
         var6.b_CharSequence_1 = var3;
         var6.a_int_2 = 80;
         var6.a_fh_3 = var4;
         var6.a_bk_4 = var5;
         var6.a_arr_byte_1 = var1;
         var6.b_arr_byte = var2;
         C_bl var12 = new C_bl(var6);
         C_bm var14 = new C_bm();
         var12.a_long_1 = System.currentTimeMillis();
         var14.a_bl = var12;
         var12.start();
         var14.start();
         try {
            var12.join();
         } catch (InterruptedException var_ie) {
            throw new RuntimeException(var_ie);
         }
         var14.interrupt();
         if (var6.a_Throwable_5 != null) {
            throw new RuntimeException(var6.a_Throwable_5);
         }

         var13 = var6;
      } finally {
         try {
            var6.a_fh_3.a();
         } catch (Throwable var10) {
         }
      }

      return var13;
   }
}
