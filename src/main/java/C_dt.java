import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class C_dt extends LinkedHashMap implements C_ds, C_dv {
   public C_dt() {
   }

   public C_dt(Map var1) {
      super(var1);
   }

   public static void a(Map var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else {
         boolean var2 = true;
         Iterator var4 = var0.entrySet().iterator();
         var1.write(123);

         while (var4.hasNext()) {
            if (var2) {
               var2 = false;
            } else {
               var1.write(44);
            }

            Entry var3 = (Entry)var4.next();
            var1.write(34);
            var1.write(NativeBinaryManager.a(String.valueOf(var3.getKey())));
            var1.write(34);
            var1.write(58);
            NativeBinaryManager.a(var3.getValue(), var1);
         }

         var1.write(125);
      }
   }

   @Override
   public final void a(Writer var1) throws IOException {
      a(this, var1);
   }

   public static String a(Map var0) {
      StringWriter var1 = new StringWriter();

      try {
         a(var0, var1);
         return var1.toString();
      } catch (IOException var2) {
         throw new RuntimeException(var2);
      }
   }

   @Override
   public final String a() {
      return a(this);
   }

   @Override
   public final String toString() {
      return a(this);
   }
}
