package com.example.mobiledevexamples

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    // private fields of the class
    private lateinit var _temperature: TextView
    private lateinit var _proximity: TextView
    private lateinit var _light: TextView
    private lateinit var _pressure: TextView
    private lateinit var _sm: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull references to all of our textviews
        _temperature = findViewById<TextView>(R.id.temperature)
        _proximity = findViewById<TextView>(R.id.proximity)
        _light = findViewById<TextView>(R.id.light)
        _pressure = findViewById<TextView>(R.id.pressure)
        // get access to the sensor manager and try and add a four listeners, one per sensor to it
        _sm = getSystemService(SENSOR_SERVICE) as SensorManager
        addSensorListenerTemp()
        addSensorListenerProximity()
        addSensorListenerLight()
        addSensorListenerPressure()

    }
    // private function that will add in a sensor listener for our temperature sensors
    fun addSensorListenerTemp() {
        if (_sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            _sm.registerListener(object : SensorEventListener {
                // this only gets called whenever android had detected an accuracy change in the sensors
                // it allows you to react by changing to a different version of a sensor or use multipe
                // sensors to improve accuracy. we won't use it in this example
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                override fun onSensorChanged(p0: SensorEvent?) {
                    // the value of the sensor has changed so we will update the text view with the
                    // new value it contains
                    _temperature.setText("Temperature Sensor: " + p0!!.values[0] + " celcius")
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),
                SensorManager.SENSOR_DELAY_UI)
        }
    }

    // private function that will add in a sensor listener for our proximity sensors
    fun addSensorListenerProximity() {
        if (_sm.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null) {
            _sm.registerListener(object : SensorEventListener {
                // this only gets called whenever android had detected an accuracy change in the sensors
                // it allows you to react by changing to a different version of a sensor or use multipe
                // sensors to improve accuracy. we won't use it in this example
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                override fun onSensorChanged(p0: SensorEvent?) {
                    // the value of the sensor has changed so we will update the text view with the
                    // new value it contains
                    _proximity.setText("Proximity Sensor: " + p0!!.values[0] + " cm")
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_UI)
        }
    }

    // private function that will add in a sensor listener for our light sensors
    fun addSensorListenerLight() {
        if (_sm.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            _sm.registerListener(object : SensorEventListener {
                // this only gets called whenever android had detected an accuracy change in the sensors
                // it allows you to react by changing to a different version of a sensor or use multipe
                // sensors to improve accuracy. we won't use it in this example
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                override fun onSensorChanged(p0: SensorEvent?) {
                    // the value of the sensor has changed so we will update the text view with the
                    // new value it contains
                    _light.setText("Light Sensor: " + p0!!.values[0] + " lux")
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_UI)
        }
    }

    // private function that will add in a sensor listener for our pressure sensors
    fun addSensorListenerPressure() {
        if (_sm.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {
            _sm.registerListener(object : SensorEventListener {
                // this only gets called whenever android had detected an accuracy change in the sensors
                // it allows you to react by changing to a different version of a sensor or use multipe
                // sensors to improve accuracy. we won't use it in this example
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                override fun onSensorChanged(p0: SensorEvent?) {
                    // the value of the sensor has changed so we will update the text view with the
                    // new value it contains
                    _pressure.setText("Pressure Sensor: " + p0!!.values[0] + " mbar")
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_UI)
        }
    }

}