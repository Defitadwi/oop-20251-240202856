package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    // Digunakan oleh ProductController.loadData()
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    // Digunakan oleh Lambda Expression pada tombol Hapus
    public void delete(String code) {
        if (code != null && !code.isEmpty()) {
            productDAO.delete(code);
        }
    }
}