package com.example.qlks.model;

public class NhanVien {
    String MaNV;
    String TenNV;
    String MaCV;
    String GioiTinh;
    String NgaySinh;
    String DiaChi;

    public NhanVien(String maNV, String tenNV, String maCV, String gioiTinh, String ngaySinh, String diaChi) {
        MaNV = maNV;
        TenNV = tenNV;
        MaCV = maCV;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
    }

    public NhanVien() {

    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getMaCV() {
        return MaCV;
    }

    public void setMaCV(String maCV) {
        MaCV = maCV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
