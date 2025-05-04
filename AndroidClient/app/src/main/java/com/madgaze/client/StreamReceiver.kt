package com.madgaze.client

import android.graphics.SurfaceTexture
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.Surface
import android.view.SurfaceView
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.ByteString
import java.nio.ByteBuffer

class StreamReceiver(private val surfaceView: SurfaceView) {

    private val client = OkHttpClient()
    private var surface: Surface? = null
    private var handler: Handler

    init {
        val thread = HandlerThread("DecoderThread")
        thread.start()
        handler = Handler(thread.looper)
    }

    fun startStreaming(url: String) {
        val request = Request.Builder().url(url).build()
        val listener = object : okhttp3.WebSocketListener() {
            override fun onOpen(webSocket: okhttp3.WebSocket, response: okhttp3.Response) {
                Log.d("StreamReceiver", "Connected to $url")
            }

            override fun onMessage(webSocket: okhttp3.WebSocket, bytes: ByteString) {
                handler.post {
                    decodeFrame(bytes.asByteBuffer())
                }
            }

            override fun onFailure(webSocket: okhttp3.WebSocket, t: Throwable, response: okhttp3.Response?) {
                Log.e("StreamReceiver", "Streaming failed", t)
            }
        }
        client.newWebSocket(request, listener)
        client.dispatcher.executorService.shutdown()
    }

    private fun decodeFrame(buffer: ByteBuffer) {
        // This is a placeholder.
        // MediaCodec decoding should be implemented here with H.264 decoder.
        Log.d("StreamReceiver", "Received frame buffer of size ${buffer.remaining()}")
    }
}
