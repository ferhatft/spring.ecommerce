package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.ProductCategory;
import com.example.spring_ecommerce.repositories.abstracts.ProductsRepository;
import com.example.spring_ecommerce.services.abstracts.ProductCategoryService;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService
{

    private ProductsRepository productsRepository;

    public ProductCategoryServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }

    @Override
    public ProductCategory getByID(int id) {
        return null;
    }

    @Override
    public ProductCategory update(int id, Category category) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Category category) {
        productsRepository.add(category);


    }
}
