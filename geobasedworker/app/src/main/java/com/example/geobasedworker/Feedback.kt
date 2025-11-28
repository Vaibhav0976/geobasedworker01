package com.example.geobasedworker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Feedback : AppCompatActivity() {

    var edname: EditText?=null
    var edprofile: EditText?=null
    var edcriteria: EditText?=null
    var edtime: EditText?=null
    var edhrname: EditText?=null
    var edcontact: EditText?=null
    var edaddress: EditText?=null
    var number:String?=null
    var name:String?=null
    var type:String?=null
    var hour:String?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)


        edname = findViewById<EditText>(R.id.edtype)
        edprofile = findViewById<EditText>(R.id.edname)
        edcriteria = findViewById<EditText>(R.id.eddes)
        edtime = findViewById<EditText>(R.id.edrating)
        val bundle = intent.extras

        number = bundle?.getString("number")
        name = bundle?.getString("name")
        type = bundle?.getString("type")
        hour = bundle?.getString("hour")


    }

    fun UploadData(view: View?) {
        val category = edname!!.text.toString()
        val uname = edprofile!!.text.toString()
        val description = edcriteria!!.text.toString()

        val rating = edtime!!.text.toString()

        val data = FirebaseDatabase.getInstance().reference.child("feedback")
        val service = Userfeedback(category,uname,description,rating,name,number,type,hour)


        data.push().setValue(service)

        Toast.makeText(applicationContext,"Uploaded", Toast.LENGTH_LONG).show()


    }
}