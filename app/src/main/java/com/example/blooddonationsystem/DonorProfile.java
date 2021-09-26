package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DonorProfile extends AppCompatActivity {
    TextView National_id, Name, Blood_type, Gender, DOB, Phone, Email, Address, City;
    Button Update, Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_profile);

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
                viewDonorProfileUpdate();
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHome();
            }
        });
    }

    private void viewDonorProfileUpdate() {
        Intent intent = new Intent(this, UpdateBloodDonor.class);
        startActivity(intent);
    }

    private void navigateToHome() {
//        Intent intent = new Intent(this, Homepage.class);
//        startActivity(intent);
    }
}