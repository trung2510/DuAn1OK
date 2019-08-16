package com.example.qlks.model;

public class HoaDon {
    String MaHD;
    String MaPTT;
    Double SoTien;
    Double TongTien;

    public HoaDon(String maHD, String maPTT, Double soTien, Double tongTien) {
        MaHD = maHD;
        MaPTT = maPTT;
        SoTien = soTien;
        TongTien = tongTien;
    }

    public HoaDon() {

    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public String getMaPTT() {
        return MaPTT;
    }

    public void setMaPTT(String maPTT) {
        MaPTT = maPTT;
    }

    public Double getSoTien() {
        return SoTien;
    }

    public void setSoTien(Double soTien) {
        SoTien = soTien;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double tongTien) {
        TongTien = tongTien;
    }
}
