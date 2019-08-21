package com.example.qlks.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.LinearLayout;

import com.example.qlks.R;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private LinearLayout layoutNhanVien;
    private LinearLayout layoutDichVu;
    private LinearLayout layoutHoaDon;
    private LinearLayout layoutKhachHang;
    private LinearLayout layoutPhong;
    private LinearLayout layoutPDK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        anhXa();
        onClick();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(Main2Activity.this,NhanVienActivity.class));
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(Main2Activity.this,KhachHangActivity.class));
        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(Main2Activity.this,DichVuActivity.class));
        } else if (id == R.id.nav_tools) {
            startActivity(new Intent(Main2Activity.this,PhongActivity.class));
        } else if (id == R.id.nav_share) {
            startActivity(new Intent(Main2Activity.this,HoaDonActivity.class));
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(Main2Activity.this,PhieuDangKiActivity.class));
        } else if (id == R.id.nav_dangxuat){


            AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
            LayoutInflater inflater = getLayoutInflater();
            builder.setView(inflater.inflate(R.layout.alert_dangxuat,null));
            builder.setPositiveButton("Được luôn", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onBackPressed();
                }
            });
            builder.setNegativeButton("Từ từ đã", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();

        }

            else if (id == R.id.nav_thoat){
                        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                        LayoutInflater inflater = getLayoutInflater();
                        builder.setView(inflater.inflate(R.layout.alert_exit,null));
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                        builder.setNegativeButton("Thôi để tí nữa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();

                    }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void onClick() {


        layoutNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,NhanVienActivity.class));
            }
        });

        layoutKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,KhachHangActivity.class));
            }
        });
        layoutDichVu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,DichVuActivity.class));
            }
        });

        layoutPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,PhongActivity.class));
            }
        });
        layoutHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,HoaDonActivity.class));
            }
        });
        layoutPDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,PhieuDangKiActivity.class));
            }
        });

    }

    private void anhXa() {

        layoutNhanVien = (LinearLayout) findViewById(R.id.layout_NhanVien);
        layoutDichVu = (LinearLayout) findViewById(R.id.layout_DichVu);
        layoutHoaDon = (LinearLayout) findViewById(R.id.layout_HoaDon);
        layoutKhachHang = (LinearLayout) findViewById(R.id.layout_KhachHang);
        layoutPhong = (LinearLayout) findViewById(R.id.layout_Phong);
        layoutPDK = (LinearLayout) findViewById(R.id.layoutPDK);

    }
}
