import java.awt.Dimension;
import java.util.Iterator;

final class DialogStatusCallback extends InjectionCallback {
   private C_bp a_bp;
   private final C_cc a_cc_1;
   private final Iterator a_Iterator_2;
   private final boolean b;

   DialogStatusCallback(C_bp var1, C_cc var2, Iterator var3, boolean var4) {
      this.a_bp = var1;
      this.a_cc_1 = var2;
      this.a_Iterator_2 = var3;
      this.b = var4;
   }

   @Override
   public final void a(long var1) {
      this.a_bp.a_ir_2.interrupt();
      if (var1 == 55555L) {
         System.out.println("Minecraft restarted successfully!");
         this.a_bp.a_bb_3.a_JTextArea_2().setText("Restarted successfully!");
         this.a_bp.a_bb_3.a(4);
         if (this.a_cc_1 != null) {
            this.a_cc_1.a_int_1++;
         }

         this.a_bp.a_bb_3.a_void_3();
      } else if (var1 != 0L) {
         System.out.println(ErrorCodeUtil.a((int)var1));
         this.a_bp.a_bb_3.a().setDefaultCloseOperation(2);
         this.a_bp.a_bb_3.a_JTextArea_2().setText(ErrorCodeUtil.a((int)var1));
         this.a_bp.a_bb_3.a(1);
         if (this.a_cc_1 != null) {
            this.a_cc_1.b_int_1++;
         }

         this.a_bp.a_bb_3.a_dy().setVisible(true);
         if (this.a_Iterator_2.hasNext()) {
            this.a_bp.a_bb_3.a_dy().setText("Continue");
            this.a_bp.a_bb_3.a_dy().setPreferredSize(new Dimension(90, 30));
         } else {
            this.a_bp.a_bb_3.a_dy().setText("OK");
            this.a_bp.a_bb_3.a_dy().setPreferredSize(new Dimension(70, 30));
         }
      } else {
         System.out.println("DoomsDay loaded successfully!");
         this.a_bp.a_bb_3.a_JTextArea_2().setText("DoomsDay loaded successfully!");
         this.a_bp.a_bb_3.a(4);
         if (this.a_cc_1 != null) {
            this.a_cc_1.a_int_1++;
         }

         if (this.a_Iterator_2.hasNext()) {
            C_bp.a(this.a_bp, this.a_Iterator_2, this.b);
         } else {
            this.a_bp.a_bb_3.a().setDefaultCloseOperation(2);
            this.a_bp.a_bb_3.a_dy().setVisible(true);
            this.a_bp.a_bb_3.a_dy().setText("OK");
            this.a_bp.a_bb_3.a_dy().setPreferredSize(new Dimension(70, 30));
            this.a_bp.a_bb_3.a_void_3();
         }
      }
   }

   @Override
   public final void a(String var1, Throwable var2) {
      if (var2 instanceof C_iy) {
         this.a_bp.a_bb_3.a(1);
         this.a_bp.a_bb_3.a().setDefaultCloseOperation(2);
         if (this.a_cc_1 != null) {
            this.a_cc_1.b_int_1++;
         }

         this.a_bp.a_bb_3.a_dy().setVisible(true);
         if (!C_eu.a(GamePathUtils.a_String_2()) && !GamePathUtils.a()) {
            this.a_bp.a_bb_3.a_JTextArea_2().setText("Shellcode injection on MacOS requires a java patch for debug permissions or SIP disabling.");
            this.a_bp.a_bb_3.a_dy().setText("Patch java");
            this.a_bp.a_bb_3.a_dy().setPreferredSize(new Dimension(145, 35));
            FileUtils.a(this.a_bp.a_bb_3.a_dy());
            this.a_bp.a_bb_3.a_dy().addActionListener(new C_bt());
         } else if (DoomsdayGUI.a_bool_2) {
            this.a_bp.a_bb_3.a_JTextArea_2().setText("The patch was successful, but you need to restart your computer");
         } else {
            System.out.println("EVERYTHING NORMAL?");
            this.a_bp.a_bb_3.a_JTextArea_2().setText(var2.getMessage().substring(5));
            var2.printStackTrace();
         }

         this.a_bp.a_ir_2.interrupt();
      } else {
         if (var2 != null) {
            this.a_bp.a_bb_3.a(1);
            this.a_bp.a_bb_3.a().setDefaultCloseOperation(2);
            this.a_bp.a_ir_2.interrupt();
            if (this.a_cc_1 != null) {
               this.a_cc_1.b_int_1++;
            }

            this.a_bp.a_bb_3.a_dy().setVisible(true);
            if (this.a_Iterator_2.hasNext()) {
               this.a_bp.a_bb_3.a_dy().setText("Continue");
               this.a_bp.a_bb_3.a_dy().setPreferredSize(new Dimension(90, 30));
            } else {
               this.a_bp.a_bb_3.a_dy().setText("OK");
               this.a_bp.a_bb_3.a_dy().setPreferredSize(new Dimension(70, 30));
            }
         }

         if (var1 != null && var2 != null) {
            System.out.println(var1 + " " + var2.getMessage());
            this.a_bp.a_bb_3.a_JTextArea_2().setText(var1 + " " + var2.getMessage());
         } else if (var1 != null) {
            System.out.println(var1);
            this.a_bp.a_bb_3.a_JTextArea_2().setText(var1);
         } else {
            if (var2 != null) {
               System.out.println("Error: " + var2.getMessage());
               this.a_bp.a_bb_3.a_JTextArea_2().setText("Error: " + var2.getMessage());
            }
         }
      }
   }

   @Override
   public final void a() {
      this.a_bp.a_ir_2.a = true;
   }

   @Override
   public final void b() {
      this.a_bp.a_ir_2.a = false;
   }
}
