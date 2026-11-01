import java.net.ServerSocket;
import java.net.Socket;

public abstract class InjectionCallback {
   private static volatile int a_int;
   public volatile ServerSocket a_ServerSocket_1;
   public volatile ServerSocket b_ServerSocket;
   public volatile Socket a_Socket_2;
   public volatile Socket b_Socket_1;
   public volatile boolean a_bool_3;
   public Thread a_Thread_4;
   public Thread b_Thread_2;
   private Object a_Object_5 = new Object();
   private volatile Throwable a_Throwable_6;
   private volatile long a_long_7;

   public InjectionCallback() {
      a_int++;
   }

   public final synchronized void b(String var1, Throwable var2) {
      if (!this.a_bool_3) {
         if (var2 != null) {
            this.a_bool_3 = true;
            this.d();
         }

         this.a(var1, var2);
         this.a_Throwable_6 = var2;
         if (this.a_Throwable_6 != null) {
            synchronized (this.a_Object_5) {
               this.a_Object_5.notifyAll();
            }
         }
      }
   }

   public final void c() {
      try {
         this.a_Thread_4.interrupt();
      } catch (Throwable var2) {
      }

      try {
         this.b_Thread_2.interrupt();
      } catch (Throwable var1) {
      }

      this.d();
   }

   private void d() {
      try {
         this.a_ServerSocket_1.close();
      } catch (Throwable var4) {
      }

      try {
         this.b_ServerSocket.close();
      } catch (Throwable var3) {
      }

      try {
         this.a_Socket_2.close();
      } catch (Throwable var2) {
      }

      try {
         this.b_Socket_1.close();
      } catch (Throwable var1) {
      }
   }

   public abstract void a();

   public abstract void b();

   public abstract void a(String var1, Throwable var2);

   public abstract void a(long var1);

   public final synchronized void b(long var1) {
      this.a_bool_3 = true;
      this.d();
      this.a(var1);
      this.a_long_7 = var1;
      synchronized (this.a_Object_5) {
         this.a_Object_5.notifyAll();
      }
   }
}
