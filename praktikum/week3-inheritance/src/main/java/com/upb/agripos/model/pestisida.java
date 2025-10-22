
package com.upb.agripos.model;

public class pestisida extends Produk {
    private String jenisPestisida;

    public pestisida(String kode, String nama, double harga, int stok, String jenisPestisida) {
        super(kode, nama, harga, stok);
        this.jenisPestisida = jenisPestisida;
    }

    public void deskripsi() {
        System.out.println("\n=== DATA PRODUK PESTISIDA ===");
        tampilkanInfo();
        System.out.println("Jenis Pestisida: " + jenisPestisida);
    }
}
