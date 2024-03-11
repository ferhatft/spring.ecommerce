package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Cart;
import com.example.spring_ecommerce.services.dtos.cart.request.AddCartRequest;
import com.example.spring_ecommerce.services.dtos.cart.request.UpdateCartRequest;
import com.example.spring_ecommerce.services.dtos.cart.response.ListCartsResponse;

import java.util.List;
import java.util.Optional;

public interface CartService {
    List<ListCartsResponse> getAll();

    Optional<Cart> getByID(int id);

    void add(AddCartRequest request);

    void update(UpdateCartRequest request);

    void delete(int id);
}
