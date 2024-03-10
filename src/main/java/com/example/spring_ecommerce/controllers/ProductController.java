package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.services.abstracts.ProductService;

import com.example.spring_ecommerce.services.dtos.product.requests.AddProductRequest;
import com.example.spring_ecommerce.services.dtos.product.requests.UpdateProductRequest;
import com.example.spring_ecommerce.services.dtos.product.responses.GetProductResponse;
import com.example.spring_ecommerce.services.dtos.product.responses.ProductListResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public List<ProductListResponse> get() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetProductResponse> getByID(@PathVariable int id) {
        return productService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddProductRequest addProductRequest) {
        productService.add(addProductRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateProductRequest updateProductRequest) {
        productService.update(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }
}

