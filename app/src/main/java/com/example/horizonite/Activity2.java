package com.example.horizonite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Activity2 extends AppCompatActivity {

    Button button1;
    Button button2;
    TextInputLayout username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_2);


        username =findViewById(R.id.username);
        password=findViewById(R.id.password);

        button1=(Button) findViewById(R.id.signup_btn);
        button2=(Button) findViewById(R.id.login);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Activity2.this,Activity3.class);
                startActivity(intent1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUser();
            }
        });
    }

    private Boolean validateUsername(){
        String val = username.getEditText().getText().toString();
//        String noSpace = "\\A\\w{4,20}\\z";
        if(val.isEmpty()){
            username.setError("Field can't be empty");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword(){
        String val = password.getEditText().getText().toString();

        if(val.isEmpty()){
            password.setError("Field can't be empty");
            return false;
        }
        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }

    private void loginUser(){
        if(!validateUsername() | !validatePassword()){
            return;
        }
        else{
            isUser();
        }
    }

    private void isUser() {

        final String userEnteredUname=username.getEditText().getText().toString().trim();
        final String userEnteredPass=password.getEditText().getText().toString().trim();

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUname);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    username.setError(null);
                    username.setErrorEnabled(false);

                    String DBPass = snapshot.child(userEnteredUname).child("password").getValue(String.class);
                    if(DBPass.equals(userEnteredPass)){

                        username.setError(null);
                        username.setErrorEnabled(false);

                        String DBuname = snapshot.child(userEnteredUname).child("username").getValue(String.class);
                        String DBfname = snapshot.child(userEnteredUname).child("fullname").getValue(String.class);
//                        String DBPass = snapshot.child(userEnteredUname).child("password").getValue(String.class);
                        String DBemail = snapshot.child(userEnteredUname).child("email").getValue(String.class);
                        String DBPhno = snapshot.child(userEnteredUname).child("phonenumber").getValue(String.class);

                        Intent intent = new Intent(Activity2.this,Profile.class);


                        intent.putExtra("name",DBfname);
                        intent.putExtra("username",DBuname);
                        intent.putExtra("email",DBemail);
                        intent.putExtra("phonenumber",DBPhno);
//                        intent.putExtra("password",DBPass);
                        startActivity(intent);
                    } else{
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                } else{
                    username.setError("No such user Exists ");
                    username.requestFocus();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}