
# Mad Gaze X5 Remote Control + AR Full System

## AndroidClient/
- Full Android Studio project
- Video stream receiver, voice control, touchpad input, AR overlay placeholder

## PCBridge/
- Windows Visual Studio project
- Basic capture and input injection (ready to extend)
- Inno Setup script for installer

## Build Instructions

### Android APK:
1. Open `AndroidClient/` in Android Studio
2. Build APK (Build > Build APKs)
3. Install on Mad Gaze X5 via USB

### PCBridge:
1. Open in Visual Studio
2. Build `MadGazeBridge.exe`
3. Use `setup.iss` in Inno Setup to package installer

You can now mirror your PC screen and control it from Mad Gaze with voice, touch, and more.
