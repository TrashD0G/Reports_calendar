package com.example.myapplication.DB

import androidx.lifecycle.LiveData

class ReportRepository(private val reportDao: ReportDao) {

    val readAllData: LiveData<List<Report>> = reportDao.readAllData()



    suspend fun addReport(report: Report){
        reportDao.addReport(report)
    }

    suspend fun updateReport(report: Report){
        reportDao.updateReport(report)
    }



}