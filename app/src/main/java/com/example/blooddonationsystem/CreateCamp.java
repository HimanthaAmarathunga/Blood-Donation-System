package com.example.blooddonationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class CreateCamp extends AppCompatActivity {
    EditText name, date, location;
    Button createCamp;
    Camp camp =new Camp();
    DatabaseReference dbRef;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_camp);

        name = findViewById(R.id.CC_ET_camp_name);
        date = findViewById(R.id.CC_ET_camp_date);
        location = findViewById(R.id.CC_ET_camp_location);

        createCamp = findViewById(R.id.CC_BT_Create_Camp);

        dbRef = FirebaseDatabase.getInstance().getReference().child("Camp");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                i = (int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        createCamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (TextUtils.isEmpty(name.getText().toString())) {
                        Toast.makeText(CreateCamp.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(date.getText().toString())) {
                        Toast.makeText(CreateCamp.this, "Enter Date", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(location.getText().toString())) {
                        Toast.makeText(CreateCamp.this, "Enter Location", Toast.LENGTH_SHORT).show();
                    }else {
                        camp.setName(name.getText().toString().trim());
                        camp.setDate( date.getText().toString());
                        camp.setLocation(location.getText().toString().trim());

                        dbRef.push().setValue(camp);
                        Toast.makeText(getApplicationContext(),"Registration Successful", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }}