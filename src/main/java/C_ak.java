import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

final class C_ak implements ListSelectionListener {
   private VersionTabPanel a;

   C_ak(VersionTabPanel var1) {
      this.a = var1;
   }

   @Override
   public final void valueChanged(ListSelectionEvent var1) {
      this.a.a_dy_6.setEnabled(this.a.a_JTable_3.getSelectedRow() != -1 && !this.a.a_bool);
      this.a.b_dy.setEnabled(this.a.a_JTable_3.getSelectedRow() != -1 && !this.a.a_bool);
      this.a.a_JTextField_8.setText("");
      this.a.a_JScrollPane_7.repaint();
      if (this.a.a_JTable_3.getSelectedRow() >= 0) {
         ProcessInfo var2 = (ProcessInfo)this.a.a_JTable_3.getValueAt(this.a.a_JTable_3.getSelectedRow(), 0);
         this.a.a_JTextField_8.setText(Integer.toString(var2.b_int));
      }
   }
}
