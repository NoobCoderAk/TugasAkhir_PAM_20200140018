package com.project.aplikasistokbarang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Activity extends AppCompatActivity {
    //Deklarasi variable untuk button
    Button btnAddData, btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Menghubungkan variable yang ada pada java dengan componen button pada layout
        btnAddData=findViewById(R.id.btnTambah);
        btnViewData=findViewById(R.id.btnLihat);

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, ViewDaftarBarang.class);
                startActivity(intent);
            }
        });

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, TambahData.class);
                startActivity(intent);
            }
        });
    }
}