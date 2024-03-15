package com.example.spring_ecommerce.services.concretes;


import com.example.spring_ecommerce.core.types.BusinessException;
import com.example.spring_ecommerce.core.types.ProductNotFoundException;
import com.example.spring_ecommerce.entities.Brand;
import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.repositories.abstracts.ProductRepository;
import com.example.spring_ecommerce.services.abstracts.ProductService;

import com.example.spring_ecommerce.services.dtos.product.requests.AddProductRequest;
import com.example.spring_ecommerce.services.dtos.product.requests.UpdateProductRequest;
import com.example.spring_ecommerce.services.dtos.product.responses.GetMostSoldProductResponse;
import com.example.spring_ecommerce.services.dtos.product.responses.GetProductResponse;
import com.example.spring_ecommerce.services.dtos.product.responses.ProductListResponse;

import com.example.spring_ecommerce.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductListResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductListResponse> response = new ArrayList<>();

        for (Product product : products) {
            ProductListResponse dto = new ProductListResponse(
                    product.getId(),
                    product.getName(),
                    product.getStock(),
                    product.getUnitPrice(),
                    product.getCategory().getName(),
                    product.getBrand().getName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetProductResponse> getByID(int id) {
        Product product = productRepository.findById(id).orElse(null);

        assert product != null;
        return Optional.of(new GetProductResponse(
                product.getId(),
                product.getName(),
                product.getStock(),
                product.getUnitPrice(),
                product.getCategory().getName(),
                product.getBrand().getName()));
    }

    @Override
    public void add(AddProductRequest request) {
        productWithSameNameShouldNotExists(request.getName());
        Product product = ProductMapper.INSTANCE.productFromAddRequest(request);
        productRepository.save(product);
    }

    @Override
    public void update(UpdateProductRequest request) {
        Product product = productRepository.findById(request.getId()).orElse(null);

        if (product == null) {
            throw new ProductNotFoundException(request.getId());
        }

        Category category = new Category();
        category.setId(request.getCategoryId());
        Brand brand = new Brand();
        brand.setId(request.getBrandId());
        product.setName(request.getName());
        product.setStock(request.getStock());
        product.setUnitPrice(request.getUnitPrice());
        product.setCategory(category);
        product.setBrand(brand);

        productRepository.save(product);

    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public GetMostSoldProductResponse findMostSoldProductLastMonth() {
        List<Object[]> result = productRepository.findMostSoldProductLastMonth();
        if (!result.isEmpty()) {
            Object[] row = result.get(0);
            String name = (String) row[0];
            LocalDateTime orderDate = null;
            Object dateObject = row[1];
            if (dateObject != null) {
                if (dateObject instanceof String) {
                    // Parse the string to LocalDateTime
                    orderDate = LocalDateTime.parse((String) dateObject);
                } else if (dateObject instanceof Timestamp) {
                    orderDate = ((Timestamp) dateObject).toLocalDateTime();
                } else if (dateObject instanceof Instant) {
                    orderDate = ((Instant) dateObject).atZone(ZoneId.systemDefault()).toLocalDateTime();
                } else {
                    // Log the actual type of dateObject
                    System.out.println("Unexpected type for order date: " + dateObject.getClass().getName());
                }
            }
            Long soldProductCount = (Long) row[2];
            return new GetMostSoldProductResponse(name, orderDate, soldProductCount);
        }
        return null;
    }

    @Override
    public List<Object[]> findIdAndName() {
        return productRepository.findIdAndName();
    }

    @Override
    public List<Product> findByUnitPriceGreaterThanOrStockGreaterThan(int i, int i1) {
        return productRepository.findByUnitPriceGreaterThanOrStockGreaterThan(200, 2);
    }

    @Override
    public List<Product> findByUnitPriceBetween(double minPrice, double maxPrice) {
        return productRepository.findByUnitPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Product> findByUnitPriceGreaterThanAvg() {
        return productRepository.findByUnitPriceGreaterThanAvg();
    }

    @Override
    public List<Product> findByCategoryName(String books) {
        return productRepository.findByCategoryName(books);
    }


    private void productWithSameNameShouldNotExists(String name) {
        Optional<Product> productWithSameName =
                productRepository.findByName(name);
        if (productWithSameName.isPresent())
            throw new BusinessException("A second product with the same name cannot be added");
    }
}

