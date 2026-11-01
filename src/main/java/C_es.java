import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.Charset;
import javax.swing.SwingUtilities;

final class C_es extends Thread {
   private C_ep a;

   C_es(C_ep var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      try {
         C_ew var1 = C_eu.a_ew("ddkfi");
         File var2;
         (var2 = new File(System.getProperty("java.io.tmpdir") + "/genkey" + System.nanoTime() % 1048576L)).mkdirs();
         File var3 = new File(var2, "cleanup.sh");
         StringBuilder var4;
         (var4 = new StringBuilder()).append("TMPDIR=\"" + var2.getAbsolutePath() + "\"\n");
         var4.append("function cleanup {\n");
         var4.append("rm -f \"$TMPDIR\" > /dev/null 2>&1\n");
         var4.append("}\n");
         if (C_eu.a()) {
            String var5 = GamePathUtils.a_String_2();
            var4.append("sudo mv " + var5 + " " + var5 + ".back\n");
         }

         if (var1 != null) {
            var4.append("sudo security delete-certificate -Z " + var1.b + " /Library/Keychains/System.keychain\n");
         }

         var4.append("exit 0\n");
         StringBuilder var19;
         (var19 = new StringBuilder()).append("tell application \"Terminal\"\n");
         var19.append("\tset newTab to do script \"sudo " + var3 + "\"\n");
         var19.append("\tactivate\n");
         var19.append("\tset theWindow to first window of (every window whose tabs contains newTab)\n");
         var19.append("\tset windowId to theWindow's id\n");
         var19.append("\t\trepeat with i from 1 to the count of theWindow's tabs\n");
         var19.append("        if item i of theWindow's tabs is newTab then set tabNumber to i\n");
         var19.append("    \tend repeat\n");
         var19.append("    \tget {windowId, tabNumber}\n");
         var19.append("end tell\n");
         FileOutputStream var10;
         (var10 = new FileOutputStream(var3)).write(var4.toString().getBytes(Charset.forName("UTF-8")));
         var10.close();
         var3.setExecutable(true);
         File var16 = new File(var2, "open_terminal");
         FileOutputStream var11;
         (var11 = new FileOutputStream(var16)).write(var19.toString().getBytes(Charset.forName("UTF-8")));
         var11.close();
         var16.setExecutable(true);
         Process var12;
         InputStream var17 = (var12 = new ProcessBuilder("osascript", var16.getAbsolutePath()).start()).getInputStream();
         var19 = new StringBuilder();
         int var7 = 0;

         char var6;
         while ((var6 = (char)var17.read()) >= 0) {
            var7++;
            var19.append(var6);
            if (var6 == '\uffff' || var7 > 100) {
               break;
            }
         }

         String var18 = var19.toString();
         int var21 = -1;

         try {
            var21 = Integer.parseInt(var18.substring(0, var18.indexOf(44)));
         } catch (Exception var8) {
            var8.printStackTrace();
         }

         if (var12.waitFor() != 0) {
            DoomsdayGUI.a_a_3.b("Error open terminal. You have to run it yourself: sudo ".concat(String.valueOf(var3)), "Error");
         } else {
            while (var2.exists()) {
               Thread.sleep(500L);
            }

            String var13 = (var2 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "close_terminal.txt")).getAbsolutePath();
            BufferedWriter var15;
            (var15 = new BufferedWriter(new FileWriter(var2))).append("tell application \"Terminal\"");
            var15.newLine();
            var15.append("    close (every window whose id is " + var21 + ")");
            var15.newLine();
            var15.append("end tell");
            var15.close();
            var2.setExecutable(true);
            new ProcessBuilder("osascript", var13).start().waitFor();
            var2.delete();
            SwingUtilities.invokeLater(new C_et(this));
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }
   }

   static C_ep a(C_es var0) {
      return var0.a;
   }
}
