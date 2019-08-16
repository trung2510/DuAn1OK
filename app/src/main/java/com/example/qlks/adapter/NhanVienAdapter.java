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

import com.example.qlks.activity.NhanVienActivity;
import com.example.qlks.R;
import com.example.qlks.dao.NhanvienDAO;
import com.example.qlks.model.NhanVien;

import java.util.List;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder> {

    NhanvienDAO nhanvienDAO;
    Context context;
    List<NhanVien> nhanVienList;

    public NhanVienAdapter(Context context, List<NhanVien> nhanVienList) {
        this.context = context;
        this.nhanVienList = nhanVienList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nhanvien,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        NhanVien nhanVien = nhanVienList.get(i);
        viewHolder.txtID.setText(nhanVien.getMaNV());
        viewHolder.txtDATE.setText(nhanVien.getNgaySinh());
        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NhanVien nhanVien1 = nhanVienList.get(i);
                Intent intent = new Intent(context, NhanVienActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("1",nhanVien1.getMaNV());
                bundle.putString("2",nhanVien1.getTenNV());
                bundle.putString("3",nhanVien1.getMaCV());
                bundle.putString("4",nhanVien1.getGioiTinh());
                bundle.putString("5",nhanVien1.getNgaySinh());
                bundle.putString("6",nhanVien1.getDiaChi());
                intent.putExtra("bun",bundle);
                context.startActivity(intent);
            }
        });

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xoa trong database(bat buoc phai xoa trong database trươc khi xoa tren recyclerview neu khong se bi crash app);
                nhanvienDAO = new NhanvienDAO(context);
                nhanvienDAO.deleteNhanVien(nhanVienList.get(i).getMaNV());

                //Xoa tren recyclerview
                nhanVienList.remove(nhanVienList.get(i));

                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return nhanVienList.size();
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
