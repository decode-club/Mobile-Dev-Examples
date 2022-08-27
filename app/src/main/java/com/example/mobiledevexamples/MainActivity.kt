package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the views from the layout
        _textview = findViewById<TextView>(R.id.textview)
        _rb1 = findViewById<RadioButton>(R.id.rb1)
        _rb2 = findViewById<RadioButton>(R.id.rb2)
        _rb3 = findViewById<RadioButton>(R.id.rb3)
        // attach a listener to the first radio button
        _rb1?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                _textview?.setText("Radio Button 1 clicked")
            }
        })
        // attach a listener to the second radio button
        _rb2?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                _textview?.setText("Radio Button 2 clicked")
            }
        })
        // attach a listener to the third radio button
        _rb3?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                _textview?.setText("Radio Button 3 clicked")
            }
        })
    }
    // private fields of the class
    private var _textview: TextView? = null
    private var _rb1: RadioButton? = null
    private var _rb2: RadioButton? = null
    private var _rb3: RadioButton? = null
}