package main.java.com.upb.agripos.model;

public class Produk {
    protected String kode;
    protected String nama;
    protected double harga;
    protected int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Overloading
    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void tambahStok(double jumlah) {
        this.stok += (int) jumlah;
    }

    public String getInfo() {
        return "Produk: " + nama + "\nKode: " + kode + "\nHarga: Rp" + harga + "\nStok: " + stok;
    }
}
