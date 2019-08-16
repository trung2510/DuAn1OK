package com.example.qlks.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlks.list_activity.ListNhanVienActivity;
import com.example.qlks.R;
import com.example.qlks.dao.NhanvienDAO;
import com.example.qlks.model.NhanVien;

public class NhanVienActivity extends AppCompatActivity {

    private EditText edMaNV;
    private EditText edTenNV;
    private EditText edMaCV;
    private EditText edGT;
    private EditText edNgaySinh;
    private EditText edDiaChi;
    private Button btnLuu;
    private Button btnHuy;
    private Button btnShow;
    private Button btnUpdate;
    NhanvienDAO nhanvienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);


        edMaNV = (EditText) findViewById(R.id.edMaNV);
        edTenNV = (EditText) findViewById(R.id.edTenNV);
        edMaCV = (EditText) findViewById(R.id.edMaCV);
        edGT = (EditText) findViewById(R.id.edGT);
        edNgaySinh = (EditText) findViewById(R.id.edNgaySinh);
        edDiaChi = (EditText) findViewById(R.id.edDiaChi);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);


        nhanvienDAO = new NhanvienDAO(this);


        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nhanvienDAO = new NhanvienDAO(NhanVienActivity.this);

                String id = edMaNV.getText().toString();
                String name = edTenNV.getText().toString();
                String mt = edMaCV.getText().toString();
                String gt = edGT.getText().toString();
                String ns = edNgaySinh.getText().toString();
                String dc = edDiaChi.getText().toString();


                if (id.equals("")){
                    edMaNV.setError("Nhập Mã NV");
                }
                if (name.equals("")){
                    edTenNV.setError("Nhập Tên NV");
                }
                if (mt.equals("")){
                    edMaCV.setError("Nhập Mã CV");
                }
                if (gt.equals("")){
                    edMaCV.setError("Nhập Giới Tính");
                }
                if (ns.equals("")){
                    edNgaySinh.setError("Nhập Ngày Sinh");
                }
                if (dc.equals("")){
                    edDiaChi.setError("Nhập Địa Chỉ");
                }

                NhanVien nhanVien = new NhanVien(id,name,mt,gt,ns,dc);

                if (nhanvienDAO.InsertNhanVien(nhanVien) > 0) {
                    Toast.makeText(NhanVienActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(NhanVienActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NhanVienActivity.this, ListNhanVienActivity.class));
            }
        });


        try{
            Intent intent = getIntent();
            if (intent!=null){
                Bundle bundle = intent.getBundleExtra("bun");
                edMaNV.setText(bundle.getString("1"));
                edTenNV.setText(bundle.getString("2"));
                edMaCV.setText(bundle.getString("3"));
                edGT.setText(bundle.getString("4"));
                edNgaySinh.setText(bundle.getString("5"));
                edDiaChi.setText(bundle.getString("6"));
            }}
        catch (NullPointerException e){
            Log.e("Loi",e.getMessage()+" ");
        }

    }
    public void UpdateNhanVien(View view){
        nhanvienDAO = new NhanvienDAO(NhanVienActivity.this);
        NhanVien nhanVien = new NhanVien(edMaNV.getText().toString().trim(),edTenNV.getText().toString().trim(),edMaCV.getText().toString().trim(),edGT.getText().toString().trim(),edNgaySinh.getText().toString().trim(),edDiaChi.getText().toString().trim());
        if (nhanvienDAO.UpdateNhanVien(nhanVien)==1){
            Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Cap nhat that bai", Toast.LENGTH_SHORT).show();
        }
    }
}
