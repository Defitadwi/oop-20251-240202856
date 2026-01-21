package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void insert(Product p) throws Exception {
        // Validasi bisnis sederhana sesuai Activity Diagram
        if(p.getPrice() < 0) throw new Exception("Harga tidak boleh negatif!");
        productDAO.insert(p);
    }

    public List<Product> findAll() throws Exception {
        return productDAO.findAll();
    }
}