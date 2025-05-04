
# Mad Gaze X5 Remote Control + AR Platform

This project includes the complete source code and build steps to enable screen mirroring, PC control, and AR features on Mad Gaze X5 smart glasses.

---

## Android App (MadGazeClient)

### Requirements
- Android Studio Dolphin or newer
- Android SDK 33+
- Kotlin 1.8+
- ARCore & TensorFlow Lite support

### Build Steps
1. Open `madgaze_android_client` in Android Studio.
2. Allow Gradle to sync dependencies.
3. Connect Mad Gaze X5 via USB.
4. Enable Developer Mode + USB Debugging.
5. Run or build APK:
   ```
   ./gradlew assembleDebug
   adb install app/build/outputs/apk/debug/app-debug.apk
   ```

---

## Windows Agent (PCBridgeService)

### Requirements
- Visual Studio 2019 or newer
- .NET Framework 4.8
- SharpDX or DXGI capture packages

### Build Steps
1. Open `madgaze_pc_bridge` in Visual Studio.
2. Build the solution (`Release` mode).
3. Run or test `MadGazeBridge.exe`.

---

## Windows Installer (Optional)
1. Install [Inno Setup Compiler](https://jrsoftware.org/isinfo.php)
2. Open `scripts/setup.iss`
3. Compile to create `madgaze_pc_bridge_setup.exe`

---

## Usage
1. Run PCBridgeService to start streaming screen.
2. On the Mad Gaze X5, open the installed app.
3. Enter the IP of your PC to connect.
4. Use touchpad, voice, or AR overlay as configured.

---

## Notes
- Ensure both devices are on the same Wi-Fi network.
- Add firewall exceptions for PC agent if needed.
- You can extend with remote assist using Firebase/WebRTC.

