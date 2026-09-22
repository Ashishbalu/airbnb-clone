package com.airbnb.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                                auth
                                        .requestMatchers("/v1/auth/login-uri/**").permitAll()
                                        .anyRequest().authenticated()
                        )
                .oauth2Login(congfigurer ->
                        congfigurer.userInfoEndpoint(userInfoEndpointConfig ->{
                            userInfoEndpointConfig.oidcUserService();
                            userInfoEndpointConfig.userService();
                                })
                                .defaultSuccessUrl("/v1/auth/get-tokens", true)
                                .failureUrl("/v1/auth/error")
                        );


        return httpSecurity.build();
    }
}
