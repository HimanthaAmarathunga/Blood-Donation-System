package com.example.blooddonationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateBloodReceiver extends AppCompatActivity {
    EditText National_Id, Name, DOB, Email, Phone, Address, City;
    RadioButton Male, Female;
    Spinner Blood_Type;
    Button Update;
    Receiver receiver;
    DatabaseReference dbRef;
    String key;

    ArrayAdapter<CharSequence> locationAdapter, timeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_blood_receiver);

        Intent intent = getIntent();
        key = intent.getStringExtra(ReceiverProfile.key);

        National_Id = findViewById(R.id.RU_ET_national_id);
        Name = findViewById(R.id.RU_ET_name);
        DOB = findViewById(R.id.RU_ET_dob);
        Email = findViewById(R.id.RU_ET_email);
        Phone = findViewById(R.id.RU_ET_phone);
        Address = findViewById(R.id.RU_ET_address);
        City = findViewById(R.id.RU_ET_city);

        Blood_Type = findViewById(R.id.RU_spinner_blood_type);

        //Radio Buttons

//        dbRef = FirebaseDatabase.getInstance().getReference().child("Receiver").child(key);
//        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                receiver = dataSnapshot.getValue(Receiver.class);
//
//                National_Id.setText(receiver.getNationalId());
//                Name.setText(receiver.getName());
////                DOB.setText(receiver.getDob());
//                Email.setText(receiver.getEmail());
////                gender
//                Phone.setText(receiver.getPhone());
//                Address.setText(receiver.getAddress());
//                City.setText(receiver.getCity());
//            }

//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        Update = findViewById(R.id.RU_B_update);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewReceiverProfile();
                receiver.setNationalId(National_Id.getText().toString().trim());
                receiver.setNationalId(Name.getText().toString().trim());
                receiver.setNationalId(DOB.getText().toString().trim());
                receiver.setNationalId(Email.getText().toString().trim());
                receiver.setNationalId(Phone.getText().toString().trim());
                receiver.setNationalId(Address.getText().toString().trim());
                receiver.setNationalId(City.getText().toString().trim());

                dbRef.setValue(receiver);
                Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void viewReceiverProfile() {
        Intent intent = new Intent(this, ReceiverProfile.class);
        startActivity(intent);
    }
}