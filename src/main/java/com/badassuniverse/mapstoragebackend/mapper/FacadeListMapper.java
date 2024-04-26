package com.badassuniverse.mapstoragebackend.mapper;

import com.badassuniverse.mapstoragebackend.dto.FacadeDto;
import com.badassuniverse.mapstoragebackend.model.Facade;
import com.badassuniverse.mapstoragebackend.model.Map;

import java.util.List;

public interface FacadeListMapper {
    List<Facade> toModelList(List<FacadeDto> dtoList, Map map);
    List<FacadeDto> toDTOList(List<Facade> modelList);
}
