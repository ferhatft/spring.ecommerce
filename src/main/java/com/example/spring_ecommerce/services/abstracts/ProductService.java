package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getByID(int id);

    void add(Product product);

    void update(Product product);

    void delete(int id);

}
