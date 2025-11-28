package com.example.geobasedworker

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Displayprofile : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var mDatabase: DatabaseReference? = null
    var dname: String? = null
    var hname: String? = null
    var address: String? = null
    var desi: String? = null
    var contact: String? = null
    var udname: String? = null
    var uhname: String? = null
    var uhaddress: String? = null
    var udesi: String? = null
    var ucontact: String? = null
    var username: String? = null


    var sharedpreferences: SharedPreferences? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_displayprofile)


        val btndelete = findViewById<Button>(R.id.btndelete)
        sharedpreferences = getSharedPreferences("pdfdata", MODE_PRIVATE)
        val name =  sharedpreferences!!.getString("name","")
        val key = sharedpreferences!!.getString("key","")
        Toast.makeText(applicationContext,key.toString(),Toast.LENGTH_LONG).show()


        database = FirebaseDatabase.getInstance()
        mDatabase = database!!.getReference("Doctor")
//        val update = findViewById<Button>(R.id.btnupdate)
        val txtdname = findViewById<TextView>(R.id.txtdname)
        val txthname = findViewById<TextView>(R.id.txthname)
        val txthaddress = findViewById<TextView>(R.id.txtadress)
        val txtdesi = findViewById<TextView>(R.id.txtdesi)
        val txtcontact = findViewById<TextView>(R.id.txtcontact)
        val txttime = findViewById<TextView>(R.id.txttime)
        val image1= findViewById<ImageView>(R.id.img1)


        val btn = findViewById<Button>(R.id.btnupdate)

        btn.setOnClickListener {
            val i = Intent(applicationContext, Updateprofile::class.java)
            startActivity(i)
        }


        btndelete.setOnClickListener {
            val mPostReference = FirebaseDatabase.getInstance().reference
                .child("Worker").child(key!!);
            mPostReference.removeValue();

            Toast.makeText(applicationContext,"Delete Successfully",Toast.LENGTH_LONG).show()

        }

        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("Worker")

        val query: Query = mDatabaseRef.orderByChild("Name").equalTo(name)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (data in dataSnapshot.children) {
                    println(data)
                    val models: Workers? = data.getValue(Workers::class.java)

//                    val latitude: String = models!!.doctorname
//                    val longitude: String = models!!.Contactnumber
                    desi = models!!.name
                    dname = models!!.type
                    hname = models!!.mobileno
                    address = models!!.address
                    contact = models.charges
                    udname = models.hours
                    txtdname.setText("Name -"+desi)
                    txthname.setText("Mobile No -"+hname)
                    txthaddress.setText("Address -"+address)
                    txtdesi.setText("Type -"+dname)
                    txtcontact.setText("Charges -"+contact)
                    txttime.setText("Time "+udname)
                    Glide.with(image1.getContext()).load(models.imageurl)
                        .into(image1)

                }

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}