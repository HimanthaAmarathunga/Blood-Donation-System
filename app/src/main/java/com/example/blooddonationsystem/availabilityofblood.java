package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class availabilityofblood extends AppCompatActivity {

    TextView National_id, Name, Blood_type, Gender, DOB, Phone, Email, Address, City;
    Button Update, Delete;
    DatabaseReference dbRef;
    final static String key="";
    Donor donor;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availabilityofblood);
        setContentView(R.layout.activity_hospitalmanagement);

        National_id = findViewById(R.id.DP_TV_show_national_id);
        Name = findViewById(R.id.DP_TV_show_name);
        Blood_type = findViewById(R.id.DP_TV_show_blood_type);
        Gender = findViewById(R.id.DP_TV_show_gender);
        DOB = findViewById(R.id.DP_TV_show_dob);
        Phone = findViewById(R.id.DP_TV_show_phone);
        Email = findViewById(R.id.DP_TV_show_email);
        Address = findViewById(R.id.DP_TV_show_address);
        City = findViewById(R.id.DP_TV_show_city);

        Update = findViewById(R.id.DP_B_update);
        Delete = findViewById(R.id.DP_B_delete);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(availabilityofblood.this, UpdateBloodDonor.class);
                String id = donor.getKey();
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Redirecting to update page...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}