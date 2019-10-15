package com.example.ebookreadertekmira;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ebookreadertekmira.Adapter.RecyclerBooksAdapter;
import com.example.ebookreadertekmira.Model.Book;
import com.example.ebookreadertekmira.Services.JsonPlaceHolderApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReadBooks extends AppCompatActivity {
    private RecyclerView rvBooks;

    private ArrayList<Book> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reads_books);

        // Sembunyikan Action Bar
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        rvBooks = findViewById(R.id.rv_books);
        rvBooks.setHasFixedSize(true);

        // Mencoba Progress Dialog
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.9.194:8000/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Book>> call = jsonPlaceHolderApi.getBooks();

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(ReadBooks.this, "Code : " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                // Jika Berhasil di Load
                progressDialog.dismiss();

                List<Book> books = response.body();

                for(Book book : books){
                    Book buku = new Book();
                    buku.setId(book.getId());
                    buku.setJudul(book.getJudul());
                    buku.setFile(book.getFile());
                    buku.setDeskripsi(book.getDeskripsi());

                    list.add(book);
                }
                // Tampilkan data
                showRecyclerCardView();
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Toast.makeText(ReadBooks.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showRecyclerCardView(){
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        RecyclerBooksAdapter recyclerBooksAdapter = new RecyclerBooksAdapter(list);
        rvBooks.setAdapter(recyclerBooksAdapter);
    }

}
