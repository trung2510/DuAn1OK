package com.example.qlks.khongdung;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.ChucVu;

import java.util.ArrayList;
import java.util.List;

public class ChucvuDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    public static final String SQL_Chuc_Vu  = "CREATE TABLE [ChucVu] ([MaCV] TEXT  NOT NULL PRIMARY KEY,[TenCV] TEXT  NULL)";
    public static final String TABLE_Chuc_Vu ="ChucVu";
    ChucvuDAO(Context context){
        dbHelper = new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertChucVu(ChucVu chucVu){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaCV",chucVu.getMaCV());
        contentValues.put("TenCV",chucVu.getTenCV());
        try{
            if (db.insert(TABLE_Chuc_Vu,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception ex){
            Log.e("Loi",ex.getMessage());
        }
        return 1;
    };
    public List<ChucVu> getAllChucVu(){
        List<ChucVu> chucVuArrayList = new ArrayList<>();
        Cursor cursor = db.query(TABLE_Chuc_Vu,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            ChucVu chucVu = new ChucVu();
            chucVu.setMaCV(cursor.getString(0));
            chucVu.setTenCV(cursor.getString(1));
            chucVuArrayList.add(chucVu);
            cursor.moveToNext();
        }
        cursor.close();
        return chucVuArrayList;
    }
}
