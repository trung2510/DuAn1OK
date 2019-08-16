package com.example.qlks.model;

public class Phong {
    String MaPhong;
    String TenPhong;
    String TinhTrang;

    public Phong(String maPhong, String tenPhong, String tinhTrang) {
        MaPhong = maPhong;
        TenPhong = tenPhong;
        TinhTrang = tinhTrang;
    }

    public Phong() {

    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String maPhong) {
        MaPhong = maPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String tenPhong) {
        TenPhong = tenPhong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }
}
