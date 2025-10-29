package main.java.com.upb.agripos;

import main.java.com.upb.agripos.model.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        Produk[] daftarProduk = {
            new Benih("BNH-001", "Benih Padi", 25000, 100, "IR64"),
            new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea"),
            new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja"),
            new ObatHama("OBT-301", "Racun Serangga", 120000, 10 , "Deltamethrin")
        };

        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo());
            System.out.println("--------------------");
        }

        CreditBy.print("240202856", "Defita Dwi Wulanadary");
    }
}
