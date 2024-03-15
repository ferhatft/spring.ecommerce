package com.example.spring_ecommerce.services.mappers;

import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.services.dtos.like.request.AddLikeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LikesMapper {

    LikesMapper INSTANCE = Mappers.getMapper(LikesMapper.class);

    Likes likesFromAddRequest(AddLikeRequest request);
}
