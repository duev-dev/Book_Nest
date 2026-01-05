package com.duevops.identity.mapper;

import org.mapstruct.Mapper;

import com.duevops.identity.dto.request.PermissionRequest;
import com.duevops.identity.dto.response.PermissionResponse;
import com.duevops.identity.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
