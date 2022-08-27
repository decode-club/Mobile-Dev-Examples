package com.example.mobiledevexamples

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val context: Context, var ri_arraylist: ArrayList<RecyclerItem>) : RecyclerView.Adapter<RecyclerAdapter.ItemHolder>() {
    // private fields of the class
    private val _context: Context = context
    private var _ri_arraylist: ArrayList<RecyclerItem> = ri_arraylist
    // 08 function goes here
    // function that will create a viewholder for the recycler adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        // get access to the layout inflator and inflate a layout for one of our recycler view items
        return ItemHolder(LayoutInflater.from(_context).inflate(R.layout.recycler_item, parent,
            false))
    }

    // 09 function goes here
    // function that will bind an item in our arraylist to a view holder so it can be displayed
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        // get the item at the current position
        val item: RecyclerItem = _ri_arraylist.get(position)
        // set the number and text on the view holder
        holder._tv_text.setText(item.text)
        holder._tv_number.setText(item.number.toString())
    }

    // 07 function goes here
    // returns the number of items that are in this RecyclerAdapter
    override fun getItemCount(): Int {
        return _ri_arraylist.size
    }

    // 06 code goes here
    // nested class that will implement a view holder for an item in the list
    class ItemHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        // private fields of the class
        private var _view: View = v
        private var _recycler_item: RecyclerItem? = null
        lateinit var _tv_text: TextView
        lateinit var _tv_number: TextView
        // called to initialise the object
        init {
            // pull references from the layout for the text views
            _tv_text = _view.findViewById<TextView>(R.id.text)
            _tv_number = _view.findViewById<TextView>(R.id.number)
            // set a listener for clicks on this view holder
            _view.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            Log.i("RecyclerView", "clicked on item" + _tv_number.text)
        }
    }
}