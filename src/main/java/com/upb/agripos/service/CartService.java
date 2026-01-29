// File: src/main/java/com/upb/agripos/service/CartService.java
package com.upb.agripos.service;

import com.upb.agripos.model.CartItem;
import com.upb.agripos.exception.AppException;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    // Menggunakan Collections (List) untuk menyimpan item keranjang
    private List<CartItem> cartItems = new ArrayList<>();

    /**
     * Menambahkan item ke keranjang dengan validasi Exception (Bab 9)
     */
    public void addItem(CartItem item) throws AppException {
        if (item.getQuantity() <= 0) {
            throw new AppException("Jumlah beli minimal 1!");
        }
        
        // Logika: Jika produk sudah ada, tambahkan quantity-nya saja
        for (CartItem existingItem : cartItems) {
            if (existingItem.getProduct().getCode().equals(item.getProduct().getCode())) {
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        
        cartItems.add(item);
    }

    /**
     * Menghitung total belanja dari seluruh isi keranjang
     */
    public double calculateTotal() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
}