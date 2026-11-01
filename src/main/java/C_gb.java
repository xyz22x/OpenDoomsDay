import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;

public final class C_gb extends Thread {
   public List a_List = Collections.synchronizedList(new ArrayList());
   public Object a_Object_1 = new Object();

   @Override
   public final void run() {
      try {
         while (true) {
            ArrayList var1 = null;
            synchronized (this.a_List) {
               Iterator var3 = this.a_List.iterator();

               while (var3.hasNext()) {
                  C_hg var4;
                  if ((var4 = (C_hg)var3.next()).a_gg.a_dbl_2 == -1.0) {
                     if (var1 == null) {
                        var1 = new ArrayList(2);
                     }

                     var1.add(var4);
                  }

                  SwingUtilities.invokeLater(new C_gc(var4));
               }
            }

            if (var1 != null) {
               for (int var8 = 0; var8 < var1.size(); var8++) {
                  this.a_List.remove(var1.get(var8));
               }
            }

            Thread.sleep(10L);
            if (this.a_List.size() == 0) {
               synchronized (this.a_Object_1) {
                  this.a_Object_1.wait();
               }
            }
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }
   }
}
