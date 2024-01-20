package com.badassuniverse.mapstoragebackend.exceptions;

public class UserNotAuthorizedException extends AppException {
    public UserNotAuthorizedException(String message) {
        super(message);
    }
}
