package com.example.qlks.list_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.qlks.R;
import com.example.qlks.adapter.NhanVienAdapter;
import com.example.qlks.adapter.PhongAdapter;
import com.example.qlks.dao.PhongDAO;
import com.example.qlks.model.Phong;

import java.util.ArrayList;
import java.util.List;

public class ListPhongActivity extends AppCompatActivity {

    private RecyclerView rcPhong;
    PhongDAO phongDAO;
    List<Phong> phongs;
    PhongAdapter phongAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_phong);


        rcPhong = (RecyclerView) findViewById(R.id.rcPhong);

        phongs = new ArrayList<>();
        phongDAO = new PhongDAO(this);
        phongs = phongDAO.getAllPhong();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        phongAdapter = new PhongAdapter(this,phongs);
        rcPhong.setLayoutManager(linearLayoutManager);

        rcPhong.setAdapter(phongAdapter);
    }
}
