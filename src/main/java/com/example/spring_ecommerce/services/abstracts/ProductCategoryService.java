package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.ProductCategory;
import jdk.jfr.Category;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAll();

    ProductCategory getByID(int id);

    ProductCategory update(int id, Category category);

    void delete(int id);

    void add(Category category);
}
