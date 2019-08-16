package com.example.qlks.model;

public class KieuPhong {
    String MaKP;
    String TenKP;

    public KieuPhong(String maKP, String tenKP) {
        MaKP = maKP;
        TenKP = tenKP;
    }

    public KieuPhong() {

    }

    public String getMaKP() {
        return MaKP;
    }

    public void setMaKP(String maKP) {
        MaKP = maKP;
    }

    public String getTenKP() {
        return TenKP;
    }

    public void setTenKP(String tenKP) {
        TenKP = tenKP;
    }
}
