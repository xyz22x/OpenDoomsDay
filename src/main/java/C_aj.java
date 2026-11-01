import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;

final class C_aj extends RowFilter {
   private final JTextField a;

   C_aj(JTextField var1) {
      this.a = var1;
   }

   @Override
   public final boolean include(Entry var1) {
      if (this.a.getText().isEmpty()) {
         return true;
      } else {
         String var2 = var1.getValue(2).toString();
         String var3 = ((String)var1.getValue(3)).toLowerCase();
         String var7 = ((String)var1.getValue(4)).toLowerCase();
         String[] var4 = this.a.getText().toLowerCase().split(" ");

         for (int var5 = 0; var5 < var4.length; var5++) {
            String var6 = var4[var5];
            if (!var2.contains(var6) && !var3.contains(var6) && !var7.contains(var6)) {
               return false;
            }
         }

         return true;
      }
   }
}
