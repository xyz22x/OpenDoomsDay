import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public final class VersionSelectPanel extends JPanel {
   protected DoomsdayGUI a_a;
   JPanel a_JPanel_1;
   C_gb a_gb_2;
   UITheme a_fd_3;
   public static boolean a_bool_4;
   private HashMap a_HashMap_5 = new HashMap();
   private boolean b;

   static {
      try {
         a_bool_4 = Double.parseDouble(System.getProperty("java.class.version")) <= 50.0;
      } catch (Exception var0) {
         var0.printStackTrace();
         a_bool_4 = System.getProperty("java.version").startsWith("1.6");
      }
   }

   public VersionSelectPanel(DoomsdayGUI var1) {
      this.a_a = var1;
      this.setLayout(new BorderLayout());
      DoomsdayGUI.a((JPanel)this);
      this.a_gb_2 = new C_gb();
      this.a_gb_2.start();
      JPanel var2 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()));
      JPanel var3 = DoomsdayGUI.b_JPanel_2();
      var2.add(var3, "West");
      C_dy var4;
      (var4 = new C_dy()).setPreferredSize(new Dimension(180, 35));
      var4.setText("Check updates");
      var4.setFont(var1.a_Font_12);
      var4.a_Color = DoomsdayGUI.a_Color_14;
      var4.b_Color = DoomsdayGUI.a_Color_14;
      var4.setBorder(BorderFactory.createEmptyBorder());
      var4.d_Color = DoomsdayGUI.a_Color_14;
      var4.e_Color = DoomsdayGUI.a_Color_14;
      var4.f = DoomsdayGUI.c_Color_4;
      var4.g = DoomsdayGUI.c_Color_4;
      var4.h = Color.WHITE;
      var4.j = DoomsdayGUI.b_Color_4;
      var4.setFont(new Font(var1.a_Font_12.getName(), 0, 24));
      var4.setBorder(new C_fq(4, Color.orange));
      var4.addActionListener(new C_gq(var4));
      var2.setBorder(new EmptyBorder(8, 8, 8, 8));
      var2.add(var4, "East");
      JCheckBox var5;
      (var5 = DoomsdayGUI.a_JCheckBox()).setText("Automatically check for updates");
      var5.setFont(var1.a_Font_12);
      var5.setFocusable(false);
      var5.setForeground(var1.g_Color_2);
      var5.setSelected(var1.a_au_9.b_bool_2());
      var5.addActionListener(new C_gs(var1, var5));
      var2.add(var5, "West");
      this.add(var2, "North");
      this.a_JPanel_1 = DoomsdayGUI.b_JPanel_2();
      this.a_JPanel_1.setLayout(new BoxLayout(this.a_JPanel_1, 1));
      this.a_fd_3 = new UITheme(this.a_JPanel_1);
      this.a_fd_3.getVerticalScrollBar().setUnitIncrement(8);
      this.a_fd_3.setBackground(new Color(45, 45, 46));
      new C_gt(this).start();
      this.a_fd_3.getViewport().setBackground(new Color(45, 45, 46));
      this.add(this.a_fd_3, "Center");
      VersionManager.d.add(new C_gv(this));
      VersionManager.c_ArrayList_1.add(new C_gy(this));
      VersionManager.b_ArrayList_3.add(new C_ha(this));
      VersionManager.a_ArrayList_5.add(new C_hc(this));
   }

   public final void a(ClientVersion var1, int var2) {
      JLabel var3;
      (var3 = this.a_a.a_JLabel(var1.b_String)).setHorizontalAlignment(0);
      String var4 = Integer.toString(var1.a() / 1024);
      JLabel var11;
      (var11 = this.a_a.a_JLabel(var4 + " KB")).setHorizontalAlignment(0);
      JLabel var5;
      if (var1.a_arr_byte_4 != null) {
         (var5 = this.a_a.a_JLabel("Delete")).setForeground(new Color(255, 120, 104));
      } else if (var1.a_File_5 != null) {
         (var5 = this.a_a.a_JLabel("Delete")).setForeground(new Color(255, 120, 104));
      } else {
         (var5 = this.a_a.a_JLabel("Download")).setForeground(new Color(124, 180, 255));
      }

      Font var6 = var5.getFont();
      Font var7;
      if (!a_bool_4) {
         Map var8;
         (var8 = var5.getFont().getAttributes()).put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
         var7 = new Font(var8);
      } else {
         var7 = var6;
      }

      var5.setHorizontalAlignment(0);
      JPanel var9 = DoomsdayGUI.a((LayoutManager)(new GridLayout(1, 3, 2, 0)));
      this.b = !this.b;
      if (this.b) {
         var9.setBackground(new Color(55, 55, 57));
      } else {
         var9.setBackground(new Color(49, 49, 51));
      }

      var9.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
      var9.setMinimumSize(new Dimension(Integer.MAX_VALUE, 35));
      var9.setPreferredSize(new Dimension(119, 35));
      JPanel var13;
      (var13 = DoomsdayGUI.a((LayoutManager)(new BorderLayout()))).setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
      var13.setBorder(null);
      JPanel var10;
      (var10 = new JPanel()).setPreferredSize(new Dimension(0, 0));
      var10.setBackground(Color.green);
      var13.add(var10, "West");
      C_hg var14 = new C_hg(var1, var9, var11, var5, var13, var10);
      var9.add(var3);
      var9.add(var11);
      var9.add(var5);
      this.a_JPanel_1.add(var9, var2 << 1);
      this.a_JPanel_1.add(var13, (var2 << 1) + 1);
      this.a_HashMap_5.put(var1.b_String, var14);
      var5.addMouseListener(new C_he(this, var5, var1, var14, var6, var7));
   }

   static HashMap a(VersionSelectPanel var0) {
      return var0.a_HashMap_5;
   }
}
