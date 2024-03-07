package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.repositories.abstracts.WishlistRepository;
import com.example.spring_ecommerce.services.abstracts.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WishlistServiceImpl implements WishlistService {

    private WishlistRepository wishlistRepository;

    @Override
    public List<Wishlist> getAll() {
        return wishlistRepository.findAll();
    }

    @Override
    public Optional<Wishlist> getByID(int id) {
        return wishlistRepository.findById(id);
    }

    @Override
    public void add(Wishlist wishlist) {
        if (wishlist.getCurrentPrice() < 0) {
            throw new IllegalArgumentException("Current price can not be smaller than zero!");
        }
        wishlistRepository.save(wishlist);
    }

    @Override
    public void update(Wishlist wishlist) {
        if (wishlist.getCurrentPrice() < 0) {
            throw new IllegalArgumentException("Current price can not be smaller than zero!");
        }
        wishlistRepository.save(wishlist);
    }

    @Override
    public void delete(int id) {
        wishlistRepository.deleteById(id);
    }
}
