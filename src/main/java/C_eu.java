import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.nio.charset.Charset;
import java.util.ArrayList;

public final class C_eu {
   private static String a = "# Check if the certificate is already present in the system keychain\nsecurity find-certificate -Z -p -c \"$CERT\" /Library/Keychains/System.keychain > /dev/null 2>&1\nif [ $? -eq 0 ]; then\n    echo Certificate has already been generated and installed\n    exit 0\nfi\n\n# Create the certificate template\ncat <<EOF >$TMPDIR/$CERT.tmpl\n[ req ]\ndefault_bits       = 2048        # RSA key size\nencrypt_key        = no          # Protect private key\ndefault_md         = sha512      # MD to use\nprompt             = no          # Prompt for DN\ndistinguished_name = codesign_dn # DN template\n[ codesign_dn ]\ncommonName         = \"$CERT\"\n[ codesign_reqext ]\nkeyUsage           = critical,digitalSignature\nextendedKeyUsage   = critical,codeSigning\nEOF\n\necho Generating and installing \"$CERT\" certificate\n\n# Generate a new certificate\nopenssl req -new -newkey rsa:2048 -x509 -days 3650 -nodes -config \"$TMPDIR/$CERT.tmpl\" -extensions codesign_reqext -batch -out \"$TMPDIR/$CERT.cer\" -keyout \"$TMPDIR/$CERT.key\" > /dev/null 2>&1\n[ $? -eq 0 ] || error Something went wrong when generating the certificate\n\n# Install the certificate in the system keychain\nsudo security authorizationdb read com.apple.trust-settings.admin > \"$TMPDIR/rights\"\nsudo security authorizationdb write com.apple.trust-settings.admin allow\nsudo security add-trusted-cert -d -r trustRoot -p codeSign -k /Library/Keychains/System.keychain \"$TMPDIR/$CERT.cer\" > /dev/null 2>&1\nresult=$?\nsudo security authorizationdb write com.apple.trust-settings.admin < \"$TMPDIR/rights\"\n[ $result -eq 0 ] || error Something went wrong when installing the certificate\n\n# Install the key for the certificate in the system keychain\nsudo security import \"$TMPDIR/$CERT.key\" -A -k /Library/Keychains/System.keychain > /dev/null 2>&1\n[ $? -eq 0 ] || error Something went wrong when installing the key\n\n# Kill task_for_pid access control daemon\nsudo pkill -f /usr/libexec/taskgated > /dev/null 2>&1\n";
   private static String b = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n<plist version=\"1.0\">\n<dict>\n    <key>com.apple.security.cs.debugger</key>\n    <true/>\n</dict>\n</plist>\n</pre>";

   public static boolean a() {
      String var0 = a_String();
      File var1 = new File(var0);
      return new File(var1.getParentFile(), "java.backup").exists();
   }

   private static String a_String() {
      File var0 = new File(System.getProperty("java.home"), "bin");
      return new File(var0, "java").getAbsolutePath();
   }

   public static boolean a(ClientConfig var0) {
      try {
         String var1 = a_String();
      File var2;
      (var2 = new File(System.getProperty("java.io.tmpdir") + "/genkey" + System.nanoTime() % 1048576L)).mkdirs();
      File var3 = new File(var2, "genkey.sh");
      StringBuilder var4 = new StringBuilder();
      boolean var5 = a_ew("ddkfi") != null;
      var4.append("#!/bin/bash\n");
      var4.append("CERT=ddkfi\n");
      var4.append("TMPDIR=" + var2.getAbsolutePath() + '\n');
      var4.append(
         "function error() {\n    echo error: \"$@\" 1>&2\n    exit 1\n}\n\nfunction cleanup {\n    # Remove generated files\n    rm -rf \"$TMPDIR\" > /dev/null 2>&1\n}\n\ntrap cleanup EXIT\n\n"
      );
      if (!var5) {
         var4.append(a);
      }

      File var15 = new File(var2, "entitlement.xml");
      FileOutputStream var6;
      (var6 = new FileOutputStream(var15)).write(b.getBytes(Charset.forName("UTF-8")));
      var6.close();
      var4.append("sudo cp " + var1 + " " + var1 + ".back\n");
      var4.append("sudo /usr/bin/codesign --entitlements " + var15.getAbsolutePath() + " --force --sign \"ddkfi\" \"" + var1 + "\"\n");
      String var7 = C_ap.a(UnixProcessInfo.d);
      String var8 = GamePathUtils.e();
      ServerSocket var16 = new ServerSocket(0);
      var4.append('"');
      var4.append(var1);
      var4.append('"');
      var4.append(" -jar \"");
      var4.append(var8);
      var4.append('"');
      var4.append(" --msgport=");
      var4.append(var16.getLocalPort());
      var4.append(" --postkillpid=");
      var4.append(DoomsdayGUI.b_int);
      var4.append(" --tmpdirpath=");
      var4.append(var7);
      var4.append(" --patched");
      var4.append(" > /dev/null 2>&1 &\n");
      var4.append("exit 0\n");
      (var6 = new FileOutputStream(var3)).write(var4.toString().getBytes(Charset.forName("UTF-8")));
      var6.close();
      var3.setExecutable(true);
      StringBuilder var20;
      (var20 = new StringBuilder()).append("tell application \"Terminal\"\n");
      var20.append("\tset newTab to do script \"sudo " + var3 + "\"\n");
      var20.append("\tactivate\n");
      var20.append("\tset theWindow to first window of (every window whose tabs contains newTab)\n");
      var20.append("\tset windowId to theWindow's id\n");
      var20.append("\t\trepeat with i from 1 to the count of theWindow's tabs\n");
      var20.append("        if item i of theWindow's tabs is newTab then set tabNumber to i\n");
      var20.append("    \tend repeat\n");
      var20.append("    \tget {windowId, tabNumber}\n");
      var20.append("end tell\n");
      File var22 = new File(var2, "open_terminal");
      (var6 = new FileOutputStream(var22)).write(var20.toString().getBytes(Charset.forName("UTF-8")));
      var6.close();
      var22.setExecutable(true);
      Process var10;
      InputStream var11 = (var10 = new ProcessBuilder("osascript", var22.getAbsolutePath()).start()).getInputStream();
      var4 = new StringBuilder();
      int var21 = 0;
      char var19;
      while ((var19 = (char)var11.read()) >= 0) {
         var21++;
         var4.append(var19);
         if (var19 == '\uffff' || var21 > 100) {
            break;
         }
      }

      String var12 = var4.toString();
      int var14 = -1;

      try {
         var14 = Integer.parseInt(var12.substring(0, var12.indexOf(44)));
      } catch (Exception var9) {
         var9.printStackTrace();
      }

      new C_ev(var16, var14, var0).start();
      if (var10.waitFor() != 0) {
         DoomsdayGUI.a_a_3.b("Error open terminal. You have to run it yourself: sudo ".concat(String.valueOf(var3)), "Error");
      }

      return true;
      } catch (Exception var_e) {
         return false;
      }
   }

   private static Boolean a_Boolean_3(String var0) {
      try {
         Process var5;
         InputStream var1 = (var5 = Runtime.getRuntime().exec("codesign -dv --verbose=4 ".concat(String.valueOf(var0)))).getInputStream();
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();

         int var3;
         while ((var3 = var1.read()) != -1) {
            var2.write(var3);
         }

         var1 = var5.getErrorStream();

         while ((var3 = var1.read()) != -1) {
            var2.write(var3);
         }

         BufferedReader var6 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(var2.toByteArray())));
         StringBuilder var8 = new StringBuilder();
         String var9 = null;

         while ((var9 = var6.readLine()) != null) {
            var8.append(var9);
            if (var9.startsWith("Authority") || var9.startsWith("authority")) {
               return var9.split("=")[1].equalsIgnoreCase("ddkfi");
            }
         }

         return var8.length() == 0 ? null : Boolean.FALSE;
      } catch (Exception var4) {
         var4.printStackTrace();
         return Boolean.FALSE;
      }
   }

   private static String a_String_2(String var0) {
      try {
         Process var5;
         InputStream var1 = (var5 = new ProcessBuilder("/usr/bin/codesign", "-d", "--entitlements", "-", var0).start()).getInputStream();
         ByteArrayOutputStream var2 = new ByteArrayOutputStream();

         int var3;
         while ((var3 = var1.read()) != -1) {
            var2.write(var3);
         }

         var1 = var5.getErrorStream();

         while ((var3 = var1.read()) != -1) {
            var2.write(var3);
         }

         BufferedReader var6 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(var2.toByteArray())));
         StringBuilder var8 = new StringBuilder();
          String var9;
         while ((var9 = var6.readLine()) != null) {
            var8.append(var9);
            var8.append('\n');
         }

         return var8.indexOf(": code object is not signed at all") != -1 ? null : var8.toString();
      } catch (Exception var4) {
         var4.printStackTrace();
         return null;
      }
   }

   public static boolean a(String var0) {
      Boolean var1;
      return a_String_2(var0).indexOf("com.apple.security.cs.debugger") != -1 && ((var1 = a_Boolean_3(var0)) == null || var1);
   }

   public static C_ew a_ew(String var0) {
      try {
         Process var1 = new ProcessBuilder("security", "find-certificate", "-a", "-c", var0, "-Z", "/Library/Keychains/System.keychain").start();
         BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));
         ArrayList var4 = new ArrayList();
         C_ew var5 = new C_ew();

         String var3;
         while ((var3 = var2.readLine()) != null) {
            if (var3.startsWith("SHA-256")) {
               if (var5.c != null) {
                  var4.add(var5);
                  var5 = new C_ew();
               }

               var5.c = var3.substring(var3.indexOf(": ") + 2);
            }

            if (var3.startsWith("SHA-1")) {
               if (var5.b != null) {
                  var4.add(var5);
                  var5 = new C_ew();
               }

               var5.b = var3.substring(var3.indexOf(": ") + 2);
            }

            if (var3.trim().startsWith("\"alis\"")) {
               var5.a = var3.substring(var3.indexOf("=\"") + 2, var3.length() - 1);
            }
         }

         if (var5.a != null) {
            var4.add(var5);
         }

         for (int var7 = 0; var7 < var4.size(); var7++) {
            if (((C_ew)var4.get(var7)).a.equals(var0)) {
               return (C_ew)var4.get(var7);
            }
         }

         var1.waitFor();
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return null;
   }
}
