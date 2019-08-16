package com.example.qlks.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.qlks.list_activity.ListPhongActivity;
import com.example.qlks.R;
import com.example.qlks.dao.PhongDAO;
import com.example.qlks.model.Phong;

public class PhongActivity extends AppCompatActivity {

    private EditText edMaP;
    private EditText edTenP;
    private EditText edTT;
    private Button btnLuu;
    private Button btnHuy;
    private Button btnShow;
    private Button btnUpdate;

    PhongDAO phongDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong);


        edMaP = (EditText) findViewById(R.id.edMaP);
        edTenP = (EditText) findViewById(R.id.edTenP);
        edTT = (EditText) findViewById(R.id.edTT);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnHuy = (Button) findViewById(R.id.btnHuy);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        phongDAO = new PhongDAO(PhongActivity.this);


        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String id = edMaP.getText().toString();
                String name = edTenP.getText().toString();
                String mt = edTT.getText().toString();

                if (id.equals("")){
                    edMaP.setError("Nhập Mã Phòng");
                }
                if (name.equals("")){
                    edTenP.setError("Nhập Tên Phòng");
                }
                if (mt.equals("")){
                    edTT.setError("Nhập Tình Trạng Phòng");
                }


                Phong phong = new Phong(id,name,mt);

                if (phongDAO.InsertPhong(phong) > 0) {
                    Toast.makeText(PhongActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(PhongActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PhongActivity.this, ListPhongActivity.class));
            }
        });

        try{
            Intent intent = getIntent();
            if (intent!=null){
                Bundle bundle = intent.getBundleExtra("bun");
                edMaP.setText(bundle.getString("1"));
                edTenP.setText(bundle.getString("2"));
                edTT.setText(bundle.getString("3"));
            }}
        catch (NullPointerException e){
            Log.e("Loi",e.getMessage()+" ");
        }
    }

    public void UpdatePhong(View view){
        phongDAO = new PhongDAO(PhongActivity.this);
        Phong phong = new Phong(edMaP.getText().toString().trim(),edTenP.getText().toString().trim(),edTT.getText().toString().trim());
        if (phongDAO.UpdatePhong(phong)==1){
            Toast.makeText(this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Cap nhat that bai", Toast.LENGTH_SHORT).show();
        }
    }
}
