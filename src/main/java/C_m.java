import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_m implements ActionListener {
   private C_i a;

   C_m(C_i var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.a_u.a_dy_6.setEnabled(true);
      this.a.a_u.b_dy.setEnabled(true);
      this.a.a_u.a_a_9.a_ex_10.a_cr_1.a_dy_1.setEnabled(DoomsdayGUI.a_bool_5());
   }
}
