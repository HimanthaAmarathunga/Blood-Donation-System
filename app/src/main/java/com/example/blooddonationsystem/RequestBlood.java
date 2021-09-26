package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RequestBlood extends AppCompatActivity {
Button Login, Donate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);

        Login = findViewById(R.id.RB_Login_Btn);
        Donate = findViewById(R.id.RB_Donate_Btn);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestBlood.this, UserLogin.class);
                startActivity(intent);
            }
        });

        Donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RequestBlood.this,DonorProfile.class); //Must view donor list
                startActivity(intent);
            }
        });
    }
}