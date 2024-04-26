package com.badassuniverse.mapstoragebackend.mapper.impl;

import com.badassuniverse.mapstoragebackend.dto.FacadeDto;
import com.badassuniverse.mapstoragebackend.mapper.FacadeMapper;
import com.badassuniverse.mapstoragebackend.model.Direction;
import com.badassuniverse.mapstoragebackend.model.Facade;
import com.badassuniverse.mapstoragebackend.model.Map;
import org.springframework.stereotype.Component;

@Component
public class FacadeMapperImpl implements FacadeMapper {

    public FacadeDto toDTO(Facade model) {
        if (model == null) {
            return null;
        } else {
            return FacadeDto.builder()
                    .id(model.getId())
                    .name(model.getName())
                    .inGameFacadeId(model.getInGameFacadeId())
                    .mapOffsetX(model.getMapOffsetX())
                    .mapOffsetY(model.getMapOffsetY())
                    .floor(model.getFloor())
                    .rotation(model.getRotation().name())
                    .color(model.getColor())
                    .build();
        }
    }

    public Facade toModel(FacadeDto dto, Map map) {
        if (dto == null) {
            return null;
        } else {
            return Facade.builder()
                    .name(dto.getName())
                    .inGameFacadeId(dto.getInGameFacadeId())
                    .mapOffsetX(dto.getMapOffsetX())
                    .mapOffsetY(dto.getMapOffsetY())
                    .floor(dto.getFloor())
                    .rotation(Direction.valueOf(dto.getRotation()))
                    .color(dto.getColor())
                    .map(map)
                    .build();
        }
    }
}
