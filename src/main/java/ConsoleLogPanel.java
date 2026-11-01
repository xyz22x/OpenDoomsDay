import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class ConsoleLogPanel extends JPanel {
   public final JTextField a_JTextField;
   private C_dy a_dy_1;

   public ConsoleLogPanel(LayoutManager var1, JTextField var2, C_dy var3) {
      super(var1);
      this.a_JTextField = var2;
      this.a_dy_1 = var3;
   }

   @Override
   public final void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.a_JTextField.setEnabled(var1);
      this.a_dy_1.setEnabled(var1);
   }

   public final void a(String var1) {
      this.a_JTextField.setText(var1);
   }
}
