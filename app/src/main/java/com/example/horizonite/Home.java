package com.example.horizonite;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView t1,t2,t3,t4,t5,t6;
    ImageView i1,i2,i3,i4,i5,i6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

//        Toolbar
        setSupportActionBar(toolbar);

        Menu menu = navigationView.getMenu();

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        t1=(TextView) findViewById(R.id.textView3);
        t2=(TextView) findViewById(R.id.textView8);
        t3=(TextView) findViewById(R.id.textView5);
        t4=(TextView) findViewById(R.id.textView4);
        t5=(TextView) findViewById(R.id.textView17);
        t6=(TextView) findViewById(R.id.textView20);

        i1=(ImageView) findViewById(R.id.imageView2);
        i2=(ImageView) findViewById(R.id.imageView1);
        i3=(ImageView) findViewById(R.id.imageView6);
        i4=(ImageView) findViewById(R.id.imageView9);
        i5=(ImageView) findViewById(R.id.imageView18);
        i6=(ImageView) findViewById(R.id.imageView19);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in1= new Intent(Home.this,TimeTable.class);
                startActivity(in1);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2=new Intent(Home.this,Exam.class);
                startActivity(in2);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in3= new Intent(Home.this,Teacher.class);
                startActivity(in3);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in4= new Intent(Home.this, Syllabus.class);
                startActivity(in4);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in9= new Intent(Home.this,Payment.class);
                startActivity(in9);
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in9= new Intent(Home.this,Campus.class);
                startActivity(in9);
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in5= new Intent(Home.this,TimeTable.class);
                startActivity(in5);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in6=new Intent(Home.this,Exam.class);
                startActivity(in6);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in7= new Intent(Home.this,Teacher.class);
                startActivity(in7);
            }
        });
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in8= new Intent(Home.this, Syllabus.class);
                startActivity(in8);
            }
        });
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in10= new Intent(Home.this, Payment.class);
                startActivity(in10);
            }
        });
        i6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in10= new Intent(Home.this, Campus.class);
                        startActivity(in10);
                    }
                });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_campus:
                Intent intent1= new Intent(this,Campus.class);
                startActivity(intent1);
                break;
            case R.id.nav_home:
                Intent intent2 = new Intent(this,Home.class);
                startActivity(intent2);
                break;
            case R.id.nav_exam:
                Intent intent3 = new Intent(this,Exam.class);
                startActivity(intent3);
                break;
            case R.id.nav_teacher:
                Intent intent4 = new Intent(this,Teacher.class);
                startActivity(intent4);
                break;
            case R.id.nav_attendance:
                Intent intent5 = new Intent(this, Syllabus.class);
                startActivity(intent5);
                break;
            case R.id.nav_timetable:
                Intent intent8 = new Intent(this,TimeTable.class);
                startActivity(intent8);
                break;
            case R.id.nav_logout:
                Intent intent7 = new Intent(this,MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.nav_share:
                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT,"Horizonite App");
                    String shareMessage = "https://play.google.com/store/apps/details?="+BuildConfig.APPLICATION_ID+"\n\n";
                    intent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                    startActivity(Intent.createChooser(intent,"share by"));
                }catch (Exception e){
                    Toast.makeText(this, "Sharing in progress", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_rate:
                Toast.makeText(this, "Rating in progress", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}