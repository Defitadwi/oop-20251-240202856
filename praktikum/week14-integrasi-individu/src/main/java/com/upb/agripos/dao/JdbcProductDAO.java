package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDAO implements ProductDAO {
    private final String url = "jdbc:mysql://localhost:3306/agripos_db";
    private final String user = "root";
    private final String pass = "";

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {
            while (rs.next()) {
                products.add(new Product(rs.getString("id"), rs.getString("name"), 
                             rs.getString("category"), rs.getDouble("price"), rs.getInt("stock")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return products;
    }

    @Override
    public void insert(Product p) {
        String sql = "INSERT INTO products VALUES (?, ?, ?, ?, ?)";
        executeSql(sql, p.getId(), p.getName(), p.getCategory(), p.getPrice(), p.getStock());
    }

    @Override
    public void update(Product p) {
        String sql = "UPDATE products SET name=?, category=?, price=?, stock=? WHERE id=?";
        executeSql(sql, p.getName(), p.getCategory(), p.getPrice(), p.getStock(), p.getId());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM products WHERE id=?";
        executeSql(sql, id);
    }

    private void executeSql(String sql, Object... params) {
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}