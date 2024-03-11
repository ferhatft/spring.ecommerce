package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Cart;
import com.example.spring_ecommerce.services.abstracts.CartService;
import com.example.spring_ecommerce.services.dtos.cart.request.AddCartRequest;
import com.example.spring_ecommerce.services.dtos.cart.request.UpdateCartRequest;
import com.example.spring_ecommerce.services.dtos.cart.response.ListCartsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
@AllArgsConstructor
public class CartController {
    private CartService cartService;


    @GetMapping
    public List<ListCartsResponse> get() {
        return cartService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Cart> getByID(@PathVariable int id) {
        return cartService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddCartRequest request) {
        cartService.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateCartRequest request) {
        cartService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        cartService.delete(id);
    }
}
