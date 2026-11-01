import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class C_kg {
   private static Method a_Method;
   private static final ClassLoader a_ClassLoader_1;
   private static boolean a_bool_2;

   static {
      if (System.getProperty("os.name").toLowerCase().contains("windows")) {
         String var0 = System.getProperty("java.vm.name").contains("Client VM") ? "/bin/client/jvm.dll" : "/bin/server/jvm.dll";

         try {
            System.load(System.getProperty("java.home") + var0);
         } catch (UnsatisfiedLinkError var2) {
            throw new RuntimeException("Cannot find jvm.dll. Unsupported JVM?");
         }

         a_ClassLoader_1 = C_kg.class.getClassLoader();
      } else {
         a_ClassLoader_1 = null;
      }

      try {
         (a_Method = ClassLoader.class.getDeclaredMethod("findNative", ClassLoader.class, String.class)).setAccessible(true);
         a_bool_2 = true;
      } catch (Throwable var1) {
      }
   }

   public static boolean a() {
      return a_bool_2;
   }

   public static long a(String var0) {
      if (!a_bool_2) {
         return 0L;
      } else {
         try {
            return (Long)a_Method.invoke(null, a_ClassLoader_1, var0);
         } catch (InvocationTargetException var1) {
            throw new RuntimeException(var1.getTargetException());
         } catch (IllegalAccessException var2) {
            throw new RuntimeException(var2);
         }
      }
   }
}
