import java.util.Comparator;

final class VersionComparator implements Comparator {
   @Override
   public final int compare(Object var1, Object var2) {
      ClientVersion a = (ClientVersion)var1;
      ClientVersion b = (ClientVersion)var2;
      int var5 = b.a_int_1;
      int var4 = a.a_int_1;
      return -(a.a_int_1 < var5 ? -1 : (var4 == var5 ? 0 : 1));
   }
}
