package com.example.ebookreadertekmira;

import com.google.gson.annotations.SerializedName;

public class Book {
    private int id;
    @SerializedName("judul_buku")
    private String judulBuku;
    @SerializedName("link_buku")
    private String linkBuku;

    public int getId() {
        return id;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public String getLinkBuku() {
        return linkBuku;
    }
}
