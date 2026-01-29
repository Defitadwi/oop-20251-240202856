package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.List;

public interface ProductDAO {
    void insert(Product product);
    void delete(String code);
    List<Product> getAll();
    void update(Product product);
}