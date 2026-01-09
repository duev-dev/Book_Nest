package com.duevops.profile.controller;

import com.duevops.profile.dto.request.ProfileCreationRequest;
import com.duevops.profile.dto.response.UserProfileResponse;
import com.duevops.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class InternalUserProfileController {
    UserProfileService  userProfileService;
    @PostMapping("/internal/users")
    public UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request) {
        return  userProfileService.createUserProfile(request);
    }
}
