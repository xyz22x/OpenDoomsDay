import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

final class C_br implements ActionListener {
   private C_bp a_bp;
   private final Iterator a_Iterator_1;
   private final boolean a_bool_2;

   C_br(C_bp var1, Iterator var2, boolean var3) {
      this.a_bp = var1;
      this.a_Iterator_1 = var2;
      this.a_bool_2 = var3;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a_bp.a_bb_3.a().setDefaultCloseOperation(0);
      if (this.a_bp.a_bb_3.a_dy().getText().equals("Continue")) {
         C_bp.a(this.a_bp, this.a_Iterator_1, this.a_bool_2);
      } else {
         this.a_bp.a_bb_3.a().dispose();
      }
   }
}
