package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    // private fields of the class
    private lateinit var _textview: TextView
    private lateinit var _handler: ThreadHandler
    private lateinit var _thread: UpdateThread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the textview from the layout, setup the thread and the handler
        _textview = findViewById<TextView>(R.id.textview)
        _handler = ThreadHandler(this)
        _thread = UpdateThread(_handler)
    }
    // when the activity has been made visible we will start the thread
    override fun onResume() {
        super.onResume()
        // start the thread
        _thread.start()
    }
    // function that will be called by the handler that will update the UI with information from the
    // thread
    fun updateUI(num: Int) {
        _textview.setText(num.toString())
    }
}
