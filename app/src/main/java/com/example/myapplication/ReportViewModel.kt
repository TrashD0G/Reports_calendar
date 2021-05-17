package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.DB.Report
import com.example.myapplication.DB.ReportDatabase
import com.example.myapplication.DB.ReportRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ReportViewModel(application: Application) : AndroidViewModel(application){

    val readAllDate: LiveData<List<Report>>



    private val repository: ReportRepository

    init {
        val reportDao = ReportDatabase.getDatabase(application).reportDao()
        repository = ReportRepository(reportDao)
        readAllDate = repository.readAllData

    }

    fun addReport(report: Report){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addReport(report)
        }
    }

    fun updateReport(report:Report){
        viewModelScope.launch(Dispatchers.IO){ repository.updateReport(report)}
    }

}