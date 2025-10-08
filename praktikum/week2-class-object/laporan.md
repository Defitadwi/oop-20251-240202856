# Laporan Praktikum Minggu 2
Topik: Class dan Object (Produk Pertanian)

## Identitas
- Nama  : Defita Dwi Wulandary
- NIM   : 240202856
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa memahami konsep class dan object dalam 
  pemrograman berorientasi objek (OOP) serta dapat:
- Membuat class Produk dengan menerapkan enkapsulasi.
- Mengimplementasikan method untuk menambah dan 
  mengurangi stok.
- Menampilkan informasi produk serta identitas mahasiswa 
  menggunakan class CreditBy.

---

## Dasar Teori
1. Class adalah blueprint atau rancangan dari suatu objek 
   yang berisi atribut (data) dan method (fungsi).
2. Object merupakan instansiasi dari class yang dapat 
   digunakan untuk mengakses atribut dan method. 
3. Enkapsulasi adalah pembungkusan data agar tidak dapat 
   diakses langsung dari luar class, biasanya menggunakan modifier private dan diakses melalui getter serta setter.
4. Method dalam class digunakan untuk melakukan operasi 
   terhadap atribut yang dimiliki oleh objek tersebut.
5. OOP (Object Oriented Programming) membantu pengembang 
   membuat kode yang modular, mudah dipelihara, dan dapat digunakan kembali.

---

## Langkah Praktikum
1. Membuat Class Produk
  - Buat file Produk.java pada package model.
  - Tambahkan atribut: kode, nama, harga, dan stok.
  - Gunakan enkapsulasi dengan menjadikan atribut   
    bersifat private dan membuat getter serta setter untuk masing-masing atribut.
2. Membuat Class CreditBy
  - Buat file CreditBy.java pada package util.
  - Isi class dengan method statis untuk menampilkan 
    identitas mahasiswa di akhir output: credit by: <240202856> - <defita dwi wulandary>.
3. Membuat Objek Produk dan Menampilkan Credit
  - Buat file MainProduk.java.
  - Instansiasi minimal tiga objek produk, misalnya 
    "Benih Padi", "Pupuk Urea", dan satu produk alat pertanian.
  - Tampilkan informasi produk melalui method getter.
  - Panggil CreditBy.print<"240202856"> - <"defita dwi 
    wulandary"> di akhir main untuk menampilkan identitas
4. Commit dan Push
  - Commit dengan pesan: week2-class-object.

---

## Kode Program

Produk


   package com.upb.agripos.model;

   public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

     public void tambahStok(int jumlah) {
        this.stok += jumlah;
        System.out.println("\n===TRANSAKSI MASUK===");
        System.out.println("Produk : " + nama + ", " + kode);
        System.out.println("Jumlah : +" + jumlah);
        System.out.println("Stok Sekarang : " + stok);
        System.out.println("---------------------------");
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
            System.out.println("\n===TRANSAKSI KELUAR===");
            System.out.println("Produk : " + nama + ", " + kode);
            System.out.println("Jumlah : -" + jumlah);
            System.out.println("Stok Sekarang : " + stok);
            System.out.println("---------------------------");
        } else {
            System.out.println("\nStok " + nama + ", " + kode + " tidak mencukupi!");
            System.out.println("Stok tersedia : " + stok + " | Diminta : " + jumlah);
            System.out.println("---------------------------");
        }
    }
}


CreditBy


   package com.upb.agripos.util;
public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}

```MainProduk
package com.upb.agripos;

import com.upb.agripos.model.Produk;
import com.upb.agripos.util.CreditBy;



MainProduk

   public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BNH-001", "Benih Padi IR64", 25000, 100);
        Produk p2 = new Produk("PPK-101", "Pupuk Urea 50kg", 350000, 40);
        Produk p3 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
  // Transaksi penambahan stok
        p1.tambahStok(20);  // stok datang dari gudang

        // Transaksi pengurangan stok
        p1.kurangiStok(15); // produk dibeli pelanggan
      
        // Tampilkan identitas mahasiswa
        CreditBy.print("240202830", "Bagus Alldiansyah");
    }
}


---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](/praktikum/week2-class-object/screenshots/Screenshot%202025-10-08%20135915.png)
)
---

## Analisis
Penjelasan Kode Program berjalan dari MainProduk, membuat tiga objek Produk, lalu memanggil method untuk menambah atau mengurangi stok. Setelah transaksi, identitas mahasiswa ditampilkan melalui CreditBy.print().

Perbedaan Minggu Ini Minggu ini sudah menerapkan OOP dengan class dan object, sedangkan minggu sebelumnya masih tahap pengenalan dasar Java (variabel, input-output, dan struktur program sederhana).

Kendala dan Solusi Kendala utama adalah memahami hubungan antar class dan cara memanggil method dari package lain. Solusinya dengan mempelajari import package dan akses method menggunakan objek.
---

## Kesimpulan
Dengan menggunakan class dan object, program menjadi lebih terstruktur, terorganisir, dan mudah dikembangkan. Setiap bagian kode memiliki peran jelas — data disimpan dalam class, aksi dijalankan lewat method, serta konsep enkapsulasi membuat data lebih aman dan terkontrol.



---

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?
   Jawaban: Atribut sebaiknya dideklarasikan sebagai private agar data di dalam class tidak bisa diakses atau diubah secara langsung dari luar class. Hal ini menjaga keamanan (security) dan integritas data, serta memungkinkan pengembang mengontrol bagaimana data tersebut digunakan melalui metode khusus seperti getter dan setter.

2. Apa fungsi getter dan setter dalam enkapsulasi? 
   Jawaban: Getter dan setter berfungsi untuk mengakses dan mengubah nilai atribut private secara terkendali.
   - Getter digunakan untuk mengambil nilai atribut.
   - Setter digunakan untuk mengatur atau mengubah nilai 
     atribut dengan validasi tertentu bila diperlukan.
     Dengan cara ini, akses terhadap data menjadi lebih aman dan fleksibel.

3. Bagaimana cara class Produk mendukung pengembangan aplikasi POS yang lebih kompleks?
   Jawaban: Class Produk menjadi pondasi utama (model data) dalam sistem POS karena mewakili setiap produk yang dijual. Dengan adanya atribut seperti kode, nama, harga, dan stok, class ini:
     - Memudahkan pengelolaan data produk.
     - Dapat diperluas untuk fitur lanjutan (misalnya  
       diskon, kategori, atau supplier).
     - Memungkinkan integrasi dengan class lain seperti 
       Transaksi, Pelanggan, atau Kasir.
   Dengan demikian, struktur program menjadi lebih modular, terorganisir, dan mudah dikembangkan.
