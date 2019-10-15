package com.example.ebookreadertekmira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class SeeBook extends AppCompatActivity {

    private TextView tvJudul,tvDeskripsi;
    private ImageView imgPhoto;
    private Button btnBacaBuku;
    private String Judul,File,Deskripsi,Gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_book);

        // Ambil data yang dikirim
        final Bundle buku = getIntent().getExtras();
        Judul = buku.getString("Judul");
        File = buku.getString("File");
        Deskripsi = buku.getString("Deskripsi");
        Gambar = buku.getString("Gambar");

        tvJudul = findViewById(R.id.tv_judul_buku);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);
        imgPhoto = findViewById(R.id.img_foto);
        btnBacaBuku = findViewById(R.id.btn_baca);

        // Set Value yang didapat dari Intent
        tvJudul.setText(Judul);
        tvDeskripsi.setText(Deskripsi);

        Glide.with(this)
                .load("http://10.0.9.194:8000/images/" + Gambar)
                .apply(new RequestOptions().override(350,550))
                .into(imgPhoto);

        btnBacaBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BacaBuku = new Intent(SeeBook.this, DetailBooks.class);
                BacaBuku.putExtra("File", File);
                BacaBuku.putExtra("Judul", Judul);
                startActivity(BacaBuku);
            }
        });
    }
}
