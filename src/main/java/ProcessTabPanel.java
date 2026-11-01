import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public final class ProcessTabPanel extends JPanel {
   final C_dy a_dy;
   final C_dy b;
   final AdvancedSettingsPanel a_cd_1;
   public final MainContentPanel a_eg_2;

   public ProcessTabPanel(DoomsdayGUI var1) {
      this.setBackground(new Color(45, 45, 46));
      this.setLayout(new BorderLayout());
      JButton var2 = new JButton();
      byte[] var3 = NativeBinaryManager.a_arr_byte(
         "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgEAQAAACJ4248AAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAAAGAAAABgAPBrQs8AAAAHdElNRQflChAKLiczblY+AAAAu0lEQVRYw+2WOQ6DMBBFx+nhBO5oEMsd6IGLwA2h4QZItFD6DCzN/BRREmUpUkSeKJrXuHxvxi5MpCgfAg5DIEmE5NYC8wwwA0XhX87LAgDAugJpKjA5AOw7UJYqV7nKv40BW0s0DGSiiIiZ0DRk+t7P5M4ZYJqI8tzXxI8B43gSEV8xzK9XQG1L1HV+NuDc5Xx+hFxV3rehEe8jjuNHIupaI2Qjbl+ybQNnmeAmBD6l94ggAOJYRK78NWd0F0dRBt8ouwAAACV0RVh0ZGF0ZTpjcmVhdGUAMjAyMS0xMC0xNlQxMDo0NjozOSswMDowMJE7O1AAAAAldEVYdGRhdGU6bW9kaWZ5ADIwMjEtMTAtMTZUMTA6NDY6MzkrMDA6MDDgZoPsAAAAAElFTkSuQmCC"
      );
      byte[] var4 = NativeBinaryManager.a_arr_byte(
         "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAEaSURBVFhH7ZYxDoIwFIZbFhISBi5hTGDgIDqq8QYODp5EBxPPYNRNb8CqA4GglyCQsIN95MVErODQPhe+pf1Z/o+0vMB6en4lSZJhFEVLjMowcG0ljuNRmqb3PM+3YRju8LESOgWgPMuyM0ZmGMYDt0rguEppltu2vfd9f45RCV8FKMoBqQBVOfAhQFkOvAlQlwMvgX+UA7XAv8oB3iy3LOtqmuYGo1Zc1z3xIAgqzORwzqufRrFOZEdwE0ewxqiV+ghgI7mEB3EJZxi10vYZkkh0DSLtEm8CALXEhwAgkTgKiSlGpUgFACqJrwIAhUTrIPI87+I4zhgjK4piIn5MVxiV0DkJmxJlWQ5wS4v4LR+It19g7OlRBGNPjs+yI8530YMAAAAASUVORK5CYII="
      );
      byte[] var5 = NativeBinaryManager.a_arr_byte(
         "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAEdSURBVFhH7ZY/boMwFIftCAHiBiBYUQ+Tjm2UG3To0JO0Q6ScIWqypcdo53Zg5M8JADG5fugpEmAgg/1Y+Bb7x/L7kM0TbGXlXoqieMiy7BWjNja4TpLn+bYsy9+6rg9pmh7xsRZmBaC8qqorRsY5/8OtFjiuSvrlruuewjDcY9TCqABFOaAUoCoHBgKU5UBHgLocuAksUQ60AkuVA7xfbtv2t2VZHxiN4vv+hSdJIjAvgbhrFJtEdQQ/8gjeMRqlPQLYKC7hp7yEO4xGmfoMSSTmBpFxiY4AQC0xEAD6Eo7jnKMoesaoFaUAQCUxKgBQSEwOoiAIvjzPe8TImqZ5kj+mbxi1MDsJ+xJCiBi3tMjf8li+/QvGlRVNMPYPHiiz1iipuGUAAAAASUVORK5CYII="
      );
      ImageIcon var7 = new ImageIcon(var3);
      ImageIcon var9 = new ImageIcon(var4);
      ImageIcon var10 = new ImageIcon(var5);
      var2.setIcon(var7);
      var2.addMouseListener(new C_fs(var2, var10, var9, var7));
      var2.setBorder(new EmptyBorder(5, 5, 5, 5));
      var2.setContentAreaFilled(false);
      var2.setFocusable(false);
      var2.addActionListener(new C_ft(var1));
      JPanel var8;
      (var8 = new JPanel(new BorderLayout())).add(var2, "West");
      var8.setBackground(new Color(29, 29, 31));
      JPanel var6;
      (var6 = new JPanel(new GridLayout(1, 2))).setBackground(new Color(29, 29, 31));
      var8.add(var6);
      this.a_dy = new C_dy();
      this.a_dy.b_Color = new Color(29, 29, 31);
      this.a_dy.a_Color = new Color(29, 29, 31);
      this.a_dy.setBorder(BorderFactory.createEmptyBorder());
      this.a_dy.f = new Color(90, 90, 90);
      this.a_dy.g = new Color(100, 100, 100);
      this.a_dy.h = Color.WHITE;
      this.a_dy.j = new Color(130, 130, 130);
      this.a_dy.setText("Inject settings");
      this.a_dy.setFont(new Font(var1.a_Font_12.getName(), 0, (int)(var1.a_Font_12.getSize() * 1.4)));
      this.a_dy.a_int_2 = 0;
      this.a_dy.addActionListener(new C_fu(this));
      var6.add(this.a_dy);
      this.b = new C_dy();
      this.b.b_Color = new Color(29, 29, 31);
      this.b.a_Color = new Color(29, 29, 31);
      this.b.setBorder(BorderFactory.createEmptyBorder());
      this.b.f = new Color(90, 90, 90);
      this.b.g = new Color(100, 100, 100);
      this.b.h = Color.WHITE;
      this.b.j = new Color(130, 130, 130);
      this.b.setFont(new Font(var1.a_Font_12.getName(), 0, (int)(var1.a_Font_12.getSize() * 1.4)));
      this.b.a_int_2 = 0;
      this.b.setText("Loader settings");
      this.b.setBackground(Color.white);
      this.b.addActionListener(new C_fv(this));
      var6.add(this.b);
      this.a_dy.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 100, 255)));
      this.b.setBorder(BorderFactory.createEmptyBorder());
      this.add(var8, "North");
      this.a_cd_1 = new AdvancedSettingsPanel(var1);
      DoomsdayGUI.a((JPanel)this.a_cd_1);
      this.add(this.a_cd_1, "Center");
      this.a_eg_2 = new MainContentPanel(var1);
      DoomsdayGUI.a((JPanel)this.a_eg_2);
   }
}
