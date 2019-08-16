package com.example.qlks.model;

public class LoaiPhong {
    String MaLP;
    String TenLP;
    String TrangBi;

    public LoaiPhong(String maLP, String tenLP, String trangBi) {
        MaLP = maLP;
        TenLP = tenLP;
        TrangBi = trangBi;
    }

    public LoaiPhong() {

    }

    public String getMaLP() {
        return MaLP;
    }

    public void setMaLP(String maLP) {
        MaLP = maLP;
    }

    public String getTenLP() {
        return TenLP;
    }

    public void setTenLP(String tenLP) {
        TenLP = tenLP;
    }

    public String getTrangBi() {
        return TrangBi;
    }

    public void setTrangBi(String trangBi) {
        TrangBi = trangBi;
    }
}
