package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull a reference to the textview
        _textview = findViewById<TextView>(R.id.textview)
    }
    // 05 code goes here
    // function responsible for inflating and attaching our menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // call the inflator for the options menu and attach it to the menu that has been passed
        // in here
        menuInflater.inflate(R.menu.menu, menu)
        // it is a requirement to call this at the end of this function
        return super.onCreateOptionsMenu(menu)
    }
    // 06 code goes here
// function that will react to an event on any of hte menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // determine which menu item was selected
        when(item.itemId) {
            R.id.add -> {
                _textview?.setText("Add menu item selected")
                return true
            }
            R.id.first -> {
                _textview?.setText("First menu item selected")
                return true
            }
            R.id.second -> {
                _textview?.setText("Second menu item selected")
                return true
            }
        }
        // it is a requirement to call this at the end of this function if the event has not been
        // handled
        return super.onOptionsItemSelected(item)
    }

    // private fields of this class
    private var _textview: TextView? = null
}