package com.example.ebookreadertekmira.Services;

// Untuk mendapatkan Respon dari API menggunakan Retrofit
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Url;

public interface PDFServices {
    @GET
    Call<ResponseBody> downloadPDF(@Url String fileUrl);
}
