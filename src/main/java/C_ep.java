import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_ep implements ActionListener {
   private MainContentPanel a;

   C_ep(MainContentPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.a_dy_4.setEnabled(false);
      new C_eq(this).start();
      new C_es(this).start();
   }

   static MainContentPanel a(C_ep var0) {
      return var0.a;
   }
}
