# Doomsday Build Script (PowerShell)
$ErrorActionPreference = "Stop"

Write-Host "==========================================" -ForegroundColor Cyan
Write-Host " Building Doomsday from Decompiled Source " -ForegroundColor Cyan
Write-Host "==========================================" -ForegroundColor Cyan

# Check Java compiler and tools
$jdkDirs = @(
    (Get-Item "C:\Program Files\Java\jdk*" -ErrorAction SilentlyContinue),
    (Get-Item "C:\Program Files\Eclipse Adoptium\*" -ErrorAction SilentlyContinue),
    (Get-Item "C:\Program Files\BellSoft\*" -ErrorAction SilentlyContinue),
    (Get-Item "C:\Program Files\Zulu\*" -ErrorAction SilentlyContinue)
) | Where-Object { $_ -and (Test-Path (Join-Path $_.FullName "bin\javac.exe")) }
if ($jdkDirs) {
    $latestJdk = $jdkDirs | Sort-Object {
        if ($_.Name -match '(\d+(?:\.\d+)*)') {
            ($Matches[1].Split('.') | ForEach-Object { $_.PadLeft(8, '0') }) -join '.'
        } else { '0' }
    } -Descending | Select-Object -First 1
    $latestJdk = $latestJdk.FullName
    $javac = Join-Path $latestJdk "bin\javac.exe"
    $jar = Join-Path $latestJdk "bin\jar.exe"
} else {
    $javac = (Get-Command javac -ErrorAction Stop).Source
    $jar = (Get-Command jar -ErrorAction Stop).Source
}


# 1. Clean & create build folders
Write-Host "[1/4] Preparing directories..." -ForegroundColor Yellow
if (Test-Path "build") { Remove-Item -Recurse -Force "build" }
if (Test-Path "dist") { Remove-Item -Recurse -Force "dist" }
New-Item -ItemType Directory -Path "build\classes", "dist\lib" -Force | Out-Null

# 2. Compile Java sources
Write-Host "[2/4] Compiling Java classes..." -ForegroundColor Yellow
$javaFiles = Get-ChildItem -Path "src\main\java\*.java" | ForEach-Object { $_.FullName }
$cp = "lib\jna.jar"

& $javac --release 17 -d "build\classes" -cp $cp $javaFiles
if ($LASTEXITCODE -ne 0) {
    throw "Compilation failed!"
}
# Compile UniversalBootstrapAgent with Java 8 bytecode so it runs in any Minecraft Java version (8 to 25+)
& $javac --release 8 -d "build\classes" "src\main\java\UniversalBootstrapAgent.java"
Write-Host "      Successfully compiled $( (Get-ChildItem -Recurse build\classes\*.class).Count ) classes." -ForegroundColor Green

# 3. Copy resources
Write-Host "[3/4] Copying assets and resources..." -ForegroundColor Yellow
Copy-Item -Path "src\main\resources\*" -Destination "build\classes\" -Recurse -Force

# 4. Package JAR
Write-Host "[4/4] Packaging doomsday.jar..." -ForegroundColor Yellow
$manifest = "src\main\resources\META-INF\MANIFEST.MF"
& $jar --create --file "dist\doomsday.jar" --manifest $manifest -C "build\classes" .
Copy-Item "lib\jna.jar" "dist\lib\jna.jar" -Force
Copy-Item "lib\jna.jar" "dist\jna.jar" -Force

Write-Host "==========================================" -ForegroundColor Cyan
Write-Host " BUILD SUCCESSFUL!" -ForegroundColor Green
Write-Host " Output: dist\doomsday.jar" -ForegroundColor Green
Write-Host "==========================================" -ForegroundColor Cyan
