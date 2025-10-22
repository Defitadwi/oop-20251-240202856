
package com.upb.agripos;

import com.upb.agripos.model.alatpertanian;
import com.upb.agripos.model.benih;
import com.upb.agripos.model.bibitbuah;
import com.upb.agripos.model.obatTanaman;
import com.upb.agripos.model.pestisida;
import com.upb.agripos.model.pupuk;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        // Membuat objek dari tiap subclass
        benih benih = new benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        pupuk pupuk = new pupuk ("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        alatpertanian alat = new alatpertanian ("ALT-501", "Cangkul Baja", 90000, 15, "Baja");
        pestisida pestisida = new pestisida("PST-301", "Furadan 3GR", 120000, 25, "Insektisida");
        bibitbuah bibitBuah = new bibitbuah("BBH-401", "Bibit Mangga Harum Manis", 45000, 30, "Mangga");
        obatTanaman obat = new obatTanaman("OBT-501", "FungiStop 500ml", 80000, 20, "Anti jamur tanaman");

        benih.deskripsi();
        pupuk.deskripsi();
        alat.deskripsi();
        pestisida.deskripsi();
        bibitBuah.deskripsi();
        obat.deskripsi();   
        // Identitas pengembang
        CreditBy.print("240202856", "Defita Dwi Wulandary");
    }
}
