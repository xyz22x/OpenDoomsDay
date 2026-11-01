import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;
import sun.misc.Unsafe;

public final class C_kd {
   public static final Unsafe a_Unsafe = a();
   private final Map a_Map_1 = new LinkedHashMap();
   private final Map b = new LinkedHashMap();

   public C_kd() {
      this.a(a_Map());
      this.a_void_2();
      this.b();
   }

   public static boolean a_bool_3() {
      return C_kg.a();
   }

   private static Map a_Map() {
      long var0 = a("gHotSpotVMStructs");
      long var2 = a("gHotSpotVMStructEntryTypeNameOffset");
      long var4 = a("gHotSpotVMStructEntryFieldNameOffset");
      long var6 = a("gHotSpotVMStructEntryTypeStringOffset");
      long var8 = a("gHotSpotVMStructEntryIsStaticOffset");
      long var10 = a("gHotSpotVMStructEntryOffsetOffset");
      long var12 = a("gHotSpotVMStructEntryAddressOffset");
      long var14 = a("gHotSpotVMStructEntryArrayStride");
      HashMap var16 = new HashMap();

      while (true) {
         String var17 = b(var0 + var2);
         String var18;
         if ((var18 = b(var0 + var4)) == null) {
            return var16;
         }

         String var19 = b(var0 + var6);
         long var24 = var0 + var8;
         boolean var20 = a_Unsafe.getInt(var24) != 0;
         var24 = var0 + (var20 ? var12 : var10);
         long var21 = a_Unsafe.getLong(var24);
         Set var23;
         if ((var23 = (Set)var16.get(var17)) == null) {
            var16.put(var17, var23 = new TreeSet());
         }

         var23.add(new ProcessEntry(var18, var19, var21, var20));
         var0 += var14;
      }
   }

   private void a(Map var1) {
      long var2 = a("gHotSpotVMTypes");
      long var4 = a("gHotSpotVMTypeEntryTypeNameOffset");
      long var6 = a("gHotSpotVMTypeEntrySuperclassNameOffset");
      long var8 = a("gHotSpotVMTypeEntryIsOopTypeOffset");
      long var10 = a("gHotSpotVMTypeEntryIsIntegerTypeOffset");
      long var12 = a("gHotSpotVMTypeEntryIsUnsignedOffset");
      long var14 = a("gHotSpotVMTypeEntrySizeOffset");

      String var18;
      for (long var16 = a("gHotSpotVMTypeEntryArrayStride"); (var18 = b(var2 + var4)) != null; var2 += var16) {
         String var19 = b(var2 + var6);
         long var22 = var2 + var8;
         a_Unsafe.getInt(var22);
         var22 = var2 + var10;
         a_Unsafe.getInt(var22);
         var22 = var2 + var12;
         a_Unsafe.getInt(var22);
         var22 = var2 + var14;
         int var20 = a_Unsafe.getInt(var22);
         Set var21 = (Set)var1.get(var18);
         this.a_Map_1.put(var18, new C_kh(var18, var19, var20, var21));
      }
   }

   private void a_void_2() {
      long var1 = a("gHotSpotVMIntConstants");
      long var3 = a("gHotSpotVMIntConstantEntryNameOffset");
      long var5 = a("gHotSpotVMIntConstantEntryValueOffset");

      String var9;
      for (long var7 = a("gHotSpotVMIntConstantEntryArrayStride"); (var9 = b(var1 + var3)) != null; var1 += var7) {
         long var11 = var1 + var5;
         int var10 = a_Unsafe.getInt(var11);
         this.b.put(var9, var10);
      }
   }

   private void b() {
      long var1 = a("gHotSpotVMLongConstants");
      long var3 = a("gHotSpotVMLongConstantEntryNameOffset");
      long var5 = a("gHotSpotVMLongConstantEntryValueOffset");

      String var9;
      for (long var7 = a("gHotSpotVMLongConstantEntryArrayStride"); (var9 = b(var1 + var3)) != null; var1 += var7) {
         long var12 = var1 + var5;
         long var10 = a_Unsafe.getLong(var12);
         this.b.put(var9, var10);
      }
   }

   public static int a(long var0) {
      return a_Unsafe.getInt(var0);
   }

   private static String a_String(long var0) {
      if (var0 == 0L) {
         return null;
      } else {
         char[] var2 = new char[40];
         int var3 = 0;

         while (true) {
            long var5 = var0 + var3;
            byte var4;
            if ((var4 = a_Unsafe.getByte(var5)) == 0) {
               return new String(var2, 0, var3);
            }

            if (var3 >= var2.length) {
               var2 = Arrays.copyOf(var2, var3 << 1);
            }

            var2[var3++] = (char)var4;
         }
      }
   }

   private static String b(long var0) {
      return a_String(a_Unsafe.getAddress(var0));
   }

   private static long a(String var0) {
      long var1;
      if ((var1 = C_kg.a(var0)) == 0L) {
         throw new NoSuchElementException(var0);
      } else {
         return a_Unsafe.getLong(var1);
      }
   }

   public final C_kh a_kh(String var1) {
      C_kh var2;
      if ((var2 = (C_kh)this.a_Map_1.get(var1)) == null) {
         throw new NoSuchElementException(var1);
      } else {
         return var2;
      }
   }

   public final int a_int_2(String var1) {
      Number var3;
      if ((var3 = (Number)this.b.get(var1)) == null) {
         throw new NoSuchElementException(var1);
      } else {
         return var3.intValue();
      }
   }

   private static Unsafe a() {
      try {
         Field var0;
         (var0 = Unsafe.class.getDeclaredField("theUnsafe")).setAccessible(true);
         return (Unsafe)var0.get(null);
      } catch (Exception var1) {
         throw new RuntimeException(var1);
      }
   }
}
