package com.example.qlks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.LoaiPhong;
import com.example.qlks.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanvienDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public static final String SQL_Nhan_Vien  = "CREATE TABLE [NhanVien] " +
            " ([MaNV] TEXT  NOT NULL PRIMARY KEY," +
            " [TenNV] TEXT DEFAULT '''Tran Van A''' NULL," +
            " [MaCV] TEXT  NULL, " +
            " [GioiTinh] TEXT DEFAULT '''Nam''' NULL, " +
            " [NgaySinh] TEXT DEFAULT '''25/10/1999''' NULL," +
            " [DiaChi] TEXT DEFAULT '''Xa Lam''' NULL)";
    public static final String TABLE_Nhan_Vien ="NhanVien";


    public NhanvienDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }


    public int InsertNhanVien(NhanVien nhanVien){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaNV",nhanVien.getMaNV());
        contentValues.put("TenNV",nhanVien.getTenNV());
        contentValues.put("MaCV",nhanVien.getMaCV());
        contentValues.put("GioiTinh",nhanVien.getGioiTinh());
        contentValues.put("NgaySinh",nhanVien.getNgaySinh());
        contentValues.put("DiaChi",nhanVien.getDiaChi());
        try{
            if (db.insert(TABLE_Nhan_Vien,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }

    public List<NhanVien> getAllNhanVien(){
        List<NhanVien> nhanVienArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Nhan_Vien,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNV(cursor.getString(0));
            nhanVien.setTenNV(cursor.getString(1));
            nhanVien.setMaCV(cursor.getString(2));
            nhanVien.setGioiTinh(cursor.getString(3));
            nhanVien.setNgaySinh(cursor.getString(4));
            nhanVien.setDiaChi(cursor.getString(5));
            nhanVienArrayList.add(nhanVien);
            cursor.moveToNext();
        }
        return nhanVienArrayList;
    }
    public List<String> getMaNV(){
        List<String> khachHangArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Nhan_Vien,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){

            khachHangArrayList.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return khachHangArrayList;
    }


    public void deleteNhanVien(String id){
        db.delete(TABLE_Nhan_Vien,"MaNV=?",new String[]{id});
    }
    public int UpdateNhanVien(NhanVien nhanVien){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaNV",nhanVien.getMaNV());
        contentValues.put("TenNV",nhanVien.getTenNV());
        contentValues.put("MaCV",nhanVien.getMaCV());
        contentValues.put("GioiTinh",nhanVien.getGioiTinh());
        contentValues.put("NgaySinh",nhanVien.getNgaySinh());
        contentValues.put("DiaChi",nhanVien.getDiaChi());
        try{
            if (db.update(TABLE_Nhan_Vien,contentValues,"MaNV=?",new String[]{nhanVien.getMaNV()})<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }


    public int checkLogin(String MaNV,String TenNV){
        Cursor cursor = db.query(TABLE_Nhan_Vien,null,"MaNV=? and TenNV=?",new String[]{MaNV,TenNV},null,null,null);
        int i = cursor.getCount();
        if (i == 1) {
            return 1;//login thành công
        }
        return -1;//login không thành công

    }

}
