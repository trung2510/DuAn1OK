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

import com.example.qlks.activity.PhongActivity;
import com.example.qlks.R;
import com.example.qlks.dao.PhongDAO;
import com.example.qlks.model.Phong;

import java.util.List;

public class PhongAdapter extends RecyclerView.Adapter<PhongAdapter.ViewHolder> {

    PhongDAO phongDAO;
    Context context;
    List<Phong> phongList;

    public PhongAdapter(Context context, List<Phong> phongList) {
        this.context = context;
        this.phongList = phongList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_phong,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Phong phong = phongList.get(i);
        viewHolder.txtID.setText(phong.getTenPhong());
        viewHolder.txtDATE.setText(phong.getTinhTrang());
        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Phong phong1 = phongList.get(i);
                Intent intent = new Intent(context, PhongActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("1",phong1.getMaPhong());
                bundle.putString("2",phong1.getTenPhong());
                bundle.putString("3",phong1.getTinhTrang());
                intent.putExtra("bun",bundle);
                context.startActivity(intent);
            }
        });

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xoa trong database(bat buoc phai xoa trong database trươc khi xoa tren recyclerview neu khong se bi crash app);
                phongDAO  = new PhongDAO(context);
                phongDAO.deleteNhanVien(phongList.get(i).getMaPhong());

                //Xoa tren recyclerview
                phongList.remove(phongList.get(i));

                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return phongList.size();
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
