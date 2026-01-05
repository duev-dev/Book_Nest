package com.duevops.identity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.duevops.identity.dto.request.RoleRequest;
import com.duevops.identity.dto.response.RoleResponse;
import com.duevops.identity.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
