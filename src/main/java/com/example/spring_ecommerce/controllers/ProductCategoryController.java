package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.ProductCategory;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.services.abstracts.ProductCategoryService;
import com.example.spring_ecommerce.services.abstracts.ProductService;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productcategories")
public class ProductCategoryController {
    private ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping(value = "/create/")
    public void add(@RequestBody Category category) {
        productCategoryService.add(category);
    }

    @GetMapping
    public List<ProductCategory> get() {
        return productCategoryService.getAll();
    }

    @PutMapping(value = "/update/{id}")
    public ProductCategory update(@PathVariable("id") int id, @RequestBody Category category) {

        ProductCategory updatedCategory = productCategoryService.update(id, category);

        return updatedCategory;
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        productCategoryService.delete(id);
    }
}
