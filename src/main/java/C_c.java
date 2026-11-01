import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.SocketException;
import java.nio.charset.Charset;
import javax.swing.JButton;

public final class C_c implements ActionListener {
   JButton a_JButton;
   ClientConfig a_au_1;

   public C_c(JButton var1, ClientConfig var2) {
      this.a_JButton = var1;
      this.a_au_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_JButton.setEnabled(false);
      this.a_JButton.setIcon(C_bo.j);
      this.a_JButton.repaint();
      new C_d(this).start();
      new C_f(this).start();
   }

   private static int a_int(ClientConfig var0) {
      if (var0 != null) {
         for (int var1 = 0; var1 < 4; var1++) {
            try {
               ServerSocket var2 = new ServerSocket(0);
               new C_g(var2, var0).start();
               return var2.getLocalPort();
            } catch (SocketException var3) {
            } catch (Exception var4) {
               break;
            }
         }
      }

      return 0;
   }

   public static void a(ClientConfig var0) {
      try {
         String var1 = GamePathUtils.e();
         if (PlatformUtil.h()) {
            int var14 = a_int(var0);
            String var16 = System.getProperty("java.home") + File.separator + "bin" + File.separator + "javaw.exe";
            if (var14 != 0) {
               ProcessAttacher.a(
                  var16.toCharArray(), ("-jar \"" + GamePathUtils.a_File().getAbsolutePath() + "\" --msgport=" + var14 + " --postkillpid=" + DoomsdayGUI.b_int).toCharArray()
               );
               return;
            }

            ProcessAttacher.a(var16.toCharArray(), ("-jar \"" + GamePathUtils.a_File().getAbsolutePath() + "\" --postkillpid=" + DoomsdayGUI.b_int).toCharArray());
            return;
         }

         if (PlatformUtil.j() || PlatformUtil.k()) {
            String var15 = "pkexec";
            String var20 = System.getProperty("java.home") + File.separatorChar + "bin" + File.separatorChar + "java";
            String var23 = C_ap.a(UnixProcessInfo.d);
            int var26;
            ProcessBuilder var28;
            if ((var26 = a_int(var0)) != 0) {
               var28 = new ProcessBuilder(
                  var15,
                  "env",
                  "DISPLAY=" + System.getenv("DISPLAY"),
                  "XAUTHORITY=" + System.getenv("XAUTHORITY"),
                  var20,
                  "-jar",
                  var1,
                  "--postkillpid=" + DoomsdayGUI.b_int,
                  "--tmpdirpath=".concat(String.valueOf(var23)),
                  "--msgport=".concat(String.valueOf(var26))
               );
            } else {
               var28 = new ProcessBuilder(
                  var15,
                  "env",
                  "DISPLAY=" + System.getenv("DISPLAY"),
                  "XAUTHORITY=" + System.getenv("XAUTHORITY"),
                  var20,
                  "-jar",
                  var1,
                  "--postkillpid=" + DoomsdayGUI.b_int,
                  "--tmpdirpath=".concat(String.valueOf(var23))
               );
            }

            StringBuilder var29 = new StringBuilder();
            String[] var31 = var28.command().toArray(new String[0]);

            for (int var27 = 0; var27 < var31.length; var27++) {
               var29.append(var31[var27]);
               var29.append(" ");
            }

            System.out.println(var29);
            Runtime.getRuntime().exec(var31);
            return;
         }

         if (PlatformUtil.i()) {
            ServerSocket var2;
            (var2 = new ServerSocket(0)).setSoTimeout(7500);
            File var3;
            String var4 = (var3 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "run_sudo.txt")).getAbsolutePath();
            BufferedWriter var5;
            (var5 = new BufferedWriter(new FileWriter(var3))).append("tell application \"Terminal\"");
            var5.newLine();
            String var6 = C_ap.a(UnixProcessInfo.d);
            String var7 = GamePathUtils.a_String_2();
            File var8 = null;
            if (var1.indexOf(32) < 0 && var7.indexOf(32) < 0) {
               var5.append(
                  "\tset newTab to do script \"sudo bash -c \\\""
                     + var7
                     + " -jar "
                     + var1
                     + " --msgport="
                     + var2.getLocalPort()
                     + " --postkillpid="
                     + DoomsdayGUI.b_int
                     + " --tmpdirpath="
                     + var6
                     + " > /dev/null 2>&1 &\\\"\""
               );
            } else {
               var8 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "run_sudo_bash.sh");
               StringBuilder var9;
               (var9 = new StringBuilder()).append('"');
               var9.append(var7);
               var9.append('"');
               var9.append(" -jar \"");
               var9.append(var1);
               var9.append('"');
               var9.append(" --msgport=");
               var9.append(var2.getLocalPort());
               var9.append(" --postkillpid=");
               var9.append(DoomsdayGUI.b_int);
               var9.append(" --tmpdirpath=");
               var9.append(var6);
               var9.append(" > /dev/null 2>&1 &");
               FileOutputStream var24;
               (var24 = new FileOutputStream(var8)).write(var9.toString().getBytes(Charset.forName("UTF-8")));
               var24.close();
               var5.append("\tset newTab to do script \"sudo bash " + var8.getAbsolutePath() + "\"");
            }

            var5.newLine();
            var5.append("\tactivate");
            var5.newLine();
            var5.append("\tset theWindow to first window of (every window whose tabs contains newTab)");
            var5.newLine();
            var5.append("    \tset windowId to theWindow's id");
            var5.newLine();
            var5.append("    \trepeat with i from 1 to the count of theWindow's tabs");
            var5.newLine();
            var5.append("        if item i of theWindow's tabs is newTab then set tabNumber to i");
            var5.newLine();
            var5.append("    \tend repeat");
            var5.newLine();
            var5.append("    \tget {windowId, tabNumber}");
            var5.newLine();
            var5.append("end tell");
            var5.close();
            var3.setExecutable(true);
            Process var25;
            InputStream var17 = (var25 = new ProcessBuilder("osascript", var4).start()).getInputStream();
            StringBuilder var21 = new StringBuilder();
            int var10 = 0;

            char var30;
            while ((var30 = (char)var17.read()) >= 0) {
               var10++;
               var21.append(var30);
               if (var30 == '\uffff' || var10 > 100) {
                  break;
               }
            }

            var4 = var21.toString();
            int var22 = -1;

            try {
               var22 = Integer.parseInt(var4.substring(0, var4.indexOf(44)));
            } catch (Exception var11) {
               var11.printStackTrace();
            }

            C_h var13;
            (var13 = new C_h(var2, var22, var0, var8)).start();
            int var19 = var25.waitFor();
            System.out.println("WAIT CODE ".concat(String.valueOf(var19)));
            var3.delete();
            if (var19 != 0) {
               var2.close();
               var13.stop();
               DoomsdayGUI.a_a_3.b("Error open terminal. You have to run it yourself: sudo \"" + var7 + "\" -jar \"" + var1 + "\"", "Error");
               return;
            }
         }
      } catch (Throwable var12) {
         var12.printStackTrace();
      }
   }
}
