import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class C_fw implements ActionListener {
   private VersionTabPanel a_u;
   private int a_int_1;

   public C_fw(VersionTabPanel var1) {
      this.a_u = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      int var4;
      if ((var4 = this.a_u.a_JComboBox_2.getSelectedIndex()) != this.a_int_1) {
         synchronized (VersionTabPanel.a_Object_1) {
            VersionTabPanel.a_Object_1.notify();
         }

         if (var4 == 0) {
            this.a_u.a_a_9.a_au_9.b("java");
         } else if (var4 == 1) {
            this.a_u.a_a_9.a_au_9.b("all");
         }
      }

      this.a_int_1 = var4;
   }
}
