import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

final class C_an extends JFormattedTextField {
   C_an(AbstractFormatter var1) {
      super(var1);
   }

   @Override
   public final void setCaretPosition(int var1) {
      super.setCaretPosition(this.getText().length());
   }
}
