package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.JdbcProductDAO;
import com.upb.agripos.model.Product;
import com.upb.agripos.exception.AppException;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = new JdbcProductDAO();

    public void addProduct(Product product) throws AppException {
        // Validasi Exception (Bab 9)
        if (product.getCode().isEmpty()) throw new AppException("Kode produk tidak boleh kosong!");
        if (product.getPrice() < 0) throw new AppException("Harga tidak boleh negatif!");
        
        productDAO.insert(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    public void deleteProduct(String code) {
        productDAO.delete(code);
    }
}