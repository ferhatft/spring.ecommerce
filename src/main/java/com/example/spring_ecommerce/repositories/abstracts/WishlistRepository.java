package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}