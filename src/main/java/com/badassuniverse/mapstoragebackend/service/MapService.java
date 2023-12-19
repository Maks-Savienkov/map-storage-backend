package com.badassuniverse.mapstoragebackend.service;

import com.badassuniverse.mapstoragebackend.controller.MapController;
import com.badassuniverse.mapstoragebackend.dtos.MapDto;
import com.badassuniverse.mapstoragebackend.mapper.MapMapper;
import com.badassuniverse.mapstoragebackend.model.Map;
import com.badassuniverse.mapstoragebackend.repo.MapRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MapService {
    private final MapRepository repository;
    private final MapMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(MapController.class);

    public List<MapDto> getAll() {
        return ((List<Map>) repository.findAll()).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public MapDto create(MapDto mapDto) {
        Map map = mapper.toModel(mapDto);
        repository.save(map);
        return mapDto;
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public MapDto getById(Integer id) {
        return mapper.toDTO(repository.findById(id).orElse(null));
    }

    public List<MapDto> getAllByUserId(Integer userId) {
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
