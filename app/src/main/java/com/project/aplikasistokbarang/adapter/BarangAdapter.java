package com.project.aplikasistokbarang.adapter;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.aplikasistokbarang.EditBarang;
import com.project.aplikasistokbarang.MainActivity;
import com.project.aplikasistokbarang.R;
import com.project.aplikasistokbarang.database.DBController;
import com.project.aplikasistokbarang.database.Barang;

import java.util.ArrayList;
import java.util.HashMap;
/*
public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder>{
   private ArrayList<Barang> listData;
    private Context control;

    @NonNull
    @Override
    public BarangAdapter.BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_barang,parent,false);
        control = parent.getContext();
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.BarangViewHolder holder, int position) {
        String nma, id;
        Integer stok, harga;

        id = listData.get(position).getId();
        nma = listData.get(position).getNamaBarang();
        stok = listData.get(position).getStokBarang();
        harga = listData.get(position).getHargaBarang();
        DBController db = new DBController(control);

        holder.namaBarangTxt.setTextColor(Color.BLUE);
        holder.namaBarangTxt.setTextSize(20);
        holder.namaBarangTxt.setText(nma);
        holder.stokBarangTxt.setText(stok);
        holder.hargaBarangTxt.setText(harga);

        holder.cardku.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(control, holder.cardku);
                popupMenu.inflate(R.menu.menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.mnEdit:
                                Intent i = new Intent(control, EditBarang.class);
                                i.putExtra("id",id);
                                i.putExtra("nama",nma);
                                i.putExtra("telpon",tlp);
                                control.startActivity(i);
                                break;
                            case R.id.mnHapus:
                                HashMap<String,String> values = new HashMap<>();
                                values.put("id",id);
                                db.DeleteData(values);
                                Intent j = new Intent(control, MainActivity.class);
                                control.startActivity(j);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class BarangViewHolder extends RecyclerView.ViewHolder{
        private CardView cardku;
        private TextView namaBarangTxt, stokBarangTxt, hargaBarangTxt;
        public BarangViewHolder(View view) {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuku);
            namaBarangTxt = (TextView)  view.findViewById(R.id.textNama);
            stokBarangTxt = (TextView) view.findViewById(R.id.textTelpon);
            hargaBarangTxt = (TextView) view.findViewById(R.id.textTelpon);

        }
    }
}*/
