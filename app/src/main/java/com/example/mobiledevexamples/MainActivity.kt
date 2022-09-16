package com.example.mobiledevexamples

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    // private fields of the class
    private lateinit var _tv_boolean: TextView
    private lateinit var _tv_int: TextView
    private lateinit var _tv_float: TextView
    private lateinit var _preferences: SharedPreferences
    private var _bool: Boolean = false
    private var _int: Int = 0
    private var _float: Float = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the textviews from the layout
        _tv_boolean = findViewById<TextView>(R.id.tv_boolean)
        _tv_int = findViewById<TextView>(R.id.tv_int)
        _tv_float = findViewById<TextView>(R.id.tv_float)
        // pull the values from the shared preferences of they exist and if not set reasonable
        // default values
        _preferences = getSharedPreferences("ie.denby.barry.shared_preferences", Activity.MODE_PRIVATE)
        _bool = _preferences.getBoolean("boolean", false)
        _int = _preferences.getInt("integer", 0)
        _float = _preferences.getFloat("float", 0f)
        // set the values on the text views
        _tv_boolean.setText("Boolean: " + _bool)
        _tv_int.setText("Integer: " + _int)
        _tv_float.setText("Float: " + _float)
    }
    // overridden onDestroy function that should save our values if the app is closed correctly
    override fun onDestroy() {
        super.onDestroy()
        // update the values
        _bool = !_bool
        _int++
        _float += 2f
        // get access to the shared preferences editor and store the updated values
        var editor: SharedPreferences.Editor = _preferences.edit()
        editor.putBoolean("boolean", _bool)
        editor.putInt("integer", _int)
        editor.putFloat("float", _float)
        editor.apply()
    }
}
