package com.duevops.profile.controller;

import com.duevops.profile.dto.request.ProfileCreationRequest;
import com.duevops.profile.dto.response.UserProfileResponse;
import com.duevops.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileController {
    UserProfileService  userProfileService;
    @PostMapping("/")
    public UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request) {
        return  userProfileService.createUserProfile(request);
    }
    @GetMapping("/{profiled}")
    public UserProfileResponse getUserProfile(@PathVariable String profiled){
        return  userProfileService.getUserProfileById(profiled);
    }
}
