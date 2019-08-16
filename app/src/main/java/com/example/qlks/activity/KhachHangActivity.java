package com.example.qlks.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlks.list_activity.ListKhachHangActivity;
import com.example.qlks.R;
import com.example.qlks.dao.KhachhangDAO;
import com.example.qlks.model.KhachHang;

public class KhachHangActivity extends AppCompatActivity {

    private EditText edMaKH;
    private EditText edTenKH;
    private EditText edDiaChiKH;
    private EditText edGTKH;
    private EditText edCMND;
    private EditText edQT;
    private Button btnLuu;
    private Button btnHuy;
    private Button btnShow;
    private Button btnUpdate;
    KhachhangDAO khachhangDAO;
    private EditText edSDT;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_hang);


        edMaKH = (EditText) findViewById(R.id.edMaKH);
        edTenKH = (EditText) findViewById(R.id.edTenKH);
        edDiaChiKH = (EditText) findViewById(R.id.edDiaChiKH);
        edGTKH = (EditText) findViewById(R.id.edGTKH);
        edCMND = (EditText) findViewById(R.id.edCMND);
        edQT = (EditText) findViewById(R.id.edQT);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        edSDT = (EditText) findViewById(R.id.edSDT);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);


        khachhangDAO = new KhachhangDAO(this);


        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String id = edMaKH.getText().toString();
                String name = edTenKH.getText().toString();
                String mt = edDiaChiKH.getText().toString();
                String gt = edGTKH.getText().toString();
                String ns = edCMND.getText().toString();
                String sdt = edCMND.getText().toString();
                String dc = edQT.getText().toString();


                if (id.equals("")){
                    edMaKH.setError("Nhập Mã KH");
                }
                if (name.equals("")){
                    edTenKH.setError("Nhập Tên KH");
                }
                if (mt.equals("")){
                    edDiaChiKH.setError("Nhập Địa Chỉ");
                }
                if (gt.equals("")){
                    edGTKH.setError("Nhập Giới Tính");
                }
                if (ns.equals("")){
                    edCMND.setError("Nhập CMND");
                }
                if (sdt.equals("")){
                    edSDT.setError("Nhập SĐT");
                }
                if (dc.equals("")){
                    edQT.setError("Nhập Quốc Tịch");
                }

                KhachHang khachHang = new KhachHang(id,name,mt,gt,ns,sdt,dc);

                if (khachhangDAO.InsertKhachHang(khachHang) > 0) {
                    Toast.makeText(KhachHangActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(KhachHangActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KhachHangActivity.this, ListKhachHangActivity.class));
            }
        });

        try{
            Intent intent = getIntent();
            if (intent!=null){
                Bundle bundle = intent.getBundleExtra("bun");
                edMaKH.setText(bundle.getString("1"));
                edTenKH.setText(bundle.getString("2"));
                edDiaChiKH.setText(bundle.getString("3"));
                edGTKH.setText(bundle.getString("4"));
                edCMND.setText(bundle.getString("5"));
                edSDT.setText(bundle.getString("6"));
                edQT.setText(bundle.getString("7"));
            }}
        catch (NullPointerException e){
            Log.e("Loi",e.getMessage()+" ");
        }


    }
    public void UpdateKhachHang(View view){
        khachhangDAO = new KhachhangDAO(KhachHangActivity.this);
        KhachHang khachHang = new KhachHang(edMaKH.getText().toString().trim(),edTenKH.getText().toString().trim(),edDiaChiKH.getText().toString().trim(),edGTKH.getText().toString().trim(),edCMND.getText().toString().trim(),edSDT.getText().toString().trim(),edQT.getText().toString().trim());
        if (khachhangDAO.UpdateKhachHang(khachHang)==1){
            Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Cap nhat that bai", Toast.LENGTH_SHORT).show();
        }
    }
}
