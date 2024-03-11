package com.example.spring_ecommerce.controllers;


import com.example.spring_ecommerce.entities.Brand;
import com.example.spring_ecommerce.services.abstracts.BrandServices;
import com.example.spring_ecommerce.services.dtos.brand.request.AddBrandRequest;
import com.example.spring_ecommerce.services.dtos.brand.request.UpdateBrandRequest;
import com.example.spring_ecommerce.services.dtos.brand.response.ListBrandsResponse;
import com.example.spring_ecommerce.services.dtos.product.requests.AddProductRequest;
import com.example.spring_ecommerce.services.dtos.product.requests.UpdateProductRequest;
import com.example.spring_ecommerce.services.dtos.product.responses.GetProductResponse;
import com.example.spring_ecommerce.services.dtos.product.responses.ProductListResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
public class BrandController {
    private BrandServices brandServices;


    @GetMapping
    public List<ListBrandsResponse> get() {
        return brandServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Brand> getByID(@PathVariable int id) {
        return brandServices.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddBrandRequest request) {
        brandServices.add(request);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateBrandRequest request) {
        brandServices.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        brandServices.delete(id);
    }


}
