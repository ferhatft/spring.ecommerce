package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.services.dtos.review.requests.AddReviewRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper
{
    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "userId", target = "user.id")
    Review reviewFromAddRequest(AddReviewRequest request);
}