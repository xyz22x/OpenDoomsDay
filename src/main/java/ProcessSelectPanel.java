import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public final class ProcessSelectPanel extends JPanel {
   protected DoomsdayGUI a_a;
   protected ConsoleLogPanel a_aq_1;
   protected JTextField a_JTextField_2;
   protected JComboBox a_JComboBox_3;
   JLabel a_JLabel_4;
   JComboBox b_JComboBox;
   protected JPanel a_JPanel_5;
   JComboBox c_JComboBox;
   JComboBox d_JComboBox;
   JCheckBox a_JCheckBox_6;
   JCheckBox b_JCheckBox_1;
   private C_dy a_dy_7;
   ConsoleLogPanel b_aq_2;
   private JPanel b_JPanel_3;
   private JPanel c_JPanel_1;
   private int a_int_8;
   private int b_int_4;
   private int c_int_2;
   private int d_int_1;
   private String a_String_9;
   private int e = -1;
   private boolean a_bool_10;
   private ArrayList a_ArrayList_11 = new ArrayList();

   public ProcessSelectPanel(DoomsdayGUI var1) {
      this.a_a = var1;
      this.setLayout(new BorderLayout());
      this.c_JPanel_1 = DoomsdayGUI.a_JPanel_3();
      this.c_JPanel_1.setBorder(new EmptyBorder(9, 9, 9, 14));
      DoomsdayGUI.a((LayoutManager)(new GridLayout(1, 1, 10, 6)));
      this.a_aq_1 = var1.a_aq_4();
      if (var1.a_au_9.i().equals("$default$")) {
         this.a_aq_1.a(GamePathUtils.b());
      } else {
         this.a_aq_1.a(var1.a_au_9.i());
      }

      this.a_aq_1.a_JTextField.getDocument().addDocumentListener(new C_cx(this, var1));
      this.b(var1.a_JLabel("Launcher location"), this.a_aq_1);
      this.a_JCheckBox_6 = DoomsdayGUI.a_JCheckBox();
      this.a_JCheckBox_6.setSelected(var1.a_au_9.e());
      this.a_JCheckBox_6.addActionListener(new C_de(this, var1));
      this.b(var1.a_JLabel("Install as Forge/Farbic mod"), this.a_JCheckBox_6);
      this.a_JComboBox_3 = var1.a_JComboBox(FileUtils.a((Object[])(new C_dn[0])));
      this.a_JComboBox_3.addActionListener(new C_df(this));
      JButton var2;
      (var2 = new JButton()).setBackground(Color.black);
      var2.setContentAreaFilled(false);
      var2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
      var2.setToolTipText("Update");
      var2.setFocusable(false);
      var2.addActionListener(new C_dg(this));
      var2.setIcon(C_bo.l());
      var2.addMouseListener(new C_dh(var2));
      JPanel var3;
      (var3 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()))).add(this.a_JComboBox_3);
      var3.add(var2, "East");
      this.a_int_8 = this.b(var1.a_JLabel("Minecraft version"), var3);
      this.b_JPanel_3 = DoomsdayGUI.b_JPanel_2();
      JLabel var6 = var1.a_JLabel("Advanced settings");
      C_di var10 = new C_di(this, var1, var6);
      var6.addMouseListener(var10);
      this.a_JLabel_4 = var1.a_JLabel("");
      this.a_JLabel_4.addMouseListener(var10);
      if (var1.a_au_9.f()) {
         this.a_JLabel_4.setIcon(C_bo.e);
      } else {
         this.a_JLabel_4.setIcon(C_bo.d);
      }

      this.b_JPanel_3.add(var6);
      this.b_JPanel_3.add(this.a_JLabel_4);
      var3 = this.b_JPanel_3;
      JPanel var4;
      (var4 = a_JPanel()).add(var3);
      C_dm var12 = new C_dm(var4, Box.createVerticalStrut(2));
      this.c_JPanel_1.add(var12.a_JComponent);
      this.c_JPanel_1.add(var12.a_Component_1);
      this.a_ArrayList_11.size();
      this.a_ArrayList_11.add(var12);
      this.a_JPanel_5 = DoomsdayGUI.a_JPanel_3();
      this.a_JPanel_5.setVisible(var1.a_au_9.f() && !var1.a_au_9.e());
      this.b_JCheckBox_1 = DoomsdayGUI.a_JCheckBox();
      this.b_JCheckBox_1.setSelected(var1.a_au_9.g());
      this.b_JCheckBox_1.addActionListener(new C_dj(this, var1));
      this.b_int_4 = this.a(var1.a_JLabel("Create a new instance"), this.b_JCheckBox_1);
      this.a_JTextField_2 = var1.a();
      this.c_int_2 = this.a(var1.a_JLabel("Instance name"), this.a_JTextField_2);
      this.c_JComboBox = var1.a_JComboBox("Main", "Tweaker", "Java Agent");
      this.c_JComboBox.addActionListener(new C_dk(this));
      this.d_int_1 = this.a(var1.a_JLabel("Install type"), this.c_JComboBox);
      DoomsdayGUI.a((LayoutManager)(new GridLayout(1, 1, 10, 6)));
      (var3 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()))).add(var1.a_JLabel("Config directory"));
      this.b_JComboBox = var1.a_JComboBox("Default", "Manual ");
      this.b_JComboBox.addActionListener(new C_dl(this));
      var3.add(this.b_JComboBox, "East");
      this.b_aq_2 = var1.a_aq_4();
      if (this.b_JComboBox.getSelectedIndex() == 0) {
         this.b_aq_2.a(GamePathUtils.d());
         this.b_aq_2.setEnabled(false);
      } else {
         this.b_aq_2.setEnabled(true);
      }

      this.a(var3, this.b_aq_2);
      this.a(this.d_int_1, false);
      this.d_JComboBox = var1.a_JComboBox(VersionManager.e.toArray());
      if (this.d_JComboBox.getItemCount() > 0) {
         LocalClientVersion var7 = new LocalClientVersion((ClientVersion)VersionManager.e.get(0), "Latest (" + VersionManager.e.get(0) + ")");
         this.d_JComboBox.insertItemAt(var7, 0);
      }

      VersionManager.c_ArrayList_1.add(new C_cy(this));
      VersionManager.a_ArrayList_5.add(new C_da(this));
      if (this.d_JComboBox.getItemCount() > 0) {
         if (var1.a_au_9.h().equals("$latest$")) {
            this.d_JComboBox.setSelectedIndex(0);
         } else {
            for (int var8 = 0; var8 < this.d_JComboBox.getItemCount(); var8++) {
               if (this.d_JComboBox.getItemAt(var8).toString().equals(var1.a_au_9.h())) {
                  this.d_JComboBox.setSelectedIndex(var8);
                  break;
               }
            }
         }
      }

      this.d_JComboBox.addActionListener(new C_dc(this, var1));
      JPanel var9;
      (var9 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()))).add(var1.a_JLabel("DoomsDay version"));
      this.a(var9, this.d_JComboBox);
      this.a_dy_7 = new C_dy();
      this.a_dy_7.setText("Install");
      this.a_dy_7.setFont(var1.a_Font_12);
      this.a_dy_7.a_Color = new Color(0, 100, 255);
      this.a_dy_7.b_Color = new Color(0, 100, 255);
      this.a_dy_7.setBorder(BorderFactory.createEmptyBorder());
      this.a_dy_7.d_Color = new Color(66, 91, 129);
      this.a_dy_7.e_Color = new Color(66, 91, 129);
      this.a_dy_7.f = new Color(71, 145, 255);
      this.a_dy_7.g = new Color(71, 145, 255);
      this.a_dy_7.h = Color.WHITE;
      this.a_dy_7.j = new Color(91, 165, 255);
      this.a_dy_7.setFont(new Font(var1.a_Font_12.getName(), 0, 24));
      this.a_dy_7.a_int_2 = 16;
      this.a_dy_7.addActionListener(new C_cv(this));
      (var3 = DoomsdayGUI.b_JPanel_2()).add(this.a_dy_7);
      this.c_JPanel_1.add(this.a_JPanel_5);
      this.c_JPanel_1.add(Box.createVerticalStrut(24));
      this.c_JPanel_1.add(var3, "South");
      UITheme var5;
      (var5 = new UITheme(this.c_JPanel_1)).getVerticalScrollBar().setUnitIncrement(10);
      this.add(var5, "Center");
      this.setBackground(new Color(45, 45, 46));
   }

   public final void a_void_2() {
      if (!this.a_bool_10) {
         this.a_bool_10 = true;
         SwingUtilities.invokeLater(new C_dd(this));
         ProcessSelectPanel var1 = this;
         C_dn var2 = (C_dn)this.a_JComboBox_3.getSelectedItem();
         if (!this.a_aq_1.a_JTextField.getText().equals(this.a_String_9)) {
            C_dn[] var3;
            if ((var3 = this.a()) == null) {
               this.a_JComboBox_3.setModel(new DefaultComboBoxModel<>(FileUtils.a((Object[])(new C_dn[0]))));
            } else {
               this.a_JComboBox_3.setModel(new DefaultComboBoxModel<>(FileUtils.a((Object[])var3)));

               for (int var9 = 0; var9 < var1.a_JComboBox_3.getItemCount(); var9++) {
                  C_dn var4 = (C_dn)var1.a_JComboBox_3.getItemAt(var9);
                  if (var2 != null && var4.a_String_1.equals(var2.a_String_1)) {
                     var1.a_JComboBox_3.setSelectedIndex(var9);
                     break;
                  }
               }
            }

            var1.e = -1;
            var1.a_String_9 = var1.a_aq_1.a_JTextField.getText();
         }

         if (this.a_JCheckBox_6.isSelected()) {
            this.a(this.a_int_8, false);
            this.a(this.b_int_4, false);
            this.a(this.c_int_2, false);
            this.b_JPanel_3.setVisible(false);
            this.a_JPanel_5.setVisible(false);
         } else {
            this.b_JPanel_3.setVisible(true);
            this.a_JPanel_5.setVisible(this.a_a.a_au_9.f() && !this.a_a.a_au_9.e());
            this.a(this.a_int_8, true);
            this.a(this.b_int_4, true);
            if (this.b_JCheckBox_1.isSelected()) {
               this.a(this.c_int_2, true);
            } else {
               this.a(this.c_int_2, false);
            }
         }

         if (this.a_JComboBox_3.getSelectedIndex() >= 0 && !this.a_JCheckBox_6.isSelected()) {
            if (((C_dn)this.a_JComboBox_3.getSelectedItem()).a_dt.containsKey("arguments")) {
               DefaultComboBoxModel var5 = new DefaultComboBoxModel<>(new Object[]{"Main", "Tweaker", "Java agent"});
               int var7 = this.c_JComboBox.getSelectedIndex();
               this.c_JComboBox.setModel(var5);
               if (var7 < this.c_JComboBox.getItemCount()) {
                  this.c_JComboBox.setSelectedIndex(var7);
               }
            } else {
               DefaultComboBoxModel var6 = new DefaultComboBoxModel<>(new Object[]{"Main", "Tweaker"});
               int var8 = this.c_JComboBox.getSelectedIndex();
               this.c_JComboBox.setModel(var6);
               if (var8 < this.c_JComboBox.getItemCount()) {
                  this.c_JComboBox.setSelectedIndex(var8);
               }
            }

            this.a(this.d_int_1, true);
         } else {
            this.c_JComboBox.setSelectedIndex(0);
            this.a(this.d_int_1, false);
         }

         if (this.a_JComboBox_3.getSelectedIndex() != this.e) {
            this.a_JTextField_2.setText(this.a(this.a_JComboBox_3.getSelectedItem().toString()));
         }

         this.a_bool_10 = false;
      }
   }

   private String a(String var1) {
      String var2 = this.a_aq_1.a_JTextField.getText();
      File var5 = new File(var2, "versions");

      for (int var3 = 0; var3 <= 100; var3++) {
         String var4;
         if (var3 == 0) {
            var4 = var1 + "_DoomsDay";
         } else {
            var4 = var1 + "_DoomsDay(" + var3 + ")";
         }

         if (!new File(var5, var4).exists()) {
            return var4;
         }
      }

      return null;
   }

   public final C_dn[] a() {
      File var1;
      if (!(var1 = new File(this.a_aq_1.a_JTextField.getText(), "versions")).exists()) {
         return null;
      } else {
         File[] var8 = var1.listFiles();
         ArrayList var2 = new ArrayList();

         for (int var3 = 0; var3 < var8.length; var3++) {
            if (var8[var3].isDirectory()) {
               String var4 = var8[var3].getName();
               File var5;
               if ((var5 = new File(var8[var3], var4 + ".json")).exists()) {
                  try {
                     BufferedReader var9 = new BufferedReader(new FileReader(var5));
                     C_dt var6 = (C_dt)new C_du().a(var9, null);
                     var9.close();
                     C_dn var10;
                     if ((var10 = new C_dn(var6)).a_String_1.equals(var4)) {
                        var2.add(var10);
                     }
                  } catch (Exception var7) {
                     var7.printStackTrace();
                  }
               }
            }
         }

         return (C_dn[])var2.toArray(new C_dn[var2.size()]);
      }
   }

   private void a(int var1, boolean var2) {
      ((C_dm)this.a_ArrayList_11.get(var1)).a_JComponent.setVisible(var2);
      ((C_dm)this.a_ArrayList_11.get(var1)).a_Component_1.setVisible(var2);
   }

   private int a(JComponent var1, JComponent var2) {
      JPanel var3;
      (var3 = a_JPanel()).add(var1);
      var3.add(var2);
      C_dm var4 = new C_dm(var3, Box.createVerticalStrut(2));
      this.a_JPanel_5.add(var4.a_JComponent);
      this.a_JPanel_5.add(var4.a_Component_1);
      int var5 = this.a_ArrayList_11.size();
      this.a_ArrayList_11.add(var4);
      return var5;
   }

   private int b(JComponent var1, JComponent var2) {
      JPanel var3;
      (var3 = a_JPanel()).add(var1);
      var3.add(var2);
      C_dm var4 = new C_dm(var3, Box.createVerticalStrut(2));
      this.c_JPanel_1.add(var4.a_JComponent);
      this.c_JPanel_1.add(var4.a_Component_1);
      int var5 = this.a_ArrayList_11.size();
      this.a_ArrayList_11.add(var4);
      return var5;
   }

   private static JPanel a_JPanel() {
      JPanel var0;
      (var0 = DoomsdayGUI.a((LayoutManager)(new GridLayout(1, 2, 2, 0)))).setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
      var0.setMinimumSize(new Dimension(Integer.MAX_VALUE, 35));
      var0.setPreferredSize(new Dimension(119, 35));
      return var0;
   }
}
