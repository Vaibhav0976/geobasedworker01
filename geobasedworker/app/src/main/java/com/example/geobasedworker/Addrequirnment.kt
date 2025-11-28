package com.example.geobasedworker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Addrequirnment : AppCompatActivity() {

    var edname: EditText?=null
    var edprofile: EditText?=null
    var edcriteria: EditText?=null
    var edtime: EditText?=null
    var edhrname: EditText?=null
    var edcontact: EditText?=null
    var edaddress: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addrequirnment)

        edname = findViewById<EditText>(R.id.edtype)
        edprofile = findViewById<EditText>(R.id.edname)
        edcriteria = findViewById<EditText>(R.id.eddes)
        edtime = findViewById<EditText>(R.id.edprice)


    }

    fun UploadData(view: View?) {
        val category = edname!!.text.toString()
        val name = edprofile!!.text.toString()
        val description = edcriteria!!.text.toString()
        val price = edtime!!.text.toString()


        val data = FirebaseDatabase.getInstance().getReference().child("Require")
        val service = Requirement(category,name,description,price)


        data.push().setValue(service)

        Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()



    }
}