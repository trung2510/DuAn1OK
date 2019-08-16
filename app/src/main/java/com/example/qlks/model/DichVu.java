package com.example.qlks.model;

public class DichVu {
    String MaDV;
    String TenDV;
    String GiaDV;

    public DichVu(String maDV, String tenDV, String giaDV) {
        MaDV = maDV;
        TenDV = tenDV;
        GiaDV = giaDV;
    }

    public DichVu() {

    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String maDV) {
        MaDV = maDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String tenDV) {
        TenDV = tenDV;
    }

    public String getGiaDV() {
        return GiaDV;
    }

    public void setGiaDV(String giaDV) {
        GiaDV = giaDV;
    }
}
