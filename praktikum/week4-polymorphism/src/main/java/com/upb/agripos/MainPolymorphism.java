package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {

        // Membuat array berisi berbagai jenis produk (Polymorphism)
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 50, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja")
        };

        // Demonstrasi Dynamic Binding (pemanggilan method getInfo() berbeda-beda)
        System.out.println("=== Informasi Produk AgriPOS ===");
        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
        }

        // Demonstrasi Overloading
        System.out.println("\n=== Demonstrasi Overloading ===");
        Benih benih = new Benih("BNH-002", "Benih Jagung Bisi", 20000, 80, "Bisi 2");
        System.out.println("Stok awal: " + benih.getStok());
        benih.tambahStok(20);   // versi int
        benih.tambahStok(5.5);  // versi double
        System.out.println("Stok setelah ditambah: " + benih.getStok());

        // Identitas Mahasiswa
        CreditBy.print("240202856", "Defita Dwi Wulandary");
    }
}
