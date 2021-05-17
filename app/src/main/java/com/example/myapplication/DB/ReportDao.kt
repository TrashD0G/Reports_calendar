package com.example.myapplication.DB

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ReportDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addReport(report: Report)



    @Update
    suspend fun updateReport(report: Report)

    @Query("SELECT * FROM report_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Report>>
}