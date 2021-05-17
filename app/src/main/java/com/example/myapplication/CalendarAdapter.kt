package com.example.myapplication

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*
class CalendarAdapter(private var daysOfMonthList: ArrayList<String>) : RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.calendar_cell,parent,false)
        var layooutParams:ViewGroup.LayoutParams = itemView.layoutParams
        layooutParams.height =  (parent.height * 0.166666666).toInt()

        return CalendarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {

        var currentItem = daysOfMonthList[position]

        holder.dayOfMonth.text = currentItem

        holder.itemView.setOnClickListener {



        }


    }

    override fun getItemCount(): Int {
        return daysOfMonthList.size
    }





    class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var dayOfMonth = itemView.findViewById<TextView>(R.id.textView_cell_day)

    }

} */