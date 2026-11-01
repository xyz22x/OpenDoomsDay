@echo off
setlocal

rem Locate the newest installed JDK (falls back to JAVA_HOME, then PATH java)
set "JAVA_CMD="
for /f "delims=" %%J in ('powershell -NoProfile -ExecutionPolicy Bypass -Command "$c=Get-ChildItem 'C:\Program Files\Eclipse Adoptium\*\bin\java.exe','C:\Program Files\Java\*\bin\java.exe','C:\Program Files\BellSoft\*\bin\java.exe','C:\Program Files\Zulu\*\bin\java.exe' -ErrorAction SilentlyContinue | Sort-Object { if ($_.Directory.Parent.Name -match '(\d+(?:\.\d+)*)') { $Matches[1] -as [version] } else { [version]'0.0' } } -Descending | Select-Object -First 1; if($c){$c.FullName}"') do if not defined JAVA_CMD set "JAVA_CMD=%%J"

if not defined JAVA_CMD if defined JAVA_HOME if exist "%JAVA_HOME%\bin\java.exe" set "JAVA_CMD=%JAVA_HOME%\bin\java.exe"
if not defined JAVA_CMD set "JAVA_CMD=java"

rem Show which runtime is being used
echo Using Java runtime: %JAVA_CMD%
"%JAVA_CMD%" -version 2>&1 | findstr "version"

rem Build first if needed
if not exist "dist\doomsday.jar" (
    echo Building project first...
    call build.bat
    if %errorlevel% neq 0 exit /b %errorlevel%
)

echo Starting Doomsday...
"%JAVA_CMD%" -jar "dist\doomsday.jar" %*
