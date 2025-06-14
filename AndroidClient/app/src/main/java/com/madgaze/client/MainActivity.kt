package com.madgaze.client

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Mad Gaze Client Started", Toast.LENGTH_SHORT).show()
        val streamer = StreamReceiver()
        streamer.startStreaming("ws://192.168.1.100:8080")
    }
}
