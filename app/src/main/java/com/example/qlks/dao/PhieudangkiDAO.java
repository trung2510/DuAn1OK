package com.example.qlks.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.qlks.database.DatabaseHelper;
import com.example.qlks.model.NhanVien;
import com.example.qlks.model.PhieuDangKi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PhieudangkiDAO {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    SimpleDateFormat sss = new SimpleDateFormat("dd-mm-yyyy");
    Cursor cursor;

    public static final String SQL_Phieu_Dang_Ki  = "CREATE TABLE [PhieuDangKi] (" +
            "[MaPDK] TEXT  NULL PRIMARY KEY," +
            "[MaKH] TEXT  NULL," +
            "[MaNV] TEXT  NULL," +
            "[NgayDen] DATE," +
            "[SoNgayThue] INTEGER," +
            "[GiaPhong] DOUBLE," +
            "[GiaDV] DOUBLE," +
            "[TongTien] DOUBLE "+
            ")";
    public static final String TABLE_Phieu_Dang_ki ="PhieuDangKi";
    public PhieudangkiDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }
    public int InsertPhieuDangKi(PhieuDangKi phieuDangKi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaPDK",phieuDangKi.getMaPDK());
        contentValues.put("MaKH",phieuDangKi.getMaKH());
        contentValues.put("MaNV",phieuDangKi.getMaNV());
        contentValues.put("NgayDen",sss.format(phieuDangKi.getNgayDen()));
        contentValues.put("SoNgayThue",phieuDangKi.getSoNgayThue());
        contentValues.put("GiaPhong",phieuDangKi.getGiaPhong());
        contentValues.put("GiaDV",phieuDangKi.getGiaDV());
        contentValues.put("TongTien",phieuDangKi.getTongTien());

        try{
            if (db.insert(TABLE_Phieu_Dang_ki,null,contentValues)<0){
                return -1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return 1;
    }



    public int updatePDK(PhieuDangKi phieuDangKi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaPDK",phieuDangKi.getMaPDK());
        contentValues.put("MaKH",phieuDangKi.getMaKH());
        contentValues.put("MaNV",phieuDangKi.getMaNV());
        contentValues.put("NgayDen",sss.format(phieuDangKi.getNgayDen()));
        contentValues.put("SoNgayThue",phieuDangKi.getSoNgayThue());
        contentValues.put("GiaPhong",phieuDangKi.getGiaPhong());
        contentValues.put("GiaDV",phieuDangKi.getGiaDV());
        contentValues.put("TongTien",phieuDangKi.getTongTien());
        try{
            if (db.update(TABLE_Phieu_Dang_ki,contentValues,"MaPDK=?",new String[]{phieuDangKi.getMaPDK()})>0){
                return 1;
            }
        }
        catch (Exception e){
            Log.e("asd",e.getMessage());
        }
        return -1;
    }
    public List<PhieuDangKi> getAllPhieuDangKi(){
        List<PhieuDangKi> phieuDangKiArrayList = new ArrayList<>();
         cursor = db.query(TABLE_Phieu_Dang_ki,null,null,null,null,null,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            PhieuDangKi phieuDangKi = new PhieuDangKi();
            phieuDangKi.setMaPDK(cursor.getString(0));
            phieuDangKi.setMaKH(cursor.getString(1));
            phieuDangKi.setMaNV(cursor.getString(2));
            try {
                phieuDangKi.setNgayDen(sss.parse(cursor.getString(3)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            phieuDangKi.setSoNgayThue(Integer.parseInt(cursor.getString(4)));
            phieuDangKi.setGiaPhong(Double.parseDouble(cursor.getString(5)));
            phieuDangKi.setGiaDV(Double.parseDouble(cursor.getString(6)));
            phieuDangKi.setTongTien(cursor.getDouble(7));
            phieuDangKiArrayList.add(phieuDangKi);
            cursor.moveToNext();
        }
        return phieuDangKiArrayList;
    }

    public void deleteNhanVien(String id){
        db.delete(TABLE_Phieu_Dang_ki,"MaPDK=?",new String[]{id});
    }


    public Double getTongTien(){
        double trung = 0;
        String linh = "SELECT SUM(TongTien) FROM PhieuDangKi";
        cursor = db.rawQuery(linh,null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            trung=cursor.getDouble(0);
            cursor.moveToNext();

        }

        return trung;
    }
}
