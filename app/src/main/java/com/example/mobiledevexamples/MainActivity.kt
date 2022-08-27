package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _textview = findViewById<TextView>(R.id.textview)
        _numberpicker = findViewById<NumberPicker>(R.id.numberpicker)
        _numberpicker?.setMinValue(0)
        _numberpicker?.setMaxValue(10)
        _numberpicker?.setOnValueChangedListener(object :
            NumberPicker.OnValueChangeListener {
            override fun onValueChange(p0: NumberPicker?, p1: Int, p2: Int) {
                _textview?.setText("user has selected: " + p2)
            }
        })
    }
    var _textview: TextView? = null
    var _numberpicker: NumberPicker? = null
}