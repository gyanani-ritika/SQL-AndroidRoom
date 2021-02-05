package com.example.mysql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import com.getbase.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val floatingAdd: com.google.android.material.floatingactionbutton.FloatingActionButton = findViewById(R.id.floatingAdd)
        floatingAdd.setOnClickListener {
            val i = Intent(this@MainActivity, AddTask::class.java)
            startActivity(i)
        }
        val db = Room.databaseBuilder(
                applicationContext,
                Database::class.java, "Student"
        ).build()
        Thread {
            val student1 = Entity(rollno = 4, name = "Leisha")
            db.dao().insertAll(student1)
            db.dao().getAll().forEach {
                Log.i("Student ", "RollNo : ${it.rollno}")
                Log.i("Student ", "Name : ${it.name}")

            }
        }.start()

    }
}




//val db = Room.databaseBuilder(
//        applicationContext,
//        Database::class.java, "Student"
//).build()
//Thread {
//    val student1 = Entity(rollno = 4, name = "Leisha")
//    db.dao().insertAll(student1)
//    db.dao().getAll().forEach {
//        Log.i("Student ", "RollNo : ${it.rollno}")
//        Log.i("Student ", "Name : ${it.name}")
//
//    }
//}.start()

