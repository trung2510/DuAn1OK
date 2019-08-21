package com.example.qlks.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlks.R;
import com.example.qlks.dao.NhanvienDAO;

public class LoginActivity extends AppCompatActivity {
//    private Button btnLogin;
//
//    private EditText edtUser;
//    private EditText edtPass;

    private EditText edtUserName;
    private EditText edtPassWord;
    private CheckBox ckbRememberPassword;
    private Button btnDangNhap;
    private TextView txtForgotpassword;
    private TextView txtContact;
    private FloatingActionButton flbForMatText;

    NhanvienDAO nguoiDungDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lo_gin);
//        btnLogin=findViewById(R.id.btnLogin);
//        edtUser = (EditText) findViewById(R.id.edtUser);
//        edtPass = (EditText) findViewById(R.id.edtPass);
//
//
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                NhanvienDAO nhanvienDAO = new NhanvienDAO(LoginActivity.this);
//                if (nhanvienDAO.checkLogin(edtUser.getText().toString(),edtPass.getText().toString())<=0){
//                    Toast.makeText(LoginActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                }
//            }
//        });

        AnhXa();
        onClick();

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nguoiDungDAO = new NhanvienDAO(LoginActivity.this);
                if (nguoiDungDAO.checkLogin(edtUserName.getText().toString(),edtPassWord.getText().toString())<=0){
                    Toast.makeText(LoginActivity.this, "Login không thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Login thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,Main2Activity.class));
                }
            }
        });

        flbForMatText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUserName.setText("");
                edtPassWord.setText("");
            }
        });
    }

    private void onClick() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }

    private void AnhXa() {
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtPassWord = (EditText) findViewById(R.id.edtPassWord);
        ckbRememberPassword = (CheckBox) findViewById(R.id.ckbRememberPassword);
        btnDangNhap = (Button) findViewById(R.id.btnDangNhap);
        txtForgotpassword = (TextView) findViewById(R.id.txtForgotpassword);
        txtContact = (TextView) findViewById(R.id.txtContact);
        flbForMatText = (FloatingActionButton) findViewById(R.id.flbForMatText);

    }
}
