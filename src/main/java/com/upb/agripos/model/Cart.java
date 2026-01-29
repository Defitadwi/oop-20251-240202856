// File: src/main/java/com/upb/agripos/model/Cart.java
package com.upb.agripos.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representasi Keranjang Belanja (Bab 7 & 14)
 */
public class Cart {
    // Menggunakan Collections (List) sesuai aturan Bab 7
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    /**
     * Menghapus semua isi keranjang
     */
    public void clear() {
        this.items.clear();
    }

    /**
     * Mengecek apakah keranjang kosong
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
}