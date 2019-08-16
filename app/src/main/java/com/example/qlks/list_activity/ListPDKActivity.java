package com.example.qlks.list_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qlks.R;
import com.example.qlks.adapter.NhanVienAdapter;
import com.example.qlks.adapter.PhieuDangKiAdapter;
import com.example.qlks.dao.NhanvienDAO;
import com.example.qlks.dao.PhieudangkiDAO;
import com.example.qlks.model.NhanVien;
import com.example.qlks.model.PhieuDangKi;

import java.util.ArrayList;
import java.util.List;

public class ListPDKActivity extends AppCompatActivity {

    private RecyclerView rcNhanVien;
    PhieudangkiDAO phieudangkiDAO;
    List<PhieuDangKi> phieuDangKiList;
    PhieuDangKiAdapter phieuDangKiAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pdk);


        rcNhanVien = (RecyclerView) findViewById(R.id.rcNhanVien);

        phieuDangKiList = new ArrayList<>();
        phieudangkiDAO = new PhieudangkiDAO(ListPDKActivity.this);
        phieuDangKiList= phieudangkiDAO.getAllPhieuDangKi();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        phieuDangKiAdapter = new PhieuDangKiAdapter(this,phieuDangKiList);
        rcNhanVien.setLayoutManager(linearLayoutManager);

        rcNhanVien.setAdapter(phieuDangKiAdapter);
    }
}
