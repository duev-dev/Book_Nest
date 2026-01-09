package com.duevops.gateway.configuration;

import com.duevops.gateway.dto.ApiResponse;
import com.duevops.gateway.repository.httpClient.IdentityClient;
import com.duevops.gateway.service.IdentityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerResponse;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationFilter implements GlobalFilter, Ordered {
    IdentityService identityService;
    ObjectMapper objectMapper;
    @NonFinal
    private String[] publicEndpoints =  {"/identity/auth/token",
                                        "/identity/auth/introspect"};

    @Value("${app.api-prefix}")
    @NonFinal
    private String prefix;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Enter authentication filter....");
        // Get token form authorization header

        if ( isPublicEndpoint(exchange.getRequest())){
             return chain.filter(exchange);
        }
            List<String> authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION);
            if (CollectionUtils.isEmpty(authHeader)) {
                return unauthenticated(exchange.getResponse());
            }
            String token = authHeader.getFirst().replace("Bearer ", "");
            log.info("Authentication Token: {} " + token);
        // Verify token
         return identityService.introspect(token).flatMap( identityIntrospectResponseApiResponse -> {
            if ( identityIntrospectResponseApiResponse.getResult().isValid()){
                return chain.filter(exchange);
            }
            else  {
                return unauthenticated(exchange.getResponse());
            }
         }).onErrorResume(throwable -> unauthenticated(exchange.getResponse()));
        // Delegate identity service

    }
    private boolean isPublicEndpoint(ServerHttpRequest request) {
         return Arrays.stream(publicEndpoints).anyMatch(endpoint ->
                 request.getURI().getPath().matches(prefix + endpoint));

    }

    @Override
    public int getOrder() {
        return -1;
    }
    Mono<Void> unauthenticated(ServerHttpResponse response){
        ApiResponse<?> apiResponse = ApiResponse.builder()
                .code(1401)
                .message("Unauthenticated")
                .build();
        String body = null ;
        try{
             body = objectMapper.writeValueAsString(apiResponse);
        }catch (JsonProcessingException e){
            throw  new RuntimeException(e);
        }
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return response.writeWith
                (Mono.just(response.bufferFactory().wrap(body.getBytes())));// dataBuffer
    }
}
