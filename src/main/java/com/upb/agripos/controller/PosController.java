// File: src/main/java/com/upb/agripos/controller/PosController.java
package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PosController {
    @FXML private TableView<Product> tableProducts;
    @FXML private TableColumn<Product, String> colCode, colName;
    @FXML private TableColumn<Product, Double> colPrice;
    @FXML private TextField txtCode, txtName, txtPrice, txtStock;

    private final ProductService productService = new ProductService();

    @FXML
    public void initialize() {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        refreshTable();
    }

    @FXML
    private void handleAddProduct() {
        try {
            if(txtCode.getText().isEmpty()) throw new Exception("Kode wajib diisi!");
            Product p = new Product(txtCode.getText(), txtName.getText(), 
                        Double.parseDouble(txtPrice.getText()), Integer.parseInt(txtStock.getText()));
            productService.addProduct(p);
            refreshTable();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void refreshTable() {
        tableProducts.setItems(FXCollections.observableArrayList(productService.getAllProducts()));
    }
}