package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductTableView;
import javafx.collections.FXCollections;

public class ProductController {
    private ProductTableView view;
    private ProductService productService;

    public ProductController(ProductTableView view, ProductService service) {
        this.view = view;
        this.productService = service;
        initComponents();
    }

    private void initComponents() {
        // Event Handling menggunakan Lambda Expression
        view.getBtnDelete().setOnAction(e -> {
            Product selected = view.getTable().getSelectionModel().getSelectedItem();
            if (selected != null) {
                // Alur: View -> Controller -> Service -> DAO
                productService.delete(selected.getCode());
                loadData(); 
            } else {
                System.out.println("Pilih produk yang ingin dihapus!");
            }
        });

        view.getBtnAdd().setOnAction(e -> {
            System.out.println("Navigasi ke form tambah produk...");
            // Logika tambah produk sesuai Use Case UC-02
        });
    }

    public void loadData() {
        // Mengambil data dari DAO melalui Service
        view.getTable().setItems(FXCollections.observableArrayList(productService.findAll()));
    }
}