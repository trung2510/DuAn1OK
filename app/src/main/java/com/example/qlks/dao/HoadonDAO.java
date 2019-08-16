package com.example.qlks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class HoadonDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    public static final String SQL_Hoa_Don  = "CREATE TABLE [HoaDon] (\n" +
            "[MaHD] TEXT  NOT NULL PRIMARY KEY,\n" +
            "[MaPTT] TEXT  NULL,\n" +
            "[SoTien] DOUBLE DEFAULT '10000' NULL,\n" +
            "[TongTien] DOUBLE DEFAULT '10000' NULL\n" +
            ")";
    public static final String TABLE_Hoa_Don ="HoaDon";
    public HoadonDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertHoaDon(HoaDon hoaDon){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHD",hoaDon.getMaHD());
        contentValues.put("MaPTT",hoaDon.getMaPTT());
        contentValues.put("SoTien",hoaDon.getSoTien());
        contentValues.put("TongTien",hoaDon.getTongTien());
        try{
            if (db.insert(TABLE_Hoa_Don,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }
    public List<HoaDon> getAllHoaDon(){
        List<HoaDon> hoaDonArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Hoa_Don,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            HoaDon hoaDon = new HoaDon();
            hoaDon.setMaHD(cursor.getString(0));
            hoaDon.setMaPTT(cursor.getString(1));
            hoaDon.setSoTien(cursor.getDouble(2));
            hoaDon.setTongTien(cursor.getDouble(3));
            hoaDonArrayList.add(hoaDon);
            cursor.moveToNext();
        }
        cursor.close();
        return hoaDonArrayList;
    }

    public void deleteHoaDon(String id){
        db.delete(TABLE_Hoa_Don,"MaHd=?",new String[]{id});
    }


    public int UpdateHoaDon(HoaDon hoaDon){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaHD",hoaDon.getMaHD());
        contentValues.put("MaPTT",hoaDon.getMaPTT());
        contentValues.put("SoTien",hoaDon.getSoTien());
        contentValues.put("TongTien",hoaDon.getTongTien());
        try{
            if (db.update(TABLE_Hoa_Don,contentValues,"MaHd=?",new String[]{hoaDon.getMaHD()})<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }
}
