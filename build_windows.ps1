# Change path to your .sln file
$solutionPath = "C:\Path\To\MadGazeBridge.sln"

# Build using MSBuild (Visual Studio Build Tools required)
& "C:\Program Files\Microsoft Visual Studio\2022\Community\MSBuild\Current\Bin\MSBuild.exe" $solutionPath `
    /p:Configuration=Release `
    /p:Platform="Any CPU"
