import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

final class C_ag extends DefaultTableModel {
   C_ag(Object[] var1) {
      super(var1, 0);
   }

   @Override
   public final Class getColumnClass(int var1) {
      if (var1 == 1) {
         return JLabel.class;
      } else if (var1 == 2) {
         return Integer.class;
      } else if (var1 == 3) {
         return String.class;
      } else if (var1 == 4) {
         return String.class;
      } else if (var1 == 5) {
         return String.class;
      } else {
         return var1 == 6 ? Long.class : Object.class;
      }
   }
}
