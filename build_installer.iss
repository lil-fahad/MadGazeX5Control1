[Setup]
AppName=MadGazeBridge
AppVersion=1.0
DefaultDirName={pf}\MadGazeBridge
OutputDir=.
OutputBaseFilename=MadGazeInstaller
Compression=lzma
SolidCompression=yes

[Files]
Source: "bin\Release\MadGazeBridge.exe"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{group}\MadGazeBridge"; Filename: "{app}\MadGazeBridge.exe"
