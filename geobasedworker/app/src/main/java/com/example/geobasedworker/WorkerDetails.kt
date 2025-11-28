package com.example.geobasedworker

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.database.DatabaseReference
import java.io.IOException
import java.util.Locale
import kotlin.math.PI
import kotlin.math.acos
import kotlin.math.sin

class WorkerDetails : AppCompatActivity() {

    var name: String? = null
    var material: String? = null
    var manifacute: String? = null
    var origin: String? = null
    var weight: String? = null
    var rating: String? = null
    var demi: String? = null
    var price: String? = null

    var ref: DatabaseReference? = null
    var username: String? = null
    var usermobile: String? = null
    var useremail: String? = null
    var useraddress: String? = null
    var url: String? = null
    var experiance:Int?=null


//    var fusedLocationProviderClient: FusedLocationProviderClient? = null

    var lat1: Double? = null
    var log1: Double? = null
    var lat2: Double? = null
    var log2: Double? = null




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_details)


//        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
//        getlocation()

        val txtproname = findViewById<TextView>(R.id.txtname)
        val txtmaterial = findViewById<TextView>(R.id.txtmaterial)
        val txtaddress = findViewById<TextView>(R.id.txtmanifacture)

        val txtarea = findViewById<TextView>(R.id.txtorigin)
        val txtwight = findViewById<TextView>(R.id.txtweigth)
        val txtprice = findViewById<TextView>(R.id.txtrating)
        val txtexpe = findViewById<TextView>(R.id.txtexpe)


        val btn = findViewById<Button>(R.id.btnorder)
        val btnfeedback = findViewById<Button>(R.id.btntrack)

        btn.setOnClickListener {
            val intent = Intent(applicationContext,Sendinquiry::class.java)

            intent.putExtra("number",manifacute)
            startActivity(intent)
        }

        btnfeedback.setOnClickListener {
            val intent = Intent(applicationContext,Feedback::class.java)

            intent.putExtra("name",name)
            intent.putExtra("number",manifacute)
            intent.putExtra("type",origin)
            intent.putExtra("hour",price)

            startActivity(intent)
        }

        val image = findViewById<ImageView>(R.id.image1)
        val bundle = intent.extras

        name = bundle?.getString("name")
        material = bundle?.getString("address")
        manifacute = bundle?.getString("mobileno")
        origin = bundle?.getString("type")
        weight = bundle?.getString("charges")
        price = bundle?.getString("hours")

        experiance = bundle?.getInt("expe")

//        Toast.makeText(applicationContext,experiance,Toast.LENGTH_LONG).show()
        url = bundle?.getString("url")

        Glide.with(this@WorkerDetails).load(url).into(image)

        txtproname.setText("Name: " + name)
        txtmaterial.setText("Address: " + material)
        txtaddress.setText("Number: " + manifacute)
        txtarea.setText("Type: " + origin)
        txtwight.setText("Charges: " + weight)

        txtprice.setText("Category: " + price)

        txtexpe.setText("Experience: " +experiance)

    }




}