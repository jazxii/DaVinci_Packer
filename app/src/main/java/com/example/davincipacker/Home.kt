package com.example.davincipacker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val pl : Button = findViewById(R.id.plan)
        pl.setOnClickListener {
            val intent = Intent(this, Qstn1::class.java)
            startActivity(intent)
        }




    }



}