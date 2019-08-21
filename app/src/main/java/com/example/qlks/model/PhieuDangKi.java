package com.example.qlks.model;

import java.util.Date;

public class PhieuDangKi {
    String MaPDK;
    int MaKH;
    String TenKH;
    int MaNV;
    String TenNV;
    Date NgayDen;
    int SoNgayThue;
    int idPhong;
    String tenPhong;
    Double GiaPhong;
    int idDV;
    String tenDV;
    Double GiaDV;
    Double TongTien;

    public PhieuDangKi() { }

    public String getMaPDK() {
        return MaPDK;
    }

    public void setMaPDK(String maPDK) {
        MaPDK = maPDK;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
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

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Double getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(Double giaPhong) {
        GiaPhong = giaPhong;
    }

    public int getIdDV() {
        return idDV;
    }

    public void setIdDV(int idDV) {
        this.idDV = idDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
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

    public PhieuDangKi(int maKH, String tenKH, int maNV, String tenNV, Date ngayDen, int soNgayThue, int idPhong, String tenPhong, Double giaPhong, int idDV, String tenDV, Double giaDV, Double tongTien) {
        MaKH = maKH;
        TenKH = tenKH;
        MaNV = maNV;
        TenNV = tenNV;
        NgayDen = ngayDen;
        SoNgayThue = soNgayThue;
        this.idPhong = idPhong;
        this.tenPhong = tenPhong;
        GiaPhong = giaPhong;
        this.idDV = idDV;
        this.tenDV = tenDV;
        GiaDV = giaDV;
        TongTien = tongTien;
    }

    public PhieuDangKi(String maPDK, int maKH, String tenKH, int maNV, String tenNV, Date ngayDen, int soNgayThue, int idPhong, String tenPhong, Double giaPhong, int idDV, String tenDV, Double giaDV, Double tongTien) {
        MaPDK = maPDK;
        MaKH = maKH;
        TenKH = tenKH;
        MaNV = maNV;
        TenNV = tenNV;
        NgayDen = ngayDen;
        SoNgayThue = soNgayThue;
        this.idPhong = idPhong;
        this.tenPhong = tenPhong;
        GiaPhong = giaPhong;
        this.idDV = idDV;
        this.tenDV = tenDV;
        GiaDV = giaDV;
        TongTien = tongTien;
    }
}
