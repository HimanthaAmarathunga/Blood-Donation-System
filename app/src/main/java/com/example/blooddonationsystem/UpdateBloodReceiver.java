package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class UpdateBloodReceiver extends AppCompatActivity {
    EditText National_Id, Name, DOB, Email, Phone, Address, City;
    RadioButton Male, Female;
    Spinner Blood_Type;
    Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_blood_receiver);

        National_Id = findViewById(R.id.RU_ET_national_id);
        Name = findViewById(R.id.RU_ET_name);
        DOB = findViewById(R.id.RU_ET_dob);
        Email = findViewById(R.id.RU_ET_email);
        Phone = findViewById(R.id.RU_ET_phone);
        Address = findViewById(R.id.RU_ET_address);
        City = findViewById(R.id.RU_ET_city);

        Blood_Type = findViewById(R.id.RU_spinner_blood_type);

        //Radio Buttons

        //        donor = new Donor;
        Update = findViewById(R.id.RU_B_update);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewReceiverProfile();
            }
        });
    }
    private void viewReceiverProfile() {
        Intent intent = new Intent(this, ReceiverProfile.class);
        startActivity(intent);
    }
}