import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

final class C_jl implements WindowStateListener {
   private final DoomsdayGUI a_a;
   private final ClientConfig a_au_1;

   C_jl(DoomsdayGUI var1, ClientConfig var2) {
      this.a_a = var1;
      this.a_au_1 = var2;
   }

   @Override
   public final void windowStateChanged(WindowEvent var1) {
      if (this.a_a.getExtendedState() == 6) {
         this.a_au_1.a(true);
      } else {
         this.a_au_1.a(false);
      }
   }
}
