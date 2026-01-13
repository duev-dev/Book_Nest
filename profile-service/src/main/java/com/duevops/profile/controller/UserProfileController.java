package com.duevops.profile.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.duevops.profile.dto.response.UserProfileResponse;
import com.duevops.profile.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileController {
    UserProfileService userProfileService;

    @GetMapping("/users")
    public List<UserProfileResponse> getAllProfile() {
        return userProfileService.getAllProfiles();
    }

    @GetMapping("/users/{profiled}")
    public UserProfileResponse getUserProfile(@PathVariable String profiled) {
        return userProfileService.getUserProfileById(profiled);
    }
}
