import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class C_du {
   private C_hk a_hk = new C_hk(null);
   private C_hl a_hl_1 = null;
   private int a_int_2 = 0;

   private static int a(LinkedList var0) {
      return var0.size() == 0 ? -1 : (Integer)var0.getFirst();
   }

   public final Object a(String var1, C_av var2) throws C_fm {
      StringReader var4 = new StringReader(var1);
      return this.a(var4, var2);
   }

   public final Object a(Reader var1, C_av var2) throws C_fm {
      this.a_hk.a(var1);
      this.a_hl_1 = null;
      this.a_int_2 = 0;
      LinkedList var8 = new LinkedList();
      LinkedList var3 = new LinkedList();

      do {
            this.a_hl_1 = this.a_hk.a_hl_2();
            if (this.a_hl_1 == null) {
               this.a_hl_1 = new C_hl(-1, null);
            }

            label76:
            switch (this.a_int_2) {
               case -1:
                  throw new C_fm(this.a_hk.a(), 1, this.a_hl_1);
               case 0:
                  switch (this.a_hl_1.a_int) {
                     case 0:
                        this.a_int_2 = 1;
                        var8.addFirst(this.a_int_2);
                        var3.addFirst(this.a_hl_1.a_Object_1);
                        break label76;
                     case 1:
                        this.a_int_2 = 2;
                        var8.addFirst(this.a_int_2);
                        var3.addFirst(a_Map(var2));
                        break label76;
                     case 2:
                     default:
                        this.a_int_2 = -1;
                        break label76;
                     case 3:
                        this.a_int_2 = 3;
                        var8.addFirst(this.a_int_2);
                        var3.addFirst(a(var2));
                        break label76;
                  }
               case 1:
                  if (this.a_hl_1.a_int == -1) {
                     return var3.removeFirst();
                  }

                  throw new C_fm(this.a_hk.a(), 1, this.a_hl_1);
               case 2:
                  if (this.a_hl_1.a_int != 5) {
                     if (this.a_hl_1.a_int == 0) {
                        if (this.a_hl_1.a_Object_1 instanceof String) {
                           String var13 = (String)this.a_hl_1.a_Object_1;
                           var3.addFirst(var13);
                           this.a_int_2 = 4;
                           var8.addFirst(this.a_int_2);
                        } else {
                           this.a_int_2 = -1;
                        }
                     } else if (this.a_hl_1.a_int == 2) {
                        if (var3.size() > 1) {
                           var8.removeFirst();
                           var3.removeFirst();
                           this.a_int_2 = a(var8);
                        } else {
                           this.a_int_2 = 1;
                        }
                     } else {
                        this.a_int_2 = -1;
                     }
                  }
                  break;
               case 3:
                  if (this.a_hl_1.a_int != 5) {
                     if (this.a_hl_1.a_int == 0) {
                        ((List)var3.getFirst()).add(this.a_hl_1.a_Object_1);
                     } else if (this.a_hl_1.a_int == 4) {
                        if (var3.size() > 1) {
                           var8.removeFirst();
                           var3.removeFirst();
                           this.a_int_2 = a(var8);
                        } else {
                           this.a_int_2 = 1;
                        }
                     } else if (this.a_hl_1.a_int == 1) {
                        List var16 = (List)var3.getFirst();
                        Map var11 = a_Map(var2);
                        var16.add(var11);
                        this.a_int_2 = 2;
                        var8.addFirst(this.a_int_2);
                        var3.addFirst(var11);
                     } else if (this.a_hl_1.a_int == 3) {
                        List var17 = (List)var3.getFirst();
                        List var12 = a(var2);
                        var17.add(var12);
                        this.a_int_2 = 3;
                        var8.addFirst(this.a_int_2);
                        var3.addFirst(var12);
                     } else {
                        this.a_int_2 = -1;
                     }
                  }
                  break;
               case 4:
                  if (this.a_hl_1.a_int != 6) {
                     if (this.a_hl_1.a_int == 0) {
                        var8.removeFirst();
                        String var4 = (String)var3.removeFirst();
                        ((Map)var3.getFirst()).put(var4, this.a_hl_1.a_Object_1);
                        this.a_int_2 = a(var8);
                     } else if (this.a_hl_1.a_int == 3) {
                        var8.removeFirst();
                        String var9 = (String)var3.removeFirst();
                        Map var5 = (Map)var3.getFirst();
                        List var6 = a(var2);
                        var5.put(var9, var6);
                        this.a_int_2 = 3;
                        var8.addFirst(this.a_int_2);
                        var3.addFirst(var6);
                     } else if (this.a_hl_1.a_int == 1) {
                        var8.removeFirst();
                        String var10 = (String)var3.removeFirst();
                        Map var14 = (Map)var3.getFirst();
                        Map var15 = a_Map(var2);
                        var14.put(var10, var15);
                        this.a_int_2 = 2;
                        var8.addFirst(this.a_int_2);
                        var3.addFirst(var15);
                     } else {
                        this.a_int_2 = -1;
                     }
                  }
            }

            if (this.a_int_2 == -1) {
               throw new C_fm(this.a_hk.a(), 1, this.a_hl_1);
            }
         } while (this.a_hl_1.a_int != -1);

         throw new C_fm(this.a_hk.a(), 1, this.a_hl_1);
   }

   private static Map a_Map(C_av var0) {
      if (var0 == null) {
         return new C_dt();
      } else {
         Map var1;
         return (Map)((var1 = var0.a_Map()) == null ? new C_dt() : var1);
      }
   }

   private static List a(C_av var0) {
      if (var0 == null) {
         return new C_dr();
      } else {
         List var1;
         return (List)((var1 = var0.a()) == null ? new C_dr() : var1);
      }
   }
}
