package com.example.spring_ecommerce.services.mappers;


import com.example.spring_ecommerce.entities.Role;
import com.example.spring_ecommerce.services.dtos.role.requests.AddRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.responses.GetRoleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoleMapper
{
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role roleFromAddRequest(AddRoleRequest request);
    GetRoleResponse getRoleResponseFromRole(Role role);
}