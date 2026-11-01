import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_gq implements ActionListener {
   private final C_dy a;

   C_gq(C_dy var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      new C_gr(this.a).start();
   }
}
