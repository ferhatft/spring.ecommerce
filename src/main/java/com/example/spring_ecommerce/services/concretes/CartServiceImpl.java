package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.CartNotFoundException;
import com.example.spring_ecommerce.core.types.CountryNotFoundException;
import com.example.spring_ecommerce.entities.Cart;
import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.repositories.abstracts.CartRepository;
import com.example.spring_ecommerce.services.abstracts.CartService;
import com.example.spring_ecommerce.services.dtos.cart.request.AddCartRequest;
import com.example.spring_ecommerce.services.dtos.cart.request.UpdateCartRequest;
import com.example.spring_ecommerce.services.dtos.cart.response.ListCartsResponse;
import com.example.spring_ecommerce.services.dtos.category.responses.GetCategoryResponse;
import com.example.spring_ecommerce.services.dtos.country.response.ListCountryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    @Override
    public List<ListCartsResponse> getAll() {
        List<Cart> carts = cartRepository.findAll();

        List<ListCartsResponse> response = new ArrayList<>();

        for (Cart cart : carts) {
            ListCartsResponse listCartsResponse = new ListCartsResponse(
                    cart.getCartdate()
            );

            response.add(listCartsResponse);
        }

        return response;


    }

    @Override
    public Optional<Cart> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddCartRequest request) {
        Cart cart = new Cart();
        cart.setCartdate(request.getCartdate());


        cartRepository.save(cart);
    }

    @Override
    public void update(UpdateCartRequest request) {

        Optional<Cart> optionalCart = cartRepository.findById(request.getId());

        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();

            // Update the country's name with the new name from the request
            cart.setCartdate(request.getCartdate());

            // Save the updated country back to the database
            cartRepository.save(cart);
        } else {
            // Handle the case where the country with the provided ID doesn't exist
            throw new CartNotFoundException("Cart NOt found with ID: " + request.getId());
        }

    }

    @Override
    public void delete(int id) {

    }
}
