import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_l implements ActionListener {
   private C_i a_i;
   private final int a_int_1;

   C_l(C_i var1, int var2) {
      this.a_i = var1;
      this.a_int_1 = var2;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      C_i.a(this.a_i, this.a_int_1);
   }
}
