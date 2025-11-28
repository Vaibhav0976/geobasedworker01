package com.example.geobasedworker

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.location.Address
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class Showalllocation : AppCompatActivity() {

    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null

    private var adapter:TypeAdapter?=null
    private var list: ArrayList<Workers>? = null

    private  var mylist :ArrayList<String>?=null

    var searchView: SearchView? = null
    var recyclerView: RecyclerView?=null





    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showalllocation)

        searchView = findViewById(R.id.searchview)


        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        list = ArrayList()


        val pref = getSharedPreferences("user", MODE_PRIVATE)
        val address = pref.getString("Address", "default")
        Toast.makeText(applicationContext,address.toString(), Toast.LENGTH_LONG).show()
        database = FirebaseDatabase.getInstance()


        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("Worker")

        val query: Query = mDatabaseRef.orderByChild("Address").equalTo(address)

        query.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                print(dataSnapshot)


                for (data in dataSnapshot.children) {
                    println(data)


                    val models: Workers? = data.getValue(Workers::class.java)
                    println(models)
                    if (models != null) {
                        list!!.add(models)
                    }







                }

                adapter = TypeAdapter(list,applicationContext)
                recyclerView!!.adapter = adapter

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }

    override fun onStart() {
        super.onStart()

        if (searchView != null) {
            searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(s: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(s: String): Boolean {
                    search(s)
                    return true
                }
            })
        }
    }

    private fun search(s: String) {

        try{
            val mylist = ArrayList<Workers?>()
            for (`object` in list!!) {
                if (`object`!!.type.toLowerCase().contains(s.toLowerCase())) {
                    mylist.add(`object`)
                }
            }
            val adapter = TypeAdapter(mylist,applicationContext)
            recyclerView!!.adapter = adapter
        }catch (e:Exception){
            e.printStackTrace()
        }


    }


}
