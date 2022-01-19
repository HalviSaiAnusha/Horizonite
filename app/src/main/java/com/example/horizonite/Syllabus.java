package com.example.horizonite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class Syllabus extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        PDFView pdfView = findViewById(R.id.pdfview);
        pdfView.fromAsset("Syllabus.pdf").load();

    }
}