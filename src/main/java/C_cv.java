import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;

public final class C_cv implements ActionListener {
   private static Charset a_Charset = Charset.forName("UTF-8");
   private ProcessSelectPanel a_cw_1;
   private static byte[] a_arr_byte_2;
   private static byte[] b = new byte[]{-91, 22, -60, 0};
   private static byte[] c = new byte[]{42, 3, -80, -64, 0, 2, 0, -48, 0, 0, 0, 0, 20, 44, -32, 1};
   private static byte[] d;

   public C_cv(ProcessSelectPanel var1) {
      this.a_cw_1 = var1;
   }

   @Override
   public final void actionPerformed(ActionEvent var1) {
      try {
         if (this.a_cw_1.a_JCheckBox_6.isSelected()) {
            File var2;
            if (!(var2 = new File(this.a_cw_1.a_aq_1.a_JTextField.getText())).exists()) {
               throw new RuntimeException("Launcher not found: ".concat(String.valueOf(var2)));
            }

            File var3;
            if (!(var3 = new File(var2, "mods")).exists() && !var3.mkdirs()) {
               throw new RuntimeException("Error create mods directory");
            }

            var2 = GamePathUtils.a_File();

            try {
               String var4;
               if (!(var4 = var2.getName()).endsWith(".jar")) {
                  var4 = "dd.jar";
               }

               FileUtils.a_void(var2, new File(var3, var4));
            } catch (Exception var24) {
               throw new RuntimeException(var24);
            }
         } else {
            this.a_cw_1.a_JComboBox_3.getSelectedItem();
            if (this.a_cw_1.c_JComboBox.getSelectedIndex() == 2) {
               C_cv var26 = this;
               File var31;
               if (!(var31 = new File(this.a_cw_1.a_aq_1.a_JTextField.getText())).exists()) {
                  throw new RuntimeException("Launcher not found: ".concat(String.valueOf(var31)));
               }

               if (this.a_cw_1.a_JComboBox_3.getItemCount() == 0) {
                  throw new RuntimeException("Please download version of minecraft on which you want to install DoomsDay");
               }

               if (this.a_cw_1.a_JComboBox_3.getSelectedItem() == null) {
                  throw new RuntimeException("Please select minecraft version");
               }

               if (this.a_cw_1.d_JComboBox.getSelectedItem() == null) {
                  throw new RuntimeException("Please select doomsday version");
               }

               this.a_void();
               C_dt var43 = ((C_dn)this.a_cw_1.a_JComboBox_3.getSelectedItem()).a_dt;
               C_dt var32;
               if ((var32 = (C_dt)(var43 = new C_dt(var43)).get("arguments")) != null) {
                  C_dr var47 = (C_dr)var32.get("jvm");
                  C_dr var5 = (C_dr)var32.get("game");
                  if (var47 != null) {
                     b_void(var47);
                  }

                  if (var5 != null) {
                     c_void(var5);
                  }

                  String var7;
                  if ((var7 = this.a()).equals("$default$") || !FileUtils.a_bool(var7)) {
                     var7 = GamePathUtils.d();
                  }

                  File var8;
                  if (!(var8 = new File(var7)).exists() && !var8.mkdirs()) {
                     throw new RuntimeException("Error create directory: ".concat(String.valueOf(var7)));
                  }

                  File var6 = new File(var8, "Agent.jar");

                  try {
                     JvmtiInjector.a(var6);
                  } catch (Exception var23) {
                     throw new RuntimeException("Error create agent file: " + var23.getMessage());
                  }

                  var7 = new String(C_ap.a(this.a_cw_1.a_a.a_au_9.a_String(this.a()).getBytes(a_Charset)), a_Charset);
                  if (var47 == null) {
                     var47 = new C_dr();
                     var43.put("jvm", var47);
                  }

                  C_dt var9;
                  (var9 = new C_dt()).put("value", "-javaagent:" + var6.getAbsolutePath() + "=" + var7);
                  var47.add(var9);
                  var6 = new File(this.a_cw_1.a_aq_1.a_JTextField.getText(), "versions");
                  File var82 = new File(var6, ((C_dn)this.a_cw_1.a_JComboBox_3.getSelectedItem()).a_String_1);
                  if (this.a_cw_1.b_JCheckBox_1.isSelected()) {
                     String var10 = a(var43);
                     var43.put("type", "modified");
                     var43.put("jar", var10);
                     var43.put("id", this.a_cw_1.a_JTextField_2.getText());
                     File var11 = new File(var82, ((C_dn)this.a_cw_1.a_JComboBox_3.getSelectedItem()).a_String_1 + ".jar");
                     var6 = new File(var6, this.a_cw_1.a_JTextField_2.getText());
                     File var83 = new File(var6, this.a_cw_1.a_JTextField_2.getText() + ".jar");
                     if ((var31 = new File(var6, this.a_cw_1.a_JTextField_2.getText() + ".json")).exists()) {
                        throw new RuntimeException("Instance already exists");
                     }

                     var6.mkdir();
                     if (var11.exists()) {
                        try {
                           FileUtils.a_void(var11, var83);
                        } catch (Exception var22) {
                           throw new RuntimeException("Error copy minecraft from " + var11 + " to " + var83 + ": " + var22.getMessage());
                        }
                     }

                     try {
                        FileOutputStream var34;
                        (var34 = new FileOutputStream(var31)).write(C_dt.a(var43).getBytes(a_Charset));
                        var34.close();
                     } catch (Exception var21) {
                        throw new RuntimeException("Error create json file: " + var21.getMessage());
                     }

                     if (PlatformUtil.k()) {
                        this.b_void();
                     }
                  } else {
                     try {
                        File var112 = new File(var82, ((C_dn)var26.a_cw_1.a_JComboBox_3.getSelectedItem()).a_String_1 + ".json");
                        FileOutputStream var119;
                        (var119 = new FileOutputStream(var112)).write(C_dt.a(var43).getBytes(a_Charset));
                        var119.close();
                     } catch (Exception var20) {
                        throw new RuntimeException("Error rewrite existing json file: " + var20.getMessage());
                     }
                  }
               }
            } else if (this.a_cw_1.c_JComboBox.getSelectedIndex() == 1) {
               C_cv var27 = this;
               File var35;
               if (!(var35 = new File(this.a_cw_1.a_aq_1.a_JTextField.getText())).exists()) {
                  throw new RuntimeException("Launcher not found: ".concat(String.valueOf(var35)));
               }

               if (this.a_cw_1.a_JComboBox_3.getItemCount() == 0) {
                  throw new RuntimeException("Please download version of minecraft on which you want to install DoomsDay");
               }

               if (this.a_cw_1.a_JComboBox_3.getSelectedItem() == null) {
                  throw new RuntimeException("Please select minecraft version");
               }

               if (this.a_cw_1.d_JComboBox.getSelectedItem() == null) {
                  throw new RuntimeException("Please select doomsday version");
               }

               this.a_void();
               C_dn var45;
               String var36 = a((var45 = (C_dn)this.a_cw_1.a_JComboBox_3.getSelectedItem()).a_dt);
               C_dt var48 = ((C_dn)this.a_cw_1.a_JComboBox_3.getSelectedItem()).a_dt;
               C_dt var49;
               String var52 = (String)(var49 = new C_dt(var48)).get("mainClass");
               String var61 = (String)var49.get("minecraftArguments");
               String var84 = this.a_cw_1.a_a.a_au_9.a_String(this.a());
               if (!var52.equals("net.minecraft.launchwrapper.Launch")) {
                  var84 = var84 + " --mainClass=" + var52;
               }

               String var99 = new String(C_ap.a(var84.getBytes(a_Charset)), a_Charset);
               if (var61 != null) {
                  var61 = a(var61);
                  var61 = var61 + " --tweakClass " + DoomsdayGUI.c_String;
                  var61 = var61 + " --doomsdayargs=" + var99;
                  if (!var52.equals("net.minecraft.client.Minecraft")
                     && !var52.equals("net.minecraft.client.main.Main")
                     && !var52.equals("net.minecraft.launchwrapper.Launch")) {
                     var61 = var61 + "--mainClass " + var52;
                  }

                  var49.put("minecraftArguments", var61);
               } else {
                  C_dt var85;
                  C_dr var106;
                  if ((var106 = (C_dr)(var85 = (C_dt)var49.get("arguments")).get("game")) == null) {
                     var106 = new C_dr();
                     var49.put("game", var106);
                  }

                  C_dr var62;
                  if ((var62 = (C_dr)var85.get("jvm")) != null) {
                     b_void(var62);
                  }

                  c_void(var106);
                  if (var106.size() > 0 && var106.get(0) instanceof C_dt) {
                     C_dt var86;
                     (var86 = new C_dt()).put("value", "--tweakClass");
                     var106.add(var86);
                     C_dt var113;
                     (var113 = new C_dt()).put("value", DoomsdayGUI.c_String);
                     var106.add(var113);
                     C_dt var120;
                     (var120 = new C_dt()).put("value", "--doomsdayargs=".concat(String.valueOf(var99)));
                     var106.add(var120);
                     if (!var52.equals("net.minecraft.client.Minecraft")
                        && !var52.equals("net.minecraft.client.main.Main")
                        && !var52.equals("net.minecraft.launchwrapper.Launch")) {
                        C_dt var63;
                        (var63 = new C_dt()).put("value", "--mainClass");
                        var106.add(var63);
                        C_dt var87;
                        (var87 = new C_dt()).put("value", var52);
                        var106.add(var87);
                     }
                  } else {
                     var106.add("--tweakClass");
                     var106.add(DoomsdayGUI.c_String);
                     var106.add("--doomsdayargs=".concat(String.valueOf(var99)));
                     if (!var52.equals("net.minecraft.client.Minecraft")
                        && !var52.equals("net.minecraft.client.main.Main")
                        && !var52.equals("net.minecraft.launchwrapper.Launch")) {
                        var106.add("--mainClass");
                        var106.add(var52);
                     }
                  }
               }

               C_dr var88;
               a(var88 = (C_dr)var49.get("libraries"));
               if (!var52.equals("net.minecraft.launchwrapper.Launch")) {
                  var49.put("mainClass", "net.minecraft.launchwrapper.Launch");
               }

               C_dt var53 = new C_dt();
               C_dt var67 = new C_dt();
               C_dt var100;
               (var100 = new C_dt()).put("path", "net/minecraft/launchwrapper/1.12/launchwrapper-1.12.jar");
               var100.put("sha1", "111e7bea9c968cdb3d06ef4632bf7ff0824d0f36");
               var100.put("size", 32999);
               var100.put("url", "https://libraries.minecraft.net/net/minecraft/launchwrapper/1.12/launchwrapper-1.12.jar");
               var67.put("artifact", var100);
               var53.put("downloads", var67);
               var53.put("name", "net.minecraft:launchwrapper:1.12");
               var88.add(var53);
               if (!d(var88)) {
                  C_dt var54 = new C_dt();
                  C_dt var68 = new C_dt();
                  C_dt var101;
                  (var101 = new C_dt()).put("path", "org/apache/logging/log4j/log4j-api/2.8.1/log4j-api-2.8.1.jar");
                  var101.put("sha1", "e801d13612e22cad62a3f4f3fe7fdbe6334a8e72");
                  var101.put("size", 228859);
                  var101.put("url", "https://libraries.minecraft.net/org/apache/logging/log4j/log4j-api/2.8.1/log4j-api-2.8.1.jar");
                  var68.put("artifact", var101);
                  var54.put("downloads", var68);
                  var54.put("name", "org.apache.logging.log4j:log4j-api:2.8.1");
                  var88.add(var54);
               }

               if (!a_bool(var88)) {
                  C_dt var55 = new C_dt();
                  C_dt var69 = new C_dt();
                  C_dt var102;
                  (var102 = new C_dt()).put("path", "org/apache/logging/log4j/log4j-core/2.8.1/log4j-core-2.8.1.jar");
                  var102.put("sha1", "4ac28ff2f1ddf05dae3043a190451e8c46b73c31");
                  var102.put("size", 1402925);
                  var102.put("url", "https://libraries.minecraft.net/org/apache/logging/log4j/log4j-core/2.8.1/log4j-core-2.8.1.jar");
                  var69.put("artifact", var102);
                  var55.put("downloads", var69);
                  var55.put("name", "org.apache.logging.log4j:log4j-core:2.8.1");
                  var88.add(var55);
               }

               if (!c(var88)) {
                  C_dt var56 = new C_dt();
                  C_dt var70 = new C_dt();
                  C_dt var103;
                  (var103 = new C_dt()).put("path", "net/sf/jopt-simple/jopt-simple/5.0.3/jopt-simple-5.0.3.jar");
                  var103.put("sha1", "cdd846cfc4e0f7eefafc02c0f5dce32b9303aa2a");
                  var103.put("size", 78175);
                  var103.put("url", "https://libraries.minecraft.net/net/sf/jopt-simple/jopt-simple/5.0.3/jopt-simple-5.0.3.jar");
                  var70.put("artifact", var103);
                  var56.put("downloads", var70);
                  var56.put("name", "net.sf.jopt-simple:jopt-simple:5.0.3");
                  var88.add(var56);
               }

               if ("pre-1.6".equals(var49.get("assets")) && !b(var88)) {
                  C_dt var57 = new C_dt();
                  C_dt var71 = new C_dt();
                  C_dt var104;
                  (var104 = new C_dt()).put("path", "org/ow2/asm/asm-all/4.1/asm-all-4.1.jar");
                  var104.put("sha1", "054986e962b88d8660ae4566475658469595ef58");
                  var104.put("size", 214592);
                  var104.put("url", "https://libraries.minecraft.net/org/ow2/asm/asm-all/4.1/asm-all-4.1.jar");
                  var71.put("artifact", var104);
                  var57.put("downloads", var71);
                  var57.put("name", "org.ow2.asm:asm-all:4.1");
                  var88.add(var57);
               }

               try {
                  byte[] var107 = b();
                  var27.a(var107);
               } catch (Exception var19) {
                  var19.printStackTrace();
               }

               var88.add(a(DoomsdayGUI.a_int, DoomsdayGUI.a_String_1));
               var49.put("type", "modified");
               var49.put("jar", var36);
               File var108 = new File(this.a_cw_1.a_aq_1.a_JTextField.getText(), "versions");
               File var72 = new File(var108, var45.a_String_1);
               if (this.a_cw_1.b_JCheckBox_1.isSelected()) {
                  var84 = this.a_cw_1.a_JTextField_2.getText();
                  var49.put("id", var84);
                  File var114 = new File(var72, var45.a_String_1 + ".jar");
                  File var121 = new File(var108, var84);
                  File var73 = new File(var121, var84 + ".jar");
                  File var90;
                  if ((var90 = new File(var121, this.a_cw_1.a_JTextField_2.getText() + ".json")).exists()) {
                     throw new RuntimeException("Instance already exists");
                  }

                  var121.mkdir();
                  if (var114.exists()) {
                     try {
                        FileUtils.a_void(var114, var73);
                     } catch (Exception var18) {
                        throw new RuntimeException("Error copy minecraft from " + var114 + " to " + var73 + ": " + var18.getMessage());
                     }
                  }

                  try {
                     FileOutputStream var37;
                     (var37 = new FileOutputStream(var90)).write(C_dt.a(var49).getBytes(a_Charset));
                     var37.close();
                  } catch (Exception var17) {
                     throw new RuntimeException("Error create json file: " + var17.getMessage());
                  }

                  if (PlatformUtil.k()) {
                     this.b_void();
                  }
               } else {
                  try {
                     File var91 = new File(var72, ((C_dn)var27.a_cw_1.a_JComboBox_3.getSelectedItem()).a_String_1 + ".json");
                     FileOutputStream var115;
                     (var115 = new FileOutputStream(var91)).write(C_dt.a(var49).getBytes(a_Charset));
                     var115.close();
                  } catch (Exception var16) {
                     throw new RuntimeException("Error rewrite existing json file: " + var16.getMessage());
                  }
               }
            } else {
               C_cv var28 = this;
               File var38;
               if (!(var38 = new File(this.a_cw_1.a_aq_1.a_JTextField.getText())).exists()) {
                  throw new RuntimeException("Launcher not found: ".concat(String.valueOf(var38)));
               }

               if (this.a_cw_1.a_JComboBox_3.getItemCount() == 0) {
                  throw new RuntimeException("Please download version of minecraft on which you want to install DoomsDay");
               }

               if (this.a_cw_1.a_JComboBox_3.getSelectedItem() == null) {
                  throw new RuntimeException("Please select minecraft version");
               }

               if (this.a_cw_1.d_JComboBox.getSelectedItem() == null) {
                  throw new RuntimeException("Please select doomsday version");
               }

               this.a_void();
               C_dn var46;
               String var39 = a((var46 = (C_dn)this.a_cw_1.a_JComboBox_3.getSelectedItem()).a_dt);
               C_dt var50 = ((C_dn)this.a_cw_1.a_JComboBox_3.getSelectedItem()).a_dt;
               C_dt var51;
               String var58 = (String)(var51 = new C_dt(var50)).get("mainClass");
               String var74 = (String)var51.get("minecraftArguments");
               String var92 = this.a_cw_1.a_a.a_au_9.a_String(this.a());
               String var105 = new String(C_ap.a(var92.getBytes(a_Charset)), a_Charset);
               if (var74 != null) {
                  if ((var74 = a(var74)).length() > 0) {
                     var74 = var74 + ' ';
                  }

                  var74 = var74 + "--mainClass " + var58;
                  var74 = var74 + " --doomsdayargs=" + var105 + " ";
                  var51.put("minecraftArguments", var74);
               } else {
                  C_dt var93;
                  C_dr var109;
                  if ((var109 = (C_dr)(var93 = (C_dt)var51.get("arguments")).get("game")) == null) {
                     var109 = new C_dr();
                     var51.put("game", var109);
                  }

                  C_dr var75;
                  if ((var75 = (C_dr)var93.get("jvm")) != null) {
                     b_void(var75);
                  }

                  c_void(var109);
                  if (var109.size() > 0 && var109.get(0) instanceof C_dt) {
                     C_dt var94;
                     (var94 = new C_dt()).put("value", "--doomsdayargs=".concat(String.valueOf(var105)));
                     var109.add(var94);
                     C_dt var116;
                     (var116 = new C_dt()).put("value", "--mainClass");
                     var109.add(var116);
                     C_dt var122;
                     (var122 = new C_dt()).put("value", var58);
                     var109.add(var122);
                  } else {
                     var109.add("--doomsdayargs=".concat(String.valueOf(var105)));
                     var109.add("--mainClass");
                     var109.add(var58);
                  }
               }

               C_dr var95 = (C_dr)var51.get("libraries");
               var51.put("mainClass", DoomsdayGUI.b_String_2);

               try {
                  byte[] var110 = b();
                  var28.a(var110);
               } catch (Exception var15) {
                  var15.printStackTrace();
               }

               var95.add(a(DoomsdayGUI.a_int, DoomsdayGUI.a_String_1));
               var51.put("type", "modified");
               var51.put("jar", var39);
               File var111 = new File(this.a_cw_1.a_aq_1.a_JTextField.getText(), "versions");
               File var79 = new File(var111, var46.a_String_1);
               if (this.a_cw_1.b_JCheckBox_1.isSelected()) {
                  var92 = this.a_cw_1.a_JTextField_2.getText();
                  var51.put("id", var92);
                  File var117 = new File(var79, var46.a_String_1 + ".jar");
                  File var123 = new File(var111, var92);
                  File var80 = new File(var123, var92 + ".jar");
                  File var97;
                  if ((var97 = new File(var123, this.a_cw_1.a_JTextField_2.getText() + ".json")).exists()) {
                     throw new RuntimeException("Instance already exists");
                  }

                  var123.mkdir();
                  if (var117.exists()) {
                     try {
                        FileUtils.a_void(var117, var80);
                     } catch (Exception var14) {
                        throw new RuntimeException("Error copy minecraft from " + var117 + " to " + var80 + ": " + var14.getMessage());
                     }
                  }

                  try {
                     FileOutputStream var40;
                     (var40 = new FileOutputStream(var97)).write(C_dt.a(var51).getBytes(a_Charset));
                     var40.close();
                  } catch (Exception var13) {
                     throw new RuntimeException("Error create json file: " + var13.getMessage());
                  }

                  if (PlatformUtil.k()) {
                     this.b_void();
                  }
               } else {
                  try {
                     File var98 = new File(var79, ((C_dn)var28.a_cw_1.a_JComboBox_3.getSelectedItem()).a_String_1 + ".json");
                     FileOutputStream var118;
                     (var118 = new FileOutputStream(var98)).write(C_dt.a(var51).getBytes(a_Charset));
                     var118.close();
                  } catch (Exception var12) {
                     throw new RuntimeException("Error rewrite existing json file: " + var12.getMessage());
                  }
               }
            }
         }

         this.a_cw_1.a_a.a("Successfully installed", "Install", 4, false);
         C_dn var29 = (C_dn)this.a_cw_1.a_JComboBox_3.getSelectedItem();
         C_dn[] var41;
         if ((var41 = this.a_cw_1.a()) == null) {
            this.a_cw_1.a_JComboBox_3.setModel(new DefaultComboBoxModel<>(FileUtils.a((Object[])(new C_dn[0]))));
         } else {
            this.a_cw_1.a_JComboBox_3.setModel(new DefaultComboBoxModel<>(FileUtils.a((Object[])var41)));

            for (int var42 = 0; var42 < this.a_cw_1.a_JComboBox_3.getItemCount(); var42++) {
               if (((C_dn)this.a_cw_1.a_JComboBox_3.getItemAt(var42)).a_String_1.equals(var29.a_String_1)) {
                  this.a_cw_1.a_JComboBox_3.setSelectedIndex(var42);
                  break;
               }
            }
         }

         this.a_cw_1.a_void_2();
      } catch (Exception var25) {
         this.a_cw_1.a_a.b("Error install: " + var25.getMessage(), "Error");
         var25.printStackTrace();
      }
   }

   private String a() {
      return this.a_cw_1.b_JComboBox.getSelectedIndex() == 0 ? "$default$" : this.a_cw_1.b_aq_2.a_JTextField.getText();
   }

   private static String a(C_dt var0) {
      String var1 = (String)var0.get("id");
      String var2;
      if ((var2 = (String)var0.get("jar")) != null) {
         var1 = var2;
      }

      String var3;
      if ((var3 = (String)var0.get("inheritsFrom")) != null) {
         var1 = var3;
      }

      return var1;
   }

   private void a_void() {
      File var1;
      if (!(var1 = new File(this.a_cw_1.b_aq_2.a_JTextField.getText())).exists() && !var1.mkdirs()) {
         throw new RuntimeException("Error create update folder: ".concat(String.valueOf(var1)));
      } else if (var1.isFile()) {
         throw new RuntimeException("Update folder is file: " + var1 + ", please remove");
      } else {
         ClientVersion var2 = null;
         Object var3;
         if ((var3 = this.a_cw_1.d_JComboBox.getSelectedItem()) instanceof ClientVersion) {
            var2 = (ClientVersion)var3;
         } else if (var3 instanceof LocalClientVersion) {
            var2 = ((LocalClientVersion)var3).a_gg;
         }

         if (!var2.d()) {
            try {
               VersionManager.a(var2, var1);
            } catch (Exception var6) {
               var2.a_dbl_2 = -1.0;
               throw new RuntimeException(var6);
            }
         }

         try {
            var3 = VersionManager.c(var2);
         } catch (Exception var5) {
            throw new RuntimeException("Error read update " + var2 + " " + var5.getClass() + " " + var5.getMessage());
         }

         try {
            FileOutputStream var7;
            (var7 = new FileOutputStream(new File(var1, var2.a_String))).write((byte[])var3);
            var7.close();
         } catch (Exception var4) {
            throw new RuntimeException("Error write update " + var2 + " " + var4.getClass() + " " + var4.getMessage());
         }
      }
   }

   private void b_void() {
      File var1 = new File(GamePathUtils.b(), "launcher_profiles.json");

      try {
         C_dt var2;
         C_dt var3;
         if ((var3 = (C_dt)(var2 = (C_dt)new C_du().a(new String(FileUtils.a_arr_byte_2(var1), FileUtils.a_Charset), null)).get("profiles")) == null) {
            var3 = new C_dt();
            var2.put("profiles", var3);
         }

         C_dt var4;
         (var4 = new C_dt()).put("lastVersionId", this.a_cw_1.a_JTextField_2.getText());
         var4.put("logConfigIsXML", Boolean.FALSE);
         var4.put("name", "dd");
         var3.put(UUID.randomUUID().toString(), var4);
         FileUtils.a(var1, C_dt.a(var2).getBytes(FileUtils.a_Charset));
      } catch (Throwable var5) {
         var5.printStackTrace();
      }
   }

   private void a(byte[] var1) {
      File var2 = new File(this.a_cw_1.a_aq_1.a_JTextField.getText(), "libraries");
      var2 = new File(var2, "com");
      var2 = new File(var2, "doomsday");
      var2 = new File(var2, "tweaker");
      File var7;
      (var7 = new File(var2, "2.11")).mkdirs();
      var2 = new File(var7, "tweaker-2.11.jar");

      try {
         FileOutputStream var9;
         (var9 = new FileOutputStream(var2)).write(var1);
         var9.close();
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   private static boolean a_bool(C_dr var0) {
      for (int var1 = 0; var1 < var0.size(); var1++) {
         Object var2;
         if (var0.get(var1) instanceof C_dt) {
            Object nameVal = ((C_dt)var0.get(var1)).get("name");
            if (nameVal instanceof String && ((String)nameVal).contains("org.apache") && ((String)nameVal).contains("log4j-core")) {
               return true;
            }
         }
      }

      return false;
   }

   private static void a(C_dr var0) {
      for (int var1 = var0.size() - 1; var1 >= 0; var1--) {
         Object var2;
         if (var0.get(var1) instanceof C_dt
            && (var2 = ((C_dt)var0.get(var1)).get("name")) != null
            && var2 instanceof String
            && ((String)var2).startsWith("net.minecraft:launchwrapper")) {
            var0.remove(var1);
         }
      }
   }

   private static boolean b(C_dr var0) {
      for (int var1 = 0; var1 < var0.size(); var1++) {
         Object var2;
         if (var0.get(var1) instanceof C_dt
            && (var2 = ((C_dt)var0.get(var1)).get("name")) != null
            && var2 instanceof String
            && ((String)var2).contains("org.ow2")) {
            return true;
         }
      }

      return false;
   }

   private static boolean c(C_dr var0) {
      for (int var1 = 0; var1 < var0.size(); var1++) {
         Object var2;
         if (var0.get(var1) instanceof C_dt
            && (var2 = ((C_dt)var0.get(var1)).get("name")) != null
            && var2 instanceof String
            && ((String)var2).contains("jopt-simple")) {
            return true;
         }
      }

      return false;
   }

   private static boolean d(C_dr var0) {
      for (int var1 = 0; var1 < var0.size(); var1++) {
         Object var2;
         if (var0.get(var1) instanceof C_dt) {
            Object nameVal = ((C_dt)var0.get(var1)).get("name");
            if (nameVal instanceof String && ((String)nameVal).contains("org.apache") && ((String)nameVal).contains("log4j-api")) {
               return true;
            }
         }
      }

      return false;
   }

   private static boolean a(C_dr var0, int var1, String... var2) {
      Object var3;
      if ((var3 = var0.get(var1)) instanceof String) {
         if (var2.length == 1) {
            if (var2[0] == null) {
               return true;
            }

            return var2[0].equals(var3);
         }
      } else if (var3 instanceof C_dt) {
         Object var7;
         if ((var7 = ((C_dt)(var3 = (C_dt)var3)).get("values")) != null) {
            if (var7 instanceof String) {
               if (var2.length == 1) {
                  if (var2[0] == null) {
                     return true;
                  }

                  return var2[0].equals(var7);
               }
            } else {
               C_dr var8;
               if (var7 instanceof C_dr && (var8 = (C_dr)var7).size() == var2.length) {
                  for (int var6 = 0; var6 < var2.length; var6++) {
                     if (var2[var6] != null && !var2[var6].equals(var8.get(var6))) {
                        return false;
                     }
                  }

                  return true;
               }
            }
         }

         Object var9;
         if ((var9 = ((C_dt)var3).get("value")) != null) {
            if (var9 instanceof String) {
               if (var2.length == 1) {
                  if (var2[0] == null) {
                     return true;
                  }

                  return var2[0].equals(var9);
               }
            } else {
               C_dr var10;
               if (var9 instanceof C_dr && (var10 = (C_dr)var9).size() == var2.length) {
                  for (int var5 = 0; var5 < var2.length; var5++) {
                     if (var2[var5] != null && !var2[var5].equals(var10.get(var5))) {
                        return false;
                     }
                  }

                  return true;
               }
            }
         }
      }

      return false;
   }

   private static boolean a(C_dr var0, int var1, String var2) {
      Object var3;
      if ((var3 = var0.get(var1)) instanceof String) {
         return var3.toString().startsWith(var2);
      } else {
         if (var3 instanceof C_dt) {
            Object var5;
            C_dr var6;
            Object var7;
            if ((var5 = ((C_dt)(var3 = (C_dt)var3)).get("values")) != null
               && var5 instanceof C_dr
               && (var6 = (C_dr)var5).size() > 0
               && (var7 = var6.get(0)) instanceof String
               && var7.toString().startsWith(var2)) {
               return true;
            }

            Object var8;
            if ((var8 = ((C_dt)var3).get("value")) != null && var8 instanceof String) {
               return var8.toString().startsWith(var2);
            }
         }

         return false;
      }
   }

   // $VF: Could not properly define all variable types!
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private static void b_void(C_dr var0) {
      for (int var1 = var0.size() - 1; var1 >= 0; var1--) {
         if (a(var0, var1, "-javaagent:")) {
            Object var2;
            String var10000;
            if ((var2 = var0.get(var1)) instanceof String) {
               var10000 = var2.toString();
            } else {
               label54: {
                  if (var2 instanceof C_dt) {
                     Object var3;
                     if ((var3 = ((C_dt)(var2 = (C_dt)var2)).get("values")) != null
                        && var3 instanceof C_dr
                        && ((C_dr)var3).size() > 0
                        && ((C_dr)var3).get(0) instanceof String) {
                        var10000 = var3.toString();
                        break label54;
                     }

                     if ((var3 = ((C_dt)var2).get("value")) != null && var3 instanceof String) {
                        var10000 = var3.toString();
                        break label54;
                     }
                  }

                  var10000 = null;
               }
            }

            var2 = var10000;

            try {
               String vstr = (String)var2;
                var2 = NativeBinaryManager.a_arr_byte(vstr.substring(vstr.indexOf(61) + 1));
               if (new String((byte[])var2, a_Charset).toLowerCase().contains("doomsday")) {
                  var0.remove(var1);
               }
            } catch (Exception var4) {
               var4.printStackTrace();
            }
         }
      }
   }

   private static void c_void(C_dr var0) {
      for (int var1 = var0.size() - 1; var1 >= 0; var1--) {
         if (a(var0, var1, "--tweakClass", DoomsdayGUI.c_String)) {
            var0.remove(var1);
         } else if (a(var0, var1, "--tweakClass")) {
            if (var1 + 1 < var0.size() && a(var0, var1 + 1, DoomsdayGUI.c_String)) {
               var0.remove(var1 + 1);
               var0.remove(var1);
            }
         } else if (a(var0, var1, "--mainClass")) {
            if (var1 + 1 < var0.size() && !a(var0, var1 + 1, "--")) {
               var0.remove(var1 + 1);
            }

            var0.remove(var1);
         } else if (a(var0, var1, "--doomsdayargs=")) {
            var0.remove(var1);
         }
      }
   }

   private static String a(String var0) {
      StringBuilder var4;
      int var1 = (var4 = new StringBuilder(var0)).indexOf("--tweakClass " + DoomsdayGUI.c_String);
      int var2 = ("--tweakClass " + DoomsdayGUI.c_String).length();
      if (var1 > 0) {
         if (var4.charAt(var1 - 1) == ' ') {
            var1--;
            var2++;
         } else {
            var1 = -1;
         }
      }

      if (var1 >= 0) {
         var4.delete(var1, var1 + var2);
      }

      if ((var1 = var4.indexOf("--mainClass")) > 0) {
         if (var4.charAt(var1 - 1) == ' ') {
            var1--;
         } else {
            var1 = -1;
         }
      }

      if (var1 >= 0) {
         var2 = var1 + 11;
         int var3;
         if ((var3 = var4.indexOf(" ", var1 + 1)) >= 0
            && var3 + 1 < var4.length()
            && var4.charAt(var3 + 1) != '-'
            && (var2 = var4.indexOf(" ", var3 + 1)) == -1) {
            var2 = var4.length();
         }

         var4.delete(var1, var2);
      }

      if ((var2 = var4.indexOf("--doomsdayargs=")) > 0) {
         if (var4.charAt(var2 - 1) == ' ') {
            var2--;
         } else {
            var2 = -1;
         }
      }

      if (var2 != -1) {
         int var8;
         if ((var8 = var4.indexOf(" ", var2 + 1)) == -1) {
            var8 = var4.length();
         }

         var4.delete(var2, var8);
      }

      return var4.toString().trim();
   }

   private static C_dt a(int var0, String var1) {
      C_dt var2 = new C_dt();
      C_dt var3 = new C_dt();
      C_dt var4;
      (var4 = new C_dt()).put("path", "com/doomsday/tweaker/2.11/tweaker-2.11.jar");
      var4.put("sha1", var1);
      var4.put("size", var0);
      var4.put("url", "https://doomsdayclient.com/download/tweaker-2.11.jar");
      var3.put("artifact", var4);
      var2.put("downloads", var3);
      var2.put("name", "com.doomsday:tweaker:2.11");
      return var2;
   }

   public static synchronized byte[] a_arr_byte_2() {
      if (d == null) {
         ByteArrayOutputStream var0 = new ByteArrayOutputStream(670000);

         try {
            C_ii var1;
            (var1 = new C_ii(var0)).b();
            ByteArrayInputStream var2 = new ByteArrayInputStream(LzmaDecompressor.a(DoomsdayGUI.d_arr_byte_1));
            DataInputStream var7 = new DataInputStream(var2);

            for (int var3 = 0; var3 < 11; var3++) {
               byte[] var4 = new byte[var7.read()];
               var7.readFully(var4);
               String var10 = new String(var4, FileUtils.a_Charset);
               byte[] var5 = new byte[var7.readInt()];
               var7.readFully(var5);
               C_if var11;
               (var11 = new C_if(var10.substring(1))).a_void_3();
               var1.a(var11);
               var1.write(var5);
               var1.c();
            }

            C_if var8;
            (var8 = new C_if(DoomsdayGUI.d_String.substring(1))).a_void_3();
            var1.a(var8);
            byte[] var12;
            DoomsdayGUI.a(var12 = (byte[])DoomsdayGUI.b_arr_byte_3.clone(), DoomsdayGUI.d_String);
            var1.write(var12);
            var1.c();
            (var8 = new C_if(DoomsdayGUI.e_String.substring(1))).a_void_3();
            var1.a(var8);
            DoomsdayGUI.a(var12 = (byte[])DoomsdayGUI.a_arr_byte_6.clone(), DoomsdayGUI.e_String);
            var1.write(var12);
            var1.c();
            var1.close();
            d = var0.toByteArray();
         } catch (Exception var6) {
            throw new RuntimeException(var6);
         }
      }

      return d;
   }

   private static byte[] b() {
      if (a_arr_byte_2 != null) {
         return a_arr_byte_2;
      } else {
         String var0;
         if (!(var0 = FileUtils.a_String(a_arr_byte_2 = a_arr_byte_2())).equalsIgnoreCase(DoomsdayGUI.a_String_1)) {
            System.out.println("Tweaker sha doesn't match! " + var0 + " " + DoomsdayGUI.a_String_1 + ". Sizes " + a_arr_byte_2.length + " " + DoomsdayGUI.a_int);

            try {
               EncryptedHttpClient var2;
               if ((var2 = EncryptedHttpClient.a("doomsdayclient.com", b, c, "/download/tweaker-2.11.jar")).b_int_2 != 200) {
                  throw new RuntimeException("Http error: " + var2.b_int_2);
               }

               byte[] var3;
               a_arr_byte_2 = var3 = var2.c_arr_byte;
               return var3;
            } catch (Throwable var1) {
               var1.printStackTrace();
            }
         }

         return a_arr_byte_2;
      }
   }
}
