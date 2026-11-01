import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class C_dr extends ArrayList implements C_ds, C_dv {
   public static void a(Collection var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else {
         boolean var2 = true;
         Iterator var4 = var0.iterator();
         var1.write(91);

         while (var4.hasNext()) {
            if (var2) {
               var2 = false;
            } else {
               var1.write(44);
            }

            Object var3;
            if ((var3 = var4.next()) == null) {
               var1.write("null");
            } else {
               NativeBinaryManager.a(var3, var1);
            }
         }

         var1.write(93);
      }
   }

   @Override
   public final void a(Writer var1) throws IOException {
      a(this, var1);
   }

   private static String a(Collection var0) {
      StringWriter var1 = new StringWriter();

      try {
         a(var0, var1);
         return var1.toString();
      } catch (IOException var2) {
         throw new RuntimeException(var2);
      }
   }

   public static void a(byte[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[");
         var1.write(String.valueOf(var0[0]));

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write(",");
            var1.write(String.valueOf(var0[var2]));
         }

         var1.write("]");
      }
   }

   public static void a(short[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[");
         var1.write(String.valueOf(var0[0]));

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write(",");
            var1.write(String.valueOf(var0[var2]));
         }

         var1.write("]");
      }
   }

   public static void a(int[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[");
         var1.write(String.valueOf(var0[0]));

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write(",");
            var1.write(String.valueOf(var0[var2]));
         }

         var1.write("]");
      }
   }

   public static void a(long[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[");
         var1.write(String.valueOf(var0[0]));

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write(",");
            var1.write(String.valueOf(var0[var2]));
         }

         var1.write("]");
      }
   }

   public static void a(float[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[");
         var1.write(String.valueOf(var0[0]));

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write(",");
            var1.write(String.valueOf(var0[var2]));
         }

         var1.write("]");
      }
   }

   public static void a(double[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[");
         var1.write(String.valueOf(var0[0]));

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write(",");
            var1.write(String.valueOf(var0[var2]));
         }

         var1.write("]");
      }
   }

   public static void a(boolean[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[");
         var1.write(String.valueOf(var0[0]));

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write(",");
            var1.write(String.valueOf(var0[var2]));
         }

         var1.write("]");
      }
   }

   public static void a(char[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[\"");
         var1.write(String.valueOf(var0[0]));

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write("\",\"");
            var1.write(String.valueOf(var0[var2]));
         }

         var1.write("\"]");
      }
   }

   public static void a(Object[] var0, Writer var1) throws IOException {
      if (var0 == null) {
         var1.write("null");
      } else if (var0.length == 0) {
         var1.write("[]");
      } else {
         var1.write("[");
         NativeBinaryManager.a(var0[0], var1);

         for (int var2 = 1; var2 < var0.length; var2++) {
            var1.write(",");
            NativeBinaryManager.a(var0[var2], var1);
         }

         var1.write("]");
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
