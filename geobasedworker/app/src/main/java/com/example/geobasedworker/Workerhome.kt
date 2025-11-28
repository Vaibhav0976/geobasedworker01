package com.example.geobasedworker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class Workerhome : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workerhome)

        val bottom = findViewById<BottomNavigationView>(R.id.bottom)

        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {


                R.id.shop ->
                {
                    val i = Intent(applicationContext, Addwoker::class.java)
                    startActivity(i)
                    true
                }


                R.id.feedback ->
                {

                    val i = Intent(applicationContext,Showfeedback::class.java)
                    startActivity(i)
                    true
                }
                R.id.showre ->
                {

                    val i = Intent(applicationContext,Displayrequire::class.java)
                    startActivity(i)
                    true
                }
                R.id.profile ->
                {

                    val i = Intent(applicationContext,Displayprofile::class.java)
                    startActivity(i)
                    true
                }



                else -> {false}
            }
        }

    }
}