import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

final class C_bq implements ActionListener {
   private final ArrayList a_ArrayList;
   private final TargetProcess a_fb_1;

   C_bq(ArrayList var1, TargetProcess var2) {
      this.a_ArrayList = var1;
      this.a_fb_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_ArrayList.add(this.a_fb_1);
   }
}
