package com.example.qlks.model;

public class KhachHang {
    String MaKH;
    String TenKH;
    String DiaChi;
    String GioiTinh;
    String CMND;
    String SDT;
    String QuocTich;

    public KhachHang(String maKH, String tenKH, String diaChi, String gioiTinh, String CMND, String SDT, String quocTich) {
        MaKH = maKH;
        TenKH = tenKH;
        DiaChi = diaChi;
        GioiTinh = gioiTinh;
        this.CMND = CMND;
        this.SDT = SDT;
        QuocTich = quocTich;
    }

    public KhachHang() {

    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getQuocTich() {
        return QuocTich;
    }

    public void setQuocTich(String quocTich) {
        QuocTich = quocTich;
    }
}
