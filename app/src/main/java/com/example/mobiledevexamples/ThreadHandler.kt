package com.example.mobiledevexamples

import android.os.Handler
import android.os.Looper
import android.os.Message
class ThreadHandler(ma: MainActivity) : Handler(Looper.myLooper()!!) {
    // private fields of the class
    private var _ma: MainActivity = ma
    // in order to handle our own events we must override this function
    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        // call the update UI method with the number of cycles in the message
        _ma.updateUI(msg.arg1)
    }
}