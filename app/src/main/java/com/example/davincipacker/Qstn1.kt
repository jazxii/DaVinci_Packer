package com.example.davincipacker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Qstn1 : AppCompatActivity() {



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qstn1)
        supportActionBar?.hide()

        var formate = SimpleDateFormat("dd MMM, YYYY",Locale.US)
        var timeformate = SimpleDateFormat("hh:mm a",Locale.US)
        val now = Calendar.getInstance()
        val shwdat: TextView = findViewById(R.id.datshw)
        val shwtim: TextView = findViewById(R.id.timshw)



        //the date picker
        val da : Button = findViewById(R.id.btn_date)
        da.setOnClickListener {
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(Calendar.YEAR, year)
                selectedDate.set(Calendar.MONTH, month)
                selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val date = formate.format(selectedDate.time)
                shwdat.text=date
                Toast.makeText(this, "date :$date",Toast.LENGTH_SHORT).show()
            }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()

        }
        //the time picker
        val ti : Button = findViewById(R.id.btn_time)
        ti.setOnClickListener {
            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val selectedTime = Calendar.getInstance()
                selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectedTime.set(Calendar.MINUTE, minute)
                shwtim.text=timeformate.format(selectedTime.time)
                Toast.makeText(this, "time :" + timeformate.format(selectedTime.time), Toast.LENGTH_SHORT).show()
            }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false)
            timePicker.show()
        }


        val nxt1 : Button = findViewById(R.id.nxt1)
        nxt1.setOnClickListener {
            val intent= Intent(this, Qstn2::class.java)
            startActivity(intent)
        }


    }


}


