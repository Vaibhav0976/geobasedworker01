package com.example.geobasedworker

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Showfeedback : AppCompatActivity() {


    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null

    private var adapter:FeedbackAdapter?=null
    private var list: ArrayList<Userfeedback>? = null


    var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showfeedback)

        sharedpreferences = getSharedPreferences("pdfdata", MODE_PRIVATE)
        val wname =  sharedpreferences!!.getString("name","")
        Toast.makeText(applicationContext,wname.toString(), Toast.LENGTH_LONG).show()



        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        list = ArrayList()


        val pref = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val name = pref.getString("name", "")
        Toast.makeText(applicationContext,name.toString(), Toast.LENGTH_LONG).show()
        database = FirebaseDatabase.getInstance()


        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("feedback")

        val query: Query = mDatabaseRef.orderByChild("wname").equalTo(wname)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                print(dataSnapshot)


                for (data in dataSnapshot.children) {
                    println(data)




                    val models: Userfeedback? = data.getValue(Userfeedback::class.java)
                    println(models)
                    if (models != null) {
                        list!!.add(models)
                    }

                }

                adapter = FeedbackAdapter(list,applicationContext)
                recyclerView.adapter = adapter

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })


    }
}