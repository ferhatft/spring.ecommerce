package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    List<Wishlist> getAll();

    Optional<Wishlist> getByID(int id);

    void add(Wishlist wishlist);

    void update(Wishlist wishlist);

    void delete(int id);

}
