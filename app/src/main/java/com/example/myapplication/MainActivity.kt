package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    private val MESSAGE_KEY = "ID SEND"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        var calendar = binding.calendarView
        var openReportBtn = binding.btnOpenReport

        //Date format
        var sdf = SimpleDateFormat("dd.M.yyyy")
        var currentDate = sdf.format(calendar.date)


        Log.i("TAG", "current date : " + currentDate.toString())

        calendar.setOnDateChangeListener{ calendarView, year, month, dayOfMonth ->
            val msg = dayOfMonth.toString() + "." + (month + 1).toString() + "." + year.toString()
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()

            currentDate = msg
            Log.i("TAG", "current date После изменений: " + currentDate.toString())

        }




        openReportBtn.setOnClickListener{
            val intent = Intent(this, ReportsActivity::class.java)
            val message = currentDate
            Log.i("TAG", "current date отправлений в сообщения: " + currentDate.toString())

            intent.putExtra(MESSAGE_KEY, message)
            startActivity(intent)
        }

       setContentView(view)
    }







   /* private fun initRecycler() {
        calendarRecyclerView = binding.recyclerViewCalendar
        monthYearText = binding.monthYearTV
    } */
}