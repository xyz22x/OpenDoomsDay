@echo off
setlocal enabledelayedexpansion

echo ==========================================
echo  Building Doomsday from Decompiled Source
echo ==========================================

if exist "C:\Program Files\Java\jdk-21.0.10\bin\javac.exe" (
    set "PATH=C:\Program Files\Java\jdk-21.0.10\bin;%PATH%"
)
where javac >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERROR] javac.exe not found in PATH or standard JDK location.
    exit /b 1
)

echo [1/4] Preparing directories...
if exist "build" rd /s /q "build"
if exist "dist" rd /s /q "dist"
mkdir "build\classes" 2>nul
mkdir "dist\lib" 2>nul

echo [2/4] Compiling Java classes...
javac --release 17 -d "build\classes" -cp "lib\jna.jar" src\main\java\*.java
javac --release 8 -d "build\classes" src\main\java\UniversalBootstrapAgent.java
if %errorlevel% neq 0 (
    echo [ERROR] Compilation failed!
    exit /b %errorlevel%
)
echo       Compilation finished with 0 errors.

echo [3/4] Copying assets and resources...
xcopy /e /i /y "src\main\resources\*" "build\classes\" >nul

echo [4/4] Packaging doomsday.jar...
jar --create --file "dist\doomsday.jar" --manifest "src\main\resources\META-INF\MANIFEST.MF" -C "build\classes" .
copy /y "lib\jna.jar" "dist\lib\jna.jar" >nul
copy /y "lib\jna.jar" "dist\jna.jar" >nul

echo ==========================================
echo  BUILD SUCCESSFUL!
echo  Output: dist\doomsday.jar
echo ==========================================
