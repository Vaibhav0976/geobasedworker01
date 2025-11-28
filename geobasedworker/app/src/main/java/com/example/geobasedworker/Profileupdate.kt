package com.example.geobasedworker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Profileupdate : AppCompatActivity() {


    var name: String? = null
    var number: String? = null
    var address: String? = null
    var username: String? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profileupdate)


        val prf = getSharedPreferences("pdfdata", MODE_PRIVATE)
        username = prf.getString("name", "")

        val key = prf.getString("key", "")
        val eddname = findViewById<EditText>(R.id.eddname)
        val edhname = findViewById<EditText>(R.id.edhname)
        val edaddress = findViewById<EditText>(R.id.edhaddress)


        val btnupdate = findViewById<Button>(R.id.update)
        btnupdate.setOnClickListener {
            name = eddname.text.toString()
            number = edhname.text.toString()
            address = edaddress.text.toString()

            val databaseReference = FirebaseDatabase.getInstance().getReference("Profile").child(key!!)
            databaseReference.child("Name").setValue(name)
            databaseReference.child("Mobileno").setValue(number)
            databaseReference.child("Address").setValue(address)

            Toast.makeText(applicationContext,"Update",Toast.LENGTH_LONG).show()

        }
    }
}