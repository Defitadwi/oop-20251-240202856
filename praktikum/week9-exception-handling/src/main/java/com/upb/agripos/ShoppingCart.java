package main.java.com.upb.agripos;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p, int qty) throws InvalidQuantityException {
        if (qty <= 0) {
            throw new InvalidQuantityException("Jumlah beli '" + p.getName() + "' harus lebih dari 0!");
        }
        items.put(p, items.getOrDefault(p, 0) + qty);
    }

    public void removeProduct(Product p) throws ProductNotFoundException {
        if (!items.containsKey(p)) {
            throw new ProductNotFoundException("Gagal menghapus: Produk tidak ditemukan di keranjang.");
        }
        items.remove(p);
    }

    public void checkout() throws InsufficientStockException {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            if (entry.getKey().getStock() < entry.getValue()) {
                throw new InsufficientStockException("Stok '" + entry.getKey().getName() + "' tidak mencukupi.");
            }
        }
        // Jika semua stok aman, kurangi stok
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceStock(entry.getValue());
        }
        System.out.println("Checkout Berhasil!");
    }
}