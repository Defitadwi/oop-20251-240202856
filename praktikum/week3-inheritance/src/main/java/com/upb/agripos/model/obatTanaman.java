
package com.upb.agripos.model;

public class obatTanaman extends Produk {
    private String fungsiObat;

    public obatTanaman(String kode, String nama, double harga, int stok, String fungsiObat) {
        super(kode, nama, harga, stok);
        this.fungsiObat = fungsiObat;
    }

    public void deskripsi() {
        System.out.println("\n=== DATA PRODUK OBAT TANAMAN ===");
        tampilkanInfo();
        System.out.println("Fungsi Obat: " + fungsiObat);
    }
}
