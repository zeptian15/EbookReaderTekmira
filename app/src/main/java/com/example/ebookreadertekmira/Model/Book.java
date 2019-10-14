package com.example.ebookreadertekmira.Model;

import com.google.gson.annotations.SerializedName;

public class Book {
    private int id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("file")
    private String file;
    @SerializedName("deskripsi")
    private String deskripsi;
    @SerializedName("gambar")
    private String gambar;

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getFile() {
        return file;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
