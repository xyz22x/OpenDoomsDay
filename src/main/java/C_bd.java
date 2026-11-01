import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class C_bd {
   private static byte[] a_arr_byte = new byte[]{8, 8, 8, 8};
   private static byte[] b_arr_byte = new byte[]{32, 1, 72, 96, 72, 96, 0, 0, 0, 0, 0, 0, 0, 0, -120, -120};
   private static HashMap a_HashMap_1 = new HashMap();
   private static HashMap b_HashMap_1 = new HashMap();
   private static ArrayList a_ArrayList_2 = new ArrayList();
   private static HashSet a_HashSet_3 = new HashSet();

   static {
      String var0 = "doomsdayclient.com";
      a_HashMap_1.put(var0, a(C_fp.c, new byte[]{-91, 22, -60, 0}));
      b_HashMap_1.put(var0, a(C_fp.d, new byte[]{42, 3, -80, -64, 0, 2, 0, -48, 0, 0, 0, 0, 20, 44, -32, 1}));
      var0 = "dd-img.ucoz.net";
      a_HashMap_1.put(var0, a(C_fp.c, new byte[]{-63, 109, -9, 7}));
   }

   private static ExternalProcessInjector a(C_fp var0, byte[] var1) {
      ExternalProcessInjector var2 = new ExternalProcessInjector();
      C_aw var3 = new C_aw(var0, var1);
      var2.a_ArrayList_3.add(var3);
      return var2;
   }

   public static ExternalProcessInjector a(CharSequence var0) {
      ExternalProcessInjector var1 = a(a_arr_byte, var0, C_fp.c);
      if (a_ArrayList_2.size() > 0 && var1.a()) {
         for (int var2 = 0; var2 < a_ArrayList_2.size(); var2++) {
            if (!(var1 = a((byte[])a_ArrayList_2.get(var2), var0, C_fp.c)).a()) {
               return var1;
            }
         }
      }

      return var1;
   }

   public static ExternalProcessInjector b(CharSequence var0) {
      ExternalProcessInjector var1 = a(b_arr_byte, var0, C_fp.c);
      if (a_ArrayList_2.size() > 0 && var1.a()) {
         for (int var2 = 0; var2 < a_ArrayList_2.size(); var2++) {
            if (!(var1 = a(b_arr_byte, var0, C_fp.c)).a()) {
               return var1;
            }
         }
      }

      return var1;
   }

   private static ExternalProcessInjector a(byte[] var0, CharSequence var1, C_fp var2) {
      ExternalProcessInjector var3 = null;
      if (var2 == C_fp.c) {
         var3 = (ExternalProcessInjector)a_HashMap_1.get(var1);
      } else if (var2 == C_fp.d) {
         var3 = (ExternalProcessInjector)b_HashMap_1.get(var1);
      }

      if (var3 != null) {
         return var3;
      }

      byte[] var4 = new byte[1024];

      try {
         C_ay var5 = new C_ay();

         for (int var6 = 0; var6 < 4; var6++) {
            byte[] var7 = null;
            byte[] var8 = null;

            try {
               for (int var9 = 0; var9 < 4; var9++) {
                  try {
                     var5.a = new DatagramSocket();
                     var5.a.setSoTimeout(700);
                     C_ax var10 = new C_ax(var1, var2);
                     var7 = var10.a();
                     var8 = var10.a_arr_byte_2;
                     break;
                  } catch (SocketException var20) {
                     throw new RuntimeException(var20);
                  } catch (Exception var21) {
                     Thread.sleep((long)(var9 * 20));
                     if (var7 != null) {
                        for (int var12 = 0; var12 < var7.length; var12++) {
                           var7[var12] = 0;
                        }
                     }
                  }
               }

               try {
                  DatagramPacket var22 = new DatagramPacket(var7, 0, var7.length, InetAddress.getByAddress(var0), 53);
                  var5.a.send(var22);
               } catch (IOException var19) {
                  throw new RuntimeException(var19);
               }

               var5.a(var4);
               var3 = new ExternalProcessInjector(var4, var7.length, var8);
               var5.a();
               if (var7 != null) {
                  for (int var13 = 0; var13 < var7.length; var13++) {
                     var7[var13] = 0;
                  }
               }
               var5.a();
               if (var2 == C_fp.c) {
                  a_HashMap_1.put(var1, var3);
               } else if (var2 == C_fp.d) {
                  b_HashMap_1.put(var1, var3);
               }

               for (int var14 = 0; var14 < var0.length; var14++) {
                  var4[var14] = 0;
               }

               return var3;
            } catch (Exception var23) {
               Thread.sleep(20L);
               if (var6 == 3) {
                  if (var7 != null) {
                     for (int var15 = 0; var15 < var7.length; var15++) {
                        var7[var15] = 0;
                     }
                  }
                  var5.a();
                  break;
               }

               if (var7 != null) {
                  for (int var16 = 0; var16 < var7.length; var16++) {
                     var7[var16] = 0;
                  }
               }
               var5.a();
            }
         }

         for (int var17 = 0; var17 < var0.length; var17++) {
            var4[var17] = 0;
         }

         return null;
      } catch (Exception var24) {
         throw new RuntimeException(var24);
      } finally {
         for (int var18 = 0; var18 < var0.length; var18++) {
            var4[var18] = 0;
         }
      }
   }

   public static void a(SocketAddress var0) {
      try {
         if (PlatformUtil.h()) {
            ArrayList var1 = new ArrayList();
            if (var0 instanceof InetSocketAddress) {
               String var5 = ((InetSocketAddress)var0).getAddress().getHostAddress();
               if (!a_HashSet_3.contains(var5) && !var5.equals("0.0.0.0")) {
                  a_HashSet_3.add(var5);
                  ProcessAttacher.a(var5, var1);

                  for (int var6 = 0; var6 < var1.size(); var6++) {
                     try {
                        byte[] var2 = InetAddress.getByName(new String((byte[])var1.get(var6))).getAddress();
                        if (!a(a_ArrayList_2, var2)) {
                           a_ArrayList_2.add(var2);
                           if (DoomsdayGUI.c_bool_1) {
                              System.out.println("dns " + Arrays.toString(var2));
                           }
                        }
                     } catch (Throwable var3) {
                        var3.printStackTrace();
                     }
                  }

                  return;
               }
            }
         }
      } catch (Throwable var4) {
         var4.printStackTrace();
      }
   }

   private static boolean a(ArrayList var0, byte[] var1) {
      for (int var2 = 0; var2 < var0.size(); var2++) {
         if (Arrays.equals((byte[])var0.get(var2), var1)) {
            return true;
         }
      }

      return false;
   }
}
