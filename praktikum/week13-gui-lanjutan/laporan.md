# Laporan Praktikum Minggu 13 
Topik: GUI Lanjutan JavaFX (TableView dan Lambda Expression)

## Identitas
- Nama  : [Defita Dwi Wulandary]
- NIM   : [240202856]
- Kelas : [3IKRA]

---

## Tujuan
1. Menampilkan data menggunakan TableView JavaFX.
2. Mengintegrasikan koleksi objek dengan GUI.
3. Menggunakan lambda expression untuk event handling.
4. Menghubungkan GUI dengan DAO secara penuh.
5. Membangun antarmuka GUI Agri-POS yang lebih interaktif.

---

## Dasar Teori
1. JavaFX adalah framework Java yang digunakan untuk membangun aplikasi GUI berbasis desktop secara interaktif dan terstruktur.
2. DAO (Data Access Object) merupakan pola desain yang memisahkan logika akses database dari logika bisnis aplikasi.
3. JDBC (Java Database Connectivity) digunakan sebagai penghubung antara aplikasi Java dan database relasional.
4. PreparedStatement digunakan untuk menjalankan query SQL secara aman dan mencegah SQL Injection.
5. Integrasi GUI dengan database memungkinkan data ditampilkan, ditambah, dan dihapus secara real-time melalui antarmuka pengguna.

---

## Langkah Praktikum
1. Menyiapkan project Maven JavaFX dan menambahkan dependency JavaFX serta JDBC PostgreSQL.
2. Membuat database dan tabel product sebagai penyimpanan data produk.
3. Membuat class Product sebagai model data.
4. Mengimplementasikan pola DAO untuk proses insert, delete, dan tampil data dari database.
5. Menghubungkan DAO dengan GUI JavaFX melalui service.
6. Menjalankan aplikasi dan menguji fitur manajemen produk (tambah, tampil, hapus).
7. Melakukan commit hasil praktikum ke repository Git.

---

## Kode Program
(Tuliskan kode utama yang dibuat, contoh:  

```java
package com.upb.agripos;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductTableView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Class untuk menjalankan aplikasi Agri-POS Week 13.
 * Menghubungkan View, Controller, dan Service sesuai arsitektur SOLID.
 */
public class AppJavaFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // 1. Inisialisasi View (UI TableView)
            ProductTableView productView = new ProductTableView();

            // 2. Inisialisasi Service (Logika Bisnis)
            ProductService productService = new ProductService();

            // 3. Inisialisasi Controller (Penghubung View & Service)
            // Di dalamnya terdapat Lambda Expression untuk handling tombol
            ProductController controller = new ProductController(productView, productService);

            // 4. Load data awal dari database ke TableView
            controller.loadData();

            // 5. Konfigurasi Scene dan Stage
            Scene scene = new Scene(productView, 800, 600);
            
            // Menambahkan CSS jika diperlukan (opsional)
            // scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            primaryStage.setTitle("Agri-POS - Sistem Manajemen Produk Lanjutan (Week 13)");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            System.err.println("Gagal menjalankan aplikasi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Meluncurkan aplikasi JavaFX
        launch(args);
    }
}
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![screenshot hasil](screenshots/tableview_produk.png)
)
---

## Analisis

- Jelaskan bagaimana kode berjalan. 

   Aplikasi berjalan dengan alur di mana data produk diambil dari database melalui ProductDAO, diproses oleh ProductService, lalu ditampilkan pada antarmuka JavaFX menggunakan TableView. Setiap aksi pengguna seperti menambah atau menghapus produk ditangani menggunakan lambda expression pada event handler, kemudian sistem melakukan pemanggilan ulang data agar tampilan selalu terbarui.

- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  

   Perbedaan utama pada minggu ini dibandingkan minggu sebelumnya adalah penggunaan TableView yang terintegrasi langsung dengan database melalui pola DAO, sehingga data yang ditampilkan bersifat dinamis dan tersinkronisasi dengan database. Pada minggu sebelumnya, GUI masih bersifat dasar dan belum menampilkan data secara tabular dari database.

- Kendala yang dihadapi dan cara mengatasinya.  
   Kendala yang dihadapi adalah error kompilasi dan ketidaksesuaian method antara interface dan implementasi DAO. Kendala tersebut diatasi dengan menyamakan nama method, signature, serta memastikan konstruktor dan struktur class sesuai dengan desain yang telah ditentukan.

---

## Kesimpulan
Praktikum Week 13 berhasil mengintegrasikan GUI JavaFX dengan database menggunakan TableView dan pola DAO. Dengan penerapan lambda expression dan pemisahan tanggung jawab antara View, Service, dan DAO, aplikasi menjadi lebih terstruktur, mudah dikembangkan, serta sesuai dengan prinsip pemrograman berorientasi objek dan arsitektur berlapis.

---

