package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.List;

public interface ProductDAO {
    List<Product> getAll();
    void insert(Product p);
    void update(Product p);
    void delete(String id);
}