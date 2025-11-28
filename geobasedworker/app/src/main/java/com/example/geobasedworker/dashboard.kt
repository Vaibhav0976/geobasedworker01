package com.example.geobasedworker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class dashboard : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        val img1= findViewById<ImageView>(R.id.client)

        val img2 = findViewById<ImageView>(R.id.worker)

        img1.setOnClickListener {

            val intent = Intent(applicationContext,home::class.java)
            startActivity(intent)
        }


        img2.setOnClickListener {

            val intent = Intent(applicationContext,Workerhome::class.java)
            startActivity(intent)
        }


    }
}