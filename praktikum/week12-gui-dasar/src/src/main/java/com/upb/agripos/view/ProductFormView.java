package com.upb.agripos.view;

import com.upb.agripos.controller.ProductController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ProductFormView extends VBox {
    private TextField txtCode = new TextField();
    private TextField txtName = new TextField();
    private TextField txtPrice = new TextField();
    private TextField txtStock = new TextField();
    private Button btnAdd = new Button("Tambah Produk");
    private ListView<String> listView = new ListView<>();
    private ProductController controller;

    public ProductFormView(ProductController controller) {
        this.controller = controller;
        this.setPadding(new Insets(20));
        this.setSpacing(10);

        // Form Layout
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10);
        grid.add(new Label("Kode:"), 0, 0); grid.add(txtCode, 1, 0);
        grid.add(new Label("Nama:"), 0, 1); grid.add(txtName, 1, 1);
        grid.add(new Label("Harga:"), 0, 2); grid.add(txtPrice, 1, 2);
        grid.add(new Label("Stok:"), 0, 3); grid.add(txtStock, 1, 3);

        this.getChildren().addAll(new Label("FORM INPUT PRODUK"), grid, btnAdd, 
                                  new Label("DAFTAR STOK:"), listView);

        // Event Handler sesuai Sequence Diagram
        btnAdd.setOnAction(e -> handleAdd());
        
        refreshList(); // Load data awal
    }

    private void handleAdd() {
        try {
            controller.addProduct(txtCode.getText(), txtName.getText(), 
                                  txtPrice.getText(), txtStock.getText());
            refreshList();
            clearForm();
            new Alert(Alert.AlertType.INFORMATION, "Data Berhasil Disimpan!").show();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, "Error: " + ex.getMessage()).show();
        }
    }

    private void refreshList() {
        try {
            listView.setItems(controller.getProductList());
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void clearForm() {
        txtCode.clear(); txtName.clear(); txtPrice.clear(); txtStock.clear();
    }
}