package com.badassuniverse.mapstoragebackend.controller;

import com.badassuniverse.mapstoragebackend.dtos.JwtRequest;
import com.badassuniverse.mapstoragebackend.dtos.JwtResponse;
import com.badassuniverse.mapstoragebackend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public ResponseEntity<JwtResponse> createAuthToken(
            @RequestBody JwtRequest request
    ) {
        return ResponseEntity.ok(authService.createAuthToken(request));
    }
}
