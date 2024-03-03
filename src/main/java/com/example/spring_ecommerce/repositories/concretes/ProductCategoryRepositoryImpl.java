package com.example.spring_ecommerce.repositories.concretes;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.ProductCategory;
import com.example.spring_ecommerce.repositories.abstracts.ProductCategoryRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryRepositoryImpl implements ProductCategoryRepository
{

    List <ProductCategory> productCategories = new ArrayList<>();
    @Override
    public List<ProductCategory> getAll() {
        return null;
    }

    @Override
    public ProductCategory getByID(int id) {
        return null;
    }

    @Override
    public ProductCategory update(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(ProductCategory productCategory) {

    }
}
