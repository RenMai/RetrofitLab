package com.example.w1_d4_retrofitlab

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PresidentListAdapter(context: Context, private val presidents: MutableList<President>): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return presidents.size
    }

    override fun getItem(position: Int): Any {
        return presidents[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item, parent, false)

        val thisPresident = presidents[position]

        var textView: TextView = rowView.findViewById(R.id.name)
        textView.text = thisPresident.name

        textView = rowView.findViewById(R.id.startDate)
        textView.text = thisPresident.startDuty.toString()

        textView = rowView.findViewById(R.id.endDate)
        textView.text = thisPresident.endDuty.toString()

        return rowView
    }
}