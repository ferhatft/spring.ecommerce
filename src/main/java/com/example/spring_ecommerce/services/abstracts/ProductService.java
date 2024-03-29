package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Product;

import com.example.spring_ecommerce.services.dtos.product.requests.AddProductRequest;
import com.example.spring_ecommerce.services.dtos.product.requests.UpdateProductRequest;
import com.example.spring_ecommerce.services.dtos.product.responses.GetMostSoldProductResponse;
import com.example.spring_ecommerce.services.dtos.product.responses.GetProductResponse;
import com.example.spring_ecommerce.services.dtos.product.responses.ProductListResponse;


import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductListResponse> getAll();

    Optional<GetProductResponse> getByID(int id);

    void add(AddProductRequest request);

    void update(UpdateProductRequest request);

    void delete(int id);

    GetMostSoldProductResponse findMostSoldProductLastMonth();

    List<Object[]> findIdAndName();

    List<Product> findByUnitPriceGreaterThanOrStockGreaterThan(int i, int i1);

    List<Product> findByUnitPriceBetween(double minPrice, double maxPrice);

    List<Product> findByUnitPriceGreaterThanAvg();

    List<Product> findByCategoryName(String books);
}
