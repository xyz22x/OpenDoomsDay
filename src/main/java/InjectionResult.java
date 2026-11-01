import java.io.OutputStream;

public final class InjectionResult extends OutputStream {
   public final StringBuilder a = new StringBuilder();

   @Override
   public final void write(int var1) {
      this.a.append((char)var1);
   }
}
