import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public final class C_bg implements ActionListener {
   private JTextField a;

   public C_bg(JTextField var1) {
      this.a = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      JFileChooser var3;
      (var3 = new JFileChooser()).setFileSelectionMode(1);
      File var2;
      if (!this.a.getText().isEmpty() && (var2 = new File(this.a.getText()).getParentFile()) != null && var2.exists()) {
         var3.setCurrentDirectory(var2);
      }

      if (var3.showOpenDialog(DoomsdayGUI.a_a_3) == 0) {
         this.a.setText(var3.getSelectedFile().getAbsolutePath());
      }
   }
}
