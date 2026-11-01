public final class ProcessEntry implements Comparable {
   public final String a_String;
   private String b;
   public final long a_long_1;
   public final boolean a_bool_2;

   ProcessEntry(String var1, String var2, long var3, boolean var5) {
      this.a_String = var1;
      this.b = var2;
      this.a_long_1 = var3;
      this.a_bool_2 = var5;
   }

   @Override
   public final String toString() {
      return this.a_bool_2
         ? "static " + this.b + ' ' + this.a_String + " @ 0x" + Long.toHexString(this.a_long_1)
         : this.b + ' ' + this.a_String + " @ " + this.a_long_1;
   }

   @Override
   public final int compareTo(Object var1) {
      ProcessEntry var2 = (ProcessEntry)var1;
      if (this.a_bool_2 != var2.a_bool_2) {
         return this.a_bool_2 ? -1 : 1;
      } else {
         return Long.compare(this.a_long_1, var2.a_long_1);
      }
   }
}
