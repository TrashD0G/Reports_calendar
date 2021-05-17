package com.example.myapplication.DB

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "report_table")
data class Report(
    @PrimaryKey val id: String,
    val nameOrg:String,
    val nameInspector:String,
    val textDone:String) {
}