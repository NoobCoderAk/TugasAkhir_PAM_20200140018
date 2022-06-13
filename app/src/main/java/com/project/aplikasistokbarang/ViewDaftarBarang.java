package com.project.aplikasistokbarang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project.aplikasistokbarang.adapter.BarangAdapter;
import com.project.aplikasistokbarang.database.Barang;
import com.project.aplikasistokbarang.database.DBController;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewDaftarBarang extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BarangAdapter adapter;
    private ArrayList<Barang> barangArrayList;
    DBController controller = new DBController(this);
    String id, nmaBarang, stkBarang, hrgaBarang;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_daftar_barang);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapter = new BarangAdapter(barangArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewDaftarBarang.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewDaftarBarang.this, TambahData.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData(){
        ArrayList<HashMap<String,String>> daftarBarang = controller.getAllBarang();
        barangArrayList = new ArrayList<>();
        //memindah dari hasil query kedalam Barang
        for (int i=0; i<  daftarBarang.size();i++){
            Barang barang = new Barang();
            barang.setId(daftarBarang.get(i).get("id").toString());
            barang.setNamaBarang(daftarBarang.get(i).get("namaBarang").toString());
            barang.setStokBarang(daftarBarang.get(i).get("stokBarang").toString());
            barang.setHargaBarang(daftarBarang.get(i).get("hargaBarang").toString());

            //pindahkan dari Teman kedalam ArrayList barangdi adapter
            barangArrayList.add(barang);
        }
    }
}