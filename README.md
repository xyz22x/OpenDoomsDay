# Doomsday — Cracked by reversed

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-blue?style=flat-square)
![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20macOS%20%7C%20Linux-lightgrey?style=flat-square)
![License](https://img.shields.io/badge/License-Unlicense-red?style=flat-square)
![Release](https://img.shields.io/badge/Release-v2.11_cracked-purple?style=flat-square)

**Injector de JAR customizado e agente Java — reconstruído 100% recompilável a partir do Doomsday.**

</div>

---

## 📋 Sobre

Projeto de engenharia reversa do **Doomsday** (doomsdayclient.com): as classes ofuscadas
(`C_xx.java`) foram decompiladas, desofuscadas turno completo e agora **compilam com 0 erros**
usando apenas um JDK 17+ e o JNA.

O binário mantém **todas as funcionalidades** do original — nada foi removido, nada foi
modificado no comportamento. As únicas mudanças estão em `DoomsdayGUI.java` (tema) e
`TitleBarPanel.java` (botão Inject):

| Modificação | Detalhe |
| :--- | :--- |
| 🏷️ **Título da janela** | `"Cracked by reversed"` |
| 🖼️ **Ícone da janela** | [avatar customizado](https://r2.fakecrime.bio/uploads/2d667995-bb93-4351-85f8-4e148eb6b44d.png) |
| ⬛ **Fundo preto total** | Todos os painéis usam preto puro (`#000000`) |
| 🟣 **Botão Inject** | Azul → **roxo** (`#8000FF` / hover `#A050FF`) |

## ✨ Funcionalidades

- **Injection em процесsos Java** (`javaw.exe`) em execução: Minecraft Forge / Fabric / Vanilla
- **Injeção de `.jar` customizado** ou agente Java em um processo alvo
- **4 modos de insetion:** JVMTI Agent · Shellcode · Restart · Restart 2
- **Multi-OS:** Windows / macOS / Linux, com suporte a ARM (aarch64) e x86
- **Ganchos de memória** (ProcessMemoryHooks) para leitura/escrita nativa
- **Bootstrap universal em Java 8**: funciona em JVMs de 8 a 25+
- **Seletor de processos com auto-atualização** e console de logs integrado
- **Auto-inject** via CLI (`--autoinject`) para automação full headless

## 📥 Download

Baixe o `.jar` **pré-compilado** na página de Releases ou compile você mesmo:

> [**➡️ Releases — doomsday.jar**](../../releases)

```cmd
doomsday.jar                # executável standalone (Windows/Linux/macOS)
jna.jar                     # copie pro mesmo diretório ( necessário)
```

## 🏗️ Build

Requisitos: **JDK 17+** (o script busca sozinhos em `Program Files` os JDKs mais novos).

```powershell
# PowerShell
.\build.ps1

# ou Batch
build.bat
```

Saída: `dist\doomsday.jar` (307 classes) + cópia do JNA em `dist\`.

## 🚀 Uso

### GUI (padrão)

```cmd
run.bat
:: ou
java -jar dist\doomsday.jar
```

### Injetar um JAR específico

```cmd
run.bat C:\caminho\meu_agente.jar
:: ou
java -jar dist\doomsday.jar --jar="C:\caminho\meu_agente.jar"
```

Também funciona **arrastar e soltar** o `.jar` sobre o `run.bat`.

### Flags úteis

| Flag | Descrição |
| :--- | :--- |
| `--autoinject` | injeta automaticamente em todos os procesos Minecraft encontrados |
| `--allowrestart` | permite reiniciar o processo injetado |
| `--jar=<caminho>` | JAR customizado para injeção |
| `--offsets` | imprime offsets internos da JVM (JSON binário) e sai |
| `--printenv` / `--printprops` | debug do ambiente / propriedades do sistema |
| `--killpid=<num>` | força a finalização de um PID |
| `--nostd` | suprime stdout/stderr (headless) |

## 🔧 Estrutura

```text
doomsday-cracked/
├── src/main/java/        # ~305 fontes Java desofuscados e recompiláveis
│   ├── DoomsdayGUI.java  # Interface principal e CLI
│   ├── C_dy.java         # Botão customizado
│   ├── TitleBarPanel.java# Barra lateral + botão Inject
│   └── ...               # Injeção, JVMTI, shellcode, hooks nativos
├── src/main/resources/   # Payloads embutidos, manifest, META-INF
│   └── net/java/         # Binários nativos criptografados (JNA, agente)
├── lib/jna.jar           # JNA 5.14.0 (dependência de acesso nativo)
├── build.bat / build.ps1 # Scripts de compilação
└── run.bat               # Launcher
```

### Componentes principais

| Componente | Classe |
| :--- | :--- |
| GUI / CLI | `DoomsdayGUI` |
| Enumênciação e fixação ao processo | `ProcessAttacher`, `ProcessListManager` |
| Injetor JVMTI / shellcode | `JvmtiInjector`, `ShellcodeLoader` |
| Ganchos de memória nativa | `ProcessMemoryHooks`, `WinMemoryManager` |
| Agente bootstrap multi-versão | `UniversalBootstrapAgent` |
| Criptografia embutida | `CryptoUtil`, `JarEntryDecoder` |

## ⚠️ Aviso legal

Este projeto é disponibilizado **para fins educacionais e de pesquisa** apenas.
O uso indevido de ferramentas de injeção pode violar os Termos de Serviço de
qualquer produto. O autor original da ferramenta é o doomsdayclient.com; esta
reversão não se apropria de nenhum serviço pago. Use por sua conta e risco.

## 🎲 Licença

Unlicense — domínio público. Creditos ao projeto original Doomsday.

---

<div align="center">
<sub>Cracked by reversed — 2026</sub>
</div>
