using System;
using System.Runtime.InteropServices;

namespace PCBridge.Input {
    public class RemoteInputHandler {
        [DllImport("user32.dll")]
        private static extern void mouse_event(int dwFlags, int dx, int dy, int dwData, int dwExtraInfo);

        private const int MOUSEEVENTF_MOVE = 0x0001;

        public void MoveMouse(int dx, int dy) {
            mouse_event(MOUSEEVENTF_MOVE, dx, dy, 0, 0);
        }
    }
}
