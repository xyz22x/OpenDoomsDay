import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboPopup;

public final class C_fc extends BasicComboPopup {
   public C_fc(JComboBox var1) {
      super(var1);
   }

   public final UITheme a() {
      return (UITheme)this.scroller;
   }

   @Override
   protected final JScrollPane createScroller() {
      UITheme var1;
      (var1 = new UITheme(this.list, (byte)0)).setHorizontalScrollBar(null);
      return var1;
   }
}
