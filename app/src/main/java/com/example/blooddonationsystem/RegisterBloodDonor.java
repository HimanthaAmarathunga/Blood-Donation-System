package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterBloodDonor extends AppCompatActivity {
    EditText National_Id, Name, DOB, Email, Phone, Address, City;
    RadioButton Male, Female;
    Spinner Blood_Type;
    Button Register;
//    Donor donor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_blood_donor);

        National_Id = findViewById(R.id.DR_ET_national_id);
        Name = findViewById(R.id.DR_ET_name);
        DOB = findViewById(R.id.DR_ET_dob);
        Email = findViewById(R.id.DR_ET_email);
        Phone = findViewById(R.id.DR_ET_phone);
        Address = findViewById(R.id.DR_ET_Address);
        City = findViewById(R.id.DR_ET_city);

        Blood_Type = findViewById(R.id.DR_spinner_blood_type);

        //Radio Buttons

        Register = findViewById(R.id.DR_B_register);

//        donor = new Donor;

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (TextUtils.isEmpty(National_Id.getText().toString())) {
                        Toast.makeText(RegisterBloodDonor.this, "Enter National Id", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Name.getText().toString())) {
                        Toast.makeText(RegisterBloodDonor.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(DOB.getText().toString())) {
                        Toast.makeText(RegisterBloodDonor.this, "Enter DOB", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Email.getText().toString())) {
                        Toast.makeText(RegisterBloodDonor.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Phone.getText().toString())) {
                        Toast.makeText(RegisterBloodDonor.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Address.getText().toString())) {
                        Toast.makeText(RegisterBloodDonor.this, "Enter Address", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(City.getText().toString())) {
                        Toast.makeText(RegisterBloodDonor.this, "Enter City", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Registration Successful", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                loadDonorProfile();
            }
        });
    }
    private void loadDonorProfile() {
        Intent intent = new Intent(this, DonorProfile.class);
        startActivity(intent);
    }
}