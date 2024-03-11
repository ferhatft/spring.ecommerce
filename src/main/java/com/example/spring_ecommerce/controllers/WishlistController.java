package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.services.abstracts.WishlistService;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.AddWishlistRequest;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.UpdateWishlistRequest;
import com.example.spring_ecommerce.services.dtos.wishlist.responses.GetWishlistResponse;
import com.example.spring_ecommerce.services.dtos.wishlist.responses.WishlistListResponse;
import jakarta.validation.Valid;
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
    public List<WishlistListResponse> get() {
        return wishlistService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetWishlistResponse> getByID(@PathVariable int id) {
        return wishlistService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddWishlistRequest addWishlistRequest) {
        wishlistService.add(addWishlistRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateWishlistRequest updateWishlistRequest) {
        wishlistService.update(updateWishlistRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        wishlistService.delete(id);
    }
}
