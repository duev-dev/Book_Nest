package com.duevops.profile.mapper;

import org.mapstruct.Mapper;

import com.duevops.profile.dto.request.ProfileCreationRequest;
import com.duevops.profile.dto.response.UserProfileResponse;
import com.duevops.profile.entity.UserProfiles;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfiles toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfiles userProfiles);
}
