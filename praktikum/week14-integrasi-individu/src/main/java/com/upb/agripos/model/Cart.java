package com.upb.agripos.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();
    private double totalPrice = 0;

    // Gunakan Map agar bisa getOrDefault
    public Map<Product, Integer> getItems() { return items; }
    
    public double getTotalPrice() { return totalPrice; }
    
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
}