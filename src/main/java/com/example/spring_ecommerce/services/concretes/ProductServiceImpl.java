package com.example.spring_ecommerce.services.concretes;


import com.example.spring_ecommerce.core.types.BusinessException;
import com.example.spring_ecommerce.entities.Brand;
import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.repositories.abstracts.ProductRepository;
import com.example.spring_ecommerce.services.abstracts.ProductService;
import com.example.spring_ecommerce.services.dtos.product.requests.AddProductRequest;
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
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    private void productWithSameNameShouldNotExists(String name)
    {
        Optional<Product> productWithSameName =
                productRepository.findByName(name);
        if(productWithSameName.isPresent())
            throw new BusinessException("Aynı isimde 2. ürün eklenemez");
    }
}

