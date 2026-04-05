package com.duevops.gateway.service;

import com.duevops.gateway.dto.ApiResponse;
import com.duevops.gateway.dto.request.IdentityIntrospectRequest;
import com.duevops.gateway.dto.response.IdentityIntrospectResponse;
import com.duevops.gateway.repository.httpClient.IdentityClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class IdentityService {
    IdentityClient identityClient;
    public Mono<ApiResponse<IdentityIntrospectResponse>> introspect (String token) {
    return identityClient.introspect(IdentityIntrospectRequest
            .builder()
            .token(token)
            .build());
    }
}
