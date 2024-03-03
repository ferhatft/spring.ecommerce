package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.ProductCategory;
import com.example.spring_ecommerce.entities.Review;
import jdk.jfr.Category;

import java.util.List;

public interface ProductCategoryRepository {

    List<ProductCategory> getAll();

    ProductCategory getByID(int id);

    ProductCategory update(int id);

    void delete(int id);

    void add(ProductCategory productCategory);

}
