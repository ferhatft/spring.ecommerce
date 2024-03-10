package com.example.spring_ecommerce.services.concretes;


import com.example.spring_ecommerce.core.types.BusinessException;
import com.example.spring_ecommerce.entities.Brand;
import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.repositories.abstracts.ProductRepository;
import com.example.spring_ecommerce.services.abstracts.ProductService;
import com.example.spring_ecommerce.services.dtos.product.requests.AddProductRequest;
import com.example.spring_ecommerce.services.dtos.product.requests.UpdateProductRequest;
import com.example.spring_ecommerce.services.dtos.product.responses.GetProductResponse;
import com.example.spring_ecommerce.services.dtos.product.responses.ProductListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public List<ProductListResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<ProductListResponse> response = new ArrayList<>();

        for (Product product: products) {
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

        Category category = new Category();
        category.setId(request.getCategoryId());


        Brand brand = new Brand();
        brand.setId(request.getBrandId());

        // Mapping -> Manual
        // TODO: Auto Mapping
        Product product = new Product();
        product.setName(request.getName());
        product.setStock(request.getStock());
        product.setUnitPrice(request.getUnitPrice());
        product.setCategory(category);
        product.setBrand(brand);


        productRepository.save(product);

    }

    @Override
    public void update(UpdateProductRequest request) {
        Product product = productRepository.findById(request.getId()).orElse(null);

        if (product == null) {
            // TODO Handle product not found (e.g., log a warning or throw a custom exception later)
            return;
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

    private void productWithSameNameShouldNotExists(String name) {
        Optional<Product> productWithSameName =
                productRepository.findByName(name);
        if (productWithSameName.isPresent())
            throw new BusinessException("Aynı isimde 2. ürün eklenemez");
    }
}

