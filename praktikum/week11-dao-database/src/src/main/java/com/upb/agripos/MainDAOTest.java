package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import java.util.List;

public class MainDAOTest {
    public static void main(String[] args) throws Exception {
        // Konfigurasi koneksi database
        String url = "jdbc:postgresql://localhost:5432/agripos";
        String user = "postgres";
        String pass = "defita"; // Ganti dengan password database Anda

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            ProductDAO dao = new ProductDAOImpl(conn);

            System.out.println("=======================================");
            System.out.println("        AGRIPOS - SISTEM KASIR         ");
            System.out.println("=======================================");

            // 1. Operasi Insert (Create)
            dao.insert(new Product("P03", "Pupuk sintetis", 25000, 10));
            dao.insert(new Product("P04", "Benih padi", 15000, 50));
            System.out.println("[Sistem] Berhasil menambah stok barang.");

            // 2. Operasi Update
            dao.update(new Product("P01", "Pupuk Organik Premium", 30000, 8));
            System.out.println("[Sistem] Update data produk P01 selesai.");

            // 3. Menampilkan Daftar Barang (Read)
            System.out.println("\nDAFTAR STOK BARANG TERBARU:");
            System.out.println("---------------------------------------");
            List<Product> products = dao.findAll();
            for (Product p : products) {
                System.out.printf("%-5s | %-20s | %-8.0f | %-3d\n", 
                    p.getCode(), p.getName(), p.getPrice(), p.getStock());
            }

            // Bagian Bawah Struk (Identitas Kasir)
            System.out.println("---------------------------------------");
            System.out.println("Status Transaksi: BERHASIL");
            System.out.println("Terima kasih telah berbelanja!");
            System.out.println("=======================================");
            System.out.println("KASIR : [Defita Dwi Wulandary]"); // Ganti dengan Nama Anda
            System.out.println("NIM   : [240202856]");  // Ganti dengan NIM Anda
            System.out.println("=======================================");

            // Opsional: Hapus data setelah tes (agar database bersih)
            // dao.delete("P01");
            // dao.delete("P02");
        }
    }
}