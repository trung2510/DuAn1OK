package com.example.qlks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.PhieuThanhToan;
import com.example.qlks.model.Phong;

import java.util.ArrayList;
import java.util.List;

public class PhongDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public static final String SQL_Phong = "CREATE TABLE [Phong] (\n" +
            "[MaPhong] TEXT DEFAULT '1' NOT NULL PRIMARY KEY,\n" +
            "[TenPhong] TEXT  NULL,\n" +
            "[TinhTrang] TEXT  NULL\n" +
            ")";
    public static final String TABLE_Phong ="Phong";
    public PhongDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertPhong(Phong phong){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaPhong",phong.getMaPhong());
        contentValues.put("TenPhong",phong.getTenPhong());
        contentValues.put("TinhTrang",phong.getTinhTrang());

        try{
            if (db.insert(TABLE_Phong,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }

    public void deleteNhanVien(String id){
        db.delete(TABLE_Phong,"MaPhong=?",new String[]{id});
    }



    public List<String> getMaP(){
        List<String> khachHangArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Phong,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){

            khachHangArrayList.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return khachHangArrayList;
    }


    public List<Phong> getAllPhong(){
        List<Phong> phongArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Phong,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            Phong phong = new Phong();
            phong.setMaPhong(cursor.getString(0));
            phong.setTenPhong(cursor.getString(1));
            phong.setTinhTrang(cursor.getString(2));
            phongArrayList.add(phong);
            cursor.moveToNext();
        }
        cursor.close();
        return phongArrayList;
    }

    public int UpdatePhong(Phong phong){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaPhong",phong.getMaPhong());
        contentValues.put("TenPhong",phong.getTenPhong());
        contentValues.put("TinhTrang",phong.getTinhTrang());

        try{
            if (db.update(TABLE_Phong,contentValues,"MaPhong=?",new String[]{phong.getMaPhong()})<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }
}
