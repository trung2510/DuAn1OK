package com.example.qlks.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qlks.activity.KhachHangActivity;
import com.example.qlks.R;
import com.example.qlks.dao.KhachhangDAO;
import com.example.qlks.model.KhachHang;

import java.util.List;

public class KhachHangAdapter extends RecyclerView.Adapter<KhachHangAdapter.ViewHolder> {

    KhachhangDAO khachhangDAO;
    Context context;
    List<KhachHang> khachHangs;

    public KhachHangAdapter(Context context, List<KhachHang> khachHangs) {
        this.context = context;
        this.khachHangs = khachHangs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_khachhang,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        KhachHang khachHang = khachHangs.get(i);
        viewHolder.txtID.setText(khachHang.getTenKH());
        viewHolder.txtDATE.setText(khachHang.getQuocTich());
        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KhachHang khachHang1 = khachHangs.get(i);
                Intent intent = new Intent(context, KhachHangActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("1",khachHang1.getMaKH());
                bundle.putString("2",khachHang1.getTenKH());
                bundle.putString("3",khachHang1.getDiaChi());
                bundle.putString("4",khachHang1.getGioiTinh());
                bundle.putString("5",khachHang1.getCMND());
                bundle.putString("6",khachHang1.getSDT());
                bundle.putString("7",khachHang1.getQuocTich());
                intent.putExtra("bun",bundle);
                context.startActivity(intent);
            }
        });

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xoa trong database(bat buoc phai xoa trong database trươc khi xoa tren recyclerview neu khong se bi crash app);
                khachhangDAO = new KhachhangDAO(context);
                khachhangDAO.deleteNhanVien(khachHangs.get(i).getMaKH());

                //Xoa tren recyclerview
                khachHangs.remove(khachHangs.get(i));

                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return khachHangs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         ImageView imgView;
         TextView txtID;
         TextView txtDATE;
         ImageView imgEdit;
         ImageView imgDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView = (ImageView) itemView.findViewById(R.id.imgView);
            txtID = (TextView) itemView.findViewById(R.id.txtID);
            txtDATE = (TextView) itemView.findViewById(R.id.txtDATE);
            imgEdit = (ImageView) itemView.findViewById(R.id.imgEdit);
            imgDelete = (ImageView) itemView.findViewById(R.id.imgDelete);
        }
    }
}
