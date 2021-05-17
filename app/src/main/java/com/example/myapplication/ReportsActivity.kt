package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.DB.Report
import com.example.myapplication.databinding.ActivityReportsBinding
import kotlin.properties.Delegates

class ReportsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReportsBinding
    private lateinit var mReportViewModel:ReportViewModel

    lateinit var cheker: String

    private val MESSAGE_KEY = "ID SEND"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        binding = ActivityReportsBinding.inflate(layoutInflater)
        val view = binding.root
        val textDate = binding.textViewDate
        val editTextNameOrg = binding.editTextNameOrg
        val editTextNameInspection = binding.editTextNameInspection
        val editTextDone = binding.editTextDone
        val btnSave = binding.btnSaveReport


        // Intent
        val intent = intent
        val message = intent.getStringExtra(MESSAGE_KEY)
        textDate.text = message

        cheker = "false"

        //ViewModel
        mReportViewModel = ViewModelProvider(this).get(ReportViewModel::class.java)
        mReportViewModel.readAllDate.observe(this){ report -> setData(report, message.toString()) }


        btnSave.setOnClickListener {

            if(cheker == "true"){

                updateReport(message.toString(), editTextNameOrg.text.toString(), editTextNameInspection.text.toString(), editTextDone.text.toString())
            } else{
                insertDataToDatabase()
            }

        }

        setContentView(view)
    }




    private fun setData(report: List<Report>?, ID: String) {

        if (report != null) {
            for ( reportID in report){
                if (reportID.id == ID){
                    val editTextNameOrg = binding.editTextNameOrg
                    val editTextNameInspection = binding.editTextNameInspection
                    val editTextDone = binding.editTextDone

                    editTextNameOrg.setText(reportID.nameOrg)
                    editTextNameInspection.setText(reportID.nameInspector)
                    editTextDone.setText(reportID.textDone)

                    cheker = "true"
                }

            }

        } else{
            cheker = "false"
        }
    }

    private fun insertDataToDatabase() {

        val Date = binding.textViewDate.text.toString()
        val NameOrg = binding.editTextNameOrg.text.toString()
        val NameInspection = binding.editTextNameInspection.text.toString()
        val Done = binding.editTextDone.text.toString()


        if (inputChecker(Date,NameOrg,NameInspection)){
            val report = Report(Date,NameOrg,NameInspection,Done)
            mReportViewModel.addReport(report)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Отзыв сохранен !", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
        }
    }


    private fun updateReport(id: String, nameOrg: String, nameInspection: String, nameDone: String) {
        val newReport = Report(id,nameOrg,nameInspection,nameDone)

        if (inputChecker(id, nameOrg, nameInspection)){
            mReportViewModel.updateReport(newReport)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Отзыв изменен и сохранен!", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
        }


    }

    private fun inputChecker(date: String, nameOrg: String, nameInspection: String): Boolean{
        if (date.isNotEmpty() and nameOrg.trim().isNotEmpty() and nameInspection.trim().isNotEmpty()){

            return true
        } else{

            return false
        }
    }

}