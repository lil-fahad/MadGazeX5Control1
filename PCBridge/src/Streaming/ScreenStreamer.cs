using System;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace PCBridge.Streaming {
    public class ScreenStreamer {
        private readonly int port = 8080;
        private TcpListener listener;

        public void Start() {
            listener = new TcpListener(IPAddress.Any, port);
            listener.Start();
            Console.WriteLine("Streaming started on port " + port);

            new Thread(() => {
                while (true) {
                    var client = listener.AcceptTcpClient();
                    var stream = client.GetStream();
                    while (true) {
                        using var bmp = CaptureScreen();
                        using var ms = new MemoryStream();
                        bmp.Save(ms, ImageFormat.Jpeg);
                        var buffer = ms.ToArray();
                        stream.Write(buffer, 0, buffer.Length);
                        Thread.Sleep(100); // 10 FPS
                    }
                }
            }).Start();
        }

        private Bitmap CaptureScreen() {
            Rectangle bounds = System.Windows.Forms.Screen.PrimaryScreen.Bounds;
            Bitmap screenshot = new Bitmap(bounds.Width, bounds.Height);
            using Graphics g = Graphics.FromImage(screenshot);
            g.CopyFromScreen(Point.Empty, Point.Empty, bounds.Size);
            return screenshot;
        }
    }
}
