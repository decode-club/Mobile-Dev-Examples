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
    private lateinit var _rotation: TextView
    private lateinit var _sm: SensorManager
    var _rotation_matrix: FloatArray = FloatArray(16) { 0f }
    var _orientation_values: FloatArray = FloatArray(4) { 0f }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the element needed from the layout, get the sensor manager and attach a listener
        // for the rotation vector
        _rotation = findViewById<TextView>(R.id.rotation)
        _sm = getSystemService(SENSOR_SERVICE) as SensorManager
        addRotationListener()
    }
    // private function that will register intrest in the rotation vector
    private fun addRotationListener() {
        // check that we have access to the sensor first and then register a listener for it
        if(_sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR) != null) {
            _sm.registerListener(object : SensorEventListener {
                // function that will be called if the accuracy of the sensor changes but we won't
                // be using it in this example
                override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
                }
                // function that will be called whenever the sensor values have changed
                override fun onSensorChanged(p0: SensorEvent?) {
                    // we have a bit of work to do on the rotation vector in order to figure out our
                    // orientation. first we need to get the rotation matrix from the vector of values
                    // and from this determine the orientation of the device relative to earth
                    SensorManager.getRotationMatrixFromVector(_rotation_matrix, p0!!.values)
                    SensorManager.getOrientation(_rotation_matrix, _orientation_values)
                    // the orientation values are unitless but we will need to convert them into
                    // degrees in order to make them meaningful and easier to interpret
                    _orientation_values[0] =
                        Math.toDegrees(_orientation_values[0].toDouble()).toFloat()
                    _orientation_values[1] =
                        Math.toDegrees(_orientation_values[1].toDouble()).toFloat()
                    _orientation_values[2] =
                        Math.toDegrees(_orientation_values[2].toDouble()).toFloat()
                    _rotation.setText("Rotation (degrees) bearing(z), pitch(x), roll(y): " +
                            _orientation_values[0] + ", " + _orientation_values[1] + ", " + _orientation_values[2])
                }
            }, _sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
                SensorManager.SENSOR_DELAY_UI)
        }
    }
}
