import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public final class VersionTabPanel extends JPanel {
   public volatile boolean a_bool;
   static Object a_Object_1 = new Object();
   final JComboBox a_JComboBox_2;
   final JTable a_JTable_3;
   final TableRowSorter a_TableRowSorter_4;
   final DefaultTableModel a_DefaultTableModel_5;
   final C_dy a_dy_6;
   final C_dy b_dy;
   final JScrollPane a_JScrollPane_7;
   final JTextField a_JTextField_8;
   final DoomsdayGUI a_a_9;
   final JComboBox b_JComboBox_1;
   final JComboBox c;
   JLabel a_JLabel_10;

   public VersionTabPanel(DoomsdayGUI var1) {
      this.a_a_9 = var1;
      this.setLayout(new BorderLayout());
      JPanel var2 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()));
      JPanel var3;
      (var3 = DoomsdayGUI.a((LayoutManager)(new FlowLayout(0)))).setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
      this.a_JComboBox_2 = var1.a_JComboBox("java processes", "all processes");
      this.a_JComboBox_2.addActionListener(new C_fw(this));
      var3.add(var1.a_JLabel("Show"));
      var3.add(this.a_JComboBox_2);
      var3.add(var1.a_JLabel("Filter"));
      JTextField var4;
      (var4 = var1.a()).setColumns(10);
      var4.getDocument().addDocumentListener(new C_v(this));
      var3.add(var4);
      JPanel var5 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()));
      JPanel var6 = DoomsdayGUI.b_JPanel_2();
      if (GamePathUtils.b_bool()) {
         JButton var7;
         (var7 = new JButton()).setBackground(Color.black);
         var7.setContentAreaFilled(false);
         var7.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
         var7.setToolTipText("Loader launcher from shared folder");
         var7.setFocusable(false);
         var7.setIcon(C_bo.h);
         var6.add(var7);
      }

      if (!DoomsdayGUI.b_bool_1) {
         JButton var21;
         (var21 = new JButton()).setBackground(Color.black);
         var21.setContentAreaFilled(false);
         var21.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
         var21.setToolTipText("Run as administrator");
         var21.setFocusable(false);
         var21.addActionListener(new C_c(var21, var1.a_au_9));
         var21.setIcon(C_bo.i);
         var6.add(var21);
      }

      var5.add(var6, "East");
      var5.add(new UITheme(var3), "Center");
      var2.add(var5, "North");
      String[] var22;
      if (!PlatformUtil.h() || !PlatformUtil.e() && !PlatformUtil.f()) {
         var22 = new String[]{null, "", "pid", "arch", "process name", "user", "memory"};
      } else {
         var22 = new String[]{null, "", "pid", "bits", "process name", "user", "memory"};
      }

      this.a_DefaultTableModel_5 = new C_ag(var22);
      this.a_JLabel_10 = new JLabel(C_bo.p());
      this.a_JLabel_10.setOpaque(true);
      this.a_JTable_3 = new C_ah(this, this.a_DefaultTableModel_5, var1);
      this.a_TableRowSorter_4 = new TableRowSorter<>(this.a_DefaultTableModel_5);
      this.a_TableRowSorter_4.setRowFilter(new C_aj(var4));
      this.a_JTable_3.setRowSorter(this.a_TableRowSorter_4);
      this.a_JTable_3.setRowHeight(this.a_JTable_3.getRowHeight() + 8);
      this.a_JTable_3.setSelectionMode(0);
      DefaultTableCellRenderer var8;
      (var8 = new DefaultTableCellRenderer()).setHorizontalAlignment(0);
      this.a_JTable_3.setDefaultRenderer(Integer.class, var8);
      this.a_JTable_3.getSelectionModel().addListSelectionListener(new C_ak(this));
      this.a_JTable_3.setFont(new Font(var1.a_Font_12.getName(), 0, var1.a_Font_12.getSize()));
      this.a_JTable_3.setForeground(Color.WHITE);
      this.a_JTable_3.setRowSelectionAllowed(true);
      this.a_JTable_3.setShowGrid(false);
      this.a_JTable_3.getTableHeader().setBackground(new Color(45, 45, 46));
      this.a_JTable_3.getTableHeader().setFont(new Font(var1.a_Font_12.getName(), 0, var1.a_Font_12.getSize()));
      this.a_JTable_3.setBackground(new Color(45, 45, 46));
      this.a_JTable_3.getTableHeader().setForeground(Color.white);
      this.a_JTable_3.getColumnModel().getColumn(0).setMaxWidth(0);
      this.a_JTable_3.getColumnModel().getColumn(0).setMinWidth(0);
      this.a_JTable_3.getColumnModel().getColumn(0).setPreferredWidth(0);
      this.a_JTable_3.getColumnModel().getColumn(1).setMaxWidth(22);
      this.a_JTable_3.getColumnModel().getColumn(1).setMinWidth(22);
      this.a_JTable_3.getColumnModel().getColumn(1).setPreferredWidth(22);
      this.a_JTable_3.getColumnModel().getColumn(2).setPreferredWidth(100);
      this.a_JTable_3.getColumnModel().getColumn(2).setMaxWidth(100);
      this.a_JTable_3.getColumnModel().getColumn(3).setPreferredWidth(80);
      this.a_JTable_3.getColumnModel().getColumn(3).setMaxWidth(90);
      this.a_JTable_3.setSelectionBackground(new Color(0, 100, 255));
      this.a_JTable_3.setSelectionForeground(Color.white);
      this.a_JScrollPane_7 = new UITheme(this.a_JTable_3);
      C_fz var9;
      (var9 = new C_fz()).setBackground(new Color(45, 45, 46));
      var9.setHorizontalAlignment(0);

      for (int var14 = 0; var14 < this.a_JTable_3.getColumnModel().getColumnCount(); var14++) {
         this.a_JTable_3.getColumnModel().getColumn(var14).setHeaderRenderer(var9);
      }

      this.a_JScrollPane_7.setBackground(new Color(45, 45, 46));
      this.a_JScrollPane_7.getViewport().setBackground(new Color(45, 45, 46));
      this.a_JTable_3.addAncestorListener(new C_al(this));
      var2.add(this.a_JScrollPane_7);
      JLabel var15;
      (var15 = new JLabel("PID")).setFont(var1.a_Font_12);
      var15.setForeground(Color.WHITE);
      DecimalFormat var10 = new DecimalFormat("########");
      C_am var11;
      (var11 = new C_am(var10)).setValueClass(Integer.class);
      var11.setMinimum(0);
      var11.setMaximum(99999999);
      var11.setAllowsInvalid(false);
      var11.setCommitsOnValidEdit(true);
      this.a_JTextField_8 = new C_an(var11);
      this.a_JTextField_8.setColumns(6);
      this.a_JTextField_8.getDocument().addDocumentListener(new C_ao(this));
      var1.a(this.a_JTextField_8);
      this.a_dy_6 = new C_dy();
      this.a_dy_6.setPreferredSize(new Dimension(90, 35));
      this.a_dy_6.setText("Inject");
      this.a_dy_6.setFont(var1.a_Font_12);
      this.a_dy_6.a_Color = new Color(0, 100, 255);
      this.a_dy_6.b_Color = new Color(0, 100, 255);
      this.a_dy_6.setBorder(BorderFactory.createEmptyBorder());
      this.a_dy_6.d_Color = new Color(66, 91, 129);
      this.a_dy_6.e_Color = new Color(66, 91, 129);
      this.a_dy_6.f = new Color(71, 145, 255);
      this.a_dy_6.g = new Color(71, 145, 255);
      this.a_dy_6.h = Color.WHITE;
      this.a_dy_6.j = new Color(91, 165, 255);
      this.a_dy_6.setFont(new Font(var1.a_Font_12.getName(), 0, 24));
      this.a_dy_6.a_int_2 = 16;
      this.a_dy_6.setEnabled(false);
      C_i var12 = new C_i(this);
      this.a_dy_6.addMouseListener(new C_w(this, var12));
      this.b_dy = new C_dy();
      this.b_dy.setPreferredSize(new Dimension(90, 35));
      this.b_dy.setText("Restart");
      this.b_dy.setFont(var1.a_Font_12);
      this.b_dy.a_Color = new Color(0, 100, 255);
      this.b_dy.b_Color = new Color(0, 100, 255);
      this.b_dy.setBorder(BorderFactory.createEmptyBorder());
      this.b_dy.d_Color = new Color(66, 91, 129);
      this.b_dy.e_Color = new Color(66, 91, 129);
      this.b_dy.f = new Color(71, 145, 255);
      this.b_dy.g = new Color(71, 145, 255);
      this.b_dy.h = Color.WHITE;
      this.b_dy.j = new Color(91, 165, 255);
      this.b_dy.setFont(new Font(var1.a_Font_12.getName(), 0, 24));
      this.b_dy.a_int_2 = 16;
      this.b_dy.setEnabled(false);
      this.b_dy.addMouseListener(new C_x());
      var3 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()));
      var5 = DoomsdayGUI.b_JPanel_2();
      var3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 10));
      var5.add(var1.a_JLabel("Version"));
      VersionManager.c_ArrayList_1.add(new C_z(this));
      VersionManager.a_ArrayList_5.add(new C_ab(this));
      VersionManager.d.add(new C_ad(this));
      this.c = var1.a_JComboBox(VersionManager.e.toArray());
      if (this.c.getItemCount() > 0) {
         LocalClientVersion var17 = new LocalClientVersion((ClientVersion)VersionManager.e.get(0), "Latest (" + VersionManager.e.get(0) + ")");
         this.c.insertItemAt(var17, 0);
      }

      File customJarsDir = new File("custom_jars");
      if (!customJarsDir.exists()) {
         customJarsDir.mkdirs();
      } else {
         File[] jars = customJarsDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".jar"));
         if (jars != null) {
            for (File j : jars) {
               this.c.addItem(new ClientVersion(j));
            }
         }
      }

      if (DoomsdayGUI.customJarFile != null && DoomsdayGUI.customJarFile.exists()) {
         ClientVersion cliJar = new ClientVersion(DoomsdayGUI.customJarFile);
         this.c.addItem(cliJar);
         this.c.setSelectedItem(cliJar);
      } else if (this.c.getItemCount() > 0) {
         if (var1.a_au_9.g_String().equals("$latest$")) {
            this.c.setSelectedIndex(0);
         } else {
            for (int var18 = 0; var18 < this.c.getItemCount(); var18++) {
               if (this.c.getItemAt(var18).toString().equals(var1.a_au_9.g_String())) {
                  this.c.setSelectedIndex(var18);
                  break;
               }
            }
         }
      }

      this.c.addActionListener(new C_ae(this, var1));
      this.c.setMinimumSize(new Dimension(120, 0));
      this.c.setPreferredSize(new Dimension(170, 35));
      var5.add(this.c);
      var5.add(Box.createHorizontalStrut(5));

      JButton browseBtn = new JButton("Select JAR...");
      browseBtn.setFont(new Font(var1.a_Font_12.getName(), 0, 14));
      browseBtn.setForeground(Color.WHITE);
      browseBtn.setBackground(new Color(0, 100, 255));
      browseBtn.setFocusable(false);
      browseBtn.addActionListener(ev -> {
         JFileChooser chooser = new JFileChooser();
         chooser.setDialogTitle("Select Custom JAR File to Inject");
         chooser.setFileFilter(new FileNameExtensionFilter("Java Archive (*.jar)", "jar"));
         if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedJar = chooser.getSelectedFile();
            if (selectedJar != null && selectedJar.exists()) {
               ClientVersion customVer = new ClientVersion(selectedJar);
               this.c.addItem(customVer);
               this.c.setSelectedItem(customVer);
            }
         }
      });
      var5.add(browseBtn);
      var5.add(Box.createHorizontalStrut(5));
      var5.add(var1.a_JLabel("Mode"));
      Object[] var19;
      if (PlatformUtil.h() && !var1.a_au_9.i_bool() && !DoomsdayGUI.f_bool_1) {
         var19 = new Object[]{"jvmti", "shellcode"};
      } else {
         var19 = new Object[]{"jvmti", "shellcode", "restart", "restart 2"};
      }

      JComboBox var10000;
      byte var10001;
      label57: {
         this.b_JComboBox_1 = var1.a_JComboBox(var19);
         var10000 = this.b_JComboBox_1;
         String var20 = var1.a_au_9.a_String_3();
         if (!"jvmti_agent".equals(var20)) {
            if ("shellcode".equals(var20)) {
               var10001 = 1;
               break label57;
            }

            if ("restart".equals(var20)) {
               var10001 = 2;
               break label57;
            }

            if ("restart 2".equals(var20)) {
               var10001 = 3;
               break label57;
            }

            if (PlatformUtil.h()) {
               var10001 = 1;
               break label57;
            }
         }

         var10001 = 0;
      }

      var10000.setSelectedIndex(var10001);
      this.b_JComboBox_1.addActionListener(new C_af(this, var1));
      var5.add(this.b_JComboBox_1);
      var5.add(var15);
      var5.add(this.a_JTextField_8);
      var5.add(this.a_dy_6);
      PlatformUtil.i();
      UITheme var23;
      (var23 = new UITheme(var5)).getHorizontalScrollBar().setUnitIncrement(10);
      var3.add(var23, "Center");
      this.add(var3, "South");
      this.add(var2, "Center");
      if (var1.a_au_9.b_String().equals("all")) {
         this.a_JComboBox_2.setSelectedIndex(1);
      }
   }

   public final String a() {
      return a(this.b_JComboBox_1.getSelectedIndex());
   }

   public static String a(int var0) {
      if (var0 == 0) {
         return "jvmti_agent";
      } else if (var0 == 1) {
         return "shellcode";
      } else if (var0 == 2) {
         return "restart";
      } else if (var0 == 3) {
         return "restart 2";
      } else {
         return PlatformUtil.h() ? "shellcode" : "jvmti_agent";
      }
   }
}
