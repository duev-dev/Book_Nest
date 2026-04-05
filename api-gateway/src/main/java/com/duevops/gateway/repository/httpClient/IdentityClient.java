package com.duevops.gateway.repository.httpClient;

import com.duevops.gateway.dto.ApiResponse;
import com.duevops.gateway.dto.request.IdentityIntrospectRequest;
import com.duevops.gateway.dto.response.IdentityIntrospectResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;
public interface IdentityClient {
    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IdentityIntrospectResponse>> introspect(@RequestBody IdentityIntrospectRequest request);
}
