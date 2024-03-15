package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.Wishlist;
import com.example.spring_ecommerce.services.dtos.wishlist.requests.AddWishlistRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WishlistMapper
{
    WishlistMapper INSTANCE = Mappers.getMapper(WishlistMapper.class);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "productId", target = "product.id")
    Wishlist wishlistFromAddRequest(AddWishlistRequest request);
}