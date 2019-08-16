package com.example.qlks.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlks.list_activity.ListDichVuActivity;
import com.example.qlks.R;
import com.example.qlks.dao.DichvuDAO;
import com.example.qlks.model.DichVu;

public class DichVuActivity extends AppCompatActivity {


    private EditText edMaDV;
    private EditText edTenDV;
    private EditText edGiaDV;
    private Button btnLuu;
    private Button btnHuy;
    private Button btnShow;
    private Button btnUpdate;
    DichvuDAO dichvuDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dich_vu);

        edMaDV = (EditText) findViewById(R.id.edMaDV);
        edTenDV = (EditText) findViewById(R.id.edTenDV);
        edGiaDV = (EditText) findViewById(R.id.edGiaDV);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        dichvuDAO = new DichvuDAO(this);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = edMaDV.getText().toString();
                String name = edTenDV.getText().toString();
                String mt = edGiaDV.getText().toString();



                if (id.equals("")){
                    edMaDV.setError("Nhập Mã DV");
                }
                if (name.equals("")){
                    edTenDV.setError("Nhập Tên DV");
                }
                if (mt.equals("")){
                    edGiaDV.setError("Nhập Giá DV");
                }

                DichVu dichVu = new DichVu(id,name,mt);

                if (dichvuDAO.InsertDichVu(dichVu) > 0) {
                    Toast.makeText(DichVuActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(DichVuActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DichVuActivity.this, ListDichVuActivity.class));
            }
        });

        try{
            Intent intent = getIntent();
            if (intent!=null){
                Bundle bundle = intent.getBundleExtra("bun");
                edMaDV.setText(bundle.getString("1"));
                edTenDV.setText(bundle.getString("2"));
                edGiaDV.setText(bundle.getString("3"));
            }}
        catch (NullPointerException e){
            Log.e("Loi",e.getMessage()+" ");
        }



    }

    public void UpdateDichVu(View view){
        dichvuDAO = new DichvuDAO(DichVuActivity.this);
        DichVu dichVu = new DichVu(edMaDV.getText().toString().trim(),edTenDV.getText().toString().trim(),edGiaDV.getText().toString().trim());
        if (dichvuDAO.UpdateDichVu(dichVu)==1){
            Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Cap nhat that bai", Toast.LENGTH_SHORT).show();
        }
    }



}

