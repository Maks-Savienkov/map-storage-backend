package com.badassuniverse.mapstoragebackend.controller;

import com.badassuniverse.mapstoragebackend.dto.MapDto;
import com.badassuniverse.mapstoragebackend.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/map")
public class MapController {
    private final MapService service;

    @GetMapping
    public List<MapDto> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/{user_id}")
    public List<MapDto> getAllByUserId(
            @PathVariable("user_id") Integer userId
    ) {
        return service.getAllByUserId(userId);
    }

    @GetMapping("/{id}")
    public MapDto getById(
            @PathVariable("id") Integer id
    ) {
        return service.getById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MapDto create(@RequestBody MapDto mapDto) {
        return service.create(mapDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
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
