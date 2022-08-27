package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _textview = findViewById<TextView>(R.id.textview)
        _calendarview = findViewById<CalendarView>(R.id.calendar)
        _calendarview?.setOnDateChangeListener(object : CalendarView.OnDateChangeListener {
            override fun onSelectedDayChange(p0: CalendarView, p1: Int, p2: Int, p3: Int) {
                _textview?.setText("selected date (YYYY-MM-DD): " + p1 + "-" + p2 + "-" + p3)
            }
        })
    }
    private var _textview: TextView? = null
    private var _calendarview: CalendarView? = null
}
