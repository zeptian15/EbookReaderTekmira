package com.example.ebookreadertekmira.PDF;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RetrofitSettings {
    public static String BASEURL = "http://11.0.0.2:8000/pdf/";

    //This method establish the OkHtttpClient timers
    private static OkHttpClient client() {
        //Return the OkHttpClient with the read and connect Timeouts
        return new OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    //This method helps us creating the RetrofitServie
    /*
     * serviceClass = The class that provides the endpoints that the service will have
     * bseUrl = The url that will be called to request the endpoints
     * */
    public static <T> T createRetrofitService(final Class<T> serviceClass, final String baseUrl) {
        //Generate retrofit Settings the baseUrl, client (OkHttp) and converterFactory (Gson)
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client())
                .build();

        //Return the retrofit service generate from retrofit settings
        return retrofit.create(serviceClass);
    }
}
