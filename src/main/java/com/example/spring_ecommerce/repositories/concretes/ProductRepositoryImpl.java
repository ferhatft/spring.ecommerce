package com.example.spring_ecommerce.repositories.concretes;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.repositories.abstracts.ProductsRepository;
import jdk.jfr.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductsRepository {

    private List<Product> products = new ArrayList<>();


    @Override
    public List<Product> getAll() {
        return products;
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
    public void add(Category category) {

    }
}
