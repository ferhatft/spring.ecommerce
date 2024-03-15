package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.WishlistNotFoundException;
import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.repositories.abstracts.WishlistRepository;
import com.example.spring_ecommerce.services.abstracts.WishlistService;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.AddWishlistRequest;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.UpdateWishlistRequest;
import com.example.spring_ecommerce.services.dtos.wishlist.responses.GetWishlistResponse;
import com.example.spring_ecommerce.services.dtos.wishlist.responses.WishlistListResponse;
import com.example.spring_ecommerce.services.mappers.WishlistMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;

    @Override
    public List<WishlistListResponse> getAll() {
        List<Wishlist> wishlists = wishlistRepository.findAll();
        List<WishlistListResponse> response = new ArrayList<>();

        for (Wishlist wishlist : wishlists) {
            WishlistListResponse dto = new WishlistListResponse(
                    wishlist.getId(),
                    wishlist.getEditDate(),
                    wishlist.getCurrentPrice(),
                    wishlist.getUser().getFirstName(),
                    wishlist.getUser().getLastName(),
                    wishlist.getProduct().getName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetWishlistResponse> getByID(int id) {
        Wishlist wishlist = findWishlistById(id);
        GetWishlistResponse response = WishlistMapper.INSTANCE.getWishlistResponseFromWishlist(wishlist);
        return Optional.of(response);
    }

    @Override
    public void add(AddWishlistRequest addWishlistRequest) {
        Wishlist wishlist = WishlistMapper.INSTANCE.wishlistFromAddRequest(addWishlistRequest);
        wishlistRepository.save(wishlist);
    }

    @Override
    public void update(UpdateWishlistRequest updateWishlistRequest) {
        Wishlist wishlist = findWishlistById(updateWishlistRequest.getId());

        User user = new User();
        user.setId(updateWishlistRequest.getUserId());
        Product product = new Product();
        product.setId(updateWishlistRequest.getProductId());
        wishlist.setEditDate(updateWishlistRequest.getEditDate());
        wishlist.setCurrentPrice(updateWishlistRequest.getCurrentPrice());
        wishlist.setUser(user);
        wishlist.setProduct(product);
        wishlistRepository.save(wishlist);
    }

    @Override
    public void delete(int id) {
        if (!wishlistRepository.existsById(id)) {
            throw new WishlistNotFoundException(id);
        }
        wishlistRepository.deleteById(id);
    }

    private Wishlist findWishlistById(int id) {
        return wishlistRepository.findById(id)
                .orElseThrow(() -> new WishlistNotFoundException(id));
    }
}
