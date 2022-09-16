package com.example.mobiledevexamples

import android.os.Message
class UpdateThread(handler: ThreadHandler) : Thread() {
    // private fields of the class
    private var _cycles: Int = 0
    private var _handler: ThreadHandler = handler
    override fun run() {
        // for 20 times sleep for a second and generate a message to send to the main UI to
        // update the value displayed.
        while(_cycles < 20) {
            _cycles++
            val m: Message = _handler.obtainMessage(0xDEADBEEF.toInt(), _cycles, 0)
            _handler.sendMessage(m)
            try {
                sleep(1000)
            } catch (ie: InterruptedException) {
            }
        }
    }
}