package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.services.dtos.category.requests.AddCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.responses.GetCategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper
{
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryFromAddRequest(AddCategoryRequest request);
    GetCategoryResponse getCategoryResponseFromCategory(Category category);
}