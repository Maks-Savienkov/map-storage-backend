package com.badassuniverse.mapstoragebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private Boolean active;
}
