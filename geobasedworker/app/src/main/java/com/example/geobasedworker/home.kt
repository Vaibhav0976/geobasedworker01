package com.example.geobasedworker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

//        val bottom = findViewById<BottomNavigationView>(R.id.bottom)
//
//        bottom.setOnNavigationItemSelectedListener {
//            when(it.itemId)
//            {
//                R.id.home -> {
//                    val i = Intent(applicationContext, my::class.java)
//                    startActivity(i)
//                    true }
//
//                R.id.shop ->
//                {
//                    Toast.makeText(applicationContext,"Search by Location",Toast.LENGTH_LONG).show()
////                    val i = Intent(applicationContext, location::class.java)
////                    startActivity(i)
//                    true
//                }
//                R.id.rating ->
//                {
//                    Toast.makeText(applicationContext,"Search by Rating",Toast.LENGTH_LONG).show()
////                    val i = Intent(applicationContext, location::class.java)
////                    startActivity(i)
//                    true
//                }
//
//                R.id.type ->
//                {
//
//                    Toast.makeText(applicationContext,"Search by Type",Toast.LENGTH_LONG).show()
////                    val i = Intent(applicationContext, location::class.java)
////                    startActivity(i)
//                    true
//                }
//
//                R.id.newre ->
//                {
//                    Toast.makeText(applicationContext,"New Require",Toast.LENGTH_LONG).show()
////                    val i = Intent(applicationContext, location::class.java)
////                    startActivity(i)
//                    true
//                }
//
//                R.id.feedback ->
//                {
//                    Toast.makeText(applicationContext,"Feedback/Rating",Toast.LENGTH_LONG).show()
////                    val i = Intent(applicationContext, location::class.java)
////                    startActivity(i)
//                    true
//                }
//
//
//
//
//
//
//
//                else -> {false}
//            }
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {


            R.id.profile -> {
//                Toast.makeText(applicationContext,"Add Profile",Toast.LENGTH_LONG).show()

                val i = Intent(applicationContext, UserProfile::class.java)
                startActivity(i)
                 }

            R.id.rec ->
            {
//                Toast.makeText(applicationContext,"Search by Location",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext, Alllocation::class.java)
                    startActivity(i)

            }


            R.id.newre ->
            {
               // Toast.makeText(applicationContext,"New Require",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext, Addrequirnment::class.java)
                    startActivity(i)

            }


            R.id.showpro ->
            {
                //Toast.makeText(applicationContext,"Show Profile",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext, Showprofile::class.java)
                    startActivity(i)

            }
            R.id.logout ->
            {
//                Toast.makeText(applicationContext,"Feedback/Rating",Toast.LENGTH_LONG).show()
                    val i = Intent(applicationContext, login::class.java)
                    startActivity(i)

            }


        }
        return true

    }
}