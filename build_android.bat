@echo off

REM Ensure the Android project path is set
if "%~dp0AndroidAppPath%"=="" (
    echo ERROR: The Android project path is not set. Please set %~dp0AndroidAppPath% before running this script.
    pause
    exit /b 1
)

REM Change to the Android project directory
cd /d "%~dp0AndroidAppPath%" || (
    echo ERROR: Failed to navigate to the Android project directory: %~dp0AndroidAppPath%
    pause
    exit /b 1
)

REM Check if gradlew.bat exists
if not exist gradlew.bat (
    echo ERROR: gradlew.bat not found in the project directory. Ensure you have the Gradle wrapper set up.
    pause
    exit /b 1
)

echo Building APK...

REM Run Gradle build command
call gradlew.bat clean assembleDebug || (
    echo ERROR: Gradle build failed. Check the logs above for details.
    pause
    exit /b 1
)

REM Check if APK was generated
if exist app\build\outputs\apk\debug\app-debug.apk (
    echo SUCCESS: APK generated at: app\build\outputs\apk\debug\app-debug.apk
) else (
    echo ERROR: APK was not generated. Check the build logs for details.
    pause
    exit /b 1
)

pause