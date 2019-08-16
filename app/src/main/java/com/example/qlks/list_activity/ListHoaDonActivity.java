package com.example.qlks.list_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qlks.R;
import com.example.qlks.adapter.HoaDonAdapter;
import com.example.qlks.dao.HoadonDAO;
import com.example.qlks.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class ListHoaDonActivity extends AppCompatActivity {
    private RecyclerView rcHoaDon;

    List<HoaDon> hoaDonList;

    HoadonDAO hoadonDAO;

    HoaDonAdapter hoaDonAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hoa_don);
        rcHoaDon = (RecyclerView) findViewById(R.id.rcHoaDon);

        hoaDonList = new ArrayList<>();
        hoadonDAO = new HoadonDAO(ListHoaDonActivity.this);
        hoaDonList = hoadonDAO.getAllHoaDon();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        hoaDonAdapter  = new HoaDonAdapter(this,hoaDonList);

        rcHoaDon.setLayoutManager(linearLayoutManager);

        rcHoaDon.setAdapter(hoaDonAdapter);
    }
}
