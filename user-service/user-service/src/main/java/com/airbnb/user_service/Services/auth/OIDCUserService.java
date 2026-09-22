package com.airbnb.user_service.Services.auth;

import org.jspecify.annotations.Nullable;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class OIDCUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final DefaultOAuth2UserService oAuth2UserService = new DefaultOAuth2UserService();
    @Override
    public @Nullable OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        return oAuth2UserService.loadUser(userRequest);
    }
}
