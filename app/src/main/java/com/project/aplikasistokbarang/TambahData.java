package com.project.aplikasistokbarang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class TambahData extends AppCompatActivity {
    private TextInputEditText tNamaBarang,tStokBarang,tHargaBarang;
    private Button simpanBtn;
    String namaBarang;
    Integer stokBarang, hargaBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
    }
}