package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("This is a print message in the log")
        Log.i("Logging App", "this is an information message")
        Log.v("Logging App", "this is a verbose message")
        Log.d("Logging App", "this is a debug message")
        Log.w("Logging App", "this is a warning message")
        Log.e("Logging App", "this is an error message")
        Log.wtf("Logging App", "this is a WTF message")
    }
}