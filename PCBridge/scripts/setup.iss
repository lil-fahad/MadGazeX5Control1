; Inno Setup script for PCBridgeService
[Setup]
AppName=MadGaze PC Bridge
AppVersion=1.0
DefaultDirName={pf}\MadGazePCBridge
OutputBaseFilename=madgaze_pc_bridge_setup

[Files]
Source: "build\Release\MadGazeBridge.exe"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{group}\MadGaze PC Bridge"; Filename: "{app}\MadGazeBridge.exe"
