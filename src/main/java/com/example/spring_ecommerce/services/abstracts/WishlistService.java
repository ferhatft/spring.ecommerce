package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.AddWishlistRequest;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.UpdateWishlistRequest;

import java.util.List;
import java.util.Optional;

public interface WishlistService {
    List<Wishlist> getAll();

    Optional<Wishlist> getByID(int id);

    void add(AddWishlistRequest addWishlistRequest);

    void update(UpdateWishlistRequest updateWishlistRequest);

    void delete(int id);

}
