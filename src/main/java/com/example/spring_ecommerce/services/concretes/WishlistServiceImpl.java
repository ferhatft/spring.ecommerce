package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.repositories.abstracts.WishlistRepository;
import com.example.spring_ecommerce.services.abstracts.WishlistService;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.AddWishlistRequest;
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
