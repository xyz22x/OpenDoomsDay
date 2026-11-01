import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class C_df implements ActionListener {
   private ProcessSelectPanel a;

   C_df(ProcessSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      this.a.a_void_2();
   }
}
