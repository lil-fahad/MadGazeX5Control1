@echo off
cd /d "%~dp0AndroidAppPath%"  REM Replace with actual Android project folder
echo Building APK...
call gradlew.bat clean assembleDebug
echo APK generated at: app\build\outputs\apk\debug\app-debug.apk
pause
