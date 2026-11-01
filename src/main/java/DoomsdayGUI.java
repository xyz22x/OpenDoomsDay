import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Map.Entry;
import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalComboBoxButton;

public class DoomsdayGUI extends JFrame {
   public static int a_int = 435722;
   public static final String a_String_1 = "41a51b7d0f45f41dd288d5ec74b3489ed4bf2cb4".toLowerCase();
   public static boolean a_bool_2;
   public static DoomsdayGUI a_a_3;
   public static File customJarFile = null;
   private static String g_String = null;
   private static String h_String = null;
   private static String i;
   public static final int b_int = Integer.parseInt((i = ManagementFactory.getRuntimeMXBean().getName()).substring(0, i.indexOf(64)));
   public static final boolean b_bool_1 = b();
   public static String b_String_2 = "net.java.y";
   public static String c_String = "net.java.w";
   public static String d_String = "/net/java/b";
   public static String e_String = "/net/java/c";
   public static boolean c_bool_1;
   public static String f_String;
   public static CryptoUtil a_ee_4;
   public static ArrayList a_ArrayList_5 = new ArrayList();
   public static byte[] a_arr_byte_6;
   public static byte[] b_arr_byte_3;
   public static byte[] c_arr_byte_2;
   public static byte[] d_arr_byte_1;
   public static Class a_Class_7;
   private static Method a_Method_8;
   public static boolean d_bool_2;
   public static boolean e_bool_1;
   public static boolean f_bool_1;
   private static boolean h_bool_1;
   public static boolean g_bool_1;
   public static int c_int_3 = -1;
   public final ClientConfig a_au_9;
   public final SettingsTabPanel a_ex_10;
   public final ProcessTabPanel a_fr_11;
   public Font a_Font_12 = new Font("Arial", 1, 18);
   public int d_int_3;
   public ProcessListManager a_gd_13;
   public static Color a_Color_14 = new Color(29, 29, 31);
   public static Color b_Color_4 = new Color(99, 99, 101);
   public static Color c_Color_4 = new Color(79, 79, 81);
   public static Color d_Color_4 = new Color(0, 0, 0);
   static Color e_Color_2 = new Color(60, 60, 61);
   static Color f_Color_2 = new Color(80, 80, 81);
   public Color g_Color_2 = Color.white;
   public Color h_Color_2 = new Color(220, 220, 220);
   private JCheckBox a_JCheckBox_15;
   private UITheme a_fd_16 = new UITheme();

   private static boolean b() {
      synchronized (System.err) {
         if (!PlatformUtil.h() && !PlatformUtil.k()) {
            boolean var10000;
            try {
               Process var22 = Runtime.getRuntime().exec("id -u");
               var10000 = new BufferedReader(new InputStreamReader(var22.getInputStream())).readLine().equals("0");
            } catch (Throwable var17) {
               PrintStream var23 = System.err;
               System.setErr(new PrintStream(new C_bf()));
               Preferences var21 = Preferences.systemRoot();

               try {
                  var21.put("isRunWithRoot21", "isRunWithRoot21");
                  var21.remove("isRunWithRoot21");
                  var21.flush();
                  return true;
               } catch (Exception var15) {
               } finally {
                  System.setErr(var23);
               }

               return false;
            }

            return var10000;
         } else {
            PrintStream var1 = System.err;
            System.setErr(new PrintStream(new C_bf()));
            Preferences var2 = Preferences.systemRoot();

            try {
               var2.put("isRunWithRoot21", "isRunWithRoot21");
               var2.remove("isRunWithRoot21");
               var2.flush();
               return true;
            } catch (Exception var18) {
            } finally {
               System.setErr(var1);
            }

            return false;
         }
      }
   }

   public static void a(File var0) {
      if (!PlatformUtil.h()) {
         try {
            new ProcessBuilder("chmod", "a+rwx", var0.getAbsolutePath()).start().waitFor();
         } catch (Throwable var1) {
            var1.printStackTrace();
         }
      }
   }

   public static Object a(Object var0) {
      try {
         return a_Method_8.invoke(null, var0);
      } catch (Exception var1) {
         throw new RuntimeException(var1);
      }
   }

   public static native Object n(Object var0);

   public static void a(byte[] var0, String var1) {
      byte[] var3 = FileUtils.a(FileUtils.a(var1.getBytes(Charset.forName("UTF-8"))));

      for (int var2 = 0; var2 < var0.length; var2++) {
         var0[var2] ^= var3[var2 % var3.length];
      }
   }

   public static void main(String[] var0) throws Exception {
      boolean var1 = false;
      boolean var2 = false;
      if (var0 != null) {
         for (int var3 = 0; var3 < var0.length; var3++) {
            if (var0[var3].startsWith("--offsets")) {
               d_bool_2 = true;
               JvmUtil var10000 = JvmUtil.a_kf();
               DataOutputStream var5 = new DataOutputStream(System.out);
               JvmUtil var4 = var10000;
               var5.writeLong(var4.a_int);
               var5.writeLong(var4.a_long_1);
               var5.writeLong(var4.b);
               var5.writeLong(var4.c);
               var5.writeLong(var4.d);
               var5.writeLong(var4.e);
               var5.writeLong(var4.f);
               var5.writeLong(var4.g);
               var5.writeLong(var4.h);
               var5.writeLong(var4.i);
               var5.writeLong(var4.j);
               var5.writeLong(var4.k);
               var5.writeLong(var4.l);
               var5.writeLong(var4.m);
               var5.writeLong(var4.n);
               var5.writeLong(var4.o);
               var5.writeLong(var4.p);
               var5.writeLong(var4.q);
               var5.writeLong(var4.r);
               System.out.flush();
               System.exit(0);
            } else if (var0[var3].startsWith("--justwait")) {
               Thread.sleep(2000L);
               System.exit(0);
            } else if (var0[var3].startsWith("--attach")) {
               e_bool_1 = true;
            } else if (var0[var3].startsWith("--jar=")) {
               customJarFile = new File(var0[var3].substring(6).trim());
            } else if (var0[var3].toLowerCase().endsWith(".jar") && new File(var0[var3]).exists()) {
               customJarFile = new File(var0[var3]);
            } else if (var0[var3].equalsIgnoreCase("--nostd")) {
               var1 = true;
            } else if (var0[var3].equalsIgnoreCase("--std")) {
               var2 = true;
            }
         }
      }

      String var29 = System.getProperty("os.name").toLowerCase();
      String var35;
      if (((var35 = System.getProperty("os.version").toLowerCase()) == null || !var35.contains("android")) && !var29.contains("win") && var29.contains("linux")
         )
       {
         try {
            if (System.console() == null && !var2) {
               System.setErr(new PrintStream(new C_bf()));
               System.setOut(new PrintStream(new C_bf()));
            }
         } catch (Throwable var21) {
         }
      }

      if (var1) {
         System.setErr(new PrintStream(new C_bf()));
         System.setOut(new PrintStream(new C_bf()));
      }

      if (PlatformUtil.k()) {
         System.out.println("Hello Android user :)");
      } else if (PlatformUtil.c()) {
         System.out.println("Hello ARM user, you are cool :)");
      } else if (PlatformUtil.g()) {
         System.out.println("Hello RISC-V user, you are amazing!");
      } else {
         System.out.println("Hello :)");
      }

      if (var0 == null || var0.length < 6) {
         String[] newVar0 = new String[6 + (var0 == null ? 0 : var0.length)];
         newVar0[0] = "/net/java/a";
         newVar0[1] = "/net/java/b";
         newVar0[2] = "/net/java/c";
         newVar0[3] = "/net/java/d";
         newVar0[4] = "/net/java/e";
         newVar0[5] = "/64FV7P4H2NO7Q";
         if (var0 != null && var0.length > 0) {
            System.arraycopy(var0, 0, newVar0, 6, var0.length);
         }
         var0 = newVar0;
      }

      if (b_arr_byte_3 == null) {
         a(b_arr_byte_3 = AgentJarPacker.a(var0[1], "\\b"), var0[1]);
      }

      if (a_arr_byte_6 == null) {
         a(a_arr_byte_6 = AgentJarPacker.a(var0[2], "\\c"), var0[2]);
      }

      if (c_arr_byte_2 == null) {
         a(c_arr_byte_2 = AgentJarPacker.a(var0[3], "\\d"), var0[3]);
      }

      try {
         if (d_arr_byte_1 == null && (d_arr_byte_1 = AgentJarPacker.a(var0[4], "\\d")) != null) {
            a(d_arr_byte_1, var0[4]);
         }
      } catch (Throwable var20) {
      }

      if (f_String == null && var0.length > 5) {
         f_String = var0[5];
      }

      if (a_Class_7 == null) {
         a_Class_7 = DoomsdayGUI.class;
      }

      if (a_Method_8 == null) {
         try {
            a_Method_8 = a_Class_7.getDeclaredMethod("n", Object.class);
         } catch (Exception var19) {
            var19.printStackTrace();
         }
      }

      try {
         PlatformUtil.i();
      } catch (Exception var18) {
      }

      var1 = false;
      byte[] var25 = null;
      var29 = null;
      var35 = null;
      if (var0.length > 0) {
         for (int var37 = 0; var37 < var0.length; var37++) {
            if (var0[var37].equalsIgnoreCase("--autoinject")) {
               h_bool_1 = true;
            } else if (var0[var37].equalsIgnoreCase("--allowrestart")) {
               f_bool_1 = true;
            } else if (var0[var37].equalsIgnoreCase("--printbase")) {
               g_bool_1 = true;
            } else if (var0[var37].startsWith("--ishellcode=")) {
               h_String = var0[var37];
            } else if (var0[var37].startsWith("--jvmti=")) {
               g_String = var0[var37];
            } else if (var0[var37].startsWith("--jattach=")) {
               var29 = var0[var37];
            } else if (var0[var37].startsWith("--jattachnatives=")) {
               var35 = var0[var37].substring(17);
            } else if (var0[var37].equalsIgnoreCase("--printprops")) {
               Iterator var61 = System.getProperties().entrySet().iterator();

               while (var61.hasNext()) {
                  Entry var53;
                  Object var65 = (var53 = (Entry)var61.next()).getKey();
                  Object var54 = var53.getValue();
                  System.out.println(var65 + " >>> " + var54);
               }
            } else if (var0[var37].equalsIgnoreCase("--patched")) {
               a_bool_2 = true;
            } else if (var0[var37].equalsIgnoreCase("--printenv")) {
               Iterator var60 = System.getenv().entrySet().iterator();

               while (var60.hasNext()) {
                  Entry var51;
                  String var64 = (String)(var51 = (Entry)var60.next()).getKey();
                  String var52 = (String)var51.getValue();
                  System.out.println(var64 + " >>> " + var52);
               }
            } else if (var0[var37].equalsIgnoreCase("--printarch")) {
               System.out.println("OS: " + AgentJarPacker.a_String());
               System.out.println("Version: " + AgentJarPacker.b());
               System.out.println("Arch: " + AgentJarPacker.c());
            } else if (var0[var37].equalsIgnoreCase("--forcenative")) {
               var1 = true;
            } else if (var0[var37].startsWith("--killpid=")) {
               String var6 = var0[var37].substring(10);

               try {
                  int var7 = Integer.parseInt(var6);
                  ProcessBuilder var8;
                  if (PlatformUtil.h()) {
                     var8 = new ProcessBuilder("taskkill", "/PID", Integer.toString(var7), "/F");
                  } else {
                     var8 = new ProcessBuilder("kill", Integer.toString(var7));
                  }

                  var8.start();
               } catch (Throwable var17) {
                  JOptionPane.showMessageDialog(null, var17.getMessage() + " " + var17);
               }
            } else if (var0[var37].startsWith("--postkillpid=")) {
               String var39 = var0[var37].substring(14);

               try {
                  int var46 = Integer.parseInt(var39);
                  a_ArrayList_5.add(var46);
               } catch (Throwable var16) {
               }
            } else if (var0[var37].startsWith("--tmpdirpath=")) {
               String var40 = var0[var37].substring(13);
               String var47 = new String(NativeBinaryManager.a_arr_byte(var40), Charset.forName("UTF-8"));
               if (!UnixProcessInfo.b.contains(var47)) {
                  UnixProcessInfo.b.add(var47);
                  UnixProcessInfo.a_ArrayList.add(new File(var47));
               }
            } else if (var0[var37].startsWith("--deletefile=")) {
               String var41 = var0[var37].substring(13);

               try {
                  FileUtils.a_void(new File(var41));
               } catch (Exception var15) {
               }
            } else if (var0[var37].startsWith("--plns")) {
               c_bool_1 = true;
            } else if (var0[var37].startsWith("--msgport=")) {
               String var42 = var0[var37].substring(10);

               try {
                  int var48 = Integer.parseInt(var42);
                  Socket var59 = new Socket("localhost", var48);
                  DataInputStream var9 = new DataInputStream(var59.getInputStream());
                  if (PlatformUtil.i()) {
                     var48 = var9.readInt();
                     File var10;
                     String var11 = (var10 = new File(System.getProperty("java.io.tmpdir"), System.nanoTime() + "close_terminal.txt")).getAbsolutePath();
                     BufferedWriter var12;
                     (var12 = new BufferedWriter(new FileWriter(var10))).append("tell application \"Terminal\"");
                     var12.newLine();
                     var12.append("    close (every window whose id is " + var48 + ")");
                     var12.newLine();
                     var12.append("end tell");
                     var12.close();
                     var10.setExecutable(true);
                     new ProcessBuilder("osascript", var11).start().waitFor();
                     var10.delete();
                  }

                  if ((var48 = var9.readInt()) != 0) {
                     var25 = new byte[var48];
                     var9.readFully(var25);
                  }

                  String var68;
                  if ((var68 = var9.readUTF()).length() > 0) {
                     new C_iz(var68).start();
                  }

                  var59.close();
               } catch (Throwable var14) {
                  JOptionPane.showMessageDialog(null, var14.getMessage() + " " + var14);
               }
            } else {
               var0[var37].startsWith("--dontsaveconfig");
            }
         }
      }

      if (!PlatformUtil.h() && b_bool_1) {
         (a_ee_4 = new CryptoUtil()).start();
      }

      if (var0 != null && var0.length == 2) {
         new C_jf(var0).start();
      }

      ClientConfig var38 = new ClientConfig(var25);
      if (g_String != null) {
         ExternalProcessInjector.b(g_String);
      } else if (h_String != null) {
         ExternalProcessInjector.a(h_String);
      } else {
         if (var29 != null) {
            label292: {
               if (var35 != null) {
                  try {
                     System.load(var35);
                     break label292;
                  } catch (Throwable var22) {
                     JOptionPane.showMessageDialog(null, var22.getMessage() + " " + var22);
                  }
               }

               AgentJarPacker.a();
            }

            String var43 = var29.substring(10);

            try {
               int var55 = Integer.parseInt(var43);
               Socket var62 = new Socket("localhost", var55);
               DataInputStream var66 = new DataInputStream(var62.getInputStream());
               DataOutputStream var56 = new DataOutputStream(var62.getOutputStream());
               int var69 = var66.readInt();
               String var71 = var66.readUTF();
               String var73 = var66.readUTF();
               String var26 = var66.readUTF();
               var29 = var66.readUTF();
               if (var73.length() == 0) {
                  var73 = null;
               }

               if (var26.length() == 0) {
                  var26 = null;
               }

               if (var29.length() == 0) {
                  var29 = null;
               }

               InjectionResult var23 = new InjectionResult();
               int status = ProcessAttacher.a(var69, var71, var73, var26, var29, var23);
               var56.writeInt(status);
               var56.writeUTF(var23.a.toString());
               var56.flush();
               var62.close();
            } catch (Throwable var13) {
               JOptionPane.showMessageDialog(null, var13.getMessage() + " " + var13);
            }

            System.exit(0);
         }

         if (var1) {
            AgentJarPacker.a();
         }

         if (var38.c() && !b_bool_1) {
            C_c.a(null);
            if (a_ArrayList_5.size() > 0) {
               new C_fn().start();
               return;
            }
         } else {
            if (!h_bool_1) {
               DoomsdayGUI var45;
               (var45 = new DoomsdayGUI(var38)).addComponentListener(new C_bh(var45));
               boolean var58 = var38.a_int_2() == -1;
               a(var38.a_int_2(), var45);
               if (var58) {
                  var38.a_str("monitor_index", "-1");
               }

               c_int_3 = var45.b_int();
               var45.d_int_3 = var38.a_int_2();
               var45.setVisible(true);
               var45.addWindowStateListener(new C_jl(var45, var38));
               return;
            }

            ProcessListManager var44;
            (var44 = new ProcessListManager()).start();
            var44.b();
            if (var44.a_List_1.size() == 0) {
               System.out.println("Minecraft processes not found");
               System.exit(0);
            }

            AgentJarPacker.a();
            Iterator var63 = var44.a_List_1.iterator();

            while (var63.hasNext()) {
               int var67 = ((TargetProcess)var63.next()).a_int;
               String var57;
               ProcessInfo var70;
               if ((var70 = var44.a_fo(var67)) != null) {
                  var57 = var70.b_String_1;
               } else {
                  var57 = null;
               }

               String var72 = var38.a_String_3();
               ConsoleLogger var74 = new ConsoleLogger();
               byte[] var28;
               if ((var28 = AgentJarPacker.a(var38, var74)) == null) {
                  return;
               }

               var29 = var38.j();
               if (var72.equals("jvmti_agent")) {
                  JvmtiInjector.a(var67, var57, var28, var29, null, var74);
               } else if (var72.equals("shellcode")) {
                  JvmtiInjector.a(var67, var28, var29, var74);
               } else if (var72.equals("restart")) {
                  var29 = var29 + " --doomsdayversion=" + FileUtils.a(var38.g_String());
                  JvmtiInjector.a(var67, var29, var74);
               } else if (var72.equals("restart 2")) {
                  var29 = var29 + " --doomsdayversion=" + FileUtils.a(var38.g_String());
                  JvmtiInjector.b(var67, var29, var74);
               } else {
                  System.out.println("Unknown injection ".concat(String.valueOf(var72)));
               }
            }

            System.out.println("Exit");
            System.exit(0);
         }
      }
   }

   public static void a(int var0, Window var1) {
      if (var0 == -1) {
         var1.setVisible(true);
      } else {
         GraphicsDevice[] var2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
         if (var0 >= 0 && var0 < var2.length) {
            int var3 = var2[var0].getDefaultConfiguration().getBounds().width;
            int var4 = var2[var0].getDefaultConfiguration().getBounds().height;
            var1.setLocation(
               var3 / 2 - var1.getSize().width / 2 + var2[var0].getDefaultConfiguration().getBounds().x,
               var4 / 2 - var1.getSize().height / 2 + var2[var0].getDefaultConfiguration().getBounds().y
            );
            var1.setVisible(true);
         }
      }
   }

   private DoomsdayGUI(ClientConfig var1) {
      this.a_au_9 = var1;
      a_a_3 = this;
      ArrayList var2;
      (var2 = new ArrayList()).add(C_bo.k().getImage());
      var2.add(C_bo.j().getImage());
      var2.add(C_bo.i().getImage());
      var2.add(C_bo.h().getImage());
      var2.add(C_bo.g().getImage());
      this.setIconImages(var2);

      try {
         if (!PlatformUtil.h()) {
            Class var9;
            Object var3 = (var9 = this.getClass().getClassLoader().loadClass("java.awt.Taskbar")).getMethod("getTaskbar").invoke(null);
            var9.getMethod("setIconImage", Image.class).invoke(var3, C_bo.g().getImage());
         }
      } catch (ClassNotFoundException var4) {
      } catch (NoClassDefFoundError var5) {
      } catch (NoSuchMethodError var6) {
      } catch (UnsupportedOperationException var7) {
      } catch (Throwable var8) {
         if (var8.getCause() == null || !(var8.getCause() instanceof UnsupportedOperationException)) {
            var8.printStackTrace();
         }
      }

      try {
         Image var_icon = javax.imageio.ImageIO.read(new java.net.URL("https://r2.fakecrime.bio/uploads/2d667995-bb93-4351-85f8-4e148eb6b44d.png"));
         if (var_icon != null) {
            this.setIconImage(var_icon);
         }
      } catch (Throwable var_icon_err) {
      }

      this.setBackground(Color.BLACK);
      this.setDefaultCloseOperation(1);
      if (var1.a_bool_4()) {
         this.setExtendedState(6);
      } else {
         this.setExtendedState(0);
      }

      this.a_JCheckBox_15 = a_JCheckBox();
      this.a_JCheckBox_15.setFocusable(false);
      this.addWindowListener(new C_jn(var1));
      this.setTitle("Cracked by reversed");
      UIManager.put("ToolTip.background", new ColorUIResource(240, 240, 240));
      UIManager.put("ToolTip.font", new FontUIResource(new Font(this.a_Font_12.getName(), 0, this.a_Font_12.getSize())));
      if (!PlatformUtil.k()) {
         Random var11 = new Random();
         int var10 = 880 + var11.nextInt(7) + 1;
         int var12 = 695 + var11.nextInt(7) + 1;
         this.setSize(var10, var12);
      } else {
         this.setSize(710, 530);
      }

      this.setMinimumSize(new Dimension(400, 300));
      this.setLocationRelativeTo(null);
      this.a_ex_10 = new SettingsTabPanel(this);
      this.a_fr_11 = new ProcessTabPanel(this);
      this.setContentPane(this.a_ex_10);
      this.a_gd_13 = new ProcessListManager(this.a_ex_10.a_u_2);
   }

   public final JComboBox a_JComboBox(Object... var1) {
      JComboBox var5 = new JComboBox<>(var1);
      C_ea var2 = new C_ea();
      var5.setUI(var2);
      var5.addActionListener(new C_jp(var5));
      var5.setRenderer(new C_jq());
      var5.setForeground(Color.WHITE);
      var5.setFont(new Font(this.a_Font_12.getName(), 1, this.a_Font_12.getSize()));
      var5.setBackground(e_Color_2);
      var5.setBorder(new C_fq(2, Color.gray));
      MetalComboBoxButton var3 = (MetalComboBoxButton)var2.a_JButton();
      Border var4 = BorderFactory.createEmptyBorder(0, 4, 0, 3);
      var3.setBorder(new CompoundBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.white), var4));
      var3.setContentAreaFilled(false);
      var5.setFocusable(false);
      C_jr var7 = new C_jr(var5, var2);
      var5.addMouseListener(var7);
      var3.setComboIcon(new C_as(false));
      JComponent var6 = (JComponent)var2.a_ComboPopup_2();
      var2.a_JList_3().setBackground(Color.DARK_GRAY);
      var2.a_JList_3().addMouseListener(var7);
      var2.a_JList_3().addListSelectionListener(new C_js(var2));
      var2.a_JList_3().addMouseMotionListener(new C_ja(var2));
      var2.a_JList_3().setCellRenderer(new C_jb(var2, var5));
      var6.setBorder(BorderFactory.createEmptyBorder());
      return var5;
   }

   private int b_int() {
      int var1 = 0;

      try {
         GraphicsDevice[] var2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

         for (int var3 = 0; var3 < var2.length; var3++) {
            if (var2[var3] == GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()) {
               return var3;
            }
         }
      } catch (Exception var4) {
         if (this.a_au_9 != null) {
            var1 = this.a_au_9.a_int_2();
         }
      }

      return var1;
   }

   public final int a_int_2() {
      int var1 = 0;

      try {
         GraphicsDevice[] var2 = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
         int var3 = Integer.MIN_VALUE;

         for (int var4 = 0; var4 < var2.length; var4++) {
            GraphicsDevice var5 = var2[var4];
            Point var6;
            int var7 = (var6 = this.getLocationOnScreen()).x;
            int var11 = var6.y;
            Rectangle var8 = new Rectangle();
            Rectangle.intersect(var5.getDefaultConfiguration().getBounds(), new Rectangle(var7, var11, this.getWidth(), this.getHeight()), var8);
            int var10;
            if ((var10 = var8.width * var8.height) > var3 && var10 > 0) {
               var3 = var10;
               var1 = var4;
            }
         }
      } catch (Exception var9) {
         if (this.a_au_9 != null) {
            var1 = this.a_au_9.a_int_2();
         }
      }

      return var1;
   }

   public static JCheckBox a_JCheckBox() {
      JCheckBox var0;
      (var0 = new JCheckBox()).setBackground(d_Color_4);
      var0.setIcon(C_bo.o());
      var0.setSelectedIcon(C_bo.n());
      var0.setBorder(null);
      return var0;
   }

   public final JTextField a() {
      JTextField var1;
      (var1 = new JTextField()).setFont(new Font(this.a_Font_12.getName(), 0, this.a_Font_12.getSize()));
      var1.setCaretColor(Color.white);
      var1.setBorder(new C_fq(2, Color.gray));
      var1.setBackground(a_Color_14);
      var1.setForeground(Color.white);
      if (PlatformUtil.i()) {
         var1.addMouseListener(new C_jc());
      }

      return var1;
   }

   public final void a(JTextField var1) {
      var1.setFont(new Font(this.a_Font_12.getName(), 0, this.a_Font_12.getSize()));
      var1.setCaretColor(Color.white);
      var1.setBorder(new C_fq(2, Color.gray));
      var1.setBackground(a_Color_14);
      var1.setForeground(Color.white);
   }

   public final JLabel a_JLabel(String var1) {
      JLabel var2;
      (var2 = new JLabel(var1)).setFont(this.a_Font_12);
      var2.setForeground(this.g_Color_2);
      return var2;
   }

   private JTextArea a(String var1) {
      JTextArea var2;
      (var2 = new JTextArea(var1)).setLineWrap(true);
      var2.setWrapStyleWord(true);
      var2.setFont(new Font(this.a_Font_12.getName(), 0, (int)this.a_Font_12.getSize()));
      var2.setForeground(Color.white);
      var2.setEditable(false);
      var2.setBorder(null);
      var2.setBackground(d_Color_4);
      return var2;
   }

   public static JPanel a(LayoutManager var0) {
      JPanel var1;
      (var1 = new JPanel(var0)).setBackground(d_Color_4);
      return var1;
   }

   public static JPanel a_JPanel_3() {
      JPanel var0;
      (var0 = new JPanel()).setLayout(new BoxLayout(var0, 1));
      var0.setBackground(d_Color_4);
      return var0;
   }

   public final void a(String var1, String var2) {
      this.a(var1, var2, 0, false);
   }

   public final void b(String var1, String var2) {
      this.a(var1, var2, 1, false);
   }

   public static boolean a_bool_5() {
      if (a_a_3.a_ex_10.a_cr_1.a_dy_1.getText().startsWith("Wait")) {
         return false;
      } else {
         return a_a_3.a_gd_13.a_List_1.size() > 0 ? true : a_a_3.a_fr_11 != null && a_a_3.a_fr_11.a_eg_2 != null && a_a_3.a_fr_11.a_eg_2.e.isSelected();
      }
   }

   public final void a(String var1, String var2, ActionListener var3, ActionListener var4) {
      ImageIcon var9 = C_bo.d();
      Object var8 = null;
      Object var7 = null;
      JDialog var10;
      (var10 = new JDialog()).setTitle(var2);
      var10.setModal(true);
      var10.setLocationRelativeTo(this);
      JLabel var11;
      (var11 = new JLabel()).setIcon(var9);
      JPanel var14;
      (var14 = new JPanel(new BorderLayout())).setBorder(new EmptyBorder(8, 8, 8, 8));
      var14.setBackground(new Color(29, 29, 31));
      JPanel var16;
      (var16 = new JPanel(new FlowLayout())).setBackground(new Color(29, 29, 31));
      var16.add(var11);
      var14.add(var16, "West");
      JPanel var12 = new JPanel();
      C_dy var17 = new C_dy();
      if (var7 == null) {
         var17.setText("Yes");
         var17.setPreferredSize(new Dimension(70, 30));
      } else {
         var17.setText((String)var7);
         if (((String)var7).length() > 10) {
            var17.setPreferredSize(new Dimension(180, 35));
            var17.setSize(180, 35);
         }
      }

      var17.setFont(this.a_Font_12);
      var17.a_Color = new Color(0, 100, 255);
      var17.b_Color = new Color(0, 100, 255);
      var17.setBorder(BorderFactory.createEmptyBorder());
      var17.d_Color = new Color(66, 91, 129);
      var17.e_Color = new Color(66, 91, 129);
      var17.f = new Color(71, 145, 255);
      var17.g = new Color(71, 145, 255);
      var17.h = Color.WHITE;
      var17.j = new Color(91, 165, 255);
      var17.setFont(new Font(this.a_Font_12.getName(), 0, this.a_Font_12.getSize()));
      var17.a_int_2 = 16;
      var17.addActionListener(new C_jd(var10, var3));
      var12.add(var17);
      C_dy var15 = new C_dy();
      if (var8 == null) {
         var15.setText("No");
      } else {
         var15.setText((String)var8);
      }

      var15.setFont(new Font(this.a_Font_12.getName(), 0, this.a_Font_12.getSize()));
      var15.a_Color = d_Color_4;
      var15.b_Color = d_Color_4;
      var15.setPreferredSize(new Dimension(70, 30));
      var15.setBorder(BorderFactory.createEmptyBorder());
      var15.d_Color = a_Color_14;
      var15.e_Color = a_Color_14;
      var15.f = c_Color_4;
      var15.g = c_Color_4;
      var15.h = Color.WHITE;
      var15.j = b_Color_4;
      var15.addActionListener(new C_je(var10, var4));
      var12.add(var15);
      var12.setBackground(new Color(29, 29, 31));
      var12.setBorder(new EmptyBorder(5, 0, 0, 0));
      var14.add(var12, "South");
      JTextArea var13;
      (var13 = this.a(var1)).setBackground(new Color(29, 29, 31));
      if (var1.length() < 100) {
         var14.add(var13);
      } else if (PlatformUtil.l()) {
         this.a_fd_16.a(var13);
         var14.add(this.a_fd_16);
      } else {
         var14.add(new UITheme(var13));
      }

      var10.setContentPane(var14);
      var10.setDefaultCloseOperation(2);
      if (var1.length() < 60) {
         var10.setMinimumSize(new Dimension(320, 160));
      } else if (var1.length() < 100) {
         var10.setMinimumSize(new Dimension(360, 180));
      } else if (var1.length() < 150) {
         var10.setMinimumSize(new Dimension(400, 200));
      } else {
         var10.setMinimumSize(new Dimension(430, 215));
      }

      var10.setResizable(true);
      var10.setLocationRelativeTo(null);
      var10.pack();
      a(this.a_int_2(), var10);
   }

   public final CustomDialogBase a(String var1, String var2, int var3, boolean var4) {
      JDialog var5 = new JDialog((Frame)a_a_3);
      if (0L > 0L) {
         new C_jg(var5).start();
      }

      var5.setTitle(var2);
      var5.setModal(true);
      JLabel var8 = new JLabel();
      if (var3 == 0) {
         var8.setIcon(C_bo.a());
      } else if (var3 == 1) {
         var8.setIcon(C_bo.c());
      } else if (var3 == 2) {
         var8.setIcon(C_bo.b());
      } else if (var3 == 3) {
         var8.setIcon(C_bo.d());
      } else if (var3 == 4) {
         var8.setIcon(C_bo.f());
      } else if (var3 == 5) {
         var8.setIcon(null);
      }

      JPanel var9;
      (var9 = new JPanel(new BorderLayout())).setBorder(new EmptyBorder(8, 8, 8, 8));
      var9.setBackground(new Color(29, 29, 31));
      JPanel var6;
      (var6 = new JPanel(new FlowLayout())).setBackground(new Color(29, 29, 31));
      var6.add(var8);
      var9.add(var6, "West");
      var6 = new JPanel();
      C_dy var7;
      (var7 = new C_dy()).setText("OK");
      var7.setFont(this.a_Font_12);
      var7.a_Color = new Color(0, 100, 255);
      var7.b_Color = new Color(0, 100, 255);
      var7.setBorder(BorderFactory.createEmptyBorder());
      var7.d_Color = new Color(66, 91, 129);
      var7.e_Color = new Color(66, 91, 129);
      var7.f = new Color(71, 145, 255);
      var7.g = new Color(71, 145, 255);
      var7.h = Color.WHITE;
      var7.j = new Color(91, 165, 255);
      var7.setFont(new Font(this.a_Font_12.getName(), 0, this.a_Font_12.getSize()));
      var7.a_int_2 = 16;
      var7.setPreferredSize(new Dimension(70, 30));
      var7.addActionListener(new C_ji(var5));
      var6.add(var7);
      var6.setBackground(new Color(29, 29, 31));
      var6.setBorder(new EmptyBorder(5, 0, 0, 0));
      var9.add(var6, "South");
      JTextArea var11;
      (var11 = this.a(var1)).setBackground(new Color(29, 29, 31));
      if (PlatformUtil.l()) {
         this.a_fd_16.a(var11);
         var9.add(this.a_fd_16);
      } else {
         var9.add(new UITheme(var11));
      }

      var5.setContentPane(var9);
      var5.setDefaultCloseOperation(2);
      if (var1.length() < 60) {
         var5.setMinimumSize(new Dimension(340, 170));
      } else if (var1.length() < 100) {
         var5.setMinimumSize(new Dimension(370, 185));
      } else if (var1.length() < 150) {
         var5.setMinimumSize(new Dimension(400, 200));
      } else {
         var5.setMinimumSize(new Dimension(430, 215));
      }

      var5.setResizable(true);
      var5.setLocationRelativeTo(null);
      var5.pack();
      if (var4) {
         SwingUtilities.invokeLater(new C_jj(this, var5));
      } else {
         a(this.a_int_2(), var5);
      }

      return new AboutDialog(var5, var8, var11, var7);
   }

   public final ConsoleLogPanel a_aq_4() {
      JTextField var1 = this.a();
      C_dy var3;
      (var3 = new C_dy()).setText("...");
      var3.setFont(this.a_Font_12);
      var3.setPreferredSize(new Dimension(35, 35));
      var3.a_Color = new Color(0, 100, 215);
      var3.b_Color = new Color(0, 100, 215);
      var3.setBorder(BorderFactory.createEmptyBorder());
      var3.b_Color = a_Color_14;
      var3.a_Color = a_Color_14;
      var3.setBorder(new C_fq(2, Color.gray));
      var3.f = new Color(90, 90, 90);
      var3.g = new Color(100, 100, 100);
      var3.h = Color.WHITE;
      var3.j = new Color(130, 130, 130);
      var3.c_Color = a_Color_14;
      var3.d_Color = a_Color_14;
      var3.e_Color = a_Color_14;
      var3.i = Color.gray;
      var3.addActionListener(new C_bg(var1));
      ConsoleLogPanel var4;
      a((JPanel)(var4 = new ConsoleLogPanel(new BorderLayout(), var1, var3)));
      var4.add(var1);
      var4.add(var3, "East");
      return var4;
   }

   public static JPanel b_JPanel_2() {
      JPanel var0;
      (var0 = new JPanel()).setBackground(d_Color_4);
      return var0;
   }

   public static JPanel a(JPanel var0) {
      var0.setBackground(d_Color_4);
      return var0;
   }
}
