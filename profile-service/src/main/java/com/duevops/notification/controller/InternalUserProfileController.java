package com.duevops.notification.controller;

import org.springframework.web.bind.annotation.*;

import com.duevops.notification.dto.request.ProfileCreationRequest;
import com.duevops.notification.dto.response.UserProfileResponse;
import com.duevops.notification.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class InternalUserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/internal/users")
    public UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request) {
        return userProfileService.createUserProfile(request);
    }
}
