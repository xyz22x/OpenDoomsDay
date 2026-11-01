import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

final class C_dg implements ActionListener {
   private ProcessSelectPanel a;

   C_dg(ProcessSelectPanel var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      C_dn var4 = (C_dn)this.a.a_JComboBox_3.getSelectedItem();
      C_dn[] var2;
      if ((var2 = this.a.a()) == null) {
         this.a.a_JComboBox_3.setModel(new DefaultComboBoxModel<>(FileUtils.a((Object[])(new C_dn[0]))));
      } else {
         this.a.a_JComboBox_3.setModel(new DefaultComboBoxModel<>(FileUtils.a((Object[])var2)));

         for (int var5 = 0; var5 < this.a.a_JComboBox_3.getItemCount(); var5++) {
            C_dn var3 = (C_dn)this.a.a_JComboBox_3.getItemAt(var5);
            if (var4 != null && var3.a_String_1.equals(var4.a_String_1)) {
               this.a.a_JComboBox_3.setSelectedIndex(var5);
               break;
            }
         }
      }

      this.a.a_void_2();
   }
}
