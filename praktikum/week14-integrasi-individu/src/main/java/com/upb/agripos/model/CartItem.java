package com.upb.agripos.model;

import javafx.beans.property.*;

public class CartItem {
    private final StringProperty item;
    private final IntegerProperty qty;
    private final DoubleProperty subtotal;

    public CartItem(String item, int qty, double subtotal) {
        this.item = new SimpleStringProperty(item);
        this.qty = new SimpleIntegerProperty(qty);
        this.subtotal = new SimpleDoubleProperty(subtotal);
    }

    public StringProperty itemProperty() { return item; }
    public IntegerProperty qtyProperty() { return qty; }
    public DoubleProperty subtotalProperty() { return subtotal; }

    public String getItem() { return item.get(); }
    public int getQty() { return qty.get(); }
    public double getSubtotal() { return subtotal.get(); }
}