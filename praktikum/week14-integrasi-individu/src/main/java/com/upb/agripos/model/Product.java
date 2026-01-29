package com.upb.agripos.model;

import javafx.beans.property.*;

public class Product {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty category;
    private final DoubleProperty price;
    private final IntegerProperty stock;

    public Product(String id, String name, String category, double price, int stock) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
    }

    // Property Getters (Wajib untuk TableView)
    public StringProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public StringProperty categoryProperty() { return category; }
    public DoubleProperty priceProperty() { return price; }
    public IntegerProperty stockProperty() { return stock; }

    // Getters Biasa (Wajib untuk DAO)
    public String getId() { return id.get(); }
    public String getName() { return name.get(); }
    public String getCategory() { return category.get(); }
    public double getPrice() { return price.get(); }
    public int getStock() { return stock.get(); }
}