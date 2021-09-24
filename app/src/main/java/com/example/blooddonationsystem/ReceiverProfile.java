package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiverProfile extends AppCompatActivity {
    TextView National_id, Name, Blood_type, Gender, DOB, Phone, Email, Address, City;
    Button Update, Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_profile);

        National_id = findViewById(R.id.RP_TV_show_national_id);
        Name = findViewById(R.id.RP_TV_show_name);
        Blood_type = findViewById(R.id.RP_TV_show_blood_type);
        Gender = findViewById(R.id.RP_TV_show_gender);
        DOB = findViewById(R.id.RP_TV_show_dob);
        Phone = findViewById(R.id.RP_TV_show_phone);
        Email = findViewById(R.id.RP_TV_show_email);
        Address = findViewById(R.id.RP_TV_show_address);
        City = findViewById(R.id.RP_TV_show_city);

        Update = findViewById(R.id.RP_B_update);
        Delete = findViewById(R.id.RP_B_delete);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewReceiverProfileUpdate();
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToHome();
            }
        });
    }

    private void viewReceiverProfileUpdate() {
        Intent intent = new Intent(this, UpdateBloodReceiver.class);
        startActivity(intent);
    }

    private void navigateToHome() {
//        Intent intent = new Intent(this, Homepage.class);
//        startActivity(intent);
    }
}