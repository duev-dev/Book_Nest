package com.duevops.identity.repository.httpclient;

import java.awt.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.duevops.identity.configuration.AuthenticationRequestInterceptor;
import com.duevops.identity.dto.request.ProfileCreationRequest;
import com.duevops.identity.dto.response.UserProfileResponse;

@FeignClient(
        name = "profile-service",
        url = "${app.service.profile}",
        configuration = {AuthenticationRequestInterceptor.class})
public interface ProfileClient {
    @PostMapping(value = "/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
    UserProfileResponse createUserProfile(@RequestBody ProfileCreationRequest request);
}
