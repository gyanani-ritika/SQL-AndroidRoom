package com.example.mysql

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO {
    @Query("SELECT * FROM student")
    fun getAll(): List<Entity>

    @Query("SELECT * FROM student WHERE rollno IN (:userRollno)")
    fun loadAllByIds(userRollno: IntArray): List<Entity>
    @Insert
    fun insertAll(vararg users: Entity)

    @Delete
    fun delete(user: Entity)
}
