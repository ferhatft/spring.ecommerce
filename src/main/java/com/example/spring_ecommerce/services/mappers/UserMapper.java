package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.services.dtos.user.requests.AddUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userFromAddRequest(AddUserRequest request);
}