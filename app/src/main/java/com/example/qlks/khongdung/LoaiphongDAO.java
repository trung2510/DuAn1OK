package com.example.qlks.khongdung;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.KieuPhong;
import com.example.qlks.model.LoaiPhong;

import java.util.ArrayList;
import java.util.List;

public class LoaiphongDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public static final String SQL_Loai_Phong  = "CREATE TABLE [LoaiPhong] ([MaLP] TEXT  NOT NULL PRIMARY KEY,[TenLP] TEXT  NULL,[TrangBi] TEXT  NULL)";
    public static final String TABLE_Loai_Phong ="LoaiPhong";
    LoaiphongDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertLoaiPhong(LoaiPhong loaiPhong){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaLP",loaiPhong.getMaLP());
        contentValues.put("TenLP",loaiPhong.getTenLP());
        contentValues.put("TrangBi",loaiPhong.getTrangBi());
        try{
            if (db.insert(TABLE_Loai_Phong,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }
    public List<LoaiPhong> getAllLoaiPhong(){
        List<LoaiPhong> loaiPhongArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Loai_Phong,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            LoaiPhong loaiPhong = new LoaiPhong();
            loaiPhong.setMaLP(cursor.getString(0));
            loaiPhong.setTenLP(cursor.getString(1));
            loaiPhong.setTrangBi(cursor.getString(2));
            loaiPhongArrayList.add(loaiPhong);
            cursor.moveToNext();
        }
        cursor.close();
        return loaiPhongArrayList;
    }
}
