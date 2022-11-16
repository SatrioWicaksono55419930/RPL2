package com.toko.buku.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "toko_buku")
public class TokoBuku implements Serializable {
    @Id
    @Column(name = "kd_buku", length = 15)
    private String kd_buku;
    @Column(name = "nama", length = 25)
    private String nama;
    @Column(name = "harga", length = 15)
    private int harga;
    @Column(name = "stock", length = 15)
    private String stock;

    public String getKd_buku() {
        return kd_buku;
    }

    public void setKd_buku(String kd_buku) {
        this.kd_buku = kd_buku;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    
}
