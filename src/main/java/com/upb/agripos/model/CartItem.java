// File: src/main/java/com/upb/agripos/model/CartItem.java
package com.upb.agripos.model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getter untuk mendapatkan data produk
    public Product getProduct() {
        return product;
    }

    // Getter untuk mendapatkan jumlah beli
    public int getQuantity() {
        return quantity;
    }

    // Setter untuk mengubah jumlah jika diperlukan
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Menghitung subtotal per item (Harga Produk * Jumlah)
     * Digunakan untuk fitur 'Hitung total belanja'
     */
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}