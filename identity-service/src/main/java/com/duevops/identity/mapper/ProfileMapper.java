package com.duevops.identity.mapper;

import org.mapstruct.Mapper;

import com.duevops.identity.dto.request.ProfileCreationRequest;
import com.duevops.identity.dto.request.UserCreationRequest;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
