package com.upb.agripos;

import com.upb.agripos.dao.*;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.controller.ProductController;
import com.upb.agripos.view.ProductFormView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;

public class AppJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // 1. Koneksi Database
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/agripos", "postgres", "defita");

            // 2. Inisialisasi Layer (DIP/SOLID)
            ProductDAO dao = new ProductDAOImpl(conn);
            ProductService service = new ProductService(dao);
            ProductController controller = new ProductController(service);

            // 3. Tampilkan GUI
            ProductFormView root = new ProductFormView(controller);
            Scene scene = new Scene(root, 450, 550);

            primaryStage.setTitle("Agri-POS Week 12 - [Defita Dwi Wulandary]");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}