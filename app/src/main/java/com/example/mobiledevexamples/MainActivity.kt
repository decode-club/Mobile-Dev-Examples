package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import com.google.android.material.snackbar.Snackbar
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the buttons from the layout
        _default_button = findViewById<Button>(R.id.default_button)
        _action_button = findViewById<Button>(R.id.action_button)
        _linear_layout = findViewById<LinearLayout>(R.id.linear_layout)
        // 04 code goes here
        _default_button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var snackbar: Snackbar = Snackbar.make(_linear_layout!!, "This is a simple message", Snackbar.LENGTH_LONG)
                snackbar.show()
            }
        })
        // 05 code goes here
        _action_button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var snackbar: Snackbar = Snackbar.make(_linear_layout!!, "This is a snackbar action", Snackbar.LENGTH_INDEFINITE)
                snackbar.setAction("DISMISS", View.OnClickListener {
                    snackbar.dismiss()
                })
                snackbar.show()
            }
        })
    }
    // private fields for our activity
    private var _default_button: Button? = null
    private var _action_button: Button? = null
    private var _linear_layout: LinearLayout? = null
}
