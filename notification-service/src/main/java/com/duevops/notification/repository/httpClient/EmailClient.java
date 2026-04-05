package com.duevops.notification.repository.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.duevops.notification.dto.request.EmailRequest;

@FeignClient(name = "email-Client", url = "https://api.sendgrid.com")
public interface EmailClient {
    @PostMapping(value = "/v3/mail/send", produces = MediaType.APPLICATION_JSON_VALUE)
    void sendEmail(@RequestHeader("Authorization") String auth, @RequestBody EmailRequest email);
}
