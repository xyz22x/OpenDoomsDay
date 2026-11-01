import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.text.NumberFormatter;

final class C_en extends NumberFormatter {
   C_en(NumberFormat var1) {
      super(var1);
   }

   @Override
   public final Object stringToValue(String var1) throws ParseException {
      return var1.isEmpty() ? null : super.stringToValue(var1);
   }
}
