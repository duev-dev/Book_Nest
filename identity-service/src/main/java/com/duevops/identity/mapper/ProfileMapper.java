package com.duevops.identity.mapper;

import com.duevops.identity.dto.request.ProfileCreationRequest;
import com.duevops.identity.dto.request.UserCreationRequest;
import com.duevops.identity.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
