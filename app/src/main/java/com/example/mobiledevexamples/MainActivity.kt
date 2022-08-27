package com.example.mobiledevexamples

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull references to the buttons from the layout
        _textview = findViewById<TextView>(R.id.textview)
        _alert_button = findViewById<Button>(R.id.alert_button)
        _list_button = findViewById<Button>(R.id.list_button)
        _input_button = findViewById<Button>(R.id.input_button)
        // 08 code goes here
        // add a listener to the alert button that will trigger an alert dialog
        _alert_button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // trigger the alert dialog
                alertDialog()
            }
        })
        // add a listener to the list button that will trigger an list dialog
        _list_button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // trigger the alert dialog
                listDialog()
            }
        })
        // add a listener to the input button that will trigger an input dialog
        _input_button?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // trigger the alert dialog
                inputDialog()
            }
        })
    }
    // 05 function goes here
    // private function that will build and display an alert dialog
    private fun alertDialog() {
        // get access to a factory class that will build an alert dialog for us
        var builder: AlertDialog.Builder = AlertDialog.Builder(this)
        // set the title and message to be displayed on the dialog
        builder.setTitle("Alert Dialog")
        builder.setMessage("This is an alert dialog")
        // add in a positive response button such that we can dismiss the dialog with a yes answer
        builder.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                // update the textview to say this dialog was dismissed
                _textview?.setText("Alert dialog was dismissed with yes")
            }
        })
        // add in a negative response button such that we can dismiss the dialog with a no answer
        builder.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                // update the textview to say this dialog was dismissed
                _textview?.setText("Alert dialog was dismissed with no")
            }
        })
        // build the dialog and show it
        var dialog: AlertDialog = builder.create()
        dialog.show()
    }
    // 06 function goes here
    // private function that will build and display a list dialog
    private fun listDialog() {
        // get access to a factory class that will build an alert dialog for us
        var builder: AlertDialog.Builder = AlertDialog.Builder(this)
        // set the title and message to be displayed on the dialog
        builder.setTitle("List dialog: Choose a colour")
        // set the list of items on the dialog from our string array and set a listener to react
        // to whatever the user has chosen
        builder.setItems(R.array.choices, object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                // print out a message depending on the user choice
                when(p1) {
                    0 -> _textview?.setText("you chose Red from the list dialog")
                    1 -> _textview?.setText("you chose Green from the list dialog")
                    2 -> _textview?.setText("you chose Blue from the list dialog")
                }
            }
        })
        // build the dialog and show it
        var dialog: AlertDialog = builder.create()
        dialog.show()
    }
    // 07 function goes here
    // private function that will build and display an input dialog
    private fun inputDialog() {
        // get access to a factory class that will build an alert dialog for us
        var builder: AlertDialog.Builder = AlertDialog.Builder(this)
        // set the title and message to be displayed on the dialog
        builder.setTitle("Input dialog, enter some text")
        // for input dialogs we can define our own layouts but here we will just put in an edit text
        var edittext : EditText = EditText(this)
        edittext.inputType = InputType.TYPE_CLASS_TEXT
        edittext.hint = "Enter text here"
        builder.setView(edittext)
        // set a positive button to accept the user text
        builder.setPositiveButton("Accept", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                // update the textview to say this dialog was dismissed
                _textview?.setText("Input dialog text is: " + edittext.text)
            }
        })
        // add in a negative response button such that we can dismiss the dialog with a no answer
        builder.setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {
                // update the textview to say this dialog was dismissed
                _textview?.setText("Input dialog was dismissed")
            }
        })
        // build the dialog and show it
        var dialog: AlertDialog = builder.create()
        dialog.show()
    }

    // private fields of the class
    private var _textview: TextView? = null
    private var _alert_button: Button? = null
    private var _list_button: Button? = null
    private var _input_button: Button? = null
}
