public final class C_fn extends Thread {
   @Override
   public final void run() {
      for (int var1 = 0; var1 < DoomsdayGUI.a_ArrayList_5.size(); var1++) {
         Integer var2;
         if ((var2 = (Integer)DoomsdayGUI.a_ArrayList_5.get(var1)) != null) {
            try {
               ProcessBuilder var4;
               if (PlatformUtil.h()) {
                  var4 = new ProcessBuilder("taskkill", "/PID", Integer.toString(var2), "/F");
               } else {
                  var4 = new ProcessBuilder("kill", Integer.toString(var2));
               }

               var4.start();
            } catch (Exception var3) {
            }
         }
      }

      DoomsdayGUI.a_ArrayList_5.clear();
   }
}
