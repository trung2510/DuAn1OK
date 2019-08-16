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

import com.example.qlks.activity.DichVuActivity;
import com.example.qlks.R;
import com.example.qlks.dao.DichvuDAO;
import com.example.qlks.model.DichVu;

import java.util.List;

public class DichVuAdapter extends RecyclerView.Adapter<DichVuAdapter.ViewHolder> {

    DichvuDAO dichvuDAO;
    Context context;
    List<DichVu> dichVuList;

    public DichVuAdapter(Context context, List<DichVu> dichVuList) {
        this.context = context;
        this.dichVuList = dichVuList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dichvu,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        DichVu dichVu = dichVuList.get(i);
        viewHolder.txtID.setText(dichVu.getTenDV());
        viewHolder.txtDATE.setText(dichVu.getGiaDV());
        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DichVu dichVu1 = dichVuList.get(i);
                Intent intent = new Intent(context, DichVuActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("1",dichVu1.getMaDV());
                bundle.putString("2",dichVu1.getTenDV());
                bundle.putString("3",dichVu1.getGiaDV());
                intent.putExtra("bun",bundle);
                context.startActivity(intent);
            }
        });

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xoa trong database(bat buoc phai xoa trong database trươc khi xoa tren recyclerview neu khong se bi crash app);
                dichvuDAO  = new DichvuDAO(context);
                dichvuDAO.deleteNhanVien(dichVuList.get(i).getMaDV());

                //Xoa tren recyclerview
                dichVuList.remove(dichVuList.get(i));

                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return dichVuList.size();
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
