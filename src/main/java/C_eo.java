import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;

final class C_eo extends JFormattedTextField {
   C_eo(AbstractFormatter var1) {
      super(var1);
   }

   @Override
   public final void setCaretPosition(int var1) {
      super.setCaretPosition(this.getText().length());
   }
}
