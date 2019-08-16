package com.example.qlks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.HoaDon;
import com.example.qlks.model.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachhangDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public static final String SQL_Khach_Hang  = "CREATE TABLE [KHACHHANG] " +
            "([MaKH] TEXT  NOT NULL PRIMARY KEY," +
            "[TenKH] TEXT DEFAULT 'Tran Van B' NULL," +
            "[DiaChi] TEXT  NULL," +
            "[GioiTinh] TEXT DEFAULT 'Nam' NULL," +
            "[CMND] TEXT  NULL," +
            "[SDT] INTEGER DEFAULT '0123456789' NULL," +
            " [QuocTich] TEXT DEFAULT 'Viet Nam' NULL)";
    public static final String TABLE_Khach_Hang ="KHACHHANG";
    public KhachhangDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertKhachHang(KhachHang khachHang){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaKH",khachHang.getMaKH());
        contentValues.put("TenKH",khachHang.getTenKH());
        contentValues.put("DiaChi",khachHang.getDiaChi());
        contentValues.put("GioiTinh",khachHang.getGioiTinh());
        contentValues.put("CMND",khachHang.getCMND());
        contentValues.put("SDT",khachHang.getSDT());
        contentValues.put("QuocTich",khachHang.getQuocTich());
        try{
            if (db.insert(TABLE_Khach_Hang,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }
    public List<KhachHang> getAllKhachHang(){
        List<KhachHang> khachHangArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Khach_Hang,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            KhachHang khachHang = new KhachHang();
            khachHang.setMaKH(cursor.getString(0));
            khachHang.setTenKH(cursor.getString(1));
            khachHang.setDiaChi(cursor.getString(2));
            khachHang.setGioiTinh(cursor.getString(3));
            khachHang.setCMND(cursor.getString(4));
            khachHang.setSDT(cursor.getString(5));
            khachHang.setQuocTich(cursor.getString(6));
            khachHangArrayList.add(khachHang);
            cursor.moveToNext();
        }
        cursor.close();
        return khachHangArrayList;
    }

    public List<String> getMaKH(){
        List<String> khachHangArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Khach_Hang,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){

            khachHangArrayList.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return khachHangArrayList;
    }

    public void deleteNhanVien(String id){
        db.delete(TABLE_Khach_Hang,"MaKH=?",new String[]{id});
    }


    public int UpdateKhachHang(KhachHang khachHang){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaKH",khachHang.getMaKH());
        contentValues.put("TenKH",khachHang.getTenKH());
        contentValues.put("DiaChi",khachHang.getDiaChi());
        contentValues.put("GioiTinh",khachHang.getGioiTinh());
        contentValues.put("CMND",khachHang.getCMND());
        contentValues.put("SDT",khachHang.getSDT());
        contentValues.put("QuocTich",khachHang.getQuocTich());
        try{
            if (db.update(TABLE_Khach_Hang,contentValues,"MaKH=?",new String[]{khachHang.getMaKH()})<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }
}
