package com.badassuniverse.mapstoragebackend.exceptions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class ApiError {
    private Integer status;
    private String message;
    private Date timestamp;

    public ApiError(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
