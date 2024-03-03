package com.example.spring_ecommerce.services.concretes;


import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.repositories.abstracts.ProductsRepository;
import com.example.spring_ecommerce.services.abstracts.ProductService;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductsRepository productsRepository;

    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Product> getAll() {
        return productsRepository.getAll();
    }

    @Override
    public Product getByID(int id) {
        return null;
    }

    @Override
    public Product update(int id, Product product, Category category, Review review) {
        return null;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Product product, Category category) {

    }
}

