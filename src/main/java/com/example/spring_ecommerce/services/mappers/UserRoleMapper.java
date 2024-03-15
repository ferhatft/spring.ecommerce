package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.UserRole;
import com.example.spring_ecommerce.services.dtos.userrole.requests.AddUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.responses.GetUserRoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRoleMapper
{
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roleId", target = "role.id")
    UserRole userRoleFromAddRequest(AddUserRoleRequest request);

    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "role.name", target = "roleName")
    GetUserRoleResponse getUserRoleResponseFromUserRole(UserRole userRole);
}