package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _textview = findViewById<TextView>(R.id.textview)
        _edittext = findViewById<EditText>(R.id.edittext)
        _edittext?.setOnEditorActionListener(object: TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                // if the enter button has been clicked on the edit text then update the textview
                if (p1 == EditorInfo.IME_ACTION_DONE) {
                    _textview?.setText("Entered: " + _edittext?.getText())
                    return true
                }
                // if the event has not been handled then return false
                return false
            }
        })
    }

    // private fields of the class
    private var _textview: TextView? = null
    private var _edittext: EditText? = null
}