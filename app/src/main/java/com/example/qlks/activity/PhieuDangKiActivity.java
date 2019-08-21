package com.example.qlks.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlks.R;
import com.example.qlks.dao.DichvuDAO;
import com.example.qlks.dao.KhachhangDAO;
import com.example.qlks.dao.NhanvienDAO;
import com.example.qlks.dao.PhieudangkiDAO;
import com.example.qlks.dao.PhongDAO;
import com.example.qlks.list_activity.ListNhanVienActivity;
import com.example.qlks.list_activity.ListPDKActivity;
import com.example.qlks.model.KhachHang;
import com.example.qlks.model.NhanVien;
import com.example.qlks.model.PhieuDangKi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class PhieuDangKiActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText edMaPDK;
    private AppCompatSpinner spnMaKH;
    private AppCompatSpinner spnMaNV;
    private EditText edNgayDen;
    private Spinner spnPhong;
    private Spinner spnDV;
    private Button btnLuu;
    private Button btnShow;
    private Button btnUpdate;
    private EditText edSongaythuephong;
    private EditText edtGiaPhong;
    private EditText edtGiaDV;
    private SimpleDateFormat sss = new SimpleDateFormat("dd-MM-yyyy");
    private TextView tvTongTien;

    int maKH;
    int maNV;
    int idPhong;
    int idDV;

    PhieudangkiDAO phieudangkiDAO;
    List<String> stringListMaKH = new ArrayList<>();
    List<String> stringListMaNV = new ArrayList<>();
    List<String> stringListGiaDV = new ArrayList<>();
    List<String> stringListMaP = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phieu_dang_ki);


        edMaPDK = (EditText) findViewById(R.id.edMaPDK);

        spnMaKH = (AppCompatSpinner) findViewById(R.id.spnMaKH);

        spnMaNV = (AppCompatSpinner) findViewById(R.id.spnMaNV);
        edNgayDen = (EditText) findViewById(R.id.edNgayDen);
        spnPhong = (Spinner) findViewById(R.id.spnPhong);
        spnDV = (Spinner) findViewById(R.id.spnDV);
        btnLuu = (Button) findViewById(R.id.btnLuu);
        btnShow = (Button) findViewById(R.id.btnShow);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        edSongaythuephong = (EditText) findViewById(R.id.edSongaythuephong);
        edtGiaPhong = (EditText) findViewById(R.id.edtGiaPhong);
        edtGiaDV = (EditText) findViewById(R.id.edtGiaDV);
        tvTongTien = (TextView) findViewById(R.id.tvTongTien);



        //List MÃ KH
        KhachhangDAO khachhangDAO = new KhachhangDAO(getApplicationContext());
        stringListMaKH = khachhangDAO.getMaKH();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,stringListMaKH);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnMaKH.setAdapter(arrayAdapter);

        //List MÃ NV
        NhanvienDAO nhanvienDAO  = new NhanvienDAO(getApplicationContext());
        stringListMaNV = nhanvienDAO.getMaNV();
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,stringListMaNV);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnMaNV.setAdapter(arrayAdapter2);

        //List giá DV
        DichvuDAO dichvuDAO  = new DichvuDAO(getApplicationContext());
        stringListGiaDV = dichvuDAO.getMaDV();
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,stringListGiaDV);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        spnDV.setAdapter(arrayAdapter3);
        //List MÃ Phòng
        PhongDAO phongDAO  = new PhongDAO(getApplicationContext());
        stringListMaP = phongDAO.getMaP();
        ArrayAdapter lll = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,stringListMaP);
        lll.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnPhong.setAdapter(lll);





        phieudangkiDAO = new PhieudangkiDAO(this);


        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                maKH = spnMaKH.getSelectedItemPosition();
                maNV = spnMaNV.getSelectedItemPosition();
                idPhong = spnPhong.getSelectedItemPosition();
                idDV = spnDV.getSelectedItemPosition();

                phieudangkiDAO = new PhieudangkiDAO(PhieuDangKiActivity.this);


                String id = edMaPDK.getText().toString();
                String name = spnMaKH.getSelectedItem().toString();
                String mt = spnMaNV.getSelectedItem().toString();
                String phong = spnPhong.getSelectedItem().toString();
                String DV = spnDV.getSelectedItem().toString();
                Double tvtt=Double.parseDouble(tvTongTien.getText().toString()+"");
                Date gt = null;
                try {
                    gt = sss.parse( edNgayDen.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int dc = Integer.parseInt(edSongaythuephong.getText().toString());


                Double gp =Double.parseDouble( edtGiaPhong.getText().toString());
                Double gdv = Double.parseDouble(edtGiaDV.getText().toString());
                if (id.equals("")){
                    edMaPDK.setError("Nhập Mã PĐK");
                }



                PhieuDangKi phieuDangKi = new PhieuDangKi(id,maKH,name,maNV,mt,gt,dc,idPhong,phong,gp,idDV,DV,gdv,tvtt);

                if (phieudangkiDAO.InsertPhieuDangKi(phieuDangKi) > 0) {
                    Toast.makeText(PhieuDangKiActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(PhieuDangKiActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PhieuDangKiActivity.this, ListPDKActivity.class));
            }
        });


        try{
            Intent intent = getIntent();
            if (intent!=null){
                Bundle bundle = intent.getBundleExtra("bun");
                edMaPDK.setText(bundle.getString("1"));
                maKH = bundle.getInt("2");
                maNV = bundle.getInt("3");
                idPhong = bundle.getInt("idPhong");
                idDV = bundle.getInt("idDV");
                spnMaKH.setSelection(maKH);
                spnMaNV.setSelection(maNV);
                spnPhong.setSelection(idPhong);
                spnDV.setSelection(idDV);
                edSongaythuephong.setText(bundle.getInt("4")+"");
                edtGiaPhong.setText(bundle.getDouble("5")+"");
                edtGiaDV.setText(bundle.getDouble("6")+"");
                tvTongTien.setText(bundle.getString("7"));
            }}
        catch (NullPointerException e){
            Log.e("Loi",e.getMessage()+" ");
        }

    }

    public void UpdatePDK(View view){
        maKH = spnMaKH.getSelectedItemPosition();
        maNV = spnMaNV.getSelectedItemPosition();
        idPhong = spnPhong.getSelectedItemPosition();
        idDV = spnDV.getSelectedItemPosition();

        phieudangkiDAO = new PhieudangkiDAO(PhieuDangKiActivity.this);

        String id = edMaPDK.getText().toString();
        String name = spnMaKH.getSelectedItem().toString();
        String mt = spnMaNV.getSelectedItem().toString();
        Date gt = null;
        try {
            gt = sss.parse( edNgayDen.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dc = Integer.parseInt(edSongaythuephong.getText().toString());
        String phong = spnPhong.getSelectedItem().toString();
        String DV = spnDV.getSelectedItem().toString();
        Double gp =Double.parseDouble( edtGiaPhong.getText().toString());
        Double gdv = Double.parseDouble(edtGiaDV.getText().toString());
        Double tvtt=Double.parseDouble(tvTongTien.getText().toString()+"");
        if (id.equals("")){
            edMaPDK.setError("Nhập Mã PĐK");
        }
        if (gp.equals("")){
            edSongaythuephong.setError("Nhập giá phòng");
        }
        if (gdv.equals("")){
            edSongaythuephong.setError("Nhập giá dịch vụ");
        }


        PhieuDangKi phieuDangKi = new PhieuDangKi(id,maKH,name,maNV,mt,gt,dc,idPhong,phong,gp,idDV,DV,gdv,tvtt);

        if (phieudangkiDAO.updatePDK(phieuDangKi) > 0) {
            Toast.makeText(PhieuDangKiActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(PhieuDangKiActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
        }

    }


    private void setDate(final Calendar calendar) {
        edNgayDen.setText(sss.format(calendar.getTime()));
    }

    public void ThanhToan(View view) {
        int dc = Integer.parseInt(edSongaythuephong.getText().toString());
        Double gp =Double.parseDouble( edtGiaPhong.getText().toString());
        Double gdv = Double.parseDouble(edtGiaDV.getText().toString());

//        tvTongTien.setText("Số tiền phải trả là: "+ dc*(gp+gdv));
        tvTongTien.setText(dc*(gp+gdv)+"");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year, month,dayOfMonth );
        setDate(cal);
    }


    public static class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }


    }

    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "Date");

    }

}
