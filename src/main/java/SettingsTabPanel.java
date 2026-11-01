import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public final class SettingsTabPanel extends JPanel {
   final C_dy a_dy;
   final C_dy b;
   final C_dy c;
   public final TitleBarPanel a_cr_1;
   public final VersionTabPanel a_u_2;
   public final ProcessSelectPanel a_cw_3;
   public final VersionSelectPanel a_gp_4;
   final C_dy d;
   final DoomsdayGUI a_a_5;
   JButton a_JButton_6;

   public SettingsTabPanel(DoomsdayGUI var1) {
      this.a_a_5 = var1;
      this.a_u_2 = new VersionTabPanel(var1);
      this.a_cw_3 = new ProcessSelectPanel(var1);
      this.a_gp_4 = new VersionSelectPanel(var1);
      this.a_cr_1 = new TitleBarPanel(var1);
      this.setLayout(new BorderLayout());
      JPanel var2;
      (var2 = new JPanel(new GridLayout(1, 3))).setBackground(new Color(29, 29, 31));
      this.b = new C_dy();
      this.b.b_Color = new Color(29, 29, 31);
      this.b.a_Color = new Color(29, 29, 31);
      this.b.setBorder(BorderFactory.createEmptyBorder());
      this.b.f = new Color(90, 90, 90);
      this.b.g = new Color(100, 100, 100);
      this.b.h = Color.WHITE;
      this.b.j = new Color(130, 130, 130);
      this.b.setText("Inject");
      this.b.setFont(new Font(var1.a_Font_12.getName(), 0, (int)(var1.a_Font_12.getSize() * 1.3)));
      this.b.a_int_2 = 0;
      this.b.addActionListener(new C_ct(this));
      var2.add(this.b);
      this.c = new C_dy();
      this.c.b_Color = new Color(29, 29, 31);
      this.c.a_Color = new Color(29, 29, 31);
      this.c.setBorder(BorderFactory.createEmptyBorder());
      this.c.f = new Color(90, 90, 90);
      this.c.g = new Color(100, 100, 100);
      this.c.h = Color.WHITE;
      this.c.j = new Color(130, 130, 130);
      this.c.setText("Advanced inject");
      this.c.setFont(new Font(var1.a_Font_12.getName(), 0, (int)(var1.a_Font_12.getSize() * (PlatformUtil.k() ? 1.0 : 1.3))));
      this.c.a_int_2 = 0;
      this.c.addActionListener(new C_t(this));
      var2.add(this.c);
      this.a_dy = new C_dy();
      this.a_dy.b_Color = new Color(29, 29, 31);
      this.a_dy.a_Color = new Color(29, 29, 31);
      this.a_dy.setBorder(BorderFactory.createEmptyBorder());
      this.a_dy.f = new Color(90, 90, 90);
      this.a_dy.g = new Color(100, 100, 100);
      this.a_dy.h = Color.WHITE;
      this.a_dy.j = new Color(130, 130, 130);
      this.a_dy.setFont(new Font(var1.a_Font_12.getName(), 0, (int)(var1.a_Font_12.getSize() * 1.3)));
      this.a_dy.a_int_2 = 0;
      this.a_dy.setText("Install");
      this.a_dy.addActionListener(new C_do(this));
      var2.add(this.a_dy);
      this.d = new C_dy();
      this.d.b_Color = new Color(29, 29, 31);
      this.d.a_Color = new Color(29, 29, 31);
      this.d.setBorder(BorderFactory.createEmptyBorder());
      this.d.f = new Color(90, 90, 90);
      this.d.g = new Color(100, 100, 100);
      this.d.h = Color.WHITE;
      this.d.j = new Color(130, 130, 130);
      this.d.setFont(new Font(var1.a_Font_12.getName(), 0, (int)(var1.a_Font_12.getSize() * 1.3)));
      this.d.a_int_2 = 0;
      this.d.setText("Updates");
      this.d.addActionListener(new C_hh(this));
      var2.add(this.d);
      JPanel var3 = new JPanel(new BorderLayout());
      this.a_JButton_6 = new JButton();
      this.a_JButton_6.setIcon(C_bo.a);
      this.a_JButton_6.setContentAreaFilled(false);
      this.a_JButton_6.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      this.a_JButton_6.addActionListener(new C_ey(var1));
      this.a_JButton_6.addMouseListener(new C_ez(this));
      this.a_JButton_6.setToolTipText("Settings");
      this.a_JButton_6.setFocusable(false);
      var3.add(this.a_JButton_6, "East");
      var3.setBackground(new Color(29, 29, 31));
      var3.add(var2);
      this.add(var3, "North");
      if (var1.a_au_9.d_String().equals("install")) {
         this.a_dy.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 100, 255)));
         this.c.setBorder(BorderFactory.createEmptyBorder());
         this.d.setBorder(BorderFactory.createEmptyBorder());
         this.b.setBorder(BorderFactory.createEmptyBorder());
         this.add(this.a_cw_3, "Center");
         this.a_cw_3.a_void_2();
      } else if (var1.a_au_9.d_String().equals("updates")) {
         this.d.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 100, 255)));
         this.a_dy.setBorder(BorderFactory.createEmptyBorder());
         this.c.setBorder(BorderFactory.createEmptyBorder());
         this.b.setBorder(BorderFactory.createEmptyBorder());
         this.add(this.a_gp_4, "Center");
      } else if (var1.a_au_9.d_String().equals("advinject")) {
         this.c.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 100, 255)));
         this.a_dy.setBorder(BorderFactory.createEmptyBorder());
         this.d.setBorder(BorderFactory.createEmptyBorder());
         this.b.setBorder(BorderFactory.createEmptyBorder());
         this.add(this.a_u_2, "Center");
      } else {
         this.b.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 100, 255)));
         this.c.setBorder(BorderFactory.createEmptyBorder());
         this.a_dy.setBorder(BorderFactory.createEmptyBorder());
         this.d.setBorder(BorderFactory.createEmptyBorder());
         this.add(this.a_cr_1, "Center");
      }

      this.setBackground(new Color(45, 45, 46));
   }
}
