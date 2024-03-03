package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.services.abstracts.ProductService;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/create/")
    public void add(@RequestBody Product product, Category category) {
        productService.add(product, category);
    }

    @GetMapping
    public List<Product> get() {
        return productService.getAll();
    }

    @PutMapping(value = "/update/{id}")
    public Product update(@PathVariable("id") int id, @RequestBody Product product, Category category, Review review) {

        Product updatedProduct = productService.update(id, product, category, review);

        return updatedProduct;
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        productService.delete(id);
    }
}
