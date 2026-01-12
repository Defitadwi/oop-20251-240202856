package main.java.com.upb.agripos;

public class MainExceptionDemo {
    public static void main(String[] args) {
        // Ganti dengan Nama dan NIM Anda sesuai format di gambar
        System.out.println("Hello, I am [Defita Dwi Wulandary]-[240202856] (Week9)");

        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product("P01", "Pupuk Organik", 25000, 3);

        // Skenario 1: Invalid Quantity (Quantity harus lebih dari 0)
        try {
            cart.addProduct(p1, -1);
        } catch (InvalidQuantityException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

        // Skenario 2: Product Not Found (Produk tidak ada dalam keranjang)
        try {
            cart.removeProduct(p1);
        } catch (ProductNotFoundException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }

        // Skenario 3: Insufficient Stock (Stok tidak cukup)
        try {
            // Kita coba tambah 5, padahal stok p1 hanya 3
            cart.addProduct(p1, 5);
            cart.checkout();
        } catch (Exception e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }
}