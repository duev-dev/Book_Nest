package com.duevops.profile.service;

import com.duevops.profile.dto.request.ProfileCreationRequest;
import com.duevops.profile.dto.response.UserProfileResponse;
import com.duevops.profile.entity.UserProfiles;
import com.duevops.profile.mapper.UserProfileMapper;
import com.duevops.profile.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository ;
    UserProfileMapper userProfileMapper ;
    public UserProfileResponse createUserProfile(ProfileCreationRequest request){
        UserProfiles userProfiles = userProfileMapper.toUserProfile(request) ;
        userProfiles = userProfileRepository.save(userProfiles) ;
        return userProfileMapper.toUserProfileResponse(userProfiles) ;

    }
    public UserProfileResponse getUserProfileById(String id){
        UserProfiles userProfiles = userProfileRepository.findById(id).orElseThrow( () -> new RuntimeException("UserProfile not found") ) ;
        return userProfileMapper.toUserProfileResponse(userProfiles) ;
    }
    public List<UserProfileResponse> getAllProfiles() {
        var profiles = userProfileRepository.findAll();

        return profiles.stream().map(userProfileMapper::toUserProfileResponse).toList();
    }
}
