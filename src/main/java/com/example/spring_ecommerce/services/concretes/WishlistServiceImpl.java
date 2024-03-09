package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.repositories.abstracts.WishlistRepository;
import com.example.spring_ecommerce.services.abstracts.WishlistService;
import com.example.spring_ecommerce.services.dtos.user.requests.UpdateUserRequest;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.AddWishlistRequest;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.UpdateWishlistRequest;
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
    public void add(AddWishlistRequest addWishlistRequest) {
        User user = new User();
        user.setId(addWishlistRequest.getUserId());
        Product product=new Product();
        product.setId(addWishlistRequest.getProductId());
        Wishlist wishlist = new Wishlist();
        wishlist.setEditDate(addWishlistRequest.getEditDate());
        wishlist.setCurrentPrice(addWishlistRequest.getCurrentPrice());
        wishlist.setUser(user);
        wishlist.setProduct(product);
        wishlistRepository.save(wishlist);
    }

    @Override
    public void update(UpdateWishlistRequest updateWishlistRequest) {
        Wishlist wishlist = wishlistRepository.findById(updateWishlistRequest.getId()).orElse(null);

        if (wishlist == null) {
            // TODO Handle wishlist not found (e.g., log a warning or throw a custom exception later)
            return;
        }

        User user = new User();
        user.setId(updateWishlistRequest.getUserId());
        Product product=new Product();
        product.setId(updateWishlistRequest.getProductId());
        wishlist.setEditDate(updateWishlistRequest.getEditDate());
        wishlist.setCurrentPrice(updateWishlistRequest.getCurrentPrice());
        wishlist.setUser(user);
        wishlist.setProduct(product);
        wishlistRepository.save(wishlist);
    }

    @Override
    public void delete(int id) {
        wishlistRepository.deleteById(id);
    }
}
