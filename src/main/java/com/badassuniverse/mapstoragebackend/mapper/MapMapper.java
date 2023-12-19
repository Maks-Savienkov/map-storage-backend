package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dtos.MapDto;
import com.badassuniverse.mapstoragebackend.model.Map;

public interface MapMapper {
    MapDto toDTO(Map model);

    Map toModel(MapDto dto);
}
