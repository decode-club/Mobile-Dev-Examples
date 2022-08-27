package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the views from the layout
        _textview = findViewById<TextView>(R.id.textview)
        _spinner = findViewById<Spinner>(R.id.spinner)
        // part 06 goes here
        var adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.spinner_strings,
            android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        _spinner?.setAdapter(adapter)

        // part 07 goes here
        _spinner?.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                // alter the text of the textview to display the item selected
                _textview?.setText("The fruit you chose was: " + p0?.getItemAtPosition(p2))
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        })

    }
    // private fields of the class
    private var _textview: TextView? = null
    private var _spinner: Spinner? = null
}
