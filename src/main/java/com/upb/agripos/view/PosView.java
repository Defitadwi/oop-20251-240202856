package com.upb.agripos.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PosView extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Jika kamu pakai FXML, arahkan ke file .fxml kamu
        // Jika belum ada FXML, kita pakai Label sederhana dulu untuk tes
        try {
            // Ganti "main.fxml" dengan nama file fxml kamu jika ada
            // Parent root = FXMLLoader.load(getClass().getResource("/com/upb/agripos/view/main.fxml"));
            
            // Kode cadangan tanpa FXML (untuk tes apakah window muncul):
            javafx.scene.control.Label label = new javafx.scene.control.Label("GUI AgriPos Berhasil Muncul!");
            Scene scene = new Scene(new javafx.scene.layout.StackPane(label), 640, 480);
            
            stage.setTitle("AgriPos Application");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}