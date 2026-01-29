package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.List;
import java.util.ArrayList;

public class JdbcProductDAO implements ProductDAO {

    @Override
    public List<Product> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void insert(Product product) {
        System.out.println("Produk berhasil ditambah");
    }

    @Override
    public void update(Product product) {
        System.out.println("Produk berhasil diupdate");
    }

    @Override
    public void delete(String id) {
        System.out.println("Produk dengan ID " + id + " dihapus");
    }
    
    // Jika di ProductDAO ada method lain, tambahkan di sini dengan @Override
}