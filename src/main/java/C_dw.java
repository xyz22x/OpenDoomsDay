import java.util.Map;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class C_dw extends Thread {
   private ArrayList a_ArrayList = new ArrayList();
   private HashMap a_HashMap_1 = new HashMap();

   public C_dw() {
      new HashMap();
   }

   @Override
   public final void run() {
      try {
         while (!this.isInterrupted()) {
            label30: {
               synchronized (this) {
                  if (this.a_HashMap_1.size() == 0 && this.a_ArrayList.size() == 0) {
                     break label30;
                  }
               }

               this.a();
               Thread.sleep(5000L);
               continue;
            }

            Thread.sleep(40L);
         }
      } catch (Throwable var3) {
         var3.printStackTrace();
      }
   }

   public final void a() {
      synchronized (this) {
         try {
         if (this.a_HashMap_1.size() != 0 || this.a_ArrayList.size() != 0) {
            ZipInputStream var2 = new ZipInputStream(new ByteArrayInputStream(FileUtils.a_arr_byte_2(GamePathUtils.a_File())));
            ByteArrayOutputStream var3 = new ByteArrayOutputStream(1000000);
            ZipOutputStream var4;
            (var4 = new ZipOutputStream(var3)).setLevel(9);
            byte[] var6 = new byte[16384];
            boolean var7 = false;

            ZipEntry var5;
            while ((var5 = var2.getNextEntry()) != null) {
               if (this.a_ArrayList.contains(var5.getName())) {
                  var7 = true;
               } else {
                  byte[] var8;
                  if ((var8 = (byte[])this.a_HashMap_1.get(var5.getName())) != null) {
                     int var14 = 0;
                     boolean var10 = true;

                     int var17;
                     while ((var17 = var2.read(var6)) != -1) {
                        for (int var11 = 0; var11 < var17; var11++) {
                           if (var8[var14 + var11] != var6[var11]) {
                              var10 = false;
                              break;
                           }
                        }

                        var14 += var17;
                     }

                     if (!var10) {
                        var7 = true;
                     }
                  } else {
                     var7 = true;
                     var5 = new ZipEntry(var5.getName());
                     var4.putNextEntry(var5);
                     FileUtils.a(var5);

                     int var9;
                     while ((var9 = var2.read(var6)) != -1) {
                        var4.write(var6, 0, var9);
                     }

                     var4.closeEntry();
                  }
               }
            }

            var2.close();
            if (var7) {
               for (Object var16_raw : this.a_HashMap_1.entrySet()) {
                   Map.Entry var16 = (Map.Entry)var16_raw;
                  FileUtils.a(var5 = new ZipEntry((String)var16.getKey()));
                  var4.putNextEntry(var5);
                  var4.write((byte[])var16.getValue());
                  var4.closeEntry();
               }

               var4.close();
               FileUtils.a(GamePathUtils.a_File(), var3.toByteArray());
            }

            this.a_ArrayList.clear();
            this.a_HashMap_1.clear();
         }
         } catch (Exception var_err) {
            var_err.printStackTrace();
         }
      }
   }

   public final synchronized void a(String var1) {
      this.a_ArrayList.add(var1);
      this.a_HashMap_1.remove(var1);
   }

   public final synchronized void a(String var1, byte[] var2) {
      this.a_HashMap_1.put(var1, var2);
      this.a_ArrayList.remove(var1);
   }
}
