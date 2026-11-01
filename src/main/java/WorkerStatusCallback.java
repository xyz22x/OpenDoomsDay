import java.awt.Dimension;

final class WorkerStatusCallback extends InjectionCallback {
   private C_i a_i;
   private final CustomDialogBase a_bb_1;
   private final C_cc a_cc_2;

   WorkerStatusCallback(C_i var1, CustomDialogBase var2, C_cc var3) {
      this.a_i = var1;
      this.a_bb_1 = var2;
      this.a_cc_2 = var3;
   }

   @Override
   public final synchronized void a(long var1) {
      if (var1 == 55555L) {
         System.out.println("Minecraft restarted successfully!");
         this.a_bb_1.a_JTextArea_2().setText("Restarted successfully!");
         this.a_bb_1.a(4);
         if (this.a_cc_2 != null) {
            this.a_cc_2.a_int_1++;
         }

         this.a_bb_1.a_void_3();
      } else if (var1 != 0L) {
         System.out.println(ErrorCodeUtil.a((int)var1));
         this.a_bb_1.a_JTextArea_2().setText(ErrorCodeUtil.a((int)var1));
         this.a_bb_1.a(1);
         if (this.a_cc_2 != null) {
            this.a_cc_2.b_int_1++;
         }
      } else {
         System.out.println("DoomsDay loaded successfully!");
         this.a_bb_1.a_JTextArea_2().setText("DoomsDay loaded successfully!");
         this.a_bb_1.a(4);
         if (this.a_cc_2 != null) {
            this.a_cc_2.a_int_1++;
         }

         this.a_bb_1.a_void_3();
      }

      this.a_bb_1.a().setDefaultCloseOperation(2);
      this.a_i.a_ir_2.interrupt();
      this.a_bb_1.a_dy().setVisible(true);
   }

   @Override
   public final synchronized void a(String var1, Throwable var2) {
      if (var2 instanceof C_iy) {
         this.a_bb_1.a(1);
         this.a_bb_1.a().setDefaultCloseOperation(2);
         if (this.a_cc_2 != null) {
            this.a_cc_2.b_int_1++;
         }

         this.a_bb_1.a_dy().setVisible(true);
         if (!C_eu.a(GamePathUtils.a_String_2()) && !GamePathUtils.a()) {
            this.a_bb_1.a_JTextArea_2().setText("Shellcode injection on MacOS requires a java patch for debug permissions or SIP disabling.");
            this.a_bb_1.a_dy().setText("Patch java");
            this.a_bb_1.a_dy().setPreferredSize(new Dimension(145, 35));
            FileUtils.a(this.a_bb_1.a_dy());
            this.a_bb_1.a_dy().addActionListener(new C_o());
         } else if (DoomsdayGUI.a_bool_2) {
            this.a_bb_1.a_JTextArea_2().setText("The patch was successful, but you need to restart your computer");
         } else {
            this.a_bb_1.a_JTextArea_2().setText(var2.getMessage().substring(5));
            var2.printStackTrace();
         }

         this.a_i.a_ir_2.interrupt();
      } else {
         if (var2 != null) {
            this.a_bb_1.a(1);
            this.a_bb_1.a().setDefaultCloseOperation(2);
            this.a_i.a_ir_2.interrupt();
            if (this.a_cc_2 != null) {
               this.a_cc_2.b_int_1++;
            }

            this.a_bb_1.a_dy().setVisible(true);
         }

         if (var1 != null && var2 != null) {
            System.out.println(var1 + " " + var2.getMessage());
            this.a_bb_1.a_JTextArea_2().setText(var1 + " " + var2.getMessage());
         } else if (var1 != null) {
            System.out.println(var1);
            this.a_bb_1.a_JTextArea_2().setText(var1);
         } else {
            if (var2 != null) {
               System.out.println("Error: " + var2.getMessage());
               this.a_bb_1.a_JTextArea_2().setText("Error: " + var2.getMessage());
            }
         }
      }
   }

   @Override
   public final void a() {
      this.a_i.a_ir_2.a = true;
   }

   @Override
   public final void b() {
      this.a_i.a_ir_2.a = false;
   }
}
