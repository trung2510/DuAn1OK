package com.example.qlks.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.qlks.khongdung.ChucvuDAO;
import com.example.qlks.dao.DichvuDAO;
import com.example.qlks.dao.HoadonDAO;
import com.example.qlks.dao.KhachhangDAO;
import com.example.qlks.khongdung.KieuphongDAO;
import com.example.qlks.khongdung.LoaiphongDAO;
import com.example.qlks.dao.NhanvienDAO;
import com.example.qlks.dao.PhieudangkiDAO;
import com.example.qlks.dao.PhongDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Khachsan", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ChucvuDAO.SQL_Chuc_Vu);
        db.execSQL(DichvuDAO.SQL_Dich_Vu);
        db.execSQL(HoadonDAO.SQL_Hoa_Don);
        db.execSQL(KhachhangDAO.SQL_Khach_Hang);
        db.execSQL(KieuphongDAO.SQL_Kieu_Phong);
        db.execSQL(LoaiphongDAO.SQL_Loai_Phong);
        db.execSQL(NhanvienDAO.SQL_Nhan_Vien);
        db.execSQL(PhieudangkiDAO.SQL_Phieu_Dang_Ki);
        db.execSQL(PhongDAO.SQL_Phong);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ChucvuDAO.TABLE_Chuc_Vu);
        db.execSQL("drop table if exists "+DichvuDAO.TABLE_Dich_Vu);
        db.execSQL("drop table if exists "+HoadonDAO.TABLE_Hoa_Don);
        db.execSQL("drop table if exists "+KhachhangDAO.TABLE_Khach_Hang);
        db.execSQL("drop table if exists "+KieuphongDAO.TABLE_Kieu_Phong);
        db.execSQL("drop table if exists "+LoaiphongDAO.TABLE_Loai_Phong);
        db.execSQL("drop table if exists "+NhanvienDAO.TABLE_Nhan_Vien);
        db.execSQL("drop table if exists "+PhieudangkiDAO.TABLE_Phieu_Dang_ki);
        db.execSQL("drop table if exists "+PhongDAO.TABLE_Phong);

    }
}
