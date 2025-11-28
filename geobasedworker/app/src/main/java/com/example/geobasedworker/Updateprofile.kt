package com.example.geobasedworker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Updateprofile : AppCompatActivity() {

    var name: String? = null
    var number: String? = null
    var address: String? = null
    var type: String? = null
    var charges: String? = null
    var time: String? = null
    var docname: String? = null

    var username:String?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updateprofile)

        val prf = getSharedPreferences("pdfdata", MODE_PRIVATE)
        username = prf.getString("key", "")

        val eddname = findViewById<EditText>(R.id.eddname)
        val edhname = findViewById<EditText>(R.id.edhname)
        val edaddress = findViewById<EditText>(R.id.edhaddress)
        val eddesi = findViewById<EditText>(R.id.eddesi)
        val edcontact = findViewById<EditText>(R.id.edcontact)

        val edtime = findViewById<EditText>(R.id.edcharges)
        val btnupdate = findViewById<Button>(R.id.update)
        btnupdate.setOnClickListener {
            name = eddname.text.toString()
            number = edhname.text.toString()
            address = edaddress.text.toString()
            type = eddesi.text.toString()
            charges = edcontact.text.toString()
            time = edtime.text.toString()

            val databaseReference =
                FirebaseDatabase.getInstance().getReference("Worker").child(username!!)
            databaseReference.child("Name").setValue(name)
            databaseReference.child("Mobileno").setValue(number)
            databaseReference.child("Address").setValue(address)
            databaseReference.child("Type").setValue(type)
            databaseReference.child("Charges").setValue(charges)
            databaseReference.child("hours").setValue(time)


            Toast.makeText(applicationContext, "Update", Toast.LENGTH_LONG).show()
        }


    }
}