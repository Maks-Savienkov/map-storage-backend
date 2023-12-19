package com.badassuniverse.mapstoragebackend.controller;

import com.badassuniverse.mapstoragebackend.dtos.MapDto;
import com.badassuniverse.mapstoragebackend.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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

    @Secured("ROLE_USER")
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MapDto create(@RequestBody MapDto mapDto) {
        return service.create(mapDto);
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
