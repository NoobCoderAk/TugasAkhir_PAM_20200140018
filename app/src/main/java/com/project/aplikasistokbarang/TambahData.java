package com.project.aplikasistokbarang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.project.aplikasistokbarang.database.DBController;

import java.util.HashMap;

public class TambahData extends AppCompatActivity {
    private TextInputEditText tNamaBarang,tStokBarang,tHargaBarang;
    private Button simpanBtn;
    String namaBarang, stokBarang, hargaBarang;
    DBController controller = new DBController(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        tNamaBarang =(TextInputEditText) findViewById(R.id.tietNama);
        tStokBarang=(TextInputEditText) findViewById(R.id.tietStok);
        tHargaBarang=(TextInputEditText) findViewById(R.id.tietHarga);
        simpanBtn=(Button) findViewById(R.id.buttonSave);



        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tNamaBarang.getText().toString().equals("") || tStokBarang.getText().toString().equals("")||tHargaBarang.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Semua Data Harus Diisi !", Toast.LENGTH_SHORT).show();
                }
                else{
                    namaBarang = tNamaBarang.getText().toString();
                    stokBarang = tStokBarang.getText().toString();
                    hargaBarang =tHargaBarang.getText().toString();

                    HashMap<String,String> qvalues = new HashMap<>();
                    qvalues.put("namaBarang",namaBarang);
                    qvalues.put("stokBarang", stokBarang);
                    qvalues.put("hargaBarang", hargaBarang);

                    controller.insertData(qvalues);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(TambahData.this,ViewDaftarBarang.class);
        startActivity(intent);
        finish();
    }
}