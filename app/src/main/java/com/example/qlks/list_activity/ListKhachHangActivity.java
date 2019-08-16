package com.example.qlks.list_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qlks.R;
import com.example.qlks.adapter.KhachHangAdapter;
import com.example.qlks.dao.KhachhangDAO;
import com.example.qlks.model.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class ListKhachHangActivity extends AppCompatActivity {

    private RecyclerView rcKhachHang;

    List<KhachHang> khachHangs;

    KhachhangDAO khachhangDAO;

    KhachHangAdapter khachHangAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_khach_hang);

        rcKhachHang = (RecyclerView) findViewById(R.id.rcKhachHang);

        khachHangs = new ArrayList<>();
        khachhangDAO = new KhachhangDAO(ListKhachHangActivity.this);
        khachHangs = khachhangDAO.getAllKhachHang();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        khachHangAdapter = new KhachHangAdapter(this,khachHangs);

        rcKhachHang.setLayoutManager(linearLayoutManager);

        rcKhachHang.setAdapter(khachHangAdapter);



    }
}
