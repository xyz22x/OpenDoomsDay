import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Set;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public final class AdvancedSettingsPanel extends JPanel {
   private DoomsdayGUI a_a;
   JComboBox a_JComboBox_1;
   JTextField a_JTextField_2;
   JTextField b_JTextField;
   private JTextField d_JTextField;
   JCheckBox a_JCheckBox_3;
   JCheckBox b_JCheckBox_1;
   JCheckBox c_JCheckBox;
   JCheckBox d_JCheckBox_1;
   JComboBox b_JComboBox_2;
   JTextField c_JTextField_1;
   private UITheme a_fd_4;
   private JPanel a_JPanel_5;
   JComboBox c_JComboBox_2;
   private boolean a_bool_6;
   private boolean b_bool_3;

   public AdvancedSettingsPanel(DoomsdayGUI var1) {
      this.a_a = var1;
      this.setLayout(new BorderLayout());
      this.a_JPanel_5 = DoomsdayGUI.a_JPanel_3();
      this.a_JPanel_5.setBorder(new EmptyBorder(9, 9, 9, 14));
      JComboBox var2;
      (var2 = var1.a_JComboBox(
            "Thread",
            "Hook DoPrivileged",
            "Hook GetSystemPackage",
            "Hook IsInterrupted",
            "Hook IsThreadAlive",
            "Hook MonitorWait",
            "Hook MonitorNotify",
            "Hook Sleep",
            "Hook StartThread"
         ))
         .setSelectedIndex(ClientConfig.a_int_2(var1.a_au_9.e_String()));
      var2.addActionListener(new C_ce(var2, var1));
      this.a(var1.a_JLabel("Attach mode"), var2, 1);
      this.a_JComboBox_1 = var1.a_JComboBox("Illegal", "Normal", "Vanilla");
      this.a_JComboBox_1.addActionListener(new C_ci(this));
      this.a(var1.a_JLabel("Naming"), this.a_JComboBox_1, 1);
      if (var1.a_au_9.i_bool()) {
         this.a_JTextField_2 = var1.a();
         this.a_JTextField_2.getDocument().addDocumentListener(new C_cj(this));
         this.a(var1.a_JLabel("Class name prefix"), this.a_JTextField_2, 1);
         this.b_JTextField = var1.a();
         this.b_JTextField.getDocument().addDocumentListener(new C_ck(this));
         this.a(var1.a_JLabel("Class name postfix"), this.b_JTextField, 1);
         this.a_JCheckBox_3 = DoomsdayGUI.a_JCheckBox();
         this.a_JCheckBox_3.addActionListener(new C_cl(this));
         this.a(var1.a_JLabel("JVMTI getMethod"), this.a_JCheckBox_3, 0);
         this.b_JCheckBox_1 = DoomsdayGUI.a_JCheckBox();
         this.b_JCheckBox_1.addActionListener(new C_cm(this));
         this.a(var1.a_JLabel("JVMTI getField"), this.b_JCheckBox_1, 0);
         this.c_JCheckBox = DoomsdayGUI.a_JCheckBox();
         this.c_JCheckBox.addActionListener(new C_cn(this));
         this.a(var1.a_JLabel("Find class from bootstrap"), this.c_JCheckBox, 0);
         this.d_JCheckBox_1 = DoomsdayGUI.a_JCheckBox();
         this.d_JCheckBox_1.addActionListener(new C_co(this));
         this.a(var1.a_JLabel("Silent natives (unstable)"), this.d_JCheckBox_1, 0);
         this.b_JComboBox_2 = var1.a_JComboBox("JNI", "JVM_DefineClass", "JVM_DefineClassWithSource", "JVM_DefineClassWithSourceCond");
         this.b_JComboBox_2.addActionListener(new C_cp(this));
         this.a(var1.a_JLabel("Define class function"), this.b_JComboBox_2, 1);
      }

      this.c_JTextField_1 = var1.a();
      this.c_JTextField_1.getDocument().addDocumentListener(new C_cf(this));
      this.a(var1.a_JLabel("Class loader"), this.c_JTextField_1, 1);
      Object[] var3;
      Set var6;
      (var3 = new Object[(var6 = C_ed.a_LinkedHashMap_1.keySet()).size() + 1])[0] = " ";
      int var4 = 1;

      for (Object var7_raw : var6) { String var7 = (String)var7_raw;
         var3[var4++] = var7;
      }

      this.c_JComboBox_2 = var1.a_JComboBox(var3);
      this.c_JComboBox_2.addActionListener(new C_cg(this));
      this.a(var1.a_JLabel("GUI keybind"), this.c_JComboBox_2, 1);
      this.a_fd_4 = new UITheme(this.a_JPanel_5);
      this.a_fd_4.getVerticalScrollBar().setUnitIncrement(8);
      this.a_fd_4.getHorizontalScrollBar().setUnitIncrement(8);
      this.add(this.a_fd_4, "Center");
      this.d_JTextField = var1.a();
      this.d_JTextField.getDocument().addDocumentListener(new C_ch(this));
      this.d_JTextField.setText(var1.a_au_9.f_String());
      this.add(this.d_JTextField, "South");
   }

   public final void a() {
      String var1;
      if (!(var1 = this.d_JTextField.getText()).equals(this.a_a.a_au_9.f_String())) {
         this.a_a.a_au_9.f(var1);
      }

      if (!this.a_bool_6) {
         this.b_bool_3 = true;
         if (this.a_JTextField_2 != null) {
            int var2;
            if ((var2 = var1.indexOf("--classprefix=")) >= 0) {
               int var3;
               if ((var3 = var1.indexOf(" ", var2)) < 0) {
                  var3 = var1.length();
               }

               String var4 = FileUtils.b(var1.substring(var2 + 14, var3));
               this.a_JTextField_2.setText(var4);
            } else {
               this.a_JTextField_2.setText("");
            }
         }

         int var5;
         if ((var5 = var1.indexOf("--naming=")) >= 0) {
            int var19;
            if ((var19 = var1.indexOf(" ", var5)) < 0) {
               var19 = var1.length();
            }

            String var6;
            if ((var6 = FileUtils.b(var1.substring(var5 + 9, var19))).equals("1")) {
               this.a_JComboBox_1.setSelectedIndex(1);
            } else if (var6.equals("2")) {
               this.a_JComboBox_1.setSelectedIndex(2);
            } else {
               this.a_JComboBox_1.setSelectedIndex(0);
            }
         }

         if (this.b_JTextField != null) {
            if ((var5 = var1.indexOf("--classpostfix=")) >= 0) {
               int var20;
               if ((var20 = var1.indexOf(" ", var5)) < 0) {
                  var20 = var1.length();
               }

               String var8 = FileUtils.b(var1.substring(var5 + 15, var20));
               this.b_JTextField.setText(var8);
            } else {
               this.b_JTextField.setText("");
            }
         }

         if (this.a_JCheckBox_3 != null) {
            if ((var5 = var1.indexOf("--jvmtigetmethod=")) >= 0) {
               int var21;
               if ((var21 = var1.indexOf(" ", var5)) < 0) {
                  var21 = var1.length();
               }

               this.a_JCheckBox_3.setSelected(var1.substring(var5 + 17, var21).equals("true"));
            } else {
               this.a_JCheckBox_3.setSelected(false);
            }
         }

         if (this.b_JCheckBox_1 != null) {
            if ((var5 = var1.indexOf("--jvmtigetfield=")) >= 0) {
               int var22;
               if ((var22 = var1.indexOf(" ", var5)) < 0) {
                  var22 = var1.length();
               }

               this.b_JCheckBox_1.setSelected(var1.substring(var5 + 16, var22).equals("true"));
            } else {
               this.b_JCheckBox_1.setSelected(false);
            }
         }

         if (this.c_JCheckBox != null) {
            if ((var5 = var1.indexOf("--findfrombootstrap=")) >= 0) {
               int var23;
               if ((var23 = var1.indexOf(" ", var5)) < 0) {
                  var23 = var1.length();
               }

               this.c_JCheckBox.setSelected(var1.substring(var5 + 20, var23).equals("true"));
            } else {
               this.c_JCheckBox.setSelected(false);
            }
         }

         if (this.d_JCheckBox_1 != null) {
            if ((var5 = var1.indexOf("--silentnatives=")) >= 0) {
               int var24;
               if ((var24 = var1.indexOf(" ", var5)) < 0) {
                  var24 = var1.length();
               }

               this.d_JCheckBox_1.setSelected(var1.substring(var5 + 16, var24).equals("true"));
            } else {
               this.d_JCheckBox_1.setSelected(false);
            }
         }

         if (this.b_JComboBox_2 != null) {
            if ((var5 = var1.indexOf("--defineclassfunction=")) >= 0) {
               int var25;
               if ((var25 = var1.indexOf(" ", var5)) < 0) {
                  var25 = var1.length();
               }

               String var14;
               if ((var14 = var1.substring(var5 + 22, var25)).equals("JVM_DefineClass")) {
                  this.b_JComboBox_2.setSelectedIndex(1);
               } else if (var14.equals("JVM_DefineClassWithSource")) {
                  this.b_JComboBox_2.setSelectedIndex(2);
               } else if (var14.equals("JVM_DefineClassWithSourceCond")) {
                  this.b_JComboBox_2.setSelectedIndex(3);
               } else {
                  this.b_JComboBox_2.setSelectedIndex(0);
               }
            } else {
               this.b_JComboBox_2.setSelectedIndex(0);
            }
         }

         label134:
         if (this.c_JComboBox_2 != null) {
            if ((var5 = var1.indexOf("--clickguikey=")) >= 0) {
               int var26;
               if ((var26 = var1.indexOf(" ", var5)) < 0) {
                  var26 = var1.length();
               }

               String var16;
               if (C_ed.a(var16 = var1.substring(var5 + 14, var26)) != null) {
                  var26 = 0;

                  while (true) {
                     if (var26 >= this.c_JComboBox_2.getItemCount()) {
                        break label134;
                     }

                     if (this.c_JComboBox_2.getItemAt(var26).hashCode() == var16.hashCode() && this.c_JComboBox_2.getItemAt(var26).equals(var16)) {
                        this.c_JComboBox_2.setSelectedIndex(var26);
                        break label134;
                     }

                     var26++;
                  }
               }
            }

            this.c_JComboBox_2.setSelectedIndex(0);
         }

         if ((var5 = var1.indexOf("--classloader=")) >= 0) {
            int var28;
            if ((var28 = var1.indexOf(" ", var5)) < 0) {
               var28 = var1.length();
            }

            String var18 = FileUtils.b(var1.substring(var5 + 14, var28));
            this.c_JTextField_1.setText(var18);
         } else {
            this.c_JTextField_1.setText("");
         }

         this.b_bool_3 = false;
      }
   }

   public final void a(String var1, String var2) {
      if (!this.b_bool_3) {
         StringBuilder var3;
         (var3 = new StringBuilder()).append(this.d_JTextField.getText());
         int var4;
         if ((var4 = var3.indexOf(var1)) < 0) {
            if (var2.length() > 0) {
               var3.append(' ');
               var3.append(var1);
               var3.append(var2);
            }
         } else {
            int var5;
            if ((var5 = var3.indexOf(" ", var4)) < 0) {
               var5 = var3.length();
            }

            if (var2.length() > 0) {
               var3.delete(var4 + var1.length(), var5);
               var3.insert(var4 + var1.length(), var2);
            } else {
               if (var4 > 0) {
                  var4--;
               }

               var3.delete(var4, var5);
            }
         }

         this.a_bool_6 = true;
         if (var3.length() == 0) {
            this.d_JTextField.setText("");
         } else {
            this.d_JTextField.setText(var3.substring(0, var3.length()).trim());
         }

         this.a_bool_6 = false;
      }
   }

   private void a(JComponent var1, JComponent var2, int var3) {
      JPanel var4;
      (var4 = a_JPanel()).add(var1);
      var4.add(var2);
      this.a_JPanel_5.add(var4);
      this.a_JPanel_5.add(Box.createVerticalStrut(var3));
   }

   private static JPanel a_JPanel() {
      JPanel var0;
      (var0 = DoomsdayGUI.a((LayoutManager)(new GridLayout(1, 2, 2, 0)))).setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
      var0.setMinimumSize(new Dimension(Integer.MAX_VALUE, 35));
      var0.setPreferredSize(new Dimension(119, 35));
      return var0;
   }
}
