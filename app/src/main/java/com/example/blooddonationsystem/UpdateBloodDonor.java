package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class UpdateBloodDonor extends AppCompatActivity {
    EditText National_Id, Name, DOB, Email, Phone, Address, City;
    RadioButton Male, Female;
    Spinner Blood_Type;
    Button Update;
//    Donor donor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_blood_donor);

        National_Id = findViewById(R.id.DU_ET_national_id);
        Name = findViewById(R.id.DU_ET_name);
        DOB = findViewById(R.id.DU_ET_dob);
        Email = findViewById(R.id.DU_ET_email);
        Phone = findViewById(R.id.DU_ET_phone);
        Address = findViewById(R.id.DU_ET_address);
        City = findViewById(R.id.DU_ET_city);

        Blood_Type = findViewById(R.id.DU_spinner_blood_type);

        //Radio Buttons

        //        donor = new Donor;
        Update = findViewById(R.id.DU_B_update);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDonorProfile();
            }
        });
    }
    private void viewDonorProfile() {
        Intent intent = new Intent(this, DonorProfile.class);
        startActivity(intent);
    }
}