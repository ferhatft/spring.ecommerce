package com.example.spring_ecommerce.services.abstracts;


import com.example.spring_ecommerce.entities.Brand;
import com.example.spring_ecommerce.services.dtos.brand.request.AddBrandRequest;
import com.example.spring_ecommerce.services.dtos.brand.request.UpdateBrandRequest;
import com.example.spring_ecommerce.services.dtos.brand.response.ListBrandsResponse;
import com.example.spring_ecommerce.services.dtos.category.requests.AddCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.requests.UpdateCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.responses.CategoryListResponse;
import com.example.spring_ecommerce.services.dtos.category.responses.GetCategoryResponse;

import java.util.List;
import java.util.Optional;


public interface BrandServices {
    List<ListBrandsResponse> getAll();

    Optional<Brand> getByID(int id);

    void add(AddBrandRequest request);

    void update(UpdateBrandRequest request);

    void delete(int id);
}
