package com.project.aplikasistokbarang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.project.aplikasistokbarang.database.DBController;

import java.util.HashMap;

public class EditBarang extends Activity {
    TextInputEditText namaBarang, stokBarang, hargaBarang;
    Button Save;
    String nmBarang, id, stkBarang, hrgBarang;
    DBController controller = new DBController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_barang);
        namaBarang = findViewById(R.id.edNamaBarang);
        stokBarang = findViewById(R.id.edStokBarang);
        hargaBarang = findViewById(R.id.edHargaBarang);
        Save = findViewById(R.id.simpanBtn);

        id = getIntent().getStringExtra("id");
        nmBarang = getIntent().getStringExtra("namaBarang");
        stkBarang = getIntent().getStringExtra("stokBarang");
        hrgBarang = getIntent().getStringExtra("hargaBarang");

        setTitle("Edit Barang");
        namaBarang.setText(nmBarang);
        stokBarang.setText(stkBarang);
        hargaBarang.setText(hrgBarang);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (namaBarang.getText().toString().equals("") || stokBarang.getText().toString().equals("") || hargaBarang.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Mohon isi data terlebih dahulu !!", Toast.LENGTH_SHORT).show();
                }
                else{
                    nmBarang = namaBarang.getText().toString();
                    stkBarang = stokBarang.getText().toString();
                    hrgBarang = hargaBarang.getText().toString();
                    HashMap<String,String> values = new HashMap<>();
                    values.put("id",id);
                    values.put("namaBarang",nmBarang);
                    values.put("stokBarang", stkBarang);
                    values.put("hargaBarang", hrgBarang);
                    controller.UpdateData(values);
                    callHome();
                }
            }
        });
    }
    public void callHome(){
        Intent intent = new Intent(EditBarang.this,ViewDaftarBarang.class);
        startActivity(intent);
        finish();
    }
}