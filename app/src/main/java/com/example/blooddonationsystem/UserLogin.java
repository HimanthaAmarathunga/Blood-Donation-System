package com.example.blooddonationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {
    EditText Username, Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        Username= findViewById(R.id.UL_ET_username);
        Password= findViewById(R.id.UL_ET_password);

        Login= findViewById(R.id.UL_B_login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (TextUtils.isEmpty(Username.getText().toString())) {
                        Toast.makeText(UserLogin.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    }else if (TextUtils.isEmpty(Password.getText().toString())) {
                        Toast.makeText(UserLogin.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
                    }
                }catch (NullPointerException e) {
                    e.printStackTrace();
                }

                loadHomePage();   //Loads the homepage when successfully logged in
            }
        });
    }

    private void loadHomePage() {
//        Intent intent = new Intent(this, Homepage.class);
//        startActivity(intent);
    }
}