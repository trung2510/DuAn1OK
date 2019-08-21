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
    SimpleDateFormat sss = new SimpleDateFormat("dd-MM-yyyy");
    Cursor cursor;

    public static final String SQL_Phieu_Dang_Ki  = "CREATE TABLE [PhieuDangKi] (" +
            "[MaPDK] TEXT  NULL PRIMARY KEY," +
            "[MaKH] TEXT  NULL," +
            "[TenKH] TEXT  NULL," +
            "[MaNV] TEXT  NULL," +
            "[TenNV] TEXT  NULL," +
            "[NgayDen] DATE," +
            "[SoNgayThue] INTEGER," +
            "[idPhong] TEXT," +
            "[tenPhong] TEXT," +
            "[GiaPhong] DOUBLE," +
            "[idDV] TEXT," +
            "[tenDV] TEXT," +
            "[GiaDV] DOUBLE," +
            "[TongTien] DOUBLE "+
            ")";
    public static final String TABLE_Phieu_Dang_ki ="PhieuDangKi";
    public PhieudangkiDAO(Context context){
        dbHelper= new DatabaseHelper(context);
        db= dbHelper.getWritableDatabase();
    }

//    public Double getTienTheoNgay(){
//        double a = 0;
//        String testSUMDAY = "SELECT SUM(TongTien) from PhieuDangKi " +
//                "" + " WHERE strftime(\"%Y-%m-%d\", PhieuDangKi.NgayDen / 1000, 'unixepoch') = strftime(\"%Y-%m-%d\",'now') " +
//                "";
//
//        cursor = db.rawQuery(testSUMDAY,null);
//        cursor.moveToFirst();
//        while (cursor.isAfterLast()==false){
//            a = cursor.getDouble(0);
//            cursor.moveToNext();
//        }
//
//        return a;
//    }

    public int InsertPhieuDangKi(PhieuDangKi phieuDangKi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MaPDK",phieuDangKi.getMaPDK());
        contentValues.put("MaKH",phieuDangKi.getMaKH());
        contentValues.put("TenKH",phieuDangKi.getTenKH());
        contentValues.put("MaNV",phieuDangKi.getMaNV());
        contentValues.put("TenNV",phieuDangKi.getTenNV());
        contentValues.put("NgayDen",sss.format(phieuDangKi.getNgayDen()));
        contentValues.put("SoNgayThue",phieuDangKi.getSoNgayThue());
        contentValues.put("idPhong",phieuDangKi.getIdPhong());
        contentValues.put("tenPhong",phieuDangKi.getTenPhong());
        contentValues.put("GiaPhong",phieuDangKi.getGiaPhong());
        contentValues.put("idDV",phieuDangKi.getIdDV());
        contentValues.put("GiaDV",phieuDangKi.getGiaDV());
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
//        contentValues.put("MaPDK",phieuDangKi.getMaPDK());
        contentValues.put("MaKH",phieuDangKi.getMaKH());
        contentValues.put("TenKH",phieuDangKi.getMaKH());
        contentValues.put("MaNV",phieuDangKi.getMaNV());
        contentValues.put("TenNV",phieuDangKi.getTenNV());
//        contentValues.put("NgayDen",sss.format(phieuDangKi.getNgayDen()));
        contentValues.put("SoNgayThue",phieuDangKi.getSoNgayThue());
        contentValues.put("idPhong",phieuDangKi.getIdPhong());
        contentValues.put("tenPhong",phieuDangKi.getTenPhong());
        contentValues.put("GiaPhong",phieuDangKi.getGiaPhong());
        contentValues.put("idDV",phieuDangKi.getIdDV());
        contentValues.put("tenDV",phieuDangKi.getTenDV());
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
            phieuDangKi.setMaKH(cursor.getInt(1));
            phieuDangKi.setTenKH(cursor.getString(2));
            phieuDangKi.setMaNV(cursor.getInt(3));
            phieuDangKi.setTenNV(cursor.getString(4));
            try {
                phieuDangKi.setNgayDen(sss.parse(cursor.getString(5)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            phieuDangKi.setSoNgayThue(Integer.parseInt(cursor.getString(6)));
            phieuDangKi.setIdPhong(Integer.parseInt(cursor.getString(7)));
            phieuDangKi.setTenPhong(cursor.getString(8));
            phieuDangKi.setGiaPhong(Double.parseDouble(cursor.getString(9)));
            phieuDangKi.setIdDV(Integer.parseInt(cursor.getString(10)));
            phieuDangKi.setTenDV(cursor.getString(11));
            phieuDangKi.setGiaDV(Double.parseDouble(cursor.getString(12)));
            phieuDangKi.setTongTien(cursor.getDouble(13));
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
