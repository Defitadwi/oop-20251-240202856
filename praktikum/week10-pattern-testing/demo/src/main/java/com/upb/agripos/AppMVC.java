package com.upb.agripos;

import com.upb.agripos.config.DatabaseConnection;
import com.upb.agripos.model.Product;
import com.upb.agripos.view.ConsoleView;
import com.upb.agripos.controller.ProductController;

public class AppMVC {

    public static void main(String[] args) {

        System.out.println("Hello, I am [Defita Dwi Wulandary]-[240202856] (Week 10)");

        // Singleton test
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("Singleton works: " + (db1 == db2));

        // MVC
        Product product = new Product("P01", "Pupuk Organik");
        ConsoleView view = new ConsoleView();
        ProductController controller = new ProductController(product, view);

        controller.showProduct();
    }
}
