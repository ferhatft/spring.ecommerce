package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.services.dtos.product.requests.AddProductRequest;
import com.example.spring_ecommerce.services.dtos.product.requests.UpdateProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();

    Optional<Product> getByID(int id);

    void add(AddProductRequest request);

    void update(UpdateProductRequest request);

    void delete(int id);

}
