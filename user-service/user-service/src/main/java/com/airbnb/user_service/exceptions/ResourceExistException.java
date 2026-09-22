package com.airbnb.user_service.exceptions;

import org.springframework.http.HttpStatus;

public class ResourceExistException extends ApiException {
    public ResourceExistException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
