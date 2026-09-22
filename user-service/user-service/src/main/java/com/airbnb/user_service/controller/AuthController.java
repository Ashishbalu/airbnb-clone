package com.airbnb.user_service.controller;

import com.airbnb.user_service.exceptions.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ClientRegistrationRepository clientRegistrationRepository;

    @GetMapping("/login-uri/{provider}")
    public RedirectView login(@PathVariable String provider){
        ClientRegistration clientRegistration =
                clientRegistrationRepository.findByRegistrationId(provider);
        if (clientRegistration == null)
            throw new ApiException("invalid provider" + provider, HttpStatus.BAD_REQUEST);
        return new RedirectView("/oauth2/authorization" + provider);
    }
}
