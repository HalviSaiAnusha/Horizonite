package com.example.horizonite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ObjectInputStream;

public class MainActivity extends AppCompatActivity {

    public static ObjectInputStream.GetField list;
    private static int SPLASH_TIME_OUT = 3000;

    //Calls
    View f,s,t,fo,fi,si;
    TextView name,tagline;

    //Anime Variables
    Animation top, bottom, middle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        middle= AnimationUtils.loadAnimation(this,R.anim.middle_animation);
        bottom= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Connect
        f=findViewById(R.id.first);
        s=findViewById(R.id.second);
        t=findViewById(R.id.third);
        fo=findViewById(R.id.fourth);
        fi=findViewById(R.id.fifth);
        si=findViewById(R.id.sixth);

        name=findViewById(R.id.name);
        tagline=findViewById(R.id.tagline);

        f.setAnimation(top);
        s.setAnimation(top);
        t.setAnimation(top);
        fo.setAnimation(top);
        fi.setAnimation(top);
        si.setAnimation(top);

        name.setAnimation(middle);
        tagline.setAnimation(bottom);

        //function for redirect
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}