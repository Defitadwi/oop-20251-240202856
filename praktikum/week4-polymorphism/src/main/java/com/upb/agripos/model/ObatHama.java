package main.java.com.upb.agripos.model;

public class ObatHama extends Produk {
    private String bahanAktif;

    public ObatHama(String kode, String nama, double harga, int stok, String bahanAktif) {
        super(kode, nama, harga, stok);
        this.bahanAktif = bahanAktif;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nBahan Aktif: " + bahanAktif;
    }
}
