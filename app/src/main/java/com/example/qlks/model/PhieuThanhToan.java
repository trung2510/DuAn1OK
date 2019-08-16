package com.example.qlks.model;

public class PhieuThanhToan {
    String MaPTT;
    String MaNV;
    String SoNgay;
    String NgayThanhToan;
    Double TongPhaiTra;
    Double TongTien;

    public PhieuThanhToan(String maPTT, String maNV, String soNgay, String ngayThanhToan, Double tongPhaiTra, Double tongTien) {
        MaPTT = maPTT;
        MaNV = maNV;
        SoNgay = soNgay;
        NgayThanhToan = ngayThanhToan;
        TongPhaiTra = tongPhaiTra;
        TongTien = tongTien;
    }

    public PhieuThanhToan() {

    }

    public String getMaPTT() {
        return MaPTT;
    }

    public void setMaPTT(String maPTT) {
        MaPTT = maPTT;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getSoNgay() {
        return SoNgay;
    }

    public void setSoNgay(String soNgay) {
        SoNgay = soNgay;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        NgayThanhToan = ngayThanhToan;
    }

    public Double getTongPhaiTra() {
        return TongPhaiTra;
    }

    public void setTongPhaiTra(Double tongPhaiTra) {
        TongPhaiTra = tongPhaiTra;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double tongTien) {
        TongTien = tongTien;
    }
}
