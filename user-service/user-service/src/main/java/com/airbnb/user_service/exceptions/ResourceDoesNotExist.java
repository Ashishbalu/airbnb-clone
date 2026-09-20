package com.airbnb.user_service.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceDoesNotExist extends RuntimeException {
    public ResourceDoesNotExist(String message, HttpStatus status) {
        super(message, status.NOT_FOUND);
    }
}
