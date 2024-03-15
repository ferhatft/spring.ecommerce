package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.CartProducts;
import com.example.spring_ecommerce.services.abstracts.CartProductsService;
import com.example.spring_ecommerce.services.dtos.cartProduct.request.AddCartProductRequest;
import com.example.spring_ecommerce.services.dtos.cartProduct.request.UpdateCartProductRequest;
import com.example.spring_ecommerce.services.dtos.cartProduct.response.ListCartProductsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart_products")
@AllArgsConstructor
public class CartProductController {
    private CartProductsService cartProductService;


    @GetMapping
    public List<ListCartProductsResponse> get() {
        return cartProductService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CartProducts> getByID(@PathVariable int id) {
        return cartProductService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCartProductRequest request) {
        cartProductService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCartProductRequest request) {
        cartProductService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cartProductService.delete(id);
    }

}
