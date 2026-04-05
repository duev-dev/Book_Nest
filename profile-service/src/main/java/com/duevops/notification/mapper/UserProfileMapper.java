package com.duevops.notification.mapper;

import org.mapstruct.Mapper;

import com.duevops.notification.dto.request.ProfileCreationRequest;
import com.duevops.notification.dto.response.UserProfileResponse;
import com.duevops.notification.entity.UserProfiles;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfiles toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfiles userProfiles);
}
