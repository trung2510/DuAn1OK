package com.example.qlks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.DichVu;

import java.util.ArrayList;
import java.util.List;

public class DichvuDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    public static final String SQL_Dich_Vu  = "CREATE TABLE [DichVu] ([MaDV] TEXT  PRIMARY KEY NULL,[TenDV] TEXT  NULL,[GiaDV] TEXT  NULL)";
    public static final String TABLE_Dich_Vu ="DichVu";
    public DichvuDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertDichVu(DichVu dichVu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaDV",dichVu.getMaDV());
        contentValues.put("TenDV",dichVu.getTenDV());
        contentValues.put("GiaDV",dichVu.getGiaDV());
        try{
            if (db.insert(TABLE_Dich_Vu,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("Loiii",e.getMessage());
        }
        return 1;
    }

    public List<String> getMaDV(){
        List<String> khachHangArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Dich_Vu,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){

            khachHangArrayList.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return khachHangArrayList;
    }

    public void deleteNhanVien(String id){
        db.delete(TABLE_Dich_Vu,"MaDV=?",new String[]{id});
    }


    public List<DichVu> getAllDichVu(){
        List<DichVu> dichVuArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Dich_Vu,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            DichVu dichVu = new DichVu();
            dichVu.setMaDV(cursor.getString(0));
            dichVu.setTenDV(cursor.getString(1));
            dichVu.setGiaDV(cursor.getString(2));
            dichVuArrayList.add(dichVu);
            cursor.moveToNext();
        }
        cursor.close();
        return dichVuArrayList;
    }


    public int UpdateDichVu(DichVu dichVu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaDV",dichVu.getMaDV());
        contentValues.put("TenDV",dichVu.getTenDV());
        contentValues.put("GiaDV",dichVu.getGiaDV());
        try{
            if (db.update(TABLE_Dich_Vu,contentValues,"MaDv=?",new String[]{dichVu.getMaDV()})<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("Loiii",e.getMessage());
        }
        return 1;
    }
}
