package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.services.abstracts.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wishlists")
@AllArgsConstructor
public class WishlistController {
    private WishlistService wishlistService;

    @GetMapping
    public List<Wishlist> get() {
        return wishlistService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Wishlist> getByID(@PathVariable int id) {
        return wishlistService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Wishlist wishlist) {
        wishlistService.add(wishlist);
    }

    @PutMapping
    public void update(@RequestBody Wishlist wishlist) {
        wishlistService.update(wishlist);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        wishlistService.delete(id);
    }
}
