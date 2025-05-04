package com.madgaze.client

import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

class TouchpadInput(private val sendControlEvent: (String) -> Unit) : OnTouchListener {
    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> sendControlEvent("mousedown")
            MotionEvent.ACTION_MOVE -> sendControlEvent("mousemove:${event.x}:${event.y}")
            MotionEvent.ACTION_UP -> sendControlEvent("mouseup")
        }
        return true
    }
}
