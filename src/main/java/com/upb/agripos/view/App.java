package com.upb.agripos.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("AgriPos Berhasil Jalan!");
        Scene scene = new Scene(new StackPane(label), 400, 300);
        stage.setTitle("AgriPos Test");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}