package com.example.horizonite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity3 extends AppCompatActivity {

    Button button1,button2;
    TextInputLayout username,password,fname,email,phonenumber;
    FirebaseDatabase rootnode;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        username =findViewById(R.id.username);
        fname=findViewById(R.id.name);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        phonenumber=findViewById(R.id.phno);

        button1=(Button) findViewById(R.id.login_btn);
        button2=(Button) findViewById(R.id.signin);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Activity3.this,Activity2.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signinUser();
            }
        });
    }

    private void signinUser() {
        if(!validateUsername() | !validatePassword()){
            return;
        }
        else{
            isUser();
        }
    }

    private void isUser() {
        rootnode=FirebaseDatabase.getInstance();
        ref=rootnode.getReference("users");

        String name=fname.getEditText().getText().toString();
        String uname=username.getEditText().getText().toString();
        String mail=email.getEditText().getText().toString();
        String phnumber=phonenumber.getEditText().getText().toString();
        String pas=password.getEditText().getText().toString();

        HelperClass hc=new HelperClass(name,uname,phnumber,pas,mail);
        ref.child(uname).setValue(hc);

        Intent intent1 = new Intent(Activity3.this,Home.class);
        startActivity(intent1);
    }

    private Boolean validateUsername(){
        String val = username.getEditText().getText().toString();
        String noSpace = "\\A\\w{3,20}\\z";
        if(val.isEmpty()){
            username.setError("Field can't be empty");
            return false;
        }
        else if(val.length()>=15){
            username.setError("Username too lengthy");
            return false;
        }
        else if(val.length()<4){
            username.setError("Length too short");
            return false;
        }
        else if(!val.matches(noSpace)){
            username.setError("White spaces are not allowed");
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
}