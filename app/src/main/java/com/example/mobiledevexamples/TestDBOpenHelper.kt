package com.example.mobiledevexamples

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class TestDBOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    // private constant for creating our single table
    private val CREATE_TABLE: String = "create table test(" +
            "ID integer primary key autoincrement," +
            "FIRST_NAME string," +
            "LAST_NAME string," +
            "COURSE string" +
            ")"
    // private constant for dropping our single table
    private val DROP_TABLE: String = "drop table test"
    // this gets called if we need a database for this application but non exists.
    override fun onCreate(p0: SQLiteDatabase?) {
        // execute the statement to create our table
        p0?.execSQL(CREATE_TABLE)
    }
    // this gets called whenever your application should update the database schema. It is
    // responsible for converting your database from an old schemas to newer database schemas
    // for the sake of this example we will assume that data is not important so we will drop and
    // recreate the database
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // drop the table and recreate it
        p0?.execSQL(DROP_TABLE)
        p0?.execSQL(CREATE_TABLE)
    }
}