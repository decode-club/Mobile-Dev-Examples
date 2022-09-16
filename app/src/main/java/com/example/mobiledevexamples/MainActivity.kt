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
    private lateinit var _accelerometer: TextView
    private lateinit var _gyroscope: TextView
    private lateinit var _magnetic_field: TextView
    private lateinit var _gravity: TextView
    private lateinit var _linear_acceleration: TextView
    private lateinit var _sm: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the views from the layout and also get access to teh sensor manager
        _accelerometer = findViewById<TextView>(R.id.accelerometer)
        _gyroscope = findViewById<TextView>(R.id.gyroscope)
        _magnetic_field = findViewById<TextView>(R.id.magnetic_field)
        _gravity = findViewById<TextView>(R.id.gravity)
        _linear_acceleration = findViewById<TextView>(R.id.linear)
        _sm = getSystemService(SENSOR_SERVICE) as SensorManager
        // call all the relevant private functions to attach listeners to each sensor
        setAccelerometerListener()
        setGyroscopeListener()
        setMagnometerListener()
        setGravityListener()
        setLinearListener()
    }
    // private function that will attach a listener for the accelerometer
    private fun setAccelerometerListener() {
        // first check the sensor exists then add the listener if it is there
        if(_sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            _sm.registerListener(object : SensorEventListener {
                // we won't use this but we need to implement it anyway
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                // here we will just update the text field with all three axes values
                override fun onSensorChanged(p0: SensorEvent?) {
                    _accelerometer.setText("Accelerometer X, Y, Z (m/s²): " + p0!!.values[0] +
                            ", " + p0!!.values[1] + ", " + p0!!.values[2])
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI)
        }
    }

    // private function that will attach a listener for the gyroscope
    private fun setGyroscopeListener() {
        // first check the sensor exists then add the listener if it is there
        if(_sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null) {
            _sm.registerListener(object : SensorEventListener {
                // we won't use this but we need to implement it anyway
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                // here we will just update the text field with all three axes values
                override fun onSensorChanged(p0: SensorEvent?) {
                    _gyroscope.setText("Gyroscope X, Y, Z (rads/s): " + p0!!.values[0] + ", " +
                            p0!!.values[1] + ", " + p0!!.values[2])
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
                SensorManager.SENSOR_DELAY_UI)
        }
    }

    // private function that will attach a listener for the magnetic field sensor
    private fun setMagnometerListener() {
        // first check the sensor exists then add the listener if it is there
        if(_sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null) {
            _sm.registerListener(object : SensorEventListener {
                // we won't use this but we need to implement it anyway
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                // here we will just update the text field with all three axes values
                override fun onSensorChanged(p0: SensorEvent?) {
                    _magnetic_field.setText("Magnetic Field X, Y, Z (µT): " + p0!!.values[0] + "," + p0!!.values[1] + ", " + p0!!.values[2])
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_UI)
        }
    }

    // private function that will attach a listener for the virtual sensor for gravity
    private fun setGravityListener() {
        // first check the sensor exists then add the listener if it is there
        if(_sm.getDefaultSensor(Sensor.TYPE_GRAVITY) != null) {
            _sm.registerListener(object : SensorEventListener {
                // we won't use this but we need to implement it anyway
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                // here we will just update the text field with all three axes values
                override fun onSensorChanged(p0: SensorEvent?) {
                    _gravity.setText("Gravity X, Y, Z (m/s²): " + p0!!.values[0] + ", " +
                            p0!!.values[1] + ", " + p0!!.values[2])
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_GRAVITY), SensorManager.SENSOR_DELAY_UI)
        }
    }

    // private function that will attach a listener for the virtual linear accelerometer
    private fun setLinearListener() {
        // first check the sensor exists then add the listener if it is there
        if(_sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null) {
            _sm.registerListener(object : SensorEventListener {
                // we won't use this but we need to implement it anyway
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                // here we will just update the text field with all three axes values
                override fun onSensorChanged(p0: SensorEvent?) {
                    _linear_acceleration.setText("Linear Acceleration X, Y, Z (m/s²): " + p0!!.values[0] + ", " + p0!!.values[1] + ", " + p0!!.values[2])
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),
                SensorManager.SENSOR_DELAY_UI)
        }
    }
}
