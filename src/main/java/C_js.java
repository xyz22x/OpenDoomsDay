import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

final class C_js implements ListSelectionListener {
   private final C_ea a;

   C_js(C_ea var1) {
      this.a = var1;
   }

   @Override
   public final void valueChanged(ListSelectionEvent var1) {
      this.a.a().a().repaint();
   }
}
