import java.nio.charset.Charset;

public final class C_bl extends Thread {
   private EncryptedHttpClient a_bj;
   public long a_long_1;

   public C_bl(EncryptedHttpClient var1) {
      this.a_bj = var1;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   @Override
   public final void run() {
      int var1 = -1;
      int var2 = -1;
      int var3 = -1;
      byte[] var4 = null;
      byte[] var5 = null;
      NativeBinaryManager var6 = null;
      byte[] var7 = "HTTP/".getBytes(Charset.forName("UTF-8"));
      byte[] var8 = "Content-Length: ".getBytes(Charset.forName("UTF-8"));
      byte[] var9 = "\r\n\r\n".getBytes(Charset.forName("UTF-8"));
      byte[] var10 = "\n\n".getBytes(Charset.forName("UTF-8"));
      byte[] var11 = "Transfer-Encoding: chunked".getBytes(Charset.forName("UTF-8"));
      boolean var51 = false /* VF: Semaphore variable */;

      label949: {
         label950: {
            label951: {
               label952: {
                  label953: {
                     label954: {
                        label955: {
                           label956: {
                              label957: {
                                 label958: {
                                    try {
                                       label975: {
                                          try {
                                             var51 = true;
                                             ExternalProcessInjector var12;
                                             if ((var12 = C_bd.a(this.a_bj.a_CharSequence)).a_ArrayList_3.size() <= 0) {
                                                throw new RuntimeException();
                                             }

                                             var4 = ((C_aw)var12.a_ArrayList_3.get(0)).a();
                                          } catch (Exception var78) {
                                             var78.printStackTrace();
                                             var4 = (byte[])this.a_bj.a_arr_byte_1.clone();
                                          }

                                          try {
                                             if (var4 == null) {
                                                throw new NullPointerException();
                                             }

                                             this.a_bj.a_fh_3.a(var4, this.a_bj.a_int_2);
                                          } catch (Exception var77) {
                                             try {
                                                ExternalProcessInjector var13;
                                                if ((var13 = C_bd.b(this.a_bj.a_CharSequence)).a_ArrayList_3.size() <= 0) {
                                                   throw new RuntimeException();
                                                }

                                                var5 = (byte[])((C_aw)var13.a_ArrayList_3.get(0)).a().clone();
                                             } catch (Exception var76) {
                                                var5 = (byte[])this.a_bj.b_arr_byte.clone();
                                             }

                                             this.a_bj.a_fh_3.a(var5, this.a_bj.a_int_2);
                                          }

                                          StringBuilder var107;
                                          (var107 = new StringBuilder()).append("GET ");
                                          var107.append(this.a_bj.b_CharSequence_1);
                                          var107.append(" HTTP/1.1\r\n");
                                          var107.append("User-Agent: Java\r\n");
                                          var107.append("Host: ");
                                          var107.append(this.a_bj.a_CharSequence);
                                          var107.append("\r\n");
                                          var107.append("Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\r\n");
                                          var107.append("Connection: keep-alive\r\n\r\n");
                                          byte[] var109 = var107.toString().getBytes(FileUtils.a_Charset);
                                          this.a_bj.a_fh_3.a_int(var109, var109.length);
                                          int var110 = (var6 = new NativeBinaryManager((byte)0)).c_int();
                                          var107.delete(0, var107.length());
                                          boolean var108 = false;
                                          int var14 = 0;
                                          int var15 = -1;
                                          int var16 = -1;
                                          boolean var17 = true;
                                          int var18 = 0;

                                          while (true) {
                                             if (++var18 > 100000) {
                                                System.out.println("[2] Infinity http loop?");
                                                var51 = false;
                                                break label952;
                                             }

                                             if (var17) {
                                                if (this.a_bj.a_fh_3.a(var6) <= 0) {
                                                   var51 = false;
                                                   break label953;
                                                }

                                                this.a_long_1 = System.currentTimeMillis();
                                             }

                                             if (var3 == -1) {
                                                if ((var15 = var6.a(var7, var110)) == -1) {
                                                   System.err.println(var6.a_String_2(var6.b_int_2(), var6.c_int()));
                                                   System.out.println("[2] No headers? WTF?");
                                                   var51 = false;
                                                   break label954;
                                                }

                                                int var19;
                                                if ((var19 = var6.a((byte)32, var15)) < 0) {
                                                   System.out.println("[2] secondSpace < 0");
                                                   var51 = false;
                                                   break label955;
                                                }

                                                int var20;
                                                if ((var20 = var6.a((byte)32, var19 + 1)) < 0) {
                                                   System.out.println("[2] secondSpace < 0");
                                                   var51 = false;
                                                   break label956;
                                                }

                                                try {
                                                   var3 = var6.a_int(var19 + 1, var20);
                                                } catch (Throwable var79) {
                                                   System.out.println("[2] parseResponseCode");
                                                   var79.printStackTrace();
                                                   var51 = false;
                                                   break label951;
                                                }
                                             }

                                             if (var2 == -1) {
                                                if ((var2 = var6.a(var9, var15)) >= 0) {
                                                   var2 += var9.length;
                                                } else if ((var2 = var6.a(var10, var15)) >= 0) {
                                                   var2 += var10.length;
                                                }

                                                var16 = var2;
                                                if (var2 < 0) {
                                                   var17 = true;
                                                }

                                                if (var2 < 0 && var6.c_int() - var15 > 8192) {
                                                   System.out.println("[2] Not found headers end > 8192");
                                                   var51 = false;
                                                   break label957;
                                                }
                                             }

                                             if (var16 >= 0) {
                                                if (var1 == -1 && !var108) {
                                                   int var111;
                                                   int var113;
                                                   if ((var111 = var6.a(var8, var15, var16)) > 0 && (var113 = var6.a((byte)10, var111)) > 0) {
                                                      if (var6.a_byte_2(var113 - 1) == 13) {
                                                         var113--;
                                                      }

                                                      var1 = var6.a_int(var111 + var8.length, var113);
                                                      this.a_bj.c_int_1 = var1;
                                                   }

                                                   var108 = var6.a(var11, var15, var16) >= 0;
                                                   var6.a_void_3(var15, var16);
                                                   var6.b(var15);
                                                   var16 = var15;
                                                }

                                                if (var108) {
                                                   if (var14 == 0) {
                                                      if (var6.d() >= 4) {
                                                         var14 = Integer.parseInt(var6.a_String_2(), 16);
                                                         this.a_bj.c_int_1 += var14;
                                                         if (var14 == 0) {
                                                            var6.a_String_2();
                                                            if (var6.d() == 0) {
                                                               break;
                                                            }

                                                            var110 = var6.b_int_2();
                                                            var1 = -1;
                                                            var2 = -1;
                                                            var3 = -1;
                                                            var108 = false;
                                                            var14 = 0;
                                                            var15 = -1;
                                                            var16 = -1;
                                                            var17 = false;
                                                         }
                                                      } else {
                                                         var17 = true;
                                                      }
                                                   }

                                                   if (var14 > 0) {
                                                      if (var6.d() >= var14 + 2) {
                                                         var6.a(var14);
                                                         var6.a_String_2();
                                                         var14 = 0;
                                                         var17 = false;
                                                      } else {
                                                         var17 = true;
                                                      }
                                                   }
                                                } else {
                                                   if (var1 < 0) {
                                                      System.out.println("Http headers not contains content length or transfer encoding");
                                                      var51 = false;
                                                      break label975;
                                                   }

                                                   if (this.a_bj.a_bk_4 != null) {
                                                      int var112 = var6.c_int();
                                                      this.a_bj.a_bk_4.a((double)var112 / var1);
                                                   }

                                                   if (var6.d() == var1) {
                                                      break;
                                                   }

                                                   if (var6.d() > var1) {
                                                      var110 = var6.b_int_2() + var1;
                                                      var1 = -1;
                                                      var2 = -1;
                                                      var3 = -1;
                                                      var108 = false;
                                                      var14 = 0;
                                                      var15 = -1;
                                                      var16 = -1;
                                                      var17 = false;
                                                   } else {
                                                      var17 = true;
                                                   }
                                                }
                                             }
                                          }

                                          this.a_bj.c_arr_byte = var6.a(0, var6.c_int());
                                          this.a_bj.b_int_2 = var3;
                                          this.a_bj.a_fh_3.a();
                                          var51 = false;
                                          break label958;
                                       }
                                    } catch (Throwable var80) {
                                       if (var2 != -1) {
                                          var1 = var6.a_int() - var2;
                                          this.a_bj.c_arr_byte = var6.a(var2, var1);
                                          this.a_bj.b_int_2 = var3;
                                          var51 = false;
                                          break label949;
                                       }

                                       this.a_bj.a_Throwable_5 = var80;
                                       System.out.println("BAD ONE");
                                       var80.printStackTrace();
                                       var51 = false;
                                       break label950;
                                    } finally {
                                       if (var51) {
                                          if (var4 != null) {
                                             for (int var83 = 0; var83 < var4.length; var83++) {
                                                var4[var83] = 0;
                                             }
                                          }

                                          if (var5 != null) {
                                             for (int var84 = 0; var84 < var5.length; var84++) {
                                                var5[var84] = 0;
                                             }
                                          }

                                          if (var6 != null) {
                                             try {
                                                var6.b_void();
                                             } catch (Throwable var53) {
                                             }
                                          }

                                          try {
                                             this.a_bj.a_fh_3.a();
                                          } catch (Throwable var52) {
                                          }
                                       }
                                    }

                                    if (var4 != null) {
                                       for (int var93 = 0; var93 < var4.length; var93++) {
                                          var4[var93] = 0;
                                       }
                                    }

                                    if (var5 != null) {
                                       for (int var94 = 0; var94 < var5.length; var94++) {
                                          var5[var94] = 0;
                                       }
                                    }

                                    try {
                                       var6.b_void();
                                    } catch (Throwable var75) {
                                    }

                                    try {
                                       this.a_bj.a_fh_3.a();
                                       return;
                                    } catch (Throwable var74) {
                                       return;
                                    }
                                 }

                                 if (var4 != null) {
                                    for (int var91 = 0; var91 < var4.length; var91++) {
                                       var4[var91] = 0;
                                    }
                                 }

                                 if (var5 != null) {
                                    for (int var92 = 0; var92 < var5.length; var92++) {
                                       var5[var92] = 0;
                                    }
                                 }

                                 try {
                                    var6.b_void();
                                 } catch (Throwable var73) {
                                 }

                                 try {
                                    this.a_bj.a_fh_3.a();
                                    return;
                                 } catch (Throwable var72) {
                                    return;
                                 }
                              }

                              if (var4 != null) {
                                 for (int var95 = 0; var95 < var4.length; var95++) {
                                    var4[var95] = 0;
                                 }
                              }

                              if (var5 != null) {
                                 for (int var96 = 0; var96 < var5.length; var96++) {
                                    var5[var96] = 0;
                                 }
                              }

                              try {
                                 var6.b_void();
                              } catch (Throwable var71) {
                              }

                              try {
                                 this.a_bj.a_fh_3.a();
                                 return;
                              } catch (Throwable var70) {
                                 return;
                              }
                           }

                           if (var4 != null) {
                              for (int var97 = 0; var97 < var4.length; var97++) {
                                 var4[var97] = 0;
                              }
                           }

                           if (var5 != null) {
                              for (int var98 = 0; var98 < var5.length; var98++) {
                                 var5[var98] = 0;
                              }
                           }

                           try {
                              var6.b_void();
                           } catch (Throwable var69) {
                           }

                           try {
                              this.a_bj.a_fh_3.a();
                              return;
                           } catch (Throwable var68) {
                              return;
                           }
                        }

                        if (var4 != null) {
                           for (int var99 = 0; var99 < var4.length; var99++) {
                              var4[var99] = 0;
                           }
                        }

                        if (var5 != null) {
                           for (int var100 = 0; var100 < var5.length; var100++) {
                              var5[var100] = 0;
                           }
                        }

                        try {
                           var6.b_void();
                        } catch (Throwable var67) {
                        }

                        try {
                           this.a_bj.a_fh_3.a();
                           return;
                        } catch (Throwable var66) {
                           return;
                        }
                     }

                     if (var4 != null) {
                        for (int var101 = 0; var101 < var4.length; var101++) {
                           var4[var101] = 0;
                        }
                     }

                     if (var5 != null) {
                        for (int var102 = 0; var102 < var5.length; var102++) {
                           var5[var102] = 0;
                        }
                     }

                     try {
                        var6.b_void();
                     } catch (Throwable var65) {
                     }

                     try {
                        this.a_bj.a_fh_3.a();
                        return;
                     } catch (Throwable var64) {
                        return;
                     }
                  }

                  if (var4 != null) {
                     for (int var103 = 0; var103 < var4.length; var103++) {
                        var4[var103] = 0;
                     }
                  }

                  if (var5 != null) {
                     for (int var104 = 0; var104 < var5.length; var104++) {
                        var5[var104] = 0;
                     }
                  }

                  try {
                     var6.b_void();
                  } catch (Throwable var63) {
                  }

                  try {
                     this.a_bj.a_fh_3.a();
                     return;
                  } catch (Throwable var62) {
                     return;
                  }
               }

               if (var4 != null) {
                  for (int var105 = 0; var105 < var4.length; var105++) {
                     var4[var105] = 0;
                  }
               }

               if (var5 != null) {
                  for (int var106 = 0; var106 < var5.length; var106++) {
                     var5[var106] = 0;
                  }
               }

               try {
                  var6.b_void();
               } catch (Throwable var61) {
               }

               try {
                  this.a_bj.a_fh_3.a();
                  return;
               } catch (Throwable var60) {
                  return;
               }
            }

            if (var4 != null) {
               for (int var89 = 0; var89 < var4.length; var89++) {
                  var4[var89] = 0;
               }
            }

            if (var5 != null) {
               for (int var90 = 0; var90 < var5.length; var90++) {
                  var5[var90] = 0;
               }
            }

            try {
               var6.b_void();
            } catch (Throwable var59) {
            }

            try {
               this.a_bj.a_fh_3.a();
               return;
            } catch (Throwable var58) {
               return;
            }
         }

         if (var4 != null) {
            for (int var85 = 0; var85 < var4.length; var85++) {
               var4[var85] = 0;
            }
         }

         if (var5 != null) {
            for (int var86 = 0; var86 < var5.length; var86++) {
               var5[var86] = 0;
            }
         }

         if (var6 != null) {
            try {
               var6.b_void();
            } catch (Throwable var57) {
            }
         }

         try {
            this.a_bj.a_fh_3.a();
            return;
         } catch (Throwable var56) {
            return;
         }
      }

      if (var4 != null) {
         for (int var87 = 0; var87 < var4.length; var87++) {
            var4[var87] = 0;
         }
      }

      if (var5 != null) {
         for (int var88 = 0; var88 < var5.length; var88++) {
            var5[var88] = 0;
         }
      }

      if (var6 != null) {
         try {
            var6.b_void();
         } catch (Throwable var55) {
         }
      }

      try {
         this.a_bj.a_fh_3.a();
      } catch (Throwable var54) {
      }
   }
}
