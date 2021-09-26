package com.example.blooddonationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReceiverProfile extends AppCompatActivity {
    TextView National_id, Name, Blood_type, Gender, DOB, Phone, Email, Address, City;
    Button Update, Delete;
    DatabaseReference dbRef;
    final static String key="";
    Receiver receiver;

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
//                viewReceiverProfileUpdate();
                Intent intent = new Intent(ReceiverProfile.this, UpdateBloodReceiver.class);
                String id = receiver.getKey();
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Redirecting to update page...", Toast.LENGTH_SHORT).show();
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                navigateToHome();
                DatabaseReference showRef = FirebaseDatabase.getInstance().getReference().child("Receiver");
                showRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("")) {
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Receiver").child("");
                            dbRef.removeValue();

                            Toast.makeText(getApplicationContext(), "Data Successfully Deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "No Source to Deleted", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

//            @Override
            protected void onResume() {
//                super.onResume();

                dbRef = FirebaseDatabase.getInstance().getReference().child("Receiver").child("");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()) {
                            receiver = dataSnapshot.getValue(Receiver.class);
                            receiver.setKey(dataSnapshot.getKey());

                            National_id.setText(dataSnapshot.child("Id").getValue().toString());
                            Name.setText(dataSnapshot.child("Name").getValue().toString());
                            DOB.setText(dataSnapshot.child("DOB").getValue().toString());
//                            Gender
                            Email.setText(dataSnapshot.child("Email").getValue().toString());
                            Phone.setText(dataSnapshot.child("Phone").getValue().toString());
                            Address.setText(dataSnapshot.child("Address").getValue().toString());
                            City.setText(dataSnapshot.child("City").getValue().toString());
                        } else {
                            Toast.makeText(getApplicationContext(), "Details Not Displayed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}