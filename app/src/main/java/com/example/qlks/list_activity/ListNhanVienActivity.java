package com.example.qlks.list_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qlks.R;
import com.example.qlks.adapter.NhanVienAdapter;
import com.example.qlks.dao.NhanvienDAO;
import com.example.qlks.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class ListNhanVienActivity extends AppCompatActivity {

    private RecyclerView rcNhanVien;
    NhanvienDAO nhanvienDAO;
    List<NhanVien> nhanVienList;
    NhanVienAdapter nhanVienAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nhan_vien);

        rcNhanVien = (RecyclerView) findViewById(R.id.rcNhanVien);

        nhanVienList = new ArrayList<>();
        nhanvienDAO = new NhanvienDAO(ListNhanVienActivity.this);
        nhanVienList= nhanvienDAO.getAllNhanVien();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        nhanVienAdapter = new NhanVienAdapter(this,nhanVienList);
        rcNhanVien.setLayoutManager(linearLayoutManager);

        rcNhanVien.setAdapter(nhanVienAdapter);

    }
}
