import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

final class C_in extends Thread {
   private final int a;

   C_in(int var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         File var1;
         String var2 = (var1 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "close_terminal.txt")).getAbsolutePath();
         BufferedWriter var3;
         (var3 = new BufferedWriter(new FileWriter(var1))).append("tell application \"Terminal\"");
         var3.newLine();
         var3.append("    close (every window whose id is " + this.a + ")");
         var3.newLine();
         var3.append("end tell");
         var3.close();
         var1.setExecutable(true);
         new ProcessBuilder("osascript", var2).start().waitFor();
         var1.delete();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }
}
