package com.example.ebookreadertekmira.Services;

import com.example.ebookreadertekmira.Model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    // Ambil List Buku pada API
    @GET("book")
    Call<List<Book>> getBooks();
    // Update Apakah masuk Favorite atau Tidak
}
