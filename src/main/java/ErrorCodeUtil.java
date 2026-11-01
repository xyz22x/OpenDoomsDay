public final class ErrorCodeUtil {
   private static String a;

   static {
      try {
         a = System.getProperty("user.language");
      } catch (Throwable var0) {
      }
   }

   public static String a(int var0) {
      String var1;
      if (var0 == -17) {
         var1 = "Failed to create DoomsDay instance";
      } else if (var0 == -1) {
         var1 = "Injection error (-1): Native agent rejected payload. If using a custom JAR, please use Restart mode.";
      } else if (var0 < 0) {
         var1 = "DoomsDay internal error: ".concat(String.valueOf(var0));
      } else if (var0 == 301) {
         var1 = "Failed to find JNI_GetCreatedJavaVMs. Not java process?";
      } else if (var0 == 302) {
         var1 = "Failed to get VM. Weird java process";
      } else if (var0 == 303) {
         var1 = "Failed to get JNI. Protected java process?";
      } else if (var0 == 304) {
         var1 = "Failed to detect version. Probably not minecraft process?";
      } else if (var0 == 305) {
         if ("ru".equalsIgnoreCase(a)) {
            var1 = "Неподдерживаемая версия майнкрафта";
         } else if ("tr".equalsIgnoreCase(a)) {
            var1 = "Desteklenmeyen minecraft sürümü";
         } else if ("pl".equalsIgnoreCase(a)) {
            var1 = "Nieobsługiwana wersja Minecrafta";
         } else {
            var1 = "Unsupported minecraft version";
         }
      } else if (var0 == 306) {
         if ("ru".equalsIgnoreCase(a)) {
            var1 = "Устаревший лоадер. Скачайте новый";
         } else if ("tr".equalsIgnoreCase(a)) {
            var1 = "Eski yükleyici. Yenisini indir";
         } else if ("pl".equalsIgnoreCase(a)) {
            var1 = "Przestarzała wersja. Pobierz nową";
         } else {
            var1 = "Outdated loader";
         }
      } else if (var0 == 307) {
         if ("ru".equalsIgnoreCase(a)) {
            var1 = "DoomsDay уже был заинжекчен";
         } else if ("tr".equalsIgnoreCase(a)) {
            var1 = "DoomsDay zaten enjekte edildi";
         } else if ("pl".equalsIgnoreCase(a)) {
            var1 = "Doomsday jest już zinjectowany";
         } else {
            var1 = "DoomsDay is already loaded";
         }
      } else if (var0 != 311 && var0 != 312) {
         var1 = "DoomsDay load error: ".concat(String.valueOf(var0));
      } else {
         var1 = "Failed install hook ".concat(String.valueOf(var0));
      }

      return var1;
   }

   public static String b(int var0) {
      String var1;
      if (var0 == 200) {
         var1 = "Empty options";
      } else if (var0 == 201) {
         var1 = "Failed to open pipe";
      } else if (var0 == 202) {
         var1 = "Failed to read shellcode length from pipe";
      } else if (var0 == 203) {
         var1 = "Failed to read data length from pipe";
      } else if (var0 == 204) {
         var1 = "Failed to allocate temp memory for shellcode";
      } else if (var0 == 205) {
         var1 = "Failed to allocate temp memory for data";
      } else if (var0 == 206) {
         var1 = "Failed to calculate RX size in shellcode";
      } else if (var0 == 207) {
         if (PlatformUtil.h()) {
            var1 = "Failed to reserve memory for shellcode and data";
         } else {
            var1 = "Failed to allocate memory for shellcode and data";
         }
      } else if (var0 == 208) {
         if (PlatformUtil.h()) {
            var1 = "Failed to commit memory for shellcode";
         } else {
            var1 = "Failed to allocate memory for shellcode";
         }
      } else if (var0 == 209) {
         if (PlatformUtil.h()) {
            var1 = "Failed to commit memory for data";
         } else {
            var1 = "Failed to allocate memory for data";
         }
      } else if (var0 == 210) {
         var1 = "[!] Failed to allocate correct addresses for shellcode and data";
      } else if (var0 == 211) {
         var1 = "Failed to protect to RX shellcode";
      } else if (var0 == 212) {
         var1 = "Failed to find main entry";
      } else if (var0 == 213) {
         var1 = "Failed to find executable entry";
      } else if (var0 >= 215 && var0 <= 217) {
         var1 = "[WINDOWS] Failed to load shellcode: ".concat(String.valueOf(var0));
      } else if (var0 != 219 && var0 != 220 && (var0 < -10 || var0 > -8)) {
         if (var0 != 221 && var0 != 222) {
            var1 = "Load shellcode error: ".concat(String.valueOf(var0));
         } else {
            var1 = "[MACOS] Failed to load shellcode: ".concat(String.valueOf(var0));
         }
      } else {
         var1 = "[LINUX] Failed to load shellcode: ".concat(String.valueOf(var0));
      }

      return var1;
   }

   public static String c(int var0) {
      if (var0 == -1000002) {
         return "Could not create pipe";
      } else if (var0 == -1000002) {
         return "Not enough privileges";
      } else if (var0 == -1000003) {
         return "Could not open process";
      } else if (var0 == -1000004) {
         return "Could not allocate memory";
      } else if (var0 == -1000005) {
         return "Could not create remote thread";
      } else if (var0 == -1000006) {
         return "Cannot attach x64 to x32";
      } else if (var0 == -1000007) {
         return "Cannot attach x32 to x64";
      } else if (var0 == -1000008) {
         return "Attach is not supported by target process";
      } else if (var0 == -1000009) {
         return "Error reading response";
      } else if (var0 == -1000011) {
         return "Invalid pid provider";
      } else if (var0 == -1000012) {
         return "Process not found";
      } else if (var0 == -1000013) {
         return "Failed to change credentials";
      } else if (var0 == -1000014) {
         return "Could not start attach mechanism";
      } else if (var0 == -1000015) {
         return "Failed to connect socket";
      } else if (var0 == -1000016) {
         return "Error write to socket";
      } else if (var0 == -1000017) {
         return "Error create socket";
      } else if (var0 == -1000018) {
         return "Failed to allocate memory";
      } else if (var0 == -1000019) {
         return "Could not create attach trigger";
      } else {
         return var0 != 0 && var0 != 100 ? "Code: ".concat(String.valueOf(var0)) : "";
      }
   }
}
