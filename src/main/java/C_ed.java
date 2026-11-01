import java.util.LinkedHashMap;

public final class C_ed {
   private static C_ec[] a_arr_ec = new C_ec[384];
   private static C_ec[] b = new C_ec[256];
   private static C_ec[] c = new C_ec[16];
   protected static LinkedHashMap a_LinkedHashMap_1 = new LinkedHashMap(256);

   static {
      a(new C_ec("RIGHT_SHIFT", 344, 54));
      a(new C_ec("RIGHT_CONTROL", 345, 157));
      a(new C_ec("RIGHT_ALT", 346, 184));
      a(new C_ec("LEFT_ALT", 342, 56));
      a(new C_ec("A", 65, 30));
      a(new C_ec("B", 66, 48));
      a(new C_ec("C", 67, 46));
      a(new C_ec("D", 68, 32));
      a(new C_ec("E", 69, 18));
      a(new C_ec("F", 70, 33));
      a(new C_ec("G", 71, 34));
      a(new C_ec("H", 72, 35));
      a(new C_ec("I", 73, 23));
      a(new C_ec("J", 74, 36));
      a(new C_ec("K", 75, 37));
      a(new C_ec("L", 76, 38));
      a(new C_ec("M", 77, 50));
      a(new C_ec("N", 78, 49));
      a(new C_ec("O", 79, 24));
      a(new C_ec("P", 80, 25));
      a(new C_ec("Q", 81, 16));
      a(new C_ec("R", 82, 19));
      a(new C_ec("S", 83, 31));
      a(new C_ec("T", 84, 20));
      a(new C_ec("U", 85, 22));
      a(new C_ec("V", 86, 47));
      a(new C_ec("W", 87, 17));
      a(new C_ec("X", 88, 45));
      a(new C_ec("Y", 89, 21));
      a(new C_ec("Z", 90, 44));
      a(new C_ec("NONE", 0, 0));
      a(new C_ec("SPACE", 32, 57));
      a(new C_ec("APOSTROPHE", 39, 40));
      a(new C_ec("COMMA", 44, 51));
      a(new C_ec("MINUS", 45, 12));
      a(new C_ec("PERIOD", 46, 52));
      a(new C_ec("SLASH", 47, 53));
      a(new C_ec("0", 48, 11));
      a(new C_ec("1", 49, 2));
      a(new C_ec("2", 50, 3));
      a(new C_ec("3", 51, 4));
      a(new C_ec("4", 52, 5));
      a(new C_ec("5", 53, 6));
      a(new C_ec("6", 54, 7));
      a(new C_ec("7", 55, 8));
      a(new C_ec("8", 56, 9));
      a(new C_ec("9", 57, 10));
      a(new C_ec("SEMICOLON", 59, 39));
      a(new C_ec("EQUAL", 61, 13));
      a(new C_ec("LEFT_BRACKET", 91, 26));
      a(new C_ec("BACKSLASH", 92, 43));
      a(new C_ec("RIGHT_BRACKET", 93, 27));
      a(new C_ec("GRAVE_ACCENT", 96, 41));
      a(new C_ec("WORLD_1", 161, -1));
      a(new C_ec("WORLD_2", 162, 86));
      a(new C_ec("ESCAPE", 256, 1));
      a(new C_ec("ENTER", 257, 28));
      a(new C_ec("TAB", 258, 15));
      a(new C_ec("BACKSPACE", 259, 14));
      a(new C_ec("INSERT", 260, 210));
      a(new C_ec("DELETE", 261, 211));
      a(new C_ec("RIGHT", 262, 205));
      a(new C_ec("LEFT", 263, 203));
      a(new C_ec("DOWN", 264, 208));
      a(new C_ec("UP", 265, 200));
      a(new C_ec("PAGE_UP", 266, 201));
      a(new C_ec("PAGE_DOWN", 267, 209));
      a(new C_ec("HOME", 268, 199));
      a(new C_ec("END", 269, 207));
      a(new C_ec("CAPS_LOCK", 280, 58));
      a(new C_ec("SCROLL_LOCK", 281, 70));
      a(new C_ec("NUM_LOCK", 282, 69));
      a(new C_ec("PRINT_SCREEN", 283, 183));
      a(new C_ec("F1", 290, 59));
      a(new C_ec("F2", 291, 60));
      a(new C_ec("F3", 292, 61));
      a(new C_ec("F4", 293, 62));
      a(new C_ec("F5", 294, 63));
      a(new C_ec("F6", 295, 64));
      a(new C_ec("F7", 296, 65));
      a(new C_ec("F8", 297, 66));
      a(new C_ec("F9", 298, 67));
      a(new C_ec("F10", 299, 68));
      a(new C_ec("F11", 300, 87));
      a(new C_ec("F12", 301, 88));
      a(new C_ec("KP_0", 320, 82));
      a(new C_ec("KP_1", 321, 79));
      a(new C_ec("KP_2", 322, 80));
      a(new C_ec("KP_3", 323, 81));
      a(new C_ec("KP_4", 324, 75));
      a(new C_ec("KP_5", 325, 76));
      a(new C_ec("KP_6", 326, 77));
      a(new C_ec("KP_7", 327, 71));
      a(new C_ec("KP_8", 328, 72));
      a(new C_ec("KP_9", 329, 73));
      a(new C_ec("KP_DECIMAL", 330, 83));
      a(new C_ec("KP_DIVIDE", 331, 181));
      a(new C_ec("KP_MULTIPLY", 332, 55));
      a(new C_ec("KP_SUBTRACT", 333, 74));
      a(new C_ec("KP_ADD", 334, 78));
      a(new C_ec("KP_ENTER", 335, 28));
      a(new C_ec("KP_EQUAL", 336, 89));
      a(new C_ec("LEFT_SHIFT", 340, 42));
      a(new C_ec("LEFT_CONTROL", 341, 29));
      a(new C_ec("LEFT_SUPER", 343, -1));
      a(new C_ec("RIGHT_SUPER", 347, -1));
   }

   private static C_ec a(C_ec var0) {
      if (var0.a_int_1 <= -100) {
         int var1 = -var0.a_int_1 - 100;
         c[var1] = var0;
         a_LinkedHashMap_1.put(var0.a_String, var0);
         return var0;
      } else if (var0.a_int_1 < 0) {
         return null;
      } else {
         a_arr_ec[var0.a_int_1] = var0;
         if (var0.b >= 0) {
            b[var0.b] = var0;
         }

         a_LinkedHashMap_1.put(var0.a_String, var0);
         return var0;
      }
   }

   public static C_ec a(String var0) {
      return var0 == null ? null : (C_ec)a_LinkedHashMap_1.get(var0);
   }
}
