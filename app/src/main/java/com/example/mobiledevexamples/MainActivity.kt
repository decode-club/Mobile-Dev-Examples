package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get a reference to the textview and change its contents
        var tv_textview = findViewById<TextView>(R.id.textview)
        tv_textview.setText("changed from the Kotlin Code")
    }
}