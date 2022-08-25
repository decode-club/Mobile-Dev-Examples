package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _textview = findViewById<TextView>(R.id.textview)
        _button = findViewById<Button>(R.id.button)
        _button?.setOnClickListener ( object : View.OnClickListener {
            override fun onClick(p0: View?) {
                _clicks++
                _textview?.setText("This button has been clicked " +_clicks + " times")
            }
        })
    }
    // private fields of the class
    private var _textview: TextView? = null
    private var _button: Button? = null
    private var _clicks: Int = 0
}
