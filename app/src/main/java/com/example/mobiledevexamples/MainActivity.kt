package com.example.mobiledevexamples

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
class MainActivity : AppCompatActivity() {
    // private fields of the class
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the button from the layout and set a listener on it to trigger a notification message
        button = findViewById<Button>(R.id.button)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                triggerNotification()
            }
        })
    }
    // private function that will trigger a notification
    private fun triggerNotification() {
        // get access to the notification manager service
        var nm: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        // if the build version is version O or above we will also need a notification channel for sending
        // the message
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nc = NotificationChannel(
                "MY_CHANNEL_ID",
                "My Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            // Configure the notification channel.
            nc.description = "description of our channel"
            nc.vibrationPattern = longArrayOf(0, 1000)
            nc.enableVibration(true)
            nm.createNotificationChannel(nc)
        }
        // build a notification and show it on the device
        var nb: NotificationCompat.Builder = NotificationCompat.Builder(this, "MY_CHANNEL_ID")
        nb.setDefaults(Notification.DEFAULT_ALL)
        nb.setWhen(System.currentTimeMillis())
        nb.setSmallIcon(R.mipmap.ic_launcher)
        nb.setTicker("My notification")
        nb.setContentTitle("Notification title")
        nb.setContentText("The long text of the notification itself")
        nb.setContentInfo("The content info");
        // make the notification
        nm.notify(1, nb.build())
    }
}
