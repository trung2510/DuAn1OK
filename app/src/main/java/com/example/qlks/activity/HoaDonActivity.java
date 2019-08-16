package com.example.qlks.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlks.dao.PhieudangkiDAO;
import com.example.qlks.list_activity.ListHoaDonActivity;
import com.example.qlks.R;
import com.example.qlks.dao.HoadonDAO;
import com.example.qlks.model.HoaDon;

public class HoaDonActivity extends AppCompatActivity {
    private TextView tvThongKe;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);
        tvThongKe = (TextView) findViewById(R.id.tvThongKe);


        PhieudangkiDAO phieudangkiDAO= new PhieudangkiDAO(getApplicationContext());
        tvThongKe.setText(     "Tổng Doanh Thu: "    +phieudangkiDAO.getTongTien()       +       " VNĐ"      );

}   }

