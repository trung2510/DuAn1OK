package com.example.qlks.model;

import java.util.Date;

public class PhieuDangKi {
    String MaPDK;
    String MaKH;
    String MaNV;
    Date NgayDen;
    int SoNgayThue;
    Double GiaPhong;
    Double GiaDV;
    Double TongTien;

    public PhieuDangKi(String maPDK, String maKH, String maNV, Date ngayDen, int soNgayThue, Double giaPhong, Double giaDV, Double tongTien) {
        MaPDK = maPDK;
        MaKH = maKH;
        MaNV = maNV;
        NgayDen = ngayDen;
        SoNgayThue = soNgayThue;
        GiaPhong = giaPhong;
        GiaDV = giaDV;
        TongTien = tongTien;
    }

    public PhieuDangKi() {

    }

    public String getMaPDK() {
        return MaPDK;
    }

    public void setMaPDK(String maPDK) {
        MaPDK = maPDK;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public Date getNgayDen() {
        return NgayDen;
    }

    public void setNgayDen(Date ngayDen) {
        NgayDen = ngayDen;
    }

    public int getSoNgayThue() {
        return SoNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        SoNgayThue = soNgayThue;
    }

    public Double getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(Double giaPhong) {
        GiaPhong = giaPhong;
    }

    public Double getGiaDV() {
        return GiaDV;
    }

    public void setGiaDV(Double giaDV) {
        GiaDV = giaDV;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double tongTien) {
        TongTien = tongTien;
    }
}
