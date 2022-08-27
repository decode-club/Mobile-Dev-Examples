package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // log a message to indicate that this lifecycle handler has been called
        Log.i("MainActivity", "onCreate() called")
    }
    // 03 code goes here
    // overridden onDestroy function
    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy() called")
    }
    // 04 code goes here
    // overridden resume function
    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume() called")
    }
    // 05 code goes here
    // overridden pause function
    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause() called")
    }
    // 06 code goes here
    // overridden stop function
    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop() called")
    }
    // 07 code goes here
    // overridden start function
    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart() called")
    }
}