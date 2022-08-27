package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the views from the layout
        _textview = findViewById<TextView>(R.id.textview)
        _checkbox = findViewById<CheckBox>(R.id.checkbox)
        // add a listener to the checkbox that will change the textview when the checkbox is clicked
        _checkbox?.setOnCheckedChangeListener(object :
            CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
                if(p1 == true)
                    _textview?.setText("Checkbox is true")
                else
                    _textview?.setText("Checkbox is false")
            }
        })
    }
    // private fields of the class
    private var _textview: TextView? = null
    private var _checkbox: CheckBox? = null
}