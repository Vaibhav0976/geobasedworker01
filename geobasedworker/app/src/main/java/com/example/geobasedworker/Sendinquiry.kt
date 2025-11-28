package com.example.geobasedworker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class Sendinquiry : AppCompatActivity() {

    var edname: EditText?=null
    var edprofile: EditText?=null
    var edcriteria: EditText?=null
    var edtime: EditText?=null
    var edhrname: EditText?=null
    var edcontact: EditText?=null
    var edaddress: EditText?=null
    var number:String?=null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sendinquiry)

        edname = findViewById<EditText>(R.id.edtype)
        edprofile = findViewById<EditText>(R.id.edname)
        edcriteria = findViewById<EditText>(R.id.eddes)


        val bundle = intent.extras

       number = bundle?.getString("number")

    }

    fun UploadData(view: View?) {
        val category = edname!!.text.toString()
        val name = edprofile!!.text.toString()
        val description = edcriteria!!.text.toString()



        val sb = StringBuffer()
        sb.append("Name").append(category)
        sb.append(System.getProperty("line.separator"))
        sb.append("Number").append(name)
        sb.append(System.getProperty("line.separator"))
        sb.append("address").append(description)
        val msg = sb.toString()

        val smsManager = SmsManager.getDefault() as SmsManager
        smsManager.sendTextMessage(number,null,msg,null,null)

        Toast.makeText(applicationContext,"Send sms",Toast.LENGTH_LONG).show()

    }
}