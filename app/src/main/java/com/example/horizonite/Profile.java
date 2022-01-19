package com.example.horizonite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Profile extends AppCompatActivity {

    TextInputLayout fullName,email,phoneNo,userName;
    TextView fname,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fname = findViewById(R.id.full_name_profile);
        username = findViewById(R.id.username_profile);
        email = findViewById(R.id.email);
        phoneNo = findViewById(R.id.phno);
        userName = findViewById(R.id.username);
        fullName = findViewById(R.id.name);

        showAllUserData();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Profile.this,Home.class);
                startActivity(intent1);
            }
        });
    }

    private void showAllUserData() {
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_name = intent.getStringExtra("fullname");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phonenumber");

        fname.setText(user_name);
        username.setText(user_username);
        fullName.getEditText().setText(user_name);
        userName.getEditText().setText(user_username);
        email.getEditText().setText(user_email);
        phoneNo.getEditText().setText(user_phoneNo);
    }
}