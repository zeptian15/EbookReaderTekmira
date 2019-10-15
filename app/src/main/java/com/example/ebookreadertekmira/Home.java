package com.example.ebookreadertekmira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    private ImageView imgBacaBuku, imgBukuFavorit, imgLaporan, imgSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Sembunyikan Action Bar
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        // Memindahkan ke Halaman Baca Buku
        imgBacaBuku = findViewById(R.id.img_btn_baca_buku);
        imgBacaBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BacaBuku = new Intent(Home.this, ReadBooks.class);
                startActivity(BacaBuku);
            }
        });

        // Masuk ke Halaman Buku Favorit
        imgBukuFavorit = findViewById(R.id.img_btn_buku_favorit);
        imgBukuFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "Fitur akan segera hadir!", Toast.LENGTH_SHORT).show();
            }
        });

        // Masuk ke Halaman Laporan
        imgLaporan = findViewById(R.id.img_btn_cari_laporan);
        imgLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "Fitur akan segera Hadir", Toast.LENGTH_SHORT).show();
            }
        });

        // Masuk ke Halaman Setting
        imgSetting = findViewById(R.id.img_btn_setting);
        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Setting = new Intent(Home.this, About.class);
                startActivity(Setting);
            }
        });


    }
}