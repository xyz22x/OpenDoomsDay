import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import sun.misc.Unsafe;

public class WinMemoryManager implements MemoryAccessor {
   private static int a_int;
   private JvmUtil a_kf_1 = JvmUtil.a_kf();
   private Unsafe a_Unsafe_2 = C_kd.a_Unsafe;
   private boolean a_bool_3;
   private static long a_long_4;
   private long b;
   private long c;
   private static long d;
   private static long e;

   static {
      String var0 = "arm64";
      String var1 = "aarch64";
      String var2 = "x86_64";
      String var3 = "amd64";
      String var4 = "x86";
      String var5 = "x86_32";
      String var6 = "i386";
      String var7 = "i486";
      String var8 = "i586";
      String var9 = "i686";
      String var10;
      if ((var10 = System.getProperty("os.arch").toLowerCase()).equals(var0) || var10.equals(var1)) {
         a_int = 2;
      } else if (var10.equals(var2) || var10.equals(var3)) {
         a_int = 0;
      } else if (!var10.equals(var4) && !var10.equals(var5) && !var10.equals(var6) && !var10.equals(var7) && !var10.equals(var8) && !var10.equals(var9)) {
         a_int = -1;
      } else {
         a_int = 1;
      }
   }

   private static boolean a() {
      return a_int == 2;
   }

   private static boolean b_bool() {
      return a_int == 1;
   }

   private static boolean c() {
      return a_int == 0;
   }

   public static int a_int() {
      return (int)Double.parseDouble(System.getProperty("java.class.version")) - 44;
   }

   private long a(Class var1) {
      return C_kd.a_Unsafe.getLong(var1, this.a_kf_1.a_long_1);
   }

   private long a(long var1, int var3) {
      long var4 = this.a_Unsafe_2.getAddress(var1 + this.a_kf_1.b);
      int var6 = this.a_Unsafe_2.getInt(var4);
      if (var3 >= 0 && var3 < var6) {
         return this.a_Unsafe_2.getAddress(var4 + this.a_kf_1.c + var3 * this.a_kf_1.a_int);
      } else {
         throw new IndexOutOfBoundsException(Integer.toString(var3));
      }
   }

   private static void a(Class var0, StringBuilder var1) {
      while (var0.isArray()) {
         var1.append('[');
         var0 = var0.getComponentType();
      }

      if (var0.isPrimitive()) {
         char var2;
         if (var0 == int.class) {
            var2 = 'I';
         } else if (var0 == void.class) {
            var2 = 'V';
         } else if (var0 == boolean.class) {
            var2 = 'Z';
         } else if (var0 == byte.class) {
            var2 = 'B';
         } else if (var0 == char.class) {
            var2 = 'C';
         } else if (var0 == short.class) {
            var2 = 'S';
         } else if (var0 == double.class) {
            var2 = 'D';
         } else if (var0 == float.class) {
            var2 = 'F';
         } else {
            if (var0 != long.class) {
               throw new AssertionError();
            }

            var2 = 'J';
         }

         var1.append(var2);
      } else {
         var1.append('L').append(var0.getName().replace('.', '/')).append(';');
      }
   }

   private long a_long_2() {
      Method[] var1 = WinMemoryManager.class.getDeclaredMethods();
      Method var2 = null;

      for (int var3 = 0; var3 < var1.length; var3++) {
         if (Modifier.isStatic(var1[var3].getModifiers())
            && var1[var3].getParameterCount() == 1
            && var1[var3].getParameters()[0].getType() == long.class
            && var1[var3].getReturnType() == long.class) {
            var2 = var1[var3];
            break;
         }
      }

      System.out.println("Method ".concat(String.valueOf(var2)));

      try {
         long var5 = this.a(var2.getDeclaringClass());
         Field var33;
         (var33 = var2.getClass().getDeclaredField("slot")).setAccessible(true);
         int var31 = var33.getInt(var2);
         return this.a(var5, var31);
      } catch (Throwable var27) {
         WinMemoryManager var28 = this;
         long var7 = this.a(var2.getDeclaringClass());
         long var9;
         long var11 = (var9 = this.a_Unsafe_2.getAddress(var7 + this.a_kf_1.j)) + this.a_kf_1.k;
         int var34 = this.a_Unsafe_2.getInt(var9);
         long var13 = this.a_kf_1.l;
         long var15 = this.a_kf_1.m;
         long var17 = this.a_kf_1.n;
         long var19 = this.a_kf_1.o;

         for (int var10 = 0; var10 < var34; var10++) {
            long var21 = var28.a_Unsafe_2.getAddress(var11 + var10 * var28.a_kf_1.a_int);
            long var23 = var28.a_Unsafe_2.getAddress(var21 + var13);
            long var25 = var28.a_Unsafe_2.getAddress(var23 + var15);
            int var29 = var28.a_Unsafe_2.getShort(var23 + var17) & '\uffff';
            int var4 = var28.a_Unsafe_2.getShort(var23 + var19) & '\uffff';
            String var30 = var28.a_String(var25 + var28.a_kf_1.p + var29 * var28.a_kf_1.a_int);
            String var32 = var28.a_String(var25 + var28.a_kf_1.p + var4 * var28.a_kf_1.a_int);
            if (var30.equals(var2.getName())) {
               StringBuilder var35;
               (var35 = new StringBuilder()).append('(');
               Class[] var37;
               int var24 = (var37 = var2.getParameterTypes()).length;

               for (int var36 = 0; var36 < var24; var36++) {
                  a(var37[var36], var35);
               }

               var35.append(')');
               a(var2.getReturnType(), var35);
               if (var32.equals(var35.toString())) {
                  return var28.a(var7, var10);
               }
            }
         }

         return 0L;
      }
   }

   private byte[] a(long var1, byte[] var3) {
      long var4 = this.a_Unsafe_2.getAddress(var1 + this.a_kf_1.h);
      this.a_Unsafe_2.getAddress(var1 + this.a_kf_1.d);
      this.a_Unsafe_2.getAddress(var1 + this.a_kf_1.e);
      long var6 = this.a_Unsafe_2.getAddress(var1 + this.a_kf_1.f);
      if (!this.a_bool_3) {
         this.a_bool_3 = true;
      }

      long var8;
      if (var4 == 0L) {
         var8 = var6;
         long var10 = 0L;
         boolean var12 = false;

         for (int var5 = 0; var5 < 1048576; var5++) {
            if (this.a_Unsafe_2.getByte(var6 + var5) == 0) {
               if (!var12) {
                  var12 = true;
                  var10 = var6 + var5;
               }
            } else if (var12) {
               var12 = false;
               if (var6 + var5 - var10 > 8192L) {
                  var8 = var10 + 4096L;
                  break;
               }
            }
         }
      } else {
         var8 = this.a_Unsafe_2.getAddress(var4 + this.a_kf_1.i);
      }

      this.a_Unsafe_2.putAddress(var1 + this.a_kf_1.d, var8);
      this.a_Unsafe_2.putAddress(var1 + this.a_kf_1.e, var8);
      this.a_Unsafe_2.putAddress(var1 + this.a_kf_1.f, var8);
      int var15;
      byte[] var11 = new byte[var15 = var3.length];

      for (int var13 = 0; var13 < var15; var13++) {
         var11[var13] = this.a_Unsafe_2.getByte(var8);
         byte var14 = var3[var13];
         this.a_Unsafe_2.putByte(var8, var14);
         var8++;
      }

      return var11;
   }

   public static void main(String[] var0) throws Exception {
      System.out.println("Started");
      WinMemoryManager var5;
      long var2 = (var5 = new WinMemoryManager()).a(0L, 4096L, 4096);
      var5.a(var2, 0L);
      var2 = var5.a(0L, 4096L, 4096);
      System.out.println("Allocated at " + Long.toHexString(var2));
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      DataOutputStream var4 = new DataOutputStream(var1);
      BinaryBufferWriter.a(8, var5.b, var4);
      BinaryBufferWriter.a(0, var2, var4);
      BinaryBufferWriter.a(1, 0L, var4);
      BinaryBufferWriter.a(2, 32768L, var4);
      var4.write(0);
      var4.write(1);
      var4.write(31);
      var4.write(214);
      byte[] var6 = var1.toByteArray();
      var5.a(var2, var6, var6.length);
      boolean var7 = var5.a(var2, 4096L, null);
      System.out.println("Protected ".concat(String.valueOf(var7)));
      System.out.println(Long.toHexString(var2) + " invoke " + Long.toHexString(var5.a_long(var2, 0L)));
      System.out.println("Finish ");
      Thread.sleep(500000L);
   }

   @Override
   public final void a(long var1, byte[] var3, int var4) {
      int var5 = 0;

      for (int var6 = 0; var6 < var4; var6++) {
         this.a_Unsafe_2.putByte(var1 + var5, var3[var6]);
         var5++;
      }
   }

   @Override
   public final void b(long var1, byte[] var3, int var4) {
      int var5 = 0;

      for (int var6 = 0; var6 < var4; var6++) {
         var3[var6] = this.a_Unsafe_2.getByte(var1 + var5);
         var5++;
      }
   }

   private long b() {
      try {
         Class[] var10001 = new Class[]{long.class};
         long var1 = this.a_long_2();
         if (b_bool()) {
            byte[] var10 = new byte[]{100, -95, 48, 0, 0, 0, -61};
            var10 = this.a(var1, var10);
            int var13 = (int)a_long_2(0L);
            this.a(var1, var10);
            return var13;
         } else if (c()) {
            byte[] var8 = new byte[]{101, 72, -117, 4, 37, 96, 0, 0, 0, -61};
            var8 = this.a(var1, var8);
            long var12 = a_long_2(0L);
            this.a(var1, var8);
            return var12;
         } else if (a()) {
            byte[] var3 = new byte[]{-24, 3, 18, -86, 0, 49, 64, -7, -64, 3, 95, -42, -13, 83, -67, -87};
            var3 = this.a(var1, var3);
            long var4 = a_long_2(0L);
            this.a(var1, var3);
            return var4;
         } else {
            return 0L;
         }
      } catch (Exception var6) {
         throw new RuntimeException(var6);
      }
   }

   @Override
   public final long a_long(long var1, long var3) {
      int[] var5 = new int[1];
      long var6 = b_bool() ? this.b_long(var1, var3, var5) : (c() ? this.a_long(var1, var3, var5) : (a() ? this.c_long(var1, var3, var5) : 0L));
      if (b_bool()) {
         this.a(var6);
      } else if (c()) {
         this.c(var6);
      } else if (a()) {
         this.b_int(var6);
      }

      return 0L;
   }

   @Override
   public final boolean a(long var1, long var3) {
      if (b_bool()) {
         return this.b(var1, var3);
      } else if (c()) {
         return this.d(var1, var3);
      } else {
         return a() ? this.c(var1, var3) : false;
      }
   }

   @Override
   public final boolean a(long var1, long var3, int[] var5) {
      if (b_bool()) {
         return this.b(var1, var3, var5);
      } else if (c()) {
         return this.d(var1, var3, var5);
      } else {
         return a() ? this.c(var1, var3, var5) : false;
      }
   }

   @Override
   public final long a(long var1, long var3, int var5) {
      if (b_bool()) {
         return this.d(var1, var3, var5);
      } else if (c()) {
         return this.c(var1, var3, var5);
      } else {
         return a() ? this.b(var1, var3, var5) : 0L;
      }
   }

   private int a(long var1) {
      if (a_long_4 == 0L) {
         long var3 = this.a("kernel32.dll");
         a_long_4 = this.a(var3, "WaitForSingleObject");
      }

      try {
         ByteArrayOutputStream var12 = new ByteArrayOutputStream();
         DataOutputStream var4;
         (var4 = new DataOutputStream(var12)).write(104);
         var4.writeInt(Integer.reverseBytes(-1));
         var4.write(104);
         var4.writeInt(Integer.reverseBytes((int)var1));
         var4.write(184);
         var4.writeInt(Integer.reverseBytes((int)a_long_4));
         var4.write(255);
         var4.write(208);
         var4.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var5 = this.a_long_2();
         byte[] var10 = var12.toByteArray();
         byte[] var11 = this.a(var5, var10);
         long var7 = a_long_2(0L);
         this.a(var5, var11);
         return (int)var7;
      } catch (Exception var9) {
         var9.printStackTrace();
         return -1;
      }
   }

   private int b_int(long var1) {
      if (a_long_4 == 0L) {
         long var3 = this.a("kernel32.dll");
         a_long_4 = this.a(var3, "WaitForSingleObject");
      }

      try {
         ByteArrayOutputStream var12 = new ByteArrayOutputStream();
         DataOutputStream var4;
         (var4 = new DataOutputStream(var12)).write(254);
         var4.write(15);
         var4.write(31);
         var4.write(248);
         BinaryBufferWriter.a(8, a_long_4, var4);
         BinaryBufferWriter.a(0, var1, var4);
         BinaryBufferWriter.a(1, -1L, var4);
         var4.write(0);
         var4.write(1);
         var4.write(63);
         var4.write(214);
         var4.write(254);
         var4.write(7);
         var4.write(65);
         var4.write(248);
         var4.write(192);
         var4.write(3);
         var4.write(95);
         var4.write(214);
         Class[] var10001 = new Class[]{long.class};
         long var5 = this.a_long_2();
         byte[] var10 = var12.toByteArray();
         byte[] var11 = this.a(var5, var10);
         long var7 = a_long_2(0L);
         this.a(var5, var11);
         return (int)var7;
      } catch (Exception var9) {
         var9.printStackTrace();
         return 0;
      }
   }

   private int c(long var1) {
      if (a_long_4 == 0L) {
         long var3 = this.a("kernel32.dll");
         a_long_4 = this.a(var3, "WaitForSingleObject");
      }

      try {
         ByteArrayOutputStream var12 = new ByteArrayOutputStream();
         DataOutputStream var4;
         (var4 = new DataOutputStream(var12)).write(72);
         var4.write(131);
         var4.write(236);
         var4.write(40);
         var4.write(72);
         var4.write(184);
         var4.writeLong(Long.reverseBytes(a_long_4));
         var4.write(72);
         var4.write(185);
         var4.writeLong(Long.reverseBytes(var1));
         var4.write(72);
         var4.write(186);
         var4.writeLong(Long.reverseBytes(-1L));
         var4.write(255);
         var4.write(208);
         var4.write(72);
         var4.write(131);
         var4.write(196);
         var4.write(40);
         var4.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var5 = this.a_long_2();
         byte[] var10 = var12.toByteArray();
         byte[] var11 = this.a(var5, var10);
         long var7 = a_long_2(60L);
         this.a(var5, var11);
         return (int)var7;
      } catch (Exception var9) {
         var9.printStackTrace();
         return -1;
      }
   }

   private boolean b(long var1, long var3) {
      if (this.b == 0L) {
         long var5 = this.a("kernel32.dll");
         this.b = this.a(var5, "VirtualFree");
      }

      try {
         ByteArrayOutputStream var14 = new ByteArrayOutputStream();
         DataOutputStream var6;
         (var6 = new DataOutputStream(var14)).write(104);
         var6.writeInt(Integer.reverseBytes(32768));
         var6.write(104);
         var6.writeInt(Integer.reverseBytes((int)var3));
         var6.write(104);
         var6.writeInt(Integer.reverseBytes((int)var1));
         var6.write(184);
         var6.writeInt(Integer.reverseBytes((int)this.b));
         var6.write(255);
         var6.write(208);
         var6.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var7 = this.a_long_2();
         byte[] var12 = var14.toByteArray();
         byte[] var13 = this.a(var7, var12);
         long var9 = a_long_2(0L);
         this.a(var7, var13);
         return (int)var9 == 1;
      } catch (Exception var11) {
         var11.printStackTrace();
         return false;
      }
   }

   private boolean c(long var1, long var3) {
      if (this.b == 0L) {
         long var5 = this.a("kernel32.dll");
         this.b = this.a(var5, "VirtualFree");
      }

      try {
         ByteArrayOutputStream var14 = new ByteArrayOutputStream();
         DataOutputStream var6;
         (var6 = new DataOutputStream(var14)).write(254);
         var6.write(15);
         var6.write(31);
         var6.write(248);
         BinaryBufferWriter.a(8, this.b, var6);
         BinaryBufferWriter.a(0, var1, var6);
         BinaryBufferWriter.a(1, var3, var6);
         BinaryBufferWriter.a(2, 32768L, var6);
         var6.write(0);
         var6.write(1);
         var6.write(63);
         var6.write(214);
         var6.write(254);
         var6.write(7);
         var6.write(65);
         var6.write(248);
         var6.write(192);
         var6.write(3);
         var6.write(95);
         var6.write(214);
         Class[] var10001 = new Class[]{long.class};
         long var7 = this.a_long_2();
         byte[] var12 = var14.toByteArray();
         byte[] var13 = this.a(var7, var12);
         long var9 = a_long_2(0L);
         this.a(var7, var13);
         return var9 == 1L;
      } catch (Exception var11) {
         var11.printStackTrace();
         return false;
      }
   }

   private boolean d(long var1, long var3) {
      if (this.b == 0L) {
         long var5 = this.a("kernel32.dll");
         this.b = this.a(var5, "VirtualFree");
      }

      try {
         ByteArrayOutputStream var14 = new ByteArrayOutputStream();
         DataOutputStream var6;
         (var6 = new DataOutputStream(var14)).write(72);
         var6.write(131);
         var6.write(236);
         var6.write(40);
         var6.write(72);
         var6.write(184);
         var6.writeLong(Long.reverseBytes(this.b));
         var6.write(72);
         var6.write(185);
         var6.writeLong(Long.reverseBytes(var1));
         var6.write(72);
         var6.write(186);
         var6.writeLong(Long.reverseBytes(var3));
         var6.write(73);
         var6.write(184);
         var6.writeLong(Long.reverseBytes(32768L));
         var6.write(255);
         var6.write(208);
         var6.write(72);
         var6.write(131);
         var6.write(196);
         var6.write(40);
         var6.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var7 = this.a_long_2();
         byte[] var12 = var14.toByteArray();
         byte[] var13 = this.a(var7, var12);
         long var9 = a_long_2(60L);
         this.a(var7, var13);
         return var9 == 1L;
      } catch (Exception var11) {
         var11.printStackTrace();
         return false;
      }
   }

   private boolean b(long var1, long var3, int[] var5) {
      if (this.c == 0L) {
         long var7 = this.a("kernel32.dll");
         this.c = this.a(var7, "VirtualProtect");
      }

      long var17 = this.a_Unsafe_2.allocateMemory(8L);

      try {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var9;
         (var9 = new DataOutputStream(var6)).write(104);
         var9.writeInt(Integer.reverseBytes((int)var17));
         var9.write(104);
         var9.writeInt(Integer.reverseBytes(32));
         var9.write(104);
         var9.writeInt(Integer.reverseBytes((int)var3));
         var9.write(104);
         var9.writeInt(Integer.reverseBytes((int)var1));
         var9.write(184);
         var9.writeInt(Integer.reverseBytes((int)this.c));
         var9.write(255);
         var9.write(208);
         var9.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var10 = this.a_long_2();
         byte[] var15 = var6.toByteArray();
         byte[] var16 = this.a(var10, var15);
         long var12 = a_long_2(0L);
         this.a(var10, var16);
         if (var5 != null) {
            var5[0] = this.a_Unsafe_2.getInt(var17);
         }

         this.a_Unsafe_2.freeMemory(var17);
         return var12 == 1L;
      } catch (Exception var14) {
         var14.printStackTrace();
         return false;
      }
   }

   private boolean c(long var1, long var3, int[] var5) {
      if (this.c == 0L) {
         long var7 = this.a("kernel32.dll");
         this.c = this.a(var7, "VirtualProtect");
      }

      long var17 = this.a_Unsafe_2.allocateMemory(8L);

      try {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var9;
         (var9 = new DataOutputStream(var6)).write(254);
         var9.write(15);
         var9.write(31);
         var9.write(248);
         BinaryBufferWriter.a(8, this.c, var9);
         BinaryBufferWriter.a(0, var1, var9);
         BinaryBufferWriter.a(1, var3, var9);
         BinaryBufferWriter.a(2, 32L, var9);
         BinaryBufferWriter.a(3, var17, var9);
         var9.write(0);
         var9.write(1);
         var9.write(63);
         var9.write(214);
         var9.write(254);
         var9.write(7);
         var9.write(65);
         var9.write(248);
         var9.write(192);
         var9.write(3);
         var9.write(95);
         var9.write(214);
         Class[] var10001 = new Class[]{long.class};
         long var10 = this.a_long_2();
         byte[] var15 = var6.toByteArray();
         byte[] var16 = this.a(var10, var15);
         long var12 = a_long_2(0L);
         this.a(var10, var16);
         if (var5 != null) {
            var5[0] = this.a_Unsafe_2.getInt(var17);
         }

         this.a_Unsafe_2.freeMemory(var17);
         return var12 == 1L;
      } catch (Exception var14) {
         var14.printStackTrace();
         return false;
      }
   }

   private boolean d(long var1, long var3, int[] var5) {
      if (this.c == 0L) {
         long var7 = this.a("kernel32.dll");
         this.c = this.a(var7, "VirtualProtect");
      }

      long var17 = this.a_Unsafe_2.allocateMemory(8L);

      try {
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var9;
         (var9 = new DataOutputStream(var6)).write(72);
         var9.write(131);
         var9.write(236);
         var9.write(40);
         var9.write(72);
         var9.write(184);
         var9.writeLong(Long.reverseBytes(this.c));
         var9.write(72);
         var9.write(185);
         var9.writeLong(Long.reverseBytes(var1));
         var9.write(72);
         var9.write(186);
         var9.writeLong(Long.reverseBytes(var3));
         var9.write(73);
         var9.write(199);
         var9.write(192);
         var9.writeInt(Integer.reverseBytes(32));
         var9.write(73);
         var9.write(185);
         var9.writeLong(Long.reverseBytes(var17));
         var9.write(255);
         var9.write(208);
         var9.write(72);
         var9.write(131);
         var9.write(196);
         var9.write(40);
         var9.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var10 = this.a_long_2();
         byte[] var15 = var6.toByteArray();
         byte[] var16 = this.a(var10, var15);
         long var12 = a_long_2(0L);
         this.a(var10, var16);
         if (var5 != null) {
            var5[0] = this.a_Unsafe_2.getInt(var17);
         }

         this.a_Unsafe_2.freeMemory(var17);
         return var12 == 1L;
      } catch (Exception var14) {
         var14.printStackTrace();
         return false;
      }
   }

   private long b(long var1, long var3, int var5) {
      if (d == 0L) {
         long var6 = this.a("kernel32.dll");
         d = this.a(var6, "VirtualAlloc");
      }

      try {
         System.out.println(d);
         ByteArrayOutputStream var15 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var15)).write(254);
         var7.write(15);
         var7.write(31);
         var7.write(248);
         BinaryBufferWriter.a(8, d, var7);
         BinaryBufferWriter.a(0, var1, var7);
         BinaryBufferWriter.a(1, var3, var7);
         BinaryBufferWriter.a(2, var5, var7);
         BinaryBufferWriter.a(3, 4L, var7);
         var7.write(0);
         var7.write(1);
         var7.write(63);
         var7.write(214);
         var7.write(254);
         var7.write(7);
         var7.write(65);
         var7.write(248);
         var7.write(192);
         var7.write(3);
         var7.write(95);
         var7.write(214);
         Class[] var10001 = new Class[]{long.class};
         long var8 = this.a_long_2();
         byte[] var13 = var15.toByteArray();
         byte[] var14 = this.a(var8, var13);
         long var10 = a_long_2(0L);
         this.a(var8, var14);
         return var10;
      } catch (Exception var12) {
         var12.printStackTrace();
         return 0L;
      }
   }

   private long a_long(long var1, long var3, int[] var5) {
      if (e == 0L) {
         long var8 = this.a("kernel32.dll");
         e = this.a(var8, "CreateThread");
      }

      try {
         long var17 = this.a_Unsafe_2.allocateMemory(8L);
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var6)).write(72);
         var7.write(131);
         var7.write(236);
         var7.write(56);
         var7.write(72);
         var7.write(184);
         var7.writeLong(Long.reverseBytes(var17));
         var7.write(72);
         var7.write(137);
         var7.write(68);
         var7.write(36);
         var7.write(40);
         var7.write(72);
         var7.write(184);
         var7.writeLong(Long.reverseBytes(e));
         var7.write(72);
         var7.write(185);
         var7.writeLong(Long.reverseBytes(0L));
         var7.write(72);
         var7.write(186);
         var7.writeLong(Long.reverseBytes(0L));
         var7.write(73);
         var7.write(184);
         var7.writeLong(Long.reverseBytes(var1));
         var7.write(73);
         var7.write(185);
         var7.writeLong(Long.reverseBytes(var3));
         var7.write(199);
         var7.write(68);
         var7.write(36);
         var7.write(32);
         var7.writeInt(Integer.reverseBytes(0));
         var7.write(255);
         var7.write(208);
         var7.write(72);
         var7.write(131);
         var7.write(196);
         var7.write(56);
         var7.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var10 = this.a_long_2();
         byte[] var15 = var6.toByteArray();
         byte[] var16 = this.a(var10, var15);
         long var12 = a_long_2(0L);
         var5[0] = this.a_Unsafe_2.getInt(var17);
         this.a_Unsafe_2.freeMemory(var17);
         this.a(var10, var16);
         return var12;
      } catch (Exception var14) {
         var14.printStackTrace();
         return 0L;
      }
   }

   private long b_long(long var1, long var3, int[] var5) {
      if (e == 0L) {
         long var6 = this.a("kernel32.dll");
         e = this.a(var6, "CreateThread");
      }

      try {
         ByteArrayOutputStream var17 = new ByteArrayOutputStream();
         DataOutputStream var7 = new DataOutputStream(var17);
         long var8 = this.a_Unsafe_2.allocateMemory(8L);
         var7.write(104);
         var7.writeInt(Integer.reverseBytes((int)var8));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes(0));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes((int)var3));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes((int)var1));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes(0));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes(0));
         var7.write(184);
         var7.writeInt(Integer.reverseBytes((int)e));
         var7.write(255);
         var7.write(208);
         var7.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var10 = this.a_long_2();
         byte[] var15 = var17.toByteArray();
         byte[] var16 = this.a(var10, var15);
         long var12 = a_long_2(0L);
         this.a(var10, var16);
         var5[0] = this.a_Unsafe_2.getInt(var8);
         this.a_Unsafe_2.freeMemory(var8);
         return (int)var12;
      } catch (Exception var14) {
         var14.printStackTrace();
         return 0L;
      }
   }

   private long c_long(long var1, long var3, int[] var5) {
      if (e == 0L) {
         long var8 = this.a("kernel32.dll");
         e = this.a(var8, "CreateThread");
      }

      try {
         long var17 = this.a_Unsafe_2.allocateMemory(8L);
         ByteArrayOutputStream var6 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var6)).write(254);
         var7.write(15);
         var7.write(31);
         var7.write(248);
         BinaryBufferWriter.a(8, e, var7);
         BinaryBufferWriter.a(0, 0L, var7);
         BinaryBufferWriter.a(1, 0L, var7);
         BinaryBufferWriter.a(2, var1, var7);
         BinaryBufferWriter.a(3, var3, var7);
         BinaryBufferWriter.a(4, 0L, var7);
         BinaryBufferWriter.a(5, var17, var7);
         var7.write(0);
         var7.write(1);
         var7.write(63);
         var7.write(214);
         var7.write(254);
         var7.write(7);
         var7.write(65);
         var7.write(248);
         var7.write(192);
         var7.write(3);
         var7.write(95);
         var7.write(214);
         Class[] var10001 = new Class[]{long.class};
         long var10 = this.a_long_2();
         byte[] var15 = var6.toByteArray();
         byte[] var16 = this.a(var10, var15);
         long var12 = a_long_2(0L);
         var5[0] = this.a_Unsafe_2.getInt(var17);
         this.a_Unsafe_2.freeMemory(var17);
         this.a(var10, var16);
         return var12;
      } catch (Exception var14) {
         var14.printStackTrace();
         return 0L;
      }
   }

   private long c(long var1, long var3, int var5) {
      if (d == 0L) {
         long var6 = this.a("kernel32.dll");
         d = this.a(var6, "VirtualAlloc");
      }

      try {
         ByteArrayOutputStream var15 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var15)).write(72);
         var7.write(131);
         var7.write(236);
         var7.write(40);
         var7.write(72);
         var7.write(184);
         var7.writeLong(Long.reverseBytes(d));
         var7.write(72);
         var7.write(185);
         var7.writeLong(Long.reverseBytes(var1));
         var7.write(72);
         var7.write(186);
         var7.writeLong(Long.reverseBytes(var3));
         var7.write(73);
         var7.write(199);
         var7.write(192);
         var7.writeInt(Integer.reverseBytes(var5));
         var7.write(73);
         var7.write(199);
         var7.write(193);
         var7.writeInt(Integer.reverseBytes(4));
         var7.write(255);
         var7.write(208);
         var7.write(72);
         var7.write(131);
         var7.write(196);
         var7.write(40);
         var7.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var8 = this.a_long_2();
         byte[] var13 = var15.toByteArray();
         byte[] var14 = this.a(var8, var13);
         long var10 = a_long_2(0L);
         this.a(var8, var14);
         return var10;
      } catch (Exception var12) {
         var12.printStackTrace();
         return 0L;
      }
   }

   private long d(long var1, long var3, int var5) {
      if (d == 0L) {
         long var6 = this.a("kernel32.dll");
         d = this.a(var6, "VirtualAlloc");
      }

      try {
         ByteArrayOutputStream var15 = new ByteArrayOutputStream();
         DataOutputStream var7;
         (var7 = new DataOutputStream(var15)).write(104);
         var7.writeInt(Integer.reverseBytes(4));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes(var5));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes((int)var3));
         var7.write(104);
         var7.writeInt(Integer.reverseBytes((int)var1));
         var7.write(184);
         var7.writeInt(Integer.reverseBytes((int)d));
         var7.write(255);
         var7.write(208);
         var7.write(195);
         Class[] var10001 = new Class[]{long.class};
         long var8 = this.a_long_2();
         byte[] var13 = var15.toByteArray();
         byte[] var14 = this.a(var8, var13);
         long var10 = a_long_2(0L);
         this.a(var8, var14);
         return (int)var10;
      } catch (Exception var12) {
         var12.printStackTrace();
         return 0L;
      }
   }

   private String a_String(long var1) {
      long var3;
      long var5 = (var3 = this.a_Unsafe_2.getAddress(var1)) + this.a_kf_1.q;
      int var7;
      byte[] var2 = new byte[var7 = this.a_Unsafe_2.getShort(var3 + this.a_kf_1.r) & '\uffff'];

      for (int var8 = 0; var8 < var7; var8++) {
         var2[var8] = this.a_Unsafe_2.getByte(var5 + var8);
      }

      return new String(var2, Charset.forName("UTF-8"));
   }

   private String b(long var1) {
      StringBuilder var3 = new StringBuilder();

      char var5;
      for (int var4 = 0; (var5 = (char)this.a_Unsafe_2.getByte(var1 + var4)) != 0; var4++) {
         var3.append(var5);
      }

      return var3.toString();
   }

   private long a(long var1, String var3) {
      int var4 = 112;
      if (b_bool()) {
         var4 = 96;
      }

      long var5 = var1 + this.a_Unsafe_2.getInt(var1 + 60L);
      long var7 = var1 + this.a_Unsafe_2.getInt(var5 + 24L + var4);
      long var9 = var1 + this.a_Unsafe_2.getInt(var7 + 32L);
      long var11 = var1 + this.a_Unsafe_2.getInt(var7 + 28L);
      long var13 = var1 + this.a_Unsafe_2.getInt(var7 + 36L);
      var4 = this.a_Unsafe_2.getInt(var7 + 20L);

      for (int var20 = 0; var20 < var4; var20++) {
         long var15 = var1 + this.a_Unsafe_2.getInt(var9 + (var20 << 2));
         if (this.b(var15).equals(var3)) {
            long var17 = this.a_Unsafe_2.getInt(var11 + (this.a_Unsafe_2.getShort(var13 + (var20 << 1)) << 2));
            return var1 + var17;
         }
      }

      return 0L;
   }

   private long a(String var1) {
      long var2 = this.b();
      byte var4 = 24;
      byte var5 = 16;
      byte var6 = 8;
      byte var7 = 8;
      byte var8 = 88;
      byte var9 = 32;
      byte var10 = 16;
      byte var11 = 48;
      if (b_bool()) {
         var4 = 12;
         var5 = 20;
         var6 = 4;
         var7 = 4;
         var8 = 44;
         var9 = 20;
         var10 = 8;
         var11 = 24;
      }

      long var12 = this.a_Unsafe_2.getAddress(var2 + var4);
      this.a_Unsafe_2.getAddress(this.a_Unsafe_2.getAddress(var12 + var5));
      long var14 = var12 + var9;

      for (long var16 = this.a_Unsafe_2.getAddress(var14 + var6); var16 != var14; var16 = this.a_Unsafe_2.getAddress(var16 + var6)) {
         long var18 = var16 - var10;
         long var20 = this.a_Unsafe_2.getAddress(var18 + var8 + var7);
         short var22 = this.a_Unsafe_2.getShort(var18 + var8);
         StringBuilder var3 = new StringBuilder();

         for (byte var23 = 0; var23 < var22; var23 += 2) {
            char var24 = (char)this.a_Unsafe_2.getShort(var20 + var23);
            var3.append(var24);
         }

         if (var3.toString().equalsIgnoreCase(var1)) {
            return this.a_Unsafe_2.getAddress(var18 + var11);
         }
      }

      return 0L;
   }

   private static long a_long_2(long var0) {
      if (var0 == -8603657889541918990L) {
         return -8603657889541918991L;
      } else if (var0 == -8603657889541918992L) {
         return -8603657889541918986L;
      } else {
         return var0 == -8603657889541918989L ? -8603657889541918988L : -8603657889541918977L;
      }
   }
}
