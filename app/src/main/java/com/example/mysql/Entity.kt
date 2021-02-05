package com.example.mysql

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
  public data class Entity(
        @PrimaryKey var rollno : Int,
        @ColumnInfo(name = "Name") var name: String?
    )