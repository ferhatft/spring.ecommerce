package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.services.dtos.review.requests.AddReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.responses.GetReviewResponse;
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

    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "product.name", target = "productName")
    GetReviewResponse getReviewResponseFromReview(Review review);
}