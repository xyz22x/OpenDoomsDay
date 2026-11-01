import java.io.DataInputStream;
import java.io.File;

public final class JvmUtil {
   public int a_int;
   public long a_long_1;
   public long b;
   public long c;
   public long d;
   public long e;
   public long f;
   public long g;
   public long h;
   public long i;
   public long j;
   public long k;
   public long l;
   public long m;
   public long n;
   public long o;
   public long p;
   public long q;
   public long r;

   private JvmUtil(DataInputStream var1) throws java.io.IOException {
      this.a_int = (int)var1.readLong();
      this.a_long_1 = var1.readLong();
      this.b = var1.readLong();
      this.c = var1.readLong();
      this.d = var1.readLong();
      this.e = var1.readLong();
      this.f = var1.readLong();
      this.g = var1.readLong();
      this.h = var1.readLong();
      this.i = var1.readLong();
      this.j = var1.readLong();
      this.k = var1.readLong();
      this.l = var1.readLong();
      this.m = var1.readLong();
      this.n = var1.readLong();
      this.o = var1.readLong();
      this.p = var1.readLong();
      this.q = var1.readLong();
      this.r = var1.readLong();
   }

   private JvmUtil(
      int var1,
      long var2,
      long var4,
      long var6,
      long var8,
      long var10,
      long var12,
      long var14,
      long var16,
      long var18,
      long var20,
      long var22,
      long var24,
      long var26,
      long var28,
      long var30,
      long var32,
      long var34,
      long var36
   ) {
      this.a_int = var1;
      this.a_long_1 = var2;
      this.b = var4;
      this.c = var6;
      this.d = var8;
      this.e = var10;
      this.f = var12;
      this.g = var14;
      this.h = var16;
      this.i = var18;
      this.j = var20;
      this.k = var22;
      this.l = var24;
      this.m = var26;
      this.n = var28;
      this.o = var30;
      this.p = var32;
      this.q = var34;
      this.r = var36;
   }

   private static boolean a() {
      try {
         return Class.forName("java.lang.J9VMInternals") != null;
      } catch (Throwable var0) {
         return false;
      }
   }

   public static JvmUtil a_kf() {
      try {
         C_kd var0 = new C_kd();
         if (!C_kd.a_bool_3()) {
            throw new RuntimeException("Not supported");
         } else {
            int var41 = var0.a_int_2("oopSize");
            ProcessEntry var42;
            if ((var42 = var0.a_kh("java_lang_Class").a("_klass_offset")).a_bool_2) {
               long var43 = C_kd.a(var42.a_long_1);
               long var44 = var0.a_kh("InstanceKlass").a_long("_methods");
               long var6 = var0.a_kh("Array<Method*>").a_long("_data");
               long var8 = var0.a_kh("Method").a_long("_i2i_entry");
               long var10 = var0.a_kh("Method").a_long("_from_compiled_entry");
               long var12 = var0.a_kh("Method").a_long("_from_interpreted_entry");
               long var14 = var0.a_kh("Method").a_int_2;
               long var16 = var0.a_kh("Method").a_long("_code");
               long var18 = var0.a_kh("nmethod").a_long("_verified_entry_point");
               long var20 = var0.a_kh("InstanceKlass").a_long("_methods");
               long var22 = var0.a_kh("Array<Method*>").a_long("_data");
               long var24 = var0.a_kh("Method").a_long("_constMethod");
               long var26 = var0.a_kh("ConstMethod").a_long("_constants");
               long var28 = var0.a_kh("ConstMethod").a_long("_name_index");
               long var30 = var0.a_kh("ConstMethod").a_long("_signature_index");
               C_kh var34;
               long var32 = (var34 = var0.a_kh("Symbol")).a_long("_body");
               long var45 = 0L;

               try {
                  var45 = var34.a_long("_length");
               } catch (Exception var39) {
                  var39.printStackTrace();
                  var45 = 2L;
               }

               long var36 = var0.a_kh("ConstantPool").a_int_2;
               return new JvmUtil(
                  var41, var43, var44, var6, var8, var10, var12, var14, var16, var18, var20, var22, var24, var26, var28, var30, var36, var32, var45
               );
            } else {
               throw new IllegalArgumentException("Static field expected");
            }
         }
      } catch (Throwable var40) {
         if (DoomsdayGUI.d_bool_2) {
            throw new RuntimeException(var40);
         } else if (!C_kg.a()) {
            throw new RuntimeException("Offsets not supported");
         } else {
            try {
               String var2 = System.getProperty("java.home") + File.separatorChar + "bin" + File.separatorChar + "javaw";
               ProcessBuilder var1;
               if (a()) {
                  var1 = new ProcessBuilder(
                     var2, "--add-opens=java.base/java.lang=ALL-UNNAMED", "-Dcom.ibm.tools.attach.enable=no", "-jar", GamePathUtils.e(), "--offsets"
                  );
               } else {
                  var1 = new ProcessBuilder(
                     var2,
                     "--add-opens=java.base/java.lang=ALL-UNNAMED",
                     "-XX:-UsePerfData",
                     "-XX:+DisableAttachMechanism",
                     "-splash:",
                     "-jar",
                     GamePathUtils.e(),
                     "--offsets"
                  );
               }

               Process var3 = var1.start();
               DataInputStream var4 = new DataInputStream(var3.getInputStream());
               return new JvmUtil(var4);
            } catch (Throwable var38) {
               throw new RuntimeException(var38);
            }
         }
      }
   }
}
