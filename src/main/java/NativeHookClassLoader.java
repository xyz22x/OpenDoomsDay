import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public final class NativeHookClassLoader extends ClassLoader implements MemoryAccessor {
   private HashMap a_HashMap = new HashMap();
   private Class a_Class_1;
   private Method a_Method_2;
   private Method b;
   private Method c;
   private Method d;
   private Method e;
   private Method f;
   private static NativeHookClassLoader a_kl_3;

   private NativeHookClassLoader() {
   }

   @Override
   public final synchronized Class loadClass(String var1) throws ClassNotFoundException {
      Class var2;
      if ((var2 = this.findLoadedClass(var1)) == null) {
         byte[] var3;
         return (var3 = (byte[])this.a_HashMap.get(var1)) == null ? super.loadClass(var1) : this.defineClass(var1, var3, 0, var3.length);
      } else {
         return var2;
      }
   }

   @Override
   public final long a(long var1, long var3, int var5) {
      try {
         Object[] var7 = new Object[]{var1, var3, (long)var5, 4L};
         return (Long)a_kl_3.a_Method_2.invoke(null, (Object)var7);
      } catch (Exception var6) {
         throw new RuntimeException(var6);
      }
   }

   @Override
   public final boolean a(long var1, long var3, int[] var5) {
      try {
         Object[] var7 = new Object[]{var1, var3, 32L, var5};
         return a_kl_3.b.invoke(null, (Object)var7) == Boolean.TRUE;
      } catch (Exception var6) {
         throw new RuntimeException(var6);
      }
   }

   @Override
   public final boolean a(long var1, long var3) {
      try {
         Object[] var6 = new Object[]{var1, var3, 32768L};
         return a_kl_3.c.invoke(null, (Object)var6) == Boolean.TRUE;
      } catch (Exception var5) {
         throw new RuntimeException(var5);
      }
   }

   @Override
   public final void a(long var1, byte[] var3, int var4) {
      try {
         a_kl_3.d.invoke(null, var1, var3, 0, var4);
      } catch (Exception var5) {
         throw new RuntimeException(var5);
      }
   }

   @Override
   public final void b(long var1, byte[] var3, int var4) {
      try {
         a_kl_3.e.invoke(null, var1, var3, 0, var4);
      } catch (Exception var5) {
         throw new RuntimeException(var5);
      }
   }

   @Override
   public final long a_long(long var1, long var3) {
      try {
         return (Long)a_kl_3.f.invoke(null, var1, var3);
      } catch (Exception var5) {
         throw new RuntimeException(var5);
      }
   }

   public static NativeHookClassLoader a() {
      if (a_kl_3 != null) {
         return a_kl_3;
      } else {
         C_km var0;
         if ((var0 = C_km.a()) == null) {
            throw new RuntimeException("Jna library not found");
         } else {
            a_kl_3 = new NativeHookClassLoader();
            System.setProperty("jna.nounpack", Boolean.TRUE.toString());
            System.setProperty("jna.boot.library.path", var0.a_File.getParent());
            System.setProperty("jna.boot.library.name", var0.a_File.getName().substring(0, var0.a_File.getName().lastIndexOf(46)));
            String var1 = System.getProperty("java.io.tmpdir");
            NativeHookClassLoader var14 = null;
            System.setProperty("java.io.tmpdir", var1 + File.separator + "tmp");

            try {
               byte[] var2 = LzmaDecompressor.a(DoomsdayGUI.c_arr_byte_2);
               ByteArrayInputStream var15 = new ByteArrayInputStream(var2);
               DataInputStream var16;
               int var3 = (var16 = new DataInputStream(var15)).read();

               for (int var4 = 0; var4 < var3; var4++) {
                  String var5 = var16.readUTF();
                  int var6 = var16.read();
                  boolean var17 = !var5.equals(var0.a_String_2);

                  for (int var7 = 0; var7 < var6; var7++) {
                     String var8 = var16.readUTF();
                     int var9 = var16.readInt();
                     if (var17) {
                        var16.skip(var9);
                     } else {
                        byte[] var18 = new byte[var9];
                        var16.readFully(var18);
                        a_kl_3.a_HashMap.put(var8.replace('\\', '.'), var18);
                     }
                  }
               }

               a_kl_3.a_Class_1 = a_kl_3.loadClass("com.sun.jna.Native");
               a_kl_3.a_Method_2 = a_kl_3.a_Class_1.getDeclaredMethod("VirtualAlloc", Object.class);
               a_kl_3.b = a_kl_3.a_Class_1.getDeclaredMethod("VirtualProtect", Object.class);
               a_kl_3.c = a_kl_3.a_Class_1.getDeclaredMethod("VirtualFree", Object.class);
               a_kl_3.f = a_kl_3.a_Class_1.getDeclaredMethod("invoke", long.class, long.class);
               a_kl_3.e = a_kl_3.a_Class_1.getDeclaredMethod("read", long.class, byte[].class, int.class, int.class);
               a_kl_3.d = a_kl_3.a_Class_1.getDeclaredMethod("write", long.class, byte[].class, int.class, int.class);
               a_kl_3.a_Class_1.getName();
               var14 = a_kl_3;
            } catch (Exception var12) {
               throw new RuntimeException(var12);
            } finally {
               System.setProperty("java.io.tmpdir", var1);
            }

            return var14;
         }
      }
   }

   public static void main(String[] var0) {
      NativeHookClassLoader var4;
      long var2 = (var4 = a()).a(0L, 16534L, 4096);
      System.out.println(Long.toHexString(var2));
      byte[] var1 = new byte[]{72, -57, -64, 35, 49, 0, 0, -61};
      var4.a(var2, var1, 8);
      var4.a(var2, 16534L, null);
      System.out.println(Long.toHexString(var2) + " " + Long.toHexString(var4.a_long(var2, 0L)));
      var4.a(var2, 1174L);
      var4.b(var2, var1, 8);
   }
}
