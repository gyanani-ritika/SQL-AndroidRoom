package com.example.mysql

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class AddTask : AppCompatActivity() , TimePickerDialog.OnTimeSetListener , DatePickerDialog.OnDateSetListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        val date : Button = findViewById(R.id.date)
        date.setOnClickListener {
            val datePicker: DialogFragment = DateFragment()
            datePicker.show(supportFragmentManager, "Date Picker")
        }

        val time : Button = findViewById(R.id.time)
        time.setOnClickListener {
            val timePicker: DialogFragment = TimeFragment()
            timePicker.show(supportFragmentManager, "Time Picker")
        }

    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val timePicker: DialogFragment = TimeFragment()
        timePicker.show(supportFragmentManager, "Time Picker")
        val txtViewDate : TextView = findViewById(R.id.txtDate)
        txtViewDate.text = "$dayOfMonth-$month-$year"    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val txtViewTime : TextView = findViewById(R.id.txtTime)
        txtViewTime.text = "$hourOfDay:$minute"
    }
}
