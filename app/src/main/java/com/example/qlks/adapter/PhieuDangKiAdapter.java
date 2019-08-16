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

import com.example.qlks.R;
import com.example.qlks.activity.DichVuActivity;
import com.example.qlks.activity.PhieuDangKiActivity;
import com.example.qlks.dao.PhieudangkiDAO;
import com.example.qlks.model.DichVu;
import com.example.qlks.model.PhieuDangKi;

import java.util.List;

public class PhieuDangKiAdapter extends RecyclerView.Adapter<PhieuDangKiAdapter.ViewHolder> {

    PhieudangkiDAO phieudangkiDAO;
    Context context;
    List<PhieuDangKi> phieuDangKiList;

    public PhieuDangKiAdapter(Context context, List<PhieuDangKi> phieuDangKiList) {
        this.context = context;
        this.phieuDangKiList = phieuDangKiList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_phieu_dang_ki,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final PhieuDangKi PhieuDangKiDAO = phieuDangKiList.get(i);
        viewHolder.txtID.setText(PhieuDangKiDAO.getMaKH());
        viewHolder.txtDATE.setText(PhieuDangKiDAO.getTongTien()+"");
        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhieuDangKi phieuDangKi = phieuDangKiList.get(i);
                Intent intent = new Intent(context, PhieuDangKiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("1",phieuDangKi.getMaPDK());
                bundle.putString("2",phieuDangKi.getMaKH());
                bundle.putString("3",phieuDangKi.getMaNV());
                bundle.putInt("4",phieuDangKi.getSoNgayThue());
                bundle.putDouble("5",phieuDangKi.getGiaPhong());
                bundle.putDouble("6",phieuDangKi.getGiaDV());
                bundle.putString("7",phieuDangKi.getTongTien()+"");

                intent.putExtra("bun",bundle);
                context.startActivity(intent);
            }
        });

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xoa trong database(bat buoc phai xoa trong database trươc khi xoa tren recyclerview neu khong se bi crash app);
                phieudangkiDAO  = new PhieudangkiDAO(context);
                phieudangkiDAO.deleteNhanVien(phieuDangKiList.get(i).getMaPDK());

                //Xoa tren recyclerview
                phieuDangKiList.remove(phieuDangKiList.get(i));

                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return phieuDangKiList.size();
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
