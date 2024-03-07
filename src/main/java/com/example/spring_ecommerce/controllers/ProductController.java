package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.services.abstracts.ProductService;
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
    public List<Product> get() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getByID(@PathVariable int id) {
        return productService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }
}
