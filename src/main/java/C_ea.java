import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;

public final class C_ea extends MetalComboBoxUI {
   public int a = -1;

   public C_ea() {
      this.currentValuePane = new C_eb(this);
   }

   public final JButton a_JButton() {
      return this.arrowButton;
   }

   public final C_fc a() {
      return (C_fc)this.popup;
   }

   public final ComboPopup a_ComboPopup_2() {
      return this.popup;
   }

   public final JList a_JList_3() {
      return this.listBox;
   }

   @Override
   public final void paintCurrentValueBackground(Graphics var1, Rectangle var2, boolean var3) {
   }

   @Override
   protected final ComboPopup createPopup() {
      return new C_fc(this.comboBox);
   }

   static JComboBox a(C_ea var0) {
      return var0.comboBox;
   }
}
