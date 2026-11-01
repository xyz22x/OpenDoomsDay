import java.awt.Font;

final class C_bz implements Runnable {
   private C_by a;

   C_bz(C_by var1) {
      this.a = var1;
   }

   @Override
   public final void run() {
      C_by.a(this.a).a_cr.a_dy_1.setText("Wait for minecraft...");
      C_by.a(this.a).a_cr.a_dy_1.setFont(new Font(DoomsdayGUI.a_a_3.a_Font_12.getName(), 1, (int)(DoomsdayGUI.a_a_3.a_Font_12.getSize() * 1.4)));
   }
}
