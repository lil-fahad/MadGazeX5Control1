using System;
using System.Runtime.InteropServices;

namespace MadGazeBridge.Input
{
    public class InputInjector
    {
        [DllImport("user32.dll")]
        static extern void mouse_event(uint dwFlags, uint dx, uint dy, uint dwData, int dwExtraInfo);

        public void MoveMouse(int x, int y)
        {
            // Example: move mouse
        }
    }
}
