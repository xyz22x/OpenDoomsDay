import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SortOrder;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public final class C_fz extends DefaultTableCellRenderer implements javax.swing.plaf.UIResource {
   private boolean a_bool;
   private static volatile int[] a_arr_int_1;

   public C_fz() {
      this.setHorizontalAlignment(0);
   }

   @Override
   public final void setHorizontalTextPosition(int var1) {
      this.a_bool = true;
      super.setHorizontalTextPosition(var1);
   }

   @Override
   public final Component getTableCellRendererComponent(JTable var1, Object var2, boolean var3, boolean var4, int var5, int var6) {
      C_as var9 = null;
      var4 = false;
      if (var1 != null) {
         JTableHeader var13;
         if ((var13 = var1.getTableHeader()) != null) {
            Color var11 = null;
            Color var7 = null;
            if (var11 == null) {
               var11 = var13.getForeground();
            }

            if (var7 == null) {
               var7 = var13.getBackground();
            }

            this.setForeground(var11);
            this.setBackground(var7);
            this.setFont(var13.getFont());
            var4 = var13.isPaintingForPrint();
         }

         if (!var4 && var1.getRowSorter() != null) {
            if (!this.a_bool) {
               this.setHorizontalTextPosition(10);
            }

            SortOrder var14 = null;
            SortOrder var10000;
            if (var1 != null && var1.getRowSorter() != null) {
               List var8;
               if ((var8 = var1.getRowSorter().getSortKeys()).size() > 0 && ((SortKey)var8.get(0)).getColumn() == var1.convertColumnIndexToModel(var6)) {
                  var14 = ((SortKey)var8.get(0)).getSortOrder();
               }

               var10000 = var14;
            } else {
               var10000 = var14;
            }

            SortOrder var12 = var10000;
            if (var10000 != null) {
               switch (a()[var12.ordinal()]) {
                  case 1:
                     var9 = new C_as(true);
                     break;
                  case 2:
                     var9 = new C_as(false);
                     break;
                  case 3:
                     var9 = null;
               }
            }
         }
      }

      this.setText(var2 == null ? "" : var2.toString());
      this.setIcon(var9);
      if (var6 == 0) {
         this.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.white));
      } else if (var6 == var1.getColumnCount()) {
         this.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.white));
      }

      return this;
   }

   private static int[] a() {
      if (a_arr_int_1 != null) {
         return a_arr_int_1;
      } else {
         int[] var0 = new int[SortOrder.values().length];

         try {
            var0[SortOrder.ASCENDING.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SortOrder.DESCENDING.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[SortOrder.UNSORTED.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
         }

         a_arr_int_1 = var0;
         return var0;
      }
   }
}
