package com.example.spring_ecommerce.core.types;

public class WishlistNotFoundException extends RuntimeException {
    public WishlistNotFoundException(int wishlistId) {
        super("Wishlist with ID " + wishlistId + " not found");
    }
}
