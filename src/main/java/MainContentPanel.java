import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public final class MainContentPanel extends JPanel {
   final JTextField a_JTextField;
   final JCheckBox a_JCheckBox_1;
   final JCheckBox b_JCheckBox;
   final JCheckBox c;
   final JCheckBox d;
   public final JCheckBox e;
   private UITheme a_fd_2;
   private JPanel a_JPanel_3;
   final C_dy a_dy_4;
   public final JTextField b_JTextField_1;

   public MainContentPanel(DoomsdayGUI var1) {
      this.setLayout(new BorderLayout());
      this.a_JPanel_3 = DoomsdayGUI.a_JPanel_3();
      this.a_JPanel_3.setBorder(new EmptyBorder(9, 9, 9, 14));
      this.a_JTextField = var1.a();
      this.a_JTextField.setColumns(2);
      this.a_JTextField.setText(var1.a_au_9.c_String());
      this.a_JTextField.getDocument().addDocumentListener(new C_eh(this, var1));
      this.a(var1.a_JLabel("Window title"), this.a_JTextField);
      this.a_JCheckBox_1 = DoomsdayGUI.a_JCheckBox();
      this.a_JCheckBox_1.setSelected(var1.a_au_9.c());
      this.a_JCheckBox_1.addActionListener(new C_ei(this, var1));
      this.a(var1.a_JLabel("Run as administrator"), this.a_JCheckBox_1);
      DoomsdayGUI.a((LayoutManager)(new BorderLayout()));
      this.b_JCheckBox = DoomsdayGUI.a_JCheckBox();
      this.b_JCheckBox.setSelected(var1.a_au_9.h_bool());
      this.b_JCheckBox.addActionListener(new C_ej(this, var1));
      this.a(var1.a_JLabel("Show successful injection messages"), this.b_JCheckBox);
      this.c = DoomsdayGUI.a_JCheckBox();
      if (var1.a_au_9.a_Boolean() != null) {
         this.c.setSelected(var1.a_au_9.a_Boolean());
      }

      this.c.addActionListener(new C_ek(this, var1));
      this.a(var1.a_JLabel("Automatically save loader configuration"), this.c);
      this.d = DoomsdayGUI.a_JCheckBox();
      this.d.setSelected(var1.a_au_9.d());
      this.d.addActionListener(new C_el(this, var1));
      this.a(var1.a_JLabel("Save updates in loader"), this.d);
      this.e = DoomsdayGUI.a_JCheckBox();
      this.e.setSelected(var1.a_au_9.d());
      this.e.addActionListener(new C_em(this));
      JPanel var2;
      (var2 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()))).add(this.e, "West");
      DecimalFormat var3 = new DecimalFormat("########");
      C_en var5;
      (var5 = new C_en(var3)).setValueClass(Integer.class);
      var5.setMinimum(0);
      var5.setMaximum(60000);
      var5.setAllowsInvalid(false);
      var5.setCommitsOnValidEdit(true);
      this.b_JTextField_1 = new C_eo(var5);
      this.b_JTextField_1.setColumns(6);
      var1.a(this.b_JTextField_1);
      this.b_JTextField_1.setText("500");
      this.b_JTextField_1.setEditable(this.e.isSelected());
      var2.add(this.b_JTextField_1, "Center");
      this.a(var1.a_JLabel("Wait inject mode"), var2);
      this.a_fd_2 = new UITheme(this.a_JPanel_3);
      this.a_fd_2.getVerticalScrollBar().setUnitIncrement(8);
      this.a_fd_2.getHorizontalScrollBar().setUnitIncrement(8);
      this.a_dy_4 = new C_dy();
      this.a_dy_4.setPreferredSize(new Dimension(180, 35));
      this.a_dy_4.setText("Remove patch");
      this.a_dy_4.setFont(var1.a_Font_12);
      this.a_dy_4.a_Color = new Color(0, 100, 255);
      this.a_dy_4.b_Color = new Color(0, 100, 255);
      this.a_dy_4.setBorder(BorderFactory.createEmptyBorder());
      this.a_dy_4.d_Color = new Color(66, 91, 129);
      this.a_dy_4.e_Color = new Color(66, 91, 129);
      this.a_dy_4.f = new Color(71, 145, 255);
      this.a_dy_4.g = new Color(71, 145, 255);
      this.a_dy_4.h = Color.WHITE;
      this.a_dy_4.j = new Color(91, 165, 255);
      this.a_dy_4.setFont(new Font(var1.a_Font_12.getName(), 0, 24));
      this.a_dy_4.a_int_2 = 16;
      this.a_dy_4.setVisible(false);
      (var2 = DoomsdayGUI.b_JPanel_2()).setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
      var2.setMinimumSize(new Dimension(Integer.MAX_VALUE, 40));
      var2.setPreferredSize(new Dimension(119, 40));
      var2.add(this.a_dy_4);
      this.a_JPanel_3.add(var2);
      this.add(this.a_fd_2, "Center");
      if (PlatformUtil.i()) {
         this.a_dy_4.addActionListener(new C_ep(this));
         if (C_eu.a() || C_eu.a_ew("ddkfi") != null) {
            this.a_dy_4.setVisible(true);
         }
      }
   }

   private void a(JComponent var1, JComponent var2) {
      JPanel var3;
      (var3 = a()).add(var1);
      var3.add(var2);
      this.a_JPanel_3.add(var3);
      this.a_JPanel_3.add(Box.createVerticalStrut(2));
   }

   private static JPanel a() {
      JPanel var0;
      (var0 = DoomsdayGUI.a((LayoutManager)(new GridLayout(1, 2, 2, 0)))).setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
      var0.setMinimumSize(new Dimension(Integer.MAX_VALUE, 35));
      var0.setPreferredSize(new Dimension(119, 35));
      return var0;
   }
}
