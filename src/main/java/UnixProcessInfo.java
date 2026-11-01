import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public final class UnixProcessInfo extends ProcessInfo {
   public static final ArrayList a_ArrayList = new ArrayList(3);
   public static final ArrayList b = new ArrayList(3);
   private static File a_File_1;
   public static final String d;

   static {
      String var0;
      String var10000 = var0 = System.getProperty("java.io.tmpdir");
      if (var10000.charAt(var10000.length() - 1) != File.separatorChar) {
         var0 = var0 + File.separator;
      }

      d = var0;
      a_File_1 = new File(d);
      a_ArrayList.add(a_File_1);
      b.add(d);
   }

   private UnixProcessInfo(String var1, int var2, int var3, String var4, String var5) {
      super(var2, var3, var1, var4, 0L, var5);
   }

   @Override
   public final String toString() {
      return this.b_String_1 == null ? this.b_int + "@" + this.a_String_1 : this.b_String_1 + ":" + this.b_int + "@" + this.a_String_1;
   }

   public static List a() {
      ArrayList var0 = new ArrayList();

      for (int var1 = 0; var1 < a_ArrayList.size(); var1++) {
         File var2 = (File)a_ArrayList.get(var1);
         String var3 = (String)b.get(var1);
         List var4 = a(var2, var3);

         for (int var5 = 0; var5 < var4.size(); var5++) {
            if (!var0.contains(var4.get(var5))) {
               var0.add((ProcessInfo)var4.get(var5));
            }
         }
      }

      return var0;
   }

   private static List a(File var0, String var1) {
      PrintStream var2 = System.err;
      List var25 = null;
      System.setErr(new PrintStream(new C_bf()));

      try {
         ArrayList var3 = new ArrayList(3);
         String[] var24 = var0.list();

         for (int var4 = 0; var24 != null && var4 < var24.length; var4++) {
            if (var24[var4].startsWith("hsperfdata_")) {
               String var5 = var1 + File.separatorChar + var24[var4];
               File var6;
               if ((var6 = new File(var5)).isDirectory()) {
                  String var7 = var24[var4].substring(11);
                  if (var5.charAt(var5.length() - 1) != File.separatorChar) {
                     var5 = var5 + File.separatorChar;
                  }

                  String[] var28 = var6.list();

                  for (int var8 = 0; var28 != null && var8 < var28.length; var8++) {
                     String var9 = "";
                     int var10 = 0;

                     try {
                        var10 = Integer.parseInt(var28[var8]);
                     } catch (Exception var22) {
                     }

                     try {
                        ByteArrayOutputStream var11 = new ByteArrayOutputStream();
                        FileUtils.a(var5 + var28[var8], var11);
                        String var12;
                        int var35 = (var12 = new String(var11.toByteArray())).indexOf("sun.rt.javaCommand") + 18 + 1;
                        int var13 = var12.indexOf(0, var35);
                        if (var35 >= 0 && var13 >= 0) {
                           var9 = var12.substring(var35, var13);
                        }
                     } catch (Exception var21) {
                     }

                     int var36 = ProcessAttacher.a(var10);
                     String var42;
                     if (PlatformUtil.h()) {
                        var42 = "javaw.exe";
                     } else {
                        var42 = "java";
                     }

                     UnixProcessInfo var37 = new UnixProcessInfo(var42, var10, var36, var7, var9);
                     var3.add(var37);
                  }
               }
            } else if (var24[var4].startsWith(".com_ibm_tools_attach")) {
               String var26 = var1 + File.separatorChar + var24[var4];
               File var29;
               if ((var29 = new File(var26)).isDirectory()) {
                  File[] var31 = var29.listFiles();

                  for (int var30 = 0; var31 != null && var30 < var31.length; var30++) {
                     File[] var32;
                     if (var31[var30].isDirectory() && (var32 = var31[var30].listFiles()) != null && var32.length != 0) {
                        String var33 = "";
                        int var34 = 0;

                        try {
                           var34 = Integer.parseInt(var31[var30].getName());
                           File var38;
                           if ((var38 = new File(var31[var30], "attachInfo")).exists()) {
                              try {
                                 ByteArrayOutputStream var43 = new ByteArrayOutputStream();
                                 FileUtils.a(var38.getAbsolutePath(), var43);
                                 String var39;
                                 int var45 = (var39 = new String(var43.toByteArray())).indexOf("displayName=") + 12;
                                 int var27 = var39.indexOf(10, var45);
                                 if (var45 >= 0 && var27 >= 0) {
                                    var33 = var39.substring(var45, var27);
                                 }
                              } catch (Exception var19) {
                              }
                           }
                        } catch (Exception var20) {
                        }

                        int var40 = ProcessAttacher.a(var34);
                        String var44;
                        if (PlatformUtil.h()) {
                           var44 = "javaw.exe";
                        } else {
                           var44 = "java";
                        }

                        UnixProcessInfo var41 = new UnixProcessInfo(var44, var34, var40, null, var33);
                        var3.add(var41);
                     }
                  }
               }
            }
         }

         var25 = var3;
      } finally {
         System.setErr(var2);
      }

      return var25;
   }
}
