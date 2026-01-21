package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Metode ini dipanggil saat tombol Tambah diklik
    public void addProduct(String code, String name, String priceStr, String stockStr) throws Exception {
        // Validasi format angka
        double price = Double.parseDouble(priceStr);
        int stock = Integer.parseInt(stockStr);
        
        Product p = new Product(code, name, price, stock);
        productService.insert(p); // Meneruskan ke Service
    }

    // Mengambil data untuk ditampilkan di ListView
    public ObservableList<String> getProductList() throws Exception {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Product p : productService.findAll()) {
            items.add(p.getCode() + " - " + p.getName() + " (Rp" + p.getPrice() + ")");
        }
        return items;
    }
}