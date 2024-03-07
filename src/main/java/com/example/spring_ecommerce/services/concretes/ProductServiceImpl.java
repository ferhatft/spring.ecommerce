package com.example.spring_ecommerce.services.concretes;


import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.repositories.abstracts.ProductRepository;
import com.example.spring_ecommerce.services.abstracts.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getByID(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void add(Product product) {
        if (product.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be left blank!");
        }
        if (product.getStock() < 0) {
            throw new IllegalArgumentException("Stock can not be smaller than zero!");
        }
        if (product.getUnitPrice() < 0) {
            throw new IllegalArgumentException("Unit price can not be smaller than zero!");
        }
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        if (product.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be left blank!");
        }
        if (product.getStock() < 0) {
            throw new IllegalArgumentException("Stock can not be smaller than zero!");
        }
        if (product.getUnitPrice() < 0) {
            throw new IllegalArgumentException("Unit price can not be smaller than zero!");
        }
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}

