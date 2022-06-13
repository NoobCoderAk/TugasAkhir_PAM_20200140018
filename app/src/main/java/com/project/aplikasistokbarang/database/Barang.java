package com.project.aplikasistokbarang.database;

public class Barang {
    String id, namaBarang, stokBarang, hargaBarang;

    public Barang() {
    }
/*
    public Barang(String id, String namaBarang, String stokBarang, String hargaBarang) {
        this.id = id;
        this.namaBarang = namaBarang;
        this.stokBarang = stokBarang;
        this.hargaBarang = hargaBarang;

    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(String stokBarang) {
        this.stokBarang = stokBarang;
    }

    public String getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(String hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
}
