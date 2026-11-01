import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

public class C_dx {
   public static long a() {
      try {
         return ((OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
      } catch (Throwable var0) {
         return 0L;
      }
   }
}
