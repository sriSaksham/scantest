package com.reader.scanner.service;

import com.reader.scanner.model.Cart;
import com.reader.scanner.model.CartItem;
import com.reader.scanner.model.Product;
import com.reader.scanner.repository.CartRepository;
import com.reader.scanner.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<CartItem> getCartItems(Cart cart) {
        return cart.getItems();
    }
//public List<CartItem> getCartItems(Cart cart) {
//    return cart.getItems().stream()
//            .map(item -> new CartItem(item.getRfid(), item.getProductId(), item.getName(), item.getPrice(), item.getWeight())) // Map weight
//            .toList();
//}

    public void addItemToCart(Cart cart, Product product) {
        cart.addItem(product);
        productRepository.save(product);
    }

    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }


    public void clearCart(Cart cart) {
        cart.getItems().clear();
        cart.setTotal(0);
        cart.setTotalWeight(0);  // Reset totalWeight
        saveCart(cart);
    }
//    public void clearCart(Cart cart) {
//        cart.getItems().clear();
//        saveCart(cart);
//    }

    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    public String generateCartId() {
        return UUID.randomUUID().toString();
    }
}
