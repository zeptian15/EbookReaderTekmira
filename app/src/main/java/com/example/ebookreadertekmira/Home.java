package com.example.ebookreadertekmira;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textViewResult = findViewById(R.id.tv_result);

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
                    textViewResult.setText("Code : " + response.code());
                    return;
                }

                List<Book> books = response.body();

                for(Book book : books){
                    String content = "";
                    content += "ID : " + book.getId() + "\n";
                    content += "Judul Buku : " + book.getJudulBuku() + "\n";
                    content += "Link Buku : " + book.getLinkBuku() + "\n";

                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}
