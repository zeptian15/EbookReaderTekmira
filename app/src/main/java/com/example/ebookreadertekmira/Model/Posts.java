package com.example.ebookreadertekmira.Model;

import com.google.gson.annotations.SerializedName;

public class Posts {
    // Inisialisasi Variabel
    private int userId;
    private int id;
    private String title;
    @SerializedName("body")
    private String text;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
