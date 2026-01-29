package com.upb.agripos.service;

import com.upb.agripos.model.Cart;
import com.upb.agripos.model.Product;

public class CartService {
    private Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public void addItem(Product product, int qty) {
        // Sekarang getOrDefault akan berfungsi karena items adalah Map
        int currentQty = cart.getItems().getOrDefault(product, 0);
        cart.getItems().put(product, currentQty + qty);
        
        double newTotal = cart.getTotalPrice() + (product.getPrice() * qty);
        cart.setTotalPrice(newTotal);
    }

    public void clearCart() {
        cart.getItems().clear();
        cart.setTotalPrice(0);
    }
}