package com.example.mobiledevexamples

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    // private fields of the class
    private lateinit var _tdb: TestDBOpenHelper
    private lateinit var _sdb: SQLiteDatabase
    private lateinit var _textview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull the textview from the layout
        _textview = findViewById<TextView>(R.id.textview)
        // open a writable connection to the database
        _tdb = TestDBOpenHelper(this, "test.db", null, 1)
        _sdb = _tdb.writableDatabase
        // call the private functions to manipulate the database
        addData()
        updateData()
        retrieveData()
    }
    // overridden onDestroy function that will be called when the activity finishes properly
    // this will delete all rows from the database
    override fun onDestroy() {
        super.onDestroy()
        // run a simple query that will delete all rows from our table
        var table: String = "test"
        var where: String? = null
        var where_args: Array<String>? = null
        _sdb.delete(table, where, where_args)
    }
    // private function that will add some data into our database
    private fun addData() {
        // now we will add in three rows of data using content values objects
        val row1: ContentValues = ContentValues().apply {
            put("FIRST_NAME", "john")
            put("LAST_NAME", "doe")
            put("COURSE", "computing")
        }
        _sdb.insert("test", null, row1)
        val row2: ContentValues = ContentValues().apply {
            put("FIRST_NAME", "jane")
            put("LAST_NAME", "doe")
            put("COURSE", "business")
        }
        _sdb.insert("test", null, row2)
        val row3: ContentValues = ContentValues().apply {
            put("FIRST_NAME", "jim")
            put("LAST_NAME", "doe")
            put("COURSE", "law")
        }
        _sdb.insert("test", null, row3)
    }
    // private function that will retrieve the data from our database using a query and set it on
    // the textview
    private fun retrieveData() {
        // name of the table we are going to query
        val table_name: String = "test"
        // columns of the table we are going to retrieve
        val columns: Array<String> = arrayOf("ID", "FIRST_NAME", "LAST_NAME")
        // where clause of the query. never write the keyword WHERE in this
        val where: String? = null
        // arguments to provide to the where clause
        val where_args: Array<String>? = null
        // group by clause of the query. never write the GROUP BY keyword here
        val group_by: String? = null
        // having clause of the query. never write the HAVING keyword here
        val having: String? = null
        // order by clause of the query. never write the ORDER BY keyword here
        val order_by: String? = null
        // run the query. This will return a cursor object which we can use to iterate through the
        // returned rows from the query
        var c: Cursor = _sdb.query(table_name, columns, where, where_args, group_by, having
            , order_by)
        // collect the rows of data and set the collected data on the text view
        var total_text: String = "total number of rows: " + c.count + "\n"
        c.moveToFirst()
        for(i in 0 until c.count) {
            total_text += c.getInt(0).toString() + " " + c.getString(1) + " " + c.getString(2) + "\n"
            c.moveToNext()
        }
        _textview.setText(total_text)
    }
    // private function that will update a value in a row of our table
    private fun updateData() {
        val row: ContentValues = ContentValues().apply {
            put("FIRST_NAME", "jacob")
        }
        // setup a query to update the row in the table
        var table: String = "test"
        var where: String = "FIRST_NAME = ?"
        var where_args: Array<String> = arrayOf("jim")
        _sdb.update(table, row, where, where_args)
    }
}