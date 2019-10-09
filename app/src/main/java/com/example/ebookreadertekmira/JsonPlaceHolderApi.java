package com.example.ebookreadertekmira;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    // Ambil List Buku pada API
    @GET("book")
    Call<List<Book>> getBooks();
}
