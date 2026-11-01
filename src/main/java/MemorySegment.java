import com.sun.jna.Function;
import com.sun.jna.Memory;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;

public final class MemorySegment implements MemoryAccessor {
   private static NativeLibrary a;

   private static NativeLibrary a() {
      if (a == null) {
         a = NativeLibrary.getInstance("kernel32");
      }

      return a;
   }

   @Override
   public final void a(long var1, byte[] var3, int var4) {
      new Pointer(var1).write(0L, var3, 0, var4);
   }

   @Override
   public final void b(long var1, byte[] var3, int var4) {
      new Pointer(var1).read(0L, var3, 0, var4);
   }

   @Override
   public final boolean a(long var1, long var3, int[] var5) {
      Memory var6 = new Memory(4L);
      Pointer var7 = a().getFunction("VirtualProtect").invokePointer(new Object[]{new Pointer(var1), new Pointer(var3), 32, var6});
      if (var5 != null) {
         var5[0] = var6.getInt(0L);
      }

      return var7 == null ? false : Pointer.nativeValue(var7) == 1L;
   }

   @Override
   public final boolean a(long var1, long var3) {
      Pointer var5;
      return (var5 = a().getFunction("VirtualFree").invokePointer(new Object[]{new Pointer(var1), new Pointer(var3), 32768})) == null
         ? false
         : Pointer.nativeValue(var5) == 1L;
   }

   @Override
   public final long a(long var1, long var3, int var5) {
      return Pointer.nativeValue(a().getFunction("VirtualAlloc").invokePointer(new Object[]{new Pointer(var1), new Pointer(var3), var5, 4}));
   }

   @Override
   public final long a_long(long var1, long var3) {
      Pointer var5;
      return (var5 = Function.getFunction(new Pointer(var1)).invokePointer(new Object[]{new Pointer(var3)})) == null ? 0L : Pointer.nativeValue(var5);
   }
}
