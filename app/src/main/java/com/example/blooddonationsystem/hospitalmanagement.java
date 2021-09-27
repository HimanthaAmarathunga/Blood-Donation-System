package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class hospitalmanagement extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalmanagement);



    }
}