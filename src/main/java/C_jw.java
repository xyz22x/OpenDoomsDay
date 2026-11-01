import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;

final class C_jw extends Thread {
   @Override
   public final void run() {
      try {
         Thread.sleep(250L);
      } catch (InterruptedException var4) {
         var4.printStackTrace();
      }

      if (ProcessMemoryHooks.a_String_2 != null) {
         byte[] var10000 = ProcessMemoryHooks.a_String_2.getBytes(Charset.forName("UTF-8"));
         byte[] var1 = Arrays.copyOf(var10000, var10000.length + 1);
         if (PlatformUtil.h()) {
            char[] var5 = ProcessMemoryHooks.a_String_2.toCharArray();
            ProcessAttacher.a_int(ProcessAttacher.a(Arrays.copyOf(var5, var5.length + 1)));
         } else {
            long var2;
            ProcessAttacher.a_long_2(var2 = ProcessAttacher.a(var1));
            ProcessAttacher.a_long_2(var2);
         }

         new File(ProcessMemoryHooks.a_String_2).delete();
      }
   }
}
