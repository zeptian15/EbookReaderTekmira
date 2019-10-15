package com.example.ebookreadertekmira;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Sembunyikan Action Bar
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Tentang Aplikasi");
        }
    }
}
