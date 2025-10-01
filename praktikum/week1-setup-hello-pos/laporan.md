# Laporan Praktikum Minggu 1 
Topik: Praktikum Dasar Penerapan Tiga Paradigma Pemrograman

## Identitas
- Nama  : Defita Dwi Wulandary
- NIM   : 240202856
- Kelas : 3IKRA

---

## Tujuan
1.Mahasiswa memahami konsep dasar tiga paradigma pemrograman: prosedural, OOP, dan fungsional.
2.Mahasiswa mampu membuat program sederhana “Hello World, I am Defita Dwi Wulandary-240202856” 
  dengan tiga pendekatan tersebut.
3.Mahasiswa dapat menganalisis kelebihan dan kelemahan masing-masing paradigma.
4.Mahasiswa mampu mendokumentasikan hasil praktikum dan mengunggah ke repository Git.

---

## Dasar Teori
1.Paradigma Prosedural berfokus pada urutan instruksi langkah demi langkah (step by step) dan 
  cocok untuk program kecil.
2.Paradigma OOP (Object-Oriented Programming) menggunakan konsep class dan object dengan 
  atribut (state) serta metode (behavior).
3.Paradigma Fungsional menekankan fungsi murni (pure function) dan immutability untuk 
  mengurangi bug serta mendukung komputasi paralel.
4.Pemilihan paradigma yang tepat memengaruhi maintainability dan scalability aplikasi.

---

## Langkah Praktikum
1.Menyiapkan lingkungan coding (Java dan C).
2.Membuat program “Hello World, I am Defita Dwi Wulandary-240202856” dengan tiga paradigma: 
  prosedural (C/Java), OOP (Java), dan fungsional (Java lambda).
3.Menjalankan program dan mengamati hasil eksekusi.
4.Melakukan commit ke Git dengan pesan:
  -Add Hello World program in Procedural
  -Add Hello World program in OOP
  -Add Hello World program in Functional


## Kode Program
```prosedural
// HelloProcedural.java
public class HelloProcedural {
   public static void main(String[] args) {
      String nim = "240202856";
      String nama = "Defita Dwi Wulandary";
     
      System.out.println("Hello World, I am " + nama + ", " + nim);

   }

}

 ```OOP
    // HelloOOP.java
class Mahasiswa {
   String nama; int nim; 
   Mahasiswa(String nama, int nim) {
      this.nama = nama;
      this.nim = nim;
   }
   void sapa() { System.out.println("Hallo word, I am "+nama + ", " + nim);}
}

public class HelloOOP {
   public static void main(String[] args) {
      Mahasiswa m = new Mahasiswa ("Defita Dwi Wulandary", 240202856); 
        m.sapa(); 
       }
}


```functional
import java.util.function.BiConsumer;
public class HelloFunctional {
  public static void main(String[] args)  {
 BiConsumer<String,Integer> sapa =
(nama,nim) -> System.out.println("Hallo word, I am " + nama + ", " + nim);
sapa.accept("Defita Dwi Wulandary", 240202856);

  }
}


---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/Functional.png)
![Screenshot hasil](screenshots/OOP.png)
![Screenshot hasil](screenshots/Prosedural.png)
)
---

## Analisis
1.Kode berjalan sesuai paradigma masing-masing:
  -Prosedural ->  langsung mengeksekusi perintah cetak.
  -OOP -> memanfaatkan objek untuk memanggil metode sapa().
  -Fungsional -> menggunakan ekspresi lambda untuk mengeksekusi fungsi.

2.Perbedaan pendekatan:
  -Prosedural lebih sederhana, tetapi kurang terstruktur untuk sistem besar.
  -OOP lebih modular dan dekat dengan dunia nyata.
  -Fungsional lebih ringkas dan cocok untuk komputasi data.

3.Kendala: Perlu menyesuaikan sintaks Java untuk fungsional programming karena belum terbiasa menggunakan lambda dan BiConsumer.

---

## Kesimpulan
Dengan mempelajari tiga paradigma (prosedural, OOP, dan fungsional), mahasiswa dapat memahami perbedaan gaya pemrograman dan memilih paradigma yang sesuai dengan kebutuhan. OOP lebih cocok untuk aplikasi kompleks, prosedural untuk program kecil, sedangkan fungsional unggul dalam komputasi paralel dan pengolahan data.

---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural?
   Jawaban: Tidak selalu. OOP lebih baik untuk sistem besar dan kompleks, sedangkan prosedural lebih sederhana dan efisien untuk program kecil.

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?
   Jawaban: Functional lebih cocok digunakan saat mengolah data besar, pemrograman paralel, dan situasi yang membutuhkan kode ringkas dengan minim bug state. 

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi? 
   Jawaban: -Prosedural: sulit di-maintain jika sistem besar.
   -OOP: lebih mudah di-maintain karena modular dan scalable.
   -Fungsional: memudahkan maintainability karena kode ringkas, serta scalable untuk komputasi paralel.
4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?
   Jawaban: Karena aplikasi POS (Point of Sale) terdiri dari banyak entitas (produk, pelanggan, transaksi, kasir) yang saling berinteraksi. Dengan OOP, setiap entitas dapat dimodelkan sebagai object, sehingga sistem lebih mudah dikelola, diperluas, dan sesuai dengan dunia nyata.

5. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?
   Jawaban: Paradigma fungsional menggunakan fungsi murni, ekspresi lambda, dan higher-order function sehingga banyak logika dapat ditulis secara ringkas. Hal ini mengurangi kebutuhan menulis ulang kode yang sama (boilerplate), meningkatkan keterbacaan, dan memudahkan pemeliharaan program.
