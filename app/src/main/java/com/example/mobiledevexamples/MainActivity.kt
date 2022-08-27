package com.example.mobiledevexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // pull references to the views in our layout
        _edittext = findViewById<EditText>(R.id.edittext)
        _recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        // set a linear layout manager on the recycler view then generate an adapter and attach it to the recycler view
        _recyclerview.layoutManager = LinearLayoutManager(this)
        var recycler_adapter: RecyclerAdapter = RecyclerAdapter(this, _rl_arraylist)
        _recyclerview.adapter = recycler_adapter
        // 11 code goes here
        // add in a listener to the edit text that will append a new item to the arraylist and
        // update the recycler view
        _edittext.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                // if the enter button has been clicked then add a new item to the arraylist and update
                if(p1 == EditorInfo.IME_ACTION_DONE) {
                    // create an item and add it to the array list and tell the recycler adapter to
                    // update the display
                    _rl_arraylist.add(RecyclerItem(_edittext.text.toString(), _count++))
                    recycler_adapter.notifyDataSetChanged()
                    // return true to indicate this event has been handled
                    return true
                }
                // if we get to this point then the event has not been handled so we can return false
                return false;
            }
        })
    }
    // private fields of the class
    private lateinit var _edittext: EditText
    private lateinit var _recyclerview: RecyclerView
    private var _rl_arraylist : ArrayList<RecyclerItem> = ArrayList<RecyclerItem>()
    private var _count: Int = 0
}
