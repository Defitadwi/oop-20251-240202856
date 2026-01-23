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