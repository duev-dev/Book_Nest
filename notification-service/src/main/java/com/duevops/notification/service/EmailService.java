package com.duevops.notification.service;

import com.duevops.notification.dto.request.EmailRequest;
import org.springframework.stereotype.Service;

import com.duevops.notification.repository.httpClient.EmailClient;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    public void sendEmail(EmailRequest email) {}
}
