package com.upb.agripos;

import com.upb.agripos.model.Cart;
import com.upb.agripos.model.Product;
import com.upb.agripos.service.CartService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {
    @Test
    public void testCartOperations() {
        Cart cart = new Cart();
        CartService service = new CartService(cart);
        Product p = new Product("1", "Pupuk", "Tani", 10000, 10);
        
        service.addItem(p, 2);
        assertEquals(1, cart.getItems().size());
        assertEquals(20000, cart.getTotalPrice());
    }
}