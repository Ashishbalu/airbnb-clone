package com.airbnb.user_service.exceptions;

import com.airbnb.user_service.payload.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExcceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExcceptionHandler.class);

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ApiResponse<Void>> handleApiException(ApiException exception){
        return ResponseEntity
                .status(exception.getStatus())
                .body(ApiResponse.error("ApiException"));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleServerErrors(Exception ex){
        logger.error(ex.getMessage(), ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("internal server error"));
    }
}
