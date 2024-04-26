package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dto.FacadeDto;
import com.badassuniverse.mapstoragebackend.model.Facade;
import com.badassuniverse.mapstoragebackend.model.Map;

public interface FacadeMapper {
    FacadeDto toDTO(Facade model);

    Facade toModel(FacadeDto dto, Map map);
}
