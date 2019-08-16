package com.example.qlks.khongdung;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.KhachHang;
import com.example.qlks.model.KieuPhong;

import java.util.ArrayList;
import java.util.List;

public class KieuphongDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public static final String SQL_Kieu_Phong  = "CREATE TABLE [KieuPhong] ([MaKP] TEXT  NOT NULL PRIMARY KEY,[TenKP] TEXT  NULL)";
    public static final String TABLE_Kieu_Phong ="KieuPhong";
    KieuphongDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertKieuPhong(KieuPhong kieuPhong){
        ContentValues contentValues = new ContentValues();
        contentValues.put("KieuPhong",kieuPhong.getMaKP());
        contentValues.put("TenKP",kieuPhong.getTenKP());
        try{
            if (db.insert(TABLE_Kieu_Phong,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }
    public List<KieuPhong> getAllKieuPhong(){
        List<KieuPhong> kieuPhongArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Kieu_Phong,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            KieuPhong kieuPhong = new KieuPhong();
            kieuPhong.setMaKP(cursor.getString(0));
            kieuPhong.setTenKP(cursor.getString(1));
            kieuPhongArrayList.add(kieuPhong);
            cursor.moveToNext();
        }
        cursor.close();
        return kieuPhongArrayList;
    }

}
