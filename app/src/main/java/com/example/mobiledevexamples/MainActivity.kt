package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.io.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // create a file in internal storage and write some content to it
        var output: File = File(filesDir, "test.txt")
        try {
            var bw: BufferedWriter = BufferedWriter(FileWriter(output))
            bw.write("hello world\nthis is an internal file.")
            bw.close()
        } catch(e: IOException) {
            e.printStackTrace()
        }

        // we will now read back in the file
        var total: String = ""
        try {
            val br: BufferedReader = BufferedReader(FileReader(output))
            var temp: String? = br.readLine()
            while(temp != null) {
                total += temp + "\n"
                temp = br.readLine()
            }
            br.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        // set the file content on the textview then delete the file
        var textview: TextView = findViewById<TextView>(R.id.textview)
        textview.setText(total)
        output.delete()

    }
}
