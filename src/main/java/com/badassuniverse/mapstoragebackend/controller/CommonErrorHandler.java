package com.badassuniverse.mapstoragebackend.controller;

import com.badassuniverse.mapstoragebackend.exceptions.ApiError;
import com.badassuniverse.mapstoragebackend.exceptions.UserCreatingException;
import com.badassuniverse.mapstoragebackend.exceptions.UserNotAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Slf4j
public class CommonErrorHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex) {
        log.error("Failed to process request due to exception", ex);
        return ResponseEntity.badRequest()
                .body(
                        new ApiError(
                                HttpStatus.BAD_REQUEST.value(),
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(UserNotAuthorizedException.class)
    public ResponseEntity<ApiError> handleUserNotAuthorizedException(UserNotAuthorizedException ex) {
        log.error("Failed to process request due to exception", ex);
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(
                        new ApiError(
                                HttpStatus.FORBIDDEN.value(),
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(UserCreatingException.class)
    public ResponseEntity<ApiError> handleUserCreatingException(UserCreatingException ex) {
        log.error("Failed to process request due to exception", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        new ApiError(
                                HttpStatus.BAD_REQUEST.value(),
                                ex.getMessage()
                        )
                );
    }
}
