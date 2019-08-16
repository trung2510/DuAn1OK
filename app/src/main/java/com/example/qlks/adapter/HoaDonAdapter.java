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

import com.example.qlks.activity.HoaDonActivity;
import com.example.qlks.R;
import com.example.qlks.dao.HoadonDAO;
import com.example.qlks.model.HoaDon;

import java.util.List;

public class HoaDonAdapter extends RecyclerView.Adapter<HoaDonAdapter.ViewHolder> {
    HoadonDAO hoadonDAO;
    Context context;
    List<HoaDon> hoaDonList;

    public HoaDonAdapter(Context context, List<HoaDon> hoaDonList) {
        this.context = context;
        this.hoaDonList = hoaDonList;
    }

    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hoadon,viewGroup,false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder( ViewHolder viewHolder,final int i) {
        HoaDon hoaDon = hoaDonList.get(i);
        viewHolder.txtID.setText(hoaDon.getMaHD());
        viewHolder.txtDATE.setText(hoaDon.getMaPTT());
        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HoaDon hoaDon1 = hoaDonList.get(i);
                Intent intent = new Intent(context, HoaDonActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("1",hoaDon1.getMaHD());
                bundle.putString("2",hoaDon1.getMaPTT());
                bundle.putDouble("3",hoaDon1.getSoTien());
                bundle.putDouble("4",hoaDon1.getTongTien());
                intent.putExtra("bun",bundle);
                context.startActivity(intent);
            }
        });

        viewHolder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xoa trong database(bat buoc phai xoa trong database trươc khi xoa tren recyclerview neu khong se bi crash app);
                hoadonDAO  = new HoadonDAO(context);
                hoadonDAO.deleteHoaDon(hoaDonList.get(i).getMaHD());

                //Xoa tren recyclerview
                hoaDonList.remove(hoaDonList.get(i));

                notifyDataSetChanged();


            }
        });

    }

    @Override
    public int getItemCount() {
        return hoaDonList.size();
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
