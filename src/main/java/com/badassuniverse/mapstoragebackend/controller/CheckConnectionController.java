package com.badassuniverse.mapstoragebackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/check")
public class CheckConnectionController {
    @GetMapping
    public ResponseEntity<Void> checkConnection() {
        System.out.println("check");
        return ResponseEntity
                .ok()
                .build();
    }
}
