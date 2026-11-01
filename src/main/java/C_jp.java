import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

final class C_jp implements ActionListener {
   private final JComboBox a;

   C_jp(JComboBox var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.setBackground(new Color(60, 60, 61));
   }
}
