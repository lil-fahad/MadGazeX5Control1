
; Inno Setup script for PCBridgeService
[Setup]
AppName=MadGaze PC Bridge
AppVersion=1.0
DefaultDirName={pf}\MadGazePCBridge
DefaultGroupName=MadGaze
OutputBaseFilename=madgaze_pc_bridge_setup
Compression=lzma
SolidCompression=yes

[Files]
Source: "build\Release\MadGazeBridge.exe"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{group}\MadGaze PC Bridge"; Filename: "{app}\MadGazeBridge.exe"
