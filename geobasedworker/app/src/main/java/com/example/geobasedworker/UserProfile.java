package com.example.geobasedworker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;

public class UserProfile extends AppCompatActivity {


    SharedPreferences sharedpreferences;

    FirebaseDatabase firebaseDatabase ;
    DatabaseReference mref;
    FirebaseStorage firebaseStorage;
    ImageButton imageButton ;
    EditText edfirst,edlast,edprice;
    Button btninsert;
    private static final int code=1;
    Uri imageurl = null;


    EditText edname,edaddress,edcontact,editem1,editem1price,editem2,editem2price;
    String lati,longi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        sharedpreferences = getSharedPreferences("pdfdata", Context.MODE_PRIVATE);

        imageButton = findViewById(R.id.imageButton2);
        edname = findViewById(R.id.edname);
        edaddress = findViewById(R.id.edaddress);
        edcontact = findViewById(R.id.edmobile);

        btninsert = findViewById(R.id.btninsert);

        firebaseDatabase = FirebaseDatabase.getInstance();
        mref = firebaseDatabase.getReference().child("Profile");
        firebaseStorage = FirebaseStorage.getInstance();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == code && resultCode == RESULT_OK)
        {

            imageurl = data.getData();
            imageButton.setImageURI(imageurl);
        }

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edname.getText().toString().trim();
                String place1 = edaddress.getText().toString().trim();
                String address = edcontact.getText().toString().trim();



                Geocoder coder = new Geocoder(getApplicationContext());

                try {
                    ArrayList<Address> adresses = (ArrayList<Address>) coder.getFromLocationName(place1, 50);


                    for(Address add : adresses){
                        double longitude = add.getLongitude();
                        double latitude = add.getLatitude();
                        lati = String.valueOf(latitude);
                        longi = String.valueOf(longitude);
//                        Toast.makeText(getApplicationContext(),lati.toString(),Toast.LENGTH_LONG).show();


                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }

                StorageReference filepath =firebaseStorage.getReference().child("imagepost").child(imageurl.getLastPathSegment());
                filepath.putFile(imageurl).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> downloadurl =taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {

                                String t =task.getResult().toString();
                                DatabaseReference newpost =mref.push();

                                newpost.child("Name").setValue(name);
                                newpost.child("Address").setValue(place1);
                                newpost.child("Mobileno").setValue(address);

                                newpost.child("lati").setValue(lati);
                                newpost.child("longi").setValue(longi);

                                newpost.child("imageurl").setValue(task.getResult().toString());
                                Toast.makeText(getApplicationContext(), "Uploaded", Toast.LENGTH_SHORT).show();
                                String key = newpost.getKey().toString();
                                //Toast.makeText(getApplicationContext(),key.toString(),Toast.LENGTH_SHORT).show();



                                sharedata(name,key,place1);

                            }
                        });
                    }
                });
            }
        });
    }

    private void sharedata(String name, String key, String address) {

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("name",name);
        editor.putString("key",key);
        editor.putString("add",address);
        editor.commit();
        editor.apply();
    }
}