import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

public final class C_bp implements ActionListener {
   protected TitleBarPanel a_cr;
   protected volatile InjectionTask a_cu_1;
   protected volatile C_ir a_ir_2;
   protected volatile CustomDialogBase a_bb_3;

   public C_bp(TitleBarPanel var1) {
      this.a_cr = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      VersionTabPanel var7 = this.a_cr.a_a.a_ex_10.a_u_2;
      this.a_cr.a_a.a_ex_10.a_u_2.a_dy_6.setEnabled(false);
      var7.b_dy.setEnabled(false);
      this.a_cr.a_dy_1.setEnabled(false);

      try {
         ArrayList var2 = new ArrayList(3);

         for (Object var3_raw : DoomsdayGUI.a_a_3.a_gd_13.a_List_1) { TargetProcess var3 = (TargetProcess)var3_raw;
            C_cc var5;
            if ((var5 = (C_cc)this.a_cr.a_a.a_ex_10.a_u_2.a_a_9.a_gd_13.a_HashMap.get(var3.a_int)) != null && var5.a_int_1 > 0) {
               String var8;
               if (var5.a_int_1 == 1) {
                  var8 = "You have already injected " + var3 + " once. Do you want to inject again?";
               } else if (var5.a_int_1 == 2) {
                  var8 = "You have already injected " + var3 + " twice. Do you want to inject again?";
               } else {
                  if (var5.a_int_1 == 25) {
                     this.a_cr.a_a.a("Please, stop! I don't know what can happen...", "Please...");
                     return;
                  }

                  if (var5.a_int_1 == 28) {
                     this.a_cr.a_a.a("Are you shure?", "Too much");
                     return;
                  }

                  if (var5.a_int_1 == 30) {
                     return;
                  }

                  if (var5.a_int_1 == 32) {
                     this.a_cr.a_a.a("Dude?", "Too much");
                     return;
                  }

                  if (var5.a_int_1 == 35) {
                     this.a_cr.a_a.a("Ok. Do whatever you want", "Toooo much");
                     return;
                  }

                  var8 = "You have already injected " + var3 + " " + var5.a_int_1 + " times. Do you want to inject again?";
               }

               if (var8 != null) {
                  this.a_cr.a_a.a(var8, "Warn", new C_bq(var2, var3), null);
               }
            } else {
               var2.add(var3);
            }
         }

         if (var2.size() > 0) {
            this.a(var2, false);
         } else {
            this.a_cr.a_dy_1.setEnabled(false);
            this.a_cr.a_a.a_ex_10.a_u_2.a_dy_6.setEnabled(true);
            var7.b_dy.setEnabled(true);
            new C_by(this).start();
         }
      } catch (Exception var6) {
         var6.printStackTrace();
         this.a_cr.a_dy_1.setEnabled(DoomsdayGUI.a_bool_5());
         this.a_cr.a_a.a_ex_10.a_u_2.a_dy_6.setEnabled(true);
         var7.b_dy.setEnabled(true);
      }
   }

   private void a(Iterator var1, boolean var2) {
      if (var1.hasNext()) {
         int var3 = ((TargetProcess)var1.next()).a_int;
         VersionTabPanel var4 = this.a_cr.a_a.a_ex_10.a_u_2;
         DoomsdayGUI var5 = this.a_cr.a_a.a_ex_10.a_u_2.a_a_9;
         C_cc var6 = (C_cc)this.a_cr.a_a.a_ex_10.a_u_2.a_a_9.a_gd_13.a_HashMap.get(var3);
         ProcessInfo var7;
         String var8;
         if ((var7 = var5.a_gd_13.a_fo(var3)) != null) {
            var8 = var7.b_String_1;
         } else {
            var8 = null;
         }

         if (this.a_bb_3 == null) {
            this.a_bb_3 = var4.a_a_9.a("", "", 5, true);
            this.a_bb_3.a().setDefaultCloseOperation(0);
            this.a_bb_3.a().setAlwaysOnTop(true);
            this.a_bb_3.a_dy().setVisible(false);
            this.a_bb_3.a_dy().removeActionListener(this.a_bb_3.a_dy().getActionListeners()[0]);
            this.a_bb_3.a_dy().addActionListener(new C_br(this, var1, var2));
         }

         DialogStatusCallback var9 = new DialogStatusCallback(this, var6, var1, var2);
         this.a_bb_3.a_JTextArea_2().setText("Starting...");
         this.a_cu_1 = new JvmtiInjectTask(var4, var1, var9, var2, var3, var8);
         this.a_ir_2 = new C_bw(this, var4, var1, var9);
         this.a_cu_1.start();
         this.a_ir_2.start();
      }
   }

   private void a(ArrayList var1, boolean var2) {
      this.a_bb_3 = null;
      Iterator var3 = var1.iterator();
      this.a(var3, var2);
   }

   static void a(C_bp var0, Iterator var1, boolean var2) {
      var0.a(var1, var2);
   }

   static void a(C_bp var0, ArrayList var1) {
      var0.a(var1, true);
   }
}
