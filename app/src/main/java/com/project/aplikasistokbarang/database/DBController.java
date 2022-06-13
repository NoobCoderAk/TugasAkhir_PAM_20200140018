package com.project.aplikasistokbarang.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper{

    public DBController(Context context){super(context,"Toko",null,1);}

    //membuat tabel
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table barang (id integer primary key, namaBarang text, stokBarang text, hargaBarang text)");
    }

    //mengupgrade tabel
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists barang");
        onCreate(db);
    }

    //method untuk memasukkan data ke tabel
    public void insertData(HashMap<String,String> queryValues){
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();

        nilai.put("namaBarang",queryValues.get("namaBarang"));
        nilai.put("stokBarang",queryValues.get("stokBarang"));
        nilai.put("hargaBarang",queryValues.get("hargaBarang"));

        //memasukkan ke data ke tabel teman pada database basisdata
        basisdata.insert("barang", null, nilai);
        basisdata.close();
    }

    //method untuk mengupdate data yang telqh di edit
    public void UpdateData(HashMap<String,String> queryValues ){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilai = new ContentValues();

        nilai.put("namaBarang",queryValues.get("namaBarang"));
        nilai.put("stokBarang",queryValues.get("stokBarang"));
        nilai.put("hargaBarang",queryValues.get("hargaBarang"));

        db.update("barang", nilai, "id=?", new String[]{queryValues.get("id")});
        db.close();
    }

    //untuk delete data
    public void DeleteData(HashMap<String,String> queryValues){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("barang", "id=?", new String[]{queryValues.get("id")});
        db.close();
    }

    //untuk mengambil data pada tabel
    public ArrayList<HashMap<String,String>> getAllBarang() {

        ArrayList<HashMap<String,String>> daftarBarang;
        daftarBarang = new ArrayList<HashMap<String,String>>();
        String selectQuery = "Select * from barang";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put("id",cursor.getString(0));
                map.put("namaBarang",cursor.getString(1));
                map.put("stokBarang", cursor.getString(2));
                map.put("hargaBarang", cursor.getString(3));

                daftarBarang.add(map);
            }while (cursor.moveToNext());
        }
        db.close();
        return daftarBarang;
    }
}
