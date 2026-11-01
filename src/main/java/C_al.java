import java.awt.Color;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

final class C_al implements AncestorListener {
   private VersionTabPanel a;

   C_al(VersionTabPanel var1) {
      this.a = var1;
   }

   @Override
   public final void ancestorRemoved(AncestorEvent var1) {
   }

   @Override
   public final void ancestorMoved(AncestorEvent var1) {
   }

   @Override
   public final void ancestorAdded(AncestorEvent var1) {
      if (this.a.a_JTable_3.getTableHeader().getParent() != null) {
         this.a.a_JTable_3.getTableHeader().getParent().setBackground(new Color(45, 45, 46));
      }
   }
}
