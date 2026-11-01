import java.io.DataOutputStream;
import java.io.IOException;

public final class GuiStatusCallback extends InjectionCallback {
   private DataOutputStream a;

   public GuiStatusCallback(DataOutputStream var1) {
      this.a = var1;
   }

   @Override
   public final void a(String var1, Throwable var2) {
      try {
         this.a.writeByte(2);
         if (var1 != null) {
            this.a.writeUTF(var1);
         } else {
            this.a.writeUTF("");
         }

         if (var2 != null) {
            this.a.writeUTF(var2.getMessage());
         } else {
            this.a.writeUTF("");
         }

         this.a.flush();
      } catch (IOException var3) {
         throw new RuntimeException(var3);
      }
   }

   @Override
   public final void a(long var1) {
      try {
         this.a.writeByte(3);
         this.a.writeLong(var1);
         this.a.flush();
      } catch (IOException var3) {
         throw new RuntimeException(var3);
      }
   }

   @Override
   public final void a() {
   }

   @Override
   public final void b() {
   }
}
