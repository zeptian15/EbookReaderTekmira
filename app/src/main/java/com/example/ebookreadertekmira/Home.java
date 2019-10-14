package com.example.ebookreadertekmira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView imageView = (ImageView) findViewById(R.id.pgtrnn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent il = new Intent(getApplicationContext(), Settings.class);
                startActivity(il);


                TextView textView = (TextView) findViewById(R.id.pgtrn);

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent il = new Intent(getApplicationContext(), Settings.class);
                        startActivity(il);
                    }
                });
            }
        });
    }
}