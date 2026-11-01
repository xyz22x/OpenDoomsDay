# OpenDoomsDay

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-blue?style=flat-square)
![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20macOS%20%7C%20Linux-lightgrey?style=flat-square)
![License](https://img.shields.io/badge/License-Unlicense-red?style=flat-square)

</div>

A clean, fully recompilable Java process injector reconstructed from the Doomsday
client. Allows injecting custom `.jar` files and Java agents into running Java
processes (`javaw.exe`), such as Minecraft (vanilla, Forge or Fabric).

## Features

- Injects custom `.jar` files or Java agents into running Java processes
- Four injection modes: JVMTI Agent, Shellcode, Restart, Restart 2
- Cross-platform: Windows, macOS and Linux, with x64, x86 and ARM support
- Native memory hooks for reading and writing process memory
- Universal bootstrap agent compiled for Java 8 bytecode, running on JVMs from 8 to 25+
- Auto-updating process list with an integrated log console
- Headless automation via CLI flags (`--autoinject`)

## Download

Prebuilt binaries are available on the
[Releases page](https://github.com/xyz22x/OpenDoomsDay/releases):

```text
doomsday.jar    standalone executable (Windows / macOS / Linux)
jna.jar         required, place in the same directory
```

## Building

Requirements: JDK 17+. The build scripts automatically locate the newest
installed JDK under `C:\Program Files` (Adoptium, Liberica, Zulu or Oracle).

```powershell
# PowerShell
.\build.ps1

# or Batch
build.bat
```

Output: `dist\doomsday.jar` (307 classes) plus a copy of JNA in `dist\`.

## Usage

### GUI

```cmd
run.bat
:: or
java -jar dist\doomsday.jar
```

### Injecting a specific JAR

```cmd
run.bat C:\path\to\agent.jar
:: or
java -jar dist\doomsday.jar --jar="C:\path\to\agent.jar"
```

Drag and drop a `.jar` file onto `run.bat` also works.

### Ways to inject your own `.jar` files

1. **Select JAR button** in the GUI, pick any `.jar` and press Inject
2. **`custom_jars/` folder** — any `.jar` placed there shows up in the dropdown
3. **Command line / drag and drop** as shown above

### CLI flags

| Flag | Description |
| :--- | :--- |
| `--autoinject` | automatically inject into all found Minecraft processes |
| `--allowrestart` | allow restarting the injected process |
| `--jar=<path>` | custom JAR to inject |
| `--offsets` | print internal JVM offsets and exit |
| `--printenv` / `--printprops` | dump environment / system properties |
| `--killpid=<pid>` | force kill a process by PID |
| `--nostd` | suppress stdout/stderr (headless) |

## Project structure

```text
OpenDoomsDay/
├── src/main/java/         ~305 deobfuscated, recompilable Java sources
├── src/main/resources/    manifest, assets and embedded payloads
│   └── net/java/          encrypted native binaries (agent, JNA, shellcode)
├── lib/jna.jar            JNA 5.14.0 native access dependency
├── build.bat / build.ps1  build scripts
└── run.bat                launcher (auto-detects newest JDK)
```

### Core components

| Component | Classes |
| :--- | :--- |
| GUI / CLI entry point | `DoomsdayGUI` |
| Process enumeration and attach | `ProcessAttacher`, `ProcessListManager` |
| JVMTI / shellcode injection | `JvmtiInjector`, `ShellcodeLoader` |
| Native memory hooks | `ProcessMemoryHooks`, `WinMemoryManager` |
| Universal bootstrap agent | `UniversalBootstrapAgent` |
| Embedded crypto / payload decode | `CryptoUtil`, `JarEntryDecoder` |

## Legal notice

This project is provided for educational and research purposes only.
Injecting software into other processes may violate the Terms of Service
of any product. Credit for the original tool goes to doomsdayclient.com.
Use at your own risk.

## License

Unlicense. See [LICENSE](LICENSE).

---

<div align="center">
<sub>reversed</sub>
</div>
