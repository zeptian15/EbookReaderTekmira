package com.example.ebookreadertekmira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Sembunyikan Action Bar
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        new Handler().postDelayed(new Runnable(){
            @Override
                    public void run(){
                        Intent homeIntent = new Intent(Splash.this, Home.class);
                        startActivity(homeIntent);
                        finish();
            }
        },SPLASH_TIME_OUT);
    }
}
