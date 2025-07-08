package com.example.myapplicationzaki.model;

public class Mahasiswa {
    private String nama;
    private String stb;

    public Mahasiswa(String nama, String stb) {
        this.nama = nama;
        this.stb = stb;
    }

    public Mahasiswa() {

    }

    public String getStb() {
        return stb;
    }

    public void setStb(String stb) {
        this.stb = stb;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
