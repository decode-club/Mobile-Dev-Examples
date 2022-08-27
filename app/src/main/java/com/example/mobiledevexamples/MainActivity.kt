package com.example.mobiledevexamples

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // get access to a configuration object and determine which orientation we are in.
        // set the appropriate layout depending on orientation
        var config: Configuration = resources.configuration
        if(config.orientation == Configuration.ORIENTATION_PORTRAIT)
            setContentView(R.layout.activity_main)
        else if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
            setContentView(R.layout.activity_main_landscape)
    }
}