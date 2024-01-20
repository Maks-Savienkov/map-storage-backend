package com.badassuniverse.mapstoragebackend.controller;

import com.badassuniverse.mapstoragebackend.dtos.UserDto;
import com.badassuniverse.mapstoragebackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") Integer id
    ) {
        service.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
