import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class C_ga implements DocumentListener {
   @Override
   public final void changedUpdate(DocumentEvent var1) {
      this.a();
   }

   @Override
   public final void removeUpdate(DocumentEvent var1) {
      this.a();
   }

   @Override
   public final void insertUpdate(DocumentEvent var1) {
      this.a();
   }

   public abstract void a();
}
