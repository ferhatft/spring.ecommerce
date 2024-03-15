package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.CartProducts;
import com.example.spring_ecommerce.services.dtos.cartProduct.request.AddCartProductRequest;
import com.example.spring_ecommerce.services.dtos.cartProduct.request.UpdateCartProductRequest;
import com.example.spring_ecommerce.services.dtos.cartProduct.response.ListCartProductsResponse;

import java.util.List;
import java.util.Optional;

public interface CartProductsService {

    List<ListCartProductsResponse> getAll();

    Optional<CartProducts> getByID(int id);

    void add(AddCartProductRequest request);

    void update(UpdateCartProductRequest request);

    void delete(int id);

}
