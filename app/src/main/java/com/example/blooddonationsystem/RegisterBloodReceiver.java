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

public class RegisterBloodReceiver extends AppCompatActivity {
    EditText National_Id, Name, DOB, Email, Phone, Address, City;
    RadioButton Male, Female;
    Spinner Blood_Type;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_blood_receiver);

        National_Id = findViewById(R.id.RR_ET_national_id);
        Name = findViewById(R.id.RR_ET_name);
        DOB = findViewById(R.id.RR_ET_dob);
        Email = findViewById(R.id.RR_ET_email);
        Phone = findViewById(R.id.RR_ET_phone);
        Address = findViewById(R.id.RR_ET_address);
        City = findViewById(R.id.RR_ET_city);

        Blood_Type = findViewById(R.id.RR_spinner_blood_type);

        //Radio Buttons

        Register = findViewById(R.id.RR_B_register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (TextUtils.isEmpty(National_Id.getText().toString())) {
                        Toast.makeText(RegisterBloodReceiver.this, "Enter National Id", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Name.getText().toString())) {
                        Toast.makeText(RegisterBloodReceiver.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(DOB.getText().toString())) {
                        Toast.makeText(RegisterBloodReceiver.this, "Enter DOB", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Email.getText().toString())) {
                        Toast.makeText(RegisterBloodReceiver.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Phone.getText().toString())) {
                        Toast.makeText(RegisterBloodReceiver.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Address.getText().toString())) {
                        Toast.makeText(RegisterBloodReceiver.this, "Enter Address", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(City.getText().toString())) {
                        Toast.makeText(RegisterBloodReceiver.this, "Enter City", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Registration Successful", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
                loadReceiverProfile();
            }
        });
    }
    private void loadReceiverProfile() {
        Intent intent = new Intent(this, ReceiverProfile.class);
        startActivity(intent);
    }
}